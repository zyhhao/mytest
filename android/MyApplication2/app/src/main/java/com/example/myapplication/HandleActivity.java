package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class HandleActivity extends AppCompatActivity {
    public static final int UPDATE = 0X01;
    TextView tv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle);

        tv = (TextView) findViewById(R.id.tv_time);
        begin();
    }

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            switch (msg.what)
            {
                case UPDATE:
                    tv.setText(String.valueOf(msg.arg1));
                    break;
                default:break;
            }
            return false;
        }
    });


    public void begin(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=5; i>0; i--){
                    Message msg = new Message();
                    msg.what = UPDATE;
                    msg.arg1 = i;
                    handler.sendMessage(msg);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                startActivity(new Intent(HandleActivity.this,TestActivity.class));
                finish();
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("HandleActivity","destory");
    }
}
