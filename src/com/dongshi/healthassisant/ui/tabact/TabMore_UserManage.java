package com.dongshi.healthassisant.ui.tabact;

import java.util.ArrayList;
import java.util.HashMap;
import com.dongshi.healthassisant.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import android.widget.SimpleAdapter;
import android.widget.TextView;

public class TabMore_UserManage extends Activity implements
		OnGlobalLayoutListener {
	private ListView listView;
	private TextView textView;
	private LinearLayout linearLayout;
	private ImageView imageView;
	boolean isFirst = true;
	private Context mContext;
	private ImageView addImageView;

	private String userManageEditText = "80445770";
	private String nameEditText = "杨巧";
	private String happyEditText = "1985-06-20";
	private String poneEditText = "18716402020";
	private String[] userStrings;
	private ArrayList<String[]> userlist = new ArrayList<String[]>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		mContext = this;
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.more_ui_user);
		userStrings = new String[] { userManageEditText, "儿子",nameEditText,"男",
				happyEditText, poneEditText,"111111","111111" };
		userlist.add(userStrings);

		listView = (ListView) findViewById(R.id.more_listView);
		textView = (TextView) findViewById(R.id.more_listview_no_data);
		linearLayout = (LinearLayout) findViewById(R.id.more_linear);
		linearLayout.getViewTreeObserver().addOnGlobalLayoutListener(this);

		imageView = (ImageView) findViewById(R.id.more_return_btn);
		imageView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(mContext, TabMore.class);
				startActivity(intent);

			}
		});

		addImageView = (ImageView) findViewById(R.id.btn_additem);
		addImageView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(mContext,
						TabMore_AddUserManage.class);
				startActivityForResult(intent, 2);

			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Log.i("kyo", requestCode + "   " + resultCode);
		if (requestCode == 2 && resultCode == 2) {
			userlist.add(data.getStringArrayExtra("data"));

			getData();
		}

	}

	private void getData() {
		ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String, Object>>();

        for (String[] anUserlist : userlist) {

            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemText1", anUserlist[1]);
            map.put("ItemText2", anUserlist[2]);
            map.put("ItemText3", anUserlist[5]);
            map.put("ItemText4", anUserlist[4]);
            map.put("iamge1", R.drawable.pone);
            listItem.add(map);
            SimpleAdapter listItemAdapter = new SimpleAdapter(this, listItem,
                    R.layout.more_ui_listview_item, new String[]{"ItemText1",
                    "ItemText2", "ItemText3", "ItemText4", "iamge1"},
                    new int[]{R.id.more_text1, R.id.more_text2,
                            R.id.more_text3, R.id.more_text4, R.id.more_image}
            );
            listView.setAdapter(listItemAdapter);
        }

	}

	@Override
	public void onGlobalLayout() {

		if (isFirst) {
			isFirst = false;
			// TODO listview换成对象 判读对象是否为空 为空 显示text提示添加 否则 绑定对象
			if (listView == null) {
				Log.i("kyo", "listView==null");
				textView.setVisibility(View.VISIBLE);
			} else {

				Log.i("kyo", "listView!=null");
				getData();
			}
		}

	}

}
