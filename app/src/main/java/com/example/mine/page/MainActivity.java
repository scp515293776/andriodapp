package com.example.mine.page;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.mine.R;

public class MainActivity extends AppCompatActivity {
    private ImageButton LoginButton1;
    private Button LoginButton2;

    private View.OnClickListener login_On=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.login_img:
                    Intent intent=new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    break;
                case R.id.login_text:
                    Intent intent1=new Intent(MainActivity.this,LoginActivity.class);
                    startActivity(intent1);
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginButton1=(ImageButton)findViewById(R.id.login_img);
        LoginButton1.setOnClickListener(login_On);
        LoginButton2 = (Button) findViewById(R.id.login_text);
        LoginButton2.setOnClickListener(login_On);
    }
}
