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


import static com.example.proriarty1.gamesapp.MainActivity.games;
import static com.example.proriarty1.gamesapp.MainActivity.listAdapter;

/**
 */
/**Created by Proriarty1 on 30.10.2016.**/
public class DialogF extends DialogFragment implements SeekBar.OnSeekBarChangeListener {

    TextView name;
    public int index = 0;
    RadioGroup ages;
    TextView desc;
    TextView price;
    SeekBar players;
    RadioButton r1;
    RadioButton r2;
    RadioButton r3;
    Game currentGame;
    boolean AddOrEdit = false; //false for Add true for Edit
    View view;

    Integer age;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.dialog_layout, null);
        view = v;
        if (AddOrEdit) {
            getDialog().setTitle("Edit");
        } else {
            getDialog().setTitle("Add");
        }


        name = (TextView) v.findViewById(R.id.dialog_name);
        desc = (TextView) v.findViewById(R.id.dialog_desc);
        price = (TextView) v.findViewById(R.id.dialog_price);
        players = (SeekBar) v.findViewById(R.id.seekBar2);
        players.setOnSeekBarChangeListener(this);
        ages = (RadioGroup) v.findViewById(R.id.ages);


        r3 = (RadioButton) v.findViewById(R.id.r6);
        r2 = (RadioButton) v.findViewById(R.id.r12);
        r1 = (RadioButton) v.findViewById(R.id.r18);

        View.OnClickListener onClickSave = new View.OnClickListener() {// обрабатывает нажатие на кнопку Save
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.r6:
                        age = 6;
                        r3.setAlpha(1);
                        r2.setAlpha((float) 0.5);
                        r1.setAlpha((float) 0.5);
                        break;
                    case R.id.r12:
                        age = 12;
                        r2.setAlpha(1);
                        r1.setAlpha((float) 0.5);
                        r3.setAlpha((float) 0.5);
                        break;
                    case R.id.r18:
                        age = 18;
                        r1.setAlpha(1);
                        r2.setAlpha((float) 0.5);
                        r3.setAlpha((float) 0.5);
                        break;
                    case R.id.save_btn:
                        //заполнить currentGame (new Game (String title, String description, Integer players, Integer price, Integer age))
                        //собрать инфу со всех полей в диалоге

                        //я тщетно пытался сделать так, чтобы, когда хоть одно поле было не заполнено, кнопка save была неактивна
                        //TextView text =(TextView) view.findViewById(R.id.dialog_name); //тут вместо name нужно было указать dialog name
                        if (name.getText().length() == 0 || price.getText().length() == 0 || desc.getText().length() == 0 || ages.getCheckedRadioButtonId() == -1) {

                            if (name.getText().length() == 0) { //идея с выключением кнопки была плохая, так что пусть кнопка нихуя не делает но подсвечивает поля красным

                                name.setBackgroundResource(R.color.colorPlsFillThisField);
                                //view.findViewById(R.id.save_btn).setEnabled(false);
                            }
                            if (price.getText().length() == 0) { //идея с выключением кнопки была плохая, так что пусть кнопка нихуя не делает но подсвечивает поля красным

                                price.setBackgroundResource(R.color.colorPlsFillThisField);
                                //view.findViewById(R.id.save_btn).setEnabled(false);
                            }
                            if (desc.getText().length() == 0) { //идея с выключением кнопки была плохая, так что пусть кнопка нихуя не делает но подсвечивает поля красным

                                desc.setBackgroundResource(R.color.colorPlsFillThisField);

                            }
                            if (ages.getCheckedRadioButtonId() == -1) { //идея с выключением кнопки была плохая, так что пусть кнопка нихуя не делает но подсвечивает поля красным
                                ages.setBackgroundResource(R.color.colorPlsFillThisField);

                            }

                        } else {
                            view.findViewById(R.id.dialog_name).setBackgroundResource(R.color.colorNormalTextEdit);
                            currentGame = new Game(name.getText().toString(), desc.getText().toString(), players.getProgress() + 1, Integer.valueOf(price.getText().toString()), age);

                            if (!AddOrEdit) {
                                games.add(currentGame);
                                cleanAll();
                                getDialog().dismiss();
                                listAdapter.notifyDataSetChanged();//dismiss закрывает диалог


                            } else {

                                games.set(index, currentGame);

                                getDialog().dismiss();
                                listAdapter.notifyDataSetChanged();
                            }
                        }
                }
            }


        };
        if (AddOrEdit) {
            setFields(index);
        }

        r1.setOnClickListener(onClickSave);
        r2.setOnClickListener(onClickSave);
        r3.setOnClickListener(onClickSave);


        v.findViewById(R.id.save_btn).setOnClickListener(onClickSave);

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

    public void setFields(int index) {
        Game game = games.get(index);
        players.setProgress(game.getPlayers() - 1);
        name.setText(game.getName());
        desc.setText(game.getDesc());
        price.setText(game.getPrice());
        age = game.getAge();
        RadioButton r;
        switch (game.getAge()) {
            case 6:
                r = (RadioButton) view.findViewById(R.id.r6);
                break;
            case 12:
                r = (RadioButton) view.findViewById(R.id.r12);
                break;
            case 18:
                r = (RadioButton) view.findViewById(R.id.r18);
                break;
            default:
                r = null;
        }
        r.setChecked(true);
        r.setAlpha(1);
    }

    void cleanAll() {
        this.players.setProgress(0);
        this.name.setText("");
        this.desc.setText("");
        this.price.setText("");
        this.ages.clearCheck();
        for (int i = 0; i < 3; i++) {
            ages.getChildAt(i).setAlpha((float) 0.5);
        }
        this.age = -1;
    }
}