package beans;

import java.io.Serializable;
import java.util.Date;

public class BookingBean implements Serializable{
	private int bookingId;
	private Date checkin;
	private Date checkout;
	private int userId;
	private int roomId;
	private boolean extraBed;
	
	public int getBookingId() {
		return bookingId;
	}
	public Date getCheckin() {
		return checkin;
	}
	public Date getCheckout() {
		return checkout;
	}
	public int getUserId() {
		return userId;
	}
	public int getRoomId() {
		return roomId;
	}
	public boolean isExtraBed() {
		return extraBed;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}
	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public void setExtraBed(boolean extraBed) {
		this.extraBed = extraBed;
	}
	
}
