package ph.com.paraiso.model;

public class BookingInputs {
	private String checkin_date;
	private String checkout_date;
	private String room_ids;
	private String arrival_time;
	private Integer adults;
	private Integer children;
	private String add_ons;
	
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

	public BookingInputs(String checkin_date, String checkout_date, String room_ids, String arrival_time, Integer adults, Integer children,
			String add_ons) {
		super();
		this.checkin_date = checkin_date;
		this.checkout_date = checkout_date;
		this.room_ids = room_ids;
		this.arrival_time = arrival_time;
		this.adults = adults;
		this.children = children;
		this.add_ons = add_ons;
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

	public String getAdd_ons() {
		return add_ons;
	}

	public void setAdd_ons(String add_ons) {
		this.add_ons = add_ons;
	}

	public String getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}
	
	
}
