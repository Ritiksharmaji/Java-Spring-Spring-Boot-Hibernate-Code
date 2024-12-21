package com.blogapp.apis.payloads;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@Getter
@Setter

/*
 * this class will send the response for Posts request
 */
public class PostResponse {
	private List<PostDto> content;
	private int pageNumbers;
	private int pageSize;
	private long totalElements;
	private int totalPages;
	private boolean lastPages;
	

}
