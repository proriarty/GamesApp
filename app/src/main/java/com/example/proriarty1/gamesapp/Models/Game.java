package com.example.proriarty1.gamesapp.Models;

/**
 * Created by Proriarty1 on 29.10.2016.
 */

public class Game { // data класс настолок
    // все переменные private, так что чтобы получить к ним доступ из других классов, пользуйся методами
    private String description;
    private String title;
    private byte players;
    private int price;
    private byte age;

    public Game (String title, String description, byte players, int price, byte age){ //допиши конструктор



    }

    public String getTitle(){
return  title;
    }

    public void setTitle(String t){
        title=t;
    }


    public String getDescription(){
        return description;

    }

    public byte getPlayers(){
        return players;

    }

    public int getPrice(){
        return  price;

    }

    public byte getAge(){
        return age;

    }

}
