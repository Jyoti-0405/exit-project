package com.nagarro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RestController
public class ProductCommunityApplication {

	@GetMapping("/")
	public String welcome(){
		return "Spring Boot Docker Demo";
	}


	public static void main(String[] args) {
		SpringApplication.run(ProductCommunityApplication.class, args);
	}

}
