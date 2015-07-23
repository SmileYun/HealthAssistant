package com.dongshi.healthassisant.widget;

import com.dongshi.healthassisant.R;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;

public class ClearEditText extends EditText
implements View.OnFocusChangeListener, TextWatcher
{
	private boolean hasFoucs;
	  private Drawable mClearDrawable;

	  public ClearEditText(Context paramContext)
	  {
	    this(paramContext, null);
	  }

	  public ClearEditText(Context paramContext, AttributeSet paramAttributeSet)
	  {
	    this(paramContext, paramAttributeSet, 16842862);
	  }

	  public ClearEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
	  {
	    super(paramContext, paramAttributeSet, paramInt);
	    init();
	  }

	  private void init()
	  {
	    this.mClearDrawable = getCompoundDrawables()[2];
	    if (this.mClearDrawable == null)
	      this.mClearDrawable = getResources().getDrawable(R.drawable.search_clear_pressed);
	    this.mClearDrawable.setBounds(0, 0, this.mClearDrawable.getIntrinsicWidth(), this.mClearDrawable.getIntrinsicHeight());
	    setClearIconVisible(false);
	    setOnFocusChangeListener(this);
	    addTextChangedListener(this);
	  }

	  public static Animation shakeAnimation(int paramInt)
	  {
	    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 10.0F, 0.0F, 0.0F);
	    localTranslateAnimation.setInterpolator(new CycleInterpolator(paramInt));
	    localTranslateAnimation.setDuration(1000L);
	    return localTranslateAnimation;
	  }

	  public void afterTextChanged(Editable paramEditable)
	  {
	  }

	  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
	  {
	  }

	  public void onFocusChange(View paramView, boolean paramBoolean)
	  {
	    this.hasFoucs = paramBoolean;
	    if (paramBoolean)
	    {
	      int i = getText().length();
	      boolean bool = false;
	      if (i > 0)
	        bool = true;
	      setClearIconVisible(bool);
	      return;
	    }
	    setClearIconVisible(false);
	  }

	  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
	  {
	    if (this.hasFoucs)
	      if (paramCharSequence.length() <= 0)
	    	  setClearIconVisible(true);
	      else
	    	  setClearIconVisible(false);
	        
	  }

	  public boolean onTouchEvent(MotionEvent paramMotionEvent)
	  {
	    int i = 1;
	    if ((paramMotionEvent.getAction() == i) && (getCompoundDrawables()[2] != null))
	      if ((paramMotionEvent.getX() <= getWidth() - getTotalPaddingRight()) || (paramMotionEvent.getX() >= getWidth() - getPaddingRight()))
	    	  i = 0;
	    if (i != 0)
	        setText("");
	      return super.onTouchEvent(paramMotionEvent);
	     
	  }

	  protected void setClearIconVisible(boolean paramBoolean)
	  {
		  if (paramBoolean)
			{
				Drawable localDrawable = this.mClearDrawable;
				if(localDrawable!=null){
				setCompoundDrawables(getCompoundDrawables()[0],
						getCompoundDrawables()[1], localDrawable,
						getCompoundDrawables()[3]);
				}
						
			}
	  }

	  public void setShakeAnimation()
	  {
	    setAnimation(shakeAnimation(5));
	  }
}
