package com.api.book.bootrestbook.dao;

import org.springframework.data.repository.CrudRepository;

import com.api.book.bootrestbook.entities.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

}
