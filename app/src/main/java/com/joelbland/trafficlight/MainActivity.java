package com.joelbland.trafficlight;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.YELLOW;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the IDs for the View resources
        Button button = findViewById(R.id.button);
        ImageView lights = findViewById(R.id.imageView);

        // Get the Drawable resources for the three different lights
        Drawable red = getDrawable(R.drawable.traffic_lights_red);
        Drawable green = getDrawable(R.drawable.traffic_lights_green);
        Drawable yellow = getDrawable(R.drawable.traffic_lights_yellow);

        // OnClick listener for the button.
        button.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {

                  // Get the text of the button to use in our control structure.
                  String buttonText = button.getText().toString();

                  // Compare the button text and set the next light.
                  if (buttonText.equals("STOP")) {
                      button.setText("GO");
                      button.setBackgroundColor(GREEN);
                      lights.setImageDrawable(green);
                  } else if (buttonText.equals("GO")) {
                      button.setText("WAIT");
                      button.setBackgroundColor(YELLOW);
                      lights.setImageDrawable(yellow);
                  } else {
                      button.setText("STOP");
                      button.setBackgroundColor(RED);
                      lights.setImageDrawable(red);
                  }

              }
          });
    }
}

 /**
    public void change_light(View view) {

        // Get the IDs for the View resources
        Button button = findViewById(R.id.button);
        ImageView lights = findViewById(R.id.imageView);

        // Get the Drawable resources for the three different lights
        Drawable red = getDrawable(R.drawable.traffic_lights_red);
        Drawable green = getDrawable(R.drawable.traffic_lights_green);
        Drawable yellow = getDrawable(R.drawable.traffic_lights_yellow);

        // Get the text of the button to use in our control structure.
        String buttonText = button.getText().toString();

        // Compare the button text and set the next light.
        if (buttonText.equals("STOP")){
            button.setText("GO");
            button.setBackgroundColor(GREEN);
            lights.setImageDrawable(green);
        }
        else if (buttonText.equals("GO")){
            button.setText("WAIT");
            button.setBackgroundColor(YELLOW);
            lights.setImageDrawable(yellow);
        }
        else {
            button.setText("STOP");
            button.setBackgroundColor(RED);
            lights.setImageDrawable(red);
        }

    }
}*/