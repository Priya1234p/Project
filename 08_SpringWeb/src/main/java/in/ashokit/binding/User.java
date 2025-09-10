package in.ashokit.binding;

public class User {
	
	private String name;
	private String email;
	private Long phNo;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getPhNo() {
		return phNo;
	}
	public void setPhNo(Long phNo) {
		this.phNo = phNo;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", phNo=" + phNo + "]";
	}
	
	

}
