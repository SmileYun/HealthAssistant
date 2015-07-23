package com.dongshi.healthassisant.ui.healthtest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Question implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -601377743320344951L;
	
		private String inputType;
	  private List<Option> options = new ArrayList();
	  private int orderCode;
	  private String parentRubricId = "";
	  private String qAnswer;
	  private String questionId;
	  private String rubricId;
	  private String states = "0";
	  private String title;

	  public static long getSerialversionuid()
	  {
	    return -3226617966126025080L;
	  }

	  public String getInputType()
	  {
	    return this.inputType;
	  }

	  public List<Option> getOptions()
	  {
	    return this.options;
	  }

	  public int getOrderCode()
	  {
	    return this.orderCode;
	  }

	  public String getParentRubricId()
	  {
	    return this.parentRubricId;
	  }

	  public String getQuestionId()
	  {
	    return this.questionId;
	  }

	  public String getRubricId()
	  {
	    return this.rubricId;
	  }

	  public String getStates()
	  {
	    return this.states;
	  }

	  public String getTitle()
	  {
	    return this.title;
	  }

	  public String getqAnswer()
	  {
	    return this.qAnswer;
	  }

	  public void setInputType(String paramString)
	  {
	    this.inputType = paramString;
	  }

	  public void setOptions(List<Option> paramList)
	  {
	    this.options = paramList;
	  }

	  public void setOrderCode(int paramInt)
	  {
	    this.orderCode = paramInt;
	  }

	  public void setParentRubricId(String paramString)
	  {
	    this.parentRubricId = paramString;
	  }

	  public void setQuestionId(String paramString)
	  {
	    this.questionId = paramString;
	  }

	  public void setRubricId(String paramString)
	  {
	    this.rubricId = paramString;
	  }

	  public void setStates(String paramString)
	  {
	    this.states = paramString;
	  }

	  public void setTitle(String paramString)
	  {
	    this.title = paramString;
	  }

	  public void setqAnswer(String paramString)
	  {
	    this.qAnswer = paramString;
	  }

}
