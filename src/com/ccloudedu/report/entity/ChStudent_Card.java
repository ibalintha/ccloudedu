package com.ccloudedu.report.entity;

public class ChStudent_Card {
	//学籍信息
	private String chStudSchcode;
	private String chStudPersonid;
	private String chStudName;

	private String chStudSex;
	private String chStudBirth;
	private String chStudBirthplace;
	private String chStudEthnic;
	private String chStudType;
	
	private String chStudAddress;		
	private String chStudZip;
	private String chStudHealth;
	private String chStudImage;	
	//家庭成员四个列表
	private String chStudfamiNickname1;	
	private String chStudfamiName1;	
	private String chStudfamiAge1;	
	private String chStudfamiJob1;	
	private String chStudfamiPhone1;	

	private String chStudfamiNickname2;	
	private String chStudfamiName2;	
	private String chStudfamiAge2;	
	private String chStudfamiJob2;	
	private String chStudfamiPhone2;

	private String chStudfamiNickname3;	
	private String chStudfamiName3;	
	private String chStudfamiAge3;	
	private String chStudfamiJob3;	
	private String chStudfamiPhone3;
	
	private String chStudfamiNickname4;	
	private String chStudfamiName4;	
	private String chStudfamiAge4;	
	private String chStudfamiJob4;	
	private String chStudfamiPhone4;
	//入学资格
	private String chStuRollTime;
	//学籍变动的四个列表
	private String chStudRollIterm1;	
	private String chStudRollTime1;	
	private String chStudTerm1;	
	private String chStudPeperTime1;	

	private String chStudRollIterm2;	
	private String chStudRollTime2;	
	private String chStudTerm2;	
	private String chStudPeperTime2;	
	
	private String chStudRollIterm3;	
	private String chStudRollTime3;	
	private String chStudTerm3;	
	private String chStudPeperTime3;	
	
	private String chStudRollIterm4;	
	private String chStudRollTime4;	
	private String chStudTerm4;	
	private String chStudPeperTime4;	
	//毕业相关的记录
	private String chStuGraduatImg;
	private String chStuGraduateTime;
	private String chStuGraduateNum;
	private String chStuGraduateGowhere;
	
