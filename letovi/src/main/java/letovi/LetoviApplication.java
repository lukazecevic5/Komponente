package letovi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LetoviApplication {

	public static void main(String[] args) {
		SpringApplication.run(LetoviApplication.class, args);
	}

}
