package com.example.demo;

import com.example.demo.entity.AppUser;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class OauthApplication {


	@Autowired
	private UserRepository userRepository;


	@PostConstruct
	public void initUsers(){
		List<AppUser> users = Stream.of(
				new AppUser(101, "SG", "SG", "sg@gmail.com"),
				new AppUser(102, "SaG", "SaG", "sag@gmail.com"),
				new AppUser(103, "SanG", "SanG", "sang@gmail.com"),
				new AppUser(104, "SantG", "SantG", "santg@gmail.com")
		).collect(Collectors.toList());
		userRepository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(OauthApplication.class, args);
	}

}
