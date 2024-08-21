package test.com.member.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import test.com.member.model.MemberDAO;
import test.com.member.model.MemberVO;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDAO memberDAO;

    @Override
    public int register(MemberVO vo) {
        log.info("register()... {}", vo);
        return memberDAO.insert(vo);
    }

    @Override
    public int modify(MemberVO vo) {
        log.info("modify()... {}", vo);
        return memberDAO.update(vo);
    }

    @Override
    public int remove(MemberVO vo) {
        log.info("remove()... {}", vo);
        return memberDAO.delete(vo);
    }

    @Override
    public MemberVO getMember(MemberVO vo) {
        log.info("getMember()... {}", vo);
        return memberDAO.selectOne(vo);
    }

    @Override
    public List<MemberVO> getAllMembers() {
        log.info("getAllMembers()...");
        return memberDAO.selectAll();
    }

    @Override
    public List<MemberVO> searchMembers(String searchKey, String searchWord) {
        log.info("searchMembers()... searchKey: {}, searchWord: {}", searchKey, searchWord);
        return memberDAO.searchList(searchKey, searchWord);
    }
}
