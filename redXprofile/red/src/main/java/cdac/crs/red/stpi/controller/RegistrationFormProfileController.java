package cdac.crs.red.stpi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cdac.crs.red.stpi.entity.UserRegisterEntity;
import cdac.crs.red.stpi.model.UserRegisterModel;
import cdac.crs.red.stpi.repository.RegistrationFormProfileRepository;

@RestController
public class RegistrationFormProfileController {

	@Autowired
	RegistrationFormProfileRepository registrationFormProfileRepository;

	@PostMapping("/register_user")
	boolean saveUserData(@RequestBody UserRegisterModel model) {
		System.out.println(model.toString());
		UserRegisterEntity user = new UserRegisterEntity();
		user.setEmail(model.getEmail());
		user.setUsername(model.getUsername());
		user.setPassword(model.getPassword());
		user.setFlag(true);
		try {
			registrationFormProfileRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;

	}
}
