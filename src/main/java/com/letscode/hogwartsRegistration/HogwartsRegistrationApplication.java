package com.letscode.hogwartsRegistration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@OpenAPIDefinition(
    info = @Info(
        title = "Hogwarts Student Registration",
        version = "1.0",
        description = "API for registering wizard students at Hogwarts School of Witchcraft and Wizardry"))
public class HogwartsRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(HogwartsRegistrationApplication.class, args);
	}

}
