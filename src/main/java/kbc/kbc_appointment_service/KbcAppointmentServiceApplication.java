package kbc.kbc_appointment_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ComponentScan(basePackages = {"kbc.kbc_appointment_service", "kbc.common"})
@EnableJpaAuditing(auditorAwareRef = "commonAuditorAware")
public class KbcAppointmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KbcAppointmentServiceApplication.class, args);
	}

}
