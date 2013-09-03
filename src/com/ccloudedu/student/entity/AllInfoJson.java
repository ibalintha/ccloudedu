package com.ccloudedu.student.entity;

import java.util.List;

/**
 * 该实体包含了所有学籍信息中的子信息
 * @author Pescadito
 * 2013-07-31 11:39
 */
public class AllInfoJson {

	private List<ChCommentJson> chCommentJsonList;
	private List<ChFamilyJson> chFamilyJsonList;
	private List<ChHomeVisiteJson> chHomeVisiteJsonList;
	private List<ChOtherInfoJson> chOtherInfoJsonList;
	private List<ChPositionJson> chPositionJsonList;
	private List<ChPracticeJson> chPracticeJsonList;
	private List<ChResumeJson> chResumeJsonList;
	private List<ChRewardJson> chRewardJsonList;
	private List<ChSpecialJson> chSpecialJsonList;
	private List<ChWorksJson> chWorksJsonList;
	public AllInfoJson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AllInfoJson(List<ChCommentJson> chCommentJsonList,
			List<ChFamilyJson> chFamilyJsonList,
			List<ChHomeVisiteJson> chHomeVisiteJsonList,
			List<ChOtherInfoJson> chOtherInfoJsonList,
			List<ChPositionJson> chPositionJsonList,
			List<ChPracticeJson> chPracticeJsonList,
			List<ChResumeJson> chResumeJsonList,
			List<ChRewardJson> chRewardJsonList,
			List<ChSpecialJson> chSpecialJsonList,
			List<ChWorksJson> chWorksJsonList) {
		super();
		this.chCommentJsonList = chCommentJsonList;
		this.chFamilyJsonList = chFamilyJsonList;
		this.chHomeVisiteJsonList = chHomeVisiteJsonList;
		this.chOtherInfoJsonList = chOtherInfoJsonList;
		this.chPositionJsonList = chPositionJsonList;
		this.chPracticeJsonList = chPracticeJsonList;
		this.chResumeJsonList = chResumeJsonList;
		this.chRewardJsonList = chRewardJsonList;
		this.chSpecialJsonList = chSpecialJsonList;
		this.chWorksJsonList = chWorksJsonList;
	}
	public List<ChCommentJson> getChCommentJsonList() {
		return chCommentJsonList;
	}
	public void setChCommentJsonList(List<ChCommentJson> chCommentJsonList) {
		this.chCommentJsonList = chCommentJsonList;
	}
	public List<ChFamilyJson> getChFamilyJsonList() {
		return chFamilyJsonList;
	}
	public void setChFamilyJsonList(List<ChFamilyJson> chFamilyJsonList) {
		this.chFamilyJsonList = chFamilyJsonList;
	}
	public List<ChHomeVisiteJson> getChHomeVisiteJsonList() {
		return chHomeVisiteJsonList;
	}
	public void setChHomeVisiteJsonList(List<ChHomeVisiteJson> chHomeVisiteJsonList) {
		this.chHomeVisiteJsonList = chHomeVisiteJsonList;
	}
	public List<ChOtherInfoJson> getChOtherInfoJsonList() {
		return chOtherInfoJsonList;
	}
	public void setChOtherInfoJsonList(List<ChOtherInfoJson> chOtherInfoJsonList) {
		this.chOtherInfoJsonList = chOtherInfoJsonList;
	}
	public List<ChPositionJson> getChPositionJsonList() {
		return chPositionJsonList;
	}
	public void setChPositionJsonList(List<ChPositionJson> chPositionJsonList) {
		this.chPositionJsonList = chPositionJsonList;
	}
	public List<ChPracticeJson> getChPracticeJsonList() {
		return chPracticeJsonList;
	}
	public void setChPracticeJsonList(List<ChPracticeJson> chPracticeJsonList) {
		this.chPracticeJsonList = chPracticeJsonList;
	}
	public List<ChResumeJson> getChResumeJsonList() {
		return chResumeJsonList;
	}
	public void setChResumeJsonList(List<ChResumeJson> chResumeJsonList) {
		this.chResumeJsonList = chResumeJsonList;
	}
	public List<ChRewardJson> getChRewardJsonList() {
		return chRewardJsonList;
	}
	public void setChRewardJsonList(List<ChRewardJson> chRewardJsonList) {
		this.chRewardJsonList = chRewardJsonList;
	}
	public List<ChSpecialJson> getChSpecialJsonList() {
		return chSpecialJsonList;
	}
	public void setChSpecialJsonList(List<ChSpecialJson> chSpecialJsonList) {
		this.chSpecialJsonList = chSpecialJsonList;
	}
	public List<ChWorksJson> getChWorksJsonList() {
		return chWorksJsonList;
	}
	public void setChWorksJsonList(List<ChWorksJson> chWorksJsonList) {
		this.chWorksJsonList = chWorksJsonList;
	}
}
