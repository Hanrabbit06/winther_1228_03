package info.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import info.view.BookView2;
import info.vo.BookDAO;
import info.vo.BookVO;

public class BookController2  extends JFrame{
	BookDAO dao;
	ArrayList<BookVO> bookList;
	BookView2 view2;
	
	
	public BookController2() {
		dao = new BookDAO();
		view2 = new BookView2();
		bookList = dao.select();
		view2.setBookList(bookList);
		view2.initView();
		JButton btnAdd = view2.getBtnAdd();
		btnAdd.addActionListener(btnAddL);
		add(view2,"Center");
		setTitle("도서관리 프로그램");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(200, 200);
		setSize(600, 500);
		setVisible(true);
	}
	

	public static void main (String[] args) {
		new BookController2();
	}
	
	ActionListener btnAddL = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			BookVO vo = view2.neededInsertData();
			dao.insert(vo);
			bookList = dao.select();
			view2.setBookList(bookList);
			view2.putResult();
			view2.initInsertData();
		}
	};
}
