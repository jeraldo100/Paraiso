package ph.com.paraiso.model;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
@Table(name="USERS", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_generator")
    @SequenceGenerator(name="user_seq_generator", sequenceName = "users_seq", allocationSize=1)
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
	
	public User(String firstName, String lastName, String email, String username, String address, String accountType,
			Date dateOfBirth, BigInteger phone, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.address = address;
		this.accountType = accountType;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.password = password;
	}
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}



	public Long getUserid() {
		return userid;
	}


	public void setUserid(Long userid) {
		this.userid = userid;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
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


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
