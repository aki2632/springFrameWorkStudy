package test.com.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	@Autowired
	TestDAO dao;

	public int insert(TestVO vo) {
		return dao.insert(vo);
	}
	
	

}
