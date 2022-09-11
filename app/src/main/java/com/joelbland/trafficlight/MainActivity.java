package com.joelbland.trafficlight;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.YELLOW;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the ID for each View object.

        // A Button object the user clicks to change the traffic light.
        Button button = findViewById(R.id.button);

        // An image object for the light colors.
        ImageView lights = findViewById(R.id.imageView);

        // An ImageButton object the user clicks to change the background.
        ImageButton backgroundButton = findViewById(R.id.imageButton);

        // !!Remember!! ConstraintLayout object needs to have @+id assigned in activity_main.xml
        ConstraintLayout layout = findViewById(R.id.constraintLayout);

        // Get the Drawable resources for the three different lights.
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

        // Create a new TrafficLight object and set the initial attributes.
        TrafficLight trafficLight = new TrafficLight();
        trafficLight.setLightColor("RED");
        trafficLight.setLightText("STOP");

        // OnClick listener for the button.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // DEBUG OUTPUT //
                System.out.println("CURRENT COLOR: " + trafficLight.getLightColor());
                System.out.println("NEXT COLOR: " + trafficLight.getNextLightColor());
                System.out.println("CURRENT TEXT: " + trafficLight.getLightText());
                System.out.println("NEXT TEXT: " + trafficLight.getNextLightText());
                // END DEBUG OUTPUT //

                // Control structure to set the next button color and light image.
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

                // Call both of the getNextLight methods and set the next light and text colors.
                trafficLight.setLightColor(trafficLight.getNextLightColor());
                trafficLight.setLightText(trafficLight.getNextLightText());

                // Set the button text to the next light text.
                button.setText(trafficLight.getLightText());
            }
        });

        // OnClick listener for the background change button.
        backgroundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // DEBUG OUTPUT //
                // TO COMPARE THE NAMES OF DRAWABLES. //
                // System.out.println(layout.getBackground());
                // System.out.println(city);
                // System.out.println(city2);
                // System.out.println(city3);
                // END DEBUG OUTPUT //

                // Control structure to set the next background image.
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