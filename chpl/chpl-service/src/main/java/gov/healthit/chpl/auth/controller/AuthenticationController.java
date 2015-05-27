package gov.healthit.chpl.auth.controller;

import java.util.List;

import gov.healthit.chpl.acb.CertificationBody;
import gov.healthit.chpl.acb.CertificationBodyManager;
import gov.healthit.chpl.auth.authentication.Authenticator;
import gov.healthit.chpl.auth.authentication.LoginCredentials;
import gov.healthit.chpl.auth.jwt.JWTCreationException;
import gov.healthit.chpl.auth.user.UserRetrievalException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
	
	@Autowired
	private Authenticator authenticator;
	
	
	@RequestMapping(value="/helloFromAuth/{firstName}/{lastName}", method= RequestMethod.GET, produces="application/json; charset=utf-8")
	public String helloFromAuth(@PathVariable String firstName, @PathVariable String lastName) {
		
		return "{\"firstName\" : \""+firstName+"\", \"lastName\" : \""+lastName+"\" }";
		
	}
	
	@RequestMapping(value="/authenticate_json", method= RequestMethod.POST, 
			consumes= MediaType.APPLICATION_JSON_VALUE,
			produces="application/json; charset=utf-8")
	public String authenticateJSON(@RequestBody LoginCredentials credentials) {
		
		String jwt = null;
		try {
			jwt = authenticator.getJWT(credentials);
		} catch (JWTCreationException e) {
			e.printStackTrace();
		}
		return jwt;
	}
	
	@RequestMapping(value="/authenticate", method= RequestMethod.POST, 
			headers = {"content-type=application/x-www-form-urlencoded"},
			produces="application/json; charset=utf-8")
	public String authenticate(@RequestParam("userName") String userName, @RequestParam("password") String password) {
		
		LoginCredentials credentials = new LoginCredentials(userName, password);
		
		String jwt = null;
		try {
			jwt = authenticator.getJWT(credentials);
		} catch (JWTCreationException e) {
			e.printStackTrace();
		}
		return jwt;
	}
	
}