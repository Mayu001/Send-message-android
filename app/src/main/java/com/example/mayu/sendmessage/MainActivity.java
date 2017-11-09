package com.example.mayu.sendmessage;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText phonetx;
    private EditText messagetx;
    private Button sendButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phonetx=(EditText)findViewById(R.id.phone);
        messagetx=(EditText)findViewById(R.id.messageToSend);
        sendButton=(Button)findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message=messagetx.getText().toString();
                String contact=phonetx.getText().toString();
                try {
                    Uri uri = Uri.parse("smsto:" +contact);// No permisison needed
                    Intent smsIntent = new Intent(Intent.ACTION_SENDTO, uri);// Set the message to be sent to the contacted person
                    smsIntent.putExtra("sms_body", message);
                    startActivity(smsIntent);
                }
                catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "SMS faild, please try again!", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
    }
}
