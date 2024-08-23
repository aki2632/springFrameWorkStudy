package test.com.member.service;

import java.util.List;

import test.com.member.model.MemberVO;

public interface MemberService {
	
	public int insert(MemberVO vo);
	public int update(MemberVO vo);
	public int delete(MemberVO vo);
	public MemberVO selectOne(MemberVO vo);
	public List<MemberVO> selectAll();
	public List<MemberVO> searchList(String searchKey,String searchWord);

}
