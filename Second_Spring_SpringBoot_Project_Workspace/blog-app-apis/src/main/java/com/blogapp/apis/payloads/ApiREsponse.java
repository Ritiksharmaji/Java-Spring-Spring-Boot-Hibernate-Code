package com.blogapp.apis.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/*
 * to send the SMS from controller to client
 */
public class ApiREsponse {
	
	private String message;
	private boolean success;

}
