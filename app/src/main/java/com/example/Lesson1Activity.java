package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lesson1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson1);

        // パーツのViewを取得
        TextView textView = findViewById(R.id.lesson1_text_view);
        Button button = findViewById(R.id.lesson1_button);

        // Buttonをクリックした際の処理を追加
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Buttonがクリックされると、View.OnClickListener#onClickが呼ばれる。
                // ボタン押下時の処理を追加
                textView.setText("Clickされたよ！！");
            }
        });
    }
}