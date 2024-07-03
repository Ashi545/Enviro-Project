package com.enviro.assessment.grad001.aswadnyikadzino;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EnviroProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnviroProjectApplication.class, args);
	}

}
