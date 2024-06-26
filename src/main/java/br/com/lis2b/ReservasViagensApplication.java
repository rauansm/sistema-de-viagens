package br.com.lis2b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class ReservasViagensApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservasViagensApplication.class, args);
	}

}
