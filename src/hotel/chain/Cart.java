package hotel.chain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cart implements Serializable{
	int id = 0;
	int uid = 0;
	int rid = 0;
	Date checkin = null;
	Date checkout = null;
	boolean extraBed = false;
	
	public void parseResultSet(ResultSet rs) throws SQLException, ParseException{
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-mm-yyyy");
		int id = rs.getInt("id");
		Date checkin = dateformat.parse(rs.getString("checkin"));
		Date checkout = dateformat.parse(rs.getString("checkout"));
		//Is this needed if session stores uid?
		int uid = rs.getInt("uid");
		String roomType = rs.getString("roomType");
		boolean extraBed = rs.getBoolean("extraBed");
		Date bookingDate = dateformat.parse(rs.getString("bookingDate"));
	}
}
