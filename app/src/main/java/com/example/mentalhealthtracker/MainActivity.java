package com.example.mentalhealthtracker;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

import java.time.Instant;
import java.time.LocalTime;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        //Button quizButton = (Button) findViewById(R.id.takeDepressionQuizButton);
        TextView appGreeting = (TextView) findViewById(R.id.greeting);
        // instantiate time object
        //Instant instant = Instant.now();
        LocalTime localTime = LocalTime.now();
        int hour = localTime.getHour();
        if ((hour > 0) && (hour < 6)){
            appGreeting.setText("Good Night!");
        }
        if ((hour > 6) && (hour < 12)){
            appGreeting.setText("Good Morning!");
        }
        if ((hour > 12) && (hour < 17)){
            appGreeting.setText("Good Afternoon!");
        }
        if ((hour > 17) && (hour < 24)){
            appGreeting.setText("Good Night!");
        }
        Button quizButton = findViewById(R.id.takeDepressionQuizButton);
        quizButton.setOnClickListener(this);
    }
    /**
     * Called when a view has been clicked.
     *
     * @param view The view that was clicked.
     */
    @Override
    public void onClick(View view) {
        // Create an instance of the fragment
        DepressionInventoryFragment depressionInventoryFragment = new DepressionInventoryFragment();
        // Perform the fragment transaction
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main, depressionInventoryFragment)
                .addToBackStack(null)  // Optional: adds the transaction to the back stack
                .commit();
    };
}