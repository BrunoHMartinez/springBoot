package com.educandoweb.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	//Exemplo de injeção de dependência
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Bruno","bruno@gmail.com" , "9999-9999", "123456789");
		User u2 = new User(null, "Hadassa","hadassa@gmail.com" , "9999-88888", "987654321");
		
		Order o1 = new Order(null, Instant.parse("2020-10-21T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2020-10-21T03:53:07Z"), u1);
		Order o3 = new Order(null, Instant.parse("2020-10-21T15:53:07Z"), u1);
 
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));

	}}
