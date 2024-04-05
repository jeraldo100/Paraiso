package ph.com.paraiso.model;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
@Table(name="USERS", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userid;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String address;
	private String accountType;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	private BigInteger phone;
	private String password;
	
	public User() {
		super();
	}
	
	public User(String username, String password, String accountType, String firstName, String lastName,
			Date dateOfBirth, String address, BigInteger phone, String email) {
		super();
		this.username = username;
		this.password = password;
		this.accountType = accountType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	


	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long user_id) {
		this.userid = user_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String last_name) {
		this.lastName = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String account_type) {
		this.accountType = account_type;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date date_of_birth) {
		this.dateOfBirth = date_of_birth;
	}

	public BigInteger getPhone() {
		return phone;
	}

	public void setPhone(BigInteger phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	
	
}
