package com.springboot.firstRESTapi.survey;

import static org.junit.jupiter.api.Assertions.*;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class JsonAssertTest {

	@Test
	void JsonAssert_learningBasics() throws JSONException {
		String expectedResponce = """
				{"id":"Question1","desc":"Most Popular Cloud Platform Today","options":["AWS","Azure","Google Cloud","Oracle Cloud"],"correctAnswer":"AWS"}
				""";
		String actualResponce = """
				{"id":"Question1",
				"desc":"Most Popular Cloud Platform Today",
				"options":["AWS","Azure","Google Cloud","Oracle Cloud"],
				"correctAnswer":"AWS"}
				""";
		
		JSONAssert.assertEquals(expectedResponce, actualResponce, true);
	}
}
