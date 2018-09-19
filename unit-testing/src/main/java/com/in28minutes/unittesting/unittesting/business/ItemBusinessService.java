package com.in28minutes.unittesting.unittesting.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.in28minutes.unittesting.unittesting.model.Item;
import com.in28minutes.unittesting.unittesting.unittesting.data.ItemRepository;

@Component
public class ItemBusinessService {

	@Autowired
	ItemRepository itemRepository;

	public Item retrieveHardCoreItem() {
		return new Item(1, "Ball", 10, 100);
	}

	public List<Item> retrieveAllItems() {
		List<Item> items = itemRepository.findAll();
		for (Item item : items) {
			item.setValue(item.getPrice() * item.getQuantity());
		}
		return items;
	}

}
