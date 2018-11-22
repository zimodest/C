package com.example.administrator.jinworks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {
    Button bu11 ;
    EditText edittext1,edittext2;
    TextView textview1,textview2;
    String str1,str2,str3,str4,string;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        bu11= (Button)findViewById(R.id.Bu11);
        edittext1 = (EditText)findViewById(R.id.ev11);
        edittext2 = (EditText)findViewById(R.id.ev12);
        textview1 = (TextView)findViewById(R.id.tv11);
        textview2 = (TextView)findViewById(R.id.tv12);
        bu11.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {

                str1 = edittext1.getText().toString();
                str2 = edittext2.getText().toString();
                str3 = textview1.getText().toString();
                str4 = textview2.getText().toString();
                string = str3+str1 +"\n"+ str4+str2+"\n";
                Intent fintent = new Intent();
                fintent.setClass(FirstActivity.this, SecondActivity.class);
                fintent.putExtra("str",string);
                startActivity(fintent);
            }
        });
    }
}
