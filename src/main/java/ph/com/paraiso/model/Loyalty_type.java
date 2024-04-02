package ph.com.paraiso.model;

import jakarta.persistence.*;

@Entity
@Table(name="LOYALTY_TYPE")
public class Loyalty_type {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String loyalty_type;
	private String description;
	private Double points;
	
	public Loyalty_type() {
		super();
	}

	public Loyalty_type(String loyalty_type, String description, Double points) {
		super();
		this.loyalty_type = loyalty_type;
		this.description = description;
		this.points = points;
	}

	public Loyalty_type(String description, Double points) {
		super();
		this.description = description;
		this.points = points;
	}

	public String getLoyalty_type() {
		return loyalty_type;
	}

	public void setLoyalty_type(String loyalty_type) {
		this.loyalty_type = loyalty_type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPoints() {
		return points;
	}

	public void setPoints(Double points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "Loyalty_type [loyalty_type=" + loyalty_type + ", description=" + description + ", points=" + points
				+ "]";
	}
	
}
