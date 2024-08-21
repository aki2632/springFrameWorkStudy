package test.com.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class TestBean {
	private String name;
	private int age;
	
	public TestBean() {
		log.info("TestBean()...");
	}
	
	public TestBean(String name, int age) {
		log.info("TestBean(String name, int age)...");
		this.name = name;
		this.age = age;
	}
}
