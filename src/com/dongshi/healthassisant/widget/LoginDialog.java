package com.dongshi.healthassisant.widget;
/**
 * @author Yun
 */
import java.util.HashMap;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.ViewSwitcher;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.app.AppContext;
import com.dongshi.healthassisant.ui.MyBaseActivity;
import com.dongshi.healthassisant.util.StringUtils;
import com.dongshi.healthassisant.util.UIHelper;

public class LoginDialog extends MyBaseActivity {

	private ViewSwitcher mViewSwitcher;
	/** 账号 */
	private AutoCompleteTextView mAccount;
	/** 密码 */
	private EditText mPwd;
	/** 复选框 */
	private CheckBox chb_rememberMe;
	/** 登录按钮 */
	private Button btn_login;
	/** 注册按钮 */
	private Button btn_reg;
	/** 关闭按钮 */
	private ImageButton btn_close;

	private RelativeLayout loginLoading;
	/** 只有在数据加载完成后，才可以点击“返回键” **/
	private boolean canBack = true;

	private int curLoginType;
	private InputMethodManager imm;

	public final static int LOGIN_OTHER = 0x00;
	public final static int LOGIN_MAIN = 0x01;
	public final static int LOGIN_SETTING = 0x02;

	AppContext appContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_dialog);
		appContext = (AppContext) getApplication();
		initView();
	}

	/**
	 * 初始化控件
	 */
	private void initView() {
		imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);

		curLoginType = getIntent().getIntExtra("LOGINTYPE", LOGIN_OTHER);

		mViewSwitcher = (ViewSwitcher) findViewById(R.id.logindialog_view_switcher);
		mAccount = (AutoCompleteTextView) findViewById(R.id.login_account);
		mPwd = (EditText) findViewById(R.id.login_password);
		chb_rememberMe = (CheckBox) findViewById(R.id.login_checkbox_rememberMe);
		loginLoading = (RelativeLayout) findViewById(R.id.progressBar);

		btn_close = (ImageButton) findViewById(R.id.login_close_button);
		btn_close.setVisibility(View.VISIBLE);
		btn_close.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				LoginDialog.this.finish();
			}
		});

		btn_login = (Button) findViewById(R.id.login_btn_login);
		btn_login.setOnClickListener(onClickListener);
		btn_reg = (Button) findViewById(R.id.login_btn_reg);
		btn_reg.setOnClickListener(onClickListener);
	}

	private final OnClickListener onClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {

			// 隐藏软键盘
			imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

			switch (v.getId()) {
			case R.id.login_btn_login:
				String account = mAccount.getText().toString();
				String pwd = mPwd.getText().toString();
				boolean isRememberMe = chb_rememberMe.isChecked();
				// 判断输入
				if (StringUtils.isEmpty(account)) {
					return;
				}
				if (StringUtils.isEmpty(pwd)) {
					return;
				}

				btn_close.setVisibility(View.GONE);
				mViewSwitcher.showNext();

				login(account, pwd, isRememberMe);
				
				break;
			case R.id.login_btn_reg:
//				Intent intent = new Intent(LoginDialog.this, RegUserActivity.class);
//				LoginDialog.this.startActivity(intent);
//				LoginDialog.this.finish();
				break;
			}
		}
	};

	private void login(final String account, final String pwd, final boolean isRememberMe) {
	}

	@Override
	public void init() {

	}

	@Override
	public void refresh(Object... param) {

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			if (canBack) 
			{
				LoginDialog.this.finish();
				return super.onKeyDown(keyCode, event);
			} 
			else 
			{
				return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
}
