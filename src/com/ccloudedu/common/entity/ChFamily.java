package com.ccloudedu.common.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChFamily entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_family")
public class ChFamily  extends IDEntity implements java.io.Serializable {


	private static final long serialVersionUID = 1L;

//	private String id;
	private String chScroId;//ch_scro_id
	private String chFamiNickname;//ch_fami_nickname
	private String chFamiName;//ch_fami_name
	private String chFamiAge;//ch_fami_age
	private String chFamiPersonid;//ch_fami_personid
	private String chFamiWorkcompany;//ch_fami_workcompany
	private String chFamiPostion;//ch_fami_postion
	private String chFamiPhone;//ch_fami_phone
	private String chFamiPolface;//ch_fami_polface 
	private String chFamiMemo;//ch_fami_memo
	
	private String chFamiAddress;//ch_fami_address
	private String chFamiVacation;//ch_fami_vacation
	private String chFamiZip;//ch_fami_zip
	private String chFamiEmail;//ch_fami_email
	private String chFamiCell;//ch_fami_cell
	private String chFamiSpecial;//ch_fami_special
	private String chFamiServeType;//ch_fami_serveType
	private String chFamiServeRecord;//ch_fami_serveRecord
	private String chFamiSms;//ch_fami_sms
	// Constructors

	public ChFamily() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChFamily(String chScroId, String chFamiNickname, String chFamiName,
			String chFamiAge, String chFamiPersonid, String chFamiWorkcompany,
			String chFamiPostion, String chFamiPhone, String chFamiPolface,
			String chFamiMemo, String chFamiAddress, String chFamiVacation,
			String chFamiZip, String chFamiEmail, String chFamiCell,
			String chFamiSpecial, String chFamiServeType,
			String chFamiServeRecord, String chFamiSms) {
		super();
		this.chScroId = chScroId;
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
		return "ChFamily [chScroId=" + chScroId + ", chFamiNickname="
				+ chFamiNickname + ", chFamiName=" + chFamiName
				+ ", chFamiAge=" + chFamiAge + ", chFamiPersonid="
				+ chFamiPersonid + ", chFamiWorkcompany=" + chFamiWorkcompany
				+ ", chFamiPostion=" + chFamiPostion + ", chFamiPhone="
				+ chFamiPhone + ", chFamiPolface=" + chFamiPolface
				+ ", chFamiMemo=" + chFamiMemo + ", chFamiAddress="
				+ chFamiAddress + ", chFamiVacation=" + chFamiVacation
				+ ", chFamiZip=" + chFamiZip + ", chFamiEmail=" + chFamiEmail
				+ ", chFamiCell=" + chFamiCell + ", chFamiSpecial="
				+ chFamiSpecial + ", chFamiServeType=" + chFamiServeType
				+ ", chFamiServeRecord=" + chFamiServeRecord + ", chFamiSms="
				+ chFamiSms + "]";
	}
	@Column(name = "ch_scro_id", length = 50)
	public String getChScroId() {
		return this.chScroId;
	}

	public void setChScroId(String chScroId) {
		this.chScroId = chScroId;
	}

	@Column(name = "ch_fami_nickname", length = 50)
	public String getChFamiNickname() {
		return this.chFamiNickname;
	}

	public void setChFamiNickname(String chFamiNickname) {
		this.chFamiNickname = chFamiNickname;
	}

	@Column(name = "ch_fami_name", length = 50)
	public String getChFamiName() {
		return this.chFamiName;
	}

	public void setChFamiName(String chFamiName) {
		this.chFamiName = chFamiName;
	}

	@Column(name = "ch_fami_age", length = 50)
	public String getChFamiAge() {
		return this.chFamiAge;
	}

	public void setChFamiAge(String chFamiAge) {
		this.chFamiAge = chFamiAge;
	}

	@Column(name = "ch_fami_personid", length = 50)
	public String getChFamiPersonid() {
		return this.chFamiPersonid;
	}

	public void setChFamiPersonid(String chFamiPersonid) {
		this.chFamiPersonid = chFamiPersonid;
	}

	@Column(name = "ch_fami_workcompany", length = 50)
	public String getChFamiWorkcompany() {
		return this.chFamiWorkcompany;
	}

	public void setChFamiWorkcompany(String chFamiWorkcompany) {
		this.chFamiWorkcompany = chFamiWorkcompany;
	}

	@Column(name = "ch_fami_postion", length = 50)
	public String getChFamiPostion() {
		return this.chFamiPostion;
	}

	public void setChFamiPostion(String chFamiPostion) {
		this.chFamiPostion = chFamiPostion;
	}

	@Column(name = "ch_fami_phone", length = 50)
	public String getChFamiPhone() {
		return this.chFamiPhone;
	}

	public void setChFamiPhone(String chFamiPhone) {
		this.chFamiPhone = chFamiPhone;
	}

	@Column(name = "ch_fami_polface", length = 50)
	public String getChFamiPolface() {
		return this.chFamiPolface;
	}

	public void setChFamiPolface(String chFamiPolface) {
		this.chFamiPolface = chFamiPolface;
	}

	@Column(name = "ch_fami_memo", length = 100)
	public String getChFamiMemo() {
		return this.chFamiMemo;
	}

	public void setChFamiMemo(String chFamiMemo) {
		this.chFamiMemo = chFamiMemo;
	}
	
	@Column(name = "ch_fami_address", length = 100)
	public String getChFamiAddress() {
		return chFamiAddress;
	}
	public void setChFamiAddress(String chFamiAddress) {
		this.chFamiAddress = chFamiAddress;
	}
	
	@Column(name = "ch_fami_vacation", length = 50)
	public String getChFamiVacation() {
		return chFamiVacation;
	}
	public void setChFamiVacation(String chFamiVacation) {
		this.chFamiVacation = chFamiVacation;
	}
	
	@Column(name = "ch_fami_zip", length = 10)
	public String getChFamiZip() {
		return chFamiZip;
	}
	public void setChFamiZip(String chFamiZip) {
		this.chFamiZip = chFamiZip;
	}
	
	@Column(name = "ch_fami_email", length = 100)
	public String getChFamiEmail() {
		return chFamiEmail;
	}
	public void setChFamiEmail(String chFamiEmail) {
		this.chFamiEmail = chFamiEmail;
	}
	
	@Column(name = "ch_fami_cell", length = 50)
	public String getChFamiCell() {
		return chFamiCell;
	}
	public void setChFamiCell(String chFamiCell) {
		this.chFamiCell = chFamiCell;
	}
	
	@Column(name = "ch_fami_special", length = 100)
	public String getChFamiSpecial() {
		return chFamiSpecial;
	}
	public void setChFamiSpecial(String chFamiSpecial) {
		this.chFamiSpecial = chFamiSpecial;
	}
	
	@Column(name = "ch_fami_serveType", length = 100)
	public String getChFamiServeType() {
		return chFamiServeType;
	}
	public void setChFamiServeType(String chFamiServeType) {
		this.chFamiServeType = chFamiServeType;
	}
	
	@Column(name = "ch_fami_serveRecord", length = 100)
	public String getChFamiServeRecord() {
		return chFamiServeRecord;
	}
	public void setChFamiServeRecord(String chFamiServeRecord) {
		this.chFamiServeRecord = chFamiServeRecord;
	}
	
	@Column(name = "ch_fami_sms", length = 10)
	public String getChFamiSms() {
		return chFamiSms;
	}
	public void setChFamiSms(String chFamiSms) {
		this.chFamiSms = chFamiSms;
	}

}