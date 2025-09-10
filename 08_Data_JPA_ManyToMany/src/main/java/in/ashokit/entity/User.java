package in.ashokit.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	private String userName;
	
	@ManyToMany(cascade = CascadeType.PERSIST)  // allow saving new roles automatically
	@JoinTable(
	    name = "user_roles",
	    joinColumns = @JoinColumn(name = "user_id"),
	    inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> roles = new HashSet<>();



	 public Integer getUserId() {
		 return userId;
	 }


	 public void setUserId(Integer userId) {
		 this.userId = userId;
	 }


	 public String getUserName() {
		 return userName;
	 }


	 public void setUserName(String userName) {
		 this.userName = userName;
	 }


	 public Set<Role> getRoles() {
		 return roles;
	 }


	 public void setRoles(Set<Role> roles) {
		 this.roles = roles;
	 }


	 @Override
	 public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", roles=" + roles + "]";
	 }

  
	 
}
