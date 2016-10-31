package com.example.proriarty1.gamesapp;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.proriarty1.gamesapp.Models.Game;

/**
 * Created by Proriarty1 on 30.10.2016.
 */
public class Dialog_add extends DialogFragment implements View.OnClickListener {

boolean AddOrEdit; //0 for add, 1 for edit

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(AddOrEdit){
            getDialog().setTitle("Edit");
        }else{

        getDialog().setTitle("Add");}

        View v = inflater.inflate(R.layout.dialog_layout, null);


        return v;

    }

    public void setAddOrEdit(boolean bool){
        AddOrEdit=bool;
    }





    public void onClick(View v) {


    }




    public void onDismiss(DialogInterface dialog) {

        super.onDismiss(dialog);

    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);

    }
}