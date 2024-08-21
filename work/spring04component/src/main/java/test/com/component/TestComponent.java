package test.com.component;

import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestComponent {
	
	private String name;
	private int age;
	
	
	public TestComponent() {
		log.info("TestComponent()...");
		name = "kim";
		age = 33;
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "TestComponent [name=" + name + ", age=" + age + "]";
	}
	
	
	

}
