package com.dongshi.healthassisant.widget;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.util.AnimatorBuilder;
/**
 * 
 * @author YUN
 */
public class RefreshListView extends ListView implements OnScrollListener {

	private static final String TAG_STRING = "RefreshListView";
	private Context mContext;
	private LayoutInflater mInflater;
	private RefreshListener mRefreshListener;
	/** 返回的刷新结果 */
	private Object mRefreshObject;

	public RefreshListView(Context context) {
		this(context, null);
	}

	public RefreshListView(Context context, AttributeSet attr) {
		super(context, attr);
		mContext = context;
		mInflater = LayoutInflater.from(mContext);
		init();
	}

	private LinearLayout mHeaderLinearLayout;
	private LinearLayout mFooterLinearLayout;
	private ImageView headerArrow;
	private TextView headerTime;
	private TextView headerInfo;
	private ProgressBar headerProgressBar;
	private TextView footerLoadMore;
	private ProgressBar footerProgressBar;
	private int mHeaderHeight;
	private SimpleDateFormat mSimpleDateFormat;
	private float mDownY = 0;
	private float mMoveY = 0;
	private int mCurrScrollState;
	private final static int NONE_PULL_REFRESH = 0; // 正常状态
	private final static int ENTER_PULL_REFRESH = 1; // 进入下拉刷新状态
	private final static int OVER_PULL_REFRESH = 2; // 进入松手刷新状态
	private final static int EXIT_PULL_REFRESH = 3; // 松手后反弹和加载状态
	private int mPullRefreshState = 0; // 记录刷新状态
	private int mFirstVisibleItem;
	private RotateAnimation mRotationAnimUp; // 顺180
	private RotateAnimation mRotationAnimDown; // 逆180

	private final static int REFRESH_BACKING = 0; // 反弹中
	private final static int REFRESH_BACED = 1; // 达到刷新界限，反弹结束后
	private final static int REFRESH_RETURN = 2; // 没有达到刷新界限，返回
	private final static int REFRESH_DONE = 3; // 加载数据结束

	private void init() {
		mHeaderLinearLayout = (LinearLayout) mInflater.inflate(R.layout.player_list_header, null);
		headerArrow = (ImageView) mHeaderLinearLayout.findViewById(R.id.header_arrow);
		headerArrow.setImageBitmap(getOptsBitmap(R.drawable.refresh_list_pull_down));
		headerArrow.setVisibility(View.VISIBLE);
		headerTime = (TextView) mHeaderLinearLayout.findViewById(R.id.list_header_time);
		headerInfo = (TextView) mHeaderLinearLayout.findViewById(R.id.list_header_info);
		headerProgressBar = (ProgressBar) mHeaderLinearLayout.findViewById(R.id.header_progressBar);
		addHeaderView(mHeaderLinearLayout);

		mFooterLinearLayout = (LinearLayout) mInflater.inflate(R.layout.player_list_footer, null);
		// addFooterView(mFooterLinearLayout);
		footerLoadMore = (TextView) mFooterLinearLayout.findViewById(R.id.refresh_list_footer_load_more);
		footerProgressBar = (ProgressBar) mFooterLinearLayout.findViewById(R.id.refresh_list_footer_progressbar);
		mFooterLinearLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if ("点击加载".equals(footerLoadMore.getText())) {
					footerLoadMore.setText("正在加载..");
					footerProgressBar.setVisibility(View.VISIBLE);
					if (mRefreshListener != null) {
						mRefreshListener.more();
					}
				}
			}
		});

