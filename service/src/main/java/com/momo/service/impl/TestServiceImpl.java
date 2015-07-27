package com.momo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.momo.dao.ProductDao;
import com.momo.dao.TaskDao;
import com.momo.domain.ProductDo;
import com.momo.service.interfaces.TestService;

@Qualifier("testService")
public class TestServiceImpl implements TestService{
	
	@Qualifier("productDao")
	private ProductDao productDao;
	
	@Autowired
	public TestServiceImpl(ProductDao productDao, TaskDao taskDao){
		this.productDao=productDao;
	}
	
	public List<ProductDo> getList() {
		return productDao.getAllProducts();
	}

	/**
	 * @return the productDao
	 */
	public ProductDao getProductDao() {
		return productDao;
	}

	/**
	 * @param productDao the productDao to set
	 */
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	
}
