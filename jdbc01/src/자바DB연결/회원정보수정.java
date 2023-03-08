package 자바DB연결;

import java.util.Scanner;

public class 회원정보수정 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("정보를 수정할 아이디를 입력하세요.");
		String id = sc.next();

		System.out.println("수정할 전화번호를 입력하세요.");
		String tel = sc.next();

		MemberDAO2 dao = new MemberDAO2();
		dao.update(id, tel);

	}

}
