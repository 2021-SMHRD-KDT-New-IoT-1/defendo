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
		boolean check;

	 
	    public void DBcon() {
	         try {
	        	 
	        	 
	        	 
	 			Class.forName("oracle.jdbc.driver.OracleDriver");
				String db_url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
				String db_id = "campus_a_3_1215";
				String db_pw = "smhrd3";
				con = DriverManager.getConnection(db_url, db_id, db_pw);


	            
	
	            
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
		
		
		public int Join(String id, String password, String name, String tel,String dept, String check_manager) {
		
			
			try {
			
			
			DBcon();

			// 4. SQL�� �غ�
			String sql = "insert into tbl_worker(worker_id, worker_pw, worker_name, worker_phone,worker_dept, ADMIN_YESNO) values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setString(4, tel);		
			pstmt.setString(5, dept);
			pstmt.setString(6, check_manager);
			
			cnt = pstmt.executeUpdate();
		
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBclose();

			}

			return cnt;
			
			
			
		}
		
		
		public boolean idCheck(String id) {
			

			
			
			try {
				DBcon();

				String sql = "select worker_id FROM tbl_worker where worker_id=?";
				

				pstmt = con.prepareStatement(sql);

				// 4. ���ε� ���� ä���α�
				pstmt.setString(1, id);
				
				// 5. sql�� ���� �� ��� ó��
				rs = pstmt.executeQuery();
			
				if (rs.next()) {
					// �Է��� �̸����� ����� �� ������
					
					check =true;
					

				} else {
					// �Է��� �̸����� ����� �� ������
					
					check=false; 
					//�ʱⰪ�� false�� ����� �Ǵµ� ���������� ���� ���ϰ�
				}
				

			} catch (Exception e) {
				
				System.out.println("�α��ν���");
				e.printStackTrace();
				
			} finally {

				DBclose();

			}
			
			return check;
			
		
			
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

	

