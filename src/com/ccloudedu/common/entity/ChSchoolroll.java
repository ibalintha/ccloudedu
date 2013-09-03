package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChSchoolroll entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_schoolroll")
public class ChSchoolroll extends IDEntity  implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String chStudId;
	private String chScroSchroll;
	private String chScroSchcode;
	private String chScroName;
	private String chScroPinyin;
	private String chScroEngname;
	private String chScroOldname;
	private String chScroEnrolldate;
	private String chScroGrade;
	private String chClasId;
	private String chScroType;
	private String chScroState;
	private String chScroPersontype;
	private String chScroPersonid;
	private String chScroSex;
	private String chScroBirth;
	private String chScroBirthplace;
	private String chScroOnly;
	private String chScroHometown;
	private String chScroEthnic;
	private String chScroOldschool;
	private String chScroAdmway;
	private String chScroForeign;
	private String chScroSourareas;
	private String chScroHealth;
	private String chScroBloodtype;
	private String chScroPolface;
	private String chScroAddress;
	private String chScroLocakind;
	private String chScroLocation;
	private String chScroFlowperson;
	private String chScroNational;
	private String chScroPhone;
	private String chScroTranaddress;
	private String chScroZip;
	private String chScroEmail;
	private String chScroWebsite;
	private String chScroCadreflag;
	private String chScroImage;
	private String chScroScore;
	private String chScroSpecial;
	private String chScroUpdateflag;
	private String chScroMemo;
	private String chScroMaketime;

	// Constructors

	/** default constructor */
	public ChSchoolroll() {
	}


	/** full constructor */
	public ChSchoolroll( String chStudId,String chScroSchroll, String chScroSchcode,
			String chScroName, String chScroPinyin, String chScroEngname,
			String chScroOldname, String chScroEnrolldate, String chScroGrade,
			String chClasId, String chScroType,
			String chScroState, String chScroPersontype,
			String chScroPersonid, String chScroSex, String chScroBirth,
			String chScroBirthplace, String chScroOnly, String chScroHometown,
			String chScroEthnic, String chScroOldschool, String chScroAdmway,
			String chScroForeign, String chScroSourareas, String chScroHealth,
			String chScroBloodtype, String chScroPolface, String chScroAddress,
			String chScroLocakind, String chScroLocation,
			String chScroFlowperson, String chScroNational, String chScroPhone,
			String chScroTranaddress, String chScroZip, String chScroEmail,
			String chScroWebsite, String chScroCadreflag, String chScroImage,
			String chScroScore, String chScroSpecial, String chScroUpdateflag,
			String chScroMemo, String chScroMaketime) {
		this.chStudId = chStudId;
		this.chScroSchroll = chScroSchroll;
		this.chScroSchcode = chScroSchcode;
		this.chScroName = chScroName;
		this.chScroPinyin = chScroPinyin;
		this.chScroEngname = chScroEngname;
		this.chScroOldname = chScroOldname;
		this.chScroEnrolldate = chScroEnrolldate;
		this.chScroGrade = chScroGrade;
		this.chClasId = chClasId;
		this.chScroType = chScroType;
		this.chScroState = chScroState;
		this.chScroPersontype = chScroPersontype;
		this.chScroPersonid = chScroPersonid;
		this.chScroSex = chScroSex;
		this.chScroBirth = chScroBirth;
		this.chScroBirthplace = chScroBirthplace;
		this.chScroOnly = chScroOnly;
		this.chScroHometown = chScroHometown;
		this.chScroEthnic = chScroEthnic;
		this.chScroOldschool = chScroOldschool;
		this.chScroAdmway = chScroAdmway;
		this.chScroForeign = chScroForeign;
		this.chScroSourareas = chScroSourareas;
		this.chScroHealth = chScroHealth;
		this.chScroBloodtype = chScroBloodtype;
		this.chScroPolface = chScroPolface;
		this.chScroAddress = chScroAddress;
		this.chScroLocakind = chScroLocakind;
		this.chScroLocation = chScroLocation;
		this.chScroFlowperson = chScroFlowperson;
		this.chScroNational = chScroNational;
		this.chScroPhone = chScroPhone;
		this.chScroTranaddress = chScroTranaddress;
		this.chScroZip = chScroZip;
		this.chScroEmail = chScroEmail;
		this.chScroWebsite = chScroWebsite;
		this.chScroCadreflag = chScroCadreflag;
		this.chScroImage = chScroImage;
		this.chScroScore = chScroScore;
		this.chScroSpecial = chScroSpecial;
		this.chScroUpdateflag = chScroUpdateflag;
		this.chScroMemo = chScroMemo;
		this.chScroMaketime = chScroMaketime;
	}

	// Property accessors

	@Column(name = "ch_scro_schroll", length = 20)
	public String getChScroSchroll() {
		return this.chScroSchroll;
	}

	public void setChScroSchroll(String chScroSchroll) {
		this.chScroSchroll = chScroSchroll;
	}

	@Column(name = "ch_scro_schcode", length = 20)
	public String getChScroSchcode() {
		return this.chScroSchcode;
	}

	public void setChScroSchcode(String chScroSchcode) {
		this.chScroSchcode = chScroSchcode;
	}

	@Column(name = "ch_scro_name", length = 20)
	public String getChScroName() {
		return this.chScroName;
	}

	public void setChScroName(String chScroName) {
		this.chScroName = chScroName;
	}

	@Column(name = "ch_scro_pinyin", length = 50)
	public String getChScroPinyin() {
		return this.chScroPinyin;
	}

	public void setChScroPinyin(String chScroPinyin) {
		this.chScroPinyin = chScroPinyin;
	}

	@Column(name = "ch_scro_engname", length = 20)
	public String getChScroEngname() {
		return this.chScroEngname;
	}

	public void setChScroEngname(String chScroEngname) {
		this.chScroEngname = chScroEngname;
	}

	@Column(name = "ch_scro_oldname", length = 20)
	public String getChScroOldname() {
		return this.chScroOldname;
	}

	public void setChScroOldname(String chScroOldname) {
		this.chScroOldname = chScroOldname;
	}

	@Column(name = "ch_scro_enrolldate", length = 20)
	public String getChScroEnrolldate() {
		return this.chScroEnrolldate;
	}

	public void setChScroEnrolldate(String chScroEnrolldate) {
		this.chScroEnrolldate = chScroEnrolldate;
	}

	@Column(name = "ch_scro_grade", length = 20)
	public String getChScroGrade() {
		return this.chScroGrade;
	}

	public void setChScroGrade(String chScroGrade) {
		this.chScroGrade = chScroGrade;
	}

	@Column(name = "ch_clas_id", length = 50)
	public String getChClasId() {
		return this.chClasId;
	}

	public void setChClasId(String chClasId) {
		this.chClasId = chClasId;
	}

	@Column(name = "ch_scro_type", length = 20)
	public String getChScroType() {
		return this.chScroType;
	}

	public void setChScroType(String chScroType) {
		this.chScroType = chScroType;
	}

	@Column(name = "ch_scro_state", length = 20)
	public String getChScroState() {
		return chScroState;
	}


	public void setChScroState(String chScroState) {
		this.chScroState = chScroState;
	}


	@Column(name = "ch_scro_persontype", length = 20)
	public String getChScroPersontype() {
		return this.chScroPersontype;
	}

	public void setChScroPersontype(String chScroPersontype) {
		this.chScroPersontype = chScroPersontype;
	}

	@Column(name = "ch_scro_personid", length = 20)
	public String getChScroPersonid() {
		return this.chScroPersonid;
	}

	public void setChScroPersonid(String chScroPersonid) {
		this.chScroPersonid = chScroPersonid;
	}

	@Column(name = "ch_scro_sex", length = 20)
	public String getChScroSex() {
		return this.chScroSex;
	}

	public void setChScroSex(String chScroSex) {
		this.chScroSex = chScroSex;
	}

	@Column(name = "ch_scro_birth", length = 20)
	public String getChScroBirth() {
		return this.chScroBirth;
	}

	public void setChScroBirth(String chScroBirth) {
		this.chScroBirth = chScroBirth;
	}

	@Column(name = "ch_scro_birthplace", length = 20)
	public String getChScroBirthplace() {
		return this.chScroBirthplace;
	}

	public void setChScroBirthplace(String chScroBirthplace) {
		this.chScroBirthplace = chScroBirthplace;
	}

	@Column(name = "ch_scro_only", length = 20)
	public String getChScroOnly() {
		return this.chScroOnly;
	}

	public void setChScroOnly(String chScroOnly) {
		this.chScroOnly = chScroOnly;
	}

	@Column(name = "ch_scro_hometown", length = 20)
	public String getChScroHometown() {
		return this.chScroHometown;
	}

	public void setChScroHometown(String chScroHometown) {
		this.chScroHometown = chScroHometown;
	}

	@Column(name = "ch_scro_ethnic", length = 20)
	public String getChScroEthnic() {
		return this.chScroEthnic;
	}

	public void setChScroEthnic(String chScroEthnic) {
		this.chScroEthnic = chScroEthnic;
	}

	@Column(name = "ch_scro_oldschool", length = 20)
	public String getChScroOldschool() {
		return this.chScroOldschool;
	}

	public void setChScroOldschool(String chScroOldschool) {
		this.chScroOldschool = chScroOldschool;
	}

	@Column(name = "ch_scro_admway", length = 20)
	public String getChScroAdmway() {
		return this.chScroAdmway;
	}

	public void setChScroAdmway(String chScroAdmway) {
		this.chScroAdmway = chScroAdmway;
	}

	@Column(name = "ch_scro_foreign", length = 20)
	public String getChScroForeign() {
		return this.chScroForeign;
	}

	public void setChScroForeign(String chScroForeign) {
		this.chScroForeign = chScroForeign;
	}

	@Column(name = "ch_scro_sourareas", length = 20)
	public String getChScroSourareas() {
		return this.chScroSourareas;
	}

	public void setChScroSourareas(String chScroSourareas) {
		this.chScroSourareas = chScroSourareas;
	}

	@Column(name = "ch_scro_health", length = 20)
	public String getChScroHealth() {
		return this.chScroHealth;
	}

	public void setChScroHealth(String chScroHealth) {
		this.chScroHealth = chScroHealth;
	}

	@Column(name = "ch_scro_bloodtype", length = 20)
	public String getChScroBloodtype() {
		return this.chScroBloodtype;
	}

	public void setChScroBloodtype(String chScroBloodtype) {
		this.chScroBloodtype = chScroBloodtype;
	}

	@Column(name = "ch_scro_polface", length = 20)
	public String getChScroPolface() {
		return this.chScroPolface;
	}

	public void setChScroPolface(String chScroPolface) {
		this.chScroPolface = chScroPolface;
	}

	@Column(name = "ch_scro_address", length = 100)
	public String getChScroAddress() {
		return this.chScroAddress;
	}

	public void setChScroAddress(String chScroAddress) {
		this.chScroAddress = chScroAddress;
	}

	@Column(name = "ch_scro_locakind", length = 20)
	public String getChScroLocakind() {
		return this.chScroLocakind;
	}

	public void setChScroLocakind(String chScroLocakind) {
		this.chScroLocakind = chScroLocakind;
	}

	@Column(name = "ch_scro_location", length = 100)
	public String getChScroLocation() {
		return this.chScroLocation;
	}

	public void setChScroLocation(String chScroLocation) {
		this.chScroLocation = chScroLocation;
	}

	@Column(name = "ch_scro_flowperson", length = 20)
	public String getChScroFlowperson() {
		return this.chScroFlowperson;
	}

	public void setChScroFlowperson(String chScroFlowperson) {
		this.chScroFlowperson = chScroFlowperson;
	}

	@Column(name = "ch_scro_national", length = 20)
	public String getChScroNational() {
		return this.chScroNational;
	}

	public void setChScroNational(String chScroNational) {
		this.chScroNational = chScroNational;
	}

	@Column(name = "ch_scro_phone", length = 20)
	public String getChScroPhone() {
		return this.chScroPhone;
	}

	public void setChScroPhone(String chScroPhone) {
		this.chScroPhone = chScroPhone;
	}

	@Column(name = "ch_scro_tranaddress", length = 20)
	public String getChScroTranaddress() {
		return this.chScroTranaddress;
	}

	public void setChScroTranaddress(String chScroTranaddress) {
		this.chScroTranaddress = chScroTranaddress;
	}

	@Column(name = "ch_scro_zip", length = 20)
	public String getChScroZip() {
		return this.chScroZip;
	}

	public void setChScroZip(String chScroZip) {
		this.chScroZip = chScroZip;
	}

	@Column(name = "ch_scro_email", length = 50)
	public String getChScroEmail() {
		return this.chScroEmail;
	}

	public void setChScroEmail(String chScroEmail) {
		this.chScroEmail = chScroEmail;
	}

	@Column(name = "ch_scro_website", length = 20)
	public String getChScroWebsite() {
		return this.chScroWebsite;
	}

	public void setChScroWebsite(String chScroWebsite) {
		this.chScroWebsite = chScroWebsite;
	}

	@Column(name = "ch_scro_cadreflag", length = 2)
	public String getChScroCadreflag() {
		return this.chScroCadreflag;
	}

	public void setChScroCadreflag(String chScroCadreflag) {
		this.chScroCadreflag = chScroCadreflag;
	}

	@Column(name = "ch_scro_image", length = 50)
	public String getChScroImage() {
		return this.chScroImage;
	}

	public void setChScroImage(String chScroImage) {
		this.chScroImage = chScroImage;
	}

	@Column(name = "ch_scro_score", length = 20)
	public String getChScroScore() {
		return this.chScroScore;
	}

	public void setChScroScore(String chScroScore) {
		this.chScroScore = chScroScore;
	}

	@Column(name = "ch_scro_special", length = 20)
	public String getChScroSpecial() {
		return this.chScroSpecial;
	}

	public void setChScroSpecial(String chScroSpecial) {
		this.chScroSpecial = chScroSpecial;
	}

	@Column(name = "ch_scro_updateflag", length = 2)
	public String getChScroUpdateflag() {
		return this.chScroUpdateflag;
	}

	public void setChScroUpdateflag(String chScroUpdateflag) {
		this.chScroUpdateflag = chScroUpdateflag;
	}

	@Column(name = "ch_scro_memo", length = 500)
	public String getChScroMemo() {
		return this.chScroMemo;
	}

	public void setChScroMemo(String chScroMemo) {
		this.chScroMemo = chScroMemo;
	}

	@Column(name = "ch_scro_maketime", length = 20)
	public String getChScroMaketime() {
		return this.chScroMaketime;
	}

	public void setChScroMaketime(String chScroMaketime) {
		this.chScroMaketime = chScroMaketime;
	}

	@Column(name = "ch_stud_id", length = 50)
	public String getChStudId() {
		return chStudId;
	}


	public void setChStudId(String chStudId) {
		this.chStudId = chStudId;
	}
	

}