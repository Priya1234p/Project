package in.priya.util;
import com.google.gson.Gson;

import in.priya.binding.Address;
import in.priya.binding.Passenger;

public class JavaToJson {
	public static void main(String[]args) throws Exception{
		
	Address addr = new Address();
	addr.setCity("Blr");
	addr.setState("kar");
	addr.setCountry("India");
	
	
	Passenger passenger = new Passenger();
	passenger.setName("Raju");
	passenger.setGender("Male");
	passenger.setFrom("Durgapur");
	passenger.setTo("Bangalore");
	passenger.setAddr(addr);
	
	
	/*
	 * ObjectMapper mapper = new ObjectMapper(); mapper.writeValue(new
	 * File("passenger.json"), passenger);
	 */
	
	Gson gson = new Gson();
	String json= gson.toJson(passenger);
	System.out.println(json);
	
	System.out.println("done....");
	}

}
