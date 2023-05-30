/**
 * 
 */
package design.lld.HMS;

import java.util.Date;
import java.util.List;

/**
 * @author 91978
 *
 */
public class HotelManagementSystemLLDExmaple {

	/**
	 * 
	 */
	public HotelManagementSystemLLDExmaple() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Hotel{
	
	int hotelId;
	String name;
	Location hotelLocation;
	List<Room> rooms;
	
}

class Location{
	
	int pin;
	String country;
	String street;
	String city;
	String state;
	
}

class Room{
	
	String roomNumber;
	RoomStyle roomStyle;
	RoomStatus roomStatus;
	List<RoomKey> roomKeys;
	Double bookingPrice;
	List<HouseKeepingLog> houseKeepingLogs;

}

enum RoomStyle{
	
	STANDARD, DELUXE, FAMILY_SUITE;
	
}

enum RoomStatus{
	
	AVAILABLE, NOT_AVAILABLE, OOCUPIED, BOOKED, SERVICE_IN_PROGRESS 
	
}

class RoomKey{
	
	int keyId;
	String barCode;
	Boolean isActive;
	Boolean isMaster;
	Date issuedAt;
	
	public void assignRoom(Room room) {}
}

class HouseKeepingLog{
	
	String description;
	Date start;
	int duration;
	HouseKeeper houseKeeper;
	
	public void addRoom(Room room) {}
	
}

abstract class Person{
	
	String name;
	Account account;
	
}

class Account{
	
	String username;
	String password;
	
	AccountSatus accountStatus;
	
}

enum AccountSatus{
	
	ACTIVE, BLOCKED, CLOSED;
	
}

class Guest extends Person{
	
	Search serchObj;
	Booking bookingObj;
	
	public List<RoomBooking> getAllBooings(){return null;}
	
}

class Receptionist extends Person{
	
	Search serchObj;
	Booking bookingObj;
	
	public Boolean checkInGuest(Guest guestInfo, RoomBooking roomBookingInfo) {return null;}
	public Boolean checkOutGuest(Guest guestInfo, RoomBooking roomBookingInfo) {return null;}
	
	
}

class Admin extends Person{
	
	public void addRoom(Room roomDetail) {}
	public Room deleteRoom(int roomId) {return null;}
	public void editRoom(Room roomDetail) {}
	
}

class HouseKeeper extends Person{
	
	public List<Room> getServicedRooms(Date date){return null;}
	
}

class Search{
	
	public List<Room> searchRoom(RoomStyle roomStyle, Date start, int durationDays){return null;}
	
}

class Booking{
	
	public RoomBooking createBooking(Date start, int duration) { return null;}
	public RoomBooking cancelBooking(int bookingId) {return null;}
	
}

class RoomBooking{
	
	int bookingId;
	Person person;
	Date startDate;
	int durationDays;
	List<Guest> guestList;
	List<Room> rooms;
	BookingStatus bookingStatus;
	BaseRoomCharge totalRoomCharges;
	
}

enum BookingStatus{
	
	BOOKED, CANCELLED;
}


interface BaseRoomCharge{
	
	double cost();
	
}

class RoomCharge implements BaseRoomCharge{

	double roomCost;
	
	@Override
	public double cost() {
		
		return this.roomCost;
		
	}
	
	
}


class RoomServiceCharge implements BaseRoomCharge{

	double roomCost;
	
	BaseRoomCharge base;
	
	public RoomServiceCharge(BaseRoomCharge base) {
		
		this.base = base;
		
	}
	
	@Override
	public double cost() {
		return base.cost()+roomCost;
	}
	
	
	
}

class InRoomPurchaseServiceCharge implements BaseRoomCharge{

	double roomCost;
	
	BaseRoomCharge base;
	
	public InRoomPurchaseServiceCharge(BaseRoomCharge base) {
		
		this.base = base;
		
	}
	
	@Override
	public double cost() {
		return base.cost()+roomCost;
	}
	
	
	
}