package com.example.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView diceImg1 = findViewById(R.id.diceImage1);
        final ImageView diceImg2 = findViewById(R.id.diceImage2);

        final int [] diceImages = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

        Button btnRoll = findViewById(R.id.btnRollTheDice);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random rndObject = new Random();
                int myRandomNumber = rndObject.nextInt(6); // 0..5
                int myRandomNumber2 = rndObject.nextInt(6);
                Log.i("MyDiceApp", myRandomNumber + "");

                diceImg1.setImageResource(diceImages[myRandomNumber]);
                diceImg2.setImageResource(diceImages[myRandomNumber2]);

                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(findViewById(R.id.diceImage1));

                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(findViewById(R.id.diceImage2));

                mp.start();

            }
        });
    }
}
