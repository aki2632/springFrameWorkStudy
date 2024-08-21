package test.com.member.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
import test.com.member.model.MemberVO;
import test.com.member.service.MemberService;

/**
 * Handles requests for the Member-related pages.
 */
@Controller
@Slf4j
public class MemberController {

    public MemberController() {
        log.info("MemberController()...");
    }

    @Autowired
    MemberService memberService;
    
    @RequestMapping(value = {"/","/home.do"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		log.info("formattedDate {}.", formattedDate);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}//end home

    @RequestMapping(value = "/memberList.do", method = RequestMethod.GET)
    public String memberList(Locale locale, Model model) {
        log.info("memberList()...");
        
        List<MemberVO> members = memberService.getAllMembers();
        model.addAttribute("members", members);
        
        return "member/memberList"; // memberList.jsp를 반환
    }
    
    @RequestMapping(value = "/registerMember.do", method = RequestMethod.GET)
    public String showRegisterForm() {
        log.info("showRegisterForm()...");
        return "member/registerMember"; // registerMember.jsp를 반환
    }

    @RequestMapping(value = "/registerMember.do", method = RequestMethod.POST)
    public String registerMember(MemberVO vo, Model model) {
        log.info("registerMember()...");
        
        int result = memberService.register(vo);
        log.info("Member registration result: {}", result);
        
        // 등록 후 다시 목록 페이지로 리다이렉트
        return "redirect:/memberList.do";
    }
    
    @RequestMapping(value = "/memberDetail.do", method = RequestMethod.GET)
    public String memberDetail(MemberVO vo, Model model) {
        log.info("memberDetail()...");
        
        MemberVO member = memberService.getMember(vo);
        model.addAttribute("member", member);
        
        return "member/memberDetail"; // memberDetail.jsp를 반환
    }
    
    @RequestMapping(value = "/memberEdit.do/{num}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable int num, Model model) {
        log.info("showEditForm()... num: {}", num);
        
        MemberVO vo = new MemberVO();
        vo.setNum(num);
        MemberVO member = memberService.getMember(vo);
        model.addAttribute("member", member);
        
        return "member/editMember"; // editMember.jsp를 반환
    }

    @RequestMapping(value = "/memberEdit.do", method = RequestMethod.POST)
    public String updateMember(MemberVO vo, Model model) {
        log.info("updateMember()... {}", vo);
        
        int result = memberService.modify(vo);
        log.info("Member update result: {}", result);
        
        // 수정 후 다시 상세 페이지로 리다이렉트
        return "redirect:/memberDetail.do?num=" + vo.getNum();
    }

    @RequestMapping(value = "/memberDelete.do/{num}", method = RequestMethod.POST)
    public String deleteMember(@PathVariable int num, Model model) {
        log.info("deleteMember()... num: {}", num);
        
        MemberVO vo = new MemberVO();
        vo.setNum(num);
        int result = memberService.remove(vo);
        log.info("Member delete result: {}", result);
        
        // 삭제 후 목록 페이지로 리다이렉트
        return "redirect:/memberList.do";
    }
}
