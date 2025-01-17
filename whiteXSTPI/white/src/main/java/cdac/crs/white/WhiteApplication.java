package cdac.crs.white;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@PropertySource("classpath:api-gateway-routing.properties")
public class WhiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhiteApplication.class, args);
	}

}
