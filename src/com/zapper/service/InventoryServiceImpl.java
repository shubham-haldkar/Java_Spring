package com.zapper.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zapper.bussiness.bean.InventoryBean;
import com.zapper.dao.InventoryDaoWrapper;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryDaoWrapper inventoryDaoWrapper;
	
	@Override   
	public Collection<InventoryBean> getAllInventory() {
		// TODO Auto-generated method stub
		return inventoryDaoWrapper.findAll();
	}

	@Override
	public InventoryBean getInventoryDetailsById(int id) {
		// TODO Auto-generated method stub
		return inventoryDaoWrapper.findOne(id);
	}

	@Override
	public Integer addInventory(InventoryBean inventory) {
		// TODO Auto-generated method stub
		return inventoryDaoWrapper.saveInventory(inventory);
	}

	@Override
	public InventoryBean updateInventory(InventoryBean inventory) {
		// TODO Auto-generated method stub
		return inventoryDaoWrapper.updateInventory(inventory);
	}

	@Override
	public void removeInventory(int id) {
		// TODO Auto-generated method stub
		inventoryDaoWrapper.delete(id) ;
		
	}

}
