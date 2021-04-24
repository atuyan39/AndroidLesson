package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Lesson2Activity extends AppCompatActivity {
    private final String TAG = "DEBUG_" + Lesson2Activity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2);

        // Viewを取得
        TextView textView = findViewById(R.id.lesson2_text_view);
        EditText editText = findViewById(R.id.lesson2_edit_text);
        Button button = findViewById(R.id.lesson2_button);

        // Button押下時の処理を追加
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Log出力
                Log.d(TAG, "input text:" + editText.getText());

                // TextViewに入力されたテキストを表示させる
                textView.setText(editText.getText());

                // Toast表示
                Toast.makeText(getApplicationContext(), editText.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}