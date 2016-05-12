package beans;

import java.io.Serializable;
import java.util.Date;

public class BookingBean implements Serializable{
	private int bookingId;
	private Date checkin;
	private Date checkout;
	private int userId;
	private String roomType;
	private Date bookingDate;
	
	//Getters
	public Date getBookingDate() {
		return bookingDate;
	}
	public String getRoomType() {
		return roomType;
	}
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
	public boolean isExtraBed() {
		return extraBed;
	}
	//Setters
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
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
	public void setExtraBed(boolean extraBed) {
		this.extraBed = extraBed;
	}
	
}
