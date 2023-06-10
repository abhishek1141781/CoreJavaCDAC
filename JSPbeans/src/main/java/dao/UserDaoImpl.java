package dao;

import java.sql.*;
import static utils.DBUtils.*;

import pojos.User;

public class UserDaoImpl implements UserDao {
	// state (props)
	private Connection cn;
	private PreparedStatement pst1, pst2,pst3,pst4;

	// def ctor : invoked by layer above(tester) , once , in init phase
	public UserDaoImpl() throws SQLException {
		// get cn from db utils
		cn = openConnection();
		// pst1
		pst1 = cn.prepareStatement("select * from users2 where email=? and password=?");
		pst2 = cn.prepareStatement("update users2 set status=1 where id=?");
		pst3=cn.prepareStatement("insert into users2 values(default,?,?,?,?,?,0,'voter')");
		pst4= cn.prepareStatement("insert into users2 values(default,?,?,?,?,?,0,'admin')");
		System.out.println("user dao created...");
	}

	@Override
	public User authenticateUser(String email, String password) throws SQLException {
		// set IN params
		pst1.setString(1, email);
		pst1.setString(2, password);
		// exec : execQuery
		try (ResultSet rst = pst1.executeQuery()) {
			/*
			 * int id, String firstName, String lastName, String email, String password,
			 * Date dob, boolean status, String role
			 */
			if (rst.next())
				return new User(rst.getInt(1), rst.getString(2), rst.getString(3), email, password, rst.getDate(6),
						rst.getBoolean(7), rst.getString(8));
		}
		return null;
	}

	@Override
	public String updateVotingStatus(int voterId) throws SQLException {
		// Set N param
		pst2.setInt(1, voterId);
		// exec : execUpdate
		int rowCount = pst2.executeUpdate();
		if (rowCount == 1)
			return "Voting status updated....";
		return "Voting status updation failed!!!!!!!";
	}
	
	

	@Override
	public String registerNewVoter(User voter) throws SQLException {
		//set IN params
		//first_name | last_name | email             | password | dob
		pst3.setString(1, voter.getFirstName());
		pst3.setString(2, voter.getLastName());
		pst3.setString(3, voter.getEmail());
		pst3.setString(4, voter.getPassword());
		pst3.setDate(5, voter.getDob());
		int rows=pst3.executeUpdate();
		if(rows == 1)
			return "success";
		
		return "failed";
	}

	// add a method to clean up dao
	public void cleanUp() throws SQLException {
		// close psts
		if (pst1 != null)
			pst1.close();
		if (pst2 != null)
			pst2.close();
		if (pst3 != null)
			pst3.close();
		closeConnection();
	}

}
