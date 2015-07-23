package com.dongshi.healthassisant.ui.tabact;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.ui.BaseActivity_XJ;
import com.dongshi.healthassisant.ui.BaseTabTopActivity_XJ;
import com.dongshi.healthassisant.ui.alarm.AlarmSettingActivity;
import com.dongshi.healthassisant.ui.alarm.PriceDetailActivity;
import com.dongshi.healthassisant.ui.internetexam.OnlineTalkDetailActivity;


public class TabAlarm extends BaseActivity_XJ {

	
	private ToggleButton tbcallalarm;
	private ToggleButton tbcheckalarm;
	private ToggleButton tbmedicealarm;
	
	private TextView txtmedicecontent;
	private TextView txtcheckcontent;
	private TextView txtcallcontent;
	
	private TextView txthjtipcontent;
	
	private ImageButton btnaddcallalarm;
	private ImageButton btnaddcheckalarm;
	private ImageButton btnaddedicealarm;
	
	private Button btnhjdetal;
 
	
	public void onCreate(Bundle paramBundle)
	  {
		super.onCreate(paramBundle);
	    setContentView(R.layout.xj_listview_nohead_alarm);
	    initTitle("提醒");
	    this.tbcallalarm=(ToggleButton)findViewById(R.id.tbcallalarm);
	    this.tbcheckalarm=(ToggleButton)findViewById(R.id.tbcheckalarm);
	    this.tbmedicealarm=(ToggleButton)findViewById(R.id.tbmedicealarm);
	    

	    this.txtcallcontent=(TextView)findViewById(R.id.txtcallcontent);
	    
	    this.txthjtipcontent=(TextView)findViewById(R.id.txthjtipcontent);
	    
	    this.btnaddcallalarm=(ImageButton)findViewById(R.id.btnaddcallalarm);
	    this.btnaddcheckalarm=(ImageButton)findViewById(R.id.btnaddcheckalarm);
	    this.btnaddedicealarm=(ImageButton)findViewById(R.id.btnaddedicealarm);
	    
	    this.btnhjdetal=(Button)findViewById(R.id.btnhjdetal);
	    btnhjdetal.setOnClickListener(this); 
	    
	    btnaddcallalarm.setOnClickListener(this);
	    btnaddcheckalarm.setOnClickListener(this);
	    btnaddedicealarm.setOnClickListener(this);
	    initLayout();
	  }
	 
	 private void initLayout()
	  {
		  
		  this.btBack.setVisibility(View.INVISIBLE);
		  this.tbcallalarm.setChecked(true);
		  this.tbcheckalarm.setChecked(false);
		  this.tbmedicealarm.setChecked(false);
		  this.txtcallcontent.setText("3小时15分钟后到重庆市西南医院肝胆科就诊\r\n提示方式：振动");
		  this.txthjtipcontent.setText("划价提醒(2014-10-30 09:02:34)\r\n您在重庆市西南医院检验中心所做血液检查花费为39.50元");
		  this.btnaddcallalarm.setBackgroundResource(R.drawable.people_info_edit_select);
		  this.btnaddcheckalarm.setBackgroundResource(R.drawable.add_green);
		  this.btnaddedicealarm.setBackgroundResource(R.drawable.add_green);
		  
	  }
	 
	 public void onClick(View paramView)
	  {
	    super.onClick(paramView);
	    if (paramView.getId()==R.id.btnaddcallalarm)
	    {
	    	//Tool.Jump(this, ActivationCardActivity.class);
	    	Intent localIntent = new Intent(TabAlarm.this,
	    			AlarmSettingActivity.class);
			//传递参数
			localIntent.putExtra("isnewq",0);
			localIntent.putExtra("type",1);
			startActivity(localIntent);
	    }
	    else if (paramView.getId()==R.id.btnaddedicealarm)
	    {
	    	//Tool.Jump(this, ActivationCardActivity.class);
	    	Intent localIntent = new Intent(TabAlarm.this,
	    			AlarmSettingActivity.class);
			//传递参数
			localIntent.putExtra("isnewq",0);
			localIntent.putExtra("type",1);
			startActivity(localIntent);
	    }
	    else if (paramView.getId()==R.id.btnaddcheckalarm)
	    {
	    	//Tool.Jump(this, ActivationCardActivity.class);
	    	Intent localIntent = new Intent(TabAlarm.this,
	    			AlarmSettingActivity.class);
			//传递参数
			localIntent.putExtra("isnewq",0);
			localIntent.putExtra("type",1);
			startActivity(localIntent);
	    }
	    else if(paramView.getId()==R.id.btnhjdetal)
	    {
	    	Intent localIntent = new Intent(TabAlarm.this,
	    			PriceDetailActivity.class);
			 
			startActivity(localIntent);
	    }

	  }
	 
	  
   
}
