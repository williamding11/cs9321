package hotel.chain;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Book Rooms
		try {
			Connection conn = DatabaseTool.getConnection();
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
