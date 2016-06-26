package com.sample.pdusms.app;

import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btnSendData = (Button) findViewById(R.id.btnSendData);
        final Button btnSendText = (Button) findViewById(R.id.btnSendText);
        final EditText edtPhoneNo = (EditText) findViewById(R.id.edtPhoneNo);
        final EditText edtContent = (EditText) findViewById(R.id.edtContent);
        btnSendData.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String phoneNo = edtPhoneNo.getText().toString();
                String message = edtContent.getText().toString();
                if (phoneNo.length() > 0 && message.length() > 0) {
                    sendDataSMS(phoneNo, message);
                } else {

                    Toast.makeText(getBaseContext(),
                            "Please enter both phone number and me ssage.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSendText.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String phoneNo = edtPhoneNo.getText().toString();
                String message = edtContent.getText().toString();
                if (phoneNo.length() > 0 && message.length() > 0) {
                    sendTextSMS(phoneNo, message);
                } else {

                    Toast.makeText(getBaseContext(),
                            "Please enter both phone number and me ssage.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void sendDataSMS(String phoneNumber, String message) {

        SmsManager sms = SmsManager.getDefault();
        short port = 1000;
        //PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this,
        //        MainActivity.class), 0);

        if (message.length() > 70) {
            ArrayList<String> msgs = sms.divideMessage(message); for (String msg : msgs) {
                sms.sendDataMessage(phoneNumber, null, port, msg.getBytes(), null, null);
            }
        } else {
            sms.sendDataMessage(phoneNumber, null, port, message.getBytes(), null, null);
        }


        //SmsManager smsm = SmsManager.getDefault();
        //short port = 1000;
        //PendingIntent pi = PendingIntent.getBroadcast(MainActivity.this, 0, new Intent(), 0);
        //smsm.sendDataMessage("13802882071", null, port, "test pdu message!".getBytes(), pi, null);
    }

    private void sendTextSMS(String phoneNumber, String message) {

        SmsManager sms = SmsManager.getDefault();

        //PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this,
        //        MainActivity.class), 0);

        if (message.length() > 70) {
            ArrayList<String> msgs = sms.divideMessage(message); for (String msg : msgs) {
                sms.sendTextMessage(phoneNumber, null, msg, null, null);
            }
        } else {
            sms.sendTextMessage(phoneNumber, null, message, null, null);
        }


        //SmsManager smsm = SmsManager.getDefault();
        //short port = 1000;
        //PendingIntent pi = PendingIntent.getBroadcast(MainActivity.this, 0, new Intent(), 0);
        //smsm.sendDataMessage("13802882071", null, port, "test pdu message!".getBytes(), pi, null);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
