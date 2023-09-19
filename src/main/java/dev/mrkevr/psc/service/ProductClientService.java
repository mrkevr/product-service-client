package dev.mrkevr.psc.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClient.ResponseSpec;

import dev.mrkevr.psc.model.Product;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductClientService {
	
	RestClient restClient;
	
	public List<Product> getAll() {
		ResponseSpec response = restClient.get()
				.uri("/products")
				.retrieve();
		return response.body(new ParameterizedTypeReference<List<Product>>() {
		});
	}

	public Product getById(Long id) {
		ResponseSpec response = restClient.get()
				.uri("/products/{id}", id)
				.retrieve();
		return response.body(Product.class);
	}

	public Product add(Product product) {
		ResponseSpec response = restClient.post()
				.uri("/products")
				.contentType(MediaType.APPLICATION_JSON)
				.body(product)
				.retrieve();
		return response.body(Product.class);
	}

	public boolean deleteById(Long id) {
		restClient.delete()
			.uri("/products/{id}", id)
			.retrieve()
			.toBodilessEntity();
		return true;
	}

	public Product update(Long id, Product product) {
		ResponseSpec response = restClient.put()
				.uri("/products/{id}", id)
				.contentType(MediaType.APPLICATION_JSON)
				.body(product)
				.retrieve();
		return response.body(Product.class);
	}
}
