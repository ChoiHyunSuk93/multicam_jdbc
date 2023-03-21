package multi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO3 {
	public ArrayList<MemberVO> list() {
		ResultSet rs = null; // 항목명 + 결과 데이터를 담고 있는 테이블

		ArrayList<MemberVO> list = new ArrayList<>();

		MemberVO bag = null;
		try {
			// mySql 연결할 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");

			// mySql 연결
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "select * from member";
			PreparedStatement ps = con.prepareStatement(sql);

			// 보내기
			rs = ps.executeQuery(); // select할 때는 executeQuery();
			// 1. 검색결과가 있으면 while문으로 반복해서 실행.
			while (rs.next()) { // 검색결과 있는지 여부는 rs.next()
				// 2. 각 컬럼에서 값들을 꺼내오기.
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String tel = rs.getString(4);
				// 3. 가방을 만들자.
				bag = new MemberVO();
				bag.setId(id);
				bag.setPw(pw);
				bag.setName(name);
				bag.setTel(tel);
				// 4. list에 bag을 추가.
				list.add(bag);
			}
			ps.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try-catch
		return list;
	}

	public MemberVO one(String id) {
		ResultSet rs = null; // 항목명 + 결과 데이터를 담고 있는 테이블
		MemberVO bag = null;
		try {
			// mySql 연결할 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");

			// mySql 연결
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "select * from member where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);

			// 보내기
			rs = ps.executeQuery(); // select할 때는 executeQuery();
			if (rs.next()) { // 검색결과 있는지 여부는 rs.next()
				// true -> 검색결과 O, false -> 검색결과 X
				System.out.println("검색결과가 있다.");
				String id2 = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String tel = rs.getString(4);
//				System.out.println(id2 + " " + pw + " " + name + " " + tel);
				// 검색결과를 검색화면 UI부분에 주어야 함.
				bag = new MemberVO();
				bag.setId(id2);
				bag.setPw(pw);
				bag.setName(name);
				bag.setTel(tel);
			} else {
				System.out.println("검색결과 없음.");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try-catch
		return bag;
	}

	public int update(MemberVO bag) {
		int result = 0;
		try {
			// mySql 연결할 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");

			// mySql 연결
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "update member set tel = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getTel());
			ps.setString(2, bag.getId());
			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요.

			// 보내기
			result = ps.executeUpdate(); // insert, update, delete문만! sql문 실행 결과가 int

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try-catch
		return result;
	}

	public int delete(MemberVO bag) {
		int result = 0;
		try {
			// mySql 연결할 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");

			// mySql 연결
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "delete from member where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getId());

			// 보내기
			result = ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try-catch
		return result;
	}

	public int insert(MemberVO bag) { // 1. 가방을 받아서 변수에 넣어주기
		int result = 0;
		try {
			// mySql 연결할 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");

			// mySql 연결
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			// sql문 작성
			String sql = "insert into member values (?, ?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(sql);

			// R빼고, 인덱스는 0부터 시작!
			// 유일하게 db는 인덱스가 1부터 시작!

			// 2. 가방에서 값들을 하나씩 꺼내쓰기
			ps.setString(1, bag.getId());
			ps.setString(2, bag.getPw());
			ps.setString(3, bag.getName());
			ps.setString(4, bag.getTel());

			// --> insert into hr.MEMBER values ('a', 'a', 'a', 'a');

			// 보내기
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} // try-catch
		return result;
	}

	public int login(MemberVO bag) {
		int result = 0;
		try {
			// mySql 연결할 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");

			// mySql 연결
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "select * from HR.MEMBER where id = ? and pw = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getId());
			ps.setString(2, bag.getPw());

			// 보내기
			ResultSet rs = ps.executeQuery(); // select할 때는 executeQuery();
			if (rs.next()) { // 검색결과 있는지 여부는 rs.next()
				// true -> 검색결과 O, false -> 검색결과 X
				result = 1;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try-catch
		return result;
	} // login

}
