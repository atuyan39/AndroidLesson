package com.example;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> lessons = new ArrayList<>(Arrays.asList(
            "Lesson 1", "Lesson 2", "Lesson 3", "Lesson 4", "Lesson 5"
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.main_list_view);

        // 案1
        List<String> listItems = new ArrayList<>();
        listItems.add("Lesson 1");
        listItems.add("Lesson 2");
        listItems.add("Lesson 3");
        listItems.add("Lesson 4");
        listItems.add("Lesson 5");
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
        // 案2
        // ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lessons);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (view instanceof TextView) {
                    startLessonActivity(((TextView) view).getText().toString());
                }
            }
        });
    }

    private void startLessonActivity(@Nullable String lesson) {
        if (TextUtils.isEmpty(lesson)) {
            return;
        }

        Intent intent = null;
        switch (lesson) {
            case "Lesson 1":
                intent = new Intent(this, Lesson1Activity.class);
                break;
            case "Lesson 2":
                intent = new Intent(this, Lesson2Activity.class);
                break;
            case "Lesson 3":
                intent = new Intent(this, Lesson3Activity.class);
                break;
            case "Lesson 4":
                intent = new Intent(this, Lesson4Activity.class);
                break;
            case "Lesson 5":
                intent = new Intent(this, Lesson5Activity.class);
                break;
            default:
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}