package com.ibm.poc.controller;

import java.util.List;

import com.ibm.poc.dto.StoreDTO;
import com.ibm.poc.dto.StoreResponseDTO;
import com.ibm.poc.dto.UserDTO;
import com.ibm.poc.dto.UserResponseDTO;
import com.ibm.poc.services.StoreService;
import com.ibm.poc.services.UserService;
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
@RequestMapping(path = "/storesmgmnt")
public class StoreManagementResource {
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private UserService userService;
	
	/* Get all stores */
	@GetMapping("/stores")
	public ResponseEntity<List<StoreResponseDTO>> getAllStores() {
		return ResponseEntity.ok().body(storeService.getAllStores());
	}
	
	/* Get stores by id */
	@GetMapping("/stores/{storeid}")
	public ResponseEntity<StoreResponseDTO> getStoreDetails( @PathVariable("storeid") int storeId) {
	return	storeService.findStore(storeId)
		.map(data -> {
			return ResponseEntity.ok().body(data);
		}).orElseGet(() -> {
			return ResponseEntity.badRequest().body(null);
		});
	}
	
	/* Update stores by id */
	@PutMapping("/stores/{storeid}")
	public ResponseEntity<StoreResponseDTO> updateStore(@RequestBody StoreDTO requestData, @PathVariable("storeid") int storeId){
		return storeService.udpateStore(requestData, storeId)
		.map(data -> {
			return ResponseEntity.ok().body(data);
		}).orElseGet(() -> {
			return ResponseEntity.badRequest().body(null);
		});
	} 
	/* Create Store */
	@PostMapping("/stores")
	public ResponseEntity<StoreResponseDTO> createStore(@RequestBody StoreDTO requestData) {
		return storeService.createStore(requestData).map(data -> {
			return ResponseEntity.ok().body(data);
		}).orElseGet(() -> {
			return ResponseEntity.badRequest().body(null);
		});
	} 
	
	/*
	 * @DeleteMapping("/stores/{storeid}") public ResponseEntity<Integer>
	 * deleteStore(@PathVariable("storeid") int storeId){ return
	 * storeService.deleteStore(storeId).map(data -> { return
	 * ResponseEntity.ok().body(data); }).orElseGet(() -> { return
	 * ResponseEntity.badRequest().body(null); }); }
	 */

	/* User related operation */
	
	@GetMapping("/user")
	public ResponseEntity<List<UserResponseDTO>> getAllUser() {
		return ResponseEntity.ok().body(userService.getAllUsers());
	}
	
	@GetMapping("/user/{userid}")
	public ResponseEntity<UserResponseDTO> getUserDetails( @PathVariable("userid") int userId) {
	return	userService.findUser(userId)
		.map(data -> {
			return ResponseEntity.ok().body(data);
		}).orElseGet(() -> {
			return ResponseEntity.badRequest().body(null);
		});
	}
	
	@PutMapping("/user/{userid}")
	public ResponseEntity<UserResponseDTO> updateUser(@RequestBody UserDTO requestData, @PathVariable("userid") int userId){
		return userService.udpateUser(requestData, userId)
		.map(data -> {
			return ResponseEntity.ok().body(data);
		}).orElseGet(() -> {
			return ResponseEntity.badRequest().body(null);
		});
	} 
	
	@PostMapping("/user")
	public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserDTO requestData) {
		return userService.createUser(requestData).map(data -> {
			return ResponseEntity.ok().body(data);
		}).orElseGet(() -> {
			return ResponseEntity.badRequest().body(null);
		});
	} 
	
	@DeleteMapping("/user/{userid}")
	public ResponseEntity<Integer> deleteUser(@PathVariable("userid") int userId){
	return 	userService.deleteUser(userId).map(data -> {
			return ResponseEntity.ok().body(data);
		}).orElseGet(() -> {
			return ResponseEntity.badRequest().body(null);
		});
	} 
}
