package cdac.crs.white;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControllerTest {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private RedServiceClient redServiceClient;

	@Value("${service.url}")
	private String serviceUrl;

	@GetMapping("/helloFeign")
	public String text() {
		String externalResult = redServiceClient.showText();
		return "white combined with " + externalResult;
	}

	@GetMapping("/helloRed")
	public String showText() {
		// Call the external URL
		String externalResult = restTemplate.getForObject(serviceUrl, String.class);
		// String externalResult =
		// restTemplate.getForObject("http://red-service-local/hello", String.class);
		// Combine the external result with other data
		String combinedResult = "Hello, white-gateway. Combined with: " + externalResult;
		// Return the combined result
		return combinedResult;
	}

	@GetMapping("/hello")
	public String showTextTwo() {
		return "Hello, white-gateway";
	}

}
