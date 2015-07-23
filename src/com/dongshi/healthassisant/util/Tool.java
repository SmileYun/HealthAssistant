package com.dongshi.healthassisant.util;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

public class Tool {

	 public static void Jump(Context paramContext, Class<?> paramClass)
	  {
	    paramContext.startActivity(new Intent(paramContext, paramClass));
	  }
	  public static String getTvString(TextView paramTextView)
	  {
	    return paramTextView.getText().toString().trim();
	  }
	  public static void Toast(Context paramContext)
	  {
	    Toast.makeText(paramContext, "请将资料填写完整", 0).show();
	  }

	  public static void Toast(Context paramContext, String paramString)
	  {
	    if (!isEmpty(paramString))
	      Toast.makeText(paramContext, paramString, 0).show();
	  }
	  public static boolean isEmpty(String paramString)
	  {
	    return (TextUtils.isEmpty(paramString)) || ("null".equals(paramString));
	  }
}
