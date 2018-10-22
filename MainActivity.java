package com.example.idtext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity
{
    private EditText nameEdit;
    private EditText idEdit;
    private Button checkButton;
    private TextView displayText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEdit = (EditText)findViewById(R.id.nameEdit);
        idEdit = (EditText)findViewById(R.id.idEdit);
        checkButton = (Button)findViewById(R.id.checkButton);
        displayText = (TextView)findViewById(R.id.displayText);


        checkButton.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                String name = nameEdit.getText().toString();
                String id = idEdit.getText().toString();
                if(CheckNameAndId(name , id))
                {
                    displayText.setText("您输入的身份证号正确！\n"
                            + name
                            + "\n" + "籍贯:" + GetLocalition(id) + " \n"
                            + "生日:" + GetBirthday(id) + " \n");

                }
                else
                {
                    displayText.setText("您输入的身份证号不正确！！！,请重新输入");
                }
            }
        });
    }

    private String GetBirthday(String id)
    {
        if( id.isEmpty() || id.length() != 18)
        {
            Toast.makeText(this, "输入的身份证号为空或有误", Toast.LENGTH_SHORT).show();
            return "";
        }else
        {

            return id.substring(6 , 10) + "年"
                    + id.substring(10 , 12) + "月"
                    + id.substring(12 , 14) + "日";
        }
    }

    private String GetLocalition(String id)
    {
        InputStream is = getResources().openRawResource(R.raw.native_place_comparison_table);
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(is, "gbk");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(inputStreamReader);

        String line;
        String idLocalition = id.substring(0 , 6);
        try {
            while ((line = reader.readLine()) != null) {

                if(line.split(":")[0].equals(idLocalition))
                {
                    return line.split(":")[1];
                }
                //Log.e("ad" , line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return "";
    }

    private boolean CheckNameAndId(String name, String id)
    {
        if(name.isEmpty() || id.isEmpty() || id.length() != 18)
        {
            Toast.makeText(this, "输入的姓名或身份证号为空", Toast.LENGTH_SHORT).show();
            return false;
        }
        int sum = 0;
        int[] numberArr = {7 , 9 , 10 , 5 , 8 , 4 , 2 , 1 , 6 , 3
                , 7 , 9 , 10 , 5 , 8 , 4 , 2};

        String[] mArr = {"1" , "0" , "X" , "9" , "8" , "7" , "6"
                , "5" , "4" , "3" , "2"};

        for(int i = 0 ; i < id.length() - 1;i++)
        {
            sum += numberArr[i] * Integer.parseInt(id.charAt(i) + "");
            Log.e("errot:" ,sum+"" );
        }
        int num = sum % 11;

        if(mArr[num].equals(id.charAt(id.length() - 1) + ""))
            return true;
        else
            return false;
    }
}
