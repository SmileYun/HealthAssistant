package com.dongshi.healthassisant.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dongshi.healthassisant.R;

public class AdapterPersonResult extends AdapterBase {
	
	public AdapterPersonResult(Context context, ArrayList<HashMap<String, Object>> mList) {
		super(context, mList);
		right.setDuration(200);
		right.setInterpolator(new DecelerateInterpolator());
		right.setFillAfter(true);
		down.setDuration(200);
		down.setFillAfter(true);
		down.setInterpolator(new DecelerateInterpolator());
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder vh;
		if (convertView == null) {
			vh = new ViewHolder();
			convertView = getLayoutInflater().inflate(R.layout.act_personal_result_item, parent, false);
			vh.itemLayout = (RelativeLayout) convertView.findViewById(R.id.ccr_person_result_item);
			vh.rightArrow = (ImageView) convertView.findViewById(R.id.person_result_right_arrow);
			vh.stubDetail = convertView.findViewById(R.id.vs_detail_operations);
			vh.tvResultType = (TextView) convertView.findViewById(R.id.person_result_type);
			
			convertView.setTag(vh);
		}else {
			vh = (ViewHolder) convertView.getTag();
		}
		
		vh.tvResultType.setText(mList.get(position).get("type") + "");
		
		final int p = position;
		vh.itemLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(vh.stubDetail.getVisibility() == View.GONE){
					if (vh.stubDetail instanceof ViewStub) {
						vh.stubDetail = ((ViewStub)vh.stubDetail).inflate();
						vh.tvExamType = (TextView) vh.stubDetail.findViewById(R.id.ccvs_item_exam_type);
						vh.vsTitle = (TextView) vh.stubDetail.findViewById(R.id.ccvs_item_title);
						vh.tvExamResult = (TextView) vh.stubDetail.findViewById(R.id.ccvs_item_exam_result);
						
						vh.vsTitle.setText(mList.get(p).get("exam") + "");
						vh.tvExamType.setText(mList.get(p).get("examtype") + "");
						vh.tvExamResult.setText(mList.get(p).get("examresult") + "");
					}
					
					vh.stubDetail.setVisibility(View.VISIBLE);
					vh.rightArrow.startAnimation(right);
					
				}else {
					vh.stubDetail.setVisibility(View.GONE);
					vh.rightArrow.startAnimation(down);
				}
			}
		});
		
		return convertView;
	}

	private RotateAnimation right = new RotateAnimation(0, 90, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
	private RotateAnimation down = new RotateAnimation(90, 0, RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
	
	
	final class ViewHolder{
		RelativeLayout itemLayout;//
		ImageView rightArrow;//person_result_right_arrow
		View stubDetail;//vs_detail_operations
		TextView vsTitle, tvResultType, tvExamType, tvExamResult;//ccvs_item_title, "person_result_type", ccvs_item_exam_type£¬ ccvs_item_exam_result
	}
}
