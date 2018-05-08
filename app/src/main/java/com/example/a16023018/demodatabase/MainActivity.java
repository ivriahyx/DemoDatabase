package com.example.a16023018.demodatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert, btnGetTasks;
    TextView tvResults;

    ListView lv;
    ArrayList<Task> al;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = (Button) findViewById(R.id.btnInsert);
        btnGetTasks = (Button) findViewById(R.id.btnGetTasks);
        tvResults = (TextView)  findViewById(R.id.tvResults);
        lv = (ListView) this.findViewById(R.id.lv);

        al = new ArrayList<Task>();
        aa = new TaskAdapter(this,R.layout.activity_row,al);
        btnInsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertTask("Submit RJ", "25 Apr 2016");
                db.close();
            }
        });
        btnGetTasks.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                ArrayList<Task> data = db.getTasks();
                db.close();

                String txt = "";
                for (int i = 0; i < data.size(); i++) {
                    Log.d("Database Content", i +". "+data.get(i).getId()+" "+data.get(i).getDescription()+" "+data.get(i).getDate());
                    txt += i + ". " + " Submit RJ \n";
                    al.add(new Task(data.get(i).getId(),data.get(i).getDescription(),data.get(i).getDate()));
                }
                tvResults.setText(txt);
                lv.setAdapter(aa);

                Log.d("Arraylist",""+al.get(1).getId()+" "+al.get(1).getDescription()+" "+al.get(1).getDate());
            }
        });


    }
}
