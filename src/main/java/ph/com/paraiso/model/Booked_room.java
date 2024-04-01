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
	
}
