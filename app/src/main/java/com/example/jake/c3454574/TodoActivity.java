package com.example.jake.c3454574;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

public class TodoActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;
    String messageText;
    int position;

//code for the listView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        listView = findViewById(R.id.listView);
        arrayList = new ArrayList<>();
        arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(TodoActivity.this,EditFieldClass.class);
                intent.putExtra(IntentConstants.INTENT_MESSAGE_DATA, arrayList.get(position));
                intent.putExtra(IntentConstants.INTENT_ITEM_POSITION,position);
                startActivityForResult(intent,IntentConstants.INTENT_REQUEST_CODE_TWO);
            }
        });
    }
//on click code
    public void onClick(View v){
        Intent intent = new Intent();
        intent.setClass(TodoActivity.this,EditFieldClass.class);
        startActivityForResult(intent,IntentConstants.INTENT_REQUEST_CODE);
    }
//on activity result code
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data) {
        if (resultCode == IntentConstants.INTENT_REQUEST_CODE){
            messageText = data.getStringExtra(IntentConstants.INTENT_MESSAGE_FIELD);
            arrayList.add(messageText);
            arrayAdapter.notifyDataSetChanged();
        }
        else if(resultCode==IntentConstants.INTENT_REQUEST_CODE_TWO){
            messageText = data.getStringExtra(IntentConstants.INTENT_CHANGED_MESSAGE);
            position = data.getIntExtra(IntentConstants.INTENT_ITEM_POSITION,-1);
            arrayList.add(position,messageText);
            arrayList.remove(position);
            arrayAdapter.notifyDataSetChanged();
        }
    }
}
