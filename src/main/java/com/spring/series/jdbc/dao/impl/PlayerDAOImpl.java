package com.spring.series.jdbc.dao.impl;

import com.spring.series.jdbc.dao.PlayerDAO;
import com.spring.series.jdbc.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("playerDAO")
public class PlayerDAOImpl implements PlayerDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    /**
     * This method retrieves a player from database using jdbcTemplate based on the PLAYER_ID supplied in the formal arguments
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public Player getPlayer(int playerId) {

        String sql = "SELECT PLAYER_ID, NAME, AGE, MATCHES FROM PLAYER WHERE PLAYER_ID = ?";
        Player player = (Player) getJdbcTemplate().queryForObject(
                sql,
                new Object[]{playerId},
                new BeanPropertyRowMapper(Player.class));
        return player;
    }

    /**
     * create or inserts the new player information into the database using jdbcTemplate
     */
    public String insertNewPlayer(Player player) {

        String sql = "INSERT INTO PLAYER(PLAYER_ID,NAME, AGE, MATCHES) VALUES(?, ?, ?, ?)";
        int returnValue = getJdbcTemplate().update(
                sql,
                new Object[]{player.getPlayerId(),player.getName(), player.getAge(), player.getMatches()});
        if (1 == returnValue)
            return "Player creation is SUCCESS";
        else
            return "Player creation is FAILURE";
    }

    /**
     * Retrieves all players from the database
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<Player> getAllPlayer() {

        String sql = "SELECT PLAYER_ID, NAME, AGE, MATCHES FROM PLAYER";
        List<Player> lstPlayers = getJdbcTemplate().query(
                sql,
                new BeanPropertyRowMapper(Player.class));
        return lstPlayers;
    }
}