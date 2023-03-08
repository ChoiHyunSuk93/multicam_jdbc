package 자바DB연결;

import java.util.Scanner;

public class 화원가입2 {

	public static void main(String[] args) {

		// 입력해보자
		Scanner sc = new Scanner(System.in);
		System.out.println("id/pw/name/tel 순으로 입력하세요.");

		// 입력한 값을 스트링변수에 저장
		String id = sc.next();
		String pw = sc.next();
		String name = sc.next();
		String tel = sc.next();

		// 메서드 사용해서 db 전송
		MemberDAO2 dao = new MemberDAO2();
		dao.insert(id, pw, name, tel);
	}

}
