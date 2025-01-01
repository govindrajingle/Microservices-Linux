package cdac.crs.red;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTest {

	@GetMapping("/hello")
	public String showText() {
		return "Hello, red-service";
	}
}
