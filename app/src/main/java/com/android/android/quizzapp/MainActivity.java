package com.android.android.quizzapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.android.android.quizzapp.R.id.editTextPlayer;


public class MainActivity extends AppCompatActivity {

    public static String EXTRA_MESSAGE;

    /**
     * @param savedInstanceState create an Activity where it define Method, onClickListener and object declaration
     *                           EditText to store input player into a String, it will be used on other Activities
     *                           start an implicit BrowserIntent through URL to the source of this Quizz
     *                           create an Intent myIntent to pass through a String "playerName" to QuizzApp.class
     *                           start Activity QuizzApp.class through Button onClickListener with is statement
     *                           if player doesn't input his name display a Toast message else start Activity QuizzActivity
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        // Find the View that shows the string URL
        TextView textView = (TextView) findViewById(R.id.source_url);

        // Set a click listener on that View
        textView.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the text is clicked
            @Override
            public void onClick(View view) {

                // Create an implicit intent to launch a web browser
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tutorialspoint.com/java/java_online_quiz.htm"));
                if (browserIntent.resolveActivity(getPackageManager()) != null) {

                    // Start the activity
                    startActivity(browserIntent);
                }
            }
        });

        // Find the View that shows the Button
        Button button = (Button) findViewById(R.id.button);

        // Set a click listener on that View
        button.setOnClickListener(new View.OnClickListener() {
         // Set player name
           EditText etPlayer = (EditText) findViewById(editTextPlayer);

            // The code in this method will be executed when the Button is clicked
           @Override
           public void onClick(View view) {

                // Create an intent to open the {@link QuizzActivity}
                Intent myIntent = new Intent(MainActivity.this, QuizzActivity.class);

                // Send an EXTRA_MESSAGE player name
                myIntent.putExtra(EXTRA_MESSAGE, etPlayer.getText().toString());

               // Check player is not empty, start QuizzActivity else display a Toast message
                if ((etPlayer.getText().toString().equals(""))) {
                    Toast.makeText(getApplicationContext(), getString(R.string.OOpS), Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(myIntent);
                }
            }
        });

        // launch the next activity QuizzAcitivity, create an Intent and save to pass through etPlayer String
        // to the nex activity with constant var, show a toast message if etPlayer is null

        button.setOnClickListener( view -> {

            // Set player name
            EditText etPlayer = (EditText) findViewById(editTextPlayer);

            // The code in this method will be executed when the Button is clicked


                // Create an intent to open the {@link QuizzActivity}
                Intent myIntent = new Intent(MainActivity.this, QuizzActivity.class);

                // Send an EXTRA_MESSAGE player name
                myIntent.putExtra(EXTRA_MESSAGE, etPlayer.getText().toString());

                // Check player is not empty, start QuizzActivity else display a Toast message
                if ((etPlayer.getText().toString().equals(""))) {
                    Toast.makeText(getApplicationContext(), getString(R.string.OOpS), Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(myIntent);
                }

        });
    }
}
