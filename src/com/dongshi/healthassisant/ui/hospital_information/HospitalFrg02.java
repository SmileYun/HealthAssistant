package com.dongshi.healthassisant.ui.hospital_information;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.ui.hospital_information.hospitalinformation_with_old.ItemClickListener;
import com.dongshi.healthassisant.ui.hospitalregister.ActHospitalChoiseDetail;
/**
 * 
 * @author YUN
 */
public class HospitalFrg02 extends Fragment implements OnClickListener {
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
	private ListView listUsa;
	private ImageView healImageView;
	
	private TextView textSwicher;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_hospital_info_frg02, container, false);
		navtextView = (TextView) v.findViewById(R.id.btn_nav);
		navtextView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), hospitalinformation_image.class);
				startActivity(intent);
			}
		});
		aboutStrings = new String[] { "405路", "403路", "115路", "234路", "553路", "665路", "705路", "儿童医院专线" };
		listUsa = (ListView) v.findViewById(R.id.listViewUsa);
		listView = (GridView) v.findViewById(R.id.listview_hosp_text);
		getData();
		textheal = (TextView) v.findViewById(R.id.yishengjianjie_hospital);
		texthealDzTextView = (TextView) v.findViewById(R.id.yishengjianjie_department);
		textSwicher = (TextView) v.findViewById(R.id.fragment_hospital_info_right_swicher);
		textSwicher.setOnClickListener(this);
		return v;
	}
	
	private void getData() {
		ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();

		for (int j = 0; j < aboutStrings.length; j++) {
			Log.i("kyo", aboutStrings[j]);
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("hospitalinformation_text", aboutStrings[j]);
			listItem.add(map);
			SimpleAdapter listItemAdapter = new SimpleAdapter(getActivity(), listItem, R.layout.li_hospitalinformation_with, new String[] { "hospitalinformation_text" },
					new int[] { R.id.hospitalinformation_text });
			listView.setAdapter(listItemAdapter);
		}
	}
	
	public void update(Bundle b){
		textheal.setText(b.getString("hospName"));
		texthealDzTextView.setText(b.getString("hospName2") + "XXX27号");
	}

	@Override
	public void onClick(View v) {
		if(v == textSwicher){
			Intent i0 = new Intent(getActivity(), ActHospitalChoiseDetail.class);
			i0.putExtra("type", ActHospitalChoiseDetail.FIND_DOCTOR_BY_HOPITAL);
			Bundle b = new Bundle();
			b.putString("TAG", "HospitalWith");
			i0.putExtras(b);
			startActivityForResult(i0, 5);
		}
	}
}
