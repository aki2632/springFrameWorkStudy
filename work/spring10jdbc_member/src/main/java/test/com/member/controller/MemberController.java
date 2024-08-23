package test.com.member.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

import test.com.member.model.MemberVO;
import test.com.member.service.MemberService;

@Slf4j
@Controller
public class MemberController {
	
	@Autowired
	MemberService service;
	
	@RequestMapping(value = {"/","/home.do"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/m_insert.do", method = RequestMethod.GET)
	public String m_insert() {
		log.info("m_insert");
		
		return "member/insert";
	}
	
	
	@RequestMapping(value = "/m_update.do", method = RequestMethod.GET)
	public String m_update(MemberVO vo,Model model) {
		log.info("m_update");
		log.info("{}",vo);
		
		MemberVO vo2 = service.selectOne(vo);
		log.info("vo2:{}",vo2);
		
		model.addAttribute("vo2",vo2);
		
		return "member/update";
	}
	
	@RequestMapping(value = "/m_delete.do", method = RequestMethod.GET)
	public String m_delete() {
		log.info("m_delete");
		
		return "member/delete";
	}
	
	@RequestMapping(value = "/m_selectAll.do", method = RequestMethod.GET)
	public String m_selectAll(Model model) {
		log.info("m_selectAll");
		
		List<MemberVO> list = service.selectAll();
		log.info("{}",list);
		
		model.addAttribute("list",list);
		
		return "member/selectAll";
	}
	
	@RequestMapping(value = "/m_searchList.do", method = RequestMethod.GET)
	public String m_searchList(Model model,@RequestParam(defaultValue = "name")String searchKey,
			@RequestParam(defaultValue = "ki")String searchWord) {
		log.info("m_searchList");
		log.info("searchKey:{}",searchKey);
		log.info("searchWord:{}",searchWord);
		
		List<MemberVO> list = service.searchList(searchKey,searchWord);
		log.info("{}",list);
		
		model.addAttribute("list",list);
		
		return "member/selectAll";
	}
	
	@RequestMapping(value = "/m_selectOne.do", method = RequestMethod.GET)
	public String m_selectOne(MemberVO vo,Model model ) {
		log.info("m_selectOne");
		log.info("{}",vo);
		
		MemberVO vo2 = service.selectOne(vo);
		log.info("vo2:{}",vo2);
		
		model.addAttribute("vo2",vo2);
		
		return "member/selectOne";
	}
	
	@RequestMapping(value = "/m_insertOK.do", method = RequestMethod.POST)
	public String m_insertOK(MemberVO vo) {
		log.info("m_insertOK");
		log.info("{}",vo);
		
		int result = service.insert(vo);
		log.info("result:{}",result);
		
		return "redirect:m_selectAll.do";
	}
	
	@RequestMapping(value = "/m_updateOK.do", method = RequestMethod.POST)
	public String m_updateOK(MemberVO vo) {
		log.info("m_updateOK");
		log.info("{}",vo);
		
		int result = service.update(vo);
		log.info("result:{}",result);
		
		return "redirect:m_selectAll.do";
	}
	
	@RequestMapping(value = "/m_deleteOK.do", method = RequestMethod.POST)
	public String m_deleteOK(MemberVO vo) {
		log.info("m_deleteOK");
		log.info("{}",vo);
		
		int result = service.delete(vo);
		log.info("result:{}",result);
		
		return "redirect:m_selectAll.do";
	}
	
	//spring03board프로젝트도 지금과 똑같이 동작하도록 컴포넌트 추가해주세요.
	
	
	
}//end class
