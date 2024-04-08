package ph.com.paraiso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Room_joined {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer room_id;
	private String name;
	private Integer price_per_night;
	
	public Room_joined() {
		super();
	}

	public Room_joined(Integer room_id, String name, Integer price_per_night) {
		super();
		this.room_id = room_id;
		this.name = name;
		this.price_per_night = price_per_night;
	}

	public Integer getRoom_id() {
		return room_id;
	}

	public void setRoom_id(Integer room_id) {
		this.room_id = room_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice_per_night() {
		return price_per_night;
	}

	public void setPrice_per_night(Integer price_per_night) {
		this.price_per_night = price_per_night;
	}
}
