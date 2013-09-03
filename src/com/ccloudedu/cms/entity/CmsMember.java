package com.ccloudedu.cms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.entity.IDEntity;

@Entity
@Table(name = "CMS_MEMBER")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class CmsMember extends IDEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7561132308100024568L;
	private int score;
	private int coupon;
	private String uploadStatDate;
	private int uploadTotalSize;
	private String isDisabled;
	private String name;
	private String registerTime;
	private String sex;
	private String telephone;
	private String email;
	private String password;

	private CmsMemberGroup cmsMemberGroup;
	
	public CmsMember() {
	}

	public CmsMember(String id) {
		super(id);
	}

	public CmsMember(String id, CmsMemberGroup cmsMemberGroup,
			int score, int coupon, String uploadStatDate,
			int uploadTotalSize, String isDisabled, String name,
			String registerTime, String sex, String telephone, String email,
			String password) {
		super(id);
		this.cmsMemberGroup = cmsMemberGroup;
		this.score = score;
		this.coupon = coupon;
		this.uploadStatDate = uploadStatDate;
		this.uploadTotalSize = uploadTotalSize;
		this.isDisabled = isDisabled;
		this.name = name;
		this.registerTime = registerTime;
		this.sex = sex;
		this.telephone = telephone;
		this.email = email;
		this.password = password;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MEMBGER_GROUP_ID")
	public CmsMemberGroup getCmsMemberGroup() {
		return this.cmsMemberGroup;
	}

	public void setCmsMemberGroup(CmsMemberGroup cmsMemberGroup) {
		this.cmsMemberGroup = cmsMemberGroup;
	}

	@Column(name = "SCORE", precision = 22, scale = 0)
	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Column(name = "COUPON", precision = 22, scale = 0)
	public int getCoupon() {
		return this.coupon;
	}

	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}

	@Column(name = "UPLOAD_STAT_DATE", length = 20)
	public String getUploadStatDate() {
		return this.uploadStatDate;
	}

	public void setUploadStatDate(String uploadStatDate) {
		this.uploadStatDate = uploadStatDate;
	}

	@Column(name = "UPLOAD_TOTAL_SIZE", precision = 22, scale = 0)
	public int getUploadTotalSize() {
		return this.uploadTotalSize;
	}

	public void setUploadTotalSize(int uploadTotalSize) {
		this.uploadTotalSize = uploadTotalSize;
	}

	@Column(name = "IS_DISABLED", length = 1)
	public String getIsDisabled() {
		return this.isDisabled;
	}

	public void setIsDisabled(String isDisabled) {
		this.isDisabled = isDisabled;
	}

	@Column(name = "NAME", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "REGISTER_TIME", length = 20)
	public String getRegisterTime() {
		return this.registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}

	@Column(name = "SEX", length = 1)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "TELEPHONE", length = 20)
	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "EMAIL", length = 20)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PASSWORD", length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
