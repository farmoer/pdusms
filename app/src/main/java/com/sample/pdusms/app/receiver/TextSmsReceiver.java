package com.sample.pdusms.app.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by bijinlong on 6/26/16.
 */
public class TextSmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        SmsMessage[] msgs = null;
        String phone;
        String message;

        if(bundle != null){
            Object[] pdus = (Object[])bundle.get("pdus");
            msgs = new SmsMessage[pdus.length];
            for(int i = 0; i < msgs.length; i++){
                msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                phone = msgs[i].getOriginatingAddress();
                message = msgs[i].getMessageBody();
                Toast.makeText(context, "收到来自:\"" + phone + "\"的短信, 内容:" + message, Toast.LENGTH_LONG).show();
                //Log.i("resule","number->" + phone + ", message->" + message );
                //Toast.makeText(context, String.format("number:%1$, message:%2$",phone, message), Toast.LENGTH_SHORT).show();
            }


        }

    }
}