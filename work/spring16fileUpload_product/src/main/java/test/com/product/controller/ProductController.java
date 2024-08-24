package test.com.product.controller;

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

import test.com.product.model.ProductVO;
import test.com.product.service.ProductService;

@Slf4j
@Controller
public class ProductController {
	
	public ProductController() {
        log.info("ProductController()...");
    }
	
	@Autowired
	ProductService service;
	
	@RequestMapping(value = {"/","/home.do"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		log.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	
	@RequestMapping(value = "/p_insert.do", method = RequestMethod.GET)
	public String p_insert() {
		log.info("p_insert");
		
		return "product/insert";
	}
	
	@RequestMapping(value = "/p_update.do", method = RequestMethod.GET)
	public String p_update(ProductVO vo,Model model) {
		log.info("p_update");
		log.info("vo:{}",vo);
		
		ProductVO vo2 = service.selectOne(vo);
		log.info("vo2:{}",vo2);
		
		model.addAttribute("vo2",vo2);
		
		return "product/update";
	}
	
	
	@RequestMapping(value = "/p_delete.do", method = RequestMethod.GET)
	public String p_delete() {
		log.info("p_delete");
		
		return "product/delete";
	}
	
	
	@RequestMapping(value = "/p_selectOne.do", method = RequestMethod.GET)
	public String p_selectOne(ProductVO vo,Model model) {
		log.info("p_selectOne");
		log.info("vo:{}",vo);
		
		ProductVO vo2 = service.selectOne(vo);
		log.info("vo2:{}",vo2);
		
		model.addAttribute("vo2",vo2);
		
		return "product/selectOne";
	}
	
	@RequestMapping(value = "/p_selectAll.do", method = RequestMethod.GET)
	public String p_selectAll(Model model) {
		log.info("p_selectAll");
		
		List<ProductVO> list = service.selectAll();
		log.info("{}",list);
		
		model.addAttribute("list",list);
		
		return "product/selectAll";
	}
	
	@RequestMapping(value = "/p_searchList.do", method = RequestMethod.GET)
	public String p_searchList(Model model,@RequestParam(defaultValue = "title")String searchKey,
			@RequestParam(defaultValue = "sp")String searchWord) {
		log.info("p_searchList");
		log.info("searchKey:{}",searchKey);
		log.info("searchWord:{}",searchWord);
		
		List<ProductVO> list = service.searchList(searchKey,searchWord);
		log.info("{}",list);
		
		model.addAttribute("list",list);
		
		
		return "product/selectAll";
	}
	
	
	@RequestMapping(value = "/p_insertOK.do", method = RequestMethod.POST)
	public String p_insertOK(ProductVO vo) throws IllegalStateException, IOException {
		log.info("p_insertOK");
		log.info("vo:{}",vo);
		
		int result = service.insert(vo);
		log.info("result:{}",result);
		
		return "redirect:p_selectAll.do";
	}
		
	@RequestMapping(value = "/p_updateOK.do", method = RequestMethod.POST)
	public String p_updateOK(ProductVO vo) throws IllegalStateException, IOException {
	    log.info("p_updateOK");
	    log.info("vo:{}", vo);

	    int result = service.update(vo);
	    log.info("result:{}", result);

	    return "redirect:p_selectOne.do?num=" + vo.getNum();
	}

	
	@RequestMapping(value = "/p_deleteOK.do", method = RequestMethod.POST)
	public String p_deleteOK(ProductVO vo) {
		log.info("p_deleteOK");
		log.info("vo:{}",vo);
		
		int result = service.delete(vo);
		log.info("result:{}",result);
		
		return "redirect:p_selectAll.do";
	}
	
}
