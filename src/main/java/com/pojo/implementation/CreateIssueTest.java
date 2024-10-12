package com.pojo.implementation;

import com.google.gson.Gson;

public class CreateIssueTest {
	
	public static void main(String[] args) {
		
		Fields fields = new Fields();
		fields.setDescription("Creating of an issue using project keys and issue type names using the REST API");
		fields.setSummary("REST ye merry gentlemen.");
		Project project = new Project();
		project.setId("10000");
		project.setName("TES");
		fields.setProject(project);
		IssueType issueType = new IssueType();
		issueType.setId("10001");
		issueType.setName("Bug");
		fields.setIssuetype(issueType);
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(fields));
	}

}