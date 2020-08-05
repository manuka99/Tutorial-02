package com.firstapp.tute2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openActivity2(View view){

        Intent i = new Intent(getApplication(), Activity2.class);
        // Intent i = new Intent(getApplicationContext(), Activity2.class);
        //Intent i = new Intent(this, Activity2.class);
        txt = findViewById(R.id.username);

       // i.putExtra("username", txt.getText().toString());

        //or

        Bundle bundle = new Bundle();
        bundle.putString("username", txt.getText().toString());
        i.putExtras(bundle);


        startActivity(i);

    }

    public void sendEmail(View view){

        Intent intent = new Intent(Intent.ACTION_SEND);
        Intent chooser;

        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"manukayasas9@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, new String("subject"));
        intent.putExtra(Intent.EXTRA_TEXT, new String("text"));
        //intent.setType("message/rfc822");
        intent.setType("text/plain");
        chooser = intent.createChooser(intent, "Send email test app");

        startActivity(chooser);

    }


}