package com.example.jun_sung.mybook;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BookListActivity extends FragmentActivity {
    private ListView listView = null;
    private List<Book> data = null;
    SQLiteDatabase db;
    public static final String DB_NAME = "book_db";
    public static final String TABLE = "book_tb";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        data = new ArrayList<>();
        db = openOrCreateDatabase(DB_NAME,MODE_PRIVATE,null);
        Cursor c = db.rawQuery("SELECT title, writer FROM "+TABLE, null);
        while(c.moveToNext()){
            Book book = new Book();
            book.setTitle(c.getString(0));
            book.setWriter(c.getString(1));
            data.add(book);
        }

        BookAdapter adapter = new BookAdapter(this, data);
        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}
