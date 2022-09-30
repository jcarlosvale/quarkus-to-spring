package com.learning.marcianosQuarkusToSpring;

import com.learning.marcianosQuarkusToSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MarcianosQuarkusToSpringApplication implements ApplicationRunner {

	@Autowired //Singleton --> Padrao de Projeto
	UserService userService;

	@Autowired
	RestTemplate myRestTemplate;

	public static void main(String[] args) {
		SpringApplication.run(MarcianosQuarkusToSpringApplication.class, args);
	}


	@Override
	public void run(ApplicationArguments arg0) throws Exception {
//		userService.print();

		System.out.println(myRestTemplate);
	}

}
