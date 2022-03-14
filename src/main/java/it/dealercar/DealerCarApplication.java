package it.dealercar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class DealerCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(DealerCarApplication.class, args);
	}

}
