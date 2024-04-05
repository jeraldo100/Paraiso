package ph.com.paraiso.model;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import ph.com.paraiso.model.Role;

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
    @Enumerated(value = EnumType.STRING)
    private Role accountType;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	private BigInteger phone;
	private String password;
	
	public User() {
		super();
	}

	
}
