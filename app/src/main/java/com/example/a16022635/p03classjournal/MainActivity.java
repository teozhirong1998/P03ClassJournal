package com.example.a16022635.p03classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.zip.InflaterOutputStream;

public class MainActivity extends AppCompatActivity {

    ListView lvModules;
    ArrayAdapter aa;
    ArrayList<Module> module;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvModules = (ListView) this.findViewById(R.id.lvModules);

        module = new ArrayList<Module>();
        module.add(new Module("C302","Web Services"));
        module.add(new Module("C347","Android Programming II"));

        aa = new CustomAdapter(this, R.layout.rowmain, module);
        lvModules.setAdapter(aa);

        lvModules.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String code = module.get(position).getModuleCode();
                Intent i = new Intent(MainActivity.this, InfoActivity.class);
                i.putExtra("code", code);

                startActivity(i);
            }
        });

    }
}
