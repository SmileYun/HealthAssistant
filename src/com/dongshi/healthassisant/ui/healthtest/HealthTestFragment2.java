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
		String[] arrayOfString1 = { "抑郁自评量表测试[20题]\n(来源于:中华医学会健康自测量表)", "阿森斯失眠量表 [8题]", "WHO生存质量测定量表[103题] ", "健康调查简表SF36问[36题] ", "中医体质60问[60题] " };
	    String[] arrayOfString2 = { "健康体检自测问卷是由中华医学会健康管理学分会组织上百位行业专家，历时近十年完成。该问卷基于现代多维度健康概念和健康测量指标体系，并学习借鉴了国家“十一五”、“十二五”科研课题的研究成果形成的。健康体检自测问卷是健康体检服务的重要内容之一。通过该问卷，可以获取填写者的基本健康信息和数据，为后续的健康评估和个体化健康管理服务提供重要基础。", "阿森斯(Athens，AIS)失眠量表是国际公认的、主要用于自我评定睡眠质量的量表。睡眠障碍的评估量表是患者与临床医师对于睡眠问题进行的主观评定。临床医师对于患者的症状特点、有关量表的评估和多导睡眠图检查结果进行综合分析，通常能够对于许多类型睡眠障碍作出比较准确的判断与分类。进行有关量表的评估，能够获得睡眠障碍的量化依据，有助于分析睡眠紊乱的程度和评价治疗效果。阿森斯失眠量表就是临床常用的睡眠障碍的评估量表之一。", "世界卫生组织与健康有关生存质量测定量表(WHOQOL)是由世界卫生组织研制的、用于测量个体与健康有关的生存质量的国际性量表。 该量表不仅具有较好的信度、效度、反应度等心理测量学性质,而且具有国际可比性,即不同文化背景下测定的生存质量得分具有可比性。", "这是美国医学局研究(Medical Outcomes Study， MOS)组开发的一个普适性测定量表。该工作开始于80年代初期，形成了不同条目不同语言背景的多种版本。1990～1992年，含有36个条目的健康调查问卷简化版SF-36的不同语种版本相继问世〕。其中用得较多的是英国发展版和美国标准版和中文版，均包含躯体功能、躯体角色(role-physical)、肌体疼痛、总的健康状况、活力(vitality)、社会功能、情绪角色(role-emotional)和心理卫生等8个领域。", "该问卷是根据《中医体质分类与判定》的体质判定标准研发而成，它是我国第一部指导和规范中医体质研究及应用文件，旨在为体质辨识及与中医体质相关疾病的防治、养生保健、健康管理提供依据，使体质分类科学化、规范化。该标准将体质分为平和质、气虚质、阳虚质、阴虚质、痰湿质、湿热质、血瘀质、气郁质、特禀质九个类型。" };
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
