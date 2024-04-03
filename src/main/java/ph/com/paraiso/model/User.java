package ph.com.paraiso.model;

import java.math.BigInteger;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id") 
    private Integer userid;
	private String username;
	private String password;
	private String account_type;
	private String first_name;
	private String last_name;
	private Date date_of_birth;
	private String address;
	private BigInteger phone;
	private String email;
	
	public User() {
		super();
	}

	public User(Integer user_id, String username, String password, String account_type, String first_name,
			String last_name, Date date_of_birth, String address, BigInteger phone, String email) {
		super();
		userid = user_id;
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
			Date date_of_birth, String address, BigInteger phone, String email) {
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
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
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

	public String getAccountType() {
		return account_type;
	}

	public void setAccountType(String account_type) {
		this.account_type = account_type;
	}

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	public String getLastName() {
		return last_name;
	}

	public void setLastName(String last_name) {
		this.last_name = last_name;
	}

	public Date getDateOfBirth() {
		return date_of_birth;
	}

	public void setDateOfBirth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigInteger getPhone() {
		return phone;
	}

	public void setPhone(BigInteger phone) {
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
		return "User [userid=" + userid + ", username=" + username + ", password=" + password + ", account_type="
				+ account_type + ", first_name=" + first_name + ", last_name=" + last_name + ", date_of_birth="
				+ date_of_birth + ", address=" + address + ", phone=" + phone + ", email=" + email + "]";
	}
}
