package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

//    private Button swichBtn, selectSceneBtn;
    private  Button button1,button2,button_handle_test,button_static_fragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        Log.d("MainActivity","onCreateView");
        return super.onCreateView(name, context, attrs);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this::onClick);
//        button1.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Log.d("MainActivity","button1 Click----zyh------");
//            }
//        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this::onClick);

//        button2.setOnClickListener(new View.OnClickListener(){
//            @Overrides
//            public void onClick(View v) {
//                Log.d("MainActivity","button2 Click----zyh------");
//            }
//        });

        button_handle_test = (Button) findViewById(R.id.bt_handle);
        button_handle_test.setOnClickListener(this::onClick);

        button_static_fragment = (Button) findViewById(R.id.bt_static_fragment);
        button_static_fragment.setOnClickListener(this::onClick);
    }



    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
                Log.d("MainActivity","button1 Click----zyh------");
                Intent intent = new Intent(this,TestActivity.class);
                startActivity(intent);
                break;
            case R.id.button2:
                ProgressDialog dialog = ProgressDialog.show(this,"提示","正在登入......",true,true,null);
                Log.d("MainActivity","button2 Click----zyh------");
                break;
            case R.id.bt_handle:
                startActivity(new Intent(this,HandleActivity.class));
                break;
            case R.id.bt_static_fragment:
                startActivity(new Intent(this,FragmentStaticActivity.class));
                break;
            default:break;
        }
    }


//    private void initview() {
//        Log.d("MainActivity","initview---------zyh");
//        button1 = (Button) findViewById(R.id.button1);
//    }
}