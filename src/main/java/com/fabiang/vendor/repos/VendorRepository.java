package com.fabiang.vendor.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fabiang.vendor.entities.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {

}
