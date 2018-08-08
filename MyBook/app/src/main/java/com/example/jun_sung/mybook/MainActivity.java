package com.example.jun_sung.mybook;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.jun_sung.mybook.AddBookFrag;
import com.example.jun_sung.mybook.R;


public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    public static final String DB_NAME = "book_db";
    public static final String TABLE = "book_tb";

    Toolbar toolbar;
    AddBookFrag fragment1;
    BookListFrag fragment2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        db = openOrCreateDatabase(DB_NAME,MODE_PRIVATE,null);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        fragment1 = new AddBookFrag();
        fragment2 = new BookListFrag();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

        TabLayout tabs = (TabLayout)findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("입력"));
        tabs.addTab(tabs.newTab().setText("조회"));

        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("MainActivity", "선택된 탭 : " + position);

                Fragment selected = null;
                if(position ==0){
                    selected = fragment1;
                }else if(position ==1){
                    selected = fragment2;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });
    }
}
