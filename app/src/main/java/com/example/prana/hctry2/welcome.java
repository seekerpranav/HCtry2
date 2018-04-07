package com.example.prana.hctry2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class welcome extends AppCompatActivity {
    Button plays1,plays2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        plays1=(Button) findViewById(R.id.button7);
        plays2=(Button)findViewById(R.id.button8);
        plays2.setVisibility(View.INVISIBLE);
        plays1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(welcome.this,toss.class));
            }
        });
        plays2.setEnabled(false);
    }
}
