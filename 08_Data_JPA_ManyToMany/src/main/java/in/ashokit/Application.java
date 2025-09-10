package in.ashokit;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.entity.Role;
import in.ashokit.entity.User;
import in.ashokit.repository.RoleRepository;
import in.ashokit.repository.UserRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class);
		RoleRepository roleRepository = context.getBean(RoleRepository.class);

		Role role1 = new Role();
		role1.setRoleName("Manager");

		Role role2 = new Role();
		role2.setRoleName("Senior");

		User user1 = new User();
		user1.setUserName("Ram");
		user1.getRoles().add(role1);
		user1.getRoles().add(role2);

		userRepository.save(user1);  // ✅ This will save roles + mapping

	}

}
