package com.selflearnining.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {

//	private Logger logger = LoggerFactory.getLogger(getClass());
//
//	private AuthenticationService authenticationService;
//
//	public LoginController(AuthenticationService authenticationService) {
//		this.authenticationService = authenticationService;
//	}

	// http://localhost:8080/login?name=Kevin
	// Model to pass to jsp
	// @RequestMapping("login")
//	public String gotoLoginPage(@RequestParam String name, ModelMap model) {
//		model.put("name", name);
//		logger.debug("Request param is {}", name);
//		System.out.println("Request param is "+ name);
//		return "login";
//	}

	// Get -> Redirect to the login Page
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", getLoggedinUsername());

		return "welcome";
	}
	
	private String getLoggedinUsername() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		return authentication.getName();
	}

//	// Post -> Redirect to the welcome Page
//	// Form data also use Request Param
//	@RequestMapping(value = "login", method = RequestMethod.POST)
//	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
//
//		if (authenticationService.authenticate(name, password)) {
//			model.put("name", name);
//			model.put("password", password);
//			return "welcome";
//		}
//
//		model.put("errorMessage", "Invalid Credentials, Please try again");
//
//		return "login";
//	}

}
