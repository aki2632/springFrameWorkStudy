package test.com.board.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class BoardDAOimpl implements BoardDAO {
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public int insert(BoardVO vo) {
		log.info("insert()...");
		log.info("{}", vo);
        return sqlSession.insert("B_INSERT", vo);
	}

	@Override
	public int update(BoardVO vo) {
		log.info("update()...");
		log.info("{}", vo);
        return sqlSession.update("B_UPDATE", vo);
	}

	@Override
	public int delete(BoardVO vo) {
		log.info("delete()...");
		log.info("{}", vo);
        return sqlSession.delete("B_DELETE", vo);
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		log.info("selectOne()...");
		log.info("{}", vo);
        return sqlSession.selectOne("B_SELECT_ONE", vo);
	}

	@Override
	public List<BoardVO> selectAll() {
		log.info("selectAll()...");
        return sqlSession.selectList("B_SELECT_ALL");
	}

	@Override
	public List<BoardVO> searchList(String searchKey, String searchWord) {
		log.info("searchList()...");
		log.info("searchKey:{}", searchKey);
		log.info("searchWord:{}", searchWord);
		List<BoardVO> list = null;
		
       if(searchKey.equals("title")){
           list = sqlSession.selectList("B_SEARCH_LIST_TITLE", "%" + searchWord + "%");
       }else if(searchKey.equals("content")){
           list = sqlSession.selectList("B_SEARCH_LIST_CONTENT", "%" + searchWord + "%");
       }
        return list;
	}

}
