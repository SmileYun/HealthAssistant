package com.dongshi.healthassisant.ui.alarm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.ui.BaseActivity_XJ;
import com.dongshi.healthassisant.ui.alarm.wheelview.ArrayWheelAdapter;
import com.dongshi.healthassisant.ui.alarm.wheelview.WheelView;

public class AlarmSettingActivity extends BaseActivity_XJ {
	private WheelView clockadd_hour = null;

	private WheelView clockadd_minutes = null;
	
	ImageButton imgbtnalarmtypeset=null;
	ImageButton imgbtnalarmringset=null;
	
	private RadioOnClick radioOnClick = new RadioOnClick(1); 
	private RadioRingOnClick radioRingOnClick=new RadioRingOnClick(0);
	private ListView areaRadioListView;  
	private ListView ringRadioListView;  
	
	private String[] areas = new String[]{"’Ò∂Ø","¡Â…˘", "’Ò∂Ø+¡Â…˘"};
	private String[] rings = new String[]{"Morning flower alarm","Bee Bee Bee", "Gua Gua"};
	 private boolean[] areaState=new boolean[]{true,false, false};
	 
	public TextView txtalarmringtype=null;
	public TextView txtalarmringcontent=null;
	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.xj_alarmsettingactivity);
		initTitle("Ω–∫≈Ã·–—…Ë÷√");
		findView();
		initiWheelView();
		
		this.imgbtnalarmtypeset=(ImageButton) findViewById(R.id.imgbtnalarmtypeset);
		this.imgbtnalarmtypeset.setOnClickListener(this);
		this.imgbtnalarmringset=(ImageButton) findViewById(R.id.imgbtnalarmringset);
		this.imgbtnalarmringset.setOnClickListener(this);
		
	}

	private void findView() { 
		clockadd_hour = (WheelView) findViewById(R.id.clockadd_hour);
		clockadd_minutes = (WheelView) findViewById(R.id.clockadd_minutes);
	}
	
	 private void initiWheelView()
	    {
	        String[] mins = getResources().getStringArray(
	                R.array.clockadd_mins_array);
	        
	        String[] hour = getResources().getStringArray(R.array.clockadd_hour_array);

	        clockadd_minutes.setAdapter(new ArrayWheelAdapter<String>(mins));
	        clockadd_minutes.setVisibleItems(7);
	        clockadd_minutes.setCyclic(true);
	        clockadd_minutes.setCurrentItem(new Date().getMinutes());

	        clockadd_hour.setAdapter(new ArrayWheelAdapter<String>(hour));
	        clockadd_hour.setVisibleItems(7);
	        clockadd_hour.setCyclic(true);
	        clockadd_hour.setCurrentItem(new Date().getHours());
	    }
	 
	 public void onClick(View paramView)
	  {
	    super.onClick(paramView);
	    if (paramView.getId()==R.id.imgbtnalarmtypeset)
	    {
	    	AlertDialog ad =new AlertDialog.Builder(AlarmSettingActivity.this).setTitle("—°‘Òƒ÷÷”¿‡–Õ")  
	    			   .setSingleChoiceItems(areas,radioOnClick.getIndex(),radioOnClick).create();  
	    			   areaRadioListView=ad.getListView();  
	    			   ad.show(); 
	    }
	    else if(paramView.getId()==R.id.imgbtnalarmringset)
	    {
	    	AlertDialog ad =new AlertDialog.Builder(AlarmSettingActivity.this).setTitle("—°‘Ò¡Â…˘")  
	    			   .setSingleChoiceItems(rings,radioRingOnClick.getIndex(),radioRingOnClick).create();  
	    	ringRadioListView=ad.getListView();  
	    			   ad.show(); 
	    }
	  }
	 
	 
	 public String[] getRingtoneTitleList(){ 

		    List<String> resArr = new ArrayList<String>(); 

		    RingtoneManager manager = new RingtoneManager(AlarmSettingActivity.this); 

		    manager.setType(RingtoneManager.TYPE_ALARM); 

		    Cursor cursor = manager.getCursor(); 

		    if(cursor.moveToFirst()){ 

		        do{ 

		            resArr.add(cursor.getString(RingtoneManager.TITLE_COLUMN_INDEX)); 

		        }while(cursor.moveToNext()); 

		    } 
		    String[] strings = new String[resArr.size()];
		    return resArr.toArray(strings); 

		}  
	  
	     
	   class RadioOnClick implements DialogInterface.OnClickListener{  
	  private int index;  
	  
	  public RadioOnClick(int index){  
	   this.index = index;  
	  }  
	  public void setIndex(int index){  
	   this.index=index;  
	  }  
	  public int getIndex(){  
	   return index;  
	  }  
	  
	  public void onClick(DialogInterface dialog, int whichButton){  
	    setIndex(whichButton); 
	    txtalarmringtype=(TextView) findViewById(R.id.txtalarmringtype);
	    txtalarmringtype.setText(areas[index]);
	     
	    Toast.makeText(AlarmSettingActivity.this, "ƒ˙—°‘Ò¡À£∫ "+ areas[index], Toast.LENGTH_LONG).show();  
	    dialog.dismiss();  
	  }  
	 } 
	   
	   class RadioRingOnClick implements DialogInterface.OnClickListener{  
			  private int index;  
			  
			  public RadioRingOnClick(int index){  
			   this.index = index;  
			  }  
			  public void setIndex(int index){  
			   this.index=index;  
			  }  
			  public int getIndex(){  
			   return index;  
			  }  
			  
			  public void onClick(DialogInterface dialog, int whichButton){  
			    setIndex(whichButton); 
			    txtalarmringcontent=(TextView) findViewById(R.id.txtalarmringcontent);
			    txtalarmringcontent.setText(rings[index]);
			     
			    Toast.makeText(AlarmSettingActivity.this, "ƒ˙—°‘Ò¡À£∫ "+ rings[index], Toast.LENGTH_LONG).show();  
			    dialog.dismiss();  
			  }  
			 } 
}
