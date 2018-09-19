package com.in28minutes.unittesting.unittesting.unittesting.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.unittesting.unittesting.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	
}
