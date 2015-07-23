package com.dongshi.healthassisant.ui;

import com.dongshi.healthassisant.R;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class BaseActivity_XJ extends FragmentActivity implements View.OnClickListener{

	public ImageButton btBack;
	  public ImageButton ibtRight;
	  public TextView tvTitle;
	  
	  public void initTitle(String paramString)
	  {
	    this.tvTitle = ((TextView)findViewById(R.id.tvTitle));
	    if (this.tvTitle != null)
	      this.tvTitle.setText(paramString);
	    this.btBack = ((ImageButton)findViewById(R.id.btnBack));
	    if (this.btBack != null)
	      this.btBack.setOnClickListener(this);
	  }

	  public void initTitle(String paramString, int paramInt)
	  {
	    this.tvTitle = ((TextView)findViewById(R.id.tvTitle));
	    if (this.tvTitle != null)
	      this.tvTitle.setText(paramString);
	    this.ibtRight = ((ImageButton)findViewById(R.id.btnRight));
	    if (this.ibtRight != null)
	    {
	      this.ibtRight.setImageResource(paramInt);
	      this.ibtRight.setOnClickListener(this);
	    }
	    this.btBack = ((ImageButton)findViewById(R.id.btnBack));
	    if (this.btBack != null)
	      this.btBack.setOnClickListener(this);
	  }

	  public void onClick(View paramView)
	  {
		  if(paramView.getId()== R.id.btnBack)
		  {
			  finish();
		  }
	     
	  }

	  public void onCreate(Bundle paramBundle)
	  {
	    super.onCreate(paramBundle);
	     
	    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
	    //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	  }

	  protected void onResume()
	  {
	    super.onResume();
	    this.btBack = ((ImageButton)findViewById(R.id.btnBack));
	    if (this.btBack != null)
	      this.btBack.setOnClickListener(this);
	  }
}
