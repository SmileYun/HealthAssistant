package com.dongshi.healthassisant.ui.healthtest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;

public class SvListView extends ListView {
	public SvListView(Context paramContext)
	  {
	    super(paramContext);
	  }

	  public SvListView(Context paramContext, AttributeSet paramAttributeSet)
	  {
	    super(paramContext, paramAttributeSet);
	  }

	  public SvListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
	  {
	    super(paramContext, paramAttributeSet, paramInt);
	  }

	  protected void onMeasure(int paramInt1, int paramInt2)
	  {
	    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, -2147483648));
	  }
}
