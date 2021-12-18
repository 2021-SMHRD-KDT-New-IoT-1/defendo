package SensorsController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SensorDAO {
	
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
	
	
	public void UpdateSensor(String hm_id , int hm_impact_sensor,int gas_sensor, float latitude,float longitude ) {
		
		
		conn();

		String sql = "update tbl_helmet set hm_impact_sensor =?,HM_GAS_SENSOR=?,latitude=?,longitude=?  where hm_id = ?";
		
		int result = 0;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, hm_impact_sensor);
			psmt.setInt(2, gas_sensor);
			psmt.setFloat(3, latitude);
			psmt.setFloat(4, longitude);
			psmt.setString(5, hm_id);
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
	
	
	public SensorVO getSensor() {
		SensorVO vo = null;
		conn();
		System.out.println("디비 접속 성공  get sensor");
		String sql = "select * from tbl_helmet";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if (rs.next()) {
				int mysensor = rs.getInt(1);
				vo = new SensorVO(mysensor);
			}
			System.out.println("select 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}
	
	
	
	

}
