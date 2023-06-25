package com.nbu.MedRecord;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.nbu" })
public class MedicalRecordApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalRecordApplication.class, args);
	}

}
