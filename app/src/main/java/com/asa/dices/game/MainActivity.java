package com.asa.dices.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button sixSideDiceBtnView;
    private Button twentySidedDiceBtnView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        sixSideDiceBtnView = (Button) findViewById ( R.id.dice_six_sided_btn );
        sixSideDiceBtnView.setOnClickListener ( diceSixSidedListener );

        twentySidedDiceBtnView = (Button) findViewById ( R.id.dice_twenty_sided_btn );
        twentySidedDiceBtnView.setOnClickListener ( diceTwentySidedListener );
    }

    private View.OnClickListener diceSixSidedListener = new View.OnClickListener () {
        @Override
        public void onClick(View view) {
            startDiceActivity ( 6 );
        }
    };

    private View.OnClickListener diceTwentySidedListener = new View.OnClickListener () {
        @Override
        public void onClick(View view) {
           startDiceActivity ( 20 );
        }
    };

    private void startDiceActivity(int max){
        Intent intent = new Intent ( MainActivity.this , DiceActivity.class);
        intent.putExtra ( "max", max );
        startActivity ( intent );
    }
}
