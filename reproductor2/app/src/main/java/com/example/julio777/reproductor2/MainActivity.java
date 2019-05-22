package com.example.julio777.reproductor2;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    int i = 0;
    int j=0;
    MediaPlayer song[] = new MediaPlayer[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        song[0] = MediaPlayer.create(MainActivity.this, R.raw.song);
        song[1] = MediaPlayer.create(MainActivity.this, R.raw.song2);
        song[2] = MediaPlayer.create(MainActivity.this, R.raw.song3);


        Button btnPlay = (Button) findViewById(R.id.btnPlay);
        Button btnPause = (Button) findViewById(R.id.btnPause);
        Button btnStop = (Button) findViewById(R.id.btnStop);
        Button btnNext = (Button) findViewById(R.id.btnNext);
        Button btnBack = (Button) findViewById(R.id.Back); 

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (song[i].isPlaying()) {
                    Toast mensaje = Toast.makeText(getApplicationContext(), "Reproduciendo", Toast.LENGTH_SHORT);
                    mensaje.show();
                } else {
                    song[i].start();
                    Toast mensaje = Toast.makeText(getApplicationContext(), "Pausado", Toast.LENGTH_SHORT);
                    mensaje.show();
                }
            }
        });

        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                song[i].pause();
                Toast mensaje = Toast.makeText(getApplicationContext(), "Pausado", Toast.LENGTH_SHORT);
                mensaje.show();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                song[i].stop();
                Toast mensaje = Toast.makeText(getApplicationContext(), "muerto", Toast.LENGTH_SHORT);
                mensaje.show();
                song[0] = MediaPlayer.create(MainActivity.this, R.raw.song);
                song[1] = MediaPlayer.create(MainActivity.this, R.raw.song2);
                song[2] = MediaPlayer.create(MainActivity.this, R.raw.song3);

            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i < song.length - 1) {
                    if (song[i].isPlaying()) {
                        song[i].stop();
                        i++;
                        song[i].start();
                    } else {
                        i++;
                    }
                } else {
                    Toast mensaje = Toast.makeText(getApplicationContext(), "muerto", Toast.LENGTH_SHORT);
                    mensaje.show();
                }
            }

        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( i >=  1) {

                    if (song[i].isPlaying()) {
                        song[i].stop();
                        song[0] = MediaPlayer.create(MainActivity.this, R.raw.song);
                        song[1] = MediaPlayer.create(MainActivity.this, R.raw.song2);
                        song[2] = MediaPlayer.create(MainActivity.this, R.raw.song3);
                        i--;
                        song[i].start();
                    } else {
                        i--;
                    }
                } else {
                    Toast mensaje = Toast.makeText(getApplicationContext(), "muerto", Toast.LENGTH_SHORT);
                    mensaje.show();
                }
            }

        });
    }
}
