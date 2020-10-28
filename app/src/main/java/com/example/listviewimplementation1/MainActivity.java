package com.example.listviewimplementation1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt;
        final EditText et;
        Button startbtn;
        TextView tv;
        bt = (Button) findViewById(R.id.btn1);
        et = (EditText) findViewById(R.id.et1);
        final ListView listView = findViewById(R.id.myListView);
        final ArrayList<String> friendArrayList = new ArrayList<String>();

        friendArrayList.add("Abdullah");
        friendArrayList.add("Azhar");
        friendArrayList.add("Babar");
        friendArrayList.add("Mushtaq");
        friendArrayList.add("Musa");
        friendArrayList.add("Salman");
        friendArrayList.add("Zahid");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,friendArrayList );
        listView.setAdapter(arrayAdapter);
        //////
        final String input = et.getText().toString();
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String input=et.getText().toString();
                friendArrayList.add(input);
                arrayAdapter.notifyDataSetChanged();
                //listView.setAdapter(arrayAdapter);
            }
        });
/////
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i("You clicked the name of", friendArrayList.get(i));
                Toast.makeText(getApplicationContext(),friendArrayList.get(i), Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("mylist",friendArrayList.get(i));
                //intent.putStringArrayListExtra("mylist",friendArrayList);
                startActivity(intent);
            }

        });
    }
}
