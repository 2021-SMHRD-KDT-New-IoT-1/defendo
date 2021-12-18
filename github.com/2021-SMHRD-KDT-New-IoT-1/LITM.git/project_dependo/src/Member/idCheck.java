package Member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/idCheck")
public class idCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	
		
		request.setCharacterEncoding("euc-kr");
		
		String id = request.getParameter("id");
		System.out.println(id);
		
		
		
		// 출력 스트림(통로)
		PrintWriter out = response.getWriter();
		
		MemberDAO dao = new MemberDAO();
		
		boolean check = dao.idCheck(id);
		
		// 통로를 통해서 응답 데이터를 출력
		out.print(check);
		
		
		
		
		
	}

}
