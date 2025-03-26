package kr.ac.tukorea.ge.and.habin.cards;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Collections;
import java.util.Random;
/// control+art+o 누르면 안쓰는 헤더 지워줌

import java.util.Collections;

import kr.ac.tukorea.ge.and.habin.cards.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private @NonNull ActivityMainBinding binding;
    private ImageButton previousCardButton;
    private ImageButton[] cardImageButtons;
    private int[] cardResIds=new int[]{
            R.mipmap.ahri2,R.mipmap.ahri3,R.mipmap.ahri4,R.mipmap.ahri5,
            R.mipmap.ahri6,R.mipmap.ahri7,R.mipmap.ahri8,R.mipmap.ahri9,
            R.mipmap.ahri2,R.mipmap.ahri3,R.mipmap.ahri4,R.mipmap.ahri5,
            R.mipmap.ahri6,R.mipmap.ahri7,R.mipmap.ahri8,R.mipmap.ahri9
    };
private int flips;
    private int openCardCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        cardImageButtons =new ImageButton[]{
            binding.card00, binding.card01,binding.card02,binding.card03,
                binding.card10, binding.card11,binding.card12,binding.card13,
                binding.card20, binding.card21,binding.card22,binding.card23,
                binding.card30, binding.card31,binding.card32,binding.card33,
        };
        startGame();
    }



    private void startGame() {
        shuffleCards();
        for(int i=0;i<cardResIds.length;i++) {
            int resId = cardResIds[i];
            cardImageButtons[i].setVisibility(View.VISIBLE);
            cardImageButtons[i].setImageResource(R.mipmap.ahri1);
            cardImageButtons[i].setTag(resId);
        }
        setFlips(0);
        previousCardButton=null;
        openCardCount=cardResIds.length;

    }

    private void shuffleCards() {
        Random rand = new Random();
        for (int i = 0; i < cardResIds.length; i++) {
            int r = rand.nextInt(cardResIds.length);
            int resId = cardResIds[i];
            cardResIds[i] = cardResIds[r];
            cardResIds[r] = resId;
        }
    }
    public void setFlips(int flips) {
        this.flips = flips;
        String text = String.format("Flips: %d", flips);
        binding.scoreTextView.setText(text);
    }

    public void OnButtonCard(View view) {
        int previousResourceId=0;

        if(previousCardButton!=null){
            previousCardButton.setImageResource(R.mipmap.ahri1);
            previousResourceId=(Integer)previousCardButton.getTag();
        }
        ImageButton btn = (ImageButton) view;
        if(btn=previousCardButton){
            Toast.makeText(this,R.string)
        }
        int resId=(Integer)btn.getTag();
        btn.setImageResource(resId);
        setFlips(flips+1);

        if(previousResourceId==resId){
            previousCardButton.setVisibility(View.INVISIBLE);
            btn.setVisibility(View.INVISIBLE);
            previousCardButton=null;

            openCardCount-=2;
            if(openCardCount==0){
                askRestart();
            }

        }else{
            previousCardButton=btn;
        }
        previousCardButton = btn;

    }

    public void onBtnRestart(View view) {
        askRestart();
    }

    private void askRestart() {
        new AlertDialog.Builder(this)
                 .setTitle(R.string.restart)
                 .setMessage("Are you sure to restart the game?")
                 .setPositiveButton("yes", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 startGame();
             }
         })
                 .setNegativeButton("NO",null)
                 .create()
                 .show();
    }
}