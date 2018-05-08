package com.example.a16023018.demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {

    private ArrayList<Task> task;
    private Context context;
    private TextView tvIndex,tvDesc,tvDate;

    public TaskAdapter(Context context, int resource, ArrayList<Task> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        task = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a rowSecond

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the rowSecond.xmll as the layout for the View object
        View rowView = inflater.inflate(R.layout.activity_row, parent, false);

        // Get the TextView object
        tvIndex = (TextView) rowView.findViewById(R.id.tv1);
        tvDesc = (TextView) rowView.findViewById(R.id.tv2);
        tvDate = (TextView) rowView.findViewById(R.id.tv3);

        Task current = task.get(position);

         // Set the TextView to show
        tvIndex.setText("" + current.getId());
        tvDesc.setText(current.getDescription());
        tvDate.setText(current.getDate());

        // Return the nicely done up View to the ListView
        return rowView;
    }
}

