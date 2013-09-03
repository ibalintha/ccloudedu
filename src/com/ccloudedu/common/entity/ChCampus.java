package com.ccloudedu.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ccloudedu.base.entity.IDEntity;


/**
 * ChCampus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="ch_campus")

public class ChCampus extends IDEntity implements java.io.Serializable {


    // Fields    

//     private String id;
     private String chCampCode;
     private String chCampName;
     private String chCampDesc;
     private String chCampShowflag;
     private String chCampMemo;
     private String chCampAddress;


    // Constructors

    /** default constructor */
    public ChCampus() {
    }
   
    public ChCampus(String chCampCode, String chCampName, String chCampDesc,
			String chCampShowflag, String chCampMemo, String chCampAddress) {
		super();
		this.chCampCode = chCampCode;
		this.chCampName = chCampName;
		this.chCampDesc = chCampDesc;
		this.chCampShowflag = chCampShowflag;
		this.chCampMemo = chCampMemo;
		this.chCampAddress = chCampAddress;
	}

	public ChCampus(String id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

    
    @Column(name="ch_camp_code", length=20)

    public String getChCampCode() {
        return this.chCampCode;
    }
    
    public void setChCampCode(String chCampCode) {
        this.chCampCode = chCampCode;
    }
    
    @Column(name="ch_camp_name", length=50)

    public String getChCampName() {
        return this.chCampName;
    }
    
    public void setChCampName(String chCampName) {
        this.chCampName = chCampName;
    }
    
    @Column(name="ch_camp_desc", length=100)

    public String getChCampDesc() {
        return this.chCampDesc;
    }
    
    public void setChCampDesc(String chCampDesc) {
        this.chCampDesc = chCampDesc;
    }
    
    @Column(name="ch_camp_showflag", length=1)

    public String getChCampShowflag() {
        return this.chCampShowflag;
    }
    
    public void setChCampShowflag(String chCampShowflag) {
        this.chCampShowflag = chCampShowflag;
    }
    
    @Column(name="ch_camp_memo", length=100)

    public String getChCampMemo() {
        return this.chCampMemo;
    }
    
    public void setChCampMemo(String chCampMemo) {
        this.chCampMemo = chCampMemo;
    }
    
    @Column(name="ch_camp_address", length=100)

    public String getChCampAddress() {
        return this.chCampAddress;
    }
    
    public void setChCampAddress(String chCampAddress) {
        this.chCampAddress = chCampAddress;
    }
   








}