package com.example.cs478uic;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button inputButton;
    Button ContactsButton;
    //Overriding is a feature that allows a subclass or child class to provide a specific implementation of a method that is already provided by one of its super-classes or parent classes
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Most importantly, here you will usually call setContentView(int) with a layout resource defining your UI, and using findViewById(int) to retrieve the widgets in that UI that you need to interact with programmatically.
        setContentView(R.layout.activity_main);
        setTitle("Main");
        inputButton = findViewById(R.id.InputPage);
        ContactsButton = findViewById(R.id.contactsPage);
        inputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondActivity();
            }
        });
//setOnClickListener takes View.OnClickListener as its parameter.
        ContactsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Please enter a name before proceeding", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void openSecondActivity(){
        Intent openInputPage = new Intent(MainActivity.this, MainActivity2.class);
        startActivityForResult(openInputPage, 100);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, final Intent data){
        super.onActivityResult(requestCode,resultCode,data);
                if(requestCode == 100){
                    if (resultCode == RESULT_OK) {
                        ContactsButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String userInput = data.getExtras().getString("input");
                                Intent contactIntent = new Intent(Intent.ACTION_INSERT, ContactsContract.Contacts.CONTENT_URI);
                                contactIntent.putExtra(ContactsContract.Intents.Insert.NAME, userInput);
                                startActivity(contactIntent);
                            }
                        });
                    } else {
                        for(int i = 0; i<data.getExtras().getString("input").length(); i++)
                        {
                            if(Character.isDigit(data.getExtras().getString("input").charAt(i))){
                                Toast.makeText(getApplicationContext(), "Invalid name, it contains a number: " + data.getExtras().getString("input"), Toast.LENGTH_LONG).show();
                            }
                        }
                        if(data.getExtras().getString("input").length() <= 0)
                        {
                            Toast.makeText(getApplicationContext(), "Invalid name, Please provide a legal name", Toast.LENGTH_LONG).show();
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Invalid name: " + data.getExtras().getString("input"), Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }


}
