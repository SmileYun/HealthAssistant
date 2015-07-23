package com.dongshi.healthassisant.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class PersonLayout extends ViewGroup implements OnClickListener {

	private ListView mListView;

	public PersonLayout(Context context) {
		super(context);
	}

	public PersonLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public PersonLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public void onWindowFocusChanged(boolean hasWindowFocus) {
		super.onWindowFocusChanged(hasWindowFocus);
		getChildAt(0).setOnClickListener(this);
	}

	@Override
	protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
		// View account = getChildAt(0);
		// account.layout(0, 0, getWidth(), account.getMeasuredHeight());
		//
		// View detail = getChildAt(1);
		// detail.layout(0, account.getMeasuredHeight(), getWidth(),
		// detail.getMeasuredHeight()+account.getMeasuredHeight());
		//
		// View lv = getChildAt(2);
		// lv.layout(0, detail.getMeasuredHeight()+account.getMeasuredHeight(),
		// getWidth(), getHeight() - detail.getMeasuredHeight() +
		// account.getMeasuredHeight());
		//
		int mTotalHeight = 0;
		int childCount = getChildCount();
		for (int i = 0; i < childCount; i++) {
			View childView = getChildAt(i);
			if (childView.isShown()) {
				int measureHeight = childView.getMeasuredHeight();
				int measuredWidth = childView.getMeasuredWidth();

				childView.layout(left, mTotalHeight, measuredWidth, mTotalHeight + measureHeight);

				mTotalHeight += measureHeight;
			}
		}
	}
	
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		detailShowAHide();
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		final int w = MeasureSpec.getSize(widthMeasureSpec);
		final int h = MeasureSpec.getSize(heightMeasureSpec);
		setMeasuredDimension(w, h);
		measureChildren(widthMeasureSpec, heightMeasureSpec);

		// for(int x = 0 ; x < getChildCount() ; x++){
		// getChildAt(x).measure(widthMeasureSpec,
		// getChildAt(x).getLayoutParams().height);
		// }
	}

	int mDuration = 2000;
	boolean isShow = true;

	@Override
	public void onClick(View v) {
		detailShowAHide();
	}

	final void detailShowAHide() {
		if (isShow) {
			getChildAt(1).setVisibility(View.VISIBLE);
			isShow = false;
		} else {
			getChildAt(1).setVisibility(View.GONE);
			isShow = true;
		}
		invalidate();
		post(new Runnable() {

			@Override
			public void run() {
				int mTotalHeight = 0;// getChildAt(0).getMeasuredHeight();

				int childCount = getChildCount();

				for (int i = 0; i < childCount; i++) {
					View childView = getChildAt(i);

					if (childView.isShown()) {
						int measureHeight = childView.getMeasuredHeight();
						int measuredWidth = childView.getMeasuredWidth();

						childView.layout(0, mTotalHeight, measuredWidth, mTotalHeight + measureHeight);

						mTotalHeight += measureHeight;
					}

				}
				invalidate();
			}
		});
	}

}
