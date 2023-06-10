package bean;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;

import dao.UserDaoImpl;
import pojos.User;

public class VoterDetails {
	
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String dob;
	private UserDaoImpl userDao;
	public VoterDetails()throws SQLException
	{
		userDao = new UserDaoImpl();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "VoterDetails [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", dob=" + dob
				+ "]";
	}
	
	public String registerVoter() throws SQLException
	{
		System.out.println(" mapping"+firstname+""+lastname);
		LocalDate date= LocalDate.parse(dob);
		int voterAge = Period.between(date, LocalDate.now()).getYears();
		User newVoter = new User(firstname, lastname, email, password, Date.valueOf(date));
		if(voterAge>=21)
		{
			userDao.registerNewVoter(newVoter);
			return "registrationForm";
		}
		return "registration failed";
	}
}
