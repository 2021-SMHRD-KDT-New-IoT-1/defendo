package SensorsController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class impact_sensorDAO {
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;


	private void conn() {

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_a_3_1215";
			String db_pw = "smhrd3";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void getImpactSensor(int hm_impact_sensor, String hm_id ) {
		
		
		conn();

		String sql = "update tbl_helmet set hm_impact_sensor =? where hm_id = ?";
		
		int result = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, hm_impact_sensor);
			psmt.setString(2, hm_id);
			System.out.println("psmt 준비완료");
			result = psmt.executeUpdate();
			System.out.println("update 실행");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		
		
		
		
	}
	
	

}
