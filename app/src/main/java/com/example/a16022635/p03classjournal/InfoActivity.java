package com.example.a16022635.p03classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {

    ListView lvInfo;
    Button btnInfo;
    Button btnAdd;
    Button btnEmail;
    ArrayAdapter aa;
    ArrayList<Info> info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        info = new ArrayList<Info>();
        lvInfo = (ListView) this.findViewById(R.id.lvInfo);
        btnInfo = (Button) findViewById(R.id.btnInfo);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnEmail = (Button) findViewById(R.id.btnEmail);

        Intent i = getIntent();
        String code = i.getStringExtra("code");
        getSupportActionBar().setTitle("Info for " + code);

        if (code.equalsIgnoreCase("C347")){
            info.add(new Info("B"));
            info.add(new Info("C"));
            info.add(new Info("A"));

        }
        aa = new InfoAdapter(this, R.layout.row, info);
        lvInfo.setAdapter(aa);
    }
}
