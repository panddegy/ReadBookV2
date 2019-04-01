package com.biz.book.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookFormVO {

	private String f_auth;
	private String f_pass;
	private String f_subject;
	private String f_text;
	private String f_file;
	
}
