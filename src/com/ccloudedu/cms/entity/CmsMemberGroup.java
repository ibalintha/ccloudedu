package com.ccloudedu.cms.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.entity.IDEntity;

@Entity
@Table(name = "CMS_MEMBER_GROUP")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class CmsMemberGroup extends IDEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8822420176088057076L;
	private String name;
	private int groupLevel;
	private String description;
	private int uploadSize;
	private Set<CmsMember> cmsMembers = new HashSet<CmsMember>(0);

	public CmsMemberGroup() {
	}

	public CmsMemberGroup(String id) {
		super(id);
	}

	public CmsMemberGroup(String id, String name, int groupLevel,
			String description, int uploadSize, Set<CmsMember> cmsMembers) {
		super(id);
		this.name = name;
		this.groupLevel = groupLevel;
		this.description = description;
		this.uploadSize = uploadSize;
		this.cmsMembers = cmsMembers;
	}

	@Column(name = "NAME", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "GROUP_LEVEL", precision = 22, scale = 0)
	public int getGroupLevel() {
		return this.groupLevel;
	}

	public void setGroupLevel(int groupLevel) {
		this.groupLevel = groupLevel;
	}

	@Column(name = "DESCRIPTION", length = 256)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "UPLOAD_SIZE", precision = 22, scale = 0)
	public int getUploadSize() {
		return this.uploadSize;
	}

	public void setUploadSize(int uploadSize) {
		this.uploadSize = uploadSize;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cmsMemberGroup")
	public Set<CmsMember> getCmsMembers() {
		return this.cmsMembers;
	}

	public void setCmsMembers(Set<CmsMember> cmsMembers) {
		this.cmsMembers = cmsMembers;
	}

}
