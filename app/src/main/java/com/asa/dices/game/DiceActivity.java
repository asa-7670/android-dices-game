package com.asa.dices.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.SecureRandom;

public class DiceActivity extends Activity implements  View.OnClickListener{

    private TextView titleTxView;
    private TextView resultTxView;
    private Button rollBtnView;
    private int max;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_dice );

        max = getIntent ().getIntExtra ( "max", 0 );

        imageView = findViewById ( R.id.image_rotate_view );

        titleTxView = findViewById ( R.id.titleTxView );
        titleTxView.setText ( String.valueOf ( max ).concat (" ").concat ( getString ( R.string.title_label) ) );

        resultTxView =  findViewById ( R.id.resultTxView );
        resultTxView.setText ( null );

        rollBtnView =  findViewById ( R.id.rollBtnView );
        rollBtnView.setOnClickListener ( this );

    }

    private void animate(){
        Animation animation = AnimationUtils.loadAnimation (DiceActivity.this, R.anim.rotate_clockwise );
        imageView.startAnimation ( animation );
    }

    private void diceLauncher() {
        animate ();
        resultTxView.setText ( null );
        SecureRandom r = new SecureRandom();
        final int re = r.nextInt(max) + 1;

        final Thread thread = new Thread ( ) {
            @Override
            public void run(){
                try { Thread.sleep ( 2500 );
                }catch (InterruptedException e){}

                runOnUiThread(new Runnable(){
                    @Override
                    public void run(){
                        resultTxView.setText ( String.valueOf ( re ) );
                    }
                });
            }
        };
        thread.start ();
    }

    @Override
    public void onClick(View view) {
        diceLauncher ();
    }
}
