package com.dongshi.healthassisant.ui.healthtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.ui.internetexam.OnlineTalkDetailActivity;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HealthTestExpandableListAdapter extends BaseExpandableListAdapter {

	Activity activity;
	  List<Map<String, Object>> edlvDatas;
	  LayoutInflater inflater;
	  int scale = 0;
	
	  public HealthTestExpandableListAdapter(Activity paramActivity, List<Map<String, Object>> paramList)
	  {
	    this.activity = paramActivity;
	    this.edlvDatas = paramList; 
	    this.inflater = LayoutInflater.from(paramActivity);
	  }
	  
	@Override
	public Object getChild(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getChildId(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getChildView(final int paramInt1, final int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup) {
		 ChildHolder localChildHolder;
		    if (paramView == null)
		    {
		      paramView = this.inflater.inflate(R.layout.xj_item_healthtest_child, null);
		      localChildHolder = new ChildHolder();
		      localChildHolder.btnAskDoctor=((Button)paramView.findViewById(R.id.btnAskDoctor));
//		      localChildHolder.tv_test_name = ((TextView)paramView.findViewById(2131362015));
//		      localChildHolder.bt_test_button = ((Button)paramView.findViewById(2131362016));
//		      localChildHolder.tv_test_state = ((TxxtView)paramView.findViewById(2131362014));
//		      localChildHolder.iv_progress = ((ImageView)paramView.findViewById(2131362013));
		      paramView.setTag(localChildHolder);
		    }
		    else
		    {
		    	localChildHolder = (ChildHolder)paramView.getTag();
		    }
		    localChildHolder.btnAskDoctor.setOnClickListener(new View.OnClickListener()
		      {
		        public void onClick(View paramAnonymousView)
		        {
		        	Intent localIntent = new Intent(HealthTestExpandableListAdapter.this.activity,
							OnlineTalkDetailActivity.class);
					//传递参数
					localIntent.putExtra("isnewq",0);
					localIntent.putExtra("type",1);
					HealthTestExpandableListAdapter.this.activity.startActivity(localIntent);
					 
		        }
		      });
		    return paramView;
	}

	@Override
	public int getChildrenCount(int paramInt) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return this.edlvDatas.size();
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup) {
		 GroupHolder localGroupHolder;
		    TextView localTextView;
		    if (paramView == null)
		    {
		      paramView = this.inflater.inflate(R.layout.xj_item_healthtest_group, null);
		      localGroupHolder = new GroupHolder();
		      localGroupHolder.tv_healthtest_group_title = ((TextView)paramView.findViewById(R.id.tv_healthtest_group_title));
		      localGroupHolder.tv_healthtest_group_score = ((TextView)paramView.findViewById(R.id.tv_healthtest_group_score));
		      paramView.setTag(localGroupHolder);
		    }
		    else
		    {
		    	localGroupHolder = (GroupHolder)paramView.getTag();
		    }
		      String title = (String)((Map)this.edlvDatas.get(paramInt)).get("testtitle");
		      String score =  (String)((Map)this.edlvDatas.get(paramInt)).get("testscore");
		      localGroupHolder.tv_healthtest_group_title.setText(title);
		      localGroupHolder.tv_healthtest_group_score.setText("我的得分:" + score+"分");
		      localTextView = localGroupHolder.tv_healthtest_group_score;
		      if (!paramBoolean)
		    	  localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_arrow_right_small, 0);
		      else
		    	  localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_arrow_bottom_small, 0);
		      
		      return paramView;
		    
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void setScale(int paramInt)
	  {
	    this.scale = paramInt;
	  }
	
	class ChildHolder
	  {
	    Button bt_test_button;
	    ImageView iv_progress;
	    TextView tv_test_name;
	    TextView tv_test_state;
	    Button btnAskDoctor;

	    ChildHolder()
	    {
	    }
	  }

	  class GroupHolder
	  {
	    TextView tv_healthtest_group_title;
	    TextView tv_healthtest_group_score;

	    GroupHolder()
	    {
	    }
	  }

}
