package com.emss.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emss.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
