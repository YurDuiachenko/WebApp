package com.example.springdatabasicdemo;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WeBApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeBApplication.class, args);
	}

}
