package com.example.invoicetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling // <-- 加上這行，開啟定時任務功能
@SpringBootApplication
public class InvoiceTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiceTrackerApplication.class, args);
	}

}
