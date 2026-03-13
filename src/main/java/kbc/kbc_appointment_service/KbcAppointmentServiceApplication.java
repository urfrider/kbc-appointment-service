package kbc.kbc_appointment_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"kbc.kbc_appointment_service", "kbc.common"})
public class KbcAppointmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KbcAppointmentServiceApplication.class, args);
	}

}
