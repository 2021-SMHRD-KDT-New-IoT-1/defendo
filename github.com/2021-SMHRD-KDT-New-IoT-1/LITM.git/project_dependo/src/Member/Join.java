package Member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Join")
public class Join extends HttpServlet {

   private static final long serialVersionUID = 1L;


   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	   request.setCharacterEncoding("euc-kr");
      

      String id = request.getParameter("id");
      String password = request.getParameter("password");
      
      String name = request.getParameter("name");
      String tel = request.getParameter("tel");
      String dept = request.getParameter("dept");
      String check_manager = request.getParameter("check_manager");
      
      System.out.println(id+"/"+password+"/"+tel+"/"+dept+"/"+check_manager);

      
      MemberDAO dao= new MemberDAO();
      
      int cnt = dao.Join(id, password, name, tel, dept, check_manager);
      
      System.out.println(cnt);
      
      if(cnt > 0) {
         System.out.println("회원가입성공");
         response.sendRedirect("http://localhost:8085/project_dependo/defendo/index_before.jsp");
      }else {
         System.out.println("회원가입실패");
         response.sendRedirect("http://localhost:8085/project_dependo/defendo/index_before.jsp");
      }
      
      
      
      
   }

}
