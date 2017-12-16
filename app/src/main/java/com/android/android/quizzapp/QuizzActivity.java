package com.android.android.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import static android.graphics.Color.rgb;

public class QuizzActivity extends AppCompatActivity {
    
    // Declare a TAG for debugging purpose
    private static final  String TAG = "QuizzApp";

    /**
     *  Define constant KEY to store the score value on configuration change
     */

    public static final String KEY_SCORE = "scoreSaved";

    @Override protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCORE, score);
    }

    // Define a string variable for user input result

    int score;
    String playerName;


    /**
     *@param savedInstanceState
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        // Save instance variable score in case value change

        if(savedInstanceState != null) {
            score = savedInstanceState.getInt(KEY_SCORE);
            customObj();
        } else {
            score = 0;
            playerName ="";
        }

        // Call the Intent that started this activity and extract the string
        Intent intent = getIntent();
        final String playerName = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView tv = (TextView) findViewById(R.id.player_name);
        tv.setText(playerName + " " + getString(R.string.lets));

        // Find the View that shows the string hit_me
        TextView playAgain = (TextView) findViewById(R.id.hit_me);

        // Set a click listener on that View
        playAgain.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the text is clicked
            @Override
            public void onClick(View v) {

                // Create an intent to open the {@link MainActivity}
                Intent playAgain = new Intent(QuizzActivity.this, MainActivity.class);

                // Start the activity
                startActivity(playAgain);
            }
        });

        // Find the View that shows the string hit_me
        Button button = (Button) findViewById(R.id.buttonReview);

        // Set a click listener on that Button
        button.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the text is clicked
            @Override
            public void onClick(View view) {

                // Scroll the view up the screen
                ScrollView sv = (ScrollView) findViewById(R.id.activity_quizz);
                sv.fullScroll(ScrollView.FOCUS_UP);
                findViewById(R.id.player_name);

                // Check the right RadioButton was selected question 1
                RadioButton rbAnswer1C = (RadioButton) findViewById(R.id.radioButtonQ1C);
                if (rbAnswer1C.isChecked()) {
                    score += 1;
                } else {

                    // Change color text in red right answer
                    rbAnswer1C.setTextColor(rgb(213, 0, 0));
                }

                // Check the right RadioButton was selected question 2
                RadioButton rbAnswer2B = (RadioButton) findViewById(R.id.radioButtonQ2B);
                if (rbAnswer2B.isChecked()) {
                    score += 1;
                } else {

                    // Change color text in red right answer
                    rbAnswer2B.setTextColor(rgb(213, 0, 0));
                }

                // Check the right RadioButton was selected question 3
                RadioButton rbAnswer3B = (RadioButton) findViewById(R.id.radioButtonQ3B);
                if (rbAnswer3B.isChecked()) {
                    score += 1;
                } else {

                    // Change color text in red right answer
                    rbAnswer3B.setTextColor(rgb(213, 0, 0));
                }

                // Check the right CheckBox was selected question 4
                CheckBox cbAnswer4A = (CheckBox) findViewById(R.id.checkBoxQ4A);
                CheckBox cbAnswer4B = (CheckBox) findViewById(R.id.checkBoxQ4B);
                CheckBox cbAnswer4C = (CheckBox) findViewById(R.id.checkBoxQ4C);
                CheckBox cbAnswer4D = (CheckBox) findViewById(R.id.checkBoxQ4D);
                if (cbAnswer4A.isChecked() && cbAnswer4B.isChecked() && cbAnswer4D.isChecked() && !cbAnswer4C.isChecked()) {
                    score += 1;
                } else {

                    // Change color text in red right answer
                    cbAnswer4A.setTextColor(rgb(213, 0, 0));
                    cbAnswer4B.setTextColor(rgb(213, 0, 0));
                    cbAnswer4D.setTextColor(rgb(213, 0, 0));
                }

                // Check the right CheckBox was selected question 5
                CheckBox cbAnswer5A = (CheckBox) findViewById(R.id.checkBoxQ5A);
                CheckBox cbAnswer5B = (CheckBox) findViewById(R.id.checkBoxQ5B);
                CheckBox cbAnswer5C = (CheckBox) findViewById(R.id.checkBoxQ5C);
                CheckBox cbAnswer5D = (CheckBox) findViewById(R.id.checkBoxQ5D);
                if (cbAnswer5B.isChecked() && cbAnswer5C.isChecked() && cbAnswer5D.isChecked() && !cbAnswer5A.isChecked()) {
                    score += 1;
                } else {

                    // Change color text in red right answer
                    cbAnswer5A.setTextColor(rgb(213, 0, 0));
                    cbAnswer5B.setTextColor(rgb(213, 0, 0));
                    cbAnswer5D.setTextColor(rgb(213, 0, 0));
                }

                // Check the right entered answer is given question 6
                EditText etAnswer6 = (EditText) findViewById(R.id.editTextQ6);
                if (etAnswer6.getText().toString().equals(getString(R.string.Q6A))) {
                    score += 1;
                } else {

                    // Change color text in red right answer
                    etAnswer6.setText(getString(R.string.Q6A));
                    etAnswer6.setTextColor(rgb(213, 0, 0));
                }

                // Check the right CheckBox was selected question 7
                CheckBox cbAnswer7A = (CheckBox) findViewById(R.id.checkBoxQ7A);
                CheckBox cbAnswer7B = (CheckBox) findViewById(R.id.checkBoxQ7B);
                CheckBox cbAnswer7C = (CheckBox) findViewById(R.id.checkBoxQ7C);
                CheckBox cbAnswer7D = (CheckBox) findViewById(R.id.checkBoxQ7D);
                if (cbAnswer7B.isChecked() && cbAnswer7C.isChecked() && cbAnswer7D.isChecked() && !cbAnswer7A.isChecked()) {
                    score += 1;
                } else {

                    // Change color text in red right answer
                    cbAnswer7A.setTextColor(rgb(213, 0, 0));
                    cbAnswer7B.setTextColor(rgb(213, 0, 0));
                    cbAnswer7D.setTextColor(rgb(213, 0, 0));
                }

                // Check the right RadioButton was selected question 8
                RadioButton rbAnswer8B = (RadioButton) findViewById(R.id.radioButtonQ8B);
                if (rbAnswer8B.isChecked()) {
                    score += 1;
                } else {

                    // Change color text in red right answer
                    rbAnswer8B.setTextColor(rgb(213, 0, 0));
                }

                // Check the right entered answer is given question 9
                EditText etAnswer9 = (EditText) findViewById(R.id.editTextQ9);
                if (etAnswer9.getText().toString().equals(getString(R.string.Q9B))) {
                    score += 1;
                } else {

                    // Change color text in red right answer
                    etAnswer9.setText(getString(R.string.Q9B));
                    etAnswer9.setTextColor(rgb(213, 0, 0));
                }

                // Check the right RadioButton was selected question 10
                RadioButton rbAnswer10B = (RadioButton) findViewById(R.id.radioButtonQ10B);
                if (rbAnswer10B.isChecked()) {
                    score += 1;
                } else {

                    // Change color text in red right answer
                    rbAnswer10B.setTextColor(rgb(213, 0, 0));
                }

                //Prevents the Submit method from being pressed more than once
                Button myButton = (Button) findViewById(R.id.buttonReview);
                myButton.setClickable(false);

                // Sent score and the player name if submit button is pressed in the layout up he screen
                TextView tv1 = (TextView) findViewById(R.id.player_name);
                tv1.setText(playerName + " " + getString(R.string.yourScore) + " " + score);
                TextView tv2 = (TextView) findViewById(R.id.hit_me);
                tv2.setText(getString(R.string.hit));

                //Display Toast message with the score
                Toast.makeText(QuizzActivity.this, playerName + " " + getString(R.string.yourScore) + " " + score + " " + getString(R.string.point), Toast.LENGTH_LONG).show();
            }
        });
    }

    //Create a custom Method so tv1 and tv2 can be restore in configuration change
    public void customObj (){
        // Sent score and the player name if submit button is pressed in the layout up he screen
        TextView tv1 = (TextView) findViewById(R.id.player_name);
        tv1.setText(playerName + " " + getString(R.string.yourScore) + " " + score);
        Log.d(TAG, "customObj() returned: " + isChangingConfigurations());
        TextView tv2 = (TextView) findViewById(R.id.hit_me);
        tv2.setText(getString(R.string.hit));
    }
}
