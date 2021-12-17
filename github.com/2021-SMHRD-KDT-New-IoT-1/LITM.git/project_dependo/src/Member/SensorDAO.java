package Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SensorDAO {
	
	

    Connection con;
    PreparedStatement pstmt;
    ResultSet rs;
    int cnt;
    GPSVO gpsvo = null;
    ArrayList<GPSVO> gpsal =null;
 
    public void DBcon() {
         try {
        	 
        	 
        	 
 			Class.forName("oracle.jdbc.driver.OracleDriver");
			String db_url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_a_3_1215";
			String db_pw = "smhrd3";
			con = DriverManager.getConnection(db_url, db_id, db_pw);


            

            
            if( con != null ) {
                System.out.println("DB 접속 성공");
            }
            
        } catch (ClassNotFoundException e) { 
            System.out.println("드라이버 로드 실패");
        } catch (SQLException e) {
            System.out.println("DB 접속 실패");
            e.printStackTrace();
        }
    }
    
   
	public void DBclose() {

		try {
			if (rs != null) {
				rs.close();
			}

			if (pstmt != null) {
				pstmt.close();

			}
			if (con != null) {
				con.close();
			}

		} catch (Exception e2) {
			e2.printStackTrace();
		}

	}
	
	
	public ArrayList<GPSVO> Gps() {
		
		gpsal = new ArrayList<GPSVO>();
		
		try {
		
			
			
		DBcon();
		
		
		// 4. SQL문 준비
		String sql = "select hm_id,latitude,longitude from tbl_helmet";
		

		pstmt = con.prepareStatement(sql);

		rs = pstmt.executeQuery();
		
		
		while (rs.next()) {

			String hm_id = rs.getString("hm_id");
			float latitude = rs.getFloat("latitude");
			float longitude = rs.getFloat("longitude");

			gpsvo = new GPSVO(latitude, longitude, hm_id);
           
			gpsal.add(gpsvo);

		}
		
		
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBclose();

		}

		return gpsal;
		
		
		
	}
	
	

	
	

}
