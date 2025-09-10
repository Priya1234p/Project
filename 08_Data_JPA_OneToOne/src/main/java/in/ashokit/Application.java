package in.ashokit;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.entity.Passport;
import in.ashokit.entity.Person;
import in.ashokit.repository.PassportRepository;
import in.ashokit.repository.PersonRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		PersonRepository personRepository = context.getBean(PersonRepository.class);
		PassportRepository passportRepository = context.getBean(PassportRepository.class);
		
		/*
		 * Person person =new Person(); person.setPersonName("Ashok");
		 * person.setPersonGender("Male");
		 * 
		 * Passport passport = new Passport(); passport.setPassportNum("KUH0987K");
		 * passport.setIsssueDate(LocalDate.now());
		 * passport.setExpiryDate(LocalDate.now().plusYears(10));
		 * 
		 * person.setPassport(passport); passport.setPerson(person);
		 * 
		 * personRepository.save(person);
		 */
		
		//personRepository.findById(1);
		
		//personRepository.deleteById(1); // IF we delete person then automatically child record is also deleted
		

	}
	

}
