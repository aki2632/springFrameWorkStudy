package test.com.bean;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	
	@Autowired
	TestBean tb01;
	@Autowired
	TestBean tb02;
	@Autowired
	TestBean tb03;
	
	@Autowired
	Person p01;
	@Autowired
	Person p02;
	@Autowired
	Person p03;
	
	@Autowired
	TestBean2 tb04;
	@Autowired
	TestBean2 tb05;
	@Autowired
	TestBean2 tb06;
	

	@Autowired
	TestBean3 tb07;
	
	@Autowired
	Car c01;
	@Autowired
	Car c02;
	@Autowired
	Car c03;
	
	@Autowired
	MissionBean mb01;
	@Autowired
	MissionBean mb02;
	@Autowired
	MissionBean mb03;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		log.info("tb01:{}", tb01);
		log.info("tb02:{}", tb02);
		log.info("tb03:{}", tb03);
		
		log.info("p01:{}", p01);
		log.info("p02:{}", p02);
		log.info("p03:{}", p03);
		
		log.info("tb04:{}", tb04);
		log.info("tb05:{}", tb05);
		log.info("tb06:{}", tb06);

		log.info("tb07:{}", tb07);
		
		log.info("c01:{}", c01);
		log.info("c02:{}", c02);
		log.info("c03:{}", c03);
		
		log.info("mb01:{}", mb01);
		log.info("mb02:{}", mb02);
		log.info("mb03:{}", mb03);
		
		return "home";
	}
	
}
