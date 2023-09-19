package dev.mrkevr.psc.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.mrkevr.psc.model.Product;
import dev.mrkevr.psc.service.ProductClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/restclient/products")
@RequiredArgsConstructor
public class ProductClientController {
	
	private final ProductClientService productClientService;
	
	@GetMapping
	ResponseEntity<?> all() {
		List<Product> products = productClientService.getAll();
		return ResponseEntity.ok(products);
	}

	@GetMapping("/{id}")
	ResponseEntity<?> one(@PathVariable Long id) {
		Product product = productClientService.getById(id);
		return ResponseEntity.ok(product);
	}

	@PostMapping
	ResponseEntity<?> add(@RequestBody @Valid Product product) {
		Product newProduct = productClientService.add(product);
		return ResponseEntity.ok(newProduct);
	}

	@DeleteMapping("/{id}")
	ResponseEntity<?> delete(@PathVariable Long id) {
		productClientService.deleteById(id);
		return ResponseEntity.ok("Deleted successfully.");
	}

	@PutMapping("/{id}")
	ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid Product product) {
		Product updatedProduct = productClientService.update(id, product);
		return ResponseEntity.ok(updatedProduct);
	}
}
