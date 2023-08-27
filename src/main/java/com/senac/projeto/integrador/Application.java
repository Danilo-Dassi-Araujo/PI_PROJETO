package com.senac.projeto.integrador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@ComponentScan
@Configuration
@EnableAutoConfiguration
@EnableSwagger2
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Application {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Application.class, args);

		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/loja",
				"postgres",
				"3014");
		if(!ObjectUtils.isEmpty(connection)){
			System.out.println("Conectado com sucesso!");
		} else{
			System.out.println("Falha na conexão");
		}
	}
}
