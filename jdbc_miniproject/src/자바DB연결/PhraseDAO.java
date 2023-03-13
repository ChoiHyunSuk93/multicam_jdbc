package 자바DB연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import 화면DB연결.PhraseVO;

public class PhraseDAO {

	public int insert(PhraseVO bag) {
		int result = 0;
		try {
			// 오라클 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 오라클 연결
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);

			// sql문 작성
			String sql = "insert into HR.PHRASE_BBS values (?, ?, ?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(sql);

			// R빼고, 인덱스는 0부터 시작!
			// 유일하게 db는 인덱스가 1부터 시작!

			// 2. 가방에서 값들을 하나씩 꺼내쓰기
			ps.setInt(1, bag.getNo());
			ps.setString(2, bag.getId());
			ps.setString(3, bag.getTitle());
			ps.setInt(4, bag.getBook());
			ps.setString(5, bag.getContent());
			// 보내기
			result = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		} // try-catch
		return result;
	} // insert

	public int update(PhraseVO bag) {
		int result = 0;
		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 오라클 11g에 연결해보자.(java --- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "update HR.PHRASE_BBS set ID = ?, TITLE = ?, BOOK = ?, CONTENT = ? where NO = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bag.getId());
			ps.setString(2, bag.getTitle());
			ps.setInt(3, bag.getBook());
			ps.setString(4, bag.getContent());
			ps.setInt(5, bag.getNo());
			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요.

			// 보내기
			result = ps.executeUpdate(); // insert, update, delete문만! sql문 실행 결과가 int
			ps.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try-catch
		return result;

	} // update

	public int delete(PhraseVO bag) {
		int result = 0;
		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 오라클 11g에 연결해보자.(java --- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "delete from HR.PHRASE_BBS where NO = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, bag.getNo());

			// 보내기
			result = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try-catch
		return result;
	}

	public PhraseVO one(int no) {
		ResultSet rs = null; // 항목명 + 결과 데이터를 담고 있는 테이블
		PhraseVO bag = null;
		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 오라클 11g에 연결해보자.(java --- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "select * from HR.PHRASE_BBS where NO = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, no);

			// 보내기
			rs = ps.executeQuery(); // select할 때는 executeQuery();
			if (rs.next()) { // 검색결과 있는지 여부는 rs.next()
				int no2 = rs.getInt(1);
				String id = rs.getString(2);
				String title = rs.getString(3);
				int book = rs.getInt(4);
				String content = rs.getString(5);
				// 검색결과를 검색화면 UI부분에 주어야 함.
				bag = new PhraseVO();
				bag.setNo(no2);
				bag.setId(id);
				bag.setTitle(title);
				bag.setBook(book);
				bag.setContent(content);
			}
			ps.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try-catch
		return bag;
	}
	
	public ArrayList<PhraseVO> list() {
		ResultSet rs = null; // 항목명 + 결과 데이터를 담고 있는 테이블
		PhraseVO bag = null;
		ArrayList<PhraseVO> list = new ArrayList<>();
		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 오라클 11g에 연결해보자.(java --- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "select * from HR.PHRASE_BBS order by NO desc";
			PreparedStatement ps = con.prepareStatement(sql);

			// 보내기
			rs = ps.executeQuery(); // select할 때는 executeQuery();
			while (rs.next()) { // 검색결과 있는지 여부는 rs.next()
				int no = rs.getInt(1);
				String id = rs.getString(2);
				String title = rs.getString(3);
				int book = rs.getInt(4);
				String content = rs.getString(5);
				// 검색결과를 검색화면 UI부분에 주어야 함.
				bag = new PhraseVO();
				bag.setNo(no);
				bag.setId(id);
				bag.setTitle(title);
				bag.setBook(book);
				bag.setContent(content);
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
	
	public ArrayList<PhraseVO> list2(String input) {
		ResultSet rs = null; // 항목명 + 결과 데이터를 담고 있는 테이블
		PhraseVO bag = null;
		ArrayList<PhraseVO> list = new ArrayList<>();
		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 오라클 11g에 연결해보자.(java --- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "select * from HR.PHRASE_BBS where ID = ? order by NO desc";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, input);

			// 보내기
			rs = ps.executeQuery(); // select할 때는 executeQuery();
			while (rs.next()) { // 검색결과 있는지 여부는 rs.next()
				int no = rs.getInt(1);
				String id = rs.getString(2);
				String title = rs.getString(3);
				int book = rs.getInt(4);
				String content = rs.getString(5);
				// 검색결과를 검색화면 UI부분에 주어야 함.
				bag = new PhraseVO();
				bag.setNo(no);
				bag.setId(id);
				bag.setTitle(title);
				bag.setBook(book);
				bag.setContent(content);
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
	
	public ArrayList<PhraseVO> list3(int input) {
		ResultSet rs = null; // 항목명 + 결과 데이터를 담고 있는 테이블
		PhraseVO bag = null;
		ArrayList<PhraseVO> list = new ArrayList<>();
		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 오라클 11g에 연결해보자.(java --- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "select * from HR.PHRASE_BBS where BOOK = ? order by NO desc";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, input);

			// 보내기
			rs = ps.executeQuery(); // select할 때는 executeQuery();
			while (rs.next()) { // 검색결과 있는지 여부는 rs.next()
				int no = rs.getInt(1);
				String id = rs.getString(2);
				String title = rs.getString(3);
				int book = rs.getInt(4);
				String content = rs.getString(5);
				// 검색결과를 검색화면 UI부분에 주어야 함.
				bag = new PhraseVO();
				bag.setNo(no);
				bag.setId(id);
				bag.setTitle(title);
				bag.setBook(book);
				bag.setContent(content);
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
}
