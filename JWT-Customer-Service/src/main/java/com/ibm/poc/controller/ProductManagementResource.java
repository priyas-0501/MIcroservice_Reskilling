package com.ibm.poc.controller;

import java.util.List;

import com.ibm.poc.dto.ProductDTO;
import com.ibm.poc.dto.ProductResponseDTO;
import com.ibm.poc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/productmgmnt")
public class ProductManagementResource {
	
	@Autowired
	private ProductService productService;
	
	/* Get All products  */
	@GetMapping
	public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
		return ResponseEntity.ok().body(productService.getAllProducts());
	}
	/* Get product by Id  */
	@GetMapping("/{productid}")
	public ResponseEntity<ProductResponseDTO> getProductDetails( @PathVariable("productid") int productId) {
	return	productService.findProduct(productId)
		.map(data -> {
			return ResponseEntity.ok().body(data);
		}).orElseGet(() -> {
			return ResponseEntity.badRequest().body(null);
		});
	}
	/* Update product by Id  */
	@PutMapping("/{productid}")
	public ResponseEntity<ProductResponseDTO> updateProduct(@RequestBody ProductDTO requestData, @PathVariable("productid") int productId){
		return productService.udpateProduct(requestData, productId)
		.map(data -> {
			return ResponseEntity.ok().body(data);
		}).orElseGet(() -> {
			return ResponseEntity.badRequest().body(null);
		});
	} 
	/* Create product   */
	@PostMapping
	public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductDTO requestData) {
		return productService.createProduct(requestData).map(data -> {
			return ResponseEntity.ok().body(data);
		}).orElseGet(() -> {
			return ResponseEntity.badRequest().body(null);
		});
	} 
	
	/* Get Products from store Id */
	@GetMapping("/store/{storeid}")
	public ResponseEntity<List<ProductResponseDTO>> getProductForStore( @PathVariable("storeid") int storeId) {
	return	productService.getAllProductsForStore(storeId)
		.map(data -> {
			return ResponseEntity.ok().body(data);
		}).orElseGet(() -> {
			return ResponseEntity.badRequest().body(null);
		});
	}	
	
	
	/*
	 * @DeleteMapping("/{storeid}") public ResponseEntity<Integer>
	 * deleteProduct(@PathVariable("productid") int productId){ return
	 * productService.deleteProduct(productId).map(data -> { return
	 * ResponseEntity.ok().body(data); }).orElseGet(() -> { return
	 * ResponseEntity.badRequest().body(null); }); }
	 */

}
