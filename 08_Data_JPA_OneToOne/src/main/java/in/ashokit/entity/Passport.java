package in.ashokit.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Passport {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer passportId;
	private String passportNum;
	
	private LocalDate isssueDate;
	private LocalDate expiryDate;
	
	
	@OneToOne
	@JoinColumn(name="person_id") // it is a forign key 
	private Person person;


	public Integer getPassportId() {
		return passportId;
	}


	public void setPassportId(Integer passportId) {
		this.passportId = passportId;
	}


	public String getPassportNum() {
		return passportNum;
	}


	public void setPassportNum(String passportNum) {
		this.passportNum = passportNum;
	}


	public LocalDate getIsssueDate() {
		return isssueDate;
	}


	public void setIsssueDate(LocalDate isssueDate) {
		this.isssueDate = isssueDate;
	}


	public LocalDate getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}


	public Person getPerson() {
		return person;
	}


	public void setPerson(Person person) {
		this.person = person;
	}



	
	
	
}
