package com.dongshi.healthassisant.widget;

import com.dongshi.healthassisant.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.TextView;

public class MyTabBarTextView extends TextView {
	private static final int CURSOR = 4;
	  private static final int GRAY = 0;
	  private static final int GRAY_CURSOR = 3;
	  private static final int GREEN = 1;
	  private static final int GREEN_CURSOR = 2;
	  private int GreenlineColor = getResources().getColor(R.color.green);
	  private boolean isVerticalLine = false;
	  private float screen_density;
	  private int state = 0;

	  public MyTabBarTextView(Context paramContext)
	  {
	    super(paramContext);
	    init(paramContext);
	  }

	  public MyTabBarTextView(Context paramContext, AttributeSet paramAttributeSet)
	  {
	    super(paramContext, paramAttributeSet);
	    init(paramContext);
	  }

	  public MyTabBarTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
	  {
	    super(paramContext, paramAttributeSet, paramInt);
	  }

	  protected void dispatchDraw(Canvas paramCanvas)
	  {
	    super.dispatchDraw(paramCanvas);
	    Paint localPaint = new Paint();
	    if (this.isVerticalLine)
	    {
	      localPaint.setStyle(Paint.Style.FILL);
	      localPaint.setColor(-3355444);
	      paramCanvas.drawRect(0.0F, 7.0F * this.screen_density, 0.5F * this.screen_density, getHeight() - 7.0F * this.screen_density, localPaint);
	    }
	    switch (this.state)
	    {
	    
	    case GRAY:
	      localPaint.setStyle(Paint.Style.FILL);
	      localPaint.setColor(-3355444);
	      paramCanvas.drawRect(0.0F, getHeight() - 0.5F * this.screen_density, getWidth(), getHeight(), localPaint);
	      break;
	    case GREEN:
	      localPaint.setStyle(Paint.Style.FILL);
	      localPaint.setColor(this.GreenlineColor);
	      paramCanvas.drawRect(0.0F, getHeight() - 3.5F * this.screen_density, getWidth(), getHeight(), localPaint);
	      break;
	    case GREEN_CURSOR:
	      localPaint.setStyle(Paint.Style.FILL);
	      localPaint.setColor(this.GreenlineColor);
	      paramCanvas.drawRect(0.0F, getHeight() - 3.5F * this.screen_density, getWidth(), getHeight(), localPaint);
	      localPaint.setColor(-7829368);
	      paramCanvas.drawRect(getWidth() / 2 - 1.0F * this.screen_density, getHeight() - 5.5F * this.screen_density, getWidth() / 2 + 1.0F * this.screen_density, getHeight() - 3.5F * this.screen_density, localPaint);
	      break;
	    case GRAY_CURSOR:
	      localPaint.setStyle(Paint.Style.FILL);
	      localPaint.setColor(-3355444);
	      paramCanvas.drawRect(0.0F, getHeight() - 3.5F * this.screen_density, getWidth(), getHeight(), localPaint);
	      localPaint.setColor(-7829368);
	      paramCanvas.drawRect(getWidth() / 2 - 1.0F * this.screen_density, getHeight() - 5.5F * this.screen_density, getWidth() / 2 + 1.0F * this.screen_density, getHeight() - 3.5F * this.screen_density, localPaint);
	      break;
	    case CURSOR:
	    	localPaint.setStyle(Paint.Style.FILL);
		    localPaint.setColor(this.GreenlineColor);
		    paramCanvas.drawRect(0.0F, getHeight() - 3.5F * this.screen_density, getWidth() / 2 - 2.5F * this.screen_density, getHeight(), localPaint);
		    localPaint.setColor(-3355444);
		    paramCanvas.drawRect(getWidth() / 2 + 2.5F * this.screen_density, getHeight() - 3.5F * this.screen_density, getWidth(), getHeight(), localPaint);
		    break;
	    default:
	    	break;
	    }
	    
	    localPaint.setColor(-7829368);
	    localPaint.setStrokeWidth(1.0F);
	    localPaint.setAntiAlias(true);
	    Path localPath = new Path();
	    localPath.moveTo(getWidth() / 2, getHeight() - 7.5F * this.screen_density);
	    localPath.lineTo(getWidth() / 2 + 2.5F * this.screen_density, getHeight() - 4.0F * this.screen_density);
	    localPath.lineTo(getWidth() / 2 + 2.5F * this.screen_density, getHeight());
	    localPath.lineTo(getWidth() / 2 - 2.5F * this.screen_density, getHeight());
	    localPath.lineTo(getWidth() / 2 - 2.5F * this.screen_density, getHeight() - 4.0F * this.screen_density);
	    localPath.close();
	    paramCanvas.drawPath(localPath, localPaint);
	  }

	  public void init(Context paramContext)
	  {
	    setGravity(17);
	    setTextColor(-7829368);
	    setBackgroundColor(-1);
	    setTextSize(18.0F);
	    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
	    ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
	    this.screen_density = localDisplayMetrics.density;
	  }

	  protected void onDraw(Canvas paramCanvas)
	  {
	    super.onDraw(paramCanvas);
	  }

	  public void setIsVerticalLine(boolean paramBoolean)
	  {
	    this.isVerticalLine = paramBoolean;
	  }

	  public void setLineState(int paramInt)
	  {
	    this.state = paramInt;
	  }
}
