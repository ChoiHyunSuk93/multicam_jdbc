package 자바DB연결;

import java.util.Scanner;

public class 게시판수정하기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("수정할 게시판 번호를 입력하세요.");
		int no = sc.nextInt();
		
		sc.nextLine();
		
		System.out.println("수정할 게시판 내용을 입력하세요.");
		String content = sc.nextLine();
		
		BbsDAO dao = new BbsDAO();
		dao.update(no, content);

	}

}
