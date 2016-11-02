package com.example.proriarty1.gamesapp;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.proriarty1.gamesapp.Models.Game;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    static public ArrayList<Game> games;
    Dialog_add dialog_add;
   static public SimpleAdapter listAdapter;
    ListView list;
    ListView lv;

    String[] keys= {"name","desc","players","price"};
    int[] ids  = {R.id.name,R.id.desc,R.id.players,R.id.price};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog_add = new Dialog_add();
        findViewById(R.id.add_btn).setOnClickListener(this);
        findViewById(R.id.del_btn).setOnClickListener(this);
        games = new ArrayList<>();

      //  games.add(new Game("Cluedo","Desc",6,1000,12 ));
       // games.add(new Game("Uno","Desc2",6,300,6 ));

        listAdapter = new SimpleAdapter(this, games,R.layout.item,keys,ids);
        list = (ListView) findViewById(R.id.listOfItems);
        list.setAdapter(listAdapter);
       // games.add(new Game("Uno","Desc2",6,300,6 ));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                dialog_add.setAddOrEdit(true);
                dialog_add.show(getFragmentManager(),"edit");
                dialog_add.setFields(games.get(position));

               /* games.add(new Game("title","desc",20,20,20));
                listAdapter.notifyDataSetChanged();*/

    }});
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_btn:
                dialog_add.setAddOrEdit(false);
                dialog_add.show(getFragmentManager(),"dlg1" );

                break;
            case R.id.del_btn:

                // list = (ListView) this.findViewById(R.id.listOfItems);

                ToggleButton del_btn =  (ToggleButton)findViewById(R.id.del_btn);
                if(del_btn.isChecked()){

                    for (int i = 0; i < games.size(); i++){
                        list.getChildAt(i).findViewById(R.id.item_del).setVisibility(View.VISIBLE);}
                        findViewById(R.id.add_btn).setEnabled(false);

                }else{

                    for (int i = 0; i < games.size(); i++){
                        list.getChildAt(i).findViewById(R.id.item_del).setVisibility(View.GONE);}
                    findViewById(R.id.add_btn).setEnabled(true);
                }
               // del_btn.setText("Done");

                break;
            case R.id.item_del:
                // list = (ListView) this.findViewById(R.id.listOfItems);
                int index = list.indexOfChild((View) v.getParent());
                games.remove(index);
                listAdapter.notifyDataSetChanged();

           // case R.id.listOfItems:

            default:
                break;
        }
    }
  /* static public void addGame(Game game){
       games.add(game);
   }*/
}