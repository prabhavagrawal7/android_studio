package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    //        Player Representation
//         0 - X
//         1 - o
    int activeplayer = 0;
    boolean gametrigger = false;
    int gamestate[] = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    //        State Meanings
//        0 - X
//        1 - O
//        2 - Null
    int[][] winpositions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},//horizontal positions
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},//vertical positions
            {0, 4, 8}, {2, 4, 6}};          //cross positions


    public void reset(View view) {
        //Button Visibility over
        Button button = (Button)findViewById(R.id.button);
        button.setVisibility(View.INVISIBLE);
        //Text Visibility over
        TextView text = (TextView)findViewById(R.id.resulttext);
        text.setVisibility(View.INVISIBLE);
        TextView text1 = (TextView)findViewById(R.id.noone);
        text1.setVisibility(View.INVISIBLE);

        gametrigger = false;
        activeplayer = 0;


        for (int i = 0; i < 9; i++) {
            gamestate[i] = 2;
        }
        //Image Visibility over
        ImageView resultimage = (ImageView) findViewById(R.id.resetImage);
        resultimage.setVisibility(View.INVISIBLE);
        ImageView img0 = (ImageView) findViewById(R.id.imageView0);
        img0.setImageDrawable(null);
        ImageView img1 = (ImageView) findViewById(R.id.imageView1);
            img1.setImageDrawable(null);
        ImageView img2 = (ImageView) findViewById(R.id.imageView2);
        img2.setImageDrawable(null);
        ImageView img3 = (ImageView) findViewById(R.id.imageView3);
        img3.setImageDrawable(null);
        ImageView img4 = (ImageView) findViewById(R.id.imageView4);
        img4.setImageDrawable(null);
        ImageView img5 = (ImageView) findViewById(R.id.imageView5);
        img5.setImageDrawable(null);
        ImageView img6 = (ImageView) findViewById(R.id.imageView6);
        img6.setImageDrawable(null);
        ImageView img7 = (ImageView) findViewById(R.id.imageView7);
        img7.setImageDrawable(null);
        ImageView img8 = (ImageView) findViewById(R.id.imageView8);
        img8.setImageDrawable(null);

    }

    public int playerTap(View view) {

        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(gametrigger){
            return 0;
        }
        if (gamestate[tappedImage] == 2) {
            gamestate[tappedImage] = activeplayer;
//            img.setTranslationY(-1000f);
//            img.setTranslationX(-1000f);
            if (activeplayer == 0) {
                img.setImageResource(R.drawable.x);
                activeplayer = 1;
            } else {
                img.setImageResource(R.drawable.o);
                activeplayer = 0;
            }
//            img.animate().translationYBy(1000f).setDuration(300);
//            img.animate().translationXBy(1000f).setDuration(100);
        }

        //Logic for win
        //gameover = 0 as initial value
        //gameover = 1 if game didn't ended
        //gameover = 2 if game ended and someone win's
        int gameover = 0;
        for (int i = 0; i < 9; i++) {
            if (gamestate[i] == 2) {
                gameover = 1;
            }
        }

        for (int i = 0; i < winpositions.length; i++) {
            if (gamestate[winpositions[i][0]] == gamestate[winpositions[i][1]] && gamestate[winpositions[i][1]] == gamestate[winpositions[i][2]] && (gamestate[winpositions[i][0]] == 0 || gamestate[winpositions[i][0]] == 1)) {
                gameover = 2;
            }

        }   //code for changing gameover to 2

        if (gameover == 2 || gameover == 0) {

            ImageView resetimage = (ImageView) findViewById(R.id.resetImage);

            if (activeplayer == 0 && gameover == 2) {
                //0 wins
                resetimage.setVisibility(View.VISIBLE);
                resetimage.setImageResource(R.drawable.o);
            }
            else if (activeplayer == 1 && gameover == 2){
                //X wins
                resetimage.setVisibility(View.VISIBLE);
                resetimage.setImageResource(R.drawable.x);
            }
            else{
                TextView text = (TextView)findViewById(R.id.noone);
                text.setVisibility(View.VISIBLE);
            }
            Button b = (Button)findViewById(R.id.button);
            b.setVisibility(View.VISIBLE);
            b.setText("Play Again");
            TextView text = (TextView)findViewById(R.id.resulttext);
            text.setVisibility(View.VISIBLE);
            gametrigger = true;

        }
    return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}