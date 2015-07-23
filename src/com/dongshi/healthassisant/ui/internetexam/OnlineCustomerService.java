package com.dongshi.healthassisant.ui.internetexam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.util.Log;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.fragment.BaseFragment_XJ;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;

public class OnlineCustomerService extends BaseFragment_XJ {

	private List<Map<String, String>> questionDatas = new ArrayList();
	private OnlineServiceAdapter myAdapter;
	private int[] stringOnlineStrings = new int[] { R.string.online_msg,
			R.string.online_msg_2 };
	private String[] phoneStrings = new String[] { "183****7896", "153****7834" };
	private String[] phoneStrings_msg = new String[] { "2014-10-22","2014-10-24"};
	public int initData() {
		getData();
		return R.layout.xj_listview_nohead_customerservice;

	}

	public void getData() {
		Map<String, String> map = new HashMap<String, String>();
		for(int i=0;i<2;i++)
		{
			map = new HashMap<String, String>();
			map.put("Id", String.valueOf(i + 1));
			map.put("phone", phoneStrings[i]);
			map.put("txtuserphone_msg", phoneStrings_msg[i]);
			map.put("qcontent",getResources().getString(stringOnlineStrings[i]));
			questionDatas.add(map);
		}
	}

	public void initLayout() {
		View mftwcustomersubmit = this.view.findViewById(R.id.mftwcustomersubmit);
	      
		mftwcustomersubmit.setOnClickListener(this);
		if (this.myAdapter == null) {
			ListView cosutomerqlist = (ListView) this.view
					.findViewById(R.id.customerqlist);
			this.myAdapter = new OnlineServiceAdapter(getActivity(),
					this.questionDatas);
			cosutomerqlist.setAdapter(this.myAdapter);
			cosutomerqlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				public void onItemClick(
						AdapterView<?> paramAnonymousAdapterView,
						View paramAnonymousView, int paramAnonymousInt,
						long paramAnonymousLong) {
					//OnlineCustomerService.this.openNewsInfo(paramAnonymousInt);
					Intent localIntent = new Intent(getActivity(),
							OnlineTalkDetailActivity.class);
					//传递参数
					localIntent.putExtra("type",0);
					localIntent.putExtra("isnewq",1);
					startActivity(localIntent);
				}
			});
			return;
		}

		this.myAdapter.notifyDataSetChanged();

	}

	public void onStart() {
		super.onStart();
		//initData();
	}
	
	public void onClick(View paramView)
	  {
	    super.onClick(paramView);
	    //Log.i("OnlineCustomerService",String.valueOf(paramView.getId()));
	    if (paramView.getId()==R.id.mftwcustomersubmit)
	    {
	    	//Tool.Jump(this, ActivationCardActivity.class);
	    	Intent localIntent = new Intent(getActivity(),
					OnlineTalkDetailActivity.class);
			//传递参数
			localIntent.putExtra("isnewq",0);
			localIntent.putExtra("type",1);
			startActivity(localIntent);
	    }

	  }

}
