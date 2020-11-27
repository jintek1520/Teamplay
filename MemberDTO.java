package com.naver;

import java.io.Serializable;
import java.util.Date;

public class MemberDTO implements Serializable {
	
	private static final long serialVersionUid = 1L;
	private String mid;
	private String passwordd;
	private int age;
	private String name;
	private String userhero;
	private Date birth;

	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public MemberDTO(String id, String passwordd, int age, String name, String userhero, Date birth) {
		super();
		this.mid = id;
		this.passwordd = passwordd;
		this.age = age;
		this.name = name;
		this.userhero = userhero;
		this.birth = birth;
	}

	public String getid() {
		return mid;
	}

	public void setid(String id) {
		this.mid = id;
	}

	public String getPasswordd() {
		return passwordd;
	}

	public void setPasswordd(String passwordd) {
		this.passwordd = passwordd;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserhero() {
		return userhero;
	}

	public void setUserhero(String userhero) {
		this.userhero = userhero;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public static long getSerialversionuid() {
		return serialVersionUid;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mid == null) ? 0 : mid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberDTO other = (MemberDTO) obj;
		if (mid == null) {
			if (other.mid != null)
				return false;
		} else if (!mid.equals(other.mid))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MemberDTO [mid=" + mid + ", name=" + name + "]";
	}
}
