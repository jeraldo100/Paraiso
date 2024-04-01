package ph.com.paraiso.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="USERS")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	private String username;
	private String password;
	private String account_type;
	private String first_name;
	private String last_name;
	private Date date_of_birth;
	private String address;
	private Integer phone;
	private String email;
	
	public User() {
		super();
	}

	public User(Integer user_id, String username, String password, String account_type, String first_name,
			String last_name, Date date_of_birth, String address, Integer phone, String email) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.account_type = account_type;
		this.first_name = first_name;
		this.last_name = last_name;
		this.date_of_birth = date_of_birth;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public User(String username, String password, String account_type, String first_name, String last_name,
			Date date_of_birth, String address, Integer phone, String email) {
		super();
		this.username = username;
		this.password = password;
		this.account_type = account_type;
		this.first_name = first_name;
		this.last_name = last_name;
		this.date_of_birth = date_of_birth;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", account_type="
				+ account_type + ", first_name=" + first_name + ", last_name=" + last_name + ", date_of_birth="
				+ date_of_birth + ", address=" + address + ", phone=" + phone + ", email=" + email + "]";
	}
}
