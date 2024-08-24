package test.com.product.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import test.com.product.model.ProductDAO;
import test.com.product.model.ProductVO;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDAO dao;
    
    @Autowired
    FileUploadService fileUploadService;

    public ProductServiceImpl() {
        log.info("SampleServiceImpl()...");
    }

    @Override
    public int insert(ProductVO vo) throws IllegalStateException, IOException {
        log.info("insert()...");
        fileUploadService.handleFileUploadOrDefault(vo);
        return dao.insert(vo);
    }

    @Override
    public int update(ProductVO vo) throws IllegalStateException, IOException {
        log.info("update()...");
        fileUploadService.handleFileUploadOrRetain(vo);
        return dao.update(vo);
    }

    @Override
    public int delete(ProductVO vo) {
        log.info("delete()...");
        return dao.delete(vo);
    }

    @Override
    public ProductVO selectOne(ProductVO vo) {
        log.info("selectOne()...");
        return dao.selectOne(vo);
    }

    @Override
    public List<ProductVO> selectAll() {
        log.info("selectAll()...");
        return dao.selectAll();
    }

    @Override
    public List<ProductVO> searchList(String searchKey, String searchWord) {
        log.info("searchList()...");
        return dao.searchList(searchKey, searchWord);
    }

}
