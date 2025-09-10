package in.ashokit.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer roleId;
	private String roleName;
	
	 @ManyToMany(mappedBy = "roles")  // mappedBy should match User.roles
	 private Set<User> users = new HashSet<>();

	 public Integer getRoleId() {
		 return roleId;
	 }

	 public void setRoleId(Integer roleId) {
		 this.roleId = roleId;
	 }

	 public String getRoleName() {
		 return roleName;
	 }

	 public void setRoleName(String roleName) {
		 this.roleName = roleName;
	 }

	 public Set<User> getUsers() {
		 return users;
	 }

	 public void setUsers(Set<User> users) {
		 this.users = users;
	 }

	 @Override
	 public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", users=" + users + "]";
	 }
	 
	

}
