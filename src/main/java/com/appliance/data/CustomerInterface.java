package com.appliance.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerInterface extends JpaRepository<Customer, Integer> {

}
