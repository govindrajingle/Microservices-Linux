package cdac.crs.white.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import cdac.crs.white.ProfileServiceClient;
import cdac.crs.white.jwt.JwtTokenService;
import cdac.crs.white.model.UserRegisterModel;

@RestController
public class LoginFormStpiController {
	
	@Autowired
	ProfileServiceClient profileServiceClient;
	
	@Autowired
	JwtTokenService jwtTokenService;

	@GetMapping("/login")
	public ModelAndView showLoginPage() {
		ModelAndView mv = new ModelAndView("login_page");
		mv.addObject("user", new UserRegisterModel());
		return mv;
	}

	@PostMapping("/login")
	public boolean checkLogin(@ModelAttribute UserRegisterModel user, Model model) {
		String jwtToken = jwtTokenService.generateToken(user.getUsername());
		System.out.println("User login attempt: " + user.getUsername());
		return profileServiceClient.logUser(user, jwtToken);
	}
}
