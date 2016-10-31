package com.example.proriarty1.gamesapp;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by Proriarty1 on 30.10.2016.
 */
public class Dialog_add extends DialogFragment implements View.OnClickListener {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setTitle("Add");

        View v = inflater.inflate(R.layout.dialog_layout, null);


        return v;

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