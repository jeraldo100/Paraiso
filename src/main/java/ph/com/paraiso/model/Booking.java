package ph.com.paraiso.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
@Table(name="BOOKINGS")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer booking_id;
	private Integer user_id;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date checkin_date;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date checkout_date;
	private Double total_price;
	private String arrival_time;
	private Integer adults;
	private Integer children;
	private String status;
	
	public Booking() {
		super();
	}

	public Booking(Integer booking_id, Integer user_id, Date checkin_date, Date checkout_date, Double total_price,
			String arrival_time, Integer adults, Integer children, String status) {
		super();
		this.booking_id = booking_id;
		this.user_id = user_id;
		this.checkin_date = checkin_date;
		this.checkout_date = checkout_date;
		this.total_price = total_price;
		this.arrival_time = arrival_time;
		this.adults = adults;
		this.children = children;
		this.status = status;

	}

	public Booking(Integer user_id, Date checkin_date, Date checkout_date, Double total_price, String arrival_time,
			Integer adults, Integer children, String status) {
		super();
		this.user_id = user_id;
		this.checkin_date = checkin_date;
		this.checkout_date = checkout_date;
		this.total_price = total_price;
		this.arrival_time = arrival_time;
		this.adults = adults;
		this.children = children;
		this.status = status;

	}

	public Integer getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(Integer booking_id) {
		this.booking_id = booking_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
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

	public Double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}

	public String getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}

	public Integer getAdults() {
		return adults;
	}

	public void setAdults(Integer adults) {
		this.adults = adults;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Booking [booking_id=" + booking_id + ", user_id=" + user_id + ", checkin_date=" + checkin_date
				+ ", checkout_date=" + checkout_date + ", total_price=" + total_price + ", arrival_time=" + arrival_time
				+ ", adults=" + adults + ", children=" + children + ", status=" + status + "]";
	}
	
}
