package com.multiplex.dao;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import com.multiplex.beans.*;
import java.util.ArrayList;
import java.util.List;

//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpServletRequest;
 
public class BookingDAO1 {
	static Connection con;
	
	
	public List<Booking> removefrombooking(Booking b) {
		
		List<Booking> bk = new ArrayList<>(); 
		try {
	        
	        con = DBUtility.getConnection();
	        
	        if(con!=null) {
	               
	               System.out.println("Connection Established!");
	               String query3="delete from booking where bookingid = ?";
		
		
				PreparedStatement statement = con.prepareStatement(query3); 
				statement.setInt(1, b.getBookingId());
				statement.execute();
				
				String query4 = "select * from booking";
				PreparedStatement st = con.prepareStatement(query4);
				
				ResultSet rs2 = st.executeQuery();
				
				while(rs2.next()) {
					
					Booking b2 = new Booking();
					b2.setBookingId(rs2.getInt(1));
					b2.setShowId(rs2.getInt(2));
					b2.setUserId(rs2.getInt(3));
					b2.setBookedDate(rs2.getDate(4));
					b2.setShowDate(rs2.getDate(5));
					b2.setCancellation(rs2.getString(6));
					bk.add(b2);
				}
					
				}	
		
	}
		catch(Exception e) {
	        
	        e.printStackTrace();
	        System.out.println(e);
	 }
		
		return bk;
	}
	
	
	/*public void removefrombooking(int bookingid) {
	try {
        
        con = DBUtility.getConnection();
        
        if(con!=null) {
               
               System.out.println("Connection Established!");
	String query3="delete from booking where bookingid = ?";
	
	
			PreparedStatement statement = con.prepareStatement(query3); 
		statement.setInt(1, bookingid);
		 statement.executeUpdate();
	
	
}}
	catch(Exception e) {
        
        e.printStackTrace();
        System.out.println(e);
 }}*/
    //pstmt3.setString(1,p);
    
	
	
