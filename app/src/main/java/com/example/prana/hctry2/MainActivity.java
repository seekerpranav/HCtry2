package com.example.prana.hctry2;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b11;
    Player p1,p2;
    int innings,showout,show;
    String battingplayer,winner;
    int p1score,p2score;
    TextView scorecardp1,scorecardp2,scorecard1,scorecard2,currentp1,currentp2,currentchoice1,currentchoice2,commentary;
    ProgressBar progressBar;
    MyCountDownTimer myCountDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent prev=getIntent();
        String tosswinner=prev.getStringExtra("tosswinner");
        String choice=prev.getStringExtra("choice");
        innings=1;
        show=0;
        winner="NA";
        showout=1;
        scorecardp1=(TextView)findViewById(R.id.textView2);
        scorecardp2=(TextView)findViewById(R.id.textView3);
        scorecard1=(TextView)findViewById(R.id.textView4);
        scorecard2=(TextView)findViewById(R.id.textView5);
        currentp1=(TextView)findViewById(R.id.textView6);
        currentp2=(TextView)findViewById(R.id.textView7);
        currentchoice1=(TextView)findViewById(R.id.textView8);
        currentchoice2=(TextView)findViewById(R.id.textView9);
        commentary=(TextView)findViewById(R.id.textView10);
        p1=new Player("Player");
        p2=new Player(("CPU"));
        scorecardp1.setText(p1.name);
        scorecardp2.setText(p2.name);
        scorecard1.setText(Integer.toString(p1.score)+"/0");
        scorecard2.setText(Integer.toString(p2.score)+"/0");
        currentp1.setText(p1.name);
        currentp2.setText(p2.name);
        b11=(Button)findViewById(R.id.button11);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        b5=(Button)findViewById(R.id.button5);
        b6=(Button)findViewById(R.id.button6);
        b11.setEnabled(false);
        if(tosswinner.equals("Player")&&choice.equals("Bat"))
            battingplayer="p1";
        else if (tosswinner.equals("Player")&&choice.equals("Bowl"))
            battingplayer="p2";
        else if(tosswinner.equals("CPU")&&choice.equals("Bat"))
            battingplayer="p2";
        else if(tosswinner.equals("CPU")&&choice.equals("Bowl"))
            battingplayer="p1";
        progressBar=(ProgressBar)findViewById(R.id.progressbar);
        final Handler handler=new Handler();
        final Runnable r=new Runnable() {
            @Override
            public void run() {
                /*if(winner.equals("P1")||winner.equals("P2")){
                    myCountDownTimer.cancel();
                    Toast.makeText(MainActivity.this,"Winner is "+winner,Toast.LENGTH_LONG).show();
                    innings=9;
                }*/
                if(innings==1&&battingplayer.equals("p1"))
                {
                    scorecard1.setText(Integer.toString(p1.score)+"/0");
                    currentchoice1.setText(Integer.toString(p1score));
                    currentchoice2.setText(Integer.toString(p2score));
                    commentary.setText(Integer.toString(p1score)+" Run(s)!");
                    progressBar.setProgress(100);
                    b1.setEnabled(true);
                    b2.setEnabled(true);
                    b3.setEnabled(true);
                    b4.setEnabled(true);
                    b5.setEnabled(true);
                    b6.setEnabled(true);
                    myCountDownTimer.start();
                }
                else if(innings==1&&battingplayer.equals("p2")){
                    scorecard2.setText(Integer.toString(p2.score)+"/0");
                    currentchoice1.setText(Integer.toString(p1score));
                    currentchoice2.setText(Integer.toString(p2score));
                    commentary.setText(Integer.toString(p2score)+" Run(s)!");
                    progressBar.setProgress(100);

                    b1.setEnabled(true);
                    b2.setEnabled(true);
                    b3.setEnabled(true);
                    b4.setEnabled(true);
                    b5.setEnabled(true);
                    b6.setEnabled(true);
                    myCountDownTimer.start();
                }
                else if(innings==2&&battingplayer.equals("p1")&&showout==1){
                    scorecard1.setText(Integer.toString(p1.score)+"/1");
                    currentchoice1.setText(Integer.toString(p1score));
                    currentchoice2.setText(Integer.toString(p2score));
                    commentary.setText("Out!");
                    Toast.makeText(MainActivity.this,"You are now Bowling",Toast.LENGTH_LONG).show();
                    //myCountDownTimer.cancel();
                    battingplayer="p2";
                    showout=0;
                    show=1;
                    progressBar.setProgress(100);
                    //Toast.makeText(MainActivity.this,"You are now bowling",Toast.LENGTH_LONG).show();
                    b1.setEnabled(true);
                    b2.setEnabled(true);
                    b3.setEnabled(true);
                    b4.setEnabled(true);
                    b5.setEnabled(true);
                    b6.setEnabled(true);
                    myCountDownTimer.start();
                }
                else if(innings==2&&battingplayer.equals("p2")&&showout==1){
                    scorecard2.setText(Integer.toString(p2.score)+"/1");
                    currentchoice1.setText(Integer.toString(p1score));
                    currentchoice2.setText(Integer.toString(p2score));
                    commentary.setText("Out!");
                    Toast.makeText(MainActivity.this,"You are now Batting",Toast.LENGTH_LONG).show();
                    battingplayer="p1";
                    showout=0;
                    show=2;
                    progressBar.setProgress(100);
                    //Toast.makeText(MainActivity.this,"You are now bowling",Toast.LENGTH_LONG).show();
                    b1.setEnabled(true);
                    b2.setEnabled(true);
                    b3.setEnabled(true);
                    b4.setEnabled(true);
                    b5.setEnabled(true);
                    b6.setEnabled(true);
                    myCountDownTimer.start();
                    //myCountDownTimer.cancel();
                    /*battingplayer="p2";
                    finish=0;
                    progressBar.setProgress(100);
                    Toast.makeText(MainActivity.this,"You are now bowling",Toast.LENGTH_LONG).show();
                    b1.setEnabled(true);
                    b2.setEnabled(true);
                    b3.setEnabled(true);
                    b4.setEnabled(true);
                    b5.setEnabled(true);
                    b6.setEnabled(true);
                    myCountDownTimer.start();*/
                }
                else if(innings==2&&battingplayer.equals("p2")&&showout==0){
                    scorecard2.setText(Integer.toString(p2.score)+"/0");
                    currentchoice1.setText(Integer.toString(p1score));
                    currentchoice2.setText(Integer.toString(p2score));
                    commentary.setText(Integer.toString(p2score)+" Run(s)!");

                    show=1;
                    if(winner.equals("P1")){
                        Toast.makeText(MainActivity.this,"You Win!",Toast.LENGTH_LONG).show();
                        myCountDownTimer.cancel();
                        b11.setEnabled(true);
                        b11.setVisibility(View.VISIBLE);
                    }
                    else if(winner.equals("P2")){
                        Toast.makeText(MainActivity.this,"You Loose!",Toast.LENGTH_LONG).show();
                        myCountDownTimer.cancel();
                        b11.setEnabled(true);
                        b11.setVisibility(View.VISIBLE);
                    }
                    else {
                        progressBar.setProgress(100);
                        b1.setEnabled(true);
                        b2.setEnabled(true);
                        b3.setEnabled(true);
                        b4.setEnabled(true);
                        b5.setEnabled(true);
                        b6.setEnabled(true);
                        myCountDownTimer.start();
                    }
                }

                else if(innings==2&&battingplayer.equals("p1")&&showout==0){
                    scorecard1.setText(Integer.toString(p1.score)+"/0");
                    currentchoice1.setText(Integer.toString(p1score));
                    currentchoice2.setText(Integer.toString(p2score));
                    commentary.setText(Integer.toString(p1score)+" Run(s)!");
                    progressBar.setProgress(100);
                    show=2;
                    if(winner.equals("P1")){
                        Toast.makeText(MainActivity.this,"You Win!",Toast.LENGTH_LONG).show();
                        myCountDownTimer.cancel();
                        b11.setEnabled(true);
                        b11.setVisibility(View.VISIBLE);
                    }
                    else if(winner.equals("P2")){
                        Toast.makeText(MainActivity.this,"You Loose!",Toast.LENGTH_LONG).show();
                        myCountDownTimer.cancel();
                        b11.setEnabled(true);
                        b11.setVisibility(View.VISIBLE);
                    }
                    else {
                        b1.setEnabled(true);
                        b2.setEnabled(true);
                        b3.setEnabled(true);
                        b4.setEnabled(true);
                        b5.setEnabled(true);
                        b6.setEnabled(true);
                        myCountDownTimer.start();
                    }
                }
                else if(innings==3){
                    if(show==2){
                        scorecard1.setText(Integer.toString(p1.score)+"/1");
                        currentchoice1.setText(Integer.toString(p1score));
                        currentchoice2.setText(Integer.toString(p2score));
                        if(p1.score==p2.score){
                            Toast.makeText(MainActivity.this,"It's a draw!",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this,"You Lose!",Toast.LENGTH_LONG).show();
                        }
                        b11.setEnabled(true);
                        b11.setVisibility(View.VISIBLE);
                    }
                    else if(show==1){
                        scorecard2.setText(Integer.toString(p2.score)+"/1");
                        currentchoice1.setText(Integer.toString(p1score));
                        currentchoice2.setText(Integer.toString(p2score));
                        if(p1.score==p2.score){
                            Toast.makeText(MainActivity.this,"It's a draw!",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(MainActivity.this,"You Win" +
                                    "!",Toast.LENGTH_LONG).show();
                        }
                        b11.setEnabled(true);
                        b11.setVisibility(View.VISIBLE);
                    }
                    commentary.setText("Out!");
                    myCountDownTimer.cancel();
                }

            }
        };
        progressBar.setProgress(100);
        myCountDownTimer = new MyCountDownTimer(10000, 1);
        myCountDownTimer.start();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(battingplayer.equals("p1"))
                    p1score=1;
                else
                    p1score=1;
                while(true) {
                    Random random = new Random();
                    int temp = random.nextInt() % 7;
                    if(temp>0&&battingplayer.equals("p1")){
                        p2score=temp;
                        break;
                    }
                    else if(temp>0&&battingplayer.equals("p2")){
                        p2score=temp;
                        break;
                    }

                }
                if(p1score==p2score){
                    //Toast.makeText(MainActivity.this,"OUT",Toast.LENGTH_LONG).show();
                    innings=innings+1;
                }
                else if(battingplayer.equals("p1")){
                    p1.score=p1.score+p1score;
                    if(innings==2&&p1.score>p2.score) {
                        winner = "P1";
//                        Toast.makeText(MainActivity.this,"Changed winner to P1",Toast.LENGTH_LONG).show();
                    }
                    //Toast.makeText(MainActivity.this,"NOT OUT",Toast.LENGTH_LONG).show();
                }
                else if (battingplayer.equals("p2")){
                    p2.score=p2score+p2.score;
                    if(innings==2&&p2.score>p1.score) {
                        winner = "P2";
//                        Toast.makeText(MainActivity.this,"Changed winner to P2",Toast.LENGTH_LONG).show();
                    }
                }

                b2.setEnabled(false);
                b1.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                b5.setEnabled(false);
                b6.setEnabled(false);
                handler.postDelayed(r,200);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(battingplayer.equals("p1"))
                    p1score=2;
                else
                    p1score=2;
                while(true) {
                    Random random = new Random();
                    int temp = random.nextInt() % 7;
                    if(temp>0&&battingplayer.equals("p1")){
                        p2score=temp;
                        break;
                    }
                    else if(temp>0&&battingplayer.equals("p2")){
                        p2score=temp;
                        break;
                    }

                }
                if(p1score==p2score){
                    //Toast.makeText(MainActivity.this,"OUT",Toast.LENGTH_LONG).show();
                    innings+=1;
                }
                else if(battingplayer.equals("p1")){
                    p1.score=p1.score+p1score;
                    if(innings==2&&p1.score>p2.score) {
                        winner = "P1";
//                        Toast.makeText(MainActivity.this,"Changed winner to P1",Toast.LENGTH_LONG).show();
                    }
                    //Toast.makeText(MainActivity.this,"NOT OUT",Toast.LENGTH_LONG).show();
                }
                else if (battingplayer.equals("p2")){
                    p2.score=p2score+p2.score;
                    if(innings==2&&p2.score>p1.score) {
                        winner = "P2";
//                        Toast.makeText(MainActivity.this,"Changed winner to P2",Toast.LENGTH_LONG).show();
                    }
                }

                b2.setEnabled(false);
                b1.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                b5.setEnabled(false);
                b6.setEnabled(false);
                handler.postDelayed(r,200);
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(battingplayer.equals("p1"))
                    p1score=3;
                else
                    p1score=3;
                while(true) {
                    Random random = new Random();
                    int temp = random.nextInt() % 7;
                    if(temp>0&&battingplayer.equals("p1")){
                        p2score=temp;
                        break;
                    }
                    else if(temp>0&&battingplayer.equals("p2")){
                        p2score=temp;
                        break;
                    }

                }
                if(p1score==p2score){
                    //Toast.makeText(MainActivity.this,"OUT",Toast.LENGTH_LONG).show();
                    innings+=1;
                }
                else if(battingplayer.equals("p1")){
                    p1.score=p1.score+p1score;
                    if(innings==2&&p1.score>p2.score) {
                        winner = "P1";
//                        Toast.makeText(MainActivity.this,"Changed winner to P1",Toast.LENGTH_LONG).show();
                    }
                    //Toast.makeText(MainActivity.this,"NOT OUT",Toast.LENGTH_LONG).show();
                }
                else if (battingplayer.equals("p2")){
                    p2.score=p2score+p2.score;
                    if(innings==2&&p2.score>p1.score) {
                        winner = "P2";
//                        Toast.makeText(MainActivity.this,"Changed winner to P2",Toast.LENGTH_LONG).show();
                    }
                }

                b2.setEnabled(false);
                b1.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                b5.setEnabled(false);
                b6.setEnabled(false);
                handler.postDelayed(r,200);

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(battingplayer.equals("p1"))
                    p1score=4;
                else
                    p1score=4;
                while(true) {
                    Random random = new Random();
                    int temp = random.nextInt() % 7;
                    if(temp>0&&battingplayer.equals("p1")){
                        p2score=temp;
                        break;
                    }
                    else if(temp>0&&battingplayer.equals("p2")){
                        p2score=temp;
                        break;
                    }

                }
                if(p1score==p2score){
                    //Toast.makeText(MainActivity.this,"OUT",Toast.LENGTH_LONG).show();
                    innings+=1;
                }
                else if(battingplayer.equals("p1")){
                    p1.score=p1.score+p1score;
                    if(innings==2&&p1.score>p2.score) {
                        winner = "P1";
//                        Toast.makeText(MainActivity.this,"Changed winner to P1",Toast.LENGTH_LONG).show();
                    }
                    //Toast.makeText(MainActivity.this,"NOT OUT",Toast.LENGTH_LONG).show();
                }
                else if (battingplayer.equals("p2")){
                    p2.score=p2score+p2.score;
                    if(innings==2&&p2.score>p1.score) {
                        winner = "P2";
//                        Toast.makeText(MainActivity.this,"Changed winner to P2",Toast.LENGTH_LONG).show();
                    }
                }

                b2.setEnabled(false);
                b1.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                b5.setEnabled(false);
                b6.setEnabled(false);
                handler.postDelayed(r,200);

            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(battingplayer.equals("p1"))
                    p1score=5;
                else
                    p1score=5;
                while(true) {
                    Random random = new Random();
                    int temp = random.nextInt() % 7;
                    if(temp>0&&battingplayer.equals("p1")){
                        p2score=temp;
                        break;
                    }
                    else if(temp>0&&battingplayer.equals("p2")){
                        p2score=temp;
                        break;
                    }

                }
                if(p1score==p2score){
                    //Toast.makeText(MainActivity.this,"OUT",Toast.LENGTH_LONG).show();
                    innings+=1;
                }
                else if(battingplayer.equals("p1")){
                    p1.score=p1.score+p1score;
                    if(innings==2&&p1.score>p2.score) {
                        winner = "P1";
//                        Toast.makeText(MainActivity.this,"Changed winner to P1",Toast.LENGTH_LONG).show();
                    }
                    //Toast.makeText(MainActivity.this,"NOT OUT",Toast.LENGTH_LONG).show();
                }
                else if (battingplayer.equals("p2")){
                    p2.score=p2score+p2.score;
                    if(innings==2&&p2.score>p1.score) {
                        winner = "P2";
//                        Toast.makeText(MainActivity.this,"Changed winner to P2",Toast.LENGTH_LONG).show();
                    }
                }

                b2.setEnabled(false);
                b1.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                b5.setEnabled(false);
                b6.setEnabled(false);
                handler.postDelayed(r,200);

            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(battingplayer.equals("p1"))
                    p1score=6;
                else
                    p1score=6;
                while(true) {
                    Random random = new Random();
                    int temp = random.nextInt() % 7;
                    if(temp>0&&battingplayer.equals("p1")){
                        p2score=temp;
                        break;
                    }
                    else if(temp>0&&battingplayer.equals("p2")){
                        p2score=temp;
                        break;
                    }

                }
                if(p1score==p2score){
                    //Toast.makeText(MainActivity.this,"OUT",Toast.LENGTH_LONG).show();
                    innings+=1;
                }
                else if(battingplayer.equals("p1")){
                    p1.score=p1.score+p1score;
                    if(innings==2&&p1.score>p2.score) {
                        winner = "P1";
                        //Toast.makeText(MainActivity.this,"Changed winner to P1",Toast.LENGTH_LONG).show();
                    }
                    //Toast.makeText(MainActivity.this,"NOT OUT",Toast.LENGTH_LONG).show();
                }
                else if (battingplayer.equals("p2")){
                    p2.score=p2score+p2.score;
                    if(innings==2&&p2.score>p1.score) {
                        winner = "P2";
                        //Toast.makeText(MainActivity.this,"Changed winner to P2",Toast.LENGTH_LONG).show();
                    }
                }

                b2.setEnabled(false);
                b1.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                b5.setEnabled(false);
                b6.setEnabled(false);
                handler.postDelayed(r,200);

            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,welcome.class));
            }
        });

    }
    public class MyCountDownTimer extends CountDownTimer {

        /*final Handler handler=new Handler();
        final Runnable r=new Runnable() {
            @Override
            public void run() {
                progressBar.setProgress(100);
            }
        };*/
        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            //textCounter.setText(String.valueOf(millisUntilFinished));
            int progress = (int) (millisUntilFinished/100);
            progressBar.setProgress(progress);
        }

        @Override
        public void onFinish() {
            //textCounter.setText("Task completed");
//            handler.postDelayed(r,3000);


        }

    }
}
