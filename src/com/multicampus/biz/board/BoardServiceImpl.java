package com.multicampus.biz.board;

import java.util.List;

public class BoardServiceImpl implements BoardService {
	private BoardDAO boardDAO;
	
	public BoardServiceImpl() {
		System.out.println("===>BoardService °´Ã¼ »ý¼º");
	}

	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}

}
