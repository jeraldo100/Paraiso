package ph.com.paraiso.model;

public class BookingInputs {
	private String checkin_date;
	private String checkout_date;
	private String room_ids;
	private Integer adults;
	private Integer children;
	
	public BookingInputs() {
		super();
	}
	
	public BookingInputs(String checkin_date, String checkout_date) {
		super();
		this.checkin_date = checkin_date;
		this.checkout_date = checkout_date;
	}
	
	public BookingInputs(String checkin_date, String checkout_date, String room_ids) {
		super();
		this.checkin_date = checkin_date;
		this.checkout_date = checkout_date;
		this.room_ids = room_ids;
	}

	public BookingInputs(String checkin_date, String checkout_date, String room_ids, Integer adults, Integer children) {
		super();
		this.checkin_date = checkin_date;
		this.checkout_date = checkout_date;
		this.room_ids = room_ids;
		this.adults = adults;
		this.children = children;
	}

	public String getCheckin_date() {
		return checkin_date;
	}

	public void setCheckin_date(String checkin_date) {
		this.checkin_date = checkin_date;
	}

	public String getCheckout_date() {
		return checkout_date;
	}

	public void setCheckout_date(String checkout_date) {
		this.checkout_date = checkout_date;
	}

	public String getRoom_ids() {
		return room_ids;
	}

	public void setRoom_ids(String room_ids) {
		this.room_ids = room_ids;
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
	
}
