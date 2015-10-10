package com.hashclones.calldetect1;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import java.lang.reflect.Method;

/**
 * Created by Dyso on 10/10/2015.
 */
public class CallReg extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent){
        // Load preferences
/*        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);*/
        TelephonyManager telephonyManager = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);

        if (telephonyManager.getCallState() == TelephonyManager.CALL_STATE_RINGING) {
            Bundle phoneinfo = intent.getExtras();
            String phoneno = phoneinfo.getString(telephonyManager.EXTRA_INCOMING_NUMBER);
            Toast.makeText(context, phoneno, Toast.LENGTH_SHORT).show();
            // Let the phone ring for a set delay
/*            try {
                Thread.sleep(Integer.parseInt(prefs.getString("delay", "5")) * 1000);
            } catch (InterruptedException e) {
                // We don't really care
            }*/

/*            Intent i = new Intent(context, MainActivity.class);
            i.putExtras(intent);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            i.setAction(Intent.ACTION_ANSWER);
            context.startActivity(i);*/


/*            Intent callIntent = new Intent(Intent.ACTION_ANSWER);
            callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(callIntent);*/


/*            try {
                Class c = Class.forName(telephonyManager.getClass().getName());
                Method m = c.getDeclaredMethod("getITelephony");
                m.setAccessible(true);
                //Object telephonyService = m.invoke(telephonyManager); // Get the internal ITelephony object

                ITelephony telephonyService = (ITelephony) m.invoke(telephonyManager);
*//*                c = Class.forName(telephonyService.getClass().getName()); // Get its class
                m = c.getDeclaredMethod("endCall"); // Get the "endCall()" method
                m.setAccessible(true); // Make it accessible
                m.invoke(telephonyService);*//* // invoke endCall()
                telephonyService = (ITelephony) m.invoke(telephonyManager);
                telephonyService.silenceRinger();
                telephonyService.answerRingingCall();
            }
            catch(Exception e){}*/
        }

        
/*        public void call() {
            Intent in = new Intent(intent.ACTION_ANSWER);
            try{
                startActivity(in);
            }
            catch (android.content.ActivityNotFoundException ex){
                Toast.makeText(getApplicationContext(),"yourActivity is not founded",Toast.LENGTH_SHORT).show();
            }
        }*/

    }

}