	private String chStuAwardPunish;
	private String chStuheadTeacher;
	public ChStudent_Card(String chStudSchcode,
			String chStudPersonid, String chStudName, String chStudSex,
			String chStudBirth, String chStudBirthplace, String chStudEthnic,
			String chStudType, String chStudAddress, String chStudZip,
			String chStudHealth, String chStudImage,
			String chStudfamiNickname1, String chStudfamiName1,
			String chStudfamiAge1, String chStudfamiJob1,
			String chStudfamiPhone1, String chStudfamiNickname2,
			String chStudfamiName2, String chStudfamiAge2,
			String chStudfamiJob2, String chStudfamiPhone2,
			String chStudfamiNickname3, String chStudfamiName3,
			String chStudfamiAge3, String chStudfamiJob3,
			String chStudfamiPhone3, String chStudfamiNickname4,
			String chStudfamiName4, String chStudfamiAge4,
			String chStudfamiJob4, String chStudfamiPhone4,
			String chStuRollTime, String chStudRollIterm1,
			String chStudRollTime1, String chStudTerm1,
			String chStudPeperTime1, String chStudRollIterm2,
			String chStudRollTime2, String chStudTerm2,
			String chStudPeperTime2, String chStudRollIterm3,
			String chStudRollTime3, String chStudTerm3,
			String chStudPeperTime3, String chStudRollIterm4,
			String chStudRollTime4, String chStudTerm4,
			String chStudPeperTime4, String chStuGraduatImg,
			String chStuGraduateTime, String chStuGraduateNum,
			String chStuGraduateGowhere, String chStuAwardPunish, 
			String chStuheadTeacher) {
		super();
		this.chStudSchcode = chStudSchcode;
		this.chStudPersonid = chStudPersonid;
		this.chStudName = chStudName;
		this.chStudSex = chStudSex;
		this.chStudBirth = chStudBirth;
		this.chStudBirthplace = chStudBirthplace;
		this.chStudEthnic = chStudEthnic;
		this.chStudType = chStudType;
		this.chStudAddress = chStudAddress;
		this.chStudZip = chStudZip;
		this.chStudHealth = chStudHealth;
		this.chStudImage = chStudImage;
		this.chStudfamiNickname1 = chStudfamiNickname1;
		this.chStudfamiName1 = chStudfamiName1;
		this.chStudfamiAge1 = chStudfamiAge1;
		this.chStudfamiJob1 = chStudfamiJob1;
		this.chStudfamiPhone1 = chStudfamiPhone1;
		this.chStudfamiNickname2 = chStudfamiNickname2;
		this.chStudfamiName2 = chStudfamiName2;
		this.chStudfamiAge2 = chStudfamiAge2;
		this.chStudfamiJob2 = chStudfamiJob2;
		this.chStudfamiPhone2 = chStudfamiPhone2;
		this.chStudfamiNickname3 = chStudfamiNickname3;
		this.chStudfamiName3 = chStudfamiName3;
		this.chStudfamiAge3 = chStudfamiAge3;
		this.chStudfamiJob3 = chStudfamiJob3;
		this.chStudfamiPhone3 = chStudfamiPhone3;
		this.chStudfamiNickname4 = chStudfamiNickname4;
		this.chStudfamiName4 = chStudfamiName4;
		this.chStudfamiAge4 = chStudfamiAge4;
		this.chStudfamiJob4 = chStudfamiJob4;
		this.chStudfamiPhone4 = chStudfamiPhone4;
		this.chStuRollTime = chStuRollTime;
		this.chStudRollIterm1 = chStudRollIterm1;
		this.chStudRollTime1 = chStudRollTime1;
		this.chStudTerm1 = chStudTerm1;
		this.chStudPeperTime1 = chStudPeperTime1;
		this.chStudRollIterm2 = chStudRollIterm2;
		this.chStudRollTime2 = chStudRollTime2;
		this.chStudTerm2 = chStudTerm2;
		this.chStudPeperTime2 = chStudPeperTime2;
		this.chStudRollIterm3 = chStudRollIterm3;
		this.chStudRollTime3 = chStudRollTime3;
		this.chStudTerm3 = chStudTerm3;
		this.chStudPeperTime3 = chStudPeperTime3;
		this.chStudRollIterm4 = chStudRollIterm4;
		this.chStudRollTime4 = chStudRollTime4;
		this.chStudTerm4 = chStudTerm4;
		this.chStudPeperTime4 = chStudPeperTime4;
		this.chStuGraduatImg = chStuGraduatImg;
		this.chStuGraduateTime = chStuGraduateTime;
		this.chStuGraduateNum = chStuGraduateNum;
		this.chStuGraduateGowhere = chStuGraduateGowhere;
		this.chStuAwardPunish = chStuAwardPunish;
		this.chStuheadTeacher = chStuheadTeacher;
	}
	
