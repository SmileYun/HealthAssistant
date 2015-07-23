package com.dongshi.healthassisant.ui.healthtest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.util.ViewUtil;

import android.annotation.SuppressLint;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint({ "ValidFragment" })
public class SingleChoiceFragment extends BaseTestFragment {

 
	private String[] listDatas;
	private ListView lv;
	private ViewGroup mViewGroup;

	public SingleChoiceFragment(Question paramQuestion,String paramString) {
		super(paramQuestion,  paramString);
	} 
	
	public int initData() {
		this.listDatas = new String[this.options.size()]; 
		for (int i = 0;i<this.options.size(); i++) {
			 	
			this.listDatas[i] = ((Option) this.options.get(i))
					.getOptionContent(); 
		}
		return R.layout.xj_fragment_test_choice;
	}

	public void initLayout() {
		this.mViewGroup = ((ViewGroup) this.view.findViewById(R.id.ll_test));
		TextView localTextView = (TextView) this.view.findViewById(R.id.tv_healthtest_testtitle);
		localTextView.setText(this.testTitle);
		this.lv = ((ListView) this.view.findViewById(R.id.lv_healthtest_testoption));
		this.lv.setAdapter(new ArrayAdapter(getActivity(), R.layout.xj_item_single_choice,
				this.listDatas));
		this.lv.setChoiceMode(1);
 
		TestUtil.setDefaultChecked(this.options, this.lv);
		ViewUtil.setListViewHeightBasedOnChildren(this.lv, localTextView);
		int i = this.lv.getCheckedItemPosition();
		 
	}

	public void savaAnswer() {
		TestUtil.saveSingleQuestionAnswer(this.lv, this.question);
 
	}

}