//		this.setSelection(1);
		this.setOnScrollListener(this);
		measureView(mHeaderLinearLayout);// == mHeaderLinearLayout.measure(0, 0);

		mHeaderHeight = mHeaderLinearLayout.getMeasuredHeight();

		mSimpleDateFormat = new SimpleDateFormat("MM-dd hh:mm");
		headerTime.setText("更新时间为: " + mSimpleDateFormat.format(new Date()));
		mRotationAnimUp = AnimatorBuilder.createRotationAnimator(0f, 180f, AnimatorBuilder.RELATIVE_TO_SELF, 0.5f, AnimatorBuilder.RELATIVE_TO_SELF, 0.5f);
		mRotationAnimDown = AnimatorBuilder.createRotationAnimator(180f, 0f, AnimatorBuilder.RELATIVE_TO_SELF, 0.5f, AnimatorBuilder.RELATIVE_TO_SELF, 0.5f);
		/**
		 * SCROLLBARS_INSIDE_OVERLAY SCROLLBARS_INSIDE_INSET
		 * SCROLLBARS_OUTSIDE_OVERLAY SCROLLBARS_OUTSIDE_INSET
		 */
		// setScrollBarStyle(SCROLLBARS_OUTSIDE_OVERLAY );
		setScrollbarFadingEnabled(true);
	}

	/** 获取优化位图 */
	private Bitmap getOptsBitmap(int resId) {
		InputStream _in = mContext.getResources().openRawResource(resId);
		BitmapFactory.Options _opts = new Options();
		_opts.inInputShareable = true;
		// _opts.inSampleSize = 2;
		_opts.inPurgeable = true;
		Bitmap _map = BitmapFactory.decodeStream(_in, null, _opts);
		return _map;
	}

	public interface RefreshListener {
		Object refreshing();

		void refreshed(Object obj);

		void more();
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {

		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			mDownY = ev.getY();
			break;

		case MotionEvent.ACTION_MOVE:
			mMoveY = ev.getY();
			 if(getAdapter() != null && mFirstVisibleItem == 0 && mMoveY - mDownY > 25 && !isScrolling ){
					addHeaderView(mHeaderLinearLayout);
					isScrolling = true;
			 }
//			 System.out.println("------"+(mMoveY - mDownY));	       //向下
			if (mCurrScrollState == ENTER_PULL_REFRESH && mMoveY - mDownY > 0) {
				if (((mMoveY - mDownY) / 4) < 111) {
					mHeaderLinearLayout.setPadding(mHeaderLinearLayout.getPaddingLeft(), (int) ((mMoveY - mDownY) / 4), mHeaderLinearLayout.getPaddingRight(),
							mHeaderLinearLayout.getPaddingBottom());
				} else {
					//mHeaderLinearLayout.setPadding(mHeaderLinearLayout.getPaddingLeft(), 111, mHeaderLinearLayout.getPaddingRight(), mHeaderLinearLayout.getPaddingBottom());
				}
			} else if(mCurrScrollState == ENTER_PULL_REFRESH && mMoveY - mDownY < 10){
				removeHeaderView();
				//setSelection(0);
				mCurrScrollState = NONE_PULL_REFRESH;
			}
			break;

		case MotionEvent.ACTION_UP:
			// 1. 设置header paddingTop = 0； 
			// 2. 隐藏headerView  
			if (mCurrScrollState == OVER_PULL_REFRESH || mCurrScrollState == ENTER_PULL_REFRESH) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						Message _msg;
						while (ENTER_PULL_REFRESH == mCurrScrollState && isHeadDisPlaying) {
							_msg = mHandler.obtainMessage();
							_msg.what = REFRESH_BACKING;
							_msg.sendToTarget();
							try {
								Thread.sleep(10);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						_msg = mHandler.obtainMessage();
						if (mPullRefreshState == OVER_PULL_REFRESH) {
							_msg.what = REFRESH_BACED;
						} else {
							_msg.what = REFRESH_RETURN;
						}
						_msg.sendToTarget();
					}
				}).start();
			}
			break;
		}
		return super.onTouchEvent(ev);
	}

	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case REFRESH_BACKING:// 反弹中
				if (NONE_PULL_REFRESH != mPullRefreshState) {
					mHeaderLinearLayout.setPadding(mHeaderLinearLayout.getPaddingLeft(),  (int) (mHeaderLinearLayout.getPaddingTop() * 0.75f), mHeaderLinearLayout.getPaddingRight(),
							mHeaderLinearLayout.getPaddingBottom());
				}
				showProgressBar();
				break;

			case REFRESH_BACED:// 达到刷新界限，反弹结束后,加载数据
				headerInfo.setText("正在加载...");
				rotateArrow(ROTATE_DOWN);
				showProgressBar();
				mPullRefreshState = EXIT_PULL_REFRESH;
				new Thread() {
					public void run() {
						if (mRefreshListener != null) {
							mRefreshObject = mRefreshListener.refreshing();
						}
						Message msg = mHandler.obtainMessage();
						msg.what = REFRESH_DONE;
						msg.sendToTarget();
					}
                }.start();
				break;

			case REFRESH_RETURN:// 没有达到刷新界限，返回
				headerInfo.setText("下拉刷新");
				rotateArrow(ROTATE_DOWN);
				showArrow();
