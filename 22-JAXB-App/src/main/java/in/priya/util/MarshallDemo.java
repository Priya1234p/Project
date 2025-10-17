package in.priya.util;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import in.priya.binding.Address;
import in.priya.binding.Person;

public class MarshallDemo {
	public static void main (String[] args) throws Exception {
		
		Address addr= new Address();
		addr.setCity("Hyd");
		addr.setState("Tg");
		addr.setCountry("India");
		
		Person p = new Person();
		p.setId(112);
		p.setName("Priya");
		p.setGender("Female");
		p.setEmail("priya@gmail.com");
		p.setAddr(addr);
		
		JAXBContext context = JAXBContext.newInstance(Person.class);
		
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(p, new File("person.xml"));
		
		System.out.println("done.......");
	}

}
