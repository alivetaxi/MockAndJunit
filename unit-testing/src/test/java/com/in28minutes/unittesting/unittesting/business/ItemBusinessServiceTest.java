package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.in28minutes.unittesting.unittesting.business.ItemBusinessService;
import com.in28minutes.unittesting.unittesting.model.Item;
import com.in28minutes.unittesting.unittesting.unittesting.data.ItemRepository;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {
	@InjectMocks
	private ItemBusinessService itemBusinessService;
	@Mock
	private ItemRepository itemRepository;

	@Test
	public void retrieveAllItems_basic() {
		when(itemRepository.findAll())
				.thenReturn(Arrays.asList(new Item(1, "Ball", 10, 100), new Item(2, "Ball2", 102, 1002)));
		List<Item> items = itemBusinessService.retrieveAllItems();

		assertEquals(1000, items.get(0).getValue());
		assertEquals(102 * 1002, items.get(1).getValue());
	}

}
