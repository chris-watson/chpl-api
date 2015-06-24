package gov.healthit.chpl.auth;

import gov.healthit.chpl.auth.user.User;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class Util {
	
	
	public static String getUsername() {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth.getPrincipal() instanceof UserDetails) {
			return ((UserDetails) auth.getPrincipal()).getUsername();
		}
		else {
			return auth.getPrincipal().toString();
		}
	}

	public static User getCurrentUser(){
		
		User user = null;
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth instanceof User){
			user = (User) auth;
		}
		return user;	
	}
	
}