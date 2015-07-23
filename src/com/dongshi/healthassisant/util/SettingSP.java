package com.dongshi.healthassisant.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.view.Display;
import android.util.DisplayMetrics;
import android.app.Activity;

public class SettingSP {
	public static void clearData(Context paramContext)
	  {
	    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("setting", 0).edit();
	    localEditor.clear();
	    localEditor.commit();
	  }

	  public static float density(Context paramContext)
	  {
	    return paramContext.getSharedPreferences("setting", 0).getFloat("screen_density", 2.0F);
	  }

	  public static int getDictionaryVersionCode(Context paramContext)
	  {
	    return paramContext.getSharedPreferences("setting", 0).getInt("dictionaryversioncode", 0);
	  }

	  public static String getFoodLastRefreshDate(Context paramContext)
	  {
	    return paramContext.getSharedPreferences("setting", 0).getString("FoodLastRefreshDate", "1970-01-01 01:01:01");
	  }

	  public static boolean getIsDaiBan(Context paramContext)
	  {
	    return paramContext.getSharedPreferences("setting", 0).getBoolean("isDaiBan", true);
	  }

	  public static boolean getIsFirst(Context paramContext)
	  {
	    return paramContext.getSharedPreferences("setting", 0).getBoolean("isFirst", true);
	  }

	  public static boolean getIsRunInBack(Context paramContext)
	  {
	    return paramContext.getSharedPreferences("setting", 0).getBoolean("isStart", false);
	  }

	  public static boolean getIsTongZhi(Context paramContext)
	  {
	    return paramContext.getSharedPreferences("setting", 0).getBoolean("isTongZhi", true);
	  }

	  public static boolean getIsVibration(Context paramContext)
	  {
	    return paramContext.getSharedPreferences("setting", 0).getBoolean("isVibration", true);
	  }

	  public static boolean getIsZiXun(Context paramContext)
	  {
	    return paramContext.getSharedPreferences("setting", 0).getBoolean("isZiXun", true);
	  }

	  public static float screenHeight(Context paramContext)
	  {
	    return paramContext.getSharedPreferences("setting", 0).getFloat("screen_height", 800.0F);
	  }

	  public static float screenWidth(Context paramContext)
	  {
	    return paramContext.getSharedPreferences("setting", 0).getFloat("screen_width", 480.0F);
	  }

	  public static void setDictionaryVersionCode(int paramInt, Context paramContext)
	  {
	    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("setting", 0).edit();
	    localEditor.putInt("dictionaryversioncode", paramInt);
	    localEditor.commit();
	  }

	  public static void setFoodLastRefreshDate(String paramString, Context paramContext)
	  {
	    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("setting", 0).edit();
	    localEditor.putString("FoodLastRefreshDate", paramString);
	    localEditor.commit();
	  }

	  public static void setIsDaiBan(boolean paramBoolean, Context paramContext)
	  {
	    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("setting", 0).edit();
	    localEditor.putBoolean("isDaiBan", paramBoolean);
	    localEditor.commit();
	  }

	  public static void setIsFirst(boolean paramBoolean, Context paramContext)
	  {
	    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("setting", 0).edit();
	    localEditor.putBoolean("isFirst", paramBoolean);
	    localEditor.commit();
	  }

	  public static void setIsRunInBack(boolean paramBoolean, Context paramContext)
	  {
	    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("setting", 0).edit();
	    localEditor.putBoolean("isStart", paramBoolean);
	    localEditor.commit();
	  }

	  public static void setIsTongZhi(boolean paramBoolean, Context paramContext)
	  {
	    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("setting", 0).edit();
	    localEditor.putBoolean("isTongZhi", paramBoolean);
	    localEditor.commit();
	  }

	  public static void setIsVibration(boolean paramBoolean, Context paramContext)
	  {
	    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("setting", 0).edit();
	    localEditor.putBoolean("isVibration", paramBoolean);
	    localEditor.commit();
	  }

	  public static void setIsZiXun(boolean paramBoolean, Context paramContext)
	  {
	    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("setting", 0).edit();
	    localEditor.putBoolean("isZiXun", paramBoolean);
	    localEditor.commit();
	  }

	  public static void setScreenDensity(float paramFloat, Context paramContext)
	  {
	    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("setting", 0).edit();
	    localEditor.putFloat("screen_density", paramFloat);
	    localEditor.commit();
	  }

	  public static void setScreenHeight(float paramFloat, Context paramContext)
	  {
	    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("setting", 0).edit();
	    localEditor.putFloat("screen_height", paramFloat);
	    localEditor.commit();
	  }

	  public static void setScreenWidth(float paramFloat, Context paramContext)
	  {
	    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("setting", 0).edit();
	    localEditor.putFloat("screen_width", paramFloat);
	    localEditor.commit();
	  }
}
