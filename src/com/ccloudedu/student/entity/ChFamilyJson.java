package com.ccloudedu.student.entity;

/**
 * 该类用来实现学生家庭信息的转换成json返回到页面
 * @author Pescadito
 * 2013-07-31 11:06
 */
public class ChFamilyJson implements java.io.Serializable {


	private static final long serialVersionUID = 1L;

	private String id;
	private String chScroId;//学籍id
	private String chScroSchroll;//学籍号
	private String chScroName;//学生姓名
	private String chFamiNickname;
	private String chFamiName;
	private String chFamiAge;
	private String chFamiPersonid;
	private String chFamiWorkcompany;
	private String chFamiPostion;
	private String chFamiPhone;
	private String chFamiPolface;
	private String chFamiMemo;
	private String chFamiAddress;//ch_fami_address
	private String chFamiVacation;//ch_fami_vacation
	private String chFamiZip;//ch_fami_zip
	private String chFamiEmail;//ch_fami_email
	private String chFamiCell;//ch_fami_cell
	private String chFamiSpecial;//ch_fami_special
	private String chFamiServeType;//ch_fami_serveType
	private String chFamiServeRecord;//ch_fami_serveRecord
	private String chFamiSms;//ch_fami_sms
	
	public ChFamilyJson() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChFamilyJson(String id, String chScroId, String chScroSchroll,
			String chScroName, String chFamiNickname, String chFamiName,
			String chFamiAge, String chFamiPersonid, String chFamiWorkcompany,
			String chFamiPostion, String chFamiPhone, String chFamiPolface,
			String chFamiMemo, String chFamiAddress, String chFamiVacation,
			String chFamiZip, String chFamiEmail, String chFamiCell,
			String chFamiSpecial, String chFamiServeType,
			String chFamiServeRecord, String chFamiSms) {
		super();
		this.id = id;
		this.chScroId = chScroId;
		this.chScroSchroll = chScroSchroll;
		this.chScroName = chScroName;
		this.chFamiNickname = chFamiNickname;
		this.chFamiName = chFamiName;
		this.chFamiAge = chFamiAge;
		this.chFamiPersonid = chFamiPersonid;
		this.chFamiWorkcompany = chFamiWorkcompany;
		this.chFamiPostion = chFamiPostion;
		this.chFamiPhone = chFamiPhone;
		this.chFamiPolface = chFamiPolface;
		this.chFamiMemo = chFamiMemo;
		this.chFamiAddress = chFamiAddress;
		this.chFamiVacation = chFamiVacation;
		this.chFamiZip = chFamiZip;
		this.chFamiEmail = chFamiEmail;
		this.chFamiCell = chFamiCell;
		this.chFamiSpecial = chFamiSpecial;
		this.chFamiServeType = chFamiServeType;
		this.chFamiServeRecord = chFamiServeRecord;
		this.chFamiSms = chFamiSms;
	}

