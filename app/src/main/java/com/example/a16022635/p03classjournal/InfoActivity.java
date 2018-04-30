package com.example.a16022635.p03classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {

    int requestCodeForAdd = 1;

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
            info.add(new Info(1,"B"));
            info.add(new Info(2,"C"));
            info.add(new Info(3,"A"));

        }
        aa = new InfoAdapter(this, R.layout.row, info);
        lvInfo.setAdapter(aa);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int weekText = info.size()+1;
                Intent i = new Intent(InfoActivity.this,
                        AddInfo.class);
                // Put hero object in intent
                i.putExtra("week", weekText);
                startActivityForResult(i,requestCodeForAdd);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Only handle when 2nd activity closed normally
        //  and data contains something
        if(resultCode == RESULT_OK){
            if (data != null) {
                if(requestCode == requestCodeForAdd){
                // Get data passed back from 2nd activity
                int week = data.getIntExtra("week",0);
                String grade = data.getStringExtra("grade");
                // If it is activity started by clicking 				//  Superman, create corresponding String

                    info.add(new Info(week,grade));
                    aa.notifyDataSetChanged();
                }
            }
        }
    }
}
