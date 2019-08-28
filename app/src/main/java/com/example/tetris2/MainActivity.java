package com.example.tetris2;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

    Game tetris;
    MediaPlayer song;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        song = MediaPlayer.create(MainActivity.this, R.raw.stayinalive);

        song.start();
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //setContentView(new Game(this));
        setContentView(R.layout.activity_main);

        tetris = (Game) findViewById(R.id.tetris);

        findViewById(R.id.right_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tetris.shiftRight();
            }
        });

        findViewById(R.id.left_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tetris.shiftLeft();
            }
        });

        findViewById(R.id.rotate_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tetris.rotate();

            }
        });

        findViewById(R.id.down_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tetris.Down();

            }
        });

       /* if(tetris.endgame()){
            System.out.println("END GAME");
            finish();

        }*/

    }
}