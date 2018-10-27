package com.example.administrator.jinworks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/10/25 0025.
 */

public class SecondActivity extends AppCompatActivity {
    Button bu21;
    EditText edittext21,edittext22,edittext23,edittext24;
    TextView textview21,textview22,textview23,textview24;
    String string2,str21,str22,str23,str24,str25,str26,str27,str28;
    String string;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        bu21 = (Button)findViewById(R.id.Bu21);
        edittext21 = (EditText)findViewById(R.id.ev21);
        edittext22 = (EditText)findViewById(R.id.ev22);
        edittext23 = (EditText)findViewById(R.id.ev23);
        edittext24 = (EditText)findViewById(R.id.ev24);

        textview21 = (TextView)findViewById(R.id.tv21);
        textview22 = (TextView)findViewById(R.id.tv22);
        textview23 = (TextView)findViewById(R.id.tv23);
        textview24 = (TextView)findViewById(R.id.tv24);
        str25 = textview21.getText().toString();
        str26 = textview22.getText().toString();
        str27 = textview23.getText().toString();
        str28 = textview24.getText().toString();

        Intent sintent = getIntent();
        Bundle bundles = sintent.getExtras();
        string = bundles.getString("str");
        //edittext21.setText(string);



        bu21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str21 = edittext21.getText().toString();
                str22 = edittext22.getText().toString();
                str23 = edittext23.getText().toString();
                str24 = edittext24.getText().toString();
                string2 = string  +str25+str21+ "\n" +str26+str22+ "\n" +str27+str23+ "\n" +str28+str24 ;

                Intent sintent = new Intent();
                sintent.setClass(SecondActivity.this, ThirdActivity.class);
                sintent.putExtra("str1",string2);
                startActivity(sintent);
            }
        });
    }
}
