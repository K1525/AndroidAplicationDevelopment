package com.example.janne.launchmap;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showMap(View view) {
        // get lat and lng values
        EditText Longitude = (EditText) findViewById(R.id.longitude);
        EditText Latitude = (EditText) findViewById(R.id.latitude);
        String numberOne = Longitude.getText().toString();
        String numberTwo = Latitude.getText().toString();
        double lng = Double.parseDouble(numberOne);
        double lat = Double.parseDouble(numberTwo);
        // show map
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:"+lat+","+lng));
        startActivity(intent);
    }
}
