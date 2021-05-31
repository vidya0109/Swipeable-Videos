package com.example.swipeablevideos;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Subscibed extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscibed);

        button = findViewById(R.id.btnSaveTask);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

             new SweetAlertDialog(Subscibed.this,SweetAlertDialog.SUCCESS_TYPE).setTitleText("Subscribed!").show();

            }
        });





    }
}