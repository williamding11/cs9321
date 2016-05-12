package hotel.chain;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserBean;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/CheckoutServlet")
//Handles availability checking and checkout
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String checkin;
	private String checkout;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public enum RoomType{
		Single,
    	Twin,
    	Queen,
    	Executive,
    	Suite
    };
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		UserBean u = (UserBean) request.getSession().getAttribute("userBean");
		boolean bookingOpen = true;
		//Book Rooms
		try {
			Connection conn = DatabaseTool.getConnection();
			//for each userbookingorder
			//sum up number of each roomtype
			
			//for each roomtype:
			for(RoomType rt:RoomType.values()){
				int userBookingCount = 0;
				int totalBookingCount = 0;
				int totalRooms = 0;
				//count user bookings for this roomtype
				PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) as numRooms from bookingorderss where roomType = ? AND uid = ? ;");
				ps.setString(1, rt.toString());
				ps.setInt(2, u.getId());
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					userBookingCount = rs.getInt("numRooms");
				}
				//count all bookings for this roomtype
				ps = conn.prepareStatement("SELECT COUNT(*) as numRooms from bookins where roomType = ?;");
				rs = ps.executeQuery();
				if(rs.next()){
					totalBookingCount = rs.getInt("numRooms");
				}
				//count number of rooms
				ps = conn.prepareStatement("SELECT COUNT(*) as numRooms from rooms where roomType = ?;");
				rs = ps.executeQuery();
				if(rs.next()){
					totalRooms = rs.getInt("numRooms");
				}
				//if there aren't enough rooms notify and send back
				if(userBookingCount+totalBookingCount > totalRooms){
					bookingOpen = false;
					break;
				}
			}
			if(bookingOpen){
				for(RoomType rt:RoomType.values()){
					
				}
			}
			//select COUNT(*) from bookings where this.start >= checkout AND this.end <= checkin AND roomtype = this.roomtype
			//booked
			
			//select count(*) from rooms where roomtype = this.roomtype
			//avail
			//if bookingORder+booked <= avail
			PreparedStatement ps = conn.prepareStatement("INSERT INTO bookings(`checkin`,`checkout`,`uid`,`rid`,`extraBed`)VALUES(?,?,?,?,?);");
			ps.setString(1, checkin);
			ps.setString(2, checkout);
			//Change this to current user based on session
			ps.setInt(3, 1);
			//Change this to selected room number
			ps.setInt(4, 1);
			ps.setBoolean(5, false);
			ps.executeUpdate();
			DatabaseTool.endConnection(conn);
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
