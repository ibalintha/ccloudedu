package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChSchool entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_school")
public class ChSchool extends IDEntity implements java.io.Serializable {

	// Fields

	private String chSchoCode;
	private String chSchoNum;
	private String chSchoName;
	private String chSchoState;
	private String chSchoShtname;
	private String chSchoHdutcode;
	private String chSchoAdminstate;
	private String chSchoMaster;
	private String chSchoPartyperson;
	private String chSchoHddepart;
	private String chSchoCrtdate;
	private String chSchoBirth;
	private String chSchoEmplevel;
	private String chSchoFarchld;
	private String chSchoGrade;
	private String chSchoType;
	private String chSchoDemlevel;
	private String chSchoAdmarea;
	private String chSchoLocethpro;
	private String chSchoLocecopro;
	private String chSchoSmlyear;
	private String chSchoSmlage;
	private String chSchoMidyear;
	private String chSchoMidage;
	private String chSchoHimiyear;
	private String chSchoOwnarea;
	private String chSchoMainlang;
	private String chSchoSecondlang;
	private String chSchoZip;
	private String chSchoCall;
	private String chSchoFax;
	private String chSchoEmail;
	private String chSchoWebsite;
	private String chSchoOrgcode;
	private String chSchoEngname;
	private String chSchoAddress;
	private String chSchoLogo;
	private String chSchoDesc;
	private String chSchoMemo;

	// Constructors

	/** default constructor */
	public ChSchool() {
	}


	/** full constructor */
	public ChSchool( String chSchoCode, String chSchoNum,
			String chSchoName, String chSchoState, String chSchoShtname,
			String chSchoHdutcode, String chSchoAdminstate,
			String chSchoMaster, String chSchoPartyperson,
			String chSchoHddepart, String chSchoCrtdate, String chSchoBirth,
			String chSchoEmplevel, String chSchoFarchld, String chSchoGrade,
			String chSchoType, String chSchoDemlevel, String chSchoAdmarea,
			String chSchoLocethpro, String chSchoLocecopro,
			String chSchoSmlyear, String chSchoSmlage, String chSchoMidyear,
			String chSchoMidage, String chSchoHimiyear, String chSchoOwnarea,
			String chSchoMainlang, String chSchoSecondlang, String chSchoZip,
			String chSchoCall, String chSchoFax, String chSchoEmail,
			String chSchoWebsite, String chSchoOrgcode, String chSchoEngname,
			String chSchoAddress, String chSchoLogo, String chSchoDesc,
			String chSchoMemo) {
		this.chSchoCode = chSchoCode;
		this.chSchoNum = chSchoNum;
		this.chSchoName = chSchoName;
		this.chSchoState = chSchoState;
		this.chSchoShtname = chSchoShtname;
		this.chSchoHdutcode = chSchoHdutcode;
		this.chSchoAdminstate = chSchoAdminstate;
		this.chSchoMaster = chSchoMaster;
		this.chSchoPartyperson = chSchoPartyperson;
		this.chSchoHddepart = chSchoHddepart;
		this.chSchoCrtdate = chSchoCrtdate;
		this.chSchoBirth = chSchoBirth;
		this.chSchoEmplevel = chSchoEmplevel;
		this.chSchoFarchld = chSchoFarchld;
		this.chSchoGrade = chSchoGrade;
		this.chSchoType = chSchoType;
		this.chSchoDemlevel = chSchoDemlevel;
		this.chSchoAdmarea = chSchoAdmarea;
		this.chSchoLocethpro = chSchoLocethpro;
		this.chSchoLocecopro = chSchoLocecopro;
		this.chSchoSmlyear = chSchoSmlyear;
		this.chSchoSmlage = chSchoSmlage;
		this.chSchoMidyear = chSchoMidyear;
		this.chSchoMidage = chSchoMidage;
		this.chSchoHimiyear = chSchoHimiyear;
		this.chSchoOwnarea = chSchoOwnarea;
		this.chSchoMainlang = chSchoMainlang;
		this.chSchoSecondlang = chSchoSecondlang;
		this.chSchoZip = chSchoZip;
		this.chSchoCall = chSchoCall;
		this.chSchoFax = chSchoFax;
		this.chSchoEmail = chSchoEmail;
		this.chSchoWebsite = chSchoWebsite;
		this.chSchoOrgcode = chSchoOrgcode;
		this.chSchoEngname = chSchoEngname;
		this.chSchoAddress = chSchoAddress;
		this.chSchoLogo = chSchoLogo;
		this.chSchoDesc = chSchoDesc;
		this.chSchoMemo = chSchoMemo;
	}


	@Column(name = "ch_scho_code", length = 20)
	public String getChSchoCode() {
		return this.chSchoCode;
	}

	public void setChSchoCode(String chSchoCode) {
		this.chSchoCode = chSchoCode;
	}

	@Column(name = "ch_scho_num", length = 20)
	public String getChSchoNum() {
		return this.chSchoNum;
	}

