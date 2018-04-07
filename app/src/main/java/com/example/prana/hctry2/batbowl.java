package com.example.prana.hctry2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class batbowl extends AppCompatActivity {
    Button bats,bowls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batbowl);
        bats=(Button)findViewById(R.id.bat);
        bowls=(Button)findViewById(R.id.bowl);
        bats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(batbowl.this,MainActivity.class);
                i.putExtra("choice","Bat");
                i.putExtra("tosswinner","Player");
                startActivity(i);

            }
        });
        bowls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(batbowl.this,MainActivity.class);
                i.putExtra("choice","Bowl");
                i.putExtra("tosswinner","Player");
                startActivity(i);
            }
        });
    }
}