	@Override
	public String toString() {
		return "ChFamilyJson [id=" + id + ", chScroId=" + chScroId
				+ ", chScroSchroll=" + chScroSchroll + ", chScroName="
				+ chScroName + ", chFamiNickname=" + chFamiNickname
				+ ", chFamiName=" + chFamiName + ", chFamiAge=" + chFamiAge
				+ ", chFamiPersonid=" + chFamiPersonid + ", chFamiWorkcompany="
				+ chFamiWorkcompany + ", chFamiPostion=" + chFamiPostion
				+ ", chFamiPhone=" + chFamiPhone + ", chFamiPolface="
				+ chFamiPolface + ", chFamiMemo=" + chFamiMemo
				+ ", chFamiAddress=" + chFamiAddress + ", chFamiVacation="
				+ chFamiVacation + ", chFamiZip=" + chFamiZip
				+ ", chFamiEmail=" + chFamiEmail + ", chFamiCell=" + chFamiCell
				+ ", chFamiSpecial=" + chFamiSpecial + ", chFamiServeType="
				+ chFamiServeType + ", chFamiServeRecord=" + chFamiServeRecord
				+ ", chFamiSms=" + chFamiSms + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getChScroId() {
		return chScroId;
	}
	public void setChScroId(String chScroId) {
		this.chScroId = chScroId;
	}
	public String getChScroSchroll() {
		return chScroSchroll;
	}
	public void setChScroSchroll(String chScroSchroll) {
		this.chScroSchroll = chScroSchroll;
	}
	public String getChScroName() {
		return chScroName;
	}
	public void setChScroName(String chScroName) {
		this.chScroName = chScroName;
	}
	public String getChFamiNickname() {
		return chFamiNickname;
	}
	public void setChFamiNickname(String chFamiNickname) {
		this.chFamiNickname = chFamiNickname;
	}
	public String getChFamiName() {
		return chFamiName;
	}
	public void setChFamiName(String chFamiName) {
		this.chFamiName = chFamiName;
	}
	public String getChFamiAge() {
		return chFamiAge;
	}
	public void setChFamiAge(String chFamiAge) {
		this.chFamiAge = chFamiAge;
	}
	public String getChFamiPersonid() {
		return chFamiPersonid;
	}
	public void setChFamiPersonid(String chFamiPersonid) {
		this.chFamiPersonid = chFamiPersonid;
	}
	public String getChFamiWorkcompany() {
		return chFamiWorkcompany;
	}
	public void setChFamiWorkcompany(String chFamiWorkcompany) {
		this.chFamiWorkcompany = chFamiWorkcompany;
	}
	public String getChFamiPostion() {
		return chFamiPostion;
	}
	public void setChFamiPostion(String chFamiPostion) {
		this.chFamiPostion = chFamiPostion;
	}
	public String getChFamiPhone() {
		return chFamiPhone;
	}
	public void setChFamiPhone(String chFamiPhone) {
		this.chFamiPhone = chFamiPhone;
	}
	public String getChFamiPolface() {
		return chFamiPolface;
	}
	public void setChFamiPolface(String chFamiPolface) {
		this.chFamiPolface = chFamiPolface;
	}
	public String getChFamiMemo() {
		return chFamiMemo;
	}
	public void setChFamiMemo(String chFamiMemo) {
		this.chFamiMemo = chFamiMemo;
	}
	public String getChFamiAddress() {
		return chFamiAddress;
	}
	public void setChFamiAddress(String chFamiAddress) {
		this.chFamiAddress = chFamiAddress;
	}
	public String getChFamiVacation() {
		return chFamiVacation;
	}
	public void setChFamiVacation(String chFamiVacation) {
		this.chFamiVacation = chFamiVacation;
	}
	public String getChFamiZip() {
		return chFamiZip;
	}
	public void setChFamiZip(String chFamiZip) {
		this.chFamiZip = chFamiZip;
	}
	public String getChFamiEmail() {
		return chFamiEmail;
	}
	public void setChFamiEmail(String chFamiEmail) {
		this.chFamiEmail = chFamiEmail;
	}
	public String getChFamiCell() {
		return chFamiCell;
	}
	public void setChFamiCell(String chFamiCell) {
		this.chFamiCell = chFamiCell;
	}
	public String getChFamiSpecial() {
		return chFamiSpecial;
	}
	public void setChFamiSpecial(String chFamiSpecial) {
		this.chFamiSpecial = chFamiSpecial;
	}
	public String getChFamiServeType() {
		return chFamiServeType;
	}
	public void setChFamiServeType(String chFamiServeType) {
		this.chFamiServeType = chFamiServeType;
	}
	public String getChFamiServeRecord() {
		return chFamiServeRecord;
	}
	public void setChFamiServeRecord(String chFamiServeRecord) {
		this.chFamiServeRecord = chFamiServeRecord;
	}
	public String getChFamiSms() {
		return chFamiSms;
	}
	public void setChFamiSms(String chFamiSms) {
		this.chFamiSms = chFamiSms;
	}

}