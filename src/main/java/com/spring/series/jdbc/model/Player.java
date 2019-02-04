package com.spring.series.jdbc.model;

public class Player {

    // member variables
    private int playerId;
    private String name;
    private int age;
    private int matches;

    // default constructor
    public Player() {
        super();
    }

    // 3-arg parameterized-constructor
    public Player(String name, int age, int matches) {
        super();
        this.name = name;
        this.age = age;
        this.matches = matches;
    }

    // getter and setter
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }
}