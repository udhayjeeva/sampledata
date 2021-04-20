package com.uk.sampledata;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import static android.content.ContentValues.TAG;

public class FireBaseInstant extends FirebaseMessagingService {

    Context context;
    @Override
    public void onNewToken(String s) {
        context=this;

        super.onNewToken(s);
        Log.e("newToken---", s);
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();

        Log.e("newToken--", refreshedToken);
       // sendRegistrationToServer(refreshedToken);

    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        /*Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());

            if (*//* Check if data needs to be processed by long running job *//* true) {
                // For long-running tasks (10 seconds or more) use Firebase Job Dispatcher.
              //  scheduleJob();
            } else {
                // Handle message within 10 seconds
               // handleNow();
            }

        }
*/
        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        // Also if you intend on generating your own notifications as a result of a received FCM


        if(remoteMessage.getData().size() > 0){
            //handle the data message here
        }

        //getting the title and the body
        String title = remoteMessage.getNotification().getTitle();
        String body = remoteMessage.getNotification().getBody();




        Intent intent=new Intent(this,FirebaseMessage.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        Constants.showAlertDialog(context,"Allied Motors","Thanks for Choosing Allied Motors");
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT);
        NotificationCompat.Builder notifbuil=new NotificationCompat.Builder(this);
        notifbuil.setContentTitle(title);
        notifbuil.setContentText(body);
        notifbuil.setAutoCancel(true);
        notifbuil.setSmallIcon(R.drawable.icgps);
        notifbuil.setContentIntent(pendingIntent);

        //then here we can use the title and body to build a notification
    }



}
