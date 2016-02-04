package com.multicampus.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

//테스트용 클라이언트
public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다.
		ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 컨테이너를 구동하는 순간 프리로딩을 수행

		// 2. Spring 컨테이너로부터 BoardService 타입의 객체를 Lookup 한다.
		BoardService boardService = (BoardService) container.getBean("boardService");

		// 3. Lookup 된 객체의 메소드 테스트
		BoardVO vo = new BoardVO();
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		System.out.println("<< 게시글 목록 >>");
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
		// 1. 세터 구현
		// 그냥 구현 시 널 포인트익셉션 뜸, 세터 인젝션으로 널포인트 익셉션 안나게 수정
		// 책 156p참조 시 구현됨
		// <bean id="boardService"
		// class="com.multicampus.biz.board.BoardServiceImpl">
		// <property name="boardDAO" ref="boardDAO"/>
		// </bean>
		// <bean id="boardDAO"
		// class="com.multicampus.biz.board.BoardDAO"></bean>

		// 2. 어노테이션 구현
		// @Component
		// public class BoardDAO{
		//
		// @Component("boardService")  //이 아이디가 중요함!
		// public class BoardServiceImpl implements BoardService {
		// @Autowired //이걸 붙여야 boardDAO를 참조하는 것!
		// private BoardDAO boardDAO;
		
		//이땐 세터 인젝션 필요없으니 세터 메서드는 빼도 됨!

	}
}
