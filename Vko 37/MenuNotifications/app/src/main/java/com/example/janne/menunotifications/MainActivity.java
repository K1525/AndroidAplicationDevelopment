package com.example.janne.menunotifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public int notification_id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action1:
                // create a new notification
                Notification notificationPublic  = new Notification.Builder(this)
                        .setCategory(Notification.CATEGORY_MESSAGE)
                        .setContentTitle("Public Notification")
                        .setContentText("This is public notification!")
                        .setAutoCancel(true)
                        .setSmallIcon(R.drawable.freepik)
                        .setVisibility(Notification.VISIBILITY_PUBLIC).build();
                // connect notification manager
                NotificationManager notificationManagerPublic = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                // make a new notification with a new unique id
                notification_id++;
                notificationManagerPublic.notify(notification_id, notificationPublic);

                return true;
            case R.id.action2:
                // create a new notification
                Notification notificationPrivate  = new Notification.Builder(this)
                        .setCategory(Notification.CATEGORY_MESSAGE)
                        .setContentTitle("Private Notification")
                        .setContentText("This is private notification!")
                        .setAutoCancel(true)
                        .setSmallIcon(R.drawable.freepik)
                        .setVisibility(Notification.VISIBILITY_PRIVATE).build();
                // connect notification manager
                NotificationManager notificationManagerPrivate = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                // make a new notification with a new unique id
                notification_id++;
                notificationManagerPrivate.notify(notification_id, notificationPrivate);

                return true;
            case R.id.action3:
                // create a new notification
                Notification notificationSecret  = new Notification.Builder(this)
                        .setCategory(Notification.CATEGORY_MESSAGE)
                        .setContentTitle("Secret Notification")
                        .setContentText("This is secret notification!")
                        .setAutoCancel(true)
                        .setSmallIcon(R.drawable.freepik)
                        .setVisibility(Notification.VISIBILITY_SECRET).build();
                // connect notification manager
                NotificationManager notificationManagerSecret = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                // make a new notification with a new unique id
                notification_id++;
                notificationManagerSecret.notify(notification_id, notificationSecret);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
