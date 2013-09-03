package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import com.ccloudedu.base.dao.cache.CacheConstants;
import com.ccloudedu.base.dao.cache.EhCacheManager;
import com.ccloudedu.base.entity.IDEntity;

/**
 * ChStudent entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ch_student")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class ChStudent extends IDEntity implements java.io.Serializable,HttpSessionBindingListener{

	// Fields
	/**
	 * 
	 */
	private static final long serialVersionUID = -7967409295585873881L;
	private String chStudSchroll;
	private String chStudSchcode;
	private String chStudName;
	private String chStudPinyin;
	private String chStudEngname;
	private String chStudOldname;
	private String chStudEnrolldate;
	private String chStudGrade;
	private String chClasId;
	private String chStudType;
	private String chStudPersontype;
	private String chStudPersonid;
	private String chStudSex;
	private String chStudBirth;
	private String chStudBirthplace;
	private String chStudOnly;
	private String chStudHometown;
//	private String chStudEthnic;
	private String chStudOldschool;
	private String chStudAdmway;
	private String chStudForeign;
	private String chStudSourareas;
	private String chStudHealth;
	private String chStudBloodtype;
	private String chStudPolface;
	private String chStudAddress;
	private String chStudLocakind;
	private String chStudLocation;
	private String chStudFlowperson;
	private String chStudNational;
	private String chStudPhone;
	private String chStudTranaddress;
	private String chStudZip;
	private String chStudEmail;
	private String chStudWebsite;
	private String chStudCadreflag;
	private String chStudImage;
	private String chStudScore;
	private String chStudSpecial;
	private String chStudUpdateflag;
	private String chStudMemo;
	private String chStudMaketime;
	
	private ChEthnic chethnic;

	// Constructors

	/** default constructor */
	public ChStudent() {
	}


	/** full constructor */
	public ChStudent( String chStudSchroll, String chStudSchcode,
			String chStudName, String chStudPinyin, String chStudEngname,
			String chStudOldname, String chStudEnrolldate, String chStudGrade,
			String chClasId, String chStudType, String chStudPersontype,
			String chStudPersonid, String chStudSex, String chStudBirth,
			String chStudBirthplace, String chStudOnly, String chStudHometown,
//			String chStudEthnic, 
			String chStudOldschool, String chStudAdmway,
			String chStudForeign, String chStudSourareas, String chStudHealth,
			String chStudBloodtype, String chStudPolface, String chStudAddress,
			String chStudLocakind, String chStudLocation,
			String chStudFlowperson, String chStudNational, String chStudPhone,
			String chStudTranaddress, String chStudZip, String chStudEmail,
			String chStudWebsite, String chStudCadreflag, String chStudImage,
			String chStudScore, String chStudSpecial, String chStudUpdateflag,
			String chStudMemo, String chStudMaketime,ChEthnic chethnic) {
		this.chStudSchroll = chStudSchroll;
		this.chStudSchcode = chStudSchcode;
		this.chStudName = chStudName;
		this.chStudPinyin = chStudPinyin;
		this.chStudEngname = chStudEngname;
		this.chStudOldname = chStudOldname;
		this.chStudEnrolldate = chStudEnrolldate;
		this.chStudGrade = chStudGrade;
		this.chClasId = chClasId;
		this.chStudType = chStudType;
		this.chStudPersontype = chStudPersontype;
		this.chStudPersonid = chStudPersonid;
		this.chStudSex = chStudSex;
		this.chStudBirth = chStudBirth;
		this.chStudBirthplace = chStudBirthplace;
		this.chStudOnly = chStudOnly;
		this.chStudHometown = chStudHometown;
//		this.chStudEthnic = chStudEthnic;
		this.chStudOldschool = chStudOldschool;
		this.chStudAdmway = chStudAdmway;
		this.chStudForeign = chStudForeign;
		this.chStudSourareas = chStudSourareas;
		this.chStudHealth = chStudHealth;
		this.chStudBloodtype = chStudBloodtype;
		this.chStudPolface = chStudPolface;
		this.chStudAddress = chStudAddress;
		this.chStudLocakind = chStudLocakind;
		this.chStudLocation = chStudLocation;
		this.chStudFlowperson = chStudFlowperson;
		this.chStudNational = chStudNational;
		this.chStudPhone = chStudPhone;
		this.chStudTranaddress = chStudTranaddress;
		this.chStudZip = chStudZip;
		this.chStudEmail = chStudEmail;
		this.chStudWebsite = chStudWebsite;
		this.chStudCadreflag = chStudCadreflag;
		this.chStudImage = chStudImage;
		this.chStudScore = chStudScore;
		this.chStudSpecial = chStudSpecial;
		this.chStudUpdateflag = chStudUpdateflag;
		this.chStudMemo = chStudMemo;
		this.chStudMaketime = chStudMaketime;
		this.chethnic = chethnic;
	}

	@Column(name = "ch_stud_schroll", length = 20)
	public String getChStudSchroll() {
		return this.chStudSchroll;
	}

	public void setChStudSchroll(String chStudSchroll) {
		this.chStudSchroll = chStudSchroll;
	}

	@Column(name = "ch_stud_schcode", length = 20)
	public String getChStudSchcode() {
		return this.chStudSchcode;
	}

	public void setChStudSchcode(String chStudSchcode) {
		this.chStudSchcode = chStudSchcode;
	}

	@Column(name = "ch_stud_name", length = 20)
	public String guf() {
		return this.chStudName;
	}

	public void setChStudName(String chStudName) {
		this.chStudName = chStudName;
	}
	
	@Column(name = "ch_stud_pinyin", length = 50)
	public String getChStudPinyin() {
		return this.chStudPinyin;
	}
	@Column(name = "ch_stud_name", length = 50)
	public String getChStudName() {
		return this.chStudName;
	}

	public void setChStudPinyin(String chStudPinyin) {
		this.chStudPinyin = chStudPinyin;
	}

	@Column(name = "ch_stud_engname", length = 20)
	public String getChStudEngname() {
		return this.chStudEngname;
	}

	public void setChStudEngname(String chStudEngname) {
		this.chStudEngname = chStudEngname;
	}

	@Column(name = "ch_stud_oldname", length = 20)
	public String getChStudOldname() {
		return this.chStudOldname;
	}

	public void setChStudOldname(String chStudOldname) {
		this.chStudOldname = chStudOldname;
	}

	@Column(name = "ch_stud_enrolldate", length = 20)
	public String getChStudEnrolldate() {
		return this.chStudEnrolldate;
	}

	public void setChStudEnrolldate(String chStudEnrolldate) {
		this.chStudEnrolldate = chStudEnrolldate;
	}

	@Column(name = "ch_stud_grade", length = 20)
	public String getChStudGrade() {
		return this.chStudGrade;
	}

	public void setChStudGrade(String chStudGrade) {
		this.chStudGrade = chStudGrade;
	}

	@Column(name = "ch_clas_id", length = 50)
	public String getChClasId() {
		return this.chClasId;
	}

	public void setChClasId(String chClasId) {
		this.chClasId = chClasId;
	}

	@Column(name = "ch_stud_type", length = 20)
	public String getChStudType() {
		return this.chStudType;
	}

	public void setChStudType(String chStudType) {
		this.chStudType = chStudType;
	}

	@Column(name = "ch_stud_persontype", length = 20)
	public String getChStudPersontype() {
		return this.chStudPersontype;
	}

	public void setChStudPersontype(String chStudPersontype) {
		this.chStudPersontype = chStudPersontype;
	}

	@Column(name = "ch_stud_personid", length = 20)
	public String getChStudPersonid() {
		return this.chStudPersonid;
	}

	public void setChStudPersonid(String chStudPersonid) {
		this.chStudPersonid = chStudPersonid;
	}

	@Column(name = "ch_stud_sex", length = 20)
	public String getChStudSex() {
		return this.chStudSex;
	}

	public void setChStudSex(String chStudSex) {
		this.chStudSex = chStudSex;
	}

	@Column(name = "ch_stud_birth", length = 20)
	public String getChStudBirth() {
		return this.chStudBirth;
	}

	public void setChStudBirth(String chStudBirth) {
		this.chStudBirth = chStudBirth;
	}

	@Column(name = "ch_stud_birthplace", length = 20)
	public String getChStudBirthplace() {
		return this.chStudBirthplace;
	}

	public void setChStudBirthplace(String chStudBirthplace) {
		this.chStudBirthplace = chStudBirthplace;
	}

	@Column(name = "ch_stud_only", length = 20)
	public String getChStudOnly() {
		return this.chStudOnly;
	}

	public void setChStudOnly(String chStudOnly) {
		this.chStudOnly = chStudOnly;
	}

	@Column(name = "ch_stud_hometown", length = 20)
	public String getChStudHometown() {
		return this.chStudHometown;
	}

	public void setChStudHometown(String chStudHometown) {
		this.chStudHometown = chStudHometown;
	}

