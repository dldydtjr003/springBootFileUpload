package com.zeus.domain;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Item implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private Integer price;
	private String description;
	private String url;
	
	// 파일은 외장하드 D드라이브에 넣는다.
	private MultipartFile picture;
}
