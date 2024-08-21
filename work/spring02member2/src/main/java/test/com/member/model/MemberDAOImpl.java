package test.com.member.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MemberDAOImpl implements MemberDAO {

    // 임시로 메모리 내에서 데이터를 저장하기 위한 리스트
    private List<MemberVO> members = new ArrayList<MemberVO>();
    private int idCounter = 0;

    @Override
    public int insert(MemberVO vo) {
        log.info("insert()... {}", vo);
        vo.setNum(++idCounter); // 가입 시 num 증가 
        members.add(vo);
        return 1; // Return success code
    }

    @Override
    public int update(MemberVO vo) {
        log.info("update()... {}", vo);
        for (MemberVO member : members) {
            if (member.getNum() == vo.getNum()) {
                member.setId(vo.getId());
                member.setPw(vo.getPw());
                member.setName(vo.getName());
                member.setTel(vo.getTel());
                return 1; // 임시로 성공을 가정
            }
        }
        return 0;
    }

    @Override
    public int delete(MemberVO vo) {
        log.info("delete()... {}", vo);
        for (MemberVO member : members) {
            if (member.getNum() == vo.getNum()) {
                members.remove(member);
                return 1; // 성공적으로 삭제된 경우
            }
        }
        return 0;
    }

    @Override
    public MemberVO selectOne(MemberVO vo) {
        log.info("selectOne()... {}", vo);
        for (MemberVO member : members) {
            if (member.getNum() == vo.getNum()) {
                return member;
            }
        }
        return null; // 해당하는 멤버가 없는 경우
    }

    @Override
    public List<MemberVO> selectAll() {
        log.info("selectAll()...");
        return new ArrayList<MemberVO>(members); // 모든 멤버 리스트 반환
    }

    @Override
    public List<MemberVO> searchList(String searchKey, String searchWord) {
        log.info("searchList()... searchKey: {}, searchWord: {}", searchKey, searchWord);
        List<MemberVO> result = new ArrayList<MemberVO>();
        for (MemberVO member : members) {
            if (searchKey.equals("name") && member.getName().contains(searchWord)) {
                result.add(member);
            } else if (searchKey.equals("id") && member.getId().contains(searchWord)) {
                result.add(member);
            }
        }
        return result;
    }
}