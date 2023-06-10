package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Team;

public class TeamDaoImpl implements TeamDao {

	
	private Connection con ;
	private PreparedStatement pst1,pst2;
	
	
	public TeamDaoImpl() throws SQLException
	{
		con = utils.DButils.openConnection();
		pst1= con.prepareStatement("select team_id, abbrevation from teams");
		pst2 = con.prepareStatement("select * from teams where team_id =?");
		System.out.println("team dao created");
	}
	@Override
	public List<Team> getlAllTeams() throws SQLException {
		// TODO Auto-generated method stub
		List<Team> teams = new ArrayList<Team>();
		try(ResultSet rst= pst1.executeQuery())
		{
			while(rst.next())
					teams.add(new Team(rst.getInt(1), rst.getString(2)));
		}
	
		return teams;
	}
	@Override
	public Team getSelectedTeamDetails(int teamId) throws SQLException
	{
		pst2.setInt(1, teamId);
		try(ResultSet rst = pst2.executeQuery())
		{
			if(rst.next())
				return new Team(teamId, rst.getString(2), rst.getString(3), rst.getString(4), rst.getInt(5), rst.getDouble(6), rst.getInt(7));
		}
		return null;
	}
	public  void cleanUp() throws SQLException
	{
		if(pst1!=null)
			pst1.close();
		if(pst2!= null)
			pst2.close();
		utils.DButils.closeConnection();
		System.out.println("team dao cleaned up");
	}

}
