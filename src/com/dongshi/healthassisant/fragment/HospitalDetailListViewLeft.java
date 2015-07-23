package com.dongshi.healthassisant.fragment;

import java.util.ArrayList;
import java.util.HashMap;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.adapter.AdapterBase;
import com.dongshi.healthassisant.adapter.AdapterText;
import com.dongshi.healthassisant.ui.MyBaseActivity;

import android.R.anim;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

/**
 * @author YUN
 */
public class HospitalDetailListViewLeft extends Fragment {
	private ListView mListView;
	private AdapterBase mAdapter;
	private View title;
	private ArrayList<HashMap<String, Object>> mList;

	public HospitalDetailListViewLeft(ArrayList<HashMap<String, Object>> mList) {
		super();
		this.mList = mList;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_hospital_detail_listviewleft, container, false);
		title = view.findViewById(R.id.fragment_hospleft_listview_title);

		mListView = (ListView) view.findViewById(R.id.listview_hospital_fragment_left);
		mListView.setOnScrollListener(scrollerLinstener);
		mAdapter = new AdapterText(getActivity(), mList);
		mListView.setAdapter(mAdapter);
		mListView.setOnItemClickListener(itemClickListener);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onStart() {
		super.onStart();
		mListView.setItemChecked(AdapterText.mCurrentSelectedItem, true);
		
		((TextView) title.findViewById(R.id.generaltext)).setText(""
				+ (CharSequence) ((HashMap<String, Object>) mList.get(AdapterText.mCurrentSelectedItem)).get("text"));
		onSelectedListener.onItemClicked((HashMap<String, Object>) mList.get(AdapterText.mCurrentSelectedItem));
	}

	public void setDataList(ArrayList<HashMap<String, Object>> list) {
		this.mList = list;
		mAdapter.notifyDataSetChanged();
	}

	OnItemClickListener itemClickListener = new OnItemClickListener() {

		@SuppressWarnings("unchecked")
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			mCurrSelected = position;
			AdapterText.mCurrentSelectedItem = position;
			((TextView) title.findViewById(R.id.generaltext)).setText("" + (CharSequence) ((HashMap<String, Object>) parent.getAdapter().getItem(position)).get("text"));
			mListView.setItemChecked(AdapterText.mCurrentSelectedItem, true);
			if (onSelectedListener != null)
				onSelectedListener.onItemClicked(parent.getAdapter().getItem(position));
		}
	};

	int mCurrSelected = 0;
	OnScrollListener scrollerLinstener = new OnScrollListener() {

		@Override
		public void onScrollStateChanged(AbsListView view, int scrollState) {

		}

		@Override
		public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
			if (firstVisibleItem >= AdapterText.mCurrentSelectedItem) {
				title.setVisibility(View.VISIBLE);
			} else {
				title.setVisibility(View.GONE);
			}
		}
	};

	private onLeftFragmentOnSelectedListener onSelectedListener;

	public void setOnSelectedListener(onLeftFragmentOnSelectedListener onSelectedListener) {
		this.onSelectedListener = onSelectedListener;
	}

	public interface onLeftFragmentOnSelectedListener {

		/**
		 * @param item  HashMap<{@code String, Object}>
		 */
		public void onItemClicked(Object item);
	}
}
