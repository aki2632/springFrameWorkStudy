package test.com.fileUpload.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class SampleDAOimpl implements SampleDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insert(SampleVO vo) {
		log.info("insert()...");
		log.info("{}", vo);
        return sqlSession.insert("S_INSERT", vo);
	}

	@Override
	public int update(SampleVO vo) {
		log.info("update()...");
		log.info("{}", vo);
        return sqlSession.update("S_UPDATE", vo);
	}

	@Override
	public int delete(SampleVO vo) {
		log.info("delete()...");
		log.info("{}", vo);
        return sqlSession.delete("S_DELETE", vo);
	}

	@Override
	public SampleVO selectOne(SampleVO vo) {
		log.info("selectOne()...");
		log.info("{}", vo);
        return sqlSession.selectOne("S_SELECT_ONE", vo);
	}

	@Override
	public List<SampleVO> selectAll() {
		log.info("selectAll()...");
        return sqlSession.selectList("S_SELECT_ALL");
	}

	@Override
	public List<SampleVO> searchList(String searchKey, String searchWord) {
		log.info("searchList()...");
		log.info("searchKey:{}", searchKey);
		log.info("searchWord:{}", searchWord);
		List<SampleVO> list = null;
		
       if(searchKey.equals("pname")){
           list = sqlSession.selectList("S_SEARCH_LIST_PNAME", "%" + searchWord + "%");
       }else if(searchKey.equals("model")){
           list = sqlSession.selectList("S_SEARCH_LIST_MODEL", "%" + searchWord + "%");
       }
        return list;
	}

}
