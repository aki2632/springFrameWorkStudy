package test.com.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class Car {
	
	private int price;
	private String model;
	
	public Car() {
		log.info("Car()...");
	}
	
	public Car(int price, String model) {
		log.info("Car(int price, String model)...");
		this.price = price;
		this.model = model;
	}
	
}
