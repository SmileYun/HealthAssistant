package com.dongshi.healthassisant.ui.healthtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.util.ViewUtil;

@SuppressLint({ "InflateParams" })
public class TestUtil {

	 public static void addComplete(Activity paramActivity, ViewGroup paramViewGroup, Question paramQuestion, String paramString)
	  {
	    View localView = LayoutInflater.from(paramActivity).inflate(R.layout.xj_fragment_test_completion, null);
	    ((TextView)localView.findViewById(R.id.tv_healthtest_testtitle)).setText(paramString);
	    ((EditText)localView.findViewById(R.id.et_input)).setText(paramQuestion.getqAnswer());
	    paramViewGroup.addView(localView);
	  }
	
	public static List<Map<String, String>> getAllAnswer(
			List<Question> paramList, Map<String, Question> paramMap) {
		ArrayList localArrayList = new ArrayList();
		Iterator localIterator1 = paramList.iterator();
		Iterator localIterator2;
		if (!localIterator1.hasNext())
		{
			localIterator2 = paramMap.entrySet().iterator();
			if (!localIterator2.hasNext()) {
				Question localQuestion1 = (Question) localIterator1.next();
				HashMap localHashMap1 = new HashMap();
				localHashMap1.put("question", localQuestion1.getRubricId());
				localHashMap1.put("answer", localQuestion1.getqAnswer());
				localHashMap1.put("states", localQuestion1.getStates());
				localArrayList.add(localHashMap1);
			} 
		else {
			Question localQuestion2 = (Question) ((Map.Entry) localIterator2
					.next()).getValue();
			HashMap localHashMap2 = new HashMap();
			localHashMap2.put("question", localQuestion2.getRubricId());
			localHashMap2.put("answer", localQuestion2.getqAnswer());
			localHashMap2.put("states", localQuestion2.getStates());
			localArrayList.add(localHashMap2);
			}
		}
		return localArrayList;

	}
	
	public static void addListview(Activity paramActivity, ViewGroup paramViewGroup, String paramString, List<Option> paramList, boolean paramBoolean)
	  {
		DisplayMetrics dm = new DisplayMetrics();
		paramActivity.getWindowManager().getDefaultDisplay().getMetrics(dm);
	    View localView = LayoutInflater.from(paramActivity).inflate(R.layout.xj_fragment_test_choice_head, null);
	    ((TextView)localView.findViewById(R.id.tv_healthtest_testtitle)).setText(paramString);
	    SvListView localSvListView = new SvListView(paramActivity);
	    int i = (int)(10.0F * dm.density);
	    localSvListView.setDivider(paramActivity.getResources().getDrawable(R.color.transparent));
	    localSvListView.setDividerHeight(i);
	    localSvListView.setSelector(R.color.transparent);
	    localSvListView.setCacheColorHint(R.color.transparent);
	    localSvListView.addHeaderView(localView);
	    localSvListView.setPadding(0, i, 0, i);
	    int j = paramList.size();
	    String[] arrayOfString = new String[j];
	    
	    ArrayAdapter localArrayAdapter;
	    for(int k=0;k<j;k++){
		    if (k+1 == j)
		    {
		      if (!paramBoolean)
		      {
		    	  localArrayAdapter = new ArrayAdapter(paramActivity, R.layout.xj_item_multiple_choice, arrayOfString);
		    	  localSvListView.setChoiceMode(2);
		      }
		      else
		      {
			      localArrayAdapter = new ArrayAdapter(paramActivity, R.layout.xj_item_single_choice, arrayOfString);
			      localSvListView.setChoiceMode(1);
		      }
		      localSvListView.setAdapter(localArrayAdapter);
		    }
		    else
		    {
		    	arrayOfString[k] = ((Option)paramList.get(k)).getOptionContent();
		    }
	    }
	   // localSvListView.setAdapter(localArrayAdapter);
	      setDefaultCheckedForHasHead(paramList, localSvListView);
	      paramViewGroup.addView(localSvListView);
	      ViewUtil.setListViewHeightBasedOnChildren(localSvListView, localView);
	     
	  }
	 public static void setDefaultCheckedForHasHead(List<Option> paramList, ListView paramListView)
	  {
	    for (int i = 0; ; i++)
	    {
	      if (i >= paramList.size())
	        return;
	      if ("checked".equals(((Option)paramList.get(i)).getCheckedVal()))
	        paramListView.setItemChecked(i + 1, true);
	    }
	  }
	 
	 public static void setDefaultChecked(List<Option> paramList, ListView paramListView)
	  {
	    for (int i = 0;i<paramList.size() ; i++)
	    { 
	      if ("checked".equals(((Option)paramList.get(i)).getCheckedVal()))
	        paramListView.setItemChecked(i, true);
	    }
	  }
	 
	 public static void saveSingleQuestionAnswer(ListView paramListView, Question paramQuestion)
	  {
	    List localList = paramQuestion.getOptions();
	    int i = paramListView.getCheckedItemPosition();
	    if (i != -1)
	    {
	      String str = "";
	      int j = 0;
	      for(j=0;j<localList.size();j++)
	      {
	    	  Option localOption = (Option)localList.get(j);
	    	  if(j==i)
	    	  {
	    		  localOption.setCheckedVal("checked");
	  	         str = localOption.getOptionContent();
	    	  }
	    	  else
	    	  {
	    		  localOption.setCheckedVal(""); 
	    	  }
	      }
	      paramQuestion.setqAnswer(str);
	      paramQuestion.setStates("2");
	    }
	    else
	    {
	    	paramQuestion.setStates("1");
	    }
	      
	       
	  }

	  

}
