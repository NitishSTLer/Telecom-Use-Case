package com.tel.Filters;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SimpleCOSRFilter  implements Filter {
	
	
	public SimpleCOSRFilter() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;
		HttpServletRequest request = (HttpServletRequest) req;
		response.setHeader("Access-Control-Allow-origin", "*");
		response.setHeader("Access-control-Allow-Methods", "POST, GET, PUT, PATCH, OPTIONS,DELETE");
		response.setHeader("Access-Control-Max-Age", "3600");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with, authorization, content-type");


		if ("OPTIONS".equalsIgnoreCase(request.getMethod())){

		}else{
			chain.doFilter(req,res);
		}
	}

	@Override
	public void init(FilterConfig filterConfig){

	}

	@Override
	public void destroy(){

}
}