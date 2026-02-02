package com.zeus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zeus.domain.Item;
import com.zeus.mapper.ItemMapper;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper mapper;
	
	@Override
	@Transactional
	public int create(Item item) throws Exception {
		int count = mapper.create(item);
		return count;
	}

	@Override
	public Item read(Item i) throws Exception {
		Item item = mapper.read(i);
		return item;
	}

	@Override
	@Transactional
	public int update(Item item) throws Exception {
		int count = mapper.update(item);
		return count;
	}

	@Override
	@Transactional
	public int delete(Item item) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Item> list() throws Exception {
		List<Item> itemList = mapper.list();
		return itemList;
	}

	@Override
	public String getPicture(Item item) throws Exception {
		String url = mapper.getPicture(item);
		return url;
	}

}
