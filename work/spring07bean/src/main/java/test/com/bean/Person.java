package test.com.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Person {
	
	private String address;
	private String tel;
	
	public Person() {
		log.info("Person()...");
	}
	
	public Person(String address, String tel) {
		log.info("Person(String name, int age)...");
		this.address = address;
		this.tel = tel;
	}

}
