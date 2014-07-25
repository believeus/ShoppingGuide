package com.etech.filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.etech.entity.Tshopuser;
import com.etech.webutil.Variables;

public class AccessFilter implements Filter {
	private  Log log = LogFactory.getLog(AccessFilter.class);
	private List<String> allowAccessURLs;
	private List<String> sessionUserUnAccessURL;

	@Override
	public void init(FilterConfig config) throws ServletException {
		allowAccessURLs=Arrays.asList(config.getInitParameter("allowAccessURL").split(","));
		sessionUserUnAccessURL=Arrays.asList(config.getInitParameter("sessionUserUnAccessURL").split(","));
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httprequest = (HttpServletRequest) request;
		HttpSession session = httprequest.getSession();
		Tshopuser sessionUser = (Tshopuser) session.getAttribute(Variables.sessionUser);
		HttpServletResponse httpresponse = (HttpServletResponse) response;
		String requestURI = httprequest.getRequestURI();
		log.debug("current access uri:" + requestURI);
		if (allowAccessURLs.contains(requestURI)) {
			chain.doFilter(request, response);
			return;
		}else {
			if(sessionUser==null){
				httpresponse.sendRedirect("/login.jhtml");
				return;
			}else {
				chain.doFilter(request, response);
			}
		}
		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {

	}
}
