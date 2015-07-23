package com.dongshi.healthassisant.fragment;

import com.dongshi.healthassisant.R;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

public abstract class BaseFragment_XJ extends Fragment 
implements View.OnClickListener
{
	public ImageButton btBack;
	  public ImageButton ibtRight;
	  public int layoutId;
	  public TextView tvTitle;
	  public View view;

	  public abstract int initData();

	  public abstract void initLayout();

	  public void initTitle(String paramString)
	  {
	    this.tvTitle = ((TextView)this.view.findViewById(R.id.tvTitle));
	    if (this.tvTitle != null)
	      this.tvTitle.setText(paramString);
	  }

	  public void initTitle(String paramString, int paramInt)
	  {
	    this.tvTitle = ((TextView)this.view.findViewById(R.id.tvTitle));
	    if (this.tvTitle != null)
	      this.tvTitle.setText(paramString);
	    this.ibtRight = ((ImageButton)this.view.findViewById(R.id.btnRight));
	    if (this.ibtRight != null)
	    {
	      this.ibtRight.setImageResource(paramInt);
	      this.ibtRight.setOnClickListener(this);
	    }
	  }

	  public void onClick(View paramView)
	  {
	    if (paramView.getId()==R.id.btnBack)
	    {
	    	getActivity().finish();
	    }
	     
	  }

	  public void onCreate(Bundle paramBundle)
	  {
	    super.onCreate(paramBundle);
	    this.layoutId = initData();
	  }

	  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
	  {
	    if (this.view == null)
	    {
	      this.view = paramLayoutInflater.inflate(this.layoutId, paramViewGroup, false);
	      this.btBack = ((ImageButton)this.view.findViewById(R.id.btnBack));
	      if (this.btBack != null)
	        this.btBack.setOnClickListener(this);
	      initLayout();
	    }
	    ViewGroup localViewGroup = (ViewGroup)this.view.getParent();
	    if (localViewGroup != null)
	      localViewGroup.removeView(this.view);
	    return this.view;
	  }
}
