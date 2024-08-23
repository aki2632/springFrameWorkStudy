package test.com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import test.com.product.model.ProductDAO;
import test.com.product.model.ProductVO;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDAO dao;
	
	public ProductServiceImpl() {
		log.info("ProductServiceImpl()...");
	}
	
	public int insert(ProductVO vo) {
		log.info("insert()...");
		return dao.insert(vo);
	}
	public int update(ProductVO vo){
		log.info("update()...");
		return dao.update(vo);
	}
	public int delete(ProductVO vo){
		log.info("delete()...");
		return dao.delete(vo);
	}
	public ProductVO selectOne(ProductVO vo){
		log.info("selectOne()...");
		return dao.selectOne(vo);
	}
	public List<ProductVO> selectAll(){
		log.info("selectAll()...");
		return dao.selectAll();
	}
	public List<ProductVO> searchList(String searchKey,String searchWord){
		log.info("searchList()...");
		return dao.searchList(searchKey, searchWord);
	}

}
