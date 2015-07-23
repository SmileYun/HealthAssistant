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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.ui.hospital_information.hospitalinformation_with_old.ItemClickListener;
/**
 * 
 * @author YUN
 */
public class HospitalFrg01 extends Fragment {
	private int[] imageHas = new int[] { R.drawable.hospital_home1, R.drawable.hospital_home2, R.drawable.hospital_home3 };
	private String[] usaNameStrings = new String[] { "美国约翰.霍普金斯医院", "麻省总医院", "日本国立癌症中心" };
	private ListView listUsa;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = getActivity().getLayoutInflater().inflate(R.layout.fragment_hospital_info_frg01, container, false);
		listUsa = (ListView) v.findViewById(R.id.listViewUsa);
		getDataUsa();
		return v;
	}

	private void getDataUsa() {
		ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();
		String[] s = getResources().getStringArray(R.array.hospital_introduce_detail);
		for (int j = 0; j < usaNameStrings.length; j++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("hospitalinformation_image", imageHas[j]);
			map.put("hospitalinformation_text", usaNameStrings[j]);
			map.put("hospitalinformation_content", s[j]);
			listItem.add(map);
			SimpleAdapter listItemAdapter = new SimpleAdapter(getActivity(), listItem, R.layout.li_hospitalinformation_usa, 
					new String[] { "hospitalinformation_image", "hospitalinformation_text", "hospitalinformation_content"},
					new int[] { R.id.imageUsa, R.id.textUsa , R.id.textUsaDetail });
			listUsa.setAdapter(listItemAdapter);
			listUsa.setOnItemClickListener(new ItemClickListener());
		}

	}

	final class ItemClickListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

			Intent intent = new Intent(getActivity(), hospitalinformation_usa_detail.class);
			HashMap<String, Object> map = (HashMap<String, Object>) parent.getAdapter().getItem(position);
			int imageviewID = (Integer) map.get("hospitalinformation_image");
			Bundle b = new Bundle();
			b.putString("hospitalId", position + "");
			b.putString("hospitalName", ((HashMap<String, Object>) parent.getAdapter().getItem(position)).get("hospitalinformation_text") + "");
			b.putInt("hospitalImage", imageviewID);

			intent.putExtras(b);
			startActivity(intent);
		}
	}
}
