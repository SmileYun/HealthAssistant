package com.dongshi.healthassisant.ui.healthtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.widget.ExpandableListView;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.fragment.BaseFragment_XJ;

public class HealthTestFragment1 extends BaseFragment_XJ {

	private List<Map<String, Object>> edlvDatas = new ArrayList();
	  private HealthTestExpandableListAdapter myAdapter;
	  
	ExpandableListView edlv_common;
	
	private void getEdlvData()
	  {
		Map<String, Object> map = new HashMap<String, Object>();
		 
			map = new HashMap<String, Object>();
			map.put("testtitle", "抑郁自评量表测试[20题]");
			map.put("testscore", "88"); 
			edlvDatas.add(map);
			
			map = new HashMap<String, Object>();
			map.put("testtitle", "神经自评量表测试[20题]");
			map.put("testscore", "79"); 
			edlvDatas.add(map);
			//initLayout();
	  }
	@Override
	public int initData() {
		// TODO Auto-generated method stub
		getEdlvData();
		return R.layout.xj_listview_nohead_healthtest1;
	}

	@Override
	public void initLayout() {
		// TODO Auto-generated method stub
		if (this.myAdapter == null)
	    {
	      ExpandableListView localExpandableListView = (ExpandableListView)this.view.findViewById(R.id.edlv_common);
	      this.myAdapter = new HealthTestExpandableListAdapter(getActivity(), this.edlvDatas);
	      localExpandableListView.setAdapter(this.myAdapter);
	      localExpandableListView.expandGroup(0);
	      return;
	    }
	     
	    this.myAdapter.notifyDataSetChanged();
	     
	}
	
	public void onStart()
	  {
	    super.onStart();
	    //initData();
	  }

}
