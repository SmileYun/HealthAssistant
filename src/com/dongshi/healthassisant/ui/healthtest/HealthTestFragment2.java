package com.dongshi.healthassisant.ui.healthtest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.dongshi.healthassisant.R;
import com.dongshi.healthassisant.fragment.BaseFragment_XJ;

public class HealthTestFragment2 extends BaseFragment_XJ {

	private List<Map<String, String>> listDatas = new ArrayList();
	
	@Override
	public int initData() {
		String[] arrayOfString1 = { "���������������[20��]\n(��Դ��:�л�ҽѧ�ὡ���Բ�����)", "��ɭ˹ʧ������ [8��]", "WHO���������ⶨ����[103��] ", "����������SF36��[36��] ", "��ҽ����60��[60��] " };
	    String[] arrayOfString2 = { "��������Բ��ʾ������л�ҽѧ�ὡ������ѧ�ֻ���֯�ϰ�λ��ҵר�ң���ʱ��ʮ����ɡ����ʾ�����ִ���ά�Ƚ�������ͽ�������ָ����ϵ����ѧϰ����˹��ҡ�ʮһ�塱����ʮ���塱���п�����о��ɹ��γɵġ���������Բ��ʾ��ǽ������������Ҫ����֮һ��ͨ�����ʾ����Ի�ȡ��д�ߵĻ���������Ϣ�����ݣ�Ϊ�����Ľ��������͸��廯������������ṩ��Ҫ������", "��ɭ˹(Athens��AIS)ʧ�������ǹ��ʹ��ϵġ���Ҫ������������˯������������˯���ϰ������������ǻ������ٴ�ҽʦ����˯��������е������������ٴ�ҽʦ���ڻ��ߵ�֢״�ص㡢�й�����������Ͷർ˯��ͼ����������ۺϷ�����ͨ���ܹ������������˯���ϰ������Ƚ�׼ȷ���ж�����ࡣ�����й�������������ܹ����˯���ϰ����������ݣ������ڷ���˯�����ҵĳ̶Ⱥ���������Ч������ɭ˹ʧ����������ٴ����õ�˯���ϰ�����������֮һ��", "����������֯�뽡���й����������ⶨ����(WHOQOL)��������������֯���Ƶġ����ڲ��������뽡���йص����������Ĺ��������� �����������нϺõ��Ŷȡ�Ч�ȡ���Ӧ�ȵ��������ѧ����,���Ҿ��й��ʿɱ���,����ͬ�Ļ������²ⶨ�����������÷־��пɱ��ԡ�", "��������ҽѧ���о�(Medical Outcomes Study�� MOS)�鿪����һ�������Բⶨ�����ù�����ʼ��80������ڣ��γ��˲�ͬ��Ŀ��ͬ���Ա����Ķ��ְ汾��1990��1992�꣬����36����Ŀ�Ľ��������ʾ�򻯰�SF-36�Ĳ�ͬ���ְ汾����������������õý϶����Ӣ����չ���������׼������İ棬���������幦�ܡ������ɫ(role-physical)��������ʹ���ܵĽ���״��������(vitality)����Ṧ�ܡ�������ɫ(role-emotional)������������8������", "���ʾ��Ǹ��ݡ���ҽ���ʷ������ж����������ж���׼�з����ɣ������ҹ���һ��ָ���͹淶��ҽ�����о���Ӧ���ļ���ּ��Ϊ���ʱ�ʶ������ҽ������ؼ����ķ��Ρ��������������������ṩ���ݣ�ʹ���ʷ����ѧ�����淶�����ñ�׼�����ʷ�Ϊƽ���ʡ������ʡ������ʡ������ʡ�̵ʪ�ʡ�ʪ���ʡ�Ѫ���ʡ������ʡ������ʾŸ����͡�" };
	    String[] arrayOfString3 = { "zhyxh", "ass", "who", "sf", "zytz" };
	    for (int i = 0;i<arrayOfString1.length ; i++)
	    {
	      
	      HashMap localHashMap = new HashMap();
	      localHashMap.put("name", arrayOfString1[i]);
	      localHashMap.put("value", arrayOfString2[i]);
	      localHashMap.put("id", arrayOfString3[i]);
	      this.listDatas.add(localHashMap);
	    }
	    return R.layout.xj_listview_nohead_healthtest2;
	}

	@Override
	public void initLayout() {
		ListView localListView = (ListView)this.view.findViewById(R.id.lv_common);
	    localListView.setAdapter(new SimpleAdapter(getActivity(), this.listDatas, R.layout.xj_listview_nohead_healthtest2_item, new String[] { "name", "value" }, new int[] { R.id.tv_lvitem_title, R.id.tv_lvitem_body }));
	    localListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
	    {
	      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
	      {
	        Intent localIntent = new Intent();
	        localIntent.putExtra("title", (String)((Map)HealthTestFragment2.this.listDatas.get(paramAnonymousInt)).get("name"));
	        localIntent.putExtra("content", (String)((Map)HealthTestFragment2.this.listDatas.get(paramAnonymousInt)).get("value"));
	        localIntent.putExtra("testPaperTempleId", (String)((Map)HealthTestFragment2.this.listDatas.get(paramAnonymousInt)).get("id"));
//	        if (paramAnonymousInt == 0)
//	        {
//	          localIntent.setClass(HealthTestFragment2.this.getActivity(), LiangbiaoActivity_shdc.class);
//	          HealthTestFragment2.this.startActivity(localIntent);
//	          return;
//	        }
	        localIntent.setClass(HealthTestFragment2.this.getActivity(), LiangbiaoActivity.class);
	        HealthTestFragment2.this.startActivity(localIntent);
	      }
	    });

	}

}
