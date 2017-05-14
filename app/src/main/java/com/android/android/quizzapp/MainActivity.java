package com.android.android.quizzapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.android.android.quizzapp.R.id.editTextPlayer;


public class MainActivity extends AppCompatActivity {

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

        // Set player name
        final EditText etPlayer = (EditText) findViewById(editTextPlayer);

        // Launch web browser source url
        TextView textView = (TextView) findViewById(R.id.source_url);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an implicit intent to launch a web browser
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.tutorialspoint.com/java/java_online_quiz.htm"));
                if (browserIntent.resolveActivity(getPackageManager()) != null) {
                    // Start the intent
                    startActivity(browserIntent);
                }
            }
        });

        // Create an intent to pass string user input to QuizzActivity
        final Intent myIntent = new Intent(getApplicationContext(), QuizzActivity.class);
        myIntent.putExtra("playerName", etPlayer.getText().toString());

        // Create an onClickListener method
        // Check if user has input his name and launch the QuizzActivity or display a Toast message
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                // Create an intent to open the {@link QuizzActivity}
                Intent buttonIntent = new Intent(MainActivity.this, QuizzActivity.class);
                //check player is not empty, start QuizzActivity else display a Toast message
                if ((etPlayer.getText().toString().equals(""))) {
                    Toast.makeText(getApplicationContext(), getString(R.string.OOpS), Toast.LENGTH_SHORT).show();
                } else {
                    startActivity(buttonIntent);
                    startActivity(myIntent);
                }
            }
        });
    }
}
