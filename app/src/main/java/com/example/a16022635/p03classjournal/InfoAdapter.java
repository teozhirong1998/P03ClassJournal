package com.example.a16022635.p03classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoAdapter extends ArrayAdapter<Info>  {
    private ArrayList<Info> info;
    private Context context;
    private TextView tvWeek;
    private TextView tvGrade;

    public InfoAdapter(Context context, int resource, ArrayList<Info> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        info = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvWeek = (TextView) rowView.findViewById(R.id.tvWeek);
        tvGrade = (TextView) rowView.findViewById(R.id.tvGrade);

        Info currentInfo = info.get(position);

        tvWeek.setText("Week " + (position + 1));

        tvGrade.setText(currentInfo.getGrade());

        return rowView;
    }
}
