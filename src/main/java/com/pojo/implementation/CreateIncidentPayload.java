package com.pojo.implementation;

public class CreateIncidentPayload {

	private String caller_id;
	private String short_description;
	private String description;

	public String getCaller_id() {
		return caller_id;
	}

	public void setCaller_id(String caller_id) {
		this.caller_id = caller_id;
	}

	public String getShort_description() {
		return short_description;
	}

	public void setShort_description(String short_description) {
		this.short_description = short_description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}