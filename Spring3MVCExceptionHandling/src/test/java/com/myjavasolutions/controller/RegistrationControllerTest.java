package com.myjavasolutions.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

public class RegistrationControllerTest {

	private RegistrationController registrationController;
	private ModelMap model;
	
	@Before
	public void setup() {
		 registrationController = new RegistrationController();
		 model = new ModelMap();
	}
	
	@Test(expected=com.myjavasolutions.exception.GenericException.class)
	public void GenericException() throws Exception {
		registrationController.generateGenericException(model);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void generateIllegalArgumentException() throws Exception {
		registrationController.generateIllegalArgumentException();
	}
	
	@Test
	public void pageDoesNotExists() throws Exception {
		assertEquals("pagedoesnotexists", registrationController.updateUserInformation());
	}
	
	@Test(expected=SecurityException.class)
	public void generateSecurityException() throws Exception {
		registrationController.generateSecurityException();
		
	}
	
	@Test(expected=AccessDeniedException.class)
	public void generateAccessDeniedException() throws Exception {
		registrationController.generateAccessDeniedException();
	}
	
	@Test(expected=NullPointerException.class)
	public void generateNullPointerException() throws Exception {
		registrationController.generateNullPointerException();
	}
}