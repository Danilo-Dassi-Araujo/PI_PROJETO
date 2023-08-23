package com.senac.projeto.integrador.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.util.ObjectUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Application {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Application.class, args);

		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
				"postgres",
				"3014");
		if(!ObjectUtils.isEmpty(connection)){
			System.out.println("Conectado com sucesso!");
		} else{
			System.out.println("Falha na conexão");
		}
	}
}
