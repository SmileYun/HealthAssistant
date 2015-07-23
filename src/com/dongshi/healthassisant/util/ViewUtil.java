package com.dongshi.healthassisant.util;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ViewUtil {

	public static String formatParagraph(String paramString)
	  {
	    if (paramString != null)
	      return "¡¡¡¡" + paramString.trim();
	    return "";
	  }

	  public static void highLight(TextView paramTextView, int paramInt1, int paramInt2)
	  {
	    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramTextView.getText().toString());
	    localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-65536), paramInt1, paramInt2, 33);
	    paramTextView.setText(localSpannableStringBuilder);
	  }

	   

	  public static void setViewHeight(View paramView)
	  {
	    paramView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
	  }

	  public static void underLine(TextView paramTextView)
	  {
	    String str = Tool.getTvString(paramTextView);
	    int i = str.length();
	    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(str);
	    localSpannableStringBuilder.setSpan(new UnderlineSpan(), 0, i, 33);
	    paramTextView.setText(localSpannableStringBuilder);
	  }
	  
	  public static void setListViewHeightBasedOnChildren(ListView paramListView, View paramView)
	  {
	    ListAdapter localListAdapter = paramListView.getAdapter();
	    if (localListAdapter == null)
	      return;
	    int i = 0;
	    for (int j = 0;j<localListAdapter.getCount() ; j++)
	    {
	      if (j+1 == localListAdapter.getCount())
	      {
	        paramView.measure(0, 0);
	        ViewGroup.LayoutParams localLayoutParams = paramListView.getLayoutParams();
	        localLayoutParams.height = (i + paramListView.getDividerHeight() * (-1 + localListAdapter.getCount()) + paramView.getMeasuredHeight());
	        paramListView.setLayoutParams(localLayoutParams);
	        return;
	      }
	      View localView = localListAdapter.getView(j, null, paramListView);
	      localView.measure(0, 0);
	      i += localView.getMeasuredHeight();
	    }
	  }
	
}
