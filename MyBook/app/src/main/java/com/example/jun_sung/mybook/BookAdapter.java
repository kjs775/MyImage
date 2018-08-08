package com.example.jun_sung.mybook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BookAdapter extends BaseAdapter {
    List<Book> data;
    Context context;
    LayoutInflater layoutInflater;

    BookAdapter(Context context, List<Book>data){
        this.context = context;
        this.data = data;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        //View examLayout = layoutInflater.inflate(R.layout.activity_exam, null);

        ViewHolder viewHolder = null;

        View examLayout = view;
        if(examLayout == null) {
            examLayout = layoutInflater.inflate(R.layout.book_info, null);

            viewHolder = new ViewHolder();

            viewHolder.title = (TextView) examLayout.findViewById(R.id.tvTitle);
            viewHolder.writer = (TextView)examLayout.findViewById(R.id.tvWriter);
            examLayout.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)examLayout.getTag();
        }

        //findViewById()에서 검색된(생성된) View를 ViewHodler에 저장할거임.
        //ViewHilder 저장된 View를 참조.

        viewHolder.writer.setText(data.get(i).getWriter());
        viewHolder.title.setText(data.get(i).getTitle());

        return examLayout;
    }

    class ViewHolder{
        TextView title;
        TextView writer;
    }
}
