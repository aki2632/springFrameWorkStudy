package test.com.board.service;

import java.util.List;

import test.com.board.model.BoardVO;

public interface BoardService {
	
	public int insert(BoardVO vo);
	public int update(BoardVO vo);
	public int delete(BoardVO vo);
	public BoardVO selectOne(BoardVO vo);
	public List<BoardVO> selectAll();
	public List<BoardVO> searchList(String searchKey,String searchWord);

}
