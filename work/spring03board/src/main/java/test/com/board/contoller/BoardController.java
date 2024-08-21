package test.com.board.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import test.com.board.model.BoardVO;
import test.com.board.service.BoardService;

@Slf4j
@Controller
public class BoardController {
	
	
	@Autowired
	BoardService service;
	
	
	@RequestMapping(value = "/b_insert.do", method = RequestMethod.GET)
	public String b_insert() {
		log.info("b_insert");
		
		return "board/insert";
	}
	
	@RequestMapping(value = "/b_update.do", method = RequestMethod.GET)
	public String b_update(BoardVO vo,Model model) {
		log.info("b_update");
		log.info("vo:{}",vo);
		
		BoardVO vo2 = service.selectOne(vo);
		log.info("vo2:{}",vo2);
		
		model.addAttribute("vo2",vo2);
		
		return "board/update";
	}
	
	
	@RequestMapping(value = "/b_delete.do", method = RequestMethod.GET)
	public String b_delete() {
		log.info("b_delete");
		
		return "board/delete";
	}
	
	
	@RequestMapping(value = "/b_selectOne.do", method = RequestMethod.GET)
	public String b_selectOne(BoardVO vo,Model model) {
		log.info("b_selectOne");
		log.info("vo:{}",vo);
		
		BoardVO vo2 = service.selectOne(vo);
		log.info("vo2:{}",vo2);
		
		model.addAttribute("vo2",vo2);
		
		return "board/selectOne";
	}
	
	@RequestMapping(value = "/b_selectAll.do", method = RequestMethod.GET)
	public String b_selectAll(Model model) {
		log.info("b_selectAll");
		
		List<BoardVO> list = service.selectAll();
		log.info("{}",list);
		
		model.addAttribute("list",list);
		
		return "board/selectAll";
	}
	
	@RequestMapping(value = "/b_searchList.do", method = RequestMethod.GET)
	public String b_searchList(Model model,@RequestParam(defaultValue = "title")String searchKey,
			@RequestParam(defaultValue = "sp")String searchWord) {
		log.info("b_searchList");
		log.info("searchKey:{}",searchKey);
		log.info("searchWord:{}",searchWord);
		
		List<BoardVO> list = service.searchList(searchKey,searchWord);
		log.info("{}",list);
		
		model.addAttribute("list",list);
		
		
		return "board/selectAll";
	}
	
	
	@RequestMapping(value = "/b_insertOK.do", method = RequestMethod.POST)
	public String b_insertOK(BoardVO vo) {
		log.info("b_insertOK");
		log.info("vo:{}",vo);
		
		int result = service.insert(vo);
		log.info("result:{}",result);
		
		return "redirect:b_selectAll.do";
	}
		
	@RequestMapping(value = "/b_updateOK.do", method = RequestMethod.POST)
	public String b_updateOK(BoardVO vo) {
		log.info("b_updateOK");
		log.info("vo:{}",vo);
		
		int result = service.update(vo);
		log.info("result:{}",result);
		
		return "redirect:b_selectOne.do?num=33";
	}
	
	@RequestMapping(value = "/b_deleteOK.do", method = RequestMethod.POST)
	public String b_deleteOK(BoardVO vo) {
		log.info("b_deleteOK");
		log.info("vo:{}",vo);
		
		int result = service.delete(vo);
		log.info("result:{}",result);
		
		return "redirect:b_selectAll.do";
	}
	
	
}//end class
