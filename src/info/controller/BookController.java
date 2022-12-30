package info.controller;

import java.util.ArrayList;
import java.util.Scanner;

import info.view.BookView;
import info.vo.BookDAO;
import info.vo.BookVO;

public class BookController {
	private static final int CONTINUE = 1;
	private static final int BREAK = 0;
	
	ArrayList<Integer> isbn = new ArrayList<Integer>();
	ArrayList<String> bookName = new ArrayList<String>();
	ArrayList<String> publish = new ArrayList<String>();
	ArrayList<String> author = new ArrayList<String>();
	ArrayList<Integer> price = new ArrayList<Integer>();
	ArrayList<String> category = new ArrayList<String>();
	
	public void inputconsol() {
		Scanner b1 = new Scanner(System.in);
		Scanner b2 = new Scanner(System.in);
		
		int flag = CONTINUE;
		System.out.println("===============\t도서정보 입력\t===============");
		while(true) {
			if(flag == CONTINUE) {
				System.out.print("==도서번호 입력 : ");
				isbn.add(b2.nextInt());
				System.out.print("==도서명 입력 : ");
				bookName.add(b1.nextLine());
				System.out.print("==출판사 입력 : ");
				publish.add(b1.nextLine());
				System.out.print("==저자명 입력 : ");
				author.add(b1.nextLine());
				System.out.print("==가격 입력 : ");
				price.add(b2.nextInt());
				System.out.print("==도서종류 입력 : ");
				category.add(b1.nextLine());
			}else if(flag == BREAK) {
				break;
			}
			System.out.print("계속 입력받으시겠습니까?(계속: 1, 종료: 0) : ");
			flag = b2.nextInt();
		}
		
		b1.close();
		b2.close();
	}
	public void voToDAO(BookDAO bDao) {
		for(int i = 0; i< isbn.size(); i++) {
			BookVO bvo = new BookVO(isbn.get(i), bookName.get(i), publish.get(i), author.get(i), price.get(i), category.get(i));
			bDao.insert(bvo);
		}
	}
	public static void main(String[] args) {
		BookController controller = new BookController();
		controller.inputconsol();
		BookDAO bDao = new BookDAO();
		controller.voToDAO(bDao);
		BookView bView = new BookView();
		bView.view(bDao.select());
	}

}
