package com.naver;

import java.sql.Date;

public class MemberDTO {

	private String id;
	private String password;
	private String name;
	private int age;
	private Date birth;
	private String userhero;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	

	public MemberDTO(String id, String password, String name, int age, Date birth, String userhero) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.birth = birth;
		this.userhero = userhero;
	}

	


	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public Date getBirth() {
		return birth;
	}



	public void setBirth(Date birth) {
		this.birth = birth;
	}



	public String getUserhero() {
		return userhero;
	}



	public void setUserhero(String userhero) {
		this.userhero = userhero;
	}



	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", password=" + password + ", name=" + name + ", age=" + age + ", birth=" + birth
				+ ", userhero=" + userhero + "]";
	}
	
	
}
