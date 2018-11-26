package xatu.edu.cn.demo.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class HelloWorldActivity extends AppCompatActivity {
    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
        textView = (TextView)findViewById(R.id.textView1);
        textView.setText(R.string.text_name);
        editText =(EditText)findViewById(R.id.editText1);
    }
    public void onButtonClick(View v){

        textView.setText( editText.getText());
    }
}
