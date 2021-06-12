package com.example;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.dialog.MyDialogFragment;

/**
 * ダイアログの作り方についてレッスン。
 */
public class Lesson5Activity extends AppCompatActivity implements MyDialogFragment.Callback {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson5);

        mTextView = findViewById(R.id.lesson5_text_view);
        Button button = findViewById(R.id.lesson5_button);

        button.setOnClickListener((l) -> onClick());
    }

    private void onClick() {
        MyDialogFragment dialog = new MyDialogFragment();
        dialog.show(getSupportFragmentManager(), MyDialogFragment.class.getSimpleName());
    }

    @Override
    public void onMyDialogSucceeded(@NonNull String successText) {
        mTextView.setText(successText);
    }

    @Override
    public void onMyDialogCancelled(@NonNull String cancelText) {
        mTextView.setText(cancelText);
    }
}