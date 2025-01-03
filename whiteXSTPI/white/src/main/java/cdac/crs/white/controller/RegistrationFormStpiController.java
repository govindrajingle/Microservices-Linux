package cdac.crs.white.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cdac.crs.white.ProfileServiceClient;
import cdac.crs.white.model.UserRegisterModel;

@RestController
public class RegistrationFormStpiController {

	@Autowired
	ProfileServiceClient profileServiceClient;

	@GetMapping("/register")
	public ModelAndView showRegistrationForm() {
		ModelAndView mv = new ModelAndView("register_page");
		mv.addObject("user", new UserRegisterModel());
		return mv;
	}

	@PostMapping("/registerUser")
	public boolean registerUser(@ModelAttribute UserRegisterModel user, Model model) {
		System.out
				.println("User registered: " + user.getUsername() + ", " + user.getEmail() + ", " + user.getPassword());
		return profileServiceClient.registerUser(user);
	}

}
