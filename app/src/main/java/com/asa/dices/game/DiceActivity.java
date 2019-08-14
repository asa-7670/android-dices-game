package com.asa.dices.game;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.SecureRandom;

public class DiceActivity extends Activity implements  View.OnClickListener{

    private TextView titleTxView;
    private TextView resultTxView;
    private Button rollBtnView;
    int max;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_dice );

        max = getIntent ().getIntExtra ( "max", 0 );

        titleTxView = findViewById ( R.id.titleTxView );
        titleTxView.setText ( String.valueOf ( max ).concat (" ").concat ( getString ( R.string.title_label) ) );

        resultTxView =  findViewById ( R.id.resultTxView );
        resultTxView.setText ( null );

        rollBtnView =  findViewById ( R.id.rollBtnView );
        rollBtnView.setOnClickListener ( this );

    }

    private void diceLauncher() {
        resultTxView.setText ( null );
        SecureRandom r = new SecureRandom();
        int re = r.nextInt(max) + 1;
        resultTxView.setText ( String.valueOf ( re ) );
    }

    @Override
    public void onClick(View view) {
        diceLauncher ();
    }
}
