package test.com.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration3 {
	
	@Bean
	public TestBean3 tb07() {
		TestBean3 tb = new TestBean3();
		
		List<String> list = new ArrayList<String>();
		list.add("kim1");
		list.add("kim1");
		list.add("kim1");
		tb.setList(list);
		
		Set<String> set = new HashSet<String>();
		set.add("kim1");
		set.add("kim1");
		set.add("kim1");
		tb.setSet(set);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("num", "11");
		map.put("name", "lee");
		map.put("age", "33");
		tb.setMap(map);

		return tb;
	}

}
