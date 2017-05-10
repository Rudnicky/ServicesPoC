package com.example.arakjel.servicespoc.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.arakjel.servicespoc.R;
import com.example.arakjel.servicespoc.services.MyService;

public class MainActivity extends AppCompatActivity {

    private Button pushNewActivity;
    private Button startServiceButton;
    private Button stopServiceButton;
    private Button exitAppliactionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        listeners();
    }

    private void initialize() {
        pushNewActivity = (Button) findViewById(R.id.pushNewActivity);
        startServiceButton = (Button) findViewById(R.id.startServiceButton);
        stopServiceButton = (Button) findViewById(R.id.stopServiceButton);
        exitAppliactionButton = (Button) findViewById(R.id.exitAppliactionButton);
    }

    private void listeners() {
        pushNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        startServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService();
            }
        });

        stopServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService();
            }
        });

        exitAppliactionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void startService() {
        startService(new Intent(getBaseContext(), MyService.class));
    }

    public void stopService() {
        stopService(new Intent(getBaseContext(), MyService.class));
    }
}
