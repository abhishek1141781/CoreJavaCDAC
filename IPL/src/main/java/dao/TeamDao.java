package dao;

import java.sql.SQLException;
import java.util.List;

import pojo.Team;

public interface TeamDao {
	
	List<Team> getlAllTeams() throws SQLException;
	//add a method to fetch selected team details 
	Team getSelectedTeamDetails(int teamId) throws SQLException ;
	
}
