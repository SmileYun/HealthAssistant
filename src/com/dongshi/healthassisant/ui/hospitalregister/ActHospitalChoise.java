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
 * 医院选择
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

		titleName.setText("医院选择");

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
	
	String[] cqna = {"重庆协和医院", "重庆国宾妇产医院"};
	String[] cqbb = {"重庆协和医院", "重庆和平医院"};
	String[] cqyb = {"重庆爱德华医院", "重庆华肤皮肤病医院" ,"重庆华新医院"};
	String[] cqjb = {"重庆江北医院", "重庆江北骨科医院" ,"重庆新新医院"};
	
	String[] sccd = {"成都爱德华医院", "四川协和皮肤病医院" ,"成都华新医院"};
	String[] scga = {"四川江北医院", "四川骨科医院" ,"四川广安新新医院"};
	
	String[] shhp = {"上海爱德华医院", "上海复旦医院" ,"上海瑞金医院","上海华新医院"};
	String[] shpt = {"上海中山医院", "上海骨科医院" ,"上海长海新新医院"};
	String[] shjs = {"上海华山医院", "上海骨科医院" ,"上海长征新新医院"};
	String[] shcn = {"上海新华医院", "上海骨科医院" ,"上海第九人民医院"};
	String[] shhk = {"上海胸科医院", "上海骨科医院" ,"上海广安新新医院"};
	String[] shpdxq = {"上海肝胆外科医院", "上海骨科医院" ,"上海复旦附属医院"};
	
	
	void getData(Bundle b){
		String subcity = b.getString("subcity");
		String[] ss; 
 		if ("广安".equals(subcity)) {
 			ss = scga;
		}else if ("成都".equals(subcity)) {
			ss = sccd;
		}else if ("南岸区".equals(subcity)) {
			ss = cqna;
		}else if ("渝北区".equals(subcity)) {
			ss = cqyb;
		}else if ("江北区".equals(subcity)) {
			ss = cqjb;
		}else if ("北培区".equals(subcity)) {
			ss = cqbb;
		}else if ("黄埔区".equals(subcity)) {
			ss = shhp;
		}else if ("普陀区".equals(subcity)) {
			ss = shpt;
		}else if ("金山区".equals(subcity)) {
			ss = shjs;
		}else if ("常宁区".equals(subcity)) {
			ss = shcn;
		}else if ("浦东新区".equals(subcity)) {
			ss = shpdxq;
		}else if ("虹口".equals(subcity)) {
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