	public String getChStudSchcode() {
		return chStudSchcode;
	}
	public void setChStudSchcode(String chStudSchcode) {
		this.chStudSchcode = chStudSchcode;
	}
	public String getChStudPersonid() {
		return chStudPersonid;
	}
	public void setChStudPersonid(String chStudPersonid) {
		this.chStudPersonid = chStudPersonid;
	}
	public String getChStudName() {
		return chStudName;
	}
	public void setChStudName(String chStudName) {
		this.chStudName = chStudName;
	}
	public String getChStudSex() {
		return chStudSex;
	}
	public void setChStudSex(String chStudSex) {
		this.chStudSex = chStudSex;
	}
	public String getChStudBirth() {
		return chStudBirth;
	}
	public void setChStudBirth(String chStudBirth) {
		this.chStudBirth = chStudBirth;
	}
	public String getChStudBirthplace() {
		return chStudBirthplace;
	}
	public void setChStudBirthplace(String chStudBirthplace) {
		this.chStudBirthplace = chStudBirthplace;
	}
	public String getChStudEthnic() {
		return chStudEthnic;
	}
	public void setChStudEthnic(String chStudEthnic) {
		this.chStudEthnic = chStudEthnic;
	}
	public String getChStudType() {
		return chStudType;
	}
	public void setChStudType(String chStudType) {
		this.chStudType = chStudType;
	}
	public String getChStudAddress() {
		return chStudAddress;
	}
	public void setChStudAddress(String chStudAddress) {
		this.chStudAddress = chStudAddress;
	}
	public String getChStudZip() {
		return chStudZip;
	}
	public void setChStudZip(String chStudZip) {
		this.chStudZip = chStudZip;
	}
	public String getChStudHealth() {
		return chStudHealth;
	}
	public void setChStudHealth(String chStudHealth) {
		this.chStudHealth = chStudHealth;
	}
	public String getChStudImage() {
		return chStudImage;
	}
	public void setChStudImage(String chStudImage) {
		this.chStudImage = chStudImage;
	}
	public String getChStudfamiNickname1() {
		return chStudfamiNickname1;
	}
	public void setChStudfamiNickname1(String chStudfamiNickname1) {
		this.chStudfamiNickname1 = chStudfamiNickname1;
	}
	public String getChStudfamiName1() {
		return chStudfamiName1;
	}
	public void setChStudfamiName1(String chStudfamiName1) {
		this.chStudfamiName1 = chStudfamiName1;
	}
	public String getChStudfamiAge1() {
		return chStudfamiAge1;
	}
	public void setChStudfamiAge1(String chStudfamiAge1) {
		this.chStudfamiAge1 = chStudfamiAge1;
	}
	public String getChStudfamiJob1() {
		return chStudfamiJob1;
	}
	public void setChStudfamiJob1(String chStudfamiJob1) {
		this.chStudfamiJob1 = chStudfamiJob1;
	}
	public String getChStudfamiPhone1() {
		return chStudfamiPhone1;
	}
	public void setChStudfamiPhone1(String chStudfamiPhone1) {
		this.chStudfamiPhone1 = chStudfamiPhone1;
	}
	public String getChStudfamiNickname2() {
		return chStudfamiNickname2;
	}
	public void setChStudfamiNickname2(String chStudfamiNickname2) {
		this.chStudfamiNickname2 = chStudfamiNickname2;
	}
	public String getChStudfamiName2() {
		return chStudfamiName2;
	}
	public void setChStudfamiName2(String chStudfamiName2) {
		this.chStudfamiName2 = chStudfamiName2;
	}
	public String getChStudfamiAge2() {
		return chStudfamiAge2;
	}
	public void setChStudfamiAge2(String chStudfamiAge2) {
		this.chStudfamiAge2 = chStudfamiAge2;
	}
	public String getChStudfamiJob2() {
		return chStudfamiJob2;
	}
	public void setChStudfamiJob2(String chStudfamiJob2) {
		this.chStudfamiJob2 = chStudfamiJob2;
	}
	public String getChStudfamiPhone2() {
		return chStudfamiPhone2;
	}
	public void setChStudfamiPhone2(String chStudfamiPhone2) {
		this.chStudfamiPhone2 = chStudfamiPhone2;
	}
	public String getChStudfamiNickname3() {
		return chStudfamiNickname3;
	}
	public void setChStudfamiNickname3(String chStudfamiNickname3) {
		this.chStudfamiNickname3 = chStudfamiNickname3;
	}
	public String getChStudfamiName3() {
		return chStudfamiName3;
	}
	public void setChStudfamiName3(String chStudfamiName3) {
		this.chStudfamiName3 = chStudfamiName3;
	}
	public String getChStudfamiAge3() {
		return chStudfamiAge3;
	}
	public void setChStudfamiAge3(String chStudfamiAge3) {
		this.chStudfamiAge3 = chStudfamiAge3;
	}
	public String getChStudfamiJob3() {
		return chStudfamiJob3;
	}
	public void setChStudfamiJob3(String chStudfamiJob3) {
		this.chStudfamiJob3 = chStudfamiJob3;
	}
	public String getChStudfamiPhone3() {
		return chStudfamiPhone3;
	}
	public void setChStudfamiPhone3(String chStudfamiPhone3) {
		this.chStudfamiPhone3 = chStudfamiPhone3;
	}
	public String getChStudfamiNickname4() {
		return chStudfamiNickname4;
	}
	public void setChStudfamiNickname4(String chStudfamiNickname4) {
		this.chStudfamiNickname4 = chStudfamiNickname4;
	}
	public String getChStudfamiName4() {
		return chStudfamiName4;
	}
	public void setChStudfamiName4(String chStudfamiName4) {
		this.chStudfamiName4 = chStudfamiName4;
	}
	public String getChStudfamiAge4() {
		return chStudfamiAge4;
	}
	public void setChStudfamiAge4(String chStudfamiAge4) {
		this.chStudfamiAge4 = chStudfamiAge4;
	}
	public String getChStudfamiJob4() {
		return chStudfamiJob4;
	}
	public void setChStudfamiJob4(String chStudfamiJob4) {
		this.chStudfamiJob4 = chStudfamiJob4;
	}
	public String getChStudfamiPhone4() {
		return chStudfamiPhone4;
	}
	public void setChStudfamiPhone4(String chStudfamiPhone4) {
		this.chStudfamiPhone4 = chStudfamiPhone4;
	}
	public String getChStuRollTime() {
		return chStuRollTime;
	}
	public void setChStuRollTime(String chStuRollTime) {
		this.chStuRollTime = chStuRollTime;
	}
	public String getChStudRollIterm1() {
		return chStudRollIterm1;
	}
	public void setChStudRollIterm1(String chStudRollIterm1) {
		this.chStudRollIterm1 = chStudRollIterm1;
	}
	public String getChStudRollTime1() {
		return chStudRollTime1;
	}
	public void setChStudRollTime1(String chStudRollTime1) {
		this.chStudRollTime1 = chStudRollTime1;
	}
	public String getChStudTerm1() {
		return chStudTerm1;
	}
	public void setChStudTerm1(String chStudTerm1) {
		this.chStudTerm1 = chStudTerm1;
	}
	public String getChStudPeperTime1() {
		return chStudPeperTime1;
	}
	public void setChStudPeperTime1(String chStudPeperTime1) {
		this.chStudPeperTime1 = chStudPeperTime1;
	}
	public String getChStudRollIterm2() {
		return chStudRollIterm2;
	}
	public void setChStudRollIterm2(String chStudRollIterm2) {
		this.chStudRollIterm2 = chStudRollIterm2;
	}
	public String getChStudRollTime2() {
		return chStudRollTime2;
	}
	public void setChStudRollTime2(String chStudRollTime2) {
		this.chStudRollTime2 = chStudRollTime2;
	}
	public String getChStudTerm2() {
		return chStudTerm2;
	}
	public void setChStudTerm2(String chStudTerm2) {
		this.chStudTerm2 = chStudTerm2;
	}
	public String getChStudPeperTime2() {
		return chStudPeperTime2;
	}
	public void setChStudPeperTime2(String chStudPeperTime2) {
		this.chStudPeperTime2 = chStudPeperTime2;
	}
	public String getChStudRollIterm3() {
		return chStudRollIterm3;
	}
	public void setChStudRollIterm3(String chStudRollIterm3) {
		this.chStudRollIterm3 = chStudRollIterm3;
	}
	public String getChStudRollTime3() {
		return chStudRollTime3;
	}
	public void setChStudRollTime3(String chStudRollTime3) {
		this.chStudRollTime3 = chStudRollTime3;
	}
	public String getChStudTerm3() {
		return chStudTerm3;
	}
	public void setChStudTerm3(String chStudTerm3) {
		this.chStudTerm3 = chStudTerm3;
	}
	public String getChStudPeperTime3() {
		return chStudPeperTime3;
	}
	public void setChStudPeperTime3(String chStudPeperTime3) {
		this.chStudPeperTime3 = chStudPeperTime3;
	}
	public String getChStudRollIterm4() {
		return chStudRollIterm4;
	}
	public void setChStudRollIterm4(String chStudRollIterm4) {
		this.chStudRollIterm4 = chStudRollIterm4;
	}
	public String getChStudRollTime4() {
		return chStudRollTime4;
	}
	public void setChStudRollTime4(String chStudRollTime4) {
		this.chStudRollTime4 = chStudRollTime4;
	}
	public String getChStudTerm4() {
		return chStudTerm4;
	}
	public void setChStudTerm4(String chStudTerm4) {
		this.chStudTerm4 = chStudTerm4;
	}
	public String getChStudPeperTime4() {
		return chStudPeperTime4;
	}
	public void setChStudPeperTime4(String chStudPeperTime4) {
		this.chStudPeperTime4 = chStudPeperTime4;
	}
	public String getChStuGraduatImg() {
		return chStuGraduatImg;
	}
	public void setChStuGraduatImg(String chStuGraduatImg) {
		this.chStuGraduatImg = chStuGraduatImg;
	}
	public String getChStuGraduateTime() {
		return chStuGraduateTime;
	}
	public void setChStuGraduateTime(String chStuGraduateTime) {
		this.chStuGraduateTime = chStuGraduateTime;
	}
	public String getChStuGraduateNum() {
		return chStuGraduateNum;
	}
	public void setChStuGraduateNum(String chStuGraduateNum) {
		this.chStuGraduateNum = chStuGraduateNum;
	}
	public String getChStuGraduateGowhere() {
		return chStuGraduateGowhere;
	}
	public void setChStuGraduateGowhere(String chStuGraduateGowhere) {
		this.chStuGraduateGowhere = chStuGraduateGowhere;
	}
	public String getChStuAwardPunish() {
		return chStuAwardPunish;
	}
	public void setChStuAwardPunish(String chStuAwardPunish) {
		this.chStuAwardPunish = chStuAwardPunish;
	}
	public String getChStuheadTeacher() {
		return chStuheadTeacher;
	}
	public void setChStuheadTeacher(String chStuheadTeacher) {
		this.chStuheadTeacher = chStuheadTeacher;
	}
	
	
}
