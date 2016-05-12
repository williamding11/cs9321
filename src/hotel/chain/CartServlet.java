package hotel.chain;

import beans.BookingBean;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String checkin = request.getParameter("checkin");	
		String checkout = request.getParameter("checkout");	
		ArrayList<BookingBean> userCart = new ArrayList<BookingBean>();
		
		Connection conn = null;
		//
		//Confirm booking
		try {
			conn = DatabaseTool.getConnection();
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
