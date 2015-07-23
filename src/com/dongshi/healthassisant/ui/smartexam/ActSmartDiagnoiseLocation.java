package com.dongshi.healthassisant.ui.smartexam;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.adapter.AdapterLVItemSimpleTVAndArrow;
import com.dongshi.healthassisant.ui.MyBaseActivity;

/**
 * 
 * @author YUN
 */
public class ActSmartDiagnoiseLocation extends MyBaseActivity implements OnClickListener, OnItemClickListener {
	public static final int smart_diagnoise_head = 1;
	public static final int smart_diagnoise_neck = 2;
	public static final int smart_diagnoise_breast = 3;
	public static final int smart_diagnoise_stomach = 4;
	public static final int smart_diagnoise_arm_left = 5;
	public static final int smart_diagnoise_arm_right = 6;
	public static final int smart_diagnoise_bird = 7;

	public static final int smart_diagnoise_leg = 8;
	public static final int smart_diagnoise_skin = 9;
	public static final int smart_diagnoise_back = 10;
	public static final int smart_diagnoise_eye_nose_me = 11;
	public static final int smart_diagnoise_other = 12;
	public static final int smart_diagnoise_ass = 13;
	public static final int smart_diagnoise_yao = 14;
	public static final int smart_diagnoise_tGender = 18;

	private TextView titleName, mChoiseTitle;
	private ImageView mBack;
	private ListView mListView;
	private AdapterLVItemSimpleTVAndArrow mAdapter;
	ArrayList<HashMap<String, Object>> mList = new ArrayList<HashMap<String,Object>>();
	private String[] locations = { "ͷ��", "����", "�ز�", "����", "��֫", "��֫", /*6*/"��ֳ��", "��֫", "Ƥ��", "����", "���ۿڱ�", "����", "��й��", "��׵" };
	private String[] ill0 = {"�����״�", "�����ϰ�", "ͷ��", "ͷ��"};
	private String[] ill1 = {"������ʹ��Ӳ", "�ʺ���ʹ", "��������", "��״���״�"};
	private String[] ill2 = {"����", "����", "�ļ�", "��̵", "����", "�粿��ʹ"};
	private String[] ill3 = {"����", "ŻѪ�ڱ�", "��к", "��θ����", "ʳ���쳣", "����"};
	private String[] ill4 = {"ָ������", "����"};
	private String[] ill5 = {"ָ������", "����"};
	private String[] ill6 = {"����", "��й"};
	private String[] ill7 = {"ϥ�ؽ���ʹ", "�ײ�����", "�Źؽ���ʹ"};
	private String[] ill8 = {"Ƥ��", "���", "Ƥ������", "Ƥ������", "�ѷ�", "ɫ��"};
	private String[] ill9 = {"���ᱳʹ"};
	private String[] ill10 = {"�۾���ɬ", "�����½�", "����", "��֢ͫ", "��������", "�����쳣", "�����½�", "����"};
	private String[] ill11 = {"ʧ��", "����", "��Ѫѹ", "ˮ��", "ƣ��", "˼ά����", "����", "�ູ", "����"};
	private String[] ill12 = {"����", "��Ƶ", "Ѫ��", "��Ѫ"};
	private String[] ill13 = {"����", "������ͻ��", "������"};
	
	private ArrayList<String[]> mDL = new ArrayList<String[]>();
	
	
	private boolean isDetail = false;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.smart_diagnoise_location_listview);
		mDL.add(ill0);mDL.add(ill1);mDL.add(ill2);mDL.add(ill3);mDL.add(ill4);mDL.add(ill5);mDL.add(ill6);mDL.add(ill7);
		mDL.add(ill8);mDL.add(ill9);mDL.add(ill10);mDL.add(ill11);mDL.add(ill12);mDL.add(ill13);
		initView();
	}

	public void initView() {
		titleName = (TextView) findViewById(R.id.title_name);
		mBack = (ImageView) findViewById(R.id.more_return_btn);
		mBack.setOnClickListener(this);
		titleName.setText("���ܵ���");
		mChoiseTitle = (TextView) findViewById(R.id.smart_choise_title);

		int type = getIntent().getIntExtra("location", -1) - 1;
		setChoiseTitle(type);

		mListView = (ListView) findViewById(R.id.listview_smart_diagnoise_location);
		mListView.setOnItemClickListener(this);
		getListViewData(type/*"" + locations[type - 1]*/);

		mAdapter = new AdapterLVItemSimpleTVAndArrow(this, mList);
		mListView.setAdapter(mAdapter);
	}

	/**
	 *	���ݰ󶨽ӿ� 
	 */
	private void getListViewData(int type) {
		mList.clear();
		String[] strs = mDL.get(type);
		
		for (String string : strs) {
			HashMap<String, Object> m = new HashMap<String, Object>();
			m.put("name", string);
			mList.add(m);
		}
	}

	public void setChoiseTitle(int type) {
		mChoiseTitle.setText("" + locations[type]);
	}

	@Override
	public void refresh(Object... param) {

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.more_return_btn:
			finish();
			isDetail = false;
			break;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//		if (!isDetail) {
//			getListViewData(((HashMap<String, Object>) parent.getAdapter().getItem(position)).get("name") + "����");
//			mAdapter.notifyDataSetChanged();
//			isDetail = true;
//			return;
//		}
		Intent i  = new Intent(this, ActSmartDSelfExam.class);
		i.putExtra("situation", ((HashMap<String, Object>) parent.getAdapter().getItem(position)).get("name")+"");
		this.startActivity(i);
		this.finish();
	}

	@Override
	public void init() {
	}
}
