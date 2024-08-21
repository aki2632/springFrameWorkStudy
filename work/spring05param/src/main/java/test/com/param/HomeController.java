package test.com.param;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/","/home.do"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model,
			@RequestParam(defaultValue = "lee") String name,
			@RequestParam(defaultValue = "0") int age) {
		logger.info("Welcome home! The client locale is {}.", locale);
		logger.info("name:{}",name);
		logger.info("age:{}",age);
		
		TestVO vo = new TestVO();
		vo.setName(name);
		vo.setAge(age);
		
		//int result = service.insert(vo);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/home2.do", method = RequestMethod.GET)
	public String home2(TestVO vo) {
		logger.info("Welcome home2");
		logger.info("vo:{}",vo);
		
		//int result = service.insert(vo);
		
		return "home2";
	}
	
}
