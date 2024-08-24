package test.com.member.service;

import java.io.IOException;
import java.util.List;

import test.com.member.model.MemberVO;

public interface MemberService {
	
	public int insert(MemberVO vo) throws IllegalStateException, IOException;
	public int update(MemberVO vo) throws IllegalStateException, IOException;
	public int delete(MemberVO vo);
	public MemberVO selectOne(MemberVO vo);
	public List<MemberVO> selectAll();
	public List<MemberVO> searchList(String searchKey,String searchWord);

}
