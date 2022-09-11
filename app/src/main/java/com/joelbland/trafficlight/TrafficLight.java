package com.joelbland.trafficlight;

/**
 The TrafficLight class creates an object that represents a traffic light. The light color and
 light text can be get and set along with the next color and text.
 */
public class TrafficLight {

    // Strings for the light color and text.
    final String red = "RED";
    final String yellow = "YELLOW";
    final String green = "GREEN";
    final String stop = "STOP";
    final String wait = "WAIT";
    final String go = "GO";

    // Fields to store the light color and text in the object.
    String lightColor;
    String lightText;

    /**
     The setLightColor method sets the traffic light color.
     @param lightColor The color to set the light. RED, YELLOW, or GREEN
     */
    public void setLightColor(String lightColor) {
        this.lightColor = lightColor;
    }

    /**
     The setLightText method sets the traffic light text.
     @param lightText The text to set the light. STOP, WAIT, or GO.
     */
    public void setLightText(String lightText) {
        this.lightText = lightText;
    }

    /**
     The getLightColor method returns the current light color.
     @return String The current light color.
     */
    public String getLightColor() {
        return lightColor;
    }

    /**
     The getLightText method returns the current light text.
     @return String The current light text.
     */
    public String getLightText() {
        return lightText;
    }

    /**
     The getNextLightColor method returns the next light color.
     @return String The next light color.
     */
    public String getNextLightColor() {

        if (this.lightColor.equals(red)) {
            return green;
        } else if (this.lightColor.equals(green)) {
            return yellow;
        } else {
            return red;
        }
    }

    /**
     The getNextLightText method returns the next light text.
     @return String The next light text. 
     */
    public String getNextLightText() {
        if (this.lightText.equals(stop)) {
            return go;
        } else if (this.lightText.equals(go)) {
            return wait;
        } else {
            return stop;
        }
    }

}
