package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;

/**
 * ChTeacher entity. @author yueyongsheng
 * 2013-07-11
 */
@Entity
@Table(name = "CH_TEACHER")
public class ChTeacher extends IDEntity implements java.io.Serializable {

    private static final long serialVersionUID = -456121722017195692L;
	// Fields
	private String chTeacCode;
	private String chTeacName;
	private String chTeacOldname;
	private String chTeacSex;
	private String chTeacPersonid;
	private String chDepaId;
	private String chTeacBirth;
	private String chTeacWorkflag;
	private String chTeacWorktime;
	private String chTeacTitle;
	private String chTeacRecdcode;
	private String chTeacImg;
	private String chTeacPostion;
	private String chTeacPhone;
	private String chTeacCall;
	private String chTeacPolface;
	private String chTeacJointime;
	private String chTeacNational;
	private String chTeacHometown;
	private String chTeacEducation;
	private String chTeacSubject;
	private String chTeacGraducate;
	private String chTeacGradtime;
	private String chTeacAcctype;
	private String chTeacGrade;
	private String chTeacEthnic;
	private String chTeacLocation;
	private String chTeacAddress;
	private String chTeacEmail;
	private String chTeacMemo;

	// Constructors

	/** default constructor */
	public ChTeacher() {
	}

	/** minimal constructor */
	public ChTeacher(String id) {
		super(id);
	}

	/** full constructor */
	public ChTeacher(String id, String chTeacCode, String chTeacName, String chTeacOldname, String chTeacSex,
	        String chTeacPersonid, String chDepaId, String chTeacBirth, String chTeacWorkflag, String chTeacWorktime,
	        String chTeacTitle, String chTeacRecdcode, String chTeacImg, String chTeacPostion, String chTeacPhone,
	        String chTeacCall, String chTeacPolface, String chTeacJointime, String chTeacNational,
	        String chTeacHometown, String chTeacEducation, String chTeacSubject, String chTeacGraducate,
	        String chTeacGradtime, String chTeacAcctype, String chTeacGrade, String chTeacEthnic,
	        String chTeacLocation, String chTeacAddress, String chTeacEmail, String chTeacMemo) {
		super(id);
		this.chTeacCode = chTeacCode;
		this.chTeacName = chTeacName;
		this.chTeacOldname = chTeacOldname;
		this.chTeacSex = chTeacSex;
		this.chTeacPersonid = chTeacPersonid;
		this.chDepaId = chDepaId;
		this.chTeacBirth = chTeacBirth;
		this.chTeacWorkflag = chTeacWorkflag;
		this.chTeacWorktime = chTeacWorktime;
		this.chTeacTitle = chTeacTitle;
		this.chTeacRecdcode = chTeacRecdcode;
		this.chTeacImg = chTeacImg;
		this.chTeacPostion = chTeacPostion;
		this.chTeacPhone = chTeacPhone;
		this.chTeacCall = chTeacCall;
		this.chTeacPolface = chTeacPolface;
		this.chTeacJointime = chTeacJointime;
		this.chTeacNational = chTeacNational;
		this.chTeacHometown = chTeacHometown;
		this.chTeacEducation = chTeacEducation;
		this.chTeacSubject = chTeacSubject;
		this.chTeacGraducate = chTeacGraducate;
		this.chTeacGradtime = chTeacGradtime;
		this.chTeacAcctype = chTeacAcctype;
		this.chTeacGrade = chTeacGrade;
		this.chTeacEthnic = chTeacEthnic;
		this.chTeacLocation = chTeacLocation;
		this.chTeacAddress = chTeacAddress;
		this.chTeacEmail = chTeacEmail;
		this.chTeacMemo = chTeacMemo;
	}

	// Property accessors
	@Column(name = "ch_teac_code", length = 20)
	public String getChTeacCode() {
		return this.chTeacCode;
	}

	public void setChTeacCode(String chTeacCode) {
		this.chTeacCode = chTeacCode;
	}

	@Column(name = "ch_teac_name", length = 20)
	public String getChTeacName() {
		return this.chTeacName;
	}

	public void setChTeacName(String chTeacName) {
		this.chTeacName = chTeacName;
	}

	@Column(name = "ch_teac_oldname", length = 20)
	public String getChTeacOldname() {
		return this.chTeacOldname;
	}

	public void setChTeacOldname(String chTeacOldname) {
		this.chTeacOldname = chTeacOldname;
	}

	@Column(name = "ch_teac_sex", length = 2)
	public String getChTeacSex() {
		return this.chTeacSex;
	}

	public void setChTeacSex(String chTeacSex) {
		this.chTeacSex = chTeacSex;
	}

	@Column(name = "ch_teac_personid", length = 20)
	public String getChTeacPersonid() {
		return this.chTeacPersonid;
	}

	public void setChTeacPersonid(String chTeacPersonid) {
		this.chTeacPersonid = chTeacPersonid;
	}

	@Column(name = "ch_depa_id")
	public String getChDepaId() {
		return this.chDepaId;
	}

	public void setChDepaId(String chDepaId) {
		this.chDepaId = chDepaId;
	}

	@Column(name = "ch_teac_birth", length = 20)
	public String getChTeacBirth() {
		return this.chTeacBirth;
	}

	public void setChTeacBirth(String chTeacBirth) {
		this.chTeacBirth = chTeacBirth;
	}

	@Column(name = "ch_teac_workflag", length = 10)
	public String getChTeacWorkflag() {
		return this.chTeacWorkflag;
	}

	public void setChTeacWorkflag(String chTeacWorkflag) {
		this.chTeacWorkflag = chTeacWorkflag;
	}

