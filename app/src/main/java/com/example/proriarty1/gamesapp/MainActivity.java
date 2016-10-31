package com.example.proriarty1.gamesapp;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.proriarty1.gamesapp.Models.Game;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ArrayList<Game> games;
    DialogFragment dialog_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog_add=new Dialog_add();
        findViewById(R.id.add_btn).setOnClickListener(this);


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