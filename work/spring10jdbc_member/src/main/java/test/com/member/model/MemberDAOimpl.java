package test.com.member.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MemberDAOimpl implements MemberDAO {
	
	private static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "JAVA";
    private static final String PASSWORD = "hi123456";
    private Connection conn;//커넥션객체
    private PreparedStatement pstmt;//쿼리(sql문-CRUD)실행객체
    private ResultSet rs;//select문 리턴 객체
	
	public MemberDAOimpl() {
		log.info("MemberDAOimpl()...");
		
		// 오라클 드라이버 클래스 연동
        try {
            Class.forName(DRIVER_NAME);
            log.info("Driver successed...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
	}

	@Override
	public int insert(MemberVO vo) {
		log.info("insert()...");
		log.info("{}",vo);
		int flag = 0;

        // 커넥션
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            log.info("conn successed...");

            String sql = "insert into member(num,id,pw,name,tel) " + "values(seq_member.nextval,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getId());
            pstmt.setString(2,vo.getPw());
            pstmt.setString(3,vo.getName());
            pstmt.setString(4,vo.getTel());

            flag = pstmt.executeUpdate(); // DML 데이터 변경 목적의 함수 insert, update, delete 문에서 사용
            log.info("flag : "+ flag);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return flag;
	}

	@Override
	public int update(MemberVO vo) {
		log.info("update()...");
		log.info("{}",vo);
		int flag = 0;

        // 커넥션
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            log.info("conn successed...");

            String sql = "update member set id=?,pw=?,name=?,tel=? " + " where num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getId());
            pstmt.setString(2,vo.getPw());
            pstmt.setString(3,vo.getName());
            pstmt.setString(4,vo.getTel());
            pstmt.setInt(5,vo.getNum());

            flag = pstmt.executeUpdate(); // DML 데이터 변경 목적의 함수 insert, update, delete 문에서 사용
            log.info("flag : "+ flag);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return flag;
	}

	@Override
	public int delete(MemberVO vo) {
		log.info("delete()...");
		log.info("{}",vo);
		int flag = 0;

        // 커넥션
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            log.info("conn successed...");

            String sql = "delete from member" + " where num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getNum());

            flag = pstmt.executeUpdate(); // DML 데이터 변경 목적의 함수 insert, update, delete 문에서 사용
            log.info("flag : "+ flag);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return flag;
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		log.info("selectOne()...");
		log.info("{}",vo);
		
		MemberVO vo2 = null;

        // 커넥션
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            log.info("conn successed...");

            String sql = "select * from member where num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getNum());

            rs = pstmt.executeQuery(); // 데이터 조회 목적의 함수 select 문에서 사용

            while (rs.next()){
                vo2 = new MemberVO();
                vo2.setNum(rs.getInt("num"));
                vo2.setId(rs.getString("id"));
                vo2.setPw(rs.getString("pw"));
                vo2.setName(rs.getString("name"));
                vo2.setTel(rs.getString("tel"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return vo2;
	}

	@Override
	public List<MemberVO> selectAll() {
		log.info("selectAll()...");
		
		List<MemberVO> list  = new ArrayList<MemberVO>();

        // 커넥션
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            log.info("conn successed...");

            // 쿼리문 전달(요청)
            String sql = "select * from member order by num desc";
            pstmt = conn.prepareStatement(sql);

            // 반환(응답)
            rs = pstmt.executeQuery(); // 데이터 조회 목적의 함수 select 문에서 사용

            // rs >>> list에 할당
            while(rs.next()){//읽어들일 행이 있으면 true
                MemberVO vo = new MemberVO();
                vo.setNum(rs.getInt("num"));
                vo.setId(rs.getString("id"));
                vo.setPw(rs.getString("pw"));
                vo.setName(rs.getString("name"));
                vo.setTel(rs.getString("tel"));
                list.add(vo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
	}

	@Override
	public List<MemberVO> searchList(String searchKey, String searchWord) {
		log.info("searchList()...");
		log.info("searchKey:{}",searchKey);
		log.info("searchWord:{}",searchWord);
		List<MemberVO> list  = new ArrayList<MemberVO>();

        // 커넥션
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            log.info("conn successed...");
            String sql = "";
            if(searchKey.equals("name")){
                sql = "select * from member where name like ? order by num desc";
            }else if(searchKey.equals("id")){
                sql = "select * from member where id like ? order by num desc";
            }

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+searchWord+"%");

            // 반환(응답)
            rs = pstmt.executeQuery(); // 데이터 조회 목적의 함수 select 문에서 사용

            // rs >>> list에 할당
            while(rs.next()){//읽어들일 행이 있으면 true
                MemberVO vo = new MemberVO();
                vo.setNum(rs.getInt("num"));
                vo.setId(rs.getString("id"));
                vo.setPw(rs.getString("pw"));
                vo.setName(rs.getString("name"));
                vo.setTel(rs.getString("tel"));
                list.add(vo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
	}

}
