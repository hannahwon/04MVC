package com.model2.mvc.service.product.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.ProductDAO;

//==> 상품관리 DAO CRUD 구현
@Repository("productDaoImpl")
public class ProductDaoImpl implements ProductDAO{
	
	//field
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
			this.sqlSession = sqlSession;
	}
	
	//Constructor
	public ProductDaoImpl() {
		
	}
	
	//Method
	public void addProduct(Product productVO) throws Exception {
		sqlSession.insert("ProductMapper.addProduct", productVO);
	}


	public Product getProduct(int ProductVO) throws Exception {
		return sqlSession.selectOne("ProductMapper.getProduct", ProductVO);
	}
	

	public List<Product> getProductList(Search searchVO) throws Exception {
		return sqlSession.selectList("ProductMapper.getProductList", searchVO);
	}

	
	public void updateProduct(Product productVO) throws Exception {
		sqlSession.update("ProductMapper.updateProduct", productVO);
	}
	
	//게시판 Page 처리를 위한 전체 Row(TotalCount) return
	public int getTotalCount(Search search) throws Exception {
		return sqlSession.selectOne("ProductMapper.getTotalCount", search);
	}

}