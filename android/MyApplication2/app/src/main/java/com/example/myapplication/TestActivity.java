package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TestActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button_back;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(this);
    }

    Handler handler = new Handler(new Handler.Callback(){
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            return false;
        }
    });


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_back:
                finish();
                break;
            default:break;
        }


    }
}
