package test.com.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {
	
	@Bean
	public TestBean tb01() {
		return new TestBean();
	}
	
	@Bean
	public TestBean tb02() {
		return new TestBean("kim", 33);
	}
	
	@Bean
	public TestBean tb03() {
		TestBean tb = new TestBean();
		tb.setName("lee");
		tb.setAge(44);
		return tb;
	}

}
