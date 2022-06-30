package com.example.cs478uic;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    EditText InputBox;
    String inputName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("Input");
        InputBox = findViewById(R.id.InputBox);
        InputBox.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                nameCheck();
                return true;
            }
        });
    }

    public void nameCheck(){
        inputName =  InputBox.getText().toString().trim();
        int len = inputName.length();
        for(int i = 0; i<len; i++)
        {
            if(Character.isDigit(inputName.charAt(i)))
            {
                Intent intent1 = new Intent(MainActivity2.this, MainActivity.class);
                intent1.putExtra("input", inputName);
                setResult(RESULT_CANCELED, intent1);
                finish();
            }
        }
        String[] nameArr = inputName.split(" ");
        if (nameArr.length < 2) {
            Intent intent1 = new Intent(MainActivity2.this, MainActivity.class);
            intent1.putExtra("input", inputName);
            setResult(RESULT_CANCELED, intent1);
            finish();
        } else if(nameArr.length > 1) {
            Intent intent1 = new Intent(MainActivity2.this, MainActivity.class);
            intent1.putExtra("input", inputName);
            setResult(RESULT_OK, intent1);
            finish();
        }
    }
}