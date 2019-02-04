package com.spring.series.jdbc;

import com.spring.series.jdbc.dao.PlayerDAO;
import com.spring.series.jdbc.model.Player;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestPlayerInfo {

    public static void main(String[] args) {
        testSpringJdbcTemplate();
    }

    /**
     * Test method : invokes all three public DAO methods using Spring Dependency Injection after loading the context xml file
     */
    private static void testSpringJdbcTemplate() {

        // loads the context xml and uses getBean() to retrieve the bean
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/spring/series/jdbc/SpringContext.xml");
        PlayerDAO playerDAO = (PlayerDAO) applicationContext.getBean("playerDAO");

        System.out.println("\nSpring JDBC Template Demostration using spring datasource");

        // invokes getPlayer() method supplying PLAYER_ID
        System.out.println("\nA. Invoking getPlayer() method supplying player_id in the formal argument");
        Player player1 = playerDAO.getPlayer(1);
        System.out.println("\nID\tName\t\t\tAge\tMatches");
        System.out.println("==\t================\t===\t=======");
        System.out.println(player1.getPlayerId() + "\t" + player1.getName() + "\t" + player1.getAge() + "\t" + player1.getMatches());

        // insert or save new player information into the database
        System.out.println("\nB. Creating or Saving new player in database");
        Player newPlayer = new Player("Lou Vincent", 36, 23);
        newPlayer.setPlayerId(4);
        String returnStr = playerDAO.insertNewPlayer(newPlayer);
        System.out.println("Return message : " + returnStr);

        // invokes to retrieve all players from database
        System.out.println("\nC. Invoking getAllPlayers() method to retrieve all players from database");
        List<Player> lstPlayers = playerDAO.getAllPlayer();
        System.out.println("\nID\tName\t\t\tAge\tMatches");
        System.out.println("==\t================\t===\t=======");
        for (Player player : lstPlayers) {
            System.out.println(player.getPlayerId() + "\t" + player.getName() + "\t" + player.getAge() + "\t" + player.getMatches());
        }
    }
}