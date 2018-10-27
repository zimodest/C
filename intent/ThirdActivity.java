package com.example.administrator.jinworks;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/10/25 0025.
 */

public class ThirdActivity extends AppCompatActivity {
    Button bu31;
    String string2;
    TextView textview;
    String UNIQUE_STRING = "com.example.administrator.jinworks";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        textview = (TextView)findViewById(R.id.tv31) ;
        bu31 = (Button)findViewById(R.id.Bu31);

        Intent sintent = getIntent();
        Bundle bundles = sintent.getExtras();
        string2 = bundles.getString("str1");
        textview.setText(string2);



        bu31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tintent = new Intent(UNIQUE_STRING);
                tintent.putExtra("key",string2);
                sendBroadcast(tintent);
            }
        });
    }
}
