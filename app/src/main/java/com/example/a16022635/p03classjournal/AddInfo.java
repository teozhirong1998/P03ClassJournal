package com.example.a16022635.p03classjournal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AddInfo extends AppCompatActivity {

    TextView tvWeek, btnAdding;
    RadioGroup rg;
    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info);

        Intent i = getIntent();
        int week = i.getIntExtra("week",0);

        rg = findViewById(R.id.radioGroup);
        btnAdding = findViewById(R.id.buttonAdding);
        tvWeek = findViewById(R.id.tvWeek);

        tvWeek.setText(String.valueOf(week));

        btnAdding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedButtonId = rg.getCheckedRadioButtonId();
                rb = findViewById(selectedButtonId);
                String rbText = rb.getText().toString();
                Intent i = new Intent();
                int wk = Integer.parseInt(tvWeek.getText().toString());
                i.putExtra("week",wk);
                i.putExtra("grade",rbText);
                setResult(RESULT_OK,i);
                finish();
            }
        });
    }
}
