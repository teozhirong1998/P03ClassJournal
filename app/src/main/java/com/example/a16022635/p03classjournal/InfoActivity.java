package com.example.a16022635.p03classjournal;

import android.content.Intent;
import android.net.Uri;
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

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // Intent to display data
                Intent rpIntent = new Intent(Intent.ACTION_VIEW);
                // Set the URL to be used.
                rpIntent.setData(Uri.parse("http://www.rp.edu.sg"));
                startActivity(rpIntent);
            }
        });

        btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The action you want this intent to do;
                // ACTION_SEND is used to indicate sending text
                Intent email = new Intent(Intent.ACTION_SEND);
                // Put essentials like email address, subject & body text
                email.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{"jason_lim@rp.edu.sg"});
                email.putExtra(Intent.EXTRA_SUBJECT,
                        "My remarks");
                String inform="Hi faci,\n";
                inform+="I am...\n Please see my remarks so far, thank you!\n";
                for(int i=0;i<info.size();i++){
                   String week=String.valueOf(info.get(i).getWeek());
                   String grade=info.get(i).getGrade();
                   inform+="Week "+week+": DG: "+grade+"\n";
                }
                email.putExtra(Intent.EXTRA_TEXT,
                        inform);

                email.setType("message/rfc822");

                // createChooser shows user a list of app that can handle
                // this MIME type, which is, email
                startActivity(Intent.createChooser(email,
                        "Choose an Email client :"));





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
