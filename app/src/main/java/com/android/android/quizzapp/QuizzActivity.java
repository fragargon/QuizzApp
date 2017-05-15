package com.android.android.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizzActivity extends AppCompatActivity {

    int score = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String playerName = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        // Capture the layout's TextView and set the string as its text
        ViewGroup layout = (ViewGroup) findViewById(R.id.player_name);
        TextView tv = new TextView(this);
        tv.setText(playerName);
        layout.addView(tv);


        /*
         * button setOnClickListener startActivity SolutionActivity
         * display a Toast message player 's name and score
         * This method is used to check the question's right answer
         * on RadioButton, CheckBox, EditText with a Boolean function
         * and return the int value (true) into score
         * display a toast message with the player's name and score
         */

        // Create an onClickListener method
        Button button = (Button) findViewById(R.id.buttonDone);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                Intent buttonIntent = new Intent(QuizzActivity.this, SolutionActivity.class);
                startActivity(buttonIntent);

                // Check the right RadioButton was selected question 1
                RadioButton rbAnswer1C = (RadioButton) findViewById(R.id.radioButtonQ1C);
                boolean rb1c = rbAnswer1C.isChecked();
                if (rb1c)
                    score += 1;

                // Check the right RadioButton was selected question 2
                RadioButton rbAnswer2B = (RadioButton) findViewById(R.id.radioButtonQ2B);
                boolean rb2b = rbAnswer2B.isChecked();
                if (rb2b)
                    score += 1;

                // Check the right RadioButton was selected question 3
                RadioButton rbAnswer3B = (RadioButton) findViewById(R.id.radioButtonQ3B);
                boolean rb3b = rbAnswer3B.isChecked();
                if (rb3b)
                    score += 1;

                // Check the right CheckBox was selected question 4
                CheckBox cbAnswer4A = (CheckBox) findViewById(R.id.checkBoxQ4A);
                boolean cb4A = cbAnswer4A.isChecked();
                CheckBox cbAnswer4B = (CheckBox) findViewById(R.id.checkBoxQ4B);
                boolean cb4B = cbAnswer4B.isChecked();
                CheckBox cbAnswer4C = (CheckBox) findViewById(R.id.checkBoxQ4C);
                boolean cb4C = cbAnswer4C.isChecked();
                CheckBox cbAnswer4D = (CheckBox) findViewById(R.id.checkBoxQ4D);
                boolean cb4D = cbAnswer4D.isChecked();
                if (cb4A && cb4B && cb4D && !cb4C)
                    score += 1;

                // Check the right CheckBox was selected question 5
                CheckBox cbAnswer5A = (CheckBox) findViewById(R.id.checkBoxQ5A);
                boolean cb5A = cbAnswer5A.isChecked();
                CheckBox cbAnswer5B = (CheckBox) findViewById(R.id.checkBoxQ5B);
                boolean cb5B = cbAnswer5B.isChecked();
                CheckBox cbAnswer5C = (CheckBox) findViewById(R.id.checkBoxQ5C);
                boolean cb5C = cbAnswer5C.isChecked();
                CheckBox cbAnswer5D = (CheckBox) findViewById(R.id.checkBoxQ5D);
                boolean cb5D = cbAnswer5D.isChecked();
                if (cb5B && cb5C && cb5D && !cb5A)
                    score += 1;

                // Check the right entered answer is given question 6
                EditText etAnswer6 = (EditText) findViewById(R.id.editTextQ6);
                if (etAnswer6.getText().toString().equals(getString(R.string.Q6A)))
                    score +=1;

                // Check the right CheckBox was selected question 7
                CheckBox cbAnswer7A = (CheckBox) findViewById(R.id.checkBoxQ7A);
                boolean cb7A = cbAnswer7A.isChecked();
                CheckBox cbAnswer7B = (CheckBox) findViewById(R.id.checkBoxQ7B);
                boolean cb7B = cbAnswer7B.isChecked();
                CheckBox cbAnswer7C = (CheckBox) findViewById(R.id.checkBoxQ7C);
                boolean cb7C = cbAnswer7C.isChecked();
                CheckBox cbAnswer7D = (CheckBox) findViewById(R.id.checkBoxQ7D);
                boolean cb7D = cbAnswer7D.isChecked();
                if (cb7B && cb7C && cb7D && !cb7A)
                    score += 1;


                // Check the right RadioButton was selected question 8
                RadioButton rbAnswer8B = (RadioButton) findViewById(R.id.radioButtonQ8B);
                boolean rb8b = rbAnswer8B.isChecked();
                if (rb8b)
                    score += 1;

                // Check the right entered answer is given question 9
                EditText etAnswer9 = (EditText) findViewById(R.id.editTextQ9);
                if (etAnswer9.getText().toString().equals(getString(R.string.Q9B))) {
                    score +=1;
                }

                // Check the right RadioButton was selected question 10
                RadioButton rbAnswer10B = (RadioButton) findViewById(R.id.radioButtonQ10B);
                boolean rb10b = rbAnswer10B.isChecked();
                if (rb10b)
                    score += 1;

                //Display Toast message with the score
                Toast.makeText(QuizzActivity.this, getString(R.string.yourScore) + " " + score + " " + getString(R.string.point), Toast.LENGTH_LONG).show();
            }
        });
    }
}
