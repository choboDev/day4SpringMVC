package com.multicampus.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.multicampus.biz.common.JDBCUtil;

// DAO(Data Access Object)
@Component
public class BoardDAO{
	
	// JDBC 관련 변수 선언
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	// SQL 명령어들 선언
	private String BOARD_INSERT = "insert into board(seq, title, writer, content) " + 
                                  "values ((select nvl(max(seq), 0) + 1 from board), ?, ?, ?)";
	private String BOARD_UPDATE = "update board set title=?, content=? where seq=?";
	private String BOARD_DELETE = "delete board where seq=?";
	private String BOARD_GET    = "select * from board where seq=?";
	private String BOARD_LIST_T = "select * from board where title like '%'||?||'%' order by seq desc";
	private String BOARD_LIST_C = "select * from board where content like '%'||?||'%' order by seq desc";
	
	public BoardDAO() {
		System.out.println("===>Board 객체 생성");
	}

	// CRUD 기능의 메소드 구현
	// 글 등록
	/* (non-Javadoc)
	 * @see com.multicampus.biz.board.BoardService#insertBoard(com.multicampus.biz.board.BoardVO)
	 */
	public void insertBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 글 수정
	/* (non-Javadoc)
	 * @see com.multicampus.biz.board.BoardService#updateBoard(com.multicampus.biz.board.BoardVO)
	 */
	public void updateBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2, vo.getContent());
			stmt.setInt(3, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 글 삭제
	/* (non-Javadoc)
	 * @see com.multicampus.biz.board.BoardService#deleteBoard(com.multicampus.biz.board.BoardVO)
	 */
	public void deleteBoard(BoardVO vo) {
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 글 상세 조회
	/* (non-Javadoc)
	 * @see com.multicampus.biz.board.BoardService#getBoard(com.multicampus.biz.board.BoardVO)
	 */
	public BoardVO getBoard(BoardVO vo) {
		BoardVO board = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, vo.getSeq());
			rs = stmt.executeQuery();			
			
			if(rs.next()) {
				board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return board;
	}
	
	// 글 목록 검색
	/* (non-Javadoc)
	 * @see com.multicampus.biz.board.BoardService#getBoardList(com.multicampus.biz.board.BoardVO)
	 */
	public List<BoardVO> getBoardList(BoardVO vo) {
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			conn = JDBCUtil.getConnection();
			if(vo.getSearchCondition().equals("TITLE")) {
				stmt = conn.prepareStatement(BOARD_LIST_T);
			} else if(vo.getSearchCondition().equals("CONTENT")) {
				stmt = conn.prepareStatement(BOARD_LIST_C);
			}
			stmt.setString(1, vo.getSearchKeyword());
			rs = stmt.executeQuery();			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				board.setSeq(rs.getInt("SEQ"));
				board.setTitle(rs.getString("TITLE"));
				board.setWriter(rs.getString("WRITER"));
				board.setContent(rs.getString("CONTENT"));
				board.setRegDate(rs.getDate("REGDATE"));
				board.setCnt(rs.getInt("CNT"));
				boardList.add(board);
			}			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return boardList;
	}
}










