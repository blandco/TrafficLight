package com.joelbland.trafficlight;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.YELLOW;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the IDs for the View resources
        Button button = findViewById(R.id.button);
        ImageView lights = findViewById(R.id.imageView);
        ImageButton backgroundButton = findViewById(R.id.imageButton);

        // ConstraintLayout object needs to have @+id assigned in activity_main.xml
        ConstraintLayout layout = findViewById(R.id.constraintLayout);

        // Get the Drawable resources for the three different lights
        Drawable red = getDrawable(R.drawable.traffic_lights_red);
        Drawable green = getDrawable(R.drawable.traffic_lights_green);
        Drawable yellow = getDrawable(R.drawable.traffic_lights_yellow);

        // Get the Drawable resources for the backgrounds.
        Drawable city = getDrawable(R.drawable.city);
        Drawable city2 = getDrawable(R.drawable.city2);
        Drawable city3 = getDrawable(R.drawable.city3);

        // Go ahead and set the Layout background with the city Drawable
        // so we can change it later in the backgroundButton.setOnClickListener
        layout.setBackground(city);

        // Go ahead and set the button text so our control structure works
        // on the first click!!!! Now I can sleep.
        // button.setText("STOP");

        // Create the TrafficLight object and set the attributes.
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.setLightColor("RED");
        trafficLight.setLightText("STOP");


        // OnClick listener for the button.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Debug output
                System.out.println("CURRENT COLOR: " + trafficLight.getLightColor());
                System.out.println("NEXT COLOR: " + trafficLight.getNextLightColor());
                System.out.println("CURRENT TEXT: " + trafficLight.getLightText());
                System.out.println("NEXT TEXT: " + trafficLight.getNextLightText());
                // End Debug output


                // Control structure to determine which background and button color to use.
                if (trafficLight.getLightColor().equals("RED")){
                    button.setBackgroundColor(GREEN);
                    lights.setImageDrawable(green);
                }
                else if (trafficLight.getLightColor().equals("GREEN")){
                    button.setBackgroundColor(YELLOW);
                    lights.setImageDrawable(yellow);
                }
                else {
                    button.setBackgroundColor(RED);
                    lights.setImageDrawable(red);
                }

                // Call the getNext methods and set the next light and text colors.
                trafficLight.setLightColor(trafficLight.getNextLightColor());
                trafficLight.setLightText(trafficLight.getNextLightText());

                // Set the button text to the next light text.
                button.setText(trafficLight.getLightText());
/*

                  // Get the text of the button to use in our control structure.
                  // String buttonText = button.getText().toString();

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
*/

            }
        });

        // OnClick listener for the background change button.
        backgroundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Debug output to compare the names of drawables.
                // System.out.println(layout.getBackground());
                // System.out.println(city);
                // System.out.println(city2);
                // System.out.println(city3);

                if (layout.getBackground() == city) {
                    layout.setBackground(city2);
                }
                else if (layout.getBackground() == city2) {
                    layout.setBackground(city3);
                }
                else {
                    layout.setBackground(city);
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