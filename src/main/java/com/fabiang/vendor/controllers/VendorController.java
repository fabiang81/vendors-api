package com.fabiang.vendor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fabiang.vendor.entities.Vendor;
import com.fabiang.vendor.service.VendorService;

@Controller
public class VendorController {
	
	@Autowired
	VendorService service;
	
	@RequestMapping(	"/showCreate")
	public String showCreate(@ModelAttribute("vendor") Vendor vendor) {
		return "createVendor";
	}
	
	@RequestMapping(value="/saveVendor", method=RequestMethod.POST)
	public String saveLocation(@ModelAttribute("vendor") Vendor vendor, ModelMap modelMap) {
		Vendor vendorSaved = service.saveVendor(vendor);
		String msg = "Vendor saved with id: "+vendorSaved.getId();
		modelMap.addAttribute("msg", msg);
		return "createVendor";
	}
	
	@RequestMapping("/displayVendors")
	public String displayLocations(ModelMap modelMap) {
		List<Vendor> vendors = service.getAllVendors();
		modelMap.addAttribute("vendors", vendors);
		return "displayVendors";
	}
	
	@RequestMapping("/deleteVendor")
	public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
		Vendor vendor = service.getVendorById(id);
		service.deleteVendor(vendor);
		List<Vendor> vendors = service.getAllVendors();
		String msg = "Vendor deleted with id: "+vendor.getId();
		modelMap.addAttribute("vendors", vendors);
		modelMap.addAttribute("msg", msg);
		return "displayVendors";
	}
	
	@RequestMapping("/updateVendor")
	public String updateLocation(@RequestParam("id") int id, ModelMap modelMap) {
		Vendor vendor = service.getVendorById(id);
		modelMap.addAttribute("vendor", vendor);
		return "updateVendor";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@ModelAttribute("vendor") Vendor vendor, ModelMap modelMap) {
		service.updateVendor(vendor);
		List<Vendor> vendors = service.getAllVendors();
		modelMap.addAttribute("vendors", vendors);
		String msg = "Vendor updated with id: "+vendor.getId();
		modelMap.addAttribute("msg", msg);
		return "displayVendors";
	}

}
