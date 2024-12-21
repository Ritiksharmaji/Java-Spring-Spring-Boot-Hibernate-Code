package com.blogapp.apis.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JWTRequest {
	private String email;
	private String password;

}
