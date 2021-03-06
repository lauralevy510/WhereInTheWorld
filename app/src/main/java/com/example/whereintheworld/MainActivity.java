package com.example.whereintheworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public Button toMapButton;
    public Button toSettingsButton;
    public Button toSummaryButton;

    public Button toastTestButton;

    private String preferenceToast ="err";
    private boolean[] prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_main);

        toMapButton = findViewById(R.id.toMapActivityButton);
        toMapButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent (getApplicationContext(),MapsActivity.class);
                //
                startActivity(intent);
            }
        });

        toSettingsButton = findViewById(R.id.toSettingsActivityButton);
        toSettingsButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent settingsIntent = new Intent (getApplicationContext(),SettingsActivity.class);
                //
                startActivity(settingsIntent);
            }
        });

        //this code takes the boolean array from the intent if you've gone from settings back to main
        Intent toMainIntent = getIntent();
        if(toMainIntent.getExtras()!=null){
            boolean[]preference = toMainIntent.getBooleanArrayExtra("preference");
            preferenceToast="";
            for(boolean item : preference){
                preferenceToast+=item;
                preferenceToast+="\n";
            }

        }

        toastTestButton = findViewById(R.id.toastTestButton);
        toastTestButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Toast.makeText(getApplicationContext(),
                        preferenceToast,
                        Toast.LENGTH_SHORT).show();

            }
        });

        toSummaryButton = findViewById(R.id.summaryButton);
        toSummaryButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent toSummaryIntent= new Intent(getApplicationContext(), SummaryActivity.class);
                startActivity(toSummaryIntent);

            }
        });


    }
}
