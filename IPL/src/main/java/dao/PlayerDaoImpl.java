package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pojo.Player;

public class PlayerDaoImpl implements PlayerDao {
	
	private Connection con;
	private PreparedStatement pst1;
	
	public PlayerDaoImpl() throws SQLException
	{
		con = utils.DButils.openConnection();
		pst1= con.prepareStatement("insert into players values(default,?,?,?,?,?,?)");
		System.out.println("player dao created");
	}
	@Override
	public void addPlayer(Player player) throws SQLException {
		
		
		pst1.setString(1, player.getFirst_name());
		pst1.setString(2, player.getLast_name());
		pst1.setDate(3, player.getDob());
		pst1.setDouble(4, player.getBatting_avg());
		pst1.setInt(5, player.getWickets_taken());
		pst1.setInt(6, player.getTeam_id());
		
		int rowChanged= pst1.executeUpdate();
		if(rowChanged ==1)
		System.out.println("plaayer added");
		else
			System.out.println("player not added");
	
	}
	public  void cleanUp() throws SQLException
	{
		if(pst1!=null)
			pst1.close();
		utils.DButils.closeConnection();
		System.out.println("player dao cleaned up ");
	}
	
}
