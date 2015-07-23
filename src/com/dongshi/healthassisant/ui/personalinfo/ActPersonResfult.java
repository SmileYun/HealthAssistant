package com.dongshi.healthassisant.ui.personalinfo;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.adapter.AdapterPersonResult;
import com.dongshi.healthassisant.ui.MyBaseActivity;

/**
 * @author Yun
 */
public class ActPersonResfult extends MyBaseActivity implements OnItemClickListener{
	ListView mListView;
	ArrayList<HashMap<String, Object>> mList = new ArrayList<HashMap<String,Object>>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_personal_result);
		initView();
	}
	
	
	private void initView() {
		setTitleName("�����⼰���");
		mListView = (ListView) findViewById(R.id.listview_person_result);
		mListView.setOnItemClickListener(this);
		getData();
		mListView.setAdapter(new AdapterPersonResult(this, mList));
		
	}

	String[] type = {"�ĵ�ͼ", "�ι��ܼ���"};
	String[] exam = {"��­������(�ർ)", "�ι�6��"};
	String[] examtype = {"��Ѫ��ͼ", "�����ֵ(A/G)"};
	String[] examresult = {"��Ѫ��ͼδ���쳣", " 1.70 "};
	
	
	private void getData() {
		for (int i = 0; i < 2; i++) {
			HashMap<String, Object> m = new HashMap<String, Object>();
			m.put("type", type[i]);
			m.put("exam", exam[i]);
			m.put("examtype", examtype[i]);
			m.put("examresult", examresult[i]);
			mList.add(m);
		}
	}


	@Override
	public void init() {
		
	}

	@Override
	public void refresh(Object... param) {
		
	}


	@Override
	public void onClick(View v) {
		super.onClick(v);
	}


	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		// TODO Auto-generated method stub
		
	}

}
