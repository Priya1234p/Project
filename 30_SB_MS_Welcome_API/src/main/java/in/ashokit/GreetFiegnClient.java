package in.ashokit;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="GREET_API")
public interface GreetFiegnClient {
	
	@GetMapping("/greet") 
	public String invokeGreetApi();

}
