package cdac.crs.white;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import cdac.crs.white.model.UserRegisterModel;

@FeignClient(name = "${microservice.profile.name}", url = "${microservice.profile.url}")
public interface ProfileServiceClient {

    @GetMapping("/hello")
    String showText();

    @PostMapping("/register_user")
	boolean registerUser(@RequestBody UserRegisterModel user);

    @PostMapping("/authenticate_user")
	boolean logUser(@RequestBody UserRegisterModel user, @RequestHeader("Authorization") String token);
}

