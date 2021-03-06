package com.example.janne.basicui2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // AutoCompleteTextView
        AutoCompleteTextView actv = (AutoCompleteTextView)
                findViewById(R.id.login); // add stings to control
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line,
                new String[]
                        {"Pasi","Juha","Kari","Jouni","Esa","Hannu"});
        actv.setAdapter(aa);

    }

    public void loginButtonClicked(View view) {
        AutoCompleteTextView field = (AutoCompleteTextView) findViewById(R.id.login);
        EditText field2 = (EditText) findViewById(R.id.password);
        // get login text
        String log = (String) field.getText().toString();
        String pass = (String) field2.getText().toString();

        String info = log + " " + pass;

        // toast message to screen
        Toast.makeText(getApplicationContext(), info,
                Toast.LENGTH_SHORT).show();
    }

}
