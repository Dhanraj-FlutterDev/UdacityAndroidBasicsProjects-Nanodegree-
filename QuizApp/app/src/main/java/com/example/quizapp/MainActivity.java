package com.example.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;
    final int quizOne = R.id.king_srk;
    final int quizTwo = R.id.age_four;
    final int quizThree = R.id.game_three;
    final int quizFour = R.id.bike_one;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickButtonMethod(View view) {

        if (Question1()) {
            score++;
        }
        if (Question2()) {
            score++;
        }
        if (Question3()) {
            score++;
        }
        if (Question4()) {
            score++;
        }
        display();
        reset();

    }

    private boolean Question1() {
        RadioGroup groupOne = (RadioGroup) findViewById(R.id.group_one);

        if (groupOne.getCheckedRadioButtonId() == quizOne) {
            return true;
        }
        return false;
    }

    private boolean Question2() {
        RadioGroup groupTwo = (RadioGroup) findViewById(R.id.group_two);

        if (groupTwo.getCheckedRadioButtonId() == quizTwo) {
            return true;
        }
        return false;
    }

    private boolean Question3() {
        RadioGroup groupThree = (RadioGroup) findViewById(R.id.group_three);

        if (groupThree.getCheckedRadioButtonId() == quizThree) {
            return true;
        }
        return false;
    }

    private boolean Question4() {
        RadioGroup groupFour = (RadioGroup) findViewById(R.id.group_four);

        if (groupFour.getCheckedRadioButtonId() == quizFour) {
            return true;
        }
        return false;
    }

    private void display() {

        Toast.makeText(this, "Your Score is " + score + " Out of 4", Toast.LENGTH_LONG).show();

    }
      private void reset() {
        score = 0;
    }
}
