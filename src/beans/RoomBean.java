package beans;

import java.io.Serializable;

public class RoomBean implements Serializable{
	private int roomId;
	private int roomPrice;
	private int hotelId;
	//0 Single
	//1 Twin
	//2 Queen
	//3 Executive
	//4 Suite
	private int roomType;
	
	
	public int getRoomId() {
		return roomId;
	}
	public int getRoomPrice() {
		return roomPrice;
	}
	public int getHotelId() {
		return hotelId;
	}
	public int getRoomType() {
		return roomType;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}
	
	
}
