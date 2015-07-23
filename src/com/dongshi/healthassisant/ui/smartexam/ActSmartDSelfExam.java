package com.dongshi.healthassisant.ui.smartexam;

import com.dongshi.healthassisant.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * �����Բ�
 * 
 * @author YUN
 */
public class ActSmartDSelfExam extends Activity implements OnClickListener {
	private TextView titleName, mQIndexTitle, mQIndex, mQContent;
	private ImageView mBack;
	private Button mBtnYes, mBtnNo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_smart_selfexam);
		initView();
	}

	private void initView() {
		titleName = (TextView) findViewById(R.id.title_name);
		mBack = (ImageView) findViewById(R.id.more_return_btn);
		mBack.setOnClickListener(this);
		mQIndexTitle = (TextView) findViewById(R.id.smart_choise_title);
		mQIndex = (TextView) findViewById(R.id.smart_question_index);
		mQContent = (TextView) findViewById(R.id.smart_question_content);
		mBtnYes = (Button) findViewById(R.id.smart_question_btnyes);
		mBtnNo = (Button) findViewById(R.id.smart_question_btnno);
		mBtnNo.setOnClickListener(this);
		mBtnYes.setOnClickListener(this);
		titleName.setText(getIntent().getStringExtra("situation") + "�����Բ�");
		mQIndexTitle.setText("����"+index);
		mQIndex.setText(""+index);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.smart_question_btnyes:
			setData();
			break;

		case R.id.smart_question_btnno:
			setData();
			break;

		case R.id.more_return_btn:
			finish();
			break;
		}
	}
	
	int index = 1;
	void setData(){
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (index < Qs.length) {
			index ++;
			mQIndex.setText(""+ index);
			mQIndexTitle.setText("����"+index);
			mQContent.setText(Qs[index-1]);
		}else {
			Intent intent = new Intent(this, ActSmartDEXamResult.class);
			intent.putExtra("result", getIntent().getStringExtra("situation"));
			this.startActivity(intent);
			this.finish();
		}
	}
	
	String[] Qs = {"�Ƿ�Ӹջ�˵����ͷ������壿", "�Ƿ����������ʷ��", "�ܶ��£�����֪��û�����壬���ǻ�ʧҪȥ���� �ܶ�ʱ������֪����Ӧ�������������ǻ���������.."};

}
