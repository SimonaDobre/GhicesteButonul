package com.simona.ghicestebutonul;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1, b2, b3;
    int winNumber;
    TextView tv1, tvMessage;
    Button[] buttons = new Button[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initWinBtn();
        btnAction2();
    }


    void initWinBtn() {
        winNumber = new Random().nextInt(3);
        tv1.setText(" Hint: butonul castigator este " + winNumber);
    }

    void btnAction2() {
        buttons[0] = b1;
        buttons[1] = b2;
        buttons[2] = b3;
        for (Button currentButton : buttons) {
            currentButton.setOnClickListener(this);
        }

    }

    @Override
    public void onClick(View view) {
        Button clickedButton = (Button) view;
        int clickedTag = Integer.parseInt((String) clickedButton.getTag());
        if (clickedTag == winNumber) {
            tvMessage.setText(" Ai castigat!");
        } else {
            tvMessage.setText(clickedButton.getTag() + " este Necastigator ");
        }
    }

    void initViews() {
        b1 = findViewById(R.id.button0);
        b2 = findViewById(R.id.button1);
        b3 = findViewById(R.id.button2);
        tv1 = findViewById(R.id.tvInfoTextView);
        tvMessage = findViewById(R.id.tvMessageTextView);
    }

}
