package ph.come.paraiso.dto;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class UserDto {

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
	
	
   
	public UserDto(String username, String password, String accountType, String firstName, String lastName,
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
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
	
	
}
