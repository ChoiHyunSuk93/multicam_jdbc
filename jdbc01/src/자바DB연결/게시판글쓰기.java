package 자바DB연결;

import java.util.Scanner;

public class 게시판글쓰기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("게시판 번호를 입력하세요.");
		int no = sc.nextInt();
		
		System.out.println("게시판 제목을 입력하세요.");
		String title = sc.next();
		
		System.out.println("게시판 내용을 입력하세요.");
		String content = sc.next();
		
		System.out.println("게시판 글쓴이 아이디를 입력하세요.");
		String writer = sc.next();
		
		BbsDAO dao = new BbsDAO();
		dao.insert(no, title, content, writer);
		
		
	}

}
