package com.example.jun_sung.myimage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    int[] cImg = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8,R.drawable.a9, R.drawable.a10};

    int num = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnUp = (Button) findViewById(R.id.btnUp);
        Button btnNext = (Button) findViewById(R.id.btnNext);
        final ImageView img = (ImageView) findViewById(R.id.img);

        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getX() > view.getX() + view.getWidth() / 2) {
                    if (num < 9) {
                        num++;
                    } else {
                        num = 0;
                    }
                    img.setImageResource(cImg[num]);
                } else {
                    if (num > 0) {
                        num--;
                    } else {
                        num = 9;
                    }
                    img.setImageResource(cImg[num]);
                }
                return false;
            }


        });
    }
//
//        btnUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(num > 0) {
//                    num--;
//                }else{
//                    num = 9;
//                }
//                img.setImageResource(cImg[num]);
//            }
//        });
//
//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if(num < 9){
//                    num++;
//                }else{
//                    num = 0;
//                }
//                img.setImageResource(cImg[num]);
//            }
//        });


}