	public void setChSchoNum(String chSchoNum) {
		this.chSchoNum = chSchoNum;
	}

	@Column(name = "ch_scho_name", length = 50)
	public String getChSchoName() {
		return this.chSchoName;
	}

	public void setChSchoName(String chSchoName) {
		this.chSchoName = chSchoName;
	}

	@Column(name = "ch_scho_state", length = 20)
	public String getChSchoState() {
		return this.chSchoState;
	}

	public void setChSchoState(String chSchoState) {
		this.chSchoState = chSchoState;
	}

	@Column(name = "ch_scho_shtname", length = 30)
	public String getChSchoShtname() {
		return this.chSchoShtname;
	}

	public void setChSchoShtname(String chSchoShtname) {
		this.chSchoShtname = chSchoShtname;
	}

	@Column(name = "ch_scho_hdutcode", length = 20)
	public String getChSchoHdutcode() {
		return this.chSchoHdutcode;
	}

	public void setChSchoHdutcode(String chSchoHdutcode) {
		this.chSchoHdutcode = chSchoHdutcode;
	}

	@Column(name = "ch_scho_adminstate", length = 20)
	public String getChSchoAdminstate() {
		return this.chSchoAdminstate;
	}

	public void setChSchoAdminstate(String chSchoAdminstate) {
		this.chSchoAdminstate = chSchoAdminstate;
	}

	@Column(name = "ch_scho_master", length = 20)
	public String getChSchoMaster() {
		return this.chSchoMaster;
	}

	public void setChSchoMaster(String chSchoMaster) {
		this.chSchoMaster = chSchoMaster;
	}

	@Column(name = "ch_scho_partyperson", length = 20)
	public String getChSchoPartyperson() {
		return this.chSchoPartyperson;
	}

	public void setChSchoPartyperson(String chSchoPartyperson) {
		this.chSchoPartyperson = chSchoPartyperson;
	}

	@Column(name = "ch_scho_hddepart", length = 20)
	public String getChSchoHddepart() {
		return this.chSchoHddepart;
	}

	public void setChSchoHddepart(String chSchoHddepart) {
		this.chSchoHddepart = chSchoHddepart;
	}

	@Column(name = "ch_scho_crtdate", length = 20)
	public String getChSchoCrtdate() {
		return this.chSchoCrtdate;
	}

	public void setChSchoCrtdate(String chSchoCrtdate) {
		this.chSchoCrtdate = chSchoCrtdate;
	}

	@Column(name = "ch_scho_birth", length = 20)
	public String getChSchoBirth() {
		return this.chSchoBirth;
	}

	public void setChSchoBirth(String chSchoBirth) {
		this.chSchoBirth = chSchoBirth;
	}

	@Column(name = "ch_scho_emplevel", length = 20)
	public String getChSchoEmplevel() {
		return this.chSchoEmplevel;
	}

	public void setChSchoEmplevel(String chSchoEmplevel) {
		this.chSchoEmplevel = chSchoEmplevel;
	}

	@Column(name = "ch_scho_farchld", length = 20)
	public String getChSchoFarchld() {
		return this.chSchoFarchld;
	}

	public void setChSchoFarchld(String chSchoFarchld) {
		this.chSchoFarchld = chSchoFarchld;
	}

	@Column(name = "ch_scho_grade", length = 20)
	public String getChSchoGrade() {
		return this.chSchoGrade;
	}

	public void setChSchoGrade(String chSchoGrade) {
		this.chSchoGrade = chSchoGrade;
	}

	@Column(name = "ch_scho_type", length = 20)
	public String getChSchoType() {
		return this.chSchoType;
	}

	public void setChSchoType(String chSchoType) {
		this.chSchoType = chSchoType;
	}

	@Column(name = "ch_scho_demlevel", length = 20)
	public String getChSchoDemlevel() {
		return this.chSchoDemlevel;
	}

	public void setChSchoDemlevel(String chSchoDemlevel) {
		this.chSchoDemlevel = chSchoDemlevel;
	}

	@Column(name = "ch_scho_admarea", length = 20)
	public String getChSchoAdmarea() {
		return this.chSchoAdmarea;
	}

	public void setChSchoAdmarea(String chSchoAdmarea) {
		this.chSchoAdmarea = chSchoAdmarea;
	}

	@Column(name = "ch_scho_locethpro", length = 20)
	public String getChSchoLocethpro() {
		return this.chSchoLocethpro;
	}

	public void setChSchoLocethpro(String chSchoLocethpro) {
		this.chSchoLocethpro = chSchoLocethpro;
	}

	@Column(name = "ch_scho_locecopro", length = 20)
	public String getChSchoLocecopro() {
		return this.chSchoLocecopro;
	}

	public void setChSchoLocecopro(String chSchoLocecopro) {
		this.chSchoLocecopro = chSchoLocecopro;
	}

