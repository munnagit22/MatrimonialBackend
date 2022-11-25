package com.MatrimonyApp.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "registration")
public class UserRegistration {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
	private int id;
	
	private String btype;
	private String customerName;
	private int age;
	private String email;
	private String password;
	private String dateOfBirth;
	private String height;
	private String religion;
	private String subcast;
	private String country;
	private String income;
	private String education;
	private String profession;
	private String familyDetails;
	private String status;
	private String subcription;
	private String substard;
	private String subend;
	private String contact;
	private String maritalstatus;
	
	
	
	public UserRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getBtype() {
		return btype;
	}



	public void setBtype(String btype) {
		this.btype = btype;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public String getHeight() {
		return height;
	}



	public void setHeight(String height) {
		this.height = height;
	}



	public String getReligion() {
		return religion;
	}



	public void setReligion(String religion) {
		this.religion = religion;
	}



	public String getSubcast() {
		return subcast;
	}



	public void setSubcast(String subcast) {
		this.subcast = subcast;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getIncome() {
		return income;
	}



	public void setIncome(String income) {
		this.income = income;
	}



	public String getEducation() {
		return education;
	}



	public void setEducation(String education) {
		this.education = education;
	}



	public String getProfession() {
		return profession;
	}



	public void setProfession(String profession) {
		this.profession = profession;
	}



	public String getFamilyDetails() {
		return familyDetails;
	}



	public void setFamilyDetails(String familyDetails) {
		this.familyDetails = familyDetails;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public String getSubcription() {
		return subcription;
	}



	public void setSubcription(String subcription) {
		this.subcription = subcription;
	}



	public String getSubstard() {
		return substard;
	}



	public void setSubstard(String substard) {
		this.substard = substard;
	}



	public String getSubend() {
		return subend;
	}



	public void setSubend(String subend) {
		this.subend = subend;
	}



	public String getContact() {
		return contact;
	}



	public void setContact(String contact) {
		this.contact = contact;
	}



	public String getMaritalstatus() {
		return maritalstatus;
	}



	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}



	public UserRegistration(int id, String btype, String customerName, int age, String email, String password,
			String dateOfBirth, String height, String religion, String subcast, String country, String income,
			String education, String profession, String familyDetails, String status, String subcription,
			String substard, String subend, String contact, String maritalstatus) {
		super();
		this.id = id;
		this.btype = btype;
		this.customerName = customerName;
		this.age = age;
		this.email = email;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.height = height;
		this.religion = religion;
		this.subcast = subcast;
		this.country = country;
		this.income = income;
		this.education = education;
		this.profession = profession;
		this.familyDetails = familyDetails;
		this.status = status;
		this.subcription = subcription;
		this.substard = substard;
		this.subend = subend;
		this.contact = contact;
		this.maritalstatus = maritalstatus;
	}



	@Override
	public String toString() {
		return "UserRegistration [id=" + id + ", btype=" + btype + ", customerName=" + customerName + ", age=" + age
				+ ", email=" + email + ", password=" + password + ", dateOfBirth=" + dateOfBirth + ", height=" + height
				+ ", religion=" + religion + ", subcast=" + subcast + ", country=" + country + ", income=" + income
				+ ", education=" + education + ", profession=" + profession + ", familyDetails=" + familyDetails
				+ ", status=" + status + ", subcription=" + subcription + ", substard=" + substard + ", subend="
				+ subend + ", contact=" + contact + ", maritalstatus=" + maritalstatus + "]";
	}



	
	
	
}
