package 자바DB연결;

import java.util.Scanner;

public class 회원탈퇴 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("탈퇴할 아이디를 입력하세요.");

		String id = sc.next();

		MemberDAO2 dao = new MemberDAO2();
		dao.delete(id);
	}

}
