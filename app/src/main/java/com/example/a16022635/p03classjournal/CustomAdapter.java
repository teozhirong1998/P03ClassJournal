package com.example.a16022635.p03classjournal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 16022916 on 30/4/2018.
 */

public class CustomAdapter extends ArrayAdapter<Module> {
    private ArrayList<Module> module;
    private Context context;
    private TextView tvModule;
    private TextView tvModuleName;

    public CustomAdapter(Context context, int resource, ArrayList<Module> objects){
            super(context, resource, objects);
            // Store the food that is passed to this adapter
            module = objects;
            // Store Context object as we would need to use it later
            this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.rowmain, parent, false);

        tvModule = rowView.findViewById(R.id.textViewModule);
        tvModuleName = rowView.findViewById(R.id.textViewName);


        Module currentInfo = module.get(position);

        tvModule.setText(currentInfo.getModuleCode());
        tvModuleName.setText(currentInfo.getModuleName());

        return rowView;
    }
}
