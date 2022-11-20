package com.zapper.dao;

import org.springframework.data.repository.CrudRepository;

import com.zapper.bussiness.bean.InventoryBean;
import com.zapper.entity.InventoryEntity;

public interface InventoryDao extends  CrudRepository<InventoryEntity, Integer>{

 
}
