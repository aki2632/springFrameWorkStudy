package test.com.member.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

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

	@Autowired
	private HttpSession session;

	@RequestMapping(value = { "/", "/home.do" }, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return ".home";
	}

	@RequestMapping(value = "/m_insert.do", method = RequestMethod.GET)
	public String m_insert() {
		log.info("m_insert");

		return ".member/insert";
	}

	@RequestMapping(value = "/m_update.do", method = RequestMethod.GET)
	public String m_update(MemberVO vo, Model model) {
		log.info("m_update");
		log.info("{}", vo);

		MemberVO vo2 = service.selectOne(vo);
		log.info("vo2:{}", vo2);

		model.addAttribute("vo2", vo2);

		return ".member/update";
	}

	@RequestMapping(value = "/m_delete.do", method = RequestMethod.GET)
	public String m_delete() {
		log.info("m_delete");

		return ".member/delete";
	}

	@RequestMapping(value = "/m_selectAll.do", method = RequestMethod.GET)
	public String m_selectAll(Model model) {
		log.info("m_selectAll");

		List<MemberVO> list = service.selectAll();
		log.info("{}", list);

		model.addAttribute("list", list);

		return ".member/selectAll";
	}

	@RequestMapping(value = "/m_searchList.do", method = RequestMethod.GET)
	public String m_searchList(Model model, @RequestParam(defaultValue = "name") String searchKey,
			@RequestParam(defaultValue = "ki") String searchWord) {
		log.info("m_searchList");
		log.info("searchKey:{}", searchKey);
		log.info("searchWord:{}", searchWord);

		List<MemberVO> list = service.searchList(searchKey, searchWord);
		log.info("{}", list);

		model.addAttribute("list", list);

		return ".member/selectAll";
	}

	@RequestMapping(value = "/m_selectOne.do", method = RequestMethod.GET)
	public String m_selectOne(MemberVO vo, Model model) {
		log.info("m_selectOne");
		log.info("{}", vo);

		MemberVO vo2 = service.selectOne(vo);
		log.info("vo2:{}", vo2);

		model.addAttribute("vo2", vo2);

		return ".member/selectOne";
	}

	@RequestMapping(value = "/m_login.do", method = RequestMethod.GET)
	public String m_login() {
		log.info("m_login");

		return ".member/login";
	}

	@RequestMapping(value = "/m_logout.do", method = RequestMethod.GET)
	public String m_logout() {
		log.info("m_logout");

		session.invalidate();

		return "redirect:home.do";
	}

	@RequestMapping(value = "/m_insertOK.do", method = RequestMethod.POST)
	public String m_insertOK(MemberVO vo) throws IllegalStateException, IOException {
		log.info("m_insertOK");
		log.info("{}", vo);

		int result = service.insert(vo);
		log.info("result:{}", result);

		return "redirect:m_selectAll.do";
	}

	@RequestMapping(value = "/m_updateOK.do", method = RequestMethod.POST)
	public String m_updateOK(MemberVO vo) throws IllegalStateException, IOException {
		log.info("m_updateOK");
		log.info("{}", vo);

		int result = service.update(vo);
		log.info("result:{}", result);

		return "redirect:m_selectAll.do?num=" + vo.getNum();
	}

	@RequestMapping(value = "/m_deleteOK.do", method = RequestMethod.POST)
	public String m_deleteOK(MemberVO vo) {
		log.info("m_deleteOK");
		log.info("{}", vo);

		int result = service.delete(vo);
		log.info("result:{}", result);

		return "redirect:m_selectAll.do";
	}

	@RequestMapping(value = "/m_loginOK.do", method = RequestMethod.POST)
	public String m_loginOK(MemberVO vo, Model model) {
		log.info("m_loginOK");

		MemberVO vo2 = service.login(vo);
		log.info("vo2:{}", vo2);

		if (vo2 != null) {
			// 로그인 성공 시 세션에 사용자 ID 저장
			session.setAttribute("user_id", vo2.getId());
			session.setMaxInactiveInterval(5 * 60);  // 세션 지속 시간 5분
			return "redirect:home.do";
		} else {
			// 로그인 실패 시 에러 메시지와 함께 로그인 페이지로 이동
			model.addAttribute("error", "Invalid username or password");
			return ".member/login";
		}
	}

}// end class
