package com.springboot.firstRESTapi.survey;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.http.HttpHeaders;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ServeyResourceIT {

	private static String SPECIFIC_QUESTION_URL = "/surveys/Survey1/questions/Question1";
	private static String ALL_QUESTION_URL = "/surveys/Survey1/questions";

	@Autowired
	private TestRestTemplate template;

	String str = """
			{
				"id": "Question1",
				"desc": "Most Popular Cloud Platform Today",
				"options": [
				"AWS",
				"Azure",
				"Google Cloud",
				"Oracle Cloud"
				],
				"correctAnswer": "AWS"
			}
			""";

	@Test
	void retrieveSpecificSurveyQuestion_basicScenario() throws JSONException {
		ResponseEntity<String> responseEntity = template.getForEntity(SPECIFIC_QUESTION_URL, String.class);

		// [Content-Type:"application/json"]
		String expectedResponce = """
				{"id":"Question1",
				"desc":"Most Popular Cloud Platform Today",
				"correctAnswer":"AWS"}
				""";
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));

		JSONAssert.assertEquals(expectedResponce, responseEntity.getBody(), false);
	}

	@Test
	void retrieveAllSurveyQuestions_basicScenario() throws JSONException {
		ResponseEntity<String> responseEntity = template.getForEntity(ALL_QUESTION_URL, String.class);

		// [Content-Type:"application/json"]
		String expectedResponce = """
								[
				{
				"id": "Question1",
				"desc": "Most Popular Cloud Platform Today",
				"options": [
				"AWS",
				"Azure",
				"Google Cloud",
				"Oracle Cloud"
				],
				"correctAnswer": "AWS"
				},
				{
				"id": "Question2",
				"desc": "Fastest Growing Cloud Platform",
				"options": [
				"AWS",
				"Azure",
				"Google Cloud",
				"Oracle Cloud"
				],
				"correctAnswer": "Google Cloud"
				},
				{
				"id": "Question3",
				"desc": "Most Popular DevOps Tool",
				"options": [
				"Kubernetes",
				"Docker",
				"Terraform",
				"Azure DevOps"
				],
				"correctAnswer": "Kubernetes"
				}
				]
								""";
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertEquals("application/json", responseEntity.getHeaders().get("Content-Type").get(0));

		JSONAssert.assertEquals(expectedResponce, responseEntity.getBody(), false);
	}

	@Test
	void addNewSurveyQuestion_basicScenario() {
		String requestBody = """
				{
					"desc": "fevorite language",
					"options":["Java", "python", "c++", "css"],
					"correctAnswer": "Java"
				}
				""";
		org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
		headers.add("Content-Type", "application/json");

		HttpEntity<String> httpEntity = new HttpEntity<String>(requestBody, headers);

		ResponseEntity<String> responseEntity = template.exchange(ALL_QUESTION_URL, HttpMethod.POST, httpEntity,
				String.class);
//		System.out.println(responseEntity.getHeaders());

		// Location:"http://localhost:51612/surveys/Survey1/questions/2148819486"
		assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
		assertTrue(responseEntity.getHeaders().get("Location").get(0).contains("/surveys/Survey1/questions/"));
	}
}
