package com.zapper.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zapper.bussiness.bean.InventoryBean;
import com.zapper.service.InventoryServiceImpl;

@RestController
public class InventoryController {

	@Autowired
	private InventoryServiceImpl inventoryServiceImpl;
	
	@RequestMapping(value = "inventory/getDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<InventoryBean>> getInventoryDetails() {
		List<InventoryBean> listInventory = new ArrayList<InventoryBean>(inventoryServiceImpl.getAllInventory());
		
		return new ResponseEntity<List<InventoryBean>>(listInventory,HttpStatus.OK);
	}

	@RequestMapping(value = "inventory/getDetailsById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InventoryBean> getInventoryDetailByInventoryId(@PathVariable("id") int myId) {
		InventoryBean inventory = inventoryServiceImpl.getInventoryDetailsById(myId);

		if (inventory != null) {
 
			return new ResponseEntity<InventoryBean>(inventory, HttpStatus.OK);
		} else {
			return new ResponseEntity<InventoryBean>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "inventory/getStocksById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getStocksDetailByInventoryId(@PathVariable("id") int myId) {
		InventoryBean inventory = inventoryServiceImpl.getInventoryDetailsById(myId);

		if (inventory != null) {
			String stocks = Integer.toString(inventory.getStock()) ;
			return new ResponseEntity<String>(stocks, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "inventory/getStatusById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getStatusDetailByInventoryId(@PathVariable("id") int myId) {
		InventoryBean inventory = inventoryServiceImpl.getInventoryDetailsById(myId);

		if (inventory != null) {
			String status =  inventory.getStatus() ;
			return new ResponseEntity<String>(status, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/inventory/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> addInventory(@RequestBody InventoryBean inventory) {
		int count=inventoryServiceImpl.addInventory(inventory);
		return new ResponseEntity<String>("Inventory added successfully with id:" + count,HttpStatus.CREATED);
	}

	@RequestMapping(value = "/inventory/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InventoryBean> updateInventory(@RequestBody  InventoryBean inventory) {
		if (inventoryServiceImpl.getInventoryDetailsById(inventory.getId()) == null) {
			InventoryBean inventory2 = null;
			return new ResponseEntity<InventoryBean>(inventory2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		InventoryBean updated = inventoryServiceImpl.updateInventory(inventory);
		return new ResponseEntity<InventoryBean>(updated, HttpStatus.OK);
	}

	@RequestMapping(value = "/inventory/delete/{id}", method = RequestMethod.DELETE,
	produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<InventoryBean> deleteInventory(@PathVariable("id") int myId) {
		InventoryBean inventory2=inventoryServiceImpl.getInventoryDetailsById(myId);
		if (inventoryServiceImpl.getInventoryDetailsById(myId) == null) {
			return new ResponseEntity<InventoryBean>(inventory2,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		inventoryServiceImpl.removeInventory(myId);
		return new ResponseEntity<InventoryBean>(inventory2, HttpStatus.OK);
	}
}