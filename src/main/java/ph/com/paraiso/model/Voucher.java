package ph.com.paraiso.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
@Table(name="VOUCHERS")
public class Voucher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer voucher_id;
	private String voucher_code;
	private String description;
	private Double amount;
	private Date validation;
	
	public Voucher() {
		super();
	}

	public Voucher(Integer voucher_id, String voucher_code, String description, Double amount, Date validation) {
		super();
		this.voucher_id = voucher_id;
		this.voucher_code = voucher_code;
		this.description = description;
		this.amount = amount;
		this.validation = validation;
	}

	public Voucher(String voucher_code, String description, Double amount, Date validation) {
		super();
		this.voucher_code = voucher_code;
		this.description = description;
		this.amount = amount;
		this.validation = validation;
	}

	public Integer getVoucher_id() {
		return voucher_id;
	}

	public void setVoucher_id(Integer voucher_id) {
		this.voucher_id = voucher_id;
	}

	public String getVoucher_code() {
		return voucher_code;
	}

	public void setVoucher_code(String voucher_code) {
		this.voucher_code = voucher_code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getValidation() {
		return validation;
	}

	public void setValidation(Date validation) {
		this.validation = validation;
	}
	
	
}
