package com.example.jake.c3454574;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditMessageClass extends AppCompatActivity {
    String messageText;
    int position;
//edit text for renaming item code
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todolayout);
        Intent intent = getIntent();
        messageText = intent.getStringExtra(IntentConstants.INTENT_MESSAGE_DATA);
        position = intent.getIntExtra(IntentConstants.INTENT_ITEM_POSITION,-1);
        EditText messageData = findViewById(R.id.message);
        messageData.setText(messageText);
    }
//on save click code
    public void saveButtonClicked(View v){
        String changedMessage = ((EditText)findViewById(R.id.message)).getText().toString();
        Intent intent = new Intent();
        intent.putExtra(IntentConstants.INTENT_CHANGED_MESSAGE,changedMessage);
        intent.putExtra(IntentConstants.INTENT_ITEM_POSITION,position);
        setResult(IntentConstants.INTENT_RESULT_CODE_TWO,intent);
        finish();
    }
}
