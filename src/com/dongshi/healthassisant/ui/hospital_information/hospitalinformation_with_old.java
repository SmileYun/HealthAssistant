package com.dongshi.healthassisant.ui.hospital_information;

import java.util.ArrayList;
import java.util.HashMap;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.ui.hospitalregister.ActHospitalChoise;
import com.dongshi.healthassisant.ui.hospitalregister.ActHospitalChoiseDetail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

public class hospitalinformation_with_old extends Activity implements OnClickListener {
	private String[] aboutStrings;
	private GridView listView;
	private TextView textView;
	private TextView navtextView;
	private Context mcContext;
	private TextView textDQ;
	private TextView texthealDzTextView;
	private TextView textheal;
	private TextView texthealNameTextView;
	private int[] imageHas = new int[] { R.drawable.hospital_home1, R.drawable.hospital_home2, R.drawable.hospital_home3 };
	private String[] usaNameStrings = new String[] { "美国约翰.霍普金斯医院", "麻省总医院", "日本国立癌症中心" };
	private ListView listUsa;
	private ImageView healImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		mcContext = this;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.li_hospitalinformation);

		textView = (TextView) findViewById(R.id.title_name);
		textView.setText("国内医院");

		textheal = (TextView) findViewById(R.id.yishengjianjie_hospital);
		texthealDzTextView = (TextView) findViewById(R.id.yishengjianjie_department);

		texthealNameTextView = (TextView) findViewById(R.id.yishengjianjie_hospital);

		navtextView = (TextView) findViewById(R.id.btn_nav);
		navtextView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(mcContext, hospitalinformation_image.class);
				startActivity(intent);
			}
		});
		aboutStrings = new String[] { "405路", "403路", "115路", "234路", "553路", "665路", "705路", "儿童医院专线" };

		listView = (GridView) findViewById(R.id.listview_hosp_text);

		listUsa = (ListView) findViewById(R.id.listViewUsa);

		getDataUsa();
		getData();

		ImageView imageView = (ImageView) findViewById(R.id.more_return_btn);
		imageView.setOnClickListener(this);

		textDQ = (TextView) findViewById(R.id.iv_set);
		textDQ.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i0 = new Intent(mcContext, ActHospitalChoiseDetail.class);
				i0.putExtra("type", ActHospitalChoiseDetail.FIND_DOCTOR_BY_HOPITAL);
				Bundle b = new Bundle();
				b.putString("TAG", "HospitalWith");
				i0.putExtras(b);
				startActivityForResult(i0, 5);
			}
		});
	}

	private void getData() {
		ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();

		for (int j = 0; j < aboutStrings.length; j++) {
			Log.i("kyo", aboutStrings[j]);
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("hospitalinformation_text", aboutStrings[j]);
			listItem.add(map);
			SimpleAdapter listItemAdapter = new SimpleAdapter(this, listItem, R.layout.li_hospitalinformation_with, new String[] { "hospitalinformation_text" },
					new int[] { R.id.hospitalinformation_text });
			listView.setAdapter(listItemAdapter);

		}

	}

	private void getDataUsa() {
		ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();

		for (int j = 0; j < usaNameStrings.length; j++) {
			Log.i("kyo", usaNameStrings[j]);
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("hospitalinformation_image", imageHas[j]);
			map.put("hospitalinformation_text", usaNameStrings[j]);
			listItem.add(map);
			SimpleAdapter listItemAdapter = new SimpleAdapter(this, listItem, R.layout.li_hospitalinformation_usa, new String[] { "hospitalinformation_image",
					"hospitalinformation_text" }, new int[] { R.id.imageUsa, R.id.textUsa });
			listUsa.setAdapter(listItemAdapter);
			listUsa.setOnItemClickListener(new ItemClickListener());
		}

	}

	String city;
	String subcity;

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		Log.i("kyo", requestCode + "      " + resultCode + "");
		if (requestCode == 5 && resultCode == 0) {

			SharedPreferences spPreferences = getSharedPreferences("hospitalwith", Activity.MODE_PRIVATE);
			textDQ.setText("医院导航");
			textheal.setText(spPreferences.getString("hospName", ""));
			texthealDzTextView.setText(spPreferences.getString("hospName", "") + "XXX27号");
		}
	}

	@Override
	public void onClick(View v) {
		finish();
	}

	final class ItemClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

			Intent intent = new Intent(mcContext, hospitalinformation_usa_detail.class);
			HashMap<String, Object> map = (HashMap<String, Object>) parent.getAdapter().getItem(position);
			int imageviewID = (Integer) map.get("hospitalinformation_image");
			Bundle b = new Bundle();
			b.putString("hospitalId", position + "");
			b.putString("hospitalName", ((HashMap<String, Object>) parent.getAdapter().getItem(position)).get("hospitalinformation_text") + "");
			b.putInt("hospitalImage", imageviewID);

			intent.putExtras(b);
			startActivity(intent);
			// /String title = (String) map.get("hospitalinformation_text");
			// int imageviewID = (Integer) map.get("hospitalinformation_image");
			// healImageView = (ImageView) findViewById(R.id.heal_image);
			// TextView textView=(TextView)
			// findViewById(R.id.yishengjianjie_department);
			// healImageView.setImageDrawable(getResources().getDrawable(imageviewID));
			// healImageView.setImageResource(imageviewID);
			// texthealNameTextView.setText(title);
			// textView.setText(title);
		}
	}
}
