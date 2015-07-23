package com.dongshi.healthassisant.ui.healthtest;

import java.io.Serializable;
import java.util.ArrayList;

public class Option implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7527833449210928627L;
	
	private String checkedVal;
	  private ArrayList<String> childRubrics = new ArrayList();
	  private String optionContent;
	  private String optionId;
	  private int optionOrderCode;
	  private String rubricId;

	  public static long getSerialversionuid()
	  {
	    return -394802040375384815L;
	  }

	  public String getCheckedVal()
	  {
	    return this.checkedVal;
	  }

	  public ArrayList<String> getChildRubrics()
	  {
	    return this.childRubrics;
	  }

	  public String getOptionContent()
	  {
	    return this.optionContent;
	  }

	  public String getOptionId()
	  {
	    return this.optionId;
	  }

	  public int getOptionOrderCode()
	  {
	    return this.optionOrderCode;
	  }

	  public String getRubricId()
	  {
	    return this.rubricId;
	  }

	  public void setCheckedVal(String paramString)
	  {
	    this.checkedVal = paramString;
	  }

	  public void setChildRubrics(ArrayList<String> paramArrayList)
	  {
	    this.childRubrics = paramArrayList;
	  }

	  public void setOptionContent(String paramString)
	  {
	    this.optionContent = paramString;
	  }

	  public void setOptionId(String paramString)
	  {
	    this.optionId = paramString;
	  }

	  public void setOptionOrderCode(int paramInt)
	  {
	    this.optionOrderCode = paramInt;
	  }

	  public void setRubricId(String paramString)
	  {
	    this.rubricId = paramString;
	  }

}
