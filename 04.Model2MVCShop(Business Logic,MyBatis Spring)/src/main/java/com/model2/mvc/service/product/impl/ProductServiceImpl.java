package com.model2.mvc.service.product.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.ProductDAO;


//==> 상품관리 서비스 구현
@Service("productServiceImpl")
public class ProductServiceImpl implements ProductService{
	
	//Field
	@Autowired
	@Qualifier("productDaoImpl")
	private ProductDAO productDAO;
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	//Constructor
	public ProductServiceImpl() {
		System.out.println(this.getClass());
	}
	
	//Method
	public void addProduct(Product productVO) throws Exception {
		productDAO.addProduct(productVO);
	}


	public Product getProduct(int ProductVO) throws Exception {
		return productDAO.getProduct(ProductVO);
	}
	

	public Map<String, Object> getProductList(Search searchVO) throws Exception {
		List<Product> list = productDAO.getProductList(searchVO);
		int totalCount = productDAO.getTotalCount(searchVO);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("totalCount", new Integer(totalCount));
		
		return map;
	}
	
	
	public void updateProduct(Product productVO) throws Exception {
		productDAO.updateProduct(productVO);
	}

}