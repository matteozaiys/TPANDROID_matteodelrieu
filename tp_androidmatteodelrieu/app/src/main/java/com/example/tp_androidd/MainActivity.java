package com.example.tp_androidd;


import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.media.AudioManager;
import android.media.MediaPlayer;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    boolean a;

    Button bouton1, bouton2, bouton3;

    ImageView imagevoir;


    int images[] = {R.drawable.ziak, R.drawable.sch};
    int i = 1;


    MediaPlayer mySong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imagevoir = (ImageView) findViewById(R.id.image1);
        bouton1 = (Button) findViewById(R.id.button1);
        bouton2 = (Button) findViewById(R.id.button2);
        bouton3 = (Button) findViewById(R.id.button3);
        a = true;

        mySong = MediaPlayer.create(getApplicationContext(), R.raw.bruit);
        mySong.start();


        bouton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(a == true) {
                    bouton1.setBackgroundColor(Color.RED);
                    bouton2.setBackgroundColor(Color.RED);
                    bouton3.setBackgroundColor(Color.RED);
                    a = false;
                }
                else{
                    bouton1.setBackgroundColor(Color.BLUE);
                    bouton2.setBackgroundColor(Color.BLUE);
                    bouton3.setBackgroundColor(Color.BLUE);
                    a = true;
                }
                imagevoir.setImageResource(images[i]);
                i++;
                if(i == images.length)
                    i = 0;
            }
        });

        bouton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mySong.start();
            }
        });

        bouton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });

    }
}