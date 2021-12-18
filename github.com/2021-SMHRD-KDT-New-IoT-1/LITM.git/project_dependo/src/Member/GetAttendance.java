package Member;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GetAttendance")
public class GetAttendance extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM:dd-hh:mm:ss");
		System.out.println(sdf1.format(cal));
	
		String hm_id = request.getParameter("hm_id");
		int GetAttendance = Integer.parseInt(request.getParameter("GetAttendance"));
		int count1 =0;
		int count2 =0;
		
		if(GetAttendance==1 && count1==0) {
			// db ÀÎ½äÆ®??
			// insert hm_id / sysdata
			count1++;
			
		}else if(GetAttendance==0 && count2==0) {
			// db ¾÷µ«??
			// update hm_id / sysdata
			count2++;
			
		}
		
		
	}

}
