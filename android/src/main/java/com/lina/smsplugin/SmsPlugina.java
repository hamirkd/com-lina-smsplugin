package com.lina.smsplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import com.getcapacitor.Plugin;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.JSObject;

@CapacitorPlugin(name = "SmsPlugin")
public class SmsPlugina extends Plugin {
    public static class SmsReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("android.provider.Telephony.SMS_RECEIVED".equals(intent.getAction())) {
                Bundle bundle = intent.getExtras();
                if (bundle != null) {
                    Object[] pdus = (Object[]) bundle.get("pdus");
                    if (pdus != null) {
                        for (Object pdu : pdus) {
                            SmsMessage sms = SmsMessage.createFromPdu((byte[]) pdu);
                            String sender = sms.getDisplayOriginatingAddress();
                            String messageBody = sms.getMessageBody();

                            JSObject data = new JSObject();
                            data.put("sender", sender);
                            data.put("message", messageBody);

                            // Émettez un événement vers le front-end
                            SmsPlugin plugin = new SmsPlugin();//SmsPlugin.this;
                            plugin.notifyListeners("onSmsReceived", data);
                        }
                    }
                }
            }
        }
    }
}
