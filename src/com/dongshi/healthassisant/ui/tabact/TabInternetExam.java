package com.dongshi.healthassisant.ui.tabact;

import com.dongshi.healthassisant.R;
 

import com.dongshi.healthassisant.ui.BaseTabTopActivity_XJ;
import com.dongshi.healthassisant.ui.internetexam.MyOnlineQuestionActivity;
import com.dongshi.healthassisant.ui.internetexam.OnlineCustomerService;
import com.dongshi.healthassisant.ui.internetexam.OnlineDoctorService;
import com.dongshi.healthassisant.ui.internetexam.OnlineTalkDetailActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class TabInternetExam extends BaseTabTopActivity_XJ {
	 
	 
	 
	  private void initLayout()
	  {
		  
		  this.btBack.setVisibility(View.INVISIBLE);
		  this.mTabItems = new String[] { "在线客服", "在线医生" };
		    this.mFragments.add(new OnlineCustomerService());
		    this.mFragments.add(new OnlineDoctorService());
		   
			   initTabbar();
		       initViewPager(); 
		   
	  }

	  public void initData()
	  {
	    setContentView(R.layout.xj_layout_tabtop_base);
	    initTitle("网诊",R.drawable.my_online_select);
	    initLayout();
	  }
	  
	  public void onClick(View paramView)
	  {
	    super.onClick(paramView);
	    if (paramView.getId()==R.id.btnRight)
	    {
	    	Intent localIntent = new Intent(TabInternetExam.this,
	    			MyOnlineQuestionActivity.class);
			//传递参数
			startActivity(localIntent);
	    	 
	    }
	    
	  }
}