//				mHeaderLinearLayout.setPadding(mHeaderLinearLayout.getPaddingLeft(), 0, mHeaderLinearLayout.getPaddingRight(), mHeaderLinearLayout.getPaddingBottom());
				mPullRefreshState = NONE_PULL_REFRESH;
				removeHeaderView();
				setSelection(0);
				break;

			case REFRESH_DONE:// 松手后， 加载数据结束
				headerInfo.setText("下拉刷新");
				headerTime.setText("更新时间为: " + mSimpleDateFormat.format(new Date()));
				rotateArrow(ROTATE_DOWN);
				showArrow();
//				HeaderLinearLayout.setPadding(mHeaderLinearLayout.getPaddingLeft(), 0, mHeaderLinearLayout.getPaddingRight(), mHeaderLinearLayout.getPaddingBottom());
				removeHeaderView();
				mPullRefreshState = NONE_PULL_REFRESH;
				setSelection(0);
				if (mRefreshListener != null) {
					mRefreshListener.refreshed(mRefreshObject);
				}
				break;
			}
		}
    };

	boolean isScrolling = false;
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
		if (totalItemCount > visibleItemCount) {
			showFooterView();
		}
		
		mFirstVisibleItem = firstVisibleItem;
		if (mCurrScrollState == SCROLL_STATE_TOUCH_SCROLL && firstVisibleItem == 0 && mHeaderLinearLayout.getBottom() >= 0 && mHeaderLinearLayout.getBottom() < mHeaderHeight) {
			// 进入且仅进入下拉刷新状态
			if (mPullRefreshState == NONE_PULL_REFRESH) {
				mPullRefreshState = ENTER_PULL_REFRESH;
			}
		} else if (mCurrScrollState == SCROLL_STATE_TOUCH_SCROLL && firstVisibleItem == 0 && mHeaderLinearLayout.getBottom() >= mHeaderHeight + 35) {
			// 下拉达到界限，进入松手刷新状态
			if (mPullRefreshState == ENTER_PULL_REFRESH || mPullRefreshState == NONE_PULL_REFRESH) {
				mPullRefreshState = OVER_PULL_REFRESH;
				// mDownY = mMoveY; // 为下拉1/3折扣效果记录开始位置
				headerInfo.setText("松手刷新");// 显示松手刷新
				rotateArrow(ROTATE_UP);
				showArrow();
			}
		} else if (mCurrScrollState == SCROLL_STATE_TOUCH_SCROLL && firstVisibleItem == 0 && mHeaderLinearLayout.getBottom() >= 0
				&& mHeaderLinearLayout.getBottom() < mHeaderHeight + 20) {
			if (mPullRefreshState == ENTER_PULL_REFRESH || mPullRefreshState == OVER_PULL_REFRESH) {
				mPullRefreshState = ENTER_PULL_REFRESH;
				headerInfo.setText("下拉刷新");// 显示下拉刷新
				rotateArrow(ROTATE_DOWN);
			}
//			if ( mHeaderLinearLayout.getBottom() < 2) {
//				setSelection(0);
//			}
		} else if (mCurrScrollState == SCROLL_STATE_TOUCH_SCROLL && firstVisibleItem != 0) {
			if (mPullRefreshState == ENTER_PULL_REFRESH || mPullRefreshState == OVER_PULL_REFRESH) {
				mPullRefreshState = NONE_PULL_REFRESH; // 停止刷新
			}
		} else if (mCurrScrollState == SCROLL_STATE_FLING && firstVisibleItem == 0) {
			// 飞滑状态，不能显示出header，也不能影响正常的飞滑,只在正常情况下才纠正位置
			if (mPullRefreshState == NONE_PULL_REFRESH) {
				//setSelection(1);
			}
		}
	}

	private static final int ROTATE_DOWN = 0;
	private static final int ROTATE_UP = 1;
	private boolean mIsArrowDown = true;

	/**
	 * 旋转箭头方向
	 * 
	 * @param orit
	 */
	private void rotateArrow(int orit) {
		switch (orit) {
		case ROTATE_DOWN:
			if (!mIsArrowDown) {
//				headerArrow.setAnimation(mRotationAnimDown);
//				mRotationAnimDown.start();
				mHeaderLinearLayout.setVisibility(View.VISIBLE);
//				addHeaderView(mHeaderLinearLayout);
				headerArrow.clearAnimation();
				headerArrow.startAnimation(mRotationAnimDown);
				mIsArrowDown = true;
				
			}
			break;
		case ROTATE_UP:
//			headerArrow.setAnimation(mRotationAnimUp);
//			mRotationAnimUp.start();
			mHeaderLinearLayout.setVisibility(View.VISIBLE);
//			addHeaderView(mHeaderLinearLayout);
			headerArrow.clearAnimation();
			headerArrow.startAnimation(mRotationAnimUp);
			mIsArrowDown = false;
			break;
		}
	}

	private void showArrow() {
		headerArrow.setVisibility(View.VISIBLE);
		headerProgressBar.setVisibility(View.GONE);
	}

	private void showProgressBar() {
		headerArrow.setAnimation(null);
		headerArrow.setVisibility(View.GONE);
		headerProgressBar.setVisibility(View.VISIBLE);
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		mCurrScrollState = scrollState;
	}

	@Override
	public void setAdapter(ListAdapter adapter) {
		super.setAdapter(adapter);
		if (adapter.getCount() == 0) {
			removeFootView();
			removeHeaderView();
		}
		
			removeHeaderView();
		//setSelection(1);
		setFastScrollEnabled(true);
		// setStackFromBottom(true); //设置 刷新后从底部开始
	}

	@SuppressWarnings("deprecation")
	private void measureView(View child) {
		ViewGroup.LayoutParams p = child.getLayoutParams();
		if (p == null) {
			p = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
		}

		int childWidthSpec = ViewGroup.getChildMeasureSpec(0, 0 + 0, p.width);
		int lpHeight = p.height;
		int childHeightSpec;
		if (lpHeight > 0) {
			childHeightSpec = MeasureSpec.makeMeasureSpec(lpHeight, MeasureSpec.EXACTLY);
		} else {
			childHeightSpec = MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
		}
		child.measure(childWidthSpec, childHeightSpec);
	}

	public void showFooterView() {
		if (getFooterViewsCount() == 0) {
			addFooterView(mFooterLinearLayout);
		}
	}

	public void loadMoreFinished() {
		footerProgressBar.setVisibility(View.GONE);
		footerLoadMore.setText("点击加载");
	}

	public void removeFootView() {
		footerProgressBar.setVisibility(View.GONE);
		footerLoadMore.setText("点击加载");
		if (mFooterLinearLayout != null) {
			removeFooterView(mFooterLinearLayout);
		}
	}

	public void removeHeaderView() {
		removeHeaderView(mHeaderLinearLayout);
		isScrolling = false;
		isHeadDisPlaying = false;
	}
	boolean isHeadDisPlaying = false;
	public void addHeaderView(){
		addHeaderView();
		mHeaderLinearLayout.scrollBy(0, 100);
		isHeadDisPlaying = true;
	}

	public void setOnRefreshListener(RefreshListener mRefreshListener) {
		this.mRefreshListener = mRefreshListener;
	}
}
