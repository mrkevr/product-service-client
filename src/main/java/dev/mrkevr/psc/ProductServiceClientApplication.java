package dev.mrkevr.psc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.mrkevr.psc.service.ProductClientService;

@SpringBootApplication
public class ProductServiceClientApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceClientApplication.class, args);
	}
	
//	@Bean
	CommandLineRunner runner(ProductClientService productClientService) {
		return args -> {
//			List<Product> list = productServiceClient.getAll();
//			list.forEach(p -> System.out.println(p));
			
//			productServiceClient.add(new Product(null, "Kape Pinoy", BigDecimal.valueOf(55.55), 300, null, null));
			
		};
	}
}
