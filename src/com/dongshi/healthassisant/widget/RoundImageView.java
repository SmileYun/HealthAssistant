package com.dongshi.healthassisant.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;

public class RoundImageView extends ImageView {

	private final Paint maskPaint = new Paint();
	  private float rect_adius = 6.0F;
	  private final RectF roundRect = new RectF();
	  private final Paint zonePaint = new Paint();

	  public RoundImageView(Context paramContext)
	  {
	    super(paramContext);
	    init();
	  }

	  public RoundImageView(Context paramContext, AttributeSet paramAttributeSet)
	  {
	    super(paramContext, paramAttributeSet);
	    init();
	  }

	  private void init()
	  {
	    this.maskPaint.setAntiAlias(true);
	    this.maskPaint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
	    this.zonePaint.setAntiAlias(true);
	    this.zonePaint.setColor(-1);
	    this.rect_adius = (getResources().getDisplayMetrics().density * this.rect_adius);
	  }

	  public void draw(Canvas paramCanvas)
	  {
	    paramCanvas.saveLayer(this.roundRect, this.zonePaint, 31);
	    paramCanvas.drawRoundRect(this.roundRect, this.rect_adius, this.rect_adius, this.zonePaint);
	    paramCanvas.saveLayer(this.roundRect, this.maskPaint, 31);
	    super.draw(paramCanvas);
	    paramCanvas.restore();
	  }

	  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
	  {
	    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
	    int i = getWidth();
	    int j = getHeight();
	    this.roundRect.set(0.0F, 0.0F, i, j);
	  }

	  public void setRectAdius(float paramFloat)
	  {
	    this.rect_adius = paramFloat;
	    invalidate();
	  }
}
