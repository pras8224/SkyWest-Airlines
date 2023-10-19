package com.flight_reservation_app5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight_reservation_app5.entity.User;
import com.flight_reservation_app5.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/showLoginPage")
	public String showLoginPage() {
		return "login/login";
	}

	
	@RequestMapping("/showReg")
	public String showReg() {
		return "login/showReg";
	}
	
	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute("user") User user) {
		userRepo.save(user);
		return "login/login";
	}
	
	@RequestMapping("/verifyLogin")
	public String verifyLogin(@RequestParam("emailId") String emailId, 
			@RequestParam("password") String password, ModelMap modelMap) {
		User user = userRepo.findByEmail(emailId);
		
		System.out.println(user.getEmail()+"---"+user.getPassword());
		if (user!=null) {
			if(user.getEmail().equals(emailId) && user.getPassword().equals(password))
			{
				return "findFlights";
			}
			else {
				modelMap.addAttribute("error", "Invalid username / password");
				return "login/login";
			}
		}else {
			modelMap.addAttribute("error", "Invalid username / password");
			return "login/login";
		}
		
//		System.out.println(user.getEmail());
//		System.out.println(user.getPassword());
//		System.out.println(emailId);
//		System.out.println(password);
//		return "findFlights";
		
	}
}
