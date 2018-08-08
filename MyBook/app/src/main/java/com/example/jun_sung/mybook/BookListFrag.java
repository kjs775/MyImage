package com.example.jun_sung.mybook;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class BookListFrag extends Fragment {
    private ListView listView = null;
    private List<Book> data = null;
    SQLiteDatabase db;
    public static final String DB_NAME = "book_db";
    public static final String TABLE = "book_tb";

    public BookListFrag() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_book_list, container, true);
        Context context = v.getContext();
        data = new ArrayList<>();
        db = getActivity().openOrCreateDatabase(DB_NAME,context.MODE_PRIVATE,null);
        Cursor c = db.rawQuery("SELECT title, writer FROM "+TABLE, null);
        while(c.moveToNext()){
            Book book = new Book();
            book.setTitle(c.getString(0));
            book.setWriter(c.getString(1));
            data.add(book);
        }

        BookAdapter adapter = new BookAdapter(context, data);
        listView = (ListView)v.findViewById(R.id.listView);
        listView.setAdapter(adapter);


        return listView;
    }

}
