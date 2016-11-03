package com.example.proriarty1.gamesapp;


import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.NotificationCompat;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.ToggleButton;

import com.example.proriarty1.gamesapp.Models.Game;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static public ArrayList<Game> games;
    DialogF dialog_add;
    static public SimpleAdapter listAdapter;
    ListView list;

    String[] keys = {"name", "desc", "players", "price", "age"};
    int[] ids = {R.id.name, R.id.desc, R.id.players, R.id.price, R.id.age};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog_add = new DialogF();
        findViewById(R.id.add_btn).setOnClickListener(this);
        findViewById(R.id.del_btn).setOnClickListener(this);
        games = new ArrayList<>();
        listAdapter = new SimpleAdapter(this, games, R.layout.item, keys, ids);
        list = (ListView) findViewById(R.id.listOfItems);
        list.setAdapter(listAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
                DialogF dialog_edit = new DialogF();
                dialog_edit.setAddOrEdit(true);
                dialog_edit.index = position;
                dialog_edit.show(getFragmentManager(), "edit");
            }
        });
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_btn:
                dialog_add.setAddOrEdit(false);
                dialog_add.show(getFragmentManager(), "dlg1");
                break;
            case R.id.del_btn:
                ToggleButton del_btn = (ToggleButton) findViewById(R.id.del_btn);
                View item_del;
                if (del_btn.isChecked()) {
                    Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotation);
                    for (int i = 0; i < games.size(); i++) {
                        if (list.getChildAt(i) != null) {
                            item_del = list.getChildAt(i).findViewById(R.id.item_del);
                            item_del.setVisibility(View.VISIBLE);
                            item_del.startAnimation(animation);
                        }
                    }
                    findViewById(R.id.add_btn).setEnabled(false);

                } else {

                    for (int i = 0; i < games.size(); i++) {
                        if (list.getChildAt(i) != null) {
                            list.getChildAt(i).findViewById(R.id.item_del).setVisibility(View.GONE);
                        }
                    }
                    findViewById(R.id.add_btn).setEnabled(true);
                }
                break;
            case R.id.item_del:
                int index = list.indexOfChild((View) v.getParent());
                list.getChildAt(games.size() - 1).findViewById(R.id.item_del).setVisibility(View.GONE);
                games.remove(index);
                listAdapter.notifyDataSetChanged();

            default:
                break;
        }
    }

}