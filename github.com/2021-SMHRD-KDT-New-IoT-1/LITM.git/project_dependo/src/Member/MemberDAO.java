package Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

	

	  
	    Connection con;
	    PreparedStatement pstmt;
	    ResultSet rs;
	    int cnt;
	  
	 
	    public void DBcon() {
	         try {
	        	 
	        	 
	            Class.forName("org.mariadb.jdbc.Driver");
	           
	            con = DriverManager.getConnection(
	                    "jdbc:mariadb://211.48.228.2:3306/dependo",
	                    "dependo",
	                    "1234");
	            
	            if( con != null ) {
	                System.out.println("DB ���� ����");
	            }
	            
	        } catch (ClassNotFoundException e) { 
	            System.out.println("����̹� �ε� ����");
	        } catch (SQLException e) {
	            System.out.println("DB ���� ����");
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
		
		
		public int Join(String id, String password, String name, String tel,String dept) {
		
			
			try {
			
			
			DBcon();

			// 4. SQL�� �غ�
			String sql = "insert into tbl_worker(worker_id, worker_pw, worker_name, worker_phone,worker_dept) values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setString(4, tel);		
			pstmt.setString(5, dept);
			
			cnt = pstmt.executeUpdate();
		
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBclose();

			}

			return cnt;
			
			
			
		}
		
		public void StartTime(String worker_id,String start_time,String att_type) {
			

			try {
			
			
			DBcon();

			// 4. SQL�� �غ�
			String sql = "insert into tbl_attendance(worker_id, start_time, att_type) values(?,?,?,)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, worker_id);
			pstmt.setString(2, start_time);
			pstmt.setString(3, att_type);
		
			
			cnt = pstmt.executeUpdate();
		
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBclose();

			}
	
			
		}
		
		
		public void endTime(String worker_id,String end_time,String att_type) {
			

			try {
			
			
			DBcon();

			// 4. SQL�� �غ�
			String sql = "update tbl_attendance(end_time, att_type) values(?,?) where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, end_time);
			pstmt.setString(2, att_type);
			pstmt.setString(3, worker_id);
		
			
			cnt = pstmt.executeUpdate();
		
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBclose();

			}
	
			
		}
		
		
		
	    
	    
	}

	
