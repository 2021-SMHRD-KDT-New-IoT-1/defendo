package SensorsController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;



@WebServlet("/GetSensor")
public class GetSensor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String hm_id = request.getParameter("hm_id");
		int hm_impact_sensor = Integer.parseInt(request.getParameter("impact_sensor"));
		int gas_sensor = Integer.parseInt(request.getParameter("gas_sensor"));
		float latitude = Float.parseFloat(request.getParameter("latitude"));
		float longitude = Float.parseFloat(request.getParameter("longitude"));
				
		System.out.println("hm_id : "+hm_id);
		System.out.println("hm_impact_sensor : "+hm_impact_sensor);
		System.out.println("gas_sensor : "+gas_sensor);
		System.out.println("latitude : "+latitude);
		System.out.println("longitude : "+longitude);
					
		SensorDAO dao = new SensorDAO();
		SensorVO vo = dao.getSensor();
		String result = new Gson().toJson(vo);
		PrintWriter out = response.getWriter();
		out.print(result);
		System.out.println(result);
	
		
		
	}

}
