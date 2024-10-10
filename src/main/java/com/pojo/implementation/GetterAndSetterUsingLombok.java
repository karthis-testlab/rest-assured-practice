package com.pojo.implementation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class GetterAndSetterUsingLombok {
	
	String description;
	String short_description;
	String state;
	String urgency;
	String category;

}