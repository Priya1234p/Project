package in.ashokit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class MakeMyTripService {

	@Value("${irctc.endpoint.book_ticket}")
	private String IRCTC_BOOK_TICKET_URL;
	
	@Value("${irctc.endpoint.get_ticket}")
	private String IRCTC_GET_TICKET_URL;
	
	public void getTicketInfoSync(String ticketId) {
	    System.out.println("sync method is started..");

	    try {
	        WebClient client = WebClient.create();
	        String response = client.get()
	                .uri(IRCTC_GET_TICKET_URL, ticketId)
	                .accept(MediaType.APPLICATION_JSON)
	                .retrieve()
	                .bodyToMono(String.class)
	                .block();

	        System.out.println("Response received: " + response);
	    } catch (Exception e) {
	        System.out.println("Error occurred while calling IRCTC API: " + e.getMessage());
	        e.printStackTrace();
	    }

	    System.out.println("sync method is ended..");
	}


}
