package com.multicampus.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

//�׽�Ʈ�� Ŭ���̾�Ʈ
public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. Spring �����̳ʸ� �����Ѵ�.
		ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");
		// �����̳ʸ� �����ϴ� ���� �����ε��� ����

		// 2. Spring �����̳ʷκ��� BoardService Ÿ���� ��ü�� Lookup �Ѵ�.
		BoardService boardService = (BoardService) container.getBean("boardService");

		// 3. Lookup �� ��ü�� �޼ҵ� �׽�Ʈ
		BoardVO vo = new BoardVO();
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardService.getBoardList(vo);
		System.out.println("<< �Խñ� ��� >>");
		for (BoardVO board : boardList) {
			System.out.println("---> " + board.toString());
		}
		// 1. ���� ����
		// �׳� ���� �� �� ����Ʈ�ͼ��� ��, ���� ���������� ������Ʈ �ͼ��� �ȳ��� ����
		// å 156p���� �� ������
		// <bean id="boardService"
		// class="com.multicampus.biz.board.BoardServiceImpl">
		// <property name="boardDAO" ref="boardDAO"/>
		// </bean>
		// <bean id="boardDAO"
		// class="com.multicampus.biz.board.BoardDAO"></bean>

		// 2. ������̼� ����
		// @Component
		// public class BoardDAO{
		//
		// @Component("boardService")  //�� ���̵� �߿���!
		// public class BoardServiceImpl implements BoardService {
		// @Autowired //�̰� �ٿ��� boardDAO�� �����ϴ� ��!
		// private BoardDAO boardDAO;
		
		//�̶� ���� ������ �ʿ������ ���� �޼���� ���� ��!

	}
}
