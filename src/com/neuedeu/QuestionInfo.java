package com.neuedeu;

import java.util.Date;

public class QuestionInfo {
	
	private Integer questionId;        //问题ID
	private String questionTitle;      //问题标题
	private String questionIntroduce;  //问题说明
	private String questionType;       //类型（1：问题 2：文章）
	private Integer questionRaiseId;  //问题发起者ID
	private String userName;			//提问者名称
	private Date questionCreateTime;  //问题创建时间
	private Integer questionTopic;		//问题话题code
	private String codeName;			//话题名称
	private String zanCount;            //点赞数量
	private String commentCount;            //评论数量
	private String userContent;           //用户简介
	
	public Integer getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}
	public String getQuestionTitle() {
		return questionTitle;
	}
	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}
	public String getQuestionIntroduce() {
		return questionIntroduce;
	}
	public void setQuestionIntroduce(String questionIntroduce) {
		this.questionIntroduce = questionIntroduce;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public Integer getQuestionRaiseId() {
		return questionRaiseId;
	}
	public void setQuestionRaiseId(Integer questionRaiseId) {
		this.questionRaiseId = questionRaiseId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getQuestionCreateTime() {
		return questionCreateTime;
	}
	public void setQuestionCreateTime(Date questionCreateTime) {
		this.questionCreateTime = questionCreateTime;
	}
	public Integer getQuestionTopic() {
		return questionTopic;
	}
	public void setQuestionTopic(Integer questionTopic) {
		this.questionTopic = questionTopic;
	}
	public String getCodeName() {
		return codeName;
	}
	public void setCodeName(String codeName) {
		this.codeName = codeName;
	}

	public String getZanCount() {
		return zanCount;
	}

	public void setZanCount(String zanCount) {
		this.zanCount = zanCount;
	}

	public String getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(String commentCount) {
		this.commentCount = commentCount;
	}

	public String getUserContent() {
		return userContent;
	}

	public void setUserContent(String userContent) {
		this.userContent = userContent;
	}
}
