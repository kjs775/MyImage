package com.example.jun_sung.mybook;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddBookFrag extends Fragment {
    EditText etTitle, etWriter, etContent;
    Button btnSave;
    SQLiteDatabase db;
    public static final String DB_NAME = "book_db";
    public static final String TABLE = "book_tb";

    public AddBookFrag(){
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_add_book, container, false);
        final Context context = v.getContext();

        etTitle = (EditText)v.findViewById(R.id.etTitle);
        etWriter = (EditText)v.findViewById(R.id.etWriter);
        etContent = (EditText)v.findViewById(R.id.etContent);
        btnSave = (Button)v.findViewById(R.id.btnSave);
        db = getContext().openOrCreateDatabase(DB_NAME, context.MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE + "("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "title TEXT,"
                + "writer TEXT,"
                +"content TEXT);");

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = etTitle.getText().toString();
                String writer = etWriter.getText().toString();
                String content = etContent.getText().toString();
                if(title == null || title.isEmpty()){
                    Toast.makeText(context,"제목을 입력하세요",Toast.LENGTH_LONG).show();
                }else if(writer == null || writer.isEmpty()){
                    Toast.makeText(context,"저자을 입력하세요",Toast.LENGTH_LONG).show();
                }else if(content == null || content.isEmpty()){
                    Toast.makeText(context,"내용을 입력하세요",Toast.LENGTH_LONG).show();
                }else{
                    int res = insertData(etTitle.getText().toString(), etWriter.getText().toString(), etContent.getText().toString());
                    if(res == 1){
                        Toast.makeText(context,"데이터베이스에 저장되었습니다.",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(context,"데이터베이스 연결하세요.",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        return v;
    }
    private int insertData(String title, String writer, String content){
        if(db.isOpen()){
            String sql = "INSERT INTO " + TABLE + "(title, writer, content) VALUES (?,?,?)";
            String[] args = {title, writer, content};
            db.execSQL(sql, args);
            return 1;
        }else{
            return 0;
        }

    }
}
