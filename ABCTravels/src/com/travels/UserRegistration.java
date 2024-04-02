package com.travels;

import java.util.Objects;

public class UserRegistration {
	
	String Firstname;
	
	String Lastname;
	
	String Mobilenumber;
	
	String Gender;
	
	String Emailid;

	String Password;
	
	public int failedCount;
	
	String accountstatus;
	
	@Override
	public int hashCode() {
		return Objects.hash(Emailid, Firstname, Gender, Lastname, Mobilenumber, Password, accountstatus, failedCount);
	}



	public UserRegistration(String firstname, String lastname, String mobilenumber, String gender, String emailid,
			String password, int failedCount, String accountstatus) {
		super();
		Firstname = firstname;
		Lastname = lastname;
		Mobilenumber = mobilenumber;
		Gender = gender;
		Emailid = emailid;
		Password = password;
		this.failedCount = 0;
		this.accountstatus ="Active";
	}



	public UserRegistration() {
	}



	@Override
	public String toString() {
		return "UserRegistration [Firstname=" + Firstname + ", Lastname=" + Lastname + ", Mobilenumber=" + Mobilenumber
				+ ", Gender=" + Gender + ", Emailid=" + Emailid + ", Password=" + Password + ", failedCount="
				+ failedCount + ", accountstatus=" + accountstatus + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRegistration other = (UserRegistration) obj;
		return Objects.equals(Emailid, other.Emailid) && Objects.equals(Firstname, other.Firstname)
				&& Objects.equals(Gender, other.Gender) && Objects.equals(Lastname, other.Lastname)
				&& Objects.equals(Mobilenumber, other.Mobilenumber) && Objects.equals(Password, other.Password)
				&& Objects.equals(accountstatus, other.accountstatus) && failedCount == other.failedCount;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public String getMobilenumber() {
		return Mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		Mobilenumber = mobilenumber;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getEmailid() {
		return Emailid;
	}

	public void setEmailid(String emailid) {
		Emailid = emailid;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public int getFailedCount() {
		return failedCount;
	}

	public void setFailedCount(int failedCount) {
		this.failedCount = failedCount;
	}

	public String getAccountstatus() {
		return accountstatus;
	}

	public void setAccountstatus(String accountstatus) {
		this.accountstatus = accountstatus;
	}


	
	
	

}


