package com.tcs.client;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.tcs.springbootdemo.entity.User;

@SpringBootApplication()
public class JavaClient {
	private static String URL = "http://localhost:8081/user/";
	
	@Bean // should be used when you dont have the source code 
	RestTemplate resTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new SpringApplicationBuilder(JavaClient.class)
				  .web(WebApplicationType.NONE)
				  .run(args);
		//getUserById(context);
		//Iterable<User> response = (Iterable<User>)resTemplate.getForObject(URL, User.class);
		getAllUser(context);
		
	}

	private static void getAllUser(ApplicationContext context) {
		RestTemplate restTemplate = context.getBean(RestTemplate.class);
		ResponseEntity<User[]> responseEntity =
				   restTemplate.getForEntity(URL,User[].class);
		User[] user = responseEntity.getBody();
		for(int i =0;i<user.length;i++) {
			System.out.println(user[i]);
		}
	}

	private static void getUserById(ApplicationContext context) {
		RestTemplate resTemplate = context.getBean(RestTemplate.class);
		User response = resTemplate.getForObject(URL+"1", User.class);
		
		System.out.println(response);
	}
}
