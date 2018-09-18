package com.in28minutes.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

	String str = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";

	@Test
	public void jasonAssert_StrinckTrue_ExactMatchExceptForSpaces() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
		JSONAssert.assertEquals(expectedResponse, str, true);
	}

	@Test
	public void jasonAssert_StrinckFalse() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10}";
		JSONAssert.assertEquals(expectedResponse, str, false);
	}
	
	@Test
	public void jasonAssert_WithoutEscapeCharacters() throws JSONException {
		String expectedResponse = "{id: 1, name: Ball, price:10}";
		JSONAssert.assertEquals(expectedResponse, str, false);
	}
}
