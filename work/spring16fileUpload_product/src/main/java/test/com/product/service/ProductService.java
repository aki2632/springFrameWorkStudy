package test.com.product.service;

import java.io.IOException;
import java.util.List;

import test.com.product.model.ProductVO;

public interface ProductService {
	
    public int insert(ProductVO vo) throws IllegalStateException, IOException;
    public int update(ProductVO vo) throws IllegalStateException, IOException;
    public int delete(ProductVO vo);
    
    public ProductVO selectOne(ProductVO vo);
    public List<ProductVO> selectAll();
    public List<ProductVO> searchList(String searchKey, String searchWord);
}
