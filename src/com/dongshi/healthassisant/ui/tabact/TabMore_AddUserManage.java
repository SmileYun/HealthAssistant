package com.dongshi.healthassisant.ui.tabact;

import java.util.ArrayList;
import java.util.Calendar;

import com.dongshi.healthassisant.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class TabMore_AddUserManage extends Activity {
	private EditText userManageEditText;
	private EditText fimEditText;
	private EditText nameEditText;
	private RadioGroup siexRadioGroup;
	private EditText happyEditText;
	private EditText poneEditText;
	private EditText passEditText;
	private EditText passendEditText;
	private ArrayList<String[]> userlist = new ArrayList<String[]>();
	private Context mContext;
	private String[] userName = new String[] { "×æ¸¸", "×æÄ¸", "Íâ×æ¸¸", "Íâ×æÄ¸", "¸¸Ç×",
			"Ä¸Ç×", "ÕÉ·ò", "ÆÞ×Ó", "½ãÃÃ", "ÐÖµÜ", "¶ù×Ó", "Å®¶ù", "ÆäËû" };

	private Calendar cal;
	private int year;
	private int month;
	private int day;

	private Button okbButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		mContext = this;
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.more_ui_listview_additem);

		userManageEditText = (EditText) findViewById(R.id.more_Editext1);
		fimEditText = (EditText) findViewById(R.id.more_Editext2);
		nameEditText = (EditText) findViewById(R.id.more_Editext3);
		siexRadioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
		happyEditText = (EditText) findViewById(R.id.more_Editext4);
		poneEditText = (EditText) findViewById(R.id.more_Editext5);
		passEditText = (EditText) findViewById(R.id.more_Editext6);
		passendEditText = (EditText) findViewById(R.id.more_Editext7);

		fimEditText = (EditText) findViewById(R.id.more_Editext2);

		fimEditText.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				Log.i("kyo", hasFocus + "");
				if (hasFocus) {
					new AlertDialog.Builder(mContext)
							.setTitle("ÇëÑ¡Ôñ¼ÒÊô¹ØÏµ")
							.setSingleChoiceItems(userName, 0,
									new DialogInterface.OnClickListener() {

										public void onClick(
												DialogInterface dialog,
												int which) {
											dialog.dismiss();
											Log.i("kyo", which + "");
											fimEditText
													.setText(userName[which]);
										}
									}).setNegativeButton(null, null).show();
				} else {

				}

			}
		});

		cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;
		day = cal.get(Calendar.DAY_OF_MONTH);
		happyEditText = (EditText) findViewById(R.id.more_Editext4);

		happyEditText.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				if (hasFocus) {
					new DatePickerDialog(mContext, new OnDateSetListener() {

						@Override
						public void onDateSet(DatePicker view, int year,
								int monthOfYear, int dayOfMonth) {
							// s Auto-generated method stub
							setTitle(year + "-" + month + "-" + day);
							happyEditText.setText(year + "-" + monthOfYear
									+ "-" + dayOfMonth);
							happyEditText.hasFocus();
						}
					}, year, month, day).show();
				}

			}
		});
		okbButton = (Button) findViewById(R.id.btn_submit);
		okbButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				RadioButton radioButton = (RadioButton) findViewById(siexRadioGroup
						.getCheckedRadioButtonId());
				Intent intent = new Intent(mContext, TabMore_UserManage.class);
				String[] userManage = new String[] {
						userManageEditText.getText().toString(),
						fimEditText.getText().toString(),
						nameEditText.getText().toString(),
						radioButton.getText().toString(),
						happyEditText.getText().toString(),
						poneEditText.getText().toString(),
						passEditText.getText().toString(),
						passendEditText.getText().toString(), };

				Log.i("kyo", userManage[0].toString() + "username");
				intent.putExtra("data", userManage);
				setResult(2, intent);
			
				finish();

			}
		});
	}

}
