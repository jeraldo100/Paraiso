package ph.com.paraiso.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="BOOKED_ROOM")
public class Booked_room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer booking_id;
	private Integer room_id;
	private Date checkin_date;
	private Date checkout_date;
	private Double price;
	
	public Booked_room() {
		super();
	}
	
	public Booked_room(Integer booking_id, Integer room_id, Date checkin_date, Date checkout_date, Double price) {
		super();
		this.booking_id = booking_id;
		this.room_id = room_id;
		this.checkin_date = checkin_date;
		this.checkout_date = checkout_date;
		this.price = price;
	}

	public Booked_room(Integer room_id, Date checkin_date, Date checkout_date, Double price) {
		super();
		this.room_id = room_id;
		this.checkin_date = checkin_date;
		this.checkout_date = checkout_date;
		this.price = price;
	}

	public Integer getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(Integer booking_id) {
		this.booking_id = booking_id;
	}

	public Integer getRoom_id() {
		return room_id;
	}

	public void setRoom_id(Integer room_id) {
		this.room_id = room_id;
	}

	public Date getCheckin_date() {
		return checkin_date;
	}

	public void setCheckin_date(Date checkin_date) {
		this.checkin_date = checkin_date;
	}

	public Date getCheckout_date() {
		return checkout_date;
	}

	public void setCheckout_date(Date checkout_date) {
		this.checkout_date = checkout_date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Booked_room [booking_id=" + booking_id + ", room_id=" + room_id + ", checkin_date=" + checkin_date
				+ ", checkout_date=" + checkout_date + ", price=" + price + "]";
	}
	
}
