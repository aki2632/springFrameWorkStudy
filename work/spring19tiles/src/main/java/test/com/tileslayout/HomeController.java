package test.com.tileslayout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = { "/", "/home.do" }, method = RequestMethod.GET)
	public String home() {
		logger.info("/home.do");
		
		return ".home";
	}
	
	@RequestMapping(value = "/test.do" , method = RequestMethod.GET)
	public String test() {
		logger.info("/test.do");
		
		return ".test/test";
	}
	
	@RequestMapping(value = "/test2.do" , method = RequestMethod.GET)
	public String test2() {
		logger.info("/test2.do");
		
		return ".test/test2";
	}
	
	@RequestMapping(value = "/b_insert.do" , method = RequestMethod.GET)
	public String b_insert() {
		logger.info("/b_insert.do");
		
		return ".board/insert";
	}
	
	@RequestMapping(value = "/b_select.do" , method = RequestMethod.GET)
	public String b_select() {
		logger.info("/b_select.do");
		
		return ".borad/select";
	}
	
	@RequestMapping(value = "/m_insert.do" , method = RequestMethod.GET)
	public String m_insert() {
		logger.info("/m_insert.do");
		
		return ".member/insert";
	}
	
	@RequestMapping(value = "/m_select.do" , method = RequestMethod.GET)
	public String m_select() {
		logger.info("/m_select.do");
		
		return ".member/select";
	}
	
}
