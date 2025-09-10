package com.ems1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ems1.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
