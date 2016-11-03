package com.example.proriarty1.gamesapp.Models;

import com.example.proriarty1.gamesapp.R;

import java.util.HashMap;

/**
 * Created by Proriarty1 on 29.10.2016.
 */

public class Game extends HashMap<String, String> { // data класс настолок
    // все переменные private, так что чтобы получить к ним доступ из других классов, пользуйся методами
  /*
    private String description;
    private String title;
    private Integer players;
    private int price;
    private byte age;
    */
    private int age;

    public Game(String title, String description, Integer players, Integer price, Integer age) { //допиши конструктор
        super();
        super.put("name", title);
        super.put("desc", description);
        super.put("players", players.toString());
        super.put("price", price.toString());
        Integer a;
        switch (age) {
            case 6:
                a = R.drawable.age_6;
                break;
            case 12:
                a = R.drawable.age_12;
                break;
            case 18:
                a = R.drawable.age_18;
                break;
            default:
                a = -1;

        }
        this.age = age;

        super.put("age", a.toString());

    }

    public String getName() {
        return super.get("name");
    }

    public String getDesc() {
        return super.get("desc");
    }

    public String getPrice() {
        return super.get("price");
    }

    public Integer getPlayers() {
        String s = super.get("players");
        return Integer.valueOf(s);
    }

    public Integer getAge() {

        return this.age;//Integer.valueOf(super.get("age"));
    }
  /*  public Game() {

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
*/
}
