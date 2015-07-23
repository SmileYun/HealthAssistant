package com.dongshi.healthassisant.ui.smartexam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.ui.MyBaseActivity;
import com.dongshi.healthassisant.util.Rotate3dAnimation;

/**
 * 智能导诊
 * 
 * @author YUN
 */
public class ActSmartDiagnoise extends MyBaseActivity implements OnClickListener {
	private View mHeadView, mNeckView, mBreastView, mStomachView, mArmLefView, mArmRightView, mShengView, mLegView;
	private TextView mGender;
	private TextView titleName;
	private ImageView mBack;
	private Button mBtnTurn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_smart_diagnoise);
		initViewAndLinstner();
	}

	private void initViewAndLinstner() {
		mHeadView = findViewById(R.id.smart_diagnoise_head);
		mNeckView = findViewById(R.id.smart_diagnoise_neck);
		mStomachView = findViewById(R.id.smart_diagnoise_stomach);
		mBreastView = findViewById(R.id.smart_diagnoise_breast);
		mArmLefView = findViewById(R.id.smart_diagnoise_arm_left);
		mArmRightView = findViewById(R.id.smart_diagnoise_arm_right);
		mShengView = findViewById(R.id.smart_diagnoise_bird);
		mLegView = findViewById(R.id.smart_diagnoise_leg);
		mGender = (TextView) findViewById(R.id.smart_diagnoise_tGender);
		mBtnTurn = (Button) findViewById(R.id.smart_diagnoise_arm_right_btnturn);
		mHeadView.setOnClickListener(this);
		mNeckView.setOnClickListener(this);
		mBreastView.setOnClickListener(this);
		mStomachView.setOnClickListener(this);
		mArmLefView.setOnClickListener(this);
		mArmRightView.setOnClickListener(this);
		mShengView.setOnClickListener(this);
		mLegView.setOnClickListener(this);
		mGender.setOnClickListener(this);
		mBtnTurn.setOnClickListener(this);

		titleName = (TextView) findViewById(R.id.title_name);
		mBack = (ImageView) findViewById(R.id.more_return_btn);
		mBack.setOnClickListener(this);
		titleName.setText("智能导诊");

		// 旋转
		mImageView1 = (ImageView) findViewById(R.id.imageView1); //face
		mImageView2 = (ImageView) findViewById(R.id.imageView2);
		mContainer = findViewById(R.id.container);
		mStartAnimView = mImageView1;
		InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
	}

	@Override
	public void init() {

	}

	@Override
	public void refresh(Object... param) {

	}

	ImageView mImageView1 = null;
	ImageView mImageView2 = null;
	ImageView mStartAnimView = null;
	View mContainer = null;
	int mDuration = 500;
	float mCenterX = 0.0f;
	float mCenterY = 0.0f;
	float mDepthZ = 0.0f;
	int mIndex = 0;
	boolean isFront = true;

	@Override
	public void onClick(View v) {
		Intent i = new Intent(this, ActSmartDiagnoiseLocation.class);

		switch (v.getId()) {
		case R.id.smart_diagnoise_head:
			i.putExtra("location", ActSmartDiagnoiseLocation.smart_diagnoise_head);
			this.startActivity(i);
			break;

		case R.id.smart_diagnoise_neck:
			i.putExtra("location", ActSmartDiagnoiseLocation.smart_diagnoise_neck);
			this.startActivity(i);
			break;

		case R.id.smart_diagnoise_stomach:
			if (isFront) {
				i.putExtra("location", ActSmartDiagnoiseLocation.smart_diagnoise_stomach);
			}else {
				i.putExtra("location", ActSmartDiagnoiseLocation.smart_diagnoise_yao);
			}
			this.startActivity(i);
			break;

		case R.id.smart_diagnoise_breast:
			if (isFront) {
				i.putExtra("location", ActSmartDiagnoiseLocation.smart_diagnoise_breast);
			}else {
				i.putExtra("location", ActSmartDiagnoiseLocation.smart_diagnoise_back);
			}
			this.startActivity(i);
			break;

		case R.id.smart_diagnoise_arm_left:
			i.putExtra("location", ActSmartDiagnoiseLocation.smart_diagnoise_arm_left);
			this.startActivity(i);
			break;

		case R.id.smart_diagnoise_arm_right:
			i.putExtra("location", ActSmartDiagnoiseLocation.smart_diagnoise_arm_right);
			this.startActivity(i);
			break;

		case R.id.smart_diagnoise_bird:
			if (isFront) {
				i.putExtra("location", ActSmartDiagnoiseLocation.smart_diagnoise_bird);
			}else {
				i.putExtra("location", ActSmartDiagnoiseLocation.smart_diagnoise_ass);
			}
			this.startActivity(i);
			break;

		case R.id.smart_diagnoise_leg:
			i.putExtra("location", ActSmartDiagnoiseLocation.smart_diagnoise_leg);
			this.startActivity(i);
			break;

		case R.id.smart_diagnoise_tGender:
			// 性别切换
			break;
		case R.id.smart_diagnoise_arm_right_btnturn:
			mCenterX = mContainer.getWidth() / 2;
			mCenterY = mContainer.getHeight() / 2;

			getDepthZ();

			applyRotation(mStartAnimView, 0, 90);

			break;

		case R.id.more_return_btn:
			finish();
			break;
		}
	}

	private void getDepthZ() {
		mDepthZ = 100;
		mDepthZ = Math.min(mDepthZ, 300.0f);
	}

	private void applyRotation(View animView, float startAngle, float toAngle) {
		float centerX = mCenterX;
		float centerY = mCenterY;
		Rotate3dAnimation rotation = new Rotate3dAnimation(startAngle, toAngle, centerX, centerY, mDepthZ, true);
		rotation.setDuration(mDuration);
		rotation.setFillAfter(true);
		rotation.setInterpolator(new AccelerateInterpolator());
		rotation.setAnimationListener(new DisplayNextView());

		animView.startAnimation(rotation);
	}

	/**
	 * This class listens for the end of the first half of the animation. It
	 * then posts a new action that effectively swaps the views when the
	 * container is rotated 90 degrees and thus invisible.
	 */
	private final class DisplayNextView implements Animation.AnimationListener {

		public void onAnimationStart(Animation animation) {
		}

		public void onAnimationEnd(Animation animation) {

			mContainer.post(new SwapViews());
		}

		public void onAnimationRepeat(Animation animation) {
		}
	}

	private final class SwapViews implements Runnable {
		@Override
		public void run() {
			mImageView1.setVisibility(View.GONE);
			mImageView2.setVisibility(View.GONE);

			mIndex++;
			if (0 == mIndex % 2) {
				mStartAnimView = mImageView1;
				isFront = true;
			} else {
				mStartAnimView = mImageView2;
				isFront = false;
			}

			mStartAnimView.setVisibility(View.VISIBLE);
			mStartAnimView.requestFocus();

			Rotate3dAnimation rotation = new Rotate3dAnimation(-90, 0, mCenterX, mCenterY, mDepthZ, false);

			rotation.setDuration(mDuration);
			rotation.setFillAfter(true);
			rotation.setInterpolator(new DecelerateInterpolator());
			mStartAnimView.startAnimation(rotation);
		}
	}
}
