 #pdusms

 ##Android app

 ###Sending data messages and text messages.

```xml
      <uses-permission android:name="android.permission.SEND_SMS"/>
      <uses-permission android:name="android.permission.READ_SMS"/>
      <uses-permission android:name="android.permission.RECEIVE_SMS"/>


      <receiver android:name=".receiver.DataSmsReceiver">
          <intent-filter>
              <action android:name="android.intent.action.DATA_SMS_RECEIVED" />
              <data android:scheme="sms"/>
              <data android:host="localhost"/>
              <data android:port="1002"/>
          </intent-filter>
      </receiver>
      <receiver android:name=".receiver.TextSmsReceiver">
          <intent-filter>
              <action android:name="android.provider.Telephony.SMS_RECEIVED" />
          </intent-filter>
      </receiver>

```