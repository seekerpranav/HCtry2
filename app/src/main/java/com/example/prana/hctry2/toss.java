package com.example.prana.hctry2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class toss extends AppCompatActivity {
    Button h,t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toss);
        h=(Button)findViewById(R.id.hds);
        t=(Button)findViewById(R.id.tls);
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.setEnabled(false);
                int x;
                Random r=new Random();
                x=r.nextInt()%2;
                if(x==0) {
                    Toast.makeText(toss.this, "You Win the toss!", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(toss.this,batbowl.class);
                    //i.putExtra()
                    startActivity(i);
                }
                else {
                    Toast.makeText(toss.this, "You lose the toss.", Toast.LENGTH_SHORT).show();
                    Random random=new Random();
                    int y=random.nextInt()%2;
                    String choice;
                    if(y==0)
                        choice="Bat";
                    else
                        choice="Bowl";
                    Toast.makeText(toss.this,"CPU decides to "+choice,Toast.LENGTH_LONG).show();
                    Intent i=new Intent(toss.this,MainActivity.class);
                    i.putExtra("choice",choice);
                    i.putExtra("tosswinner","CPU");
                    startActivity(i);
                }


            }
        });
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                h.setEnabled(true);
                int x;
                Random r=new Random();
                x=r.nextInt()%2;
                if(x==0) {
                    Toast.makeText(toss.this, "You Win the toss!", Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(toss.this,batbowl.class);
                    //i.putExtra()
                    startActivity(i);
                }
                else {
                    Toast.makeText(toss.this, "You lose the toss.", Toast.LENGTH_SHORT).show();
                    Random random=new Random();
                    int y=random.nextInt()%2;
                    String choice;
                    if(y==0)
                        choice="Bat";
                    else
                        choice="Bowl";
                    Toast.makeText(toss.this,"CPU decides to "+choice,Toast.LENGTH_LONG).show();
                    Intent i=new Intent(toss.this,MainActivity.class);
                    i.putExtra("choice",choice);
                    i.putExtra("tosswinner","CPU");
                    startActivity(i);
                }
            }
        });
    }
}
