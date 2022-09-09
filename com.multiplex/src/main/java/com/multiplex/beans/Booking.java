package com.multiplex.beans;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.sql.Date;
import java.util.*;
public class Booking {
	private int bookingId;
	private int ShowId;
	private int UserId;
	private Date BookedDate;
	private Date ShowDate;
	private String Cancellation;
	public Booking(int bookingId, int ShowId, int UserId, Date BookedDate,Date ShowDate,String Cancellation) {
		super();
		this.bookingId = bookingId;
		this.ShowId = ShowId;
		this.UserId=UserId;
		this.BookedDate=BookedDate;
		this.ShowDate=ShowDate;
		this.Cancellation=Cancellation;
	}
	
	

	public Booking() {
		super();
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getShowId() {
		return ShowId;
	}
	public void setShowId(int showId) {
		ShowId = showId;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public Date getBookedDate() {
		return BookedDate;
	}
	public void setBookedDate(Date bookedDate) {
		BookedDate = bookedDate;
	}
	public Date getShowDate() {
		return ShowDate;
	}
	public void setShowDate(Date showDate) {
		ShowDate = showDate;
	}
	public String getCancellation() {
		return Cancellation;
	}
	public void setCancellation(String cancellation) {
		Cancellation = cancellation;
	}
	
	
	
	
	
}
