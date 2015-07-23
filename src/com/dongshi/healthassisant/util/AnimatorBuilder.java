package com.dongshi.healthassisant.util;

import android.R.integer;
import android.view.animation.CycleInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.Transformation;
import android.widget.ImageView;

public class AnimatorBuilder {

	/**
	 * Repeat the animation indefinitely.
	 */
	public static final int INFINITE = -1;

	/**
	 * When the animation reaches the end and the repeat count is INFINTE_REPEAT
	 * or a positive value, the animation restarts from the beginning.
	 */
	public static final int RESTART = 1;

	/**
	 * When the animation reaches the end and the repeat count is INFINTE_REPEAT
	 * or a positive value, the animation plays backward (and then forward
	 * again).
	 */
	public static final int REVERSE = 2;

	/**
	 * Can be used as the start time to indicate the start time should be the
	 * current time when {@link #getTransformation(long, Transformation)} is
	 * invoked for the first animation frame. This can is useful for short
	 * animations.
	 */
	public static final int START_ON_FIRST_FRAME = -1;

	/**
	 * The specified dimension is an absolute number of pixels.
	 */
	public static final int ABSOLUTE = 0;

	/**
	 * The specified dimension holds a float and should be multiplied by the
	 * height or width of the object being animated.
	 */
	public static final int RELATIVE_TO_SELF = 1;

	/**
	 * The specified dimension holds a float and should be multiplied by the
	 * height or width of the parent of the object being animated.
	 */
	public static final int RELATIVE_TO_PARENT = 2;
	
	public static RotateAnimation createRotationAnimator(float fromDegrees, float toDegrees, int pivotXType, float pivotXValue,
            int pivotYType, float pivotYValue){
		RotateAnimation _r = new RotateAnimation(fromDegrees, toDegrees, pivotXType, pivotXValue, pivotYType, pivotYValue);
		_r.setDuration(200);
		_r.setFillAfter(true);
		_r.setFillEnabled(true);
		_r.setRepeatMode(RotateAnimation.REVERSE);
		_r.setRepeatCount(0/*RotateAnimation.INFINITE*/);
//		_r.setInterpolator(new CycleInterpolator(1));
		_r.setInterpolator(new LinearInterpolator());
		return _r;
	}
}

/*
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.view.animation.CycleInterpolator;
import android.widget.ImageView;


public class AnimatorBuilder {
	
	public AnimatorBuilder() {

	}
	
	public static ObjectAnimator createRotationAnimator(ImageView target, float... values){
		ObjectAnimator _ob = ObjectAnimator.ofFloat(target, "rotation", values);
		_ob.setDuration(3000);
		_ob.setPropertyName("rotation");
		_ob.setRepeatCount(ObjectAnimator.INFINITE);
		_ob.setRepeatMode(ObjectAnimator.RESTART);
		CycleInterpolator c =  new CycleInterpolator(1.0f);
		_ob.setInterpolator((TimeInterpolator) c);
		
		return _ob;
	}
	
}
*/