package com.spring.series.jdbc.dao;

import com.spring.series.jdbc.model.Player;

import java.util.List;

public interface PlayerDAO {

    public Player getPlayer(int playerId);

    public String insertNewPlayer(Player player);

    public List<Player> getAllPlayer();
}