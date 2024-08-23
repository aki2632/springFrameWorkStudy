package test.com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import test.com.board.model.BoardDAO;
import test.com.board.model.BoardVO;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardDAO dao;
	
	public BoardServiceImpl() {
		log.info("BoardServiceImpl()...");
	}
	
	public int insert(BoardVO vo) {
		log.info("insert()...");
		return dao.insert(vo);
	}
	public int update(BoardVO vo){
		log.info("update()...");
		return dao.update(vo);
	}
	public int delete(BoardVO vo){
		log.info("delete()...");
		return dao.delete(vo);
	}
	public BoardVO selectOne(BoardVO vo){
		log.info("selectOne()...");
		return dao.selectOne(vo);
	}
	public List<BoardVO> selectAll(){
		log.info("selectAll()...");
		return dao.selectAll();
	}
	public List<BoardVO> searchList(String searchKey,String searchWord){
		log.info("searchList()...");
		return dao.searchList(searchKey, searchWord);
	}

}
