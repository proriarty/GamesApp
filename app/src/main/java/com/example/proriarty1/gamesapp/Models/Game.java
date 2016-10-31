package com.example.proriarty1.gamesapp.Models;

import java.util.HashMap;

/**
 * Created by Proriarty1 on 29.10.2016.
 */

public class Game extends HashMap<String,String>{ // data класс настолок
    // все переменные private, так что чтобы получить к ним доступ из других классов, пользуйся методами
  /*  private String description;
    private String title;
    private Integer players;
    private int price;
    private byte age;*/

    public Game (String title, String description, Integer players, Integer price, Integer age){ //допиши конструктор
        super();
        super.put("title",title);
        super.put("desc",description);
        super.put("players", players.toString());
        super.put("price", price.toString());
        super.put("age",age.toString());

    }
  /*  public String getTitle(){
        return super.get("title");
    }
  /*  public Game() {

    }
/*
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
*/
}