	public Booking searchBooking(Booking booking) {
        
        try {
               
               con = DBUtility.getConnection();
               
               if(con!=null) {
                      
                      System.out.println("Connection Established!");
                      
                      String query="select * from booking where BookingId = ?";
                      PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(query);
                      pstmt.setInt(1, booking.getBookingId());
                      
                      ResultSet rs1 = pstmt.executeQuery();
                      
                      while(rs1.next()) {       
                            
                            booking.setBookingId(rs1.getInt(1));
                            booking.setShowId(rs1.getInt(2));
                            booking.setUserId(rs1.getInt(3));
                            booking.setBookedDate(rs1.getDate(4));
                            booking.setShowDate(rs1.getDate(5));
                            booking.setCancellation(rs1.getString(6));
                           
                      }      
                      
               }
        
        }
        
        catch(Exception e) {
               
               e.printStackTrace();
               System.out.println(e);
        }
        
        return booking;
  }
  
  

	
	
	
	
	
	
	
	public List<Booking> getBookings() {
	       
	       List<Booking> booking = new ArrayList<>();
	       
	             try {
	                    
	                    con = DBUtility.getConnection();
	                    
	                    if(con!=null) {
	                           
	                           System.out.println("Connection Established!");
	                           
	                           String query="select * from booking ";
	                           PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(query);
	                           
	                           ResultSet rs1 = pstmt.executeQuery();
	                           
	                           while(rs1.next()) {       
	                                 
	                                 Booking b = new Booking();
	                                 b.setBookingId(rs1.getInt(1));
	                                 b.setShowId(rs1.getInt(2));
	                                 b.setUserId(rs1.getInt(3));
	                                 b.setBookedDate(rs1.getDate(4));
	                                 b.setShowDate(rs1.getDate(5));
	                                 b.setCancellation(rs1.getString(6));
	                                 booking.add(b);
	                                 
	                           }      
	                           
	                    }
	             
	             }
	             
	             catch(Exception e) {
	                    
	                    e.printStackTrace();
	                    System.out.println(e);
	             }
	             
	             return booking;
	       }

	
}
	
      /*public void display(HttpServletRequest request, HttpServletResponse response) {
    	  
       //static Connection con;
   
    //public Booking searchBooking(Booking booking) {
                try {
    				boolean flag=false;
    				Connection con = DBUtility.getConnection();
    				Statement st=con.createStatement();
    				
    				if(con!=null) {
    					
    					System.out.println("Connection Established!");
    					//Statement st = con.createStatement();
                        //String emailId1=request.getParameter("EmailId");
                        //String password1=request.getParameter("Password");
                        //String queryString = "select EmailId, Password from user ";

    					int bId = Integer.parseInt(request.getParameter("bookingId"));
    					//int showId=Integer.parseInt(request.getParameter("showId"));
    					//int userId=Integer.parseInt(request.getParameter("userId"));
    					//date bookedDate=Date.parse(request.getParameter("bookedDate"));
    					//date showDate=Date.parse(request.getParameter("showDate"));
    					//String cancellation=request.getParameter("cancellation");
    					String query="select * from booking where BookingId = ?";
    					ResultSet results = st.executeQuery(query);
    		               while (results.next()) {
    		                     int bId1 = results.getInt("BookingId");
    		                     //String password2 =  results.getString("Password");
    		                     if (bId==bId1)  {
    		                           flag = true;  
    		                     } 
    		               }
    		               if(!flag){
    		                      JOptionPane.showMessageDialog(null, "Please Enter valid booking Id ");
    		                      RequestDispatcher rd=request.getRequestDispatcher("displayBooking.jsp");  
    		                      rd.forward(request, response);
    		               }
    		               results.close();
    		            st.close();
    		            con.close();
    		            //PrintWriter out = response.getWriter();
    		            //if(flag) {
    		            	
    		            //println("<html}
    		            //out.println("<html><body><b>Login Successful" + "</b></body></html>");
    		           // }else {
    		            //out.><body><b>display Failed" + "</b></body></html>");
    		            }
    		             }
    		             catch (Exception e) {
    		            e.printStackTrace();
    		        }
    		       }
    		}


    					/*PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(query);
    					pstmt.setInt(1, booking.getBookingId());
    					
    					ResultSet rs1 = pstmt.executeQuery();
    					
    					while(rs1.next()) {		
    						
    						booking.setBookingId(rs1.getInt(1));
    						booking.setShowId(rs1.getInt(2));
    						booking.setUserId(rs1.getInt(3));
    						booking.setBookedDate(rs1.getDate(4));
    						booking.setShowDate(rs1.getDate(5));
    						booking.setCancellation(rs1.getString(6));
    						
    					}	
    					
    				}
    			
    			}
    			
    			catch(Exception e) {
    				
    				e.printStackTrace();
    				System.out.println(e);
    			}
    			
    			return booking;
    		}
		
    		
    		public List<Booking> searchBooking() {
    		
    		List<Booking> bookings = new ArrayList<>();
    		
    		
    		
    			
    			try {
    				
    				con = DBUtility.getConnection();
    				
    				if(con!=null) {
    					
    					System.out.println("Connection Established!");
    					
    					String query="select * from booking";
    					PreparedStatement pstmt=(PreparedStatement) con.prepareStatement(query);
    					
    					ResultSet rs1 = pstmt.executeQuery();
    					
    					while(rs1.next()) {		
    						
    						Booking b = new Booking();
    						b.setBookingId(rs1.getInt(1));
    						b.setShowId(rs1.getInt(2));
    						b.setUserId(rs1.getInt(3));
    						b.setBookedDate(rs1.getDate(4));
    						b.setShowDate(rs1.getDate(5));
    						b.setCancellation(rs1.getString(6));
    						
    						bookings.add(b);
    						
    					}	
    					
    				}
    			
    			}
    			
    			catch(Exception e) {
    				
    				e.printStackTrace();
    				System.out.println(e);
    			}
    			
    			return bookings;
    		}
    	}*/
