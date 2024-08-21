package test.com.member.service;

import java.util.List;

import test.com.member.model.MemberVO;

public interface MemberService {
    public int register(MemberVO vo);
    public int modify(MemberVO vo);
    public int remove(MemberVO vo);
    public MemberVO getMember(MemberVO vo);
    public List<MemberVO> getAllMembers();
    public List<MemberVO> searchMembers(String searchKey, String searchWord);
}