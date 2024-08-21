package test.com.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class TestBean2 {
	private Person person;
	
	public TestBean2() {
		log.info("TestBean2()...");
	}
	
	public TestBean2(Person person) {
		log.info("TestBean2(Person person)...");
		this.person = person;
	}
}
