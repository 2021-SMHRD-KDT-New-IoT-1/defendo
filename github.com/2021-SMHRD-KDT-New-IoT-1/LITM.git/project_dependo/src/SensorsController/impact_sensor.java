package SensorsController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/impact_sensor")
public class impact_sensor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int impact_sensor = Integer.parseInt(request.getParameter("impact_sensor"));
		String hm_id = request.getParameter("hm_id");
		System.out.println("impact_sensor : "+impact_sensor);
		System.out.println("hm_id : "+hm_id);
		
		impact_sensorDAO dao = new impact_sensorDAO();
		dao.getImpactSensor(impact_sensor, hm_id);
	
		
		
		
	
		
		
		
		
	}

}
