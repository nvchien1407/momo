package com.momo.service.interfaces;

import java.util.List;

import com.momo.domain.ProductDo;

public interface TestService extends CommonService{
	public List<ProductDo> getList();
}
