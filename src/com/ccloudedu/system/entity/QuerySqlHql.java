package com.ccloudedu.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.ccloudedu.base.entity.BaseEntity;

@Entity
@Table(name = "query_SQL_HQL")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class QuerySqlHql extends BaseEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*private enum QueryType{
		 hql,
		 sql
	}*/
	private String queryName;
	private String description;
	private String sqlHql;
	//private QueryType queryType;
	private SysMenu menu;
	private SysUser updateUser;
	private String updateTime;
	
	@Column(name = "QUERY_NAME", length = 128)
	public String getQueryName() {
		return queryName;
	}
	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}
	
	@Column(name = "DESCRIPTION", length = 256)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Lob
	@Column(name = "SQL_HQL")
	public String getSqlHql() {
		return sqlHql;
	}
	public void setSqlHql(String sqlHql) {
		this.sqlHql = sqlHql;
	}
	
/*	@Column(name = "QUERY_TYPE", length = 10)
	@Enumerated(EnumType.STRING)
	public QueryType getQueryType() {
		return queryType;
	}
	public void setQueryType(QueryType queryType) {
		this.queryType = queryType;
	}
	*/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MENU_ID")
	public SysMenu getMenu() {
		return menu;
	}

	public void setMenu(SysMenu menu) {
		this.menu = menu;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UPDATE_USER_ID")
	public SysUser getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(SysUser updateUser) {
		this.updateUser = updateUser;
	}
	
	@Column(name = "UPDATE_TIME", length = 20)
	public String getUpdateTime() {
		return updateTime;
	}
	
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
}
