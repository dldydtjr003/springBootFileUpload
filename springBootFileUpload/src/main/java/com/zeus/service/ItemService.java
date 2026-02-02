package com.zeus.service;

import java.util.List;

import com.zeus.domain.Item;

public interface ItemService {

	public int create(Item item) throws Exception; 
	public Item read(Integer itemId) throws Exception; 
	public int update(Item item) throws Exception; 
	public int delete(Integer itemId) throws Exception; 
	public List<Item> list() throws Exception; 
	public String getPicture(Integer itemId) throws Exception; 
}
