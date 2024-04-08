package ph.com.paraiso.model;

import jakarta.persistence.*;

@Entity
@Table(name="ADD_ONS")
public class AddOns {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer add_on_id;
	private String add_on_name;
	private String description;
	private Integer amount;
	
	public AddOns() {
		super();
	}
	
	public AddOns(Integer add_on_id, String add_on_name, String description, Integer amount) {
		super();
		this.add_on_id = add_on_id;
		this.add_on_name = add_on_name;
		this.description = description;
		this.amount = amount;
	}
	
	public AddOns(String add_on_name, String description, Integer amount) {
		super();
		this.add_on_name = add_on_name;
		this.description = description;
		this.amount = amount;
	}

	public Integer getAdd_on_id() {
		return add_on_id;
	}

	public void setAdd_on_id(Integer add_on_id) {
		this.add_on_id = add_on_id;
	}

	public String getAdd_on_name() {
		return add_on_name;
	}

	public void setAdd_on_name(String add_on_name) {
		this.add_on_name = add_on_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "AddOns [add_on_id=" + add_on_id + ", add_on_name=" + add_on_name + ", description=" + description
				+ ", amount=" + amount + "]";
	}
	
	
	
	
}