//	@Column(name = "ch_stud_ethnic", length = 20)
//	public String getChStudEthnic() {
//		return this.chStudEthnic;
//	}
//
//	public void setChStudEthnic(String chStudEthnic) {
//		this.chStudEthnic = chStudEthnic;
//	}

	@Column(name = "ch_stud_oldschool", length = 20)
	public String getChStudOldschool() {
		return this.chStudOldschool;
	}

	public void setChStudOldschool(String chStudOldschool) {
		this.chStudOldschool = chStudOldschool;
	}

	@Column(name = "ch_stud_admway", length = 20)
	public String getChStudAdmway() {
		return this.chStudAdmway;
	}

	public void setChStudAdmway(String chStudAdmway) {
		this.chStudAdmway = chStudAdmway;
	}

	@Column(name = "ch_stud_foreign", length = 20)
	public String getChStudForeign() {
		return this.chStudForeign;
	}

	public void setChStudForeign(String chStudForeign) {
		this.chStudForeign = chStudForeign;
	}

	@Column(name = "ch_stud_sourareas", length = 20)
	public String getChStudSourareas() {
		return this.chStudSourareas;
	}

	public void setChStudSourareas(String chStudSourareas) {
		this.chStudSourareas = chStudSourareas;
	}

	@Column(name = "ch_stud_health", length = 20)
	public String getChStudHealth() {
		return this.chStudHealth;
	}

	public void setChStudHealth(String chStudHealth) {
		this.chStudHealth = chStudHealth;
	}

	@Column(name = "ch_stud_bloodtype", length = 20)
	public String getChStudBloodtype() {
		return this.chStudBloodtype;
	}

	public void setChStudBloodtype(String chStudBloodtype) {
		this.chStudBloodtype = chStudBloodtype;
	}

	@Column(name = "ch_stud_polface", length = 20)
	public String getChStudPolface() {
		return this.chStudPolface;
	}

	public void setChStudPolface(String chStudPolface) {
		this.chStudPolface = chStudPolface;
	}

	@Column(name = "ch_stud_address", length = 100)
	public String getChStudAddress() {
		return this.chStudAddress;
	}

	public void setChStudAddress(String chStudAddress) {
		this.chStudAddress = chStudAddress;
	}

	@Column(name = "ch_stud_locakind", length = 20)
	public String getChStudLocakind() {
		return this.chStudLocakind;
	}

	public void setChStudLocakind(String chStudLocakind) {
		this.chStudLocakind = chStudLocakind;
	}

	@Column(name = "ch_stud_location", length = 100)
	public String getChStudLocation() {
		return this.chStudLocation;
	}

	public void setChStudLocation(String chStudLocation) {
		this.chStudLocation = chStudLocation;
	}

	@Column(name = "ch_stud_flowperson", length = 20)
	public String getChStudFlowperson() {
		return this.chStudFlowperson;
	}

	public void setChStudFlowperson(String chStudFlowperson) {
		this.chStudFlowperson = chStudFlowperson;
	}

	@Column(name = "ch_stud_national", length = 20)
	public String getChStudNational() {
		return this.chStudNational;
	}

	public void setChStudNational(String chStudNational) {
		this.chStudNational = chStudNational;
	}

	@Column(name = "ch_stud_phone", length = 20)
	public String getChStudPhone() {
		return this.chStudPhone;
	}

	public void setChStudPhone(String chStudPhone) {
		this.chStudPhone = chStudPhone;
	}

	@Column(name = "ch_stud_tranaddress", length = 20)
	public String getChStudTranaddress() {
		return this.chStudTranaddress;
	}

	public void setChStudTranaddress(String chStudTranaddress) {
		this.chStudTranaddress = chStudTranaddress;
	}

	@Column(name = "ch_stud_zip", length = 20)
	public String getChStudZip() {
		return this.chStudZip;
	}

	public void setChStudZip(String chStudZip) {
		this.chStudZip = chStudZip;
	}

	@Column(name = "ch_stud_email", length = 50)
	public String getChStudEmail() {
		return this.chStudEmail;
	}

	public void setChStudEmail(String chStudEmail) {
		this.chStudEmail = chStudEmail;
	}

	@Column(name = "ch_stud_website", length = 20)
	public String getChStudWebsite() {
		return this.chStudWebsite;
	}

	public void setChStudWebsite(String chStudWebsite) {
		this.chStudWebsite = chStudWebsite;
	}

	@Column(name = "ch_stud_cadreflag", length = 2)
	public String getChStudCadreflag() {
		return this.chStudCadreflag;
	}

	public void setChStudCadreflag(String chStudCadreflag) {
		this.chStudCadreflag = chStudCadreflag;
	}

	@Column(name = "ch_stud_image", length = 50)
	public String getChStudImage() {
		return this.chStudImage;
	}

	public void setChStudImage(String chStudImage) {
		this.chStudImage = chStudImage;
	}

	@Column(name = "ch_stud_score", length = 20)
	public String getChStudScore() {
		return this.chStudScore;
	}

	public void setChStudScore(String chStudScore) {
		this.chStudScore = chStudScore;
	}

	@Column(name = "ch_stud_special", length = 20)
	public String getChStudSpecial() {
		return this.chStudSpecial;
	}

	public void setChStudSpecial(String chStudSpecial) {
		this.chStudSpecial = chStudSpecial;
	}

	@Column(name = "ch_stud_updateflag", length = 2)
	public String getChStudUpdateflag() {
		return this.chStudUpdateflag;
	}

	public void setChStudUpdateflag(String chStudUpdateflag) {
		this.chStudUpdateflag = chStudUpdateflag;
	}

	@Column(name = "ch_stud_memo", length = 500)
	public String getChStudMemo() {
		return this.chStudMemo;
	}

	public void setChStudMemo(String chStudMemo) {
		this.chStudMemo = chStudMemo;
	}

	@Column(name = "ch_stud_maketime", length = 20)
	public String getChStudMaketime() {
		return this.chStudMaketime;
	}

	public void setChStudMaketime(String chStudMaketime) {
		this.chStudMaketime = chStudMaketime;
	}
	public void valueBound(HttpSessionBindingEvent event) {
		//放入ehcache
		EhCacheManager.put(CacheConstants.HTTP_SESSION_CACHE, event.getSession().getId(), this);
	}

    /**
     * 用户退出时，从ehcache缓存中删除该用户的信息
     */
	public void valueUnbound(HttpSessionBindingEvent event) {
		//从ehcache中移除
		EhCacheManager.remove(CacheConstants.HTTP_SESSION_CACHE, event.getSession().getId());
	}

	@ManyToOne
	@JoinColumn(name="ch_stud_ethnic")
	public ChEthnic getChethnic() {
		return chethnic;
	}


	public void setChethnic(ChEthnic chethnic) {
		this.chethnic = chethnic;
	}

	
	
	
}