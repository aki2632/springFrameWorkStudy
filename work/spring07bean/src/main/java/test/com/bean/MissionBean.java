package test.com.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class MissionBean {
	
	private Car car;
	
	public MissionBean() {
		log.info("MissionBean()...");
	}
	
	public MissionBean(Car car) {
		log.info("MissionBean(Car car)...");
		this.car = car;
	}

}
