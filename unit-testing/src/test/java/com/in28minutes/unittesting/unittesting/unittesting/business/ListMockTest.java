package com.in28minutes.unittesting.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class ListMockTest {
	List<String> mock = mock(List.class);

	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}

	@Test
	public void returnDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}

	@Test
	public void returnWithParameters() {
		when(mock.get(0)).thenReturn("in28minutes");
		assertEquals("in28minutes", mock.get(0));
		assertEquals(null, mock.get(1));
	}

	@Test
	public void returnWithGenericParameters() {
		when(mock.get(anyInt())).thenReturn("in28minutes");
		assertEquals("in28minutes", mock.get(0));
		assertEquals("in28minutes", mock.get(1));
	}

	@Test
	public void verificationBasics() {
		String value1 = mock.get(0);
		String value2 = mock.get(1);

		// Verify
		verify(mock).get(0);
		verify(mock).get(anyInt());
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(2);
	}

	@Test
	public void argumentCapturing() {
		mock.add("SomeString");

		// Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());

		assertEquals("SomeString", captor.getValue());
	}

	@Test
	public void multipleArgumentCapturing() {
		mock.add("SomeString1");
		mock.add("SomeString2");

		// Verification
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock, times(2)).add(captor.capture());

		List<String> allValues = captor.getAllValues();
		assertEquals("SomeString1", allValues.get(0));
		assertEquals("SomeString2", allValues.get(1));
	}

	@Test
	public void mocking() {
		ArrayList arrayListMock = mock(ArrayList.class);
		System.out.println(arrayListMock.get(0));
		System.out.println(arrayListMock.size());
		arrayListMock.add("Test");
		arrayListMock.add("Test2");
		System.out.println(arrayListMock.size());
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size());
	}

	@Test
	public void spying() {
		ArrayList arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add("Test0");
		System.out.println(arrayListSpy.get(0));
		System.out.println(arrayListSpy.size());
		arrayListSpy.add("Test");
		arrayListSpy.add("Test2");
		System.out.println(arrayListSpy.size());
		when(arrayListSpy.size()).thenReturn(5);
		System.out.println(arrayListSpy.size());
		arrayListSpy.add("Test4");
		System.out.println(arrayListSpy.size());
		verify(arrayListSpy).add("Test4");
	}
}
