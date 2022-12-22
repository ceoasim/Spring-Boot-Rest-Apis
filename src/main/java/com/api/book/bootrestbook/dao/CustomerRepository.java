package com.api.book.bootrestbook.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.book.bootrestbook.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
