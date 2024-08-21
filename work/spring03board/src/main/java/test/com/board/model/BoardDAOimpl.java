package test.com.board.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class BoardDAOimpl implements BoardDAO {

	public BoardDAOimpl() {
		log.info("BoardDAOimpl()...");
	}

	@Override
	public int insert(BoardVO vo) {
		log.info("insert()...");
		log.info("{}", vo);
		return 0;
	}

	@Override
	public int update(BoardVO vo) {
		log.info("update()...");
		log.info("{}", vo);
		return 0;
	}

	@Override
	public int delete(BoardVO vo) {
		log.info("delete()...");
		log.info("{}", vo);
		return 0;
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		log.info("selectOne()...");
		log.info("{}", vo);

		BoardVO vo2 = new BoardVO();
		vo2.setNum(1);
		vo2.setTitle("spring");
		vo2.setContent("hello");
		vo2.setWriter("admin");
		vo2.setWdate("2024-12-25");

		return vo2;
	}

	@Override
	public List<BoardVO> selectAll() {
		log.info("selectAll()...");

		List<BoardVO> list = new ArrayList<BoardVO>();
		for (int i = 0; i < 3; i++) {
			BoardVO vo2 = new BoardVO();
			vo2.setNum(1 + i);
			vo2.setTitle("spring");
			vo2.setContent("hello");
			vo2.setWriter("admin");
			vo2.setWdate("2024-12-25");
			list.add(vo2);
		}

		return list;
	}

	@Override
	public List<BoardVO> searchList(String searchKey, String searchWord) {
		log.info("searchList()...");
		log.info("searchKey:{}", searchKey);
		log.info("searchWord:{}", searchWord);
		List<BoardVO> list = new ArrayList<BoardVO>();
		for (int i = 0; i < 3; i++) {
			BoardVO vo2 = new BoardVO();
			vo2.setNum(1 + i);
			vo2.setTitle("spring");
			vo2.setContent("hello");
			vo2.setWriter("admin");
			vo2.setWdate("2024-12-25");
			list.add(vo2);
		}

		return list;
	}

}
