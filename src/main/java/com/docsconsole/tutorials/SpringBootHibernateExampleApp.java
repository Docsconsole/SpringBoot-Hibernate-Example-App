package com.docsconsole.tutorials;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SpringBootHibernateExampleApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateExampleApp.class, args);
	}

}


