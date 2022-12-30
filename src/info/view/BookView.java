package info.view;

import java.util.ArrayList;

import info.vo.BookVO;

public class BookView {
	
	public void view(ArrayList<BookVO> bvoList) {
		for (BookVO BookVO : bvoList) {
			System.out.println("----------------------------------");
			System.out.println("== 도서번호 : "+BookVO.getIsbn());
			System.out.println("== 도서명 : "+BookVO.getBookName());
			System.out.println("== 출판사 : "+BookVO.getPublish());
			System.out.println("== 저자명 : "+BookVO.getAuthor());
			System.out.println("== 도서가격 : "+BookVO.getPrice());
			System.out.println("== 도서종류 : "+BookVO.getCategory());
			System.out.println("----------------------------------");
		}
	}

}
