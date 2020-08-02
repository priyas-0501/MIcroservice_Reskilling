package com.ibm.poc.controller;

import java.util.List;

import com.ibm.poc.dto.ProductResponseDTO;
import com.ibm.poc.dto.UserResponseDTO;
import com.ibm.poc.services.ProductService;
import com.ibm.poc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class StoreUserResource {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping("/{userid}")
	public ResponseEntity<UserResponseDTO> getUserDetails( @PathVariable("userid") int userId) {
	return	userService.findUser(userId)
		.map(data -> {
			return ResponseEntity.ok().body(data);
		}).orElseGet(() -> {
			return ResponseEntity.badRequest().body(null);
		});
	}
	
	
	@GetMapping("/product")
	public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
		return ResponseEntity.ok().body(productService.getAllProducts());
	}
	
	@GetMapping("/product/{productid}")
	public ResponseEntity<ProductResponseDTO> getProductDetails( @PathVariable("productid") int productId) {
	return	productService.findProduct(productId)
		.map(data -> {
			return ResponseEntity.ok().body(data);
		}).orElseGet(() -> {
			return ResponseEntity.badRequest().body(null);
		});
	}
	
	
	@GetMapping("/store/{storeid}")
	public ResponseEntity<List<ProductResponseDTO>> getProductForStore( @PathVariable("storeid") int storeId) {
	return	productService.getAllProductsForStore(storeId)
		.map(data -> {
			return ResponseEntity.ok().body(data);
		}).orElseGet(() -> {
			return ResponseEntity.badRequest().body(null);
		});
	}

}
