package com.fabiang.vendor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.fabiang.vendor.entities.Vendor;
import com.fabiang.vendor.repos.VendorRepository;

@RestController
public class VendorRestController {
	
	@Autowired
	VendorRepository repository;
	
	@GetMapping("/vendors/{id}")
	public Vendor findVendor(@PathVariable int id) {
		return repository.findOne(id);
	}
	
	@GetMapping("/vendors")
	public List<Vendor> allVendors(){
		return repository.findAll();
	}
	
	@PostMapping("/vendors")
	public Vendor saveVendor(@RequestBody Vendor vendor) {
		return repository.save(vendor);
	}
	
	@PutMapping("/vendors")
	public Vendor updateVendor(@RequestBody Vendor vendor) {
		return repository.save(vendor);
	}
	
	@DeleteMapping("/vendors/{id}")
	public void deleteVendor(@PathVariable int id) {
		repository.delete(id);
	}

}
