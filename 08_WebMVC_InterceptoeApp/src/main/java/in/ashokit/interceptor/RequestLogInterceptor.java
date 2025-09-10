package in.ashokit.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RequestLogInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle() method..");
		String clientId = request.getParameter("clientId");
		
		//http://localhost:8080/welcome?clientId=ashokIt
		
		//http://localhost:8080/greet?clientId=ashokIt
		
		
		if ("ashokIt".equals(clientId)) {
			return true;
		} else {
			response.getWriter().print("Invalid Request");
			return false;
		}
		/*
		 * long startTime = System.currentTimeMillis();
		 * request.setAttribute("startTime", startTime);
		 * 
		 * return HandlerInterceptor.super.preHandle(request, response, handler);
		 */
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelandview) throws Exception {
		System.out.println("postHandle() method..");
		long endTime = System.currentTimeMillis();
		long startTime = (long) request.getAttribute("startTime");
		long time = endTime - startTime;
		System.out.println("Total time taken (MS)" + time);
		HandlerInterceptor.super.postHandle(request, response, handler, modelandview);
	}

}
