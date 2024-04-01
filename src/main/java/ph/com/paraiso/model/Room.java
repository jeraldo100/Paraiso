package ph.com.paraiso.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ROOMS")
public class Room {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer room_id;
	private Integer hotel_id;
	private Integer type_id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id", referencedColumnName = "type_id")
	private Room_type room_type;
	private String status;
	
	public Room() {
		super();
	}

	public Room(Integer room_id, Integer hotel_id, Integer type_id, Room_type room_type, String status) {
		super();
		this.room_id = room_id;
		this.hotel_id = hotel_id;
		this.type_id = type_id;
		this.room_type = room_type;
		this.status = status;
	}

	public Room(Integer hotel_id, Integer type_id, Room_type room_type, String status) {
		super();
		this.hotel_id = hotel_id;
		this.type_id = type_id;
		this.room_type = room_type;
		this.status = status;
	}

	public Room(Integer hotel_id, Integer type_id, String status) {
		super();
		this.hotel_id = hotel_id;
		this.type_id = type_id;
		this.status = status;
	}

	public Room(Integer room_id, Integer hotel_id, Integer type_id, String status) {
		super();
		this.room_id = room_id;
		this.hotel_id = hotel_id;
		this.type_id = type_id;
		this.status = status;
	}

	public Integer getRoom_id() {
		return room_id;
	}

	public void setRoom_id(Integer room_id) {
		this.room_id = room_id;
	}

	public Integer getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(Integer hotel_id) {
		this.hotel_id = hotel_id;
	}

	public Integer getType_id() {
		return type_id;
	}

	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}

	public Room_type getRoom_type() {
		return room_type;
	}

	public void setRoom_type(Room_type room_type) {
		this.room_type = room_type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Room [room_id=" + room_id + ", hotel_id=" + hotel_id + ", type_id=" + type_id + ", status=" + status
				+ "]";
	}
}
