package com.hk.paperview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PaperViewApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaperViewApplication.class, args);
	}

}
