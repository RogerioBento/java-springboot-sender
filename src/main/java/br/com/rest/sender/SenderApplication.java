package br.com.rest.sender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"br.com.rest.sender"})
@EntityScan("br.com.rest.sender")
@SpringBootApplication(scanBasePackages = {"br.com.rest.sender.service", "br.com.rest.sender.core", "br.com.rest.sender.api"})
public class SenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SenderApplication.class, args);
		
	}

}
