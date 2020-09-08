package com.springbootapplication.h2demo;

import org.springframework.data.repository.CrudRepository;

public interface ItemRepo extends CrudRepository<Item, String> {
}
