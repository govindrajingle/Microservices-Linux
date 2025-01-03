package cdac.crs.red.stpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import cdac.crs.red.jwt.JwtTokenService;
import cdac.crs.red.stpi.entity.UserRegisterEntity;
import cdac.crs.red.stpi.model.UserRegisterModel;
import cdac.crs.red.stpi.repository.RegistrationFormProfileRepository;

@RestController
public class LoginFormProfileController {

	@Autowired
	RegistrationFormProfileRepository registrationFormProfileRepository;

	@Autowired
	JwtTokenService jwtTokenService;

	@PostMapping("/authenticate_user")
	boolean authenticateUser(@RequestBody UserRegisterModel model, @RequestHeader("Authorization") String token) {
		System.out.println(model.toString());
		if (!jwtTokenService.validateToken(token, model.getUsername())) {
			return false;
		}
		UserRegisterEntity user = registrationFormProfileRepository.findByUserName(model.getUsername());
		if (user != null && user.getPassword().equals(model.getPassword())) {
			return true;
		}
		return false;
	}
}
