package dao;

import java.sql.SQLException;

import pojo.Player;

public interface PlayerDao {
	
	void addPlayer(Player player) throws SQLException;
}
