package com.example.preet.manage_me;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
    Button mButton;
    EditText mEdit;
    TextView textView;
    Spinner sp;
    TextToSpeech t1;
    int i = 1;
    String lang0, lang1, lang2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //int i=0;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = new TextToSpeech(this, this);
        mEdit = (EditText) findViewById(R.id.editText);
        mButton = (Button) findViewById(R.id.button3);

        sp = (Spinner) findViewById(R.id.spinner);


        List<String> list = new ArrayList<String>();
        list.add("CANADA");
        list.add("ENGLISH UK");
        list.add("ENGLISH US");
        list.add("FRENCH");

        ArrayAdapter<String> data = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);

        data.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        sp.setAdapter(data);

      //  sp.setOnItemSelectedListener(new CustomOnItemSelectedListener());


        mButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                speech();




            }
        });


    }


    public void speech() {


        lang0 = sp.getSelectedItem().toString();
        if (lang0 == "CANADA") {
            //textView.setText("Please Enter the text in ENGLISH");
            t1.speak(mEdit.getText().toString(), TextToSpeech.QUEUE_FLUSH, null, null);
            t1.setLanguage(Locale.CANADA);


        } else if (lang0 == "FRENCH") {

            t1.speak(mEdit.getText().toString(), TextToSpeech.QUEUE_FLUSH, null, null);
            t1.setLanguage(Locale.FRENCH);


        } else if (lang0 == "ENGLISH UK") {
            // textView.setText("Please Enter the text in ENGLISH");
            t1.speak(mEdit.getText().toString(), TextToSpeech.QUEUE_FLUSH, null, null);
            t1.setLanguage(Locale.UK);

        } else if (lang0 == "ENGLISH US") {
            //  textView.setText("Please Enter the text in ENGLISH");
            t1.speak(mEdit.getText().toString(), TextToSpeech.QUEUE_FLUSH, null, null);
            t1.setLanguage(Locale.US);


        }

    }


    @Override
    public void onInit(int status) {

        Log.d("Speech", "OnInit - Status [" + status + "]");
        if (status == TextToSpeech.SUCCESS) {
            Log.d("Speech", "Success!");

        }




    }

}

