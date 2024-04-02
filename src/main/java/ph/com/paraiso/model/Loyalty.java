package ph.com.paraiso.model;

import jakarta.persistence.*;

@Entity
@Table(name="LOYALTY")
public class Loyalty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer loyalty_id;
	private Integer user_id;
	private Double available_points;
	private Double redeemed_points;
	private Double total_points;
	
	public Loyalty() {
		super();
	}

	public Loyalty(Integer loyalty_id, Integer user_id, Double available_points, Double redeemed_points,
			Double total_points) {
		super();
		this.loyalty_id = loyalty_id;
		this.user_id = user_id;
		this.available_points = available_points;
		this.redeemed_points = redeemed_points;
		this.total_points = total_points;
	}

	public Loyalty(Integer user_id, Double available_points, Double redeemed_points, Double total_points) {
		super();
		this.user_id = user_id;
		this.available_points = available_points;
		this.redeemed_points = redeemed_points;
		this.total_points = total_points;
	}

	public Integer getLoyalty_id() {
		return loyalty_id;
	}

	public void setLoyalty_id(Integer loyalty_id) {
		this.loyalty_id = loyalty_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Double getAvailable_points() {
		return available_points;
	}

	public void setAvailable_points(Double available_points) {
		this.available_points = available_points;
	}

	public Double getRedeemed_points() {
		return redeemed_points;
	}

	public void setRedeemed_points(Double redeemed_points) {
		this.redeemed_points = redeemed_points;
	}

	public Double getTotal_points() {
		return total_points;
	}

	public void setTotal_points(Double total_points) {
		this.total_points = total_points;
	}

	@Override
	public String toString() {
		return "Loyalty [loyalty_id=" + loyalty_id + ", user_id=" + user_id + ", available_points=" + available_points
				+ ", redeemed_points=" + redeemed_points + ", total_points=" + total_points + "]";
	}
	
	
}
