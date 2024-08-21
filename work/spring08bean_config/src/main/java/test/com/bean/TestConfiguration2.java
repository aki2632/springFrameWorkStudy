package test.com.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration2 {
	
	@Bean
	public Person p01() {
		return new Person();
	}
	
	@Bean
	public Person p02() {
		return new Person("seoul", "010");
	}
	
	@Bean
	public Person p03() {
		Person p = new Person();
		p.setAddress("busan");
		p.setTel("011");
		return p;
	}
	
	@Bean
	public TestBean2 tb04() {
		return new TestBean2();
	}
	
	@Bean
	public TestBean2 tb05() {
		return new TestBean2(p02());
	}
	
	@Bean
	public TestBean2 tb06() {
		TestBean2 tb = new TestBean2();
		tb.setPerson(p03());
		return tb;
	}

}
