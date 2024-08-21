package test.com.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TestService {
	
	@Autowired
	TestDAO dao;
	
	public TestService() {
		log.info("TestService()...");
		
	}
	
	public int insert() {
		log.info("insert()...");
		return dao.insert();
	}



}
