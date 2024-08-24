package test.com.fileUpload.controller;

import java.io.IOException;

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

import test.com.fileUpload.model.SampleVO;
import test.com.fileUpload.service.SampleService;

@Slf4j
@Controller
public class SampleController {
	
	@Autowired
	SampleService service;
	
	@RequestMapping(value = {"/","/home.do"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping(value = "/s_insert.do", method = RequestMethod.GET)
	public String s_insert() {
		log.info("s_insert");
		
		return "fileUpload/insert";
	}
	
	@RequestMapping(value = "/s_update.do", method = RequestMethod.GET)
	public String s_update(SampleVO vo,Model model) {
		log.info("s_update");
		log.info("vo:{}",vo);
		
		SampleVO vo2 = service.selectOne(vo);
		log.info("vo2:{}",vo2);
		
		model.addAttribute("vo2",vo2);
		
		return "fileUpload/update";
	}
	
	
	@RequestMapping(value = "/s_delete.do", method = RequestMethod.GET)
	public String s_delete() {
		log.info("s_delete");
		
		return "fileUpload/delete";
	}
	
	
	@RequestMapping(value = "/s_selectOne.do", method = RequestMethod.GET)
	public String s_selectOne(SampleVO vo,Model model) {
		log.info("s_selectOne");
		log.info("vo:{}",vo);
		
		SampleVO vo2 = service.selectOne(vo);
		log.info("vo2:{}",vo2);
		
		model.addAttribute("vo2",vo2);
		
		return "fileUpload/selectOne";
	}
	
	@RequestMapping(value = "/s_selectAll.do", method = RequestMethod.GET)
	public String s_selectAll(Model model) {
		log.info("s_selectAll");
		
		List<SampleVO> list = service.selectAll();
		log.info("{}",list);
		
		model.addAttribute("list",list);
		
		return "fileUpload/selectAll";
	}
	
	@RequestMapping(value = "/s_searchList.do", method = RequestMethod.GET)
	public String s_searchList(Model model,@RequestParam(defaultValue = "title")String searchKey,
			@RequestParam(defaultValue = "sp")String searchWord) {
		log.info("s_searchList");
		log.info("searchKey:{}",searchKey);
		log.info("searchWord:{}",searchWord);
		
		List<SampleVO> list = service.searchList(searchKey,searchWord);
		log.info("{}",list);
		
		model.addAttribute("list",list);
		
		
		return "fileUpload/selectAll";
	}
	
	
	@RequestMapping(value = "/s_insertOK.do", method = RequestMethod.POST)
	public String s_insertOK(SampleVO vo) throws IllegalStateException, IOException {
		log.info("s_insertOK");
		log.info("vo:{}",vo);
		
		int result = service.insert(vo);
		log.info("result:{}",result);
		
		return "redirect:s_selectAll.do";
	}
		
	@RequestMapping(value = "/s_updateOK.do", method = RequestMethod.POST)
	public String s_updateOK(SampleVO vo) throws IllegalStateException, IOException {
	    log.info("s_updateOK");
	    log.info("vo:{}", vo);

	    int result = service.update(vo);
	    log.info("result:{}", result);

	    return "redirect:s_selectOne.do?num=" + vo.getNum();
	}

	
	@RequestMapping(value = "/s_deleteOK.do", method = RequestMethod.POST)
	public String s_deleteOK(SampleVO vo) {
		log.info("s_deleteOK");
		log.info("vo:{}",vo);
		
		int result = service.delete(vo);
		log.info("result:{}",result);
		
		return "redirect:s_selectAll.do";
	}
	
}
