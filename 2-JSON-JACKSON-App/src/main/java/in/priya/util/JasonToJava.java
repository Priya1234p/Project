package in.priya.util;

import java.io.FileReader;
import com.google.gson.Gson;

import in.priya.binding.Passenger;

public class JasonToJava {
	
	public static void  main(String[] args) throws Exception {
		
		/*
		 * ObjectMapper mapper =new ObjectMapper(); Passenger passenger =
		 * mapper.readValue(new File("passenger.json"), Passenger.class);
		 */
		
		Gson gson = new Gson();
		Passenger p = gson.fromJson(new FileReader("passenger.json"),Passenger.class);
		System.out.println(p);
	}

}
