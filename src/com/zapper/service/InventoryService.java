package com.zapper.service;

import java.util.Collection;

import com.zapper.bussiness.bean.InventoryBean;

public interface InventoryService {

	Collection<InventoryBean> getAllInventory();

	InventoryBean getInventoryDetailsById(int id);

	Integer addInventory(InventoryBean inventory);

	InventoryBean updateInventory(InventoryBean inventory);

	void removeInventory(int id);
}
