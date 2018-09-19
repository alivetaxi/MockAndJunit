package com.in28minutes.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.in28minutes.unittesting.unittesting.unittesting.business.SomeBusinessImpl;
import com.in28minutes.unittesting.unittesting.unittesting.data.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {
	@InjectMocks
	SomeBusinessImpl business;
	@Mock
	SomeDataService dataServicemock;

	@Before
	public void before() {
		business.setSomeDataService(dataServicemock);
	}

	@Test
	public void calculateSumUsingDataService_basic() {
		when(dataServicemock.retrieveAllData()).thenReturn(new int[] { 1, 2, 3 });
		assertEquals(6, business.calculateSumUsingService());
	}

	@Test
	public void calculateSum_empty() {
		when(dataServicemock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(0, business.calculateSumUsingService());
	}

	@Test
	public void calculateSum_oneValue() {
		when(dataServicemock.retrieveAllData()).thenReturn(new int[] { 5 });
		assertEquals(5, business.calculateSumUsingService());
	}
}
