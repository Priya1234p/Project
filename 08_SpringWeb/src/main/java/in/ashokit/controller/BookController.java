package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	
	// http://localhost:8080/msg?name=buttller
	
	@GetMapping("/msg")
	public ModelAndView getMsg(@RequestParam String name) {
		ModelAndView mav = new ModelAndView();
		
		String msgTxt = "good evening"+name;
		mav.addObject("msg", msgTxt);
		mav.setViewName("index");
		return mav;
	}
	// http://localhost:8080/book?name=spring&author=johnson
	@GetMapping("/book")
	public ModelAndView getBookData(@RequestParam String name, String author) {
		ModelAndView mav = new ModelAndView();
	    
		System.out.println("Name ::"+ name);
		System.out.println("Author ::"+ author);
		mav.addObject("msg", name +"  by  " +author +" is out of stock..");
		mav.setViewName("index");
		return mav;
	}

}
