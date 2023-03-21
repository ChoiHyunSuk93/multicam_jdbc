package multi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// 테이블 하나당 dao 하나!
// CUD를 완성!
public class MovieDAO {

	public ArrayList<MovieVO> list() {
		ResultSet rs = null; // 항목명 + 결과 데이터를 담고 있는 테이블

		ArrayList<MovieVO> list = new ArrayList<>();

		MovieVO bag = null;
		try {
			// mySql 연결할 부품 설정
			Class.forName("com.mysql.cj.jdbc.Driver");

			// mySql 연결
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "select id, title, director from movie";
			PreparedStatement ps = con.prepareStatement(sql);

			// 보내기
			rs = ps.executeQuery(); // select할 때는 executeQuery();
			// 1. 검색결과가 있으면 while문으로 반복해서 실행.
			while (rs.next()) { // 검색결과 있는지 여부는 rs.next()
				bag = new MovieVO();
				bag.setId(rs.getString("id"));
				bag.setTitle(rs.getString("title"));
				bag.setDirector(rs.getString("director"));
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
	
	public MovieVO one(String id) {
		ResultSet rs = null; // 항목명 + 결과 데이터를 담고 있는 테이블
		MovieVO bag = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// mySql 연결
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "select * from movie where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, id);

			// 보내기
			rs = ps.executeQuery(); // select할 때는 executeQuery();
			if (rs.next()) { // 검색결과 있는지 여부는 rs.next()
				// true -> 검색결과 O, false -> 검색결과 X
				bag = new MovieVO();
				bag.setId(rs.getString("id"));
				bag.setTitle(rs.getString("title"));
				bag.setContent(rs.getString("content"));
				bag.setLocation(rs.getString("location"));
				bag.setDirector(rs.getString("director"));
			} else {
				System.out.println("검색결과 없음.");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try-catch
		return bag;
	}

	public int update(MovieVO bag) {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// mySql 연결
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "update movie set content = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getContent());
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

	public int delete(MovieVO bag) {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// mySql 연결
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "delete from movie where id = ?";
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

	public int insert(MovieVO bag) {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// mySql 연결
			String url = "jdbc:mysql://localhost:3306/multi?serverTimezone=UTC";
			String user = "root";
			String password = "1234";
			Connection con = DriverManager.getConnection(url, user, password);

			// sql문 작성
			String sql = "insert into movie values (?, ?, ?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(sql);

			// R빼고, 인덱스는 0부터 시작!
			// 유일하게 db는 인덱스가 1부터 시작!

			ps.setString(1, bag.getId());
			ps.setString(2, bag.getTitle());
			ps.setString(3, bag.getContent());
			ps.setString(4, bag.getLocation());
			ps.setString(5, bag.getDirector());

			// 보내기
			result = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} // try-catch
		return result;
	}
}
