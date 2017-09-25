package com.example.janne.picasso;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadImage(View view){
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        EditText imageName = (EditText) findViewById(R.id.editText);
        String imageURL = "http://student.labranet.jamk.fi/~K1525/android-kuvat/" + imageName.getText().toString()  + ".jpg";
        Picasso.with(this).load(imageURL).into(imageView);
    }

}
