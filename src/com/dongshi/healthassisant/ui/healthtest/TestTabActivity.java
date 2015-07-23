package com.dongshi.healthassisant.ui.healthtest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.ui.BaseActivity_XJ;
import com.dongshi.healthassisant.util.SettingSP;
import com.dongshi.healthassisant.util.Tool;
import com.dongshi.healthassisant.widget.MyTabBarTextView;

public class TestTabActivity extends BaseActivity_XJ implements
		ViewPager.OnPageChangeListener {

	protected static final int CURSOR = 4;
	protected static final int GRAY_CURSOR = 3;
	protected static final int GREEN_CURSOR = 2;
	protected int addCount = 0;
	protected List<Question> allBaseQuestions;
	protected Map<String, Question> allChildQuestions;
	protected Button btLeft;
	protected Button btRight;
	protected String cardId;
	protected int finishCount = 0;
	protected boolean hasScroll = false;
	int lastPosition = -1;
	protected List<Map<String, String>> listAnswers = new ArrayList();
	protected LinkedList<BaseTestFragment> mFragments = new LinkedList();
	protected int mPreSelectItem = 0;
	protected ArrayList<String> mTabItems = new ArrayList();
	protected ViewGroup mViewGroup;
	protected ViewPager mViewPager;
	protected int percent = 0;
	protected String qid = "";
	protected int quantity = 0;

	private Runnable runnable = new Runnable() {
		public void run() {
			TestTabActivity.this.mViewPager
					.setCurrentItem(TestTabActivity.this.lastPosition);
			Tool.Toast(TestTabActivity.this.getApplication(), "已自动跳到上次未答完的题目");
		}
	};

	protected int screenWidth = 480;
	protected String testId = "";
	protected MyFragmentStatePagerAdapter viewpageAdapter;

	private int getTabColor(int paramInt) {
		if ("0".equals(((Question) this.allBaseQuestions.get(paramInt))
				.getStates()))
			return -7829368;
		if ("1".equals(((Question) this.allBaseQuestions.get(paramInt))
				.getStates()))
			return -65536;
		if ("2".equals(((Question) this.allBaseQuestions.get(paramInt))
				.getStates()))
			return getResources().getColor(R.color.green);
		return 0;
	}

	protected void buttonChangeMethod(int paramInt) {
		if (paramInt == 0) {
			this.btLeft.setVisibility(View.INVISIBLE);
		} else {
			this.btLeft.setVisibility(View.VISIBLE);
		}

		if (paramInt == -1 + this.quantity) {
			this.btRight.setText("提交");
		} else {
			this.btRight.setText("下一题");
		}
	}

	protected void exitAndSave() {
//		if (this.hasScroll) {
//			getSaveAnswerUseData();
//			//uploadAnswerToService("0");
//			return;
//		}
		finish();
	}

	protected void getSaveAnswerUseData() {
		saveAnswerAt();
		this.listAnswers = TestUtil.getAllAnswer(this.allBaseQuestions,
				this.allChildQuestions);
		this.finishCount = this.quantity;
		for (int i = 0;i<this.quantity; i++) {
			 
			if (!"2".equals(((Question) this.allBaseQuestions.get(i))
					.getStates()))
				this.finishCount = (-1 + this.finishCount);
		}
		this.percent = (100 * this.finishCount / this.quantity);
	}

	protected void getServiceData() {
		TestTabActivity.this.tvTitle.setText("抑郁自评量表测试(SDS)");
		TestTabActivity.this.allChildQuestions = null;
		allBaseQuestions=new ArrayList<Question>();
		List<Option> optionlist = new ArrayList<Option>();
		Option option = new Option();
		option.setOptionContent("没有或很少时间。");
		optionlist.add(option);
		option = new Option();
		option.setOptionContent("小部分时间。");
		optionlist.add(option);
		option = new Option();
		option.setOptionContent("相当多时间。");
		optionlist.add(option);

		option = new Option();
		option.setOptionContent("绝大部分或全部时间。");
		optionlist.add(option);
		
		Question question = new Question(); 

		question.setInputType("radio");
		question.setOrderCode(1);
		question.setTitle("我觉得闷闷不乐，情绪低沉。"); 
		question.setOptions(optionlist);
		allBaseQuestions.add(question);
		
		 
	    question = new Question(); 

		question.setInputType("radio");
		question.setOrderCode(2);
		question.setTitle("我觉得一天中早晨最好。");
		question.setOptions(optionlist);
		allBaseQuestions.add(question);
		
	 
	    question = new Question(); 
		question.setInputType("radio");
		question.setOrderCode(3);
		question.setTitle("我一阵阵哭出来或觉得想哭。");
		question.setOptions(optionlist);
		allBaseQuestions.add(question);
		
		question = new Question(); 
		question.setInputType("radio");
		question.setOrderCode(4);
		question.setTitle("我晚上睡眠不好。");
		question.setOptions(optionlist);
		allBaseQuestions.add(question);
		
		question = new Question(); 
		question.setInputType("radio");
		question.setOrderCode(5);
		question.setTitle("我吃得跟平常一样多。");
		question.setOptions(optionlist);
		allBaseQuestions.add(question);
		
		question = new Question(); 
		question.setInputType("radio");
		question.setOrderCode(6);
		question.setTitle("我与异性密切接触时和以往一样感到愉快。");
		question.setOptions(optionlist);
		allBaseQuestions.add(question);
		
		question = new Question(); 
		question.setInputType("radio");
		question.setOrderCode(7);
		question.setTitle("我发现我的体重在下降。");
		question.setOptions(optionlist);
		allBaseQuestions.add(question);
		
		question = new Question(); 
		question.setInputType("radio");
		question.setOrderCode(8);
		question.setTitle("我有便秘的苦恼。");
		question.setOptions(optionlist);
		allBaseQuestions.add(question);
		
		question = new Question(); 
		question.setInputType("radio");
		question.setOrderCode(9);
		question.setTitle("我心跳比平常快。");
		question.setOptions(optionlist);
		allBaseQuestions.add(question);
		
		question = new Question(); 
		question.setInputType("radio");
		question.setOrderCode(10);
		question.setTitle("我无缘无故地感到疲乏。");
		question.setOptions(optionlist);
		allBaseQuestions.add(question);
		
		
		question = new Question(); 

		question.setInputType("radio");
		question.setOrderCode(11);
		question.setTitle("我的头脑跟平常一样清楚。"); 
		question.setOptions(optionlist);
		allBaseQuestions.add(question);
		
		 
	    question = new Question(); 

		question.setInputType("radio");
		question.setOrderCode(12);
		question.setTitle("我觉得经常做的事情并没有困难。");
		question.setOptions(optionlist);
		allBaseQuestions.add(question);
		
	 
	    question = new Question(); 
		question.setInputType("radio");
		question.setOrderCode(13);
		question.setTitle("我觉得不安而平静不下来。");
		question.setOptions(optionlist);
		allBaseQuestions.add(question);
		
		question = new Question(); 
		question.setInputType("radio");
		question.setOrderCode(14);
		question.setTitle("我对将来抱有希望。");
		question.setOptions(optionlist);
		allBaseQuestions.add(question);
		
		question = new Question(); 
		question.setInputType("radio");
		question.setOrderCode(15);
		question.setTitle("我比平常容易生气激动。");
		question.setOptions(optionlist);
		allBaseQuestions.add(question);
		
		question = new Question(); 
		question.setInputType("radio");
		question.setOrderCode(16);
		question.setTitle("我觉得作出决定是容易的。");
		question.setOptions(optionlist);
		allBaseQuestions.add(question);
		
		question = new Question(); 
		question.setInputType("radio");
		question.setOrderCode(17);
		question.setTitle("我觉得自已是个有用的人，有人需要我。");
		question.setOptions(optionlist);
		allBaseQuestions.add(question);
		
		question = new Question(); 
		question.setInputType("radio");
		question.setOrderCode(18);
		question.setTitle("我的生活过得很有意思。");
		question.setOptions(optionlist);
		allBaseQuestions.add(question);
		
		question = new Question(); 
		question.setInputType("radio");
		question.setOrderCode(19);
		question.setTitle("我认为如果我死了，别人会生活得好些。");
		question.setOptions(optionlist);
		allBaseQuestions.add(question);
		
		question = new Question(); 
		question.setInputType("radio");
		question.setOrderCode(20);
		question.setTitle("平常感兴趣的事我仍然照样感兴趣。");
		question.setOptions(optionlist);
		allBaseQuestions.add(question);
		
		
		
		TestTabActivity.this.quantity = TestTabActivity.this.allBaseQuestions
				.size();
		TestTabActivity.this.initLayout();

		 
	}

	protected void initLayout() {

		 
		for (int i = 0; i < this.allBaseQuestions.size(); i++) {
			String str1 = String.valueOf(i + 1);
			this.mTabItems.add(str1);
			Question localQuestion = (Question) this.allBaseQuestions.get(i);
			String str2 = localQuestion.getInputType();
			if ("radio".equals(str2))
				this.mFragments.add(new SingleChoiceFragment(localQuestion,str1));
			// else if ("checkbox".equals(str2))
			// this.mFragments.add(new MultipleChoiceFragment(localQuestion,
			// this.allChildQuestions, str1));
			// else if ("text".equals(str2))
			// this.mFragments.add(new CompletionFragment(localQuestion,
			// this.allChildQuestions, str1));
			if ((!"2".equals(localQuestion.getStates()))
					&& (this.lastPosition == -1))
				this.lastPosition = i;
		}
		
		initLeftRightButton();
		initTabbar();
		initViewPager();
		
		if (this.lastPosition > 0)
			new Handler().postDelayed(this.runnable, 0L);

	}

	protected void initLeftRightButton() {
		this.btLeft = ((Button) findViewById(R.id.bt_back));
		this.btRight = ((Button) findViewById(R.id.bt_next));
		this.btRight.setVisibility(View.VISIBLE);
		this.btRight.setText("下一题");
		this.btLeft.setOnClickListener(this);
		this.btRight.setOnClickListener(this);
	}

	protected void initTabbar() {
		this.mViewGroup = ((ViewGroup) findViewById(R.id.ll_tabtop));

		if (0 >= this.mTabItems.size())
			return;
		for (int i = 0; i < this.mTabItems.size(); i++) {
			MyTabBarTextView localMyTabBarTextView = new MyTabBarTextView(this);
			localMyTabBarTextView
					.setLayoutParams(new LinearLayout.LayoutParams(
							this.screenWidth / 7, -1));
			localMyTabBarTextView.setText((CharSequence) this.mTabItems.get(i));
			localMyTabBarTextView.setOnClickListener(this);
			if (i == 0) {
				localMyTabBarTextView.setTextColor(getResources().getColor(
						R.color.orange));
				localMyTabBarTextView.setLineState(4);
				localMyTabBarTextView.setTextSize(20.0F);
				localMyTabBarTextView.setTypeface(Typeface.defaultFromStyle(1));
			} else {
				localMyTabBarTextView.setLineState(3);
				localMyTabBarTextView.setTextSize(16.0F);
				localMyTabBarTextView.setTextColor(getTabColor(i));
				localMyTabBarTextView.setTypeface(Typeface.defaultFromStyle(0));
			}
			this.mViewGroup.addView(localMyTabBarTextView);

		}
	}

	protected void initViewPager() {
		this.mViewPager = ((ViewPager) findViewById(R.id.vp_tabtop));
		this.viewpageAdapter = new MyFragmentStatePagerAdapter(
				getSupportFragmentManager(), this.mFragments);
		this.mViewPager.setAdapter(this.viewpageAdapter);
		this.mViewPager.setOnPageChangeListener(this);
	}

	public void moveTitleLabel(int clickindex) {
		int sumwidth = this.mViewGroup.getMeasuredWidth();
		int preclicksumwidth = 0;
		int k = this.screenWidth / 7;
		int m = 0;
		int n;
		int i2;

		for (n = 0; n < this.mViewGroup.getChildCount(); n++) {
			MyTabBarTextView localMyTabBarTextView = (MyTabBarTextView) this.mViewGroup
					.getChildAt(n);
			int i1 = localMyTabBarTextView.getMeasuredWidth();
			if (n == clickindex) {
				localMyTabBarTextView.setTextColor(getResources().getColor(
						R.color.orange));
				localMyTabBarTextView.setLineState(4);
				localMyTabBarTextView.setTextSize(20.0F);
				localMyTabBarTextView.setTypeface(Typeface.defaultFromStyle(1));
			} else if (n < clickindex) {
				preclicksumwidth += i1;
				localMyTabBarTextView.setText((CharSequence) this.mTabItems
						.get(n));
				localMyTabBarTextView.setLineState(2);
				localMyTabBarTextView.setTextSize(16.0F);
				localMyTabBarTextView.setTextColor(getTabColor(n));
				localMyTabBarTextView.setTypeface(Typeface.defaultFromStyle(0));
			} else if (n > clickindex) {
				localMyTabBarTextView.setText((CharSequence) this.mTabItems
						.get(n));
				localMyTabBarTextView.setLineState(3);
				localMyTabBarTextView.setTextSize(16.0F);
				localMyTabBarTextView.setTextColor(getTabColor(n));
				localMyTabBarTextView.setTypeface(Typeface.defaultFromStyle(0));
			}
		}

		if (clickindex > 0) {
			if (clickindex == -1 + this.mViewGroup.getChildCount())
				m = 0;
		}

		if (sumwidth - preclicksumwidth < this.screenWidth / 2)
			m = this.screenWidth / 7;
		i2 = preclicksumwidth - (this.screenWidth - k) / 2;
		if (this.mPreSelectItem >= clickindex)
			((HorizontalScrollView) this.mViewGroup.getParent())
					.scrollTo(i2, 0);
		if (m + (preclicksumwidth + k) >= this.screenWidth / 2)
			((HorizontalScrollView) this.mViewGroup.getParent())
					.scrollTo(i2, 0);

	}

	public void onClick(View paramView) {
		switch (paramView.getId()) {
		default:
			if (this.mViewGroup == null)
				break;
			for (int i = 0;i<this.mViewGroup.getChildCount() ; i++)
		    {
				 if (paramView == this.mViewGroup.getChildAt(i))
			      {
			        this.mViewPager.setCurrentItem(i);
			        return;
			      }
		    }
		case R.id.btnBack:
			exitAndSave();
			break;
		case R.id.bt_back:
			this.mViewPager.setCurrentItem(-1 + this.mPreSelectItem);
			break;
		case R.id.bt_next:
			String str = Tool.getTvString(this.btRight);
			if ("下一题".equals(str)) {
				this.mViewPager.setCurrentItem(1 + this.mPreSelectItem);
				break;
			}
			if (!"提交".equals(str))
				break;
			getSaveAnswerUseData();
			if (this.finishCount == this.quantity) {
				//uploadAnswerToService("1");
				saveAnswerSucessDialog("题目全部答完,已为您自动保存,是否现在提交问卷?");
				break;
			}
			submitTestNotFinishDialog();
			break;
		}
		// for (int i = 0;; i++) {
		// if (i >= this.mViewGroup.getChildCount()) {
		// return;
		// exitAndSave();
		// break;
		// this.mViewPager.setCurrentItem(-1 + this.mPreSelectItem);
		// break;
		// String str = Tool.getTvString(this.btRight);
		// if ("下一题".equals(str)) {
		// this.mViewPager.setCurrentItem(1 + this.mPreSelectItem);
		// break;
		// }
		// if (!"提交".equals(str))
		// break;
		// getSaveAnswerUseData();
		// if (this.finishCount == this.quantity) {
		// uploadAnswerToService("1");
		// break;
		// }
		// submitTestNotFinishDialog();
		// break;
		// }
		// if (paramView == this.mViewGroup.getChildAt(i)) {
		// this.mViewPager.setCurrentItem(i);
		// return;
		// }
		// }
	}

	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.xj_healthtest_test_tabtop_activity);
		Intent localIntent = getIntent();
		this.cardId = localIntent.getStringExtra("cardId");
		this.qid = localIntent.getStringExtra("qid");
		String str = localIntent.getStringExtra("testPaperTempleId");
		if (Tool.isEmpty(str))
			str = "";
		this.testId = str;
		initTitle("");
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		this.screenWidth = dm.widthPixels;

		getServiceData();
	}

	public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent) {
		if ((paramInt == 4) && (paramKeyEvent.getAction() == 0)) {
			exitAndSave();
			return true;
		}
		return super.onKeyDown(paramInt, paramKeyEvent);
	}

	public void onPageScrollStateChanged(int paramInt) {
		saveAnswerAt();
	}

	public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {
	}

	public void onPageSelected(int paramInt) {
		moveTitleLabel(paramInt - this.addCount);
		buttonChangeMethod(paramInt);
		this.mPreSelectItem = paramInt;
		this.hasScroll = true;
	}

	protected void saveAnswerAt() {
		((BaseTestFragment) this.mFragments.get(this.mPreSelectItem))
				.savaAnswer();
	}

	protected void saveAnswerSucessDialog(String paramString) {
		LinearLayout localLinearLayout = (LinearLayout) getLayoutInflater()
				.inflate(R.layout.xj_dialog_save_answer, null);
		TextView localTextView1 = (TextView) localLinearLayout
				.findViewById(R.id.tv_dialog_title);
		TextView localTextView2 = (TextView) localLinearLayout
				.findViewById(R.id.tv_dialog_content);
		localTextView1.setText("保存成功");
		localTextView2.setText(paramString);
		AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
		localBuilder.setView(localLinearLayout);
		if (this.finishCount == this.quantity) {
			localBuilder.setNegativeButton("提交问卷",
					new DialogInterface.OnClickListener() {
						public void onClick(
								DialogInterface paramAnonymousDialogInterface,
								int paramAnonymousInt) {
							//TestTabActivity.this.uploadAnswerToService("1");
							//跳转到测试结果
							//HealthTestResult
							Intent localIntent = new Intent();
							localIntent.setClass(TestTabActivity.this, HealthTestResult.class);
					        startActivity(localIntent);
						}
					});
		}
		if (this.finishCount < this.quantity)
			localBuilder.setNegativeButton("继续答题", null);

		localBuilder.setPositiveButton("结束答题",
				new DialogInterface.OnClickListener() {
					public void onClick(
							DialogInterface paramAnonymousDialogInterface,
							int paramAnonymousInt) {
						TestTabActivity.this.finish();
					}
				});
		localBuilder.create().show();

	}

	protected void submitSucessDialog() {
		AlertDialog.Builder localBuilder = TishiDialog.ShowTishi(this, "提交成功!",
				"专家分析量表,一般需要3至5个工作日,请您耐心等待…");
		localBuilder.setPositiveButton("确定",
				new DialogInterface.OnClickListener() {
					public void onClick(
							DialogInterface paramAnonymousDialogInterface,
							int paramAnonymousInt) {
						TestTabActivity.this.finish();
					}
				});
		localBuilder.create().show();
	}

	protected void submitTestNotFinishDialog() {
		AlertDialog.Builder localBuilder = TishiDialog.ShowTishi(this, "温馨提示",
				"您还有" + (this.quantity - this.finishCount)
						+ "道题目没做完,暂时还不能提交医生分析");
		localBuilder.setNegativeButton("继续答题", null);
		localBuilder.setPositiveButton("保存退出",
				new DialogInterface.OnClickListener() {
					public void onClick(
							DialogInterface paramAnonymousDialogInterface,
							int paramAnonymousInt) {
						//TestTabActivity.this.uploadAnswerToService("-1");
						TestTabActivity.this.exitAndSave();
					}
				});
		localBuilder.create().show();
	}

	protected void uploadAnswerToService(final String paramString) {
//		if ((TestTabActivity.this.finishCount ==
//				 TestTabActivity.this.quantity) && ("0".equals(paramString)))
//				 {
//				 TestTabActivity.this.saveAnswerSucessDialog("题目全部答完,已为您自动保存,是否现在提交问卷?");
//				 return;
//				 }
//		
//		if ((TestTabActivity.this.finishCount <
//				 TestTabActivity.this.quantity) && ("0".equals(paramString)))
//				 {
//				 TestTabActivity.this.saveAnswerSucessDialog("还剩" +
//				 (TestTabActivity.this.quantity - TestTabActivity.this.finishCount) +
//				 "道题没做,已为您自动保存");
//				 return;
//				 }
		
		// if ("0".equals(paramString));
		// for (String str = "正在保存答案请稍候…"; ; str = "正在提交问卷请稍候…")
		// {
		// final MyRoundProgressDialog localMyRoundProgressDialog = new
		// MyRoundProgressDialog(this, str);
		// localMyRoundProgressDialog.show();
		// AjaxParams localAjaxParams = new AjaxParams();
		// localAjaxParams.put("testPaperTempleId", this.testId);
		// localAjaxParams.put("qid", this.qid);
		// localAjaxParams.put("cardId", this.cardId);
		// localAjaxParams.put("percent", this.percent);
		// localAjaxParams.put("isOver", paramString);
		// localAjaxParams.put("data", JsonUtils.toJson(this.listAnswers));
		// Business.httpPostNoDialog(this, getString(2131099696),
		// localAjaxParams, new Success()
		// {
		// public void onSuccess(String paramAnonymousString1, String
		// paramAnonymousString2, String paramAnonymousString3)
		// {
		// localMyRoundProgressDialog.dismiss();
		// if ("0".endsWith(paramAnonymousString1))
		// {
		// if ((TestTabActivity.this.finishCount ==
		// TestTabActivity.this.quantity) && ("1".equals(paramString)))
		// TestTabActivity.this.submitSucessDialog();
		// do
		// {
		// return;
		// if ((TestTabActivity.this.finishCount ==
		// TestTabActivity.this.quantity) && ("0".equals(paramString)))
		// {
		// TestTabActivity.this.saveAnswerSucessDialog("题目全部答完,已为您自动保存,是否现在提交问卷?");
		// return;
		// }
		// if ((TestTabActivity.this.finishCount <
		// TestTabActivity.this.quantity) && ("0".equals(paramString)))
		// {
		// TestTabActivity.this.saveAnswerSucessDialog("还剩" +
		// (TestTabActivity.this.quantity - TestTabActivity.this.finishCount) +
		// "道题没做,已为您自动保存");
		// return;
		// }
		// }
		// while ((TestTabActivity.this.finishCount >=
		// TestTabActivity.this.quantity) || (!"-1".equals(paramString)));
		// TestTabActivity.this.finish();
		// return;
		// }
		// Tool.Toast(TestTabActivity.this.getApplicationContext(),
		// paramAnonymousString2);
		// System.out.println(paramAnonymousString2);
		// }
		// });
		// return;
		// }
	}

}
