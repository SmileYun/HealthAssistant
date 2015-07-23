package com.dongshi.healthassisant.util;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.TextView;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;

@SuppressLint({ "SimpleDateFormat" })
public class DateUtil {

	public static String parseDate(String paramString) {
		try {
			long l1 = new SimpleDateFormat("yyyy-MM-dd").parse(paramString)
					.getTime();
			long l2 = Calendar.getInstance().getTimeInMillis();
			if (l2 - l1 < 86400000L)
				return "今天";
			else if (l2 - l1 < 86400000L + 86400000L)
				return "昨天";
			else if (l2 - l1 >= 172800000L + 86400000L)
				return "前天";

		} catch (Exception localException) {
			localException.printStackTrace();
		}
		return "";
	}
	
	public static String StrDateToStrDate(String paramString)
	  {
	    if (!Tool.isEmpty(paramString))
	    {
	      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	      try
	      {
	    	  Date localDate1 = null;
	        Date localDate2 = localSimpleDateFormat.parse(paramString);
	        localDate1 = localDate2;
	        return localSimpleDateFormat.format(localDate1);
	      }
	      catch (ParseException localParseException)
	      {
	        
	          localParseException.printStackTrace();
	           
	      }
	    }
	    return "";
	  }

}
