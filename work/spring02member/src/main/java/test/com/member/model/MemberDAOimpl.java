package test.com.member.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MemberDAOimpl implements MemberDAO {
	
	public MemberDAOimpl() {
		log.info("MemberDAOimpl()...");
	}

	@Override
	public int insert(MemberVO vo) {
		log.info("insert()...");
		log.info("{}",vo);
		return 0;
	}

	@Override
	public int update(MemberVO vo) {
		log.info("update()...");
		log.info("{}",vo);
		return 0;
	}

	@Override
	public int delete(MemberVO vo) {
		log.info("delete()...");
		log.info("{}",vo);
		return 0;
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		log.info("selectOne()...");
		log.info("{}",vo);
		
		MemberVO vo2 = new MemberVO();
		vo2.setNum(1);
		vo2.setId("admin");
		vo2.setPw("hi1111");
		vo2.setName("kim");
		vo2.setTel("011");
		
		return vo2;
	}

	@Override
	public List<MemberVO> selectAll() {
		log.info("selectAll()...");
		
		List<MemberVO> list = new ArrayList<MemberVO>();
		for (int i = 0; i < 3; i++) {
			MemberVO vo2 = new MemberVO();
			vo2.setNum(1+i);
			vo2.setId("admin"+i);
			vo2.setPw("hi1111"+i);
			vo2.setName("kim"+i);
			vo2.setTel("011"+i);
			list.add(vo2);
		}
		
		return list;
	}

	@Override
	public List<MemberVO> searchList(String searchKey, String searchWord) {
		log.info("searchList()...");
		log.info("searchKey:{}",searchKey);
		log.info("searchWord:{}",searchWord);
		List<MemberVO> list = new ArrayList<MemberVO>();
		for (int i = 0; i < 3; i++) {
			MemberVO vo2 = new MemberVO();
			vo2.setNum(1+i);
			vo2.setId("admin"+i);
			vo2.setPw("hi1111"+i);
			vo2.setName("kim"+i);
			vo2.setTel("011"+i);
			list.add(vo2);
		}
		
		return list;
	}

}
