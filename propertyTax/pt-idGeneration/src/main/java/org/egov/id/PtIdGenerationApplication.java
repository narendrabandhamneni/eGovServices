package org.egov.id;

import org.egov.models.ResponseInfoFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PtIdGenerationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PtIdGenerationApplication.class, args);
	}
	
	@Bean
	public ResponseInfoFactory getResponseInfo(){
		return new ResponseInfoFactory();
	}
}
