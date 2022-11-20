package com.zapper.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zapper.bussiness.bean.InventoryBean;
import com.zapper.entity.InventoryEntity;

@Repository
public class InventoryDaoWrapper {
	@Autowired
	private InventoryDao dao;

	public List<InventoryBean>findAll(){
		List<InventoryBean> list = new ArrayList<InventoryBean>(); 
		
		Iterable<InventoryEntity> listEn= dao.findAll();
		listEn.forEach(x->{
			InventoryBean inventory = new InventoryBean();
			BeanUtils.copyProperties(x, inventory);
			list.add(inventory);
		});
		return list;
	}


	public InventoryBean findOne(Integer id){ 
			InventoryEntity x= dao.findOne(id);
			InventoryBean inventory =null;
			if(x!=null){
				inventory = new InventoryBean();		
				BeanUtils.copyProperties(x, inventory);
			}
		return inventory;
	}

	public Integer saveInventory(InventoryBean inventory){
		InventoryEntity inventoryEntityBean = new InventoryEntity();
		BeanUtils.copyProperties(inventory, inventoryEntityBean);
		InventoryEntity en=  dao.save(inventoryEntityBean);
		return en.getId();	
	}

	public InventoryBean updateInventory(InventoryBean inventory){
		InventoryEntity inventoryEntityBean = new InventoryEntity();
		BeanUtils.copyProperties(inventory, inventoryEntityBean);
		InventoryEntity en=  dao.save(inventoryEntityBean);
		
		InventoryBean inventory2 = new InventoryBean();
		
		BeanUtils.copyProperties(en,inventory2);
		return inventory2;	
	}

	public void delete(int id){
		dao.delete(id);
	}


	
	
}
