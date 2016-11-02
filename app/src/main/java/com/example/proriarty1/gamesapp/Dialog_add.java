package com.example.proriarty1.gamesapp;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.proriarty1.gamesapp.Models.Game;


//import static com.example.proriarty1.gamesapp.MainActivity.addGame;
import static com.example.proriarty1.gamesapp.MainActivity.games;
import static com.example.proriarty1.gamesapp.MainActivity.listAdapter;

/**
 */
//Created by Proriarty1 on 30.10.2016.
public class Dialog_add extends DialogFragment implements SeekBar.OnSeekBarChangeListener {

    TextView name;
    RadioGroup vozrast;
    TextView desc;
    TextView price;
    SeekBar players;
    RadioButton r1;
    RadioButton r2;
    RadioButton r3;
    Game currentGame;
    boolean AddOrEdit;
    // Notification notification;
    Integer age;//0 for add, 1 for edit

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (AddOrEdit) {
            getDialog().setTitle("Edit");

        } else {
            getDialog().setTitle("Add");
        }

        View v = inflater.inflate(R.layout.dialog_layout, null);

        name = (TextView) v.findViewById(R.id.dialog_name);
        desc = (TextView) v.findViewById(R.id.dialog_desc);
        price = (TextView) v.findViewById(R.id.dialog_price);
        players = (SeekBar) v.findViewById(R.id.seekBar2);
        players.setOnSeekBarChangeListener(this);
        vozrast = (RadioGroup) v.findViewById(R.id.vozrast);

        r1 = (RadioButton) v.findViewById(R.id.radioButton2);
        r2 = (RadioButton) v.findViewById(R.id.radioButton3);
        r3 = (RadioButton) v.findViewById(R.id.radioButton4);

        View.OnClickListener onClickSave = new View.OnClickListener() {// обрабатывает нажатие на кнопку Save
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.radioButton2:
                        age = 6;
                        r1.setAlpha(1);
                        r2.setAlpha((float) 0.5);
                        r3.setAlpha((float) 0.5);
                        break;
                    case R.id.radioButton3:
                        age = 12;
                        r2.setAlpha(1);
                        r1.setAlpha((float) 0.5);
                        r3.setAlpha((float) 0.5);
                        break;
                    case R.id.radioButton4:
                        age = 18;
                        r3.setAlpha(1);
                        r2.setAlpha((float) 0.5);
                        r1.setAlpha((float) 0.5);
                        break;
                    case R.id.save_btn:
                        //заполнить currentGame (new Game (String title, String description, Integer players, Integer price, Integer age))
                        //собрать инфу со всех полей в диалоге

                        currentGame = new Game(name.getText().toString(), desc.getText().toString(),
                                players.getProgress(), Integer.valueOf(price.getText().toString()), age);

                        games.add(currentGame);
                        cleanAll();
                        getDialog().dismiss();
                        listAdapter.notifyDataSetChanged();//dismiss закрывает диалог


                }
            }


        };

        r1.setOnClickListener(onClickSave);
        r2.setOnClickListener(onClickSave);
        r3.setOnClickListener(onClickSave);

        v.findViewById(R.id.save_btn).

                setOnClickListener(onClickSave);

        return v;

    }

    public void setAddOrEdit(boolean bool) {
        this.AddOrEdit = bool;
    }

    public void onDismiss(DialogInterface dialog) {

        super.onDismiss(dialog);

    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress,
                                  boolean fromUser) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {


        TextView text = (TextView) getView().findViewById(R.id.seekbarCurrent);


        text.setText(String.valueOf(seekBar.getProgress() + 1));
    }

    public void setFields(Game game) {
        players.setProgress(game.getPlayers());
        name.setText(game.getName());
        desc.setText(game.getDesc());
        price.setText(game.getPrice());
    }

    void cleanAll() {
        this.players.setProgress(0);
        this.name.setText("");
        this.desc.setText("");
        this.price.setText("");
        this.vozrast.clearCheck();
        vozrast.getChildAt(0).setAlpha((float) 0.5);
        vozrast.getChildAt(1).setAlpha((float) 0.5);
        vozrast.getChildAt(2).setAlpha((float) 0.5);
        this.age = 0;
    }
}