package test.com.board.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardVO {
	
	private int num;
	private String title;
	private String content;
	private String writer;
	private Timestamp wdate;

}
