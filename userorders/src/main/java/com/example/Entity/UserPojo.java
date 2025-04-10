package com.example.Entity;
import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
@Entity
@Table(name="user_pojo")
public class UserPojo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	@NotBlank
	@Size(min = 2, max = 50)
	private String firstname;
	@NotBlank
	@Size(min = 2, max = 50)
	private String lastname;
	@NotNull(message = "Email must not be null")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email address")
	private String emailaddress;
	@NotNull(message = "Employee number must not be null")
	@Min(value = 1000000000L, message = "Employee number must be a valid 10-digit number")
	@Max(value = 9999999999L, message = "Employee number must be a valid 10-digit number")
	private long phonenumber;
	@Size(min = 3, max = 30)
	@Pattern(regexp = "^[a-zA-Z0-9_]*$")
	private String username;
	@Size(min = 8, max = 
	100)
	private String password;
	@NotBlank
	private String gender;
	@NotNull
	@Past
	private Date datofbirth;
	@NotNull
	private String userrole;
	@NotNull
	private String accountstatus;
	@OneToOne(fetch = FetchType.EAGER)
	@jakarta.persistence.JoinColumn(name="fkoid")		
	private OrderPojo op;
	
	public OrderPojo getOp() {
		return op;
	}



	public void setOp(OrderPojo op) {
		this.op = op;
	}



	public UserPojo() {
		super();
	}



	@Override
	public String toString() {
		return "UserPojo [userid=" + userid + ", firstname=" + firstname + ", lastname=" + lastname + ", emailaddress="
				+ emailaddress + ", phonenumber=" + phonenumber + ", username=" + username + ", password=" + password
				+ ", gender=" + gender + ", datofbirth=" + datofbirth + ", userrole=" + userrole + ", accountstatus="
				+ accountstatus + ", op=" + op + "]";
	}



	public UserPojo(int userid, @NotBlank @Size(min = 2, max = 50) String firstname,
			@NotBlank @Size(min = 2, max = 50) String lastname,
			@NotNull(message = "Email must not be null") @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email address") String emailaddress,
			@NotNull(message = "Employee number must not be null") @Min(value = 1000000000, message = "Employee number must be a valid 10-digit number") @Max(value = 9999999999L, message = "Employee number must be a valid 10-digit number") long phonenumber,
			@Size(min = 3, max = 30) @Pattern(regexp = "^[a-zA-Z0-9_]*$") String username,
			@Size(min = 8, max = 100) String password, @NotBlank String gender, @NotNull @Past Date datofbirth,
			@NotNull String userrole, @NotNull String accountstatus, OrderPojo op) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.emailaddress = emailaddress;
		this.phonenumber = phonenumber;
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.datofbirth = datofbirth;
		this.userrole = userrole;
		this.accountstatus = accountstatus;
		this.op = op;
	}



	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDatofbirth() {
		return datofbirth;
	}

	public void setDatofbirth(Date datofbirth) {
		this.datofbirth = datofbirth;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	public String getAccountstatus() {
		return accountstatus;
	}

	public void setAccountstatus(String accountstatus) {
		this.accountstatus = accountstatus;
	}




	
	
	
}
