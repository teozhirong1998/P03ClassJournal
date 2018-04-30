package com.example.a16022635.p03classjournal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvModules;
    ArrayAdapter aa;
    ArrayList<String> module;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvModules = (ListView) this.findViewById(R.id.lvModules);

        module = new ArrayList<String>();
        module.add("C347");

        aa = new ArrayAdapter(this, android.R.layout.simple_list_item_1, module);
        lvModules.setAdapter(aa);

        lvModules.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }
}
