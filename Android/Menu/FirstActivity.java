package com.example.administrator.housework2;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class FirstActivity extends AppCompatActivity {
    final static int CONTEXT_MENU_1 = Menu.FIRST;
    final static int CONTEXT_MENU_2 = Menu.FIRST+1;
    final static int CONTEXT_MENU_3 = Menu.FIRST+2;
    final static int CONTEXT_MENU_4 = Menu.FIRST+3;
    final static int CONTEXT_MENU_5 = Menu.FIRST+4;
    int color;
    TextView textview = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        textview = (TextView)findViewById(R.id.textview);
        textview.setText("改变字体颜色,学号:16060616106,姓名:孙世豪");
        textview.setTextSize(16f);
        registerForContextMenu(textview);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        menu.setHeaderTitle("改变字体颜色");
        menu.add(0, CONTEXT_MENU_1, 0,"红色");
        menu.add(0, CONTEXT_MENU_2, 1,"橙色");
        menu.add(0, CONTEXT_MENU_3, 2,"黄色");
        menu.add(0, CONTEXT_MENU_4, 2,"绿色");
        menu.add(0, CONTEXT_MENU_5, 2,"紫色");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case CONTEXT_MENU_1:
                textview.setTextColor(Color.RED);
                return true;
            case CONTEXT_MENU_2:
                color = getResources().getColor(R.color.orange);
                textview.setTextColor(color);
                return true;
            case CONTEXT_MENU_3:
                textview.setTextColor(Color.YELLOW);
                return true;
            case CONTEXT_MENU_4:
                textview.setTextColor(Color.GREEN);
                return true;
            case CONTEXT_MENU_5:
                color = getResources().getColor(R.color.purple);
                textview.setTextColor(color);
        }
        return false;
    }
}