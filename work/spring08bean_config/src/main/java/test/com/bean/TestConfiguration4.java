package test.com.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration4 {
	
	@Bean
	public Car c01() {
		return new Car();
	}
	
	@Bean
	public Car c02() {
		return new Car(1000, "EuroTruck");
	}
	
	@Bean
	public Car c03() {
		Car c = new Car();
		c.setPrice(1250);
		c.setModel("AmericanTruck");
		return c;
	}
	
	@Bean
	public MissionBean mb01() {
		return new MissionBean();
	}
	
	@Bean
	public MissionBean mb02() {
		return new MissionBean(c02());
	}
	
	@Bean
	public MissionBean mb03() {
		MissionBean mb = new MissionBean();
		mb.setCar(c03());
		return mb;
	}

}
