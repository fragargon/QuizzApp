package com.android.android.quizzapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.rgb;

public class QuizzActivity extends AppCompatActivity {

    // Declare a static final variable to restore value on configuration change
    public static final String KEY_SCORE = "scoreSaved";
    public static final String KEY_PLAYER_NAME = "playerNameSaved";
    public static final String KEY_TEXT = "textSaved";

    // Declare string variable to store user input result
    String mEtPlayer;
    String mText;
    String mText2;
    int mScore;

    // Declare variable to find the Views
    CheckBox cbAnswer4A, cbAnswer4B, cbAnswer4C, cbAnswer4D, cbAnswer5A, cbAnswer5B,
            cbAnswer5C, cbAnswer5D, cbAnswer7A, cbAnswer7B, cbAnswer7C, cbAnswer7D;
    RadioButton rbAnswer1C, rbAnswer2B, rbAnswer3B, rbAnswer8B, rbAnswer10B;
    EditText etAnswer6, etAnswer9;
    public TextView tv1, tv2;
    Button myButton;
    ScrollView sv;

    /**
     * @param outState save previous state in configuration change
     */

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORE, mScore);
        outState.putString(KEY_PLAYER_NAME, mEtPlayer);
        outState.putString(KEY_TEXT, mText);
        customObj();
        outState.putIntArray("ARTICLE_SCROLL_POSITION",
                new int[]{ sv.getScrollX(), sv.getScrollY()});
    }

    /**
     * @param savedInstanceState restore the previous state before configuration change
     */

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mEtPlayer = savedInstanceState.getString(KEY_PLAYER_NAME);
        mScore = savedInstanceState.getInt(KEY_SCORE);
        final int[] position = savedInstanceState.getIntArray("ARTICLE_SCROLL_POSITION");
        if(position != null)
            sv.post(() -> sv.scrollTo(position[1], position[1]));
            customObj();
    }

    // Create a custom Method so ID view tv1 and tv2 can be restore in configuration change
    public void customObj() {
        mText = getResources().getString(R.string.yourScore, mEtPlayer, mScore);
        tv1.setText(mText);
        tv2.setText(getString(R.string.hit));
    }

    /**
     * @param savedInstanceState create and show the quizz activity
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        // Instantiate variables and Ids to find the Views
        Resources res = getResources();
        mScore = 0;
        sv = (ScrollView) findViewById(R.id.activity_quizz);
        rbAnswer1C = (RadioButton) findViewById(R.id.radioButtonQ1C);
        rbAnswer2B = (RadioButton) findViewById(R.id.radioButtonQ2B);
        rbAnswer3B = (RadioButton) findViewById(R.id.radioButtonQ3B);
        cbAnswer4A = (CheckBox) findViewById(R.id.checkBoxQ4A);
        cbAnswer4B = (CheckBox) findViewById(R.id.checkBoxQ4B);
        cbAnswer4C = (CheckBox) findViewById(R.id.checkBoxQ4C);
        cbAnswer4D = (CheckBox) findViewById(R.id.checkBoxQ4D);
        cbAnswer5A = (CheckBox) findViewById(R.id.checkBoxQ5A);
        cbAnswer5B = (CheckBox) findViewById(R.id.checkBoxQ5B);
        cbAnswer5C = (CheckBox) findViewById(R.id.checkBoxQ5C);
        cbAnswer5D = (CheckBox) findViewById(R.id.checkBoxQ5D);
        etAnswer6 = (EditText) findViewById(R.id.editTextQ6);
        cbAnswer7A = (CheckBox) findViewById(R.id.checkBoxQ7A);
        cbAnswer7B = (CheckBox) findViewById(R.id.checkBoxQ7B);
        cbAnswer7C = (CheckBox) findViewById(R.id.checkBoxQ7C);
        cbAnswer7D = (CheckBox) findViewById(R.id.checkBoxQ7D);
        rbAnswer8B = (RadioButton) findViewById(R.id.radioButtonQ8B);
        etAnswer9 = (EditText) findViewById(R.id.editTextQ9);
        rbAnswer10B = (RadioButton) findViewById(R.id.radioButtonQ10B);
        myButton = (Button) findViewById(R.id.buttonReview);
        tv1 = (TextView) findViewById(R.id.player_name);
        tv2 = (TextView) findViewById(R.id.hit_me);

        // Call the Intent that store the String EXTRA_MESSAGE and set the string to the right View
        Intent intent = getIntent();
        mEtPlayer = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        // initialize the String mText2
        mText2 = getResources().getString(R.string.lets, mEtPlayer);
        // set Text to the ID view tv1
        tv1.setText(mText2);

        // Hide the Keyboard when focus on EditText
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        // Set a click listener on that View
        // The code in this method will be executed when the text is clicked
        tv2.setOnClickListener(v -> {
            // Create an intent to open the {@link MainActivity}
            Intent playAgain = new Intent(QuizzActivity.this, MainActivity.class);
            // Start the activity
            startActivity(playAgain);
        });

        // Set a click listener on that Button
        // The code in this method will be executed when the text is clicked
        myButton.setOnClickListener(view -> {

            // Scroll the view up the screen
            sv.fullScroll(ScrollView.FOCUS_UP);
            findViewById(R.id.player_name);

            // Check the right RadioButton was selected Question 1
            if (rbAnswer1C.isChecked()) {
                mScore += 1;
            } else {

                // Change color text in red right answer
                rbAnswer1C.setTextColor(rgb(213, 0, 0));
            }

            // Check the right RadioButton was selected Question 2
            if (rbAnswer2B.isChecked()) {
                mScore += 1;
            } else {

                // Change color text in red right answer
                rbAnswer2B.setTextColor(rgb(213, 0, 0));
            }

            // Check the right RadioButton was selected Question 3
            if (rbAnswer3B.isChecked()) {
                mScore += 1;
            } else {

                // Change color text in red right answer
                rbAnswer3B.setTextColor(rgb(213, 0, 0));
            }

            // Check the right CheckBox was selected Question 4
            if (cbAnswer4A.isChecked() && cbAnswer4B.isChecked() && cbAnswer4D.isChecked() && !cbAnswer4C.isChecked()) {
                mScore += 1;
            } else {

                // Change color text in red right answer
                cbAnswer4A.setTextColor(rgb(213, 0, 0));
                cbAnswer4B.setTextColor(rgb(213, 0, 0));
                cbAnswer4D.setTextColor(rgb(213, 0, 0));
            }

            // Check the right CheckBox was selected Question 5
            if (cbAnswer5B.isChecked() && cbAnswer5C.isChecked() && cbAnswer5D.isChecked() && !cbAnswer5A.isChecked()) {
                mScore += 1;
            } else {

                // Change color text in red right answer
                cbAnswer5A.setTextColor(rgb(213, 0, 0));
                cbAnswer5B.setTextColor(rgb(213, 0, 0));
                cbAnswer5D.setTextColor(rgb(213, 0, 0));
            }

            // Check the right entered answer is given Question 6
            if (etAnswer6.getText().toString().equals(getString(R.string.Q6A))) {
                mScore += 1;
            } else {

                // Change color text in red right answer
                etAnswer6.setText(getString(R.string.Q6A));
                etAnswer6.setTextColor(rgb(213, 0, 0));
            }

            // Check the right CheckBox was selected Question 7
            if (cbAnswer7B.isChecked() && cbAnswer7C.isChecked() && cbAnswer7D.isChecked() && !cbAnswer7A.isChecked()) {
                mScore += 1;
            } else {

                // Change color text in red right answer
                cbAnswer7A.setTextColor(rgb(213, 0, 0));
                cbAnswer7B.setTextColor(rgb(213, 0, 0));
                cbAnswer7D.setTextColor(rgb(213, 0, 0));
            }

            // Check the right RadioButton was selected Question 8
            if (rbAnswer8B.isChecked()) {
                mScore += 1;
            } else {

                // Change color text in red right answer
                rbAnswer8B.setTextColor(rgb(213, 0, 0));
            }

            // Check the right entered answer is given Question 9
            if (etAnswer9.getText().toString().equals(getString(R.string.Q9B))) {
                mScore += 1;
            } else {

                // Change color text in red right answer
                etAnswer9.setText(getString(R.string.Q9B));
                etAnswer9.setTextColor(rgb(213, 0, 0));
            }

            // Check the right RadioButton was selected Question 10
            if (rbAnswer10B.isChecked()) {
                mScore += 1;
            } else {

                // Change color text in red right answer
                rbAnswer10B.setTextColor(rgb(213, 0, 0));
            }

            //Prevents the Submit method from being pressed more than once
            myButton.setClickable(false);

            // Update the Views tv1 and tv2 when the submit button is hit
            mText = res.getString(R.string.yourScore, mEtPlayer, mScore);
            tv1.setText(mText);
            tv2.setText(getString(R.string.hit));

            //Display Toast message with the mScore
            Toast.makeText(QuizzActivity.this, mText + " " + getString(R.string.point), Toast.LENGTH_LONG).show();
        });
    }
}
