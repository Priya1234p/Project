package in.ashokit;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.entity.Address;
import in.ashokit.entity.Employee;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		EmpRepository empRepository = context.getBean(EmpRepository.class);
		
		
		  Employee e = new Employee();
		  e.setEmpName("Raja"); 
		  e.setEmpSalary(4000.00);
		  
		  Address a = new Address(); a.setCity("Hyd"); a.setState("Tg");
		  a.setCountry("India");
		  a.setEmp(e);
		  
		  Address a1 = new Address(); a1.setCity("Blr"); a1.setState("kar");
		  a1.setCountry("India");
		  a1.setEmp(e);
		  
		  List<Address> addrList = Arrays.asList(a, a1);
		  e.setAddr(addrList);
		  
		  empRepository.getById(2);
		//empRepository.save(e);
		  
		  //System.out.println("Record inserted..........");
		 
		//empRepository.deleteById(1);
		//System.out.println("Record deleted..........");
	}

}
