package com.zapper.dao;

import org.springframework.data.repository.CrudRepository;

import com.zapper.entity.ImageEntity;

public interface ImageDao  extends  CrudRepository<ImageEntity, Integer> {

}
