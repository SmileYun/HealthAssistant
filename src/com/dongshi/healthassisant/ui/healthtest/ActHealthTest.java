package com.dongshi.healthassisant.ui.healthtest;

 
import android.content.Intent;
import android.view.View;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.ui.BaseTabTopActivity_XJ;

public class ActHealthTest extends BaseTabTopActivity_XJ{

	private void initLayout()
	  {
		  
		  this.mTabItems = new String[] { "�ҵ��Բ�", "�������" };
		    this.mFragments.add(new HealthTestFragment1());
		    this.mFragments.add(new HealthTestFragment2());
		   
			   initTabbar();
		       initViewPager(); 
		   
	  }

	  public void initData()
	  {
	    setContentView(R.layout.xj_layout_tabtop_base);
	    initTitle("��������");
	    initLayout();
	  }
	  
	  public void onClick(View paramView)
	  {
	    super.onClick(paramView);
//	    if (paramView.getId()==R.id.btnRight)
//	    {
//	    	Intent localIntent = new Intent(TabInternetExam.this,
//	    			MyOnlineQuestionActivity.class);
//			//���ݲ���
//			startActivity(localIntent);
//	    	 
//	    }
	    
	  }

}
