package com.dongshi.healthassisant.ui.hospitalregister;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.adapter.AdapterListViewHospital;

/**
 * ҽԺѡ��
 * 
 * @author YUN
 */
public class ActHospitalChoise extends Activity implements OnClickListener {
	private ListView mListView;
	private ArrayList<HashMap<String, Object>> mList = new ArrayList<HashMap<String, Object>>();
	private TextView titleName;
	private ImageView mBack;
	private Context mContext;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		mContext = this;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_hospital_choise);
		mListView = (ListView) findViewById(R.id.listview_hospital_register);

		titleName = (TextView) findViewById(R.id.title_name);
		mBack = (ImageView) findViewById(R.id.more_return_btn);
		mBack.setOnClickListener(this);

		titleName.setText("ҽԺѡ��");

		getData(getIntent().getExtras());
		
//		for (int i = 0; i < 5; i++) {
//			HashMap<String, Object> m = new HashMap<String, Object>();
//			mList.add(m);
//		}

		mListView.setAdapter(new AdapterListViewHospital(this, mList));
		mListView.setOnItemClickListener(onClickListener);
	}

	public static final int CQNA = 1;
	public static final int CQBB = 2;
	public static final int CQYB = 3;
	public static final int CQJB = 4;
	public static final int SCCD = 5;
	public static final int CDGA = 6;
	public static final int SHHP = 7;
	public static final int SHPT = 8;
	public static final int SHJS = 9;
	public static final int SHCN = 10;
	public static final int SHPDXQ = 11;
	
	String[] cqna = {"����Э��ҽԺ", "�����������ҽԺ"};
	String[] cqbb = {"����Э��ҽԺ", "�����ƽҽԺ"};
	String[] cqyb = {"���찮�»�ҽԺ", "���컪��Ƥ����ҽԺ" ,"���컪��ҽԺ"};
	String[] cqjb = {"���콭��ҽԺ", "���콭���ǿ�ҽԺ" ,"��������ҽԺ"};
	
	String[] sccd = {"�ɶ����»�ҽԺ", "�Ĵ�Э��Ƥ����ҽԺ" ,"�ɶ�����ҽԺ"};
	String[] scga = {"�Ĵ�����ҽԺ", "�Ĵ��ǿ�ҽԺ" ,"�Ĵ��㰲����ҽԺ"};
	
	String[] shhp = {"�Ϻ����»�ҽԺ", "�Ϻ�����ҽԺ" ,"�Ϻ����ҽԺ","�Ϻ�����ҽԺ"};
	String[] shpt = {"�Ϻ���ɽҽԺ", "�Ϻ��ǿ�ҽԺ" ,"�Ϻ���������ҽԺ"};
	String[] shjs = {"�Ϻ���ɽҽԺ", "�Ϻ��ǿ�ҽԺ" ,"�Ϻ���������ҽԺ"};
	String[] shcn = {"�Ϻ��»�ҽԺ", "�Ϻ��ǿ�ҽԺ" ,"�Ϻ��ھ�����ҽԺ"};
	String[] shhk = {"�Ϻ��ؿ�ҽԺ", "�Ϻ��ǿ�ҽԺ" ,"�Ϻ��㰲����ҽԺ"};
	String[] shpdxq = {"�Ϻ��ε����ҽԺ", "�Ϻ��ǿ�ҽԺ" ,"�Ϻ���������ҽԺ"};
	
	
	void getData(Bundle b){
		String subcity = b.getString("subcity");
		String[] ss; 
 		if ("�㰲".equals(subcity)) {
 			ss = scga;
		}else if ("�ɶ�".equals(subcity)) {
			ss = sccd;
		}else if ("�ϰ���".equals(subcity)) {
			ss = cqna;
		}else if ("�山��".equals(subcity)) {
			ss = cqyb;
		}else if ("������".equals(subcity)) {
			ss = cqjb;
		}else if ("������".equals(subcity)) {
			ss = cqbb;
		}else if ("������".equals(subcity)) {
			ss = shhp;
		}else if ("������".equals(subcity)) {
			ss = shpt;
		}else if ("��ɽ��".equals(subcity)) {
			ss = shjs;
		}else if ("������".equals(subcity)) {
			ss = shcn;
		}else if ("�ֶ�����".equals(subcity)) {
			ss = shpdxq;
		}else if ("���".equals(subcity)) {
			ss = shhk;
		}else {
			ss = cqjb;
		}
		
		for (String s : ss) {
			HashMap<String, Object> m = new HashMap<String, Object>();
			m.put("hospital", s);
			mList.add(m);
		}
	}
	
	
	final OnItemClickListener onClickListener = new OnItemClickListener() {

		@SuppressWarnings("unchecked")
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			if ("guahao_item02".equals(getIntent().getStringExtra("ID"))) {
				
				Intent i = new Intent(ActHospitalChoise.this, ActDoctorList.class);
				Bundle b = new Bundle();
				b.putString("hospital", ((HashMap<String, Object>)parent.getAdapter().getItem(position)).get("hospital") + "");
				b.putString("ID", getIntent().getStringExtra("ID"));
				b.putString("TO", "ActDoctorList");
				b.putInt("type", ActHospitalChoiseDetail.CHOISE_KESHI);
				i.putExtras(b);
				startActivity(i);
				finish();
			}else {
				if ("HospitalWith".equals(getIntent().getExtras().getString("TAG"))) {
					Intent intent=new Intent();
					intent.putExtra("data", ((HashMap<String, Object>) parent.getAdapter().getItem(position)).get("hospital").toString());
					Log.i("kyo",  ((HashMap<String, Object>) parent.getAdapter().getItem(position)).get("hospital").toString());
					SharedPreferences spPreferences=getSharedPreferences("hospitalwith", Activity.MODE_PRIVATE);
					SharedPreferences.Editor editor=spPreferences.edit();
					editor.putString("hospAdd",  getIntent().getExtras().getString("city"));
					editor.putString("hospName",  ((HashMap<String, Object>) parent.getAdapter().getItem(position)).get("hospital").toString());
					editor.commit();
					setResult(5,intent);
					finish();
				}else {
					
					Intent i = new Intent(ActHospitalChoise.this, ActHospitalChoiseDetail.class);
					Bundle b = new Bundle();
					b.putString("hospital", ((HashMap<String, Object>)parent.getAdapter().getItem(position)).get("hospital") + "");
					b.putString("TAG", "ActHospitalChoiseDetail");
					b.putString("TO", "ActDoctorList");
					b.putInt("type", ActHospitalChoiseDetail.CHOISE_KESHI);
					i.putExtras(b);
					startActivity(i);
				}
				
			
				
			}
		}
	};

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.title_name:

			break;

		case R.id.more_return_btn:
			finish();
			break;
		}
	}
}
