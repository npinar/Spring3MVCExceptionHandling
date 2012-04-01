package com.myjavasolutions.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class AccessDeniedExceptionResolver implements HandlerExceptionResolver, Ordered{

	private int order;
	
	public int getOrder() {
		return this.order;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		
		//the view is returned as null if there is no AccessDeniedException
		//it will fall through to the next resolver
		ModelAndView view = null;
	    if (ex instanceof AccessDeniedException) {
	      // super special handling lives here
	      view = new ModelAndView("accessDenied");
	    }
	    
	    if(ex instanceof NullPointerException) {
	    	view = new ModelAndView("nullpointer");
	    }
	    return view;
	    
	}

}
