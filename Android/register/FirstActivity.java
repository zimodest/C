package com.example.administrator.housework3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {

    Button button;
    TextView textview;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        button = (Button)findViewById(R.id.button);
        textview = (TextView) findViewById(R.id.textview);
        button.setText("显示所有歌曲");
        textview.setText("学号：16060616106 姓名：孙世豪");
        textview.setTextSize(21f);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);

            }
        });
    }
}
