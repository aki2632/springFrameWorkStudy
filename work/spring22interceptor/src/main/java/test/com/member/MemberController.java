package test.com.member;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		log.info("login.do");
		return "login";
	}
	
	@RequestMapping(value = "/selectAll.do", method = RequestMethod.GET)
	public String selectAll(Locale locale, Model model) {
		log.info("selectAll.do");
		return "selectAll";
	}
	
	@RequestMapping(value = "/loginOK.do", method = RequestMethod.GET)
	public String loginOK(Locale locale, Model model) {
		log.info("loginOK.do");
		
		session.setAttribute("user_id", "admin");
		
		return "redirect:home.do";
	}
	
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public String logout(Locale locale, Model model) {
		log.info("logout.do");
		
		session.removeAttribute("user_id");
		
		return "redirect:home.do";
	}
	
	@RequestMapping(value = "/selectOne.do", method = RequestMethod.GET)
	public String selectOne(Locale locale, Model model) {
		log.info("selectOne.do");
		
		return "redirect:home.do";
	}
	
}