	@Column(name = "ch_scho_smlyear", length = 20)
	public String getChSchoSmlyear() {
		return this.chSchoSmlyear;
	}

	public void setChSchoSmlyear(String chSchoSmlyear) {
		this.chSchoSmlyear = chSchoSmlyear;
	}

	@Column(name = "ch_scho_smlage", length = 20)
	public String getChSchoSmlage() {
		return this.chSchoSmlage;
	}

	public void setChSchoSmlage(String chSchoSmlage) {
		this.chSchoSmlage = chSchoSmlage;
	}

	@Column(name = "ch_scho_midyear", length = 20)
	public String getChSchoMidyear() {
		return this.chSchoMidyear;
	}

	public void setChSchoMidyear(String chSchoMidyear) {
		this.chSchoMidyear = chSchoMidyear;
	}

	@Column(name = "ch_scho_midage", length = 20)
	public String getChSchoMidage() {
		return this.chSchoMidage;
	}

	public void setChSchoMidage(String chSchoMidage) {
		this.chSchoMidage = chSchoMidage;
	}

	@Column(name = "ch_scho_himiyear", length = 20)
	public String getChSchoHimiyear() {
		return this.chSchoHimiyear;
	}

	public void setChSchoHimiyear(String chSchoHimiyear) {
		this.chSchoHimiyear = chSchoHimiyear;
	}

	@Column(name = "ch_scho_ownarea", length = 20)
	public String getChSchoOwnarea() {
		return this.chSchoOwnarea;
	}

	public void setChSchoOwnarea(String chSchoOwnarea) {
		this.chSchoOwnarea = chSchoOwnarea;
	}

	@Column(name = "ch_scho_mainlang", length = 20)
	public String getChSchoMainlang() {
		return this.chSchoMainlang;
	}

	public void setChSchoMainlang(String chSchoMainlang) {
		this.chSchoMainlang = chSchoMainlang;
	}

	@Column(name = "ch_scho_secondlang", length = 20)
	public String getChSchoSecondlang() {
		return this.chSchoSecondlang;
	}

	public void setChSchoSecondlang(String chSchoSecondlang) {
		this.chSchoSecondlang = chSchoSecondlang;
	}

	@Column(name = "ch_scho_zip", length = 20)
	public String getChSchoZip() {
		return this.chSchoZip;
	}

	public void setChSchoZip(String chSchoZip) {
		this.chSchoZip = chSchoZip;
	}

	@Column(name = "ch_scho_call", length = 20)
	public String getChSchoCall() {
		return this.chSchoCall;
	}

	public void setChSchoCall(String chSchoCall) {
		this.chSchoCall = chSchoCall;
	}

	@Column(name = "ch_scho_fax", length = 20)
	public String getChSchoFax() {
		return this.chSchoFax;
	}

	public void setChSchoFax(String chSchoFax) {
		this.chSchoFax = chSchoFax;
	}

	@Column(name = "ch_scho_email", length = 50)
	public String getChSchoEmail() {
		return this.chSchoEmail;
	}

	public void setChSchoEmail(String chSchoEmail) {
		this.chSchoEmail = chSchoEmail;
	}

	@Column(name = "ch_scho_website", length = 100)
	public String getChSchoWebsite() {
		return this.chSchoWebsite;
	}

	public void setChSchoWebsite(String chSchoWebsite) {
		this.chSchoWebsite = chSchoWebsite;
	}

	@Column(name = "ch_scho_orgcode", length = 20)
	public String getChSchoOrgcode() {
		return this.chSchoOrgcode;
	}

	public void setChSchoOrgcode(String chSchoOrgcode) {
		this.chSchoOrgcode = chSchoOrgcode;
	}

	@Column(name = "ch_scho_engname", length = 50)
	public String getChSchoEngname() {
		return this.chSchoEngname;
	}

	public void setChSchoEngname(String chSchoEngname) {
		this.chSchoEngname = chSchoEngname;
	}

	@Column(name = "ch_scho_address", length = 100)
	public String getChSchoAddress() {
		return this.chSchoAddress;
	}

	public void setChSchoAddress(String chSchoAddress) {
		this.chSchoAddress = chSchoAddress;
	}

	@Column(name = "ch_scho_logo", length = 100)
	public String getChSchoLogo() {
		return this.chSchoLogo;
	}

	public void setChSchoLogo(String chSchoLogo) {
		this.chSchoLogo = chSchoLogo;
	}

	@Column(name = "ch_scho_desc", length = 100)
	public String getChSchoDesc() {
		return this.chSchoDesc;
	}

	public void setChSchoDesc(String chSchoDesc) {
		this.chSchoDesc = chSchoDesc;
	}

	@Column(name = "ch_scho_memo", length = 100)
	public String getChSchoMemo() {
		return this.chSchoMemo;
	}

	public void setChSchoMemo(String chSchoMemo) {
		this.chSchoMemo = chSchoMemo;
	}

}