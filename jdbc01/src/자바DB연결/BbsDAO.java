package 자바DB연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// 테이블 하나당 dao 하나!
// CUD를 완성!
public class BbsDAO {

	public void update(int no, String content) {
		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 오라클 11g에 연결해보자.(java --- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "update HR.BBS set content = ? where \"no\" = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, content);
			ps.setInt(2, no);
			// con부품으로 sql스트링에 있는 것 SQL부품으로 만들어주세요.

			// 보내기
			ps.executeUpdate(); // insert, update, delete문만! sql문 실행 결과가 int

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try-catch
	}

	public void delete(int no) {
		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 오라클 11g에 연결해보자.(java --- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);

			// 3. SQL문 작성
			String sql = "delete from HR.BBS where \"no\" = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, no);

			// 보내기
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // try-catch
	}

	public void insert(int no, String title, String content, String writer) {
		try {
			// 오라클 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 오라클 연결
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);

			// sql문 작성
			String sql = "insert into HR.BBS values (?, ?, ?, ?)";

			PreparedStatement ps = con.prepareStatement(sql);

			// R빼고, 인덱스는 0부터 시작!
			// 유일하게 db는 인덱스가 1부터 시작!

			ps.setInt(1, no);
			ps.setString(2, title);
			ps.setString(3, content);
			ps.setString(4, writer);

			// --> insert into hr.MEMBER values ('a', 'a', 'a', 'a');

			// 보내기
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} // try-catch
	}
}
