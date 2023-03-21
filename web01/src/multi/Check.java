package multi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/check.do")
public class Check extends HttpServlet {

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Check 서블릿 객체가 하나 만들어진다");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Check 서블릿 소멸됨");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String today = request.getParameter("today");
		if (today.equals("맑음")) {
			out.print("나가자");
		} else if (today.equals("흐림")) {
			out.print("코딩");
		} else if (today.equals("비옴")) {
			out.print("쇼핑");
		} else {
			out.print("그냥 있자");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String pw = request.getParameter("pass");
		String result = "들어올 수 없습니다.<img src='no.jpg'>";
		if (pw.equals("나는왕이다")) {
			result = "들어오세요.<img src='yes.jpg'>";
		}
		// setContentType은 out만들기 전에 설정!!
		out.print(result);
		out.close();
	}

}
