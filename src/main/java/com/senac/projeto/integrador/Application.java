package com.senac.projeto.integrador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@ComponentScan
@Configuration
@EnableSwagger2
@EnableAutoConfiguration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
