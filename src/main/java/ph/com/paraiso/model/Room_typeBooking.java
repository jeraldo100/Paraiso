package ph.com.paraiso.model;

import jakarta.persistence.*;

@Entity
public class Room_typeBooking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer type_id;
	private String name;
	private String description;
	private Double price_per_night;
	private Integer capacity;
	private Integer beds;
	private Integer bathrooms;
	private Integer available;
	
	@Lob
    @Column(name = "ROOM_IMAGE")
    private byte[] roomImage;
	
	@Transient
	private String roomImageEncoded;
	
	
	public Room_typeBooking() {
		super();
	}
	
	public Room_typeBooking(Integer type_id, String name, String description, Double price_per_night, Integer capacity,
			Integer beds, Integer bathrooms, byte[] roomImage, Integer available) {
		super();
		this.type_id = type_id;
		this.name = name;
		this.description = description;
		this.price_per_night = price_per_night;
		this.capacity = capacity;
		this.beds = beds;
		this.bathrooms = bathrooms;
		this.roomImage = roomImage;
		this.available = available;
	}

	public Integer getType_id() {
		return type_id;
	}

	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice_per_night() {
		return price_per_night;
	}

	public void setPrice_per_night(Double price_per_night) {
		this.price_per_night = price_per_night;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getBeds() {
		return beds;
	}

	public void setBeds(Integer beds) {
		this.beds = beds;
	}

	public Integer getBathrooms() {
		return bathrooms;
	}

	public void setBathrooms(Integer bathrooms) {
		this.bathrooms = bathrooms;
	}

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}

	public byte[] getRoomImage() {
		return roomImage;
	}

	public void setRoomImage(byte[] roomImage) {
		this.roomImage = roomImage;
	}

	public String getRoomImageEncoded() {
		return roomImageEncoded;
	}

	public void setRoomImageEncoded(String roomImageEncoded) {
		this.roomImageEncoded = roomImageEncoded;
	}
	
	
}
