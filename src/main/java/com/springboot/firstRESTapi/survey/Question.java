package com.springboot.firstRESTapi.survey;

import java.util.List;

public class Question {
	private String id;
	private String desc;
	private List<String> options;
	private String correctAnswer;

	public Question() {

	}

	public Question(String id, String desc, List<String> options, String correctAnswer) {
		super();
		this.id = id;
		this.desc = desc;
		this.options = options;
		this.correctAnswer = correctAnswer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<String> getOptions() {
		return options;
	}

	public void setOptions(List<String> options) {
		this.options = options;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", desc=" + desc + ", options=" + options + ", correctAnswer=" + correctAnswer
				+ "]";
	}

}
