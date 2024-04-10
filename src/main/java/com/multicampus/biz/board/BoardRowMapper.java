package com.multicampus.biz.board;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class BoardRowMapper implements RowMapper<BoardVO> {

	// mapRow()는 ResultSet에 검색 결과 수 만큼 호출된다. 
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		// System.out.println("rowNum : " + rowNum);
		// ResultSet에 있는 하나의 ROW를 BoardVO 객체에 매핑한다.
		BoardVO board = new BoardVO();
		board.setSeq(rs.getInt("SEQ"));
		board.setTitle(rs.getString("TITLE"));
		board.setWriter(rs.getString("WRITER"));
		board.setContent(rs.getString("CONTENT"));
		board.setRegDate(rs.getDate("REGDATE"));
		board.setCnt(rs.getInt("CNT"));
		return board;
	}

}
