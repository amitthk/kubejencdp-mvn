package com.jvcdp.config;


import org.springframework.stereotype.Component;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class SimpleCORSFilter implements javax.servlet.Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		HttpServletRequest  req = (HttpServletRequest) request;
		// Just REPLY OK if request method is OPTIONS for CORS (pre-flight)

		res.addHeader("Access-Control-Allow-Origin", "*");
		res.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
		res.addHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With");
		if ( req.getMethod().equals("OPTIONS") ) {
        res.setStatus(HttpServletResponse.SC_OK);
        return;
    }
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
}
