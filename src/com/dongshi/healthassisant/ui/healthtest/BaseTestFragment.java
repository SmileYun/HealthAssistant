package com.dongshi.healthassisant.ui.healthtest;

import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;

import com.dongshi.healthassisant.fragment.BaseFragment_XJ;

@SuppressLint({"ValidFragment"})
public abstract class BaseTestFragment extends BaseFragment_XJ {

	 
	  public List<Option> options;
	  public Question question;
	  public String testNum;
	  public String testTitle;

	  public BaseTestFragment(Question paramQuestion, String paramString)
	  {
	    this.question = paramQuestion; 
	    this.testNum = paramString;
	    this.testTitle = (paramString + "¡¢" + paramQuestion.getTitle());
	    this.options = paramQuestion.getOptions();
	  }

	  public abstract void savaAnswer();

}
