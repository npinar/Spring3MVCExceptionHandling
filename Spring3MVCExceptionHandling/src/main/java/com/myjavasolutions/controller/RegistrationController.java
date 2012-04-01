package com.myjavasolutions.controller;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myjavasolutions.exception.GenericException;
 
/**
 * This controller class is a dummy class for creating exceptions. 
 * @author npinar
 *
 */
@Controller
public class RegistrationController {
 
    @RequestMapping(value="/onstart", method = RequestMethod.GET)
    public String setupForm(ModelMap model) {
    	return "exceptionsForm";
    }
    
    @RequestMapping(value = "/generateUserDefinedException", method = RequestMethod.POST)
    public void generateGenericException(ModelMap model) {
    	if(true) {
    		throw new GenericException("System error. Please contact support.");
    	}
    }
    
    @RequestMapping(value="/generateIllegalArgumentException", method = RequestMethod.POST)
    public void generateIllegalArgumentException(){
    	throw new IllegalArgumentException("Not enough arguments");
    }
    
    @RequestMapping(value="/updateUserInfo", method = RequestMethod.POST)
    public String updateUserInformation(){
    	//this view does not exists, so it will create 404 error
    	return "pagedoesnotexists";
    }
    
	@RequestMapping(value = "/securityexception", method = RequestMethod.POST)
	public String generateSecurityException() throws IOException {
		
		// Generate security exception
		if (true) {
			throw new SecurityException("Security Exception Occured");
		}
		return "home";
	}
	
	@RequestMapping(value = "/accessDeniedException", method = RequestMethod.POST)
	public void generateAccessDeniedException() {
		
		// Generate security exception
		if (true) {
			throw new AccessDeniedException("access denied.");
		}
	}
	
	@RequestMapping(value = "/nullPointerException", method = RequestMethod.POST)
	public void generateNullPointerException() {
		String user = null;
		//cause null pointer exception
		user.length();
	}
	
	/**
	 * This method will be executed when Security Exception occurs in any method in this controller.
	 * In this example it will be executed when exception occurs in throwSecurityException
	 * 
	 * @param ex 
	 * 			ex is a type of SecurityException
	 * 
	 * @return
	 * 		    will return ModelAndView - security page	
	 */
	@ExceptionHandler(SecurityException.class)
	public ModelAndView handleSecurityException(SecurityException ex) {

		//do something here to handle security exception
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("security");
		modelAndView.addObject("name", ex.getClass().getSimpleName());
		modelAndView.addObject("user", "John Doe");

		return modelAndView;
	}

}
