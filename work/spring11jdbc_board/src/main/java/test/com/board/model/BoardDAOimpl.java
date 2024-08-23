package test.com.board.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class BoardDAOimpl implements BoardDAO {
	
	// DB 전역변수 설정
    private static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER = "JAVA";
    private static final String PASSWORD = "hi123456";
    private Connection conn;//커넥션객체
    private PreparedStatement pstmt;//쿼리(sql문-CRUD)실행객체
    private ResultSet rs;//select문 리턴 객체

	public BoardDAOimpl() {
		log.info("BoardDAOimpl()...");
		
		 // 오라클 드라이버 클래스 연동
        try {
            Class.forName(DRIVER_NAME);
            log.info("Driver successed...");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
	}

	@Override
	public int insert(BoardVO vo) {
		log.info("insert()...");
		log.info("{}", vo);
		int flag = 0;

        // 커넥션
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            log.info("conn successed...");

            String sql = "insert into board(num,title,content,writer) " + "values(seq_board.nextval,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,vo.getTitle());
            pstmt.setString(2,vo.getContent());
            pstmt.setString(3,vo.getWriter());

            flag = pstmt.executeUpdate(); // DML 데이터 변경 목적의 함수 insert, update, delete 문에서 사용
            System.out.println("flag : "+ flag);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return flag;
	}

	@Override
	public int update(BoardVO vo) {
		log.info("update()...");
		log.info("{}", vo);
		int flag = 0;

        // 커넥션
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            log.info("conn successed...");

            String sql = "UPDATE board SET title=?, content=?, writer=?, wdate=sysdate WHERE num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, vo.getTitle());
            pstmt.setString(2, vo.getContent());
            pstmt.setString(3, vo.getWriter());
            pstmt.setInt(5, vo.getNum());

            flag = pstmt.executeUpdate(); // DML 데이터 변경 목적의 함수 insert, update, delete 문에서 사용
            System.out.println("flag : " + flag);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return flag;
	}

	@Override
	public int delete(BoardVO vo) {
		log.info("delete()...");
		log.info("{}", vo);
		int flag = 0;

        // 커넥션
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            log.info("conn successed...");

            String sql = "DELETE FROM board WHERE num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, vo.getNum());

            flag = pstmt.executeUpdate(); // DML 데이터 변경 목적의 함수 insert, update, delete 문에서 사용
            System.out.println("flag : " + flag);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return flag;
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		log.info("selectOne()...");
		log.info("{}", vo);

		BoardVO vo2 = null;

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            log.info("conn successed...");

            String sql = "select * from board where num=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,vo.getNum());
            rs = pstmt.executeQuery();
            while(rs.next()){
                vo2 = new BoardVO();
                vo2.setNum(rs.getInt("num"));
                vo2.setTitle(rs.getString("title"));
                vo2.setContent(rs.getString("content"));
                vo2.setWriter(rs.getString("writer"));
                vo2.setWdate(Timestamp.valueOf(new Timestamp(rs.getDate("wdate").getTime()).toString()));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return vo2;
	}

	@Override
	public List<BoardVO> selectAll() {
		log.info("selectAll()...");

		List<BoardVO> list = new ArrayList<BoardVO>();

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            log.info("conn successed...");

            String sql = "select * from board order by num desc";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                BoardVO vo = new BoardVO();
                vo.setNum(rs.getInt("num"));
                vo.setTitle(rs.getString("title"));
                vo.setContent(rs.getString("content"));
                vo.setWriter(rs.getString("writer"));
                vo.setWdate(Timestamp.valueOf(new Timestamp(rs.getDate("wdate").getTime()).toString()));
                list.add(vo);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
	}

	@Override
	public List<BoardVO> searchList(String searchKey, String searchWord) {
		log.info("searchList()...");
		log.info("searchKey:{}", searchKey);
		log.info("searchWord:{}", searchWord);
		List<BoardVO> list = new ArrayList<BoardVO>();

        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
            log.info("conn successed...");

            String sql = "";
            if(searchKey.equals("title")){
                sql = "select * from board where title like ? order by num desc";
            }else if(searchKey.equals("content")){
                sql = "select * from board where content like ? order by num desc";
            }

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"%"+searchWord+"%");


            rs = pstmt.executeQuery();
            while(rs.next()){
                BoardVO vo = new BoardVO();
                vo.setNum(rs.getInt("num"));
                vo.setTitle(rs.getString("title"));
                vo.setContent(rs.getString("content"));
                vo.setWriter(rs.getString("writer"));
                vo.setWdate(Timestamp.valueOf(new Timestamp(rs.getDate("wdate").getTime()).toString()));
                list.add(vo);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
	}

}
