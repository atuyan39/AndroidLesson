package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Lesson3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson3);

        // Viewを取得
        ListView listView = findViewById(R.id.lesson3_list_view);

        // Adapterを作成する//////////////////////////////////////////////////////////
        // 方法1 : 表示するリストを動的に作成
        List<String> listItems = new ArrayList<>();
        listItems.add("月曜日");
        listItems.add("火曜日");
        listItems.add("水曜日");
        ListAdapter adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);

        // 方法2 : 表示するリストを静的に作成
        ListAdapter adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.week));

        // 方法3 : 方法2の別の方法。Resourceからの参照する際に使える。
        ListAdapter adapter3 = ArrayAdapter.createFromResource(this, R.array.week, android.R.layout.simple_list_item_1);
        ////////////////////////////////////////////////////////////////////////////

        // ListItemが押下された時の処理を追加する
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                Toast.makeText(Lesson3Activity.this, textView.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        // 作成したAdapterをListViewに表示
        listView.setAdapter(adapter1);
    }
}