package springboot.backend.apirest.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("interceptor")
public class interceptor implements HandlerInterceptor{
	
	private static final Logger logger = LoggerFactory.getLogger(interceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String customerId=request.getParameter("customerId");
		String producto1=request.getParameter("producto1");
		String producto2=request.getParameter("producto2");
		String producto3=request.getParameter("producto3");
		String producto4=request.getParameter("producto4");
		String producto5=request.getParameter("producto5");
		logger.info("Producto 5 ;" + producto5);
	
		
		
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {


	}

	
}

