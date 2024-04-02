package ph.com.paraiso.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="PAYMENTS")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer payment_id;
	private Integer booking_id;
	private Double amount;
	private Date payment_date;
	private String payment_method;
	
	public Payment() {
		super();
	}

	public Payment(Integer payment_id, Integer booking_id, Double amount, Date payment_date, String payment_method) {
		super();
		this.payment_id = payment_id;
		this.booking_id = booking_id;
		this.amount = amount;
		this.payment_date = payment_date;
		this.payment_method = payment_method;
	}

	public Payment(Integer booking_id, Double amount, Date payment_date, String payment_method) {
		super();
		this.booking_id = booking_id;
		this.amount = amount;
		this.payment_date = payment_date;
		this.payment_method = payment_method;
	}

	public Integer getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
	}

	public Integer getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(Integer booking_id) {
		this.booking_id = booking_id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", booking_id=" + booking_id + ", amount=" + amount
				+ ", payment_date=" + payment_date + ", payment_method=" + payment_method + "]";
	}
	
	
}
