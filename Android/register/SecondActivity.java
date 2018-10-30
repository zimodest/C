package com.example.administrator.housework3;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity
{
    private ListView listView;
    private ArrayList<String> musicList = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        listView = (ListView)findViewById(R.id.listview);

        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(SecondActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else
        {
            getLocalMusic();
        }
        adapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1 , musicList);
        listView.setAdapter(adapter);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,  String[] permissions,  int[] grantResults)
    {
        switch (requestCode)
        {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {
                    getLocalMusic();
                } else
                {
                    Toast.makeText(this, "权限请求失败", Toast.LENGTH_SHORT).show();
                }

                break;
            default:
                break;
        }
    }

    private void getLocalMusic()
    {
        Cursor cursor = this.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
                , null, null, null, MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
        if (cursor.moveToFirst())
        {
            while (!cursor.isAfterLast())
            {
                if (cursor != null)
                {
                    String singerName = cursor.getString(cursor.getColumnIndexOrThrow((MediaStore.Audio.Media.ARTIST)));
                    String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
                    long size = cursor.getLong(cursor.getColumnIndex(MediaStore.Audio.Media.SIZE));

                    if (size > 1024 * 800)
                    {
                        String text = title + "  -----  " + singerName;
                        musicList.add(text);
                    }
                }
                cursor.moveToNext();
            }
        }
    }

}
