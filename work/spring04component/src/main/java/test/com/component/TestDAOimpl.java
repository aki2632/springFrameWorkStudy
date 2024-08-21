package test.com.component;

import org.springframework.stereotype.Repository;
import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class TestDAOimpl 
				implements TestDAO{
	
		
	
	public TestDAOimpl() {
		log.info("TestRepository()...");
		
	}
	
	@Override
	public int insert() {
		log.info("insert()...");
		return 1;
	}



}
