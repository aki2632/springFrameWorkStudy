package test.com.member.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import test.com.member.model.MemberDAO;
import test.com.member.model.MemberVO;
import test.com.member.service.FileUploadService;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDAO dao;

	@Autowired
	FileUploadService fileUploadService;

	public MemberServiceImpl() {
		log.info("MemberServiceImpl()...");
	}

	public int insert(MemberVO vo) throws IllegalStateException, IOException {
		log.info("insert()...");
		fileUploadService.handleFileUploadOrDefault(vo);
		return dao.insert(vo);
	}

	public int update(MemberVO vo) throws IllegalStateException, IOException {
		log.info("update()...");
		fileUploadService.handleFileUploadOrRetain(vo);
		return dao.update(vo);
	}

	public int delete(MemberVO vo) {
		log.info("delete()...");
		return dao.delete(vo);
	}

	public MemberVO selectOne(MemberVO vo) {
		log.info("selectOne()...");
		return dao.selectOne(vo);
	}

	public List<MemberVO> selectAll() {
		log.info("selectAll()...");
		return dao.selectAll();
	}

	public List<MemberVO> searchList(String searchKey, String searchWord) {
		log.info("searchList()...");
		return dao.searchList(searchKey, searchWord);
	}

	public MemberVO idCheck(MemberVO vo) {
		log.info("idCheck()...");
		return dao.idCheck(vo);
	}

	public MemberVO login(MemberVO vo) {
		log.info("login()...");
		return dao.login(vo);
	}

}
