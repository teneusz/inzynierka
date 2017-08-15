package pl.teneusz.dzienniksnow.gatekeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
public class GatekeeperApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatekeeperApplication.class, args);
	}
}