	@Column(name = "ch_teac_worktime", length = 20)
	public String getChTeacWorktime() {
		return this.chTeacWorktime;
	}

	public void setChTeacWorktime(String chTeacWorktime) {
		this.chTeacWorktime = chTeacWorktime;
	}

	@Column(name = "ch_teac_title", length = 20)
	public String getChTeacTitle() {
		return this.chTeacTitle;
	}

	public void setChTeacTitle(String chTeacTitle) {
		this.chTeacTitle = chTeacTitle;
	}

	@Column(name = "ch_teac_recdcode", length = 20)
	public String getChTeacRecdcode() {
		return this.chTeacRecdcode;
	}

	public void setChTeacRecdcode(String chTeacRecdcode) {
		this.chTeacRecdcode = chTeacRecdcode;
	}

	@Column(name = "ch_teac_img", length = 50)
	public String getChTeacImg() {
		return this.chTeacImg;
	}

	public void setChTeacImg(String chTeacImg) {
		this.chTeacImg = chTeacImg;
	}

	@Column(name = "ch_teac_postion", length = 20)
	public String getChTeacPostion() {
		return this.chTeacPostion;
	}

	public void setChTeacPostion(String chTeacPostion) {
		this.chTeacPostion = chTeacPostion;
	}

	@Column(name = "ch_teac_phone", length = 20)
	public String getChTeacPhone() {
		return this.chTeacPhone;
	}

	public void setChTeacPhone(String chTeacPhone) {
		this.chTeacPhone = chTeacPhone;
	}

	@Column(name = "ch_teac_call", length = 20)
	public String getChTeacCall() {
		return this.chTeacCall;
	}

	public void setChTeacCall(String chTeacCall) {
		this.chTeacCall = chTeacCall;
	}

	@Column(name = "ch_teac_polface", length = 20)
	public String getChTeacPolface() {
		return this.chTeacPolface;
	}

	public void setChTeacPolface(String chTeacPolface) {
		this.chTeacPolface = chTeacPolface;
	}

	@Column(name = "ch_teac_jointime", length = 20)
	public String getChTeacJointime() {
		return this.chTeacJointime;
	}

	public void setChTeacJointime(String chTeacJointime) {
		this.chTeacJointime = chTeacJointime;
	}

	@Column(name = "ch_teac_national", length = 20)
	public String getChTeacNational() {
		return this.chTeacNational;
	}

	public void setChTeacNational(String chTeacNational) {
		this.chTeacNational = chTeacNational;
	}

	@Column(name = "ch_teac_hometown", length = 20)
	public String getChTeacHometown() {
		return this.chTeacHometown;
	}

	public void setChTeacHometown(String chTeacHometown) {
		this.chTeacHometown = chTeacHometown;
	}

	@Column(name = "ch_teac_education", length = 20)
	public String getChTeacEducation() {
		return this.chTeacEducation;
	}

	public void setChTeacEducation(String chTeacEducation) {
		this.chTeacEducation = chTeacEducation;
	}

	@Column(name = "ch_teac_subject", length = 50)
	public String getChTeacSubject() {
		return this.chTeacSubject;
	}

	public void setChTeacSubject(String chTeacSubject) {
		this.chTeacSubject = chTeacSubject;
	}

	@Column(name = "ch_teac_graducate", length = 50)
	public String getChTeacGraducate() {
		return this.chTeacGraducate;
	}

	public void setChTeacGraducate(String chTeacGraducate) {
		this.chTeacGraducate = chTeacGraducate;
	}

	@Column(name = "ch_teac_gradtime", length = 20)
	public String getChTeacGradtime() {
		return this.chTeacGradtime;
	}

	public void setChTeacGradtime(String chTeacGradtime) {
		this.chTeacGradtime = chTeacGradtime;
	}

	@Column(name = "ch_teac_acctype", length = 20)
	public String getChTeacAcctype() {
		return this.chTeacAcctype;
	}

	public void setChTeacAcctype(String chTeacAcctype) {
		this.chTeacAcctype = chTeacAcctype;
	}

	@Column(name = "ch_teac_grade", length = 10)
	public String getChTeacGrade() {
		return this.chTeacGrade;
	}

	public void setChTeacGrade(String chTeacGrade) {
		this.chTeacGrade = chTeacGrade;
	}

	@Column(name = "ch_teac_ethnic", length = 10)
	public String getChTeacEthnic() {
		return this.chTeacEthnic;
	}

	public void setChTeacEthnic(String chTeacEthnic) {
		this.chTeacEthnic = chTeacEthnic;
	}

	@Column(name = "ch_teac_location", length = 50)
	public String getChTeacLocation() {
		return this.chTeacLocation;
	}

	public void setChTeacLocation(String chTeacLocation) {
		this.chTeacLocation = chTeacLocation;
	}

	@Column(name = "ch_teac_address", length = 50)
	public String getChTeacAddress() {
		return this.chTeacAddress;
	}

	public void setChTeacAddress(String chTeacAddress) {
		this.chTeacAddress = chTeacAddress;
	}

	@Column(name = "ch_teac_email", length = 50)
	public String getChTeacEmail() {
		return this.chTeacEmail;
	}

	public void setChTeacEmail(String chTeacEmail) {
		this.chTeacEmail = chTeacEmail;
	}

	@Column(name = "ch_teac_memo", length = 100)
	public String getChTeacMemo() {
		return this.chTeacMemo;
	}

	public void setChTeacMemo(String chTeacMemo) {
		this.chTeacMemo = chTeacMemo;
	}

}