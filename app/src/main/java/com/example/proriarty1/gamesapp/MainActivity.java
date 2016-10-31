package com.example.proriarty1.gamesapp;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.proriarty1.gamesapp.Models.Game;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  public ArrayList<Game> games;
    DialogFragment dialog_add;
    String[] keys= {"title","desc","players","price"};
    int[] ids  = {R.id.name,R.id.desc,R.id.players,R.id.price};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dialog_add=new Dialog_add();
        findViewById(R.id.add_btn).setOnClickListener(this);
        games= new ArrayList<>();


        games.add(new Game("Cluedo","Desc",6,1000,12 ));
        games.add(new Game("Uno","Desc2",6,300,6 ));

        SimpleAdapter listAdapter = new SimpleAdapter(this, games,R.layout.item,keys,ids);
        ListView listOfItems = (ListView) findViewById(R.id.listOfItems);
        listOfItems.setAdapter(listAdapter);
        games.add(new Game("Uno","Desc2",6,300,6 ));




    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_btn:
                dialog_add.show(getFragmentManager(),"dlg1" );
                break;
            case R.id.del_btn:
                dialog_add.show(getFragmentManager(), "dlg2");
                break;
            default:
                break;
        }
    }
}