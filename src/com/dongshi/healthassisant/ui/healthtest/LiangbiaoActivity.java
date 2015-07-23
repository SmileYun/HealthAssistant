package com.dongshi.healthassisant.ui.healthtest;

import java.util.HashMap;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.ui.BaseActivity_XJ;

public class LiangbiaoActivity extends BaseActivity_XJ {
	// xj_liangbiao_test_show_activity
	private String cardId = "";
	private String id = "";
	private Map<String, Object> jinduqiuData = new HashMap();
	private Map<String, String> pageData = new HashMap();
	private RelativeLayout rl;

	private String title = "";
	private TextView tv1;
	private TextView tv2;
	private TextView tv3;

	private void getData() {

	}

	private void getJinduQiu() {
		// LiangbiaoActivity.this.scale = Double.parseDouble("80");
	}

	public void onCreate(Bundle paramBundle) {
		super.onCreate(paramBundle);
		setContentView(R.layout.xj_liangbiao_test_show_activity);
		Intent localIntent = getIntent();
		this.title = localIntent.getStringExtra("title");
		this.id = localIntent.getStringExtra("testPaperTempleId");
		String str = localIntent.getStringExtra("content");
		((TextView) findViewById(R.id.tv_content)).setText(this
				.formatParagraph(str));
		initTitle(this.title);
		this.tvTitle.setTextSize(14.0F);
		this.rl = ((RelativeLayout) findViewById(R.id.rl_zhuangtai));
		this.rl.setOnClickListener(this);
		this.tv1 = ((TextView) findViewById(R.id.tv1));
		this.tv2 = ((TextView) findViewById(R.id.tv2));
		this.tv3 = ((TextView) findViewById(R.id.tv3));
		// findViewById(R.id.tv_testshow_ruhegoumai).setOnClickListener(this);
	}

	private void iniLayout() {
		this.rl.setVisibility(0);
		String str1 = (String) this.pageData.get("fallDate");
		String str2;
		String str3;
		String str4;
		if ((TextUtils.isEmpty(str1)) || ("null".equals(str1))) {
			str2 = "您还没有进行过" + this.title + "测评";
		} else {
			str2 = "您最近一次测评:(" + str1 + ")";
		}
		str3 = (String) this.pageData.get("zt");
		str4 = "开始测评";
		if ("未使用".equals(str3))
			str4 = "开始测评";
		if ("填写中".equals(str3))
			str4 = "继续测评";
		if ("在分析".equals(str3))
			str4 = "请等待...";
		if ("已出报告".equals(str3))
			str4 = "查看报告";
		String str5 = "";
		if ((!TextUtils.isEmpty(str3)) && (!"null".equals(str3))) {
			str5 = "状态:" + str3;
		}
		this.tv1.setText(str2);
		this.tv2.setText(str5);
		this.tv3.setText(str4);
	}

	public void onResume() {
		super.onResume();
		getJinduQiu();
		iniLayout();
	}

	public void onClick(View paramView) {
		super.onClick(paramView);
		if (paramView.getId() == R.id.rl_zhuangtai) {
			String str1 = this.tv2.getText().toString().trim();
			String str2 = (String) this.pageData.get("qid");

			if ("状态:已出报告".equals(str1)) {
				// Intent localIntent1 = new Intent(this,
				// LiangbiaoReportInfoTabActivity.class);
				// localIntent1.putExtra("testName", this.title);
				// localIntent1.putExtra("qid", str2);
				// startActivity(localIntent1);
			} else if ("状态:在分析".equals(str1)) {
				Toast.makeText(LiangbiaoActivity.this, "正在分析", 0).show();

			} else {
				Intent localIntent2 = new Intent(this, TestTabActivity.class);
				localIntent2.putExtra("cardId", this.cardId);
				localIntent2.putExtra("qid", str2);
				localIntent2.putExtra("testPaperTempleId", this.id);
				startActivity(localIntent2);
			}
		}
	}

	public static String formatParagraph(String paramString) {
		if (paramString != null)
			return "　　" + paramString.trim();
		return "";
	}
}
