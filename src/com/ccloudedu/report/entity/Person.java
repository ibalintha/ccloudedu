package com.ccloudedu.report.entity;

public class Person {
	private String person_Id;

	private String person_name;

	private String person_sex;
	
	private String person_birthday;
	
	private String person_age;
	
	private String person_ethnicGroup;
	
	private String person_hometown;
	
	private String person_address;

	public Person() {

	}

	public Person(String id, String name, String sex, String age,String birthday, String ethnicGroup, String hometown, String address) {
		this.person_Id = id;
		this.person_name = name;
		this.person_sex = sex;
		this.person_birthday = birthday;
		this.person_age = age;
		this.person_ethnicGroup = ethnicGroup;
		this.person_hometown = hometown;
		this.person_address = address;
	}

	public String getPerson_address() {
		return person_address;
	}

	public void setPerson_address(String person_address) {
		this.person_address = person_address;
	}

	public String getPerson_age() {
		return person_age;
	}

	public void setPerson_age(String person_age) {
		this.person_age = person_age;
	}

	public String getPerson_Id() {
		return person_Id;
	}

	public void setPerson_Id(String person_Id) {
		this.person_Id = person_Id;
	}

	public String getPerson_name() {
		return person_name;
	}

	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}

	public String getPerson_sex() {
		return person_sex;
	}

	public void setPerson_sex(String person_sex) {
		this.person_sex = person_sex;
	}

	public String getPerson_birthday() {
		return person_birthday;
	}

	public void setPerson_birthday(String person_birthday) {
		this.person_birthday = person_birthday;
	}

	public String getPerson_ethnicGroup() {
		return person_ethnicGroup;
	}

	public void setPerson_ethnicGroup(String person_ethnicGroup) {
		this.person_ethnicGroup = person_ethnicGroup;
	}

	public String getPerson_hometown() {
		return person_hometown;
	}

	public void setPerson_hometown(String person_hometown) {
		this.person_hometown = person_hometown;
	}
}
