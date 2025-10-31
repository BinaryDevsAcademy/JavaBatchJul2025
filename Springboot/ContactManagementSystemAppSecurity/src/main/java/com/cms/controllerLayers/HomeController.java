package com.cms.controllerLayers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cms.dtos.SecurityUsersDTO;
import com.cms.entities.SecurityUsers;
import com.cms.filters.JwtFilter;
import com.cms.serviceLayers.SecurityUserService;
import com.cms.utils.JwtUtility;

@RestController
public class HomeController {

    private final JwtFilter jwtFilter;
	
	@Autowired
	private SecurityUserService userService;
	
	@Autowired
	private JwtUtility jwt;
	
	@Autowired
	private AuthenticationManager authManager;

    HomeController(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }
	
	@GetMapping("/")
	public String home() {
		return "Home Page";
	}
	
	@GetMapping("/contact")
	public String contactUs() {
		return "Contact page";
	}
	
	@PostMapping("/signup")
	public SecurityUsers signup(@RequestBody SecurityUsers user) {
		return userService.registerUser(user);
	}
	
	@GetMapping("/all")
	public List<SecurityUsers> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping("/login")
	public Map<String, Object> login(@RequestBody SecurityUsersDTO userDto) {
		System.out.println(userDto);
		Authentication authenticate = 
				authManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(), userDto.getUserPassword()));
		if(authenticate.isAuthenticated()) {
			System.out.println("User authenticated");
		}
		
		Map<String, Object> response = new HashMap<>();
		
		response.put("token", jwt.generateToken(userDto.getUsername()));
		response.put("role", userService.getUserRole(userDto.getUsername()));
		return response;
	}
	
}
