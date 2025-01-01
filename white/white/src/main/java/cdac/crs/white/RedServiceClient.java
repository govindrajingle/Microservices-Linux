package cdac.crs.white;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "red-service-local", url = "http://10.10.11.89:8280/red")
public interface RedServiceClient {

    @GetMapping("/hello")
    String showText();
}

