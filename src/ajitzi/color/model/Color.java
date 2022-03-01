package ajitzi.color.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Color {

    public int red;
    public int green;
    public int blue;
    public String hexValue;


    public Color(int red, int green, int blue) {

        if (0 <= red && red <= 255 && 0 <= green && green <= 255 && 0 <= blue && blue <= 255) {

            this.hexValue = "#" + Integer.toHexString(red) + Integer.toHexString(green) + Integer.toHexString(blue);
            this.red = red;
            this.green = green;
            this.blue = blue;

        } else {

            throw new IllegalArgumentException("Value between 0 and 255");
        }
    }

    public Color(String hexValue) {

        if (isValidHexaCode(hexValue)) {
            this.hexValue = hexValue;
            this.red = java.awt.Color.decode(hexValue).getRed();
            this.green = java.awt.Color.decode(hexValue).getGreen();
            this.blue =  java.awt.Color.decode(hexValue).getBlue();

        } else {

            throw new IllegalArgumentException("Invalide hexadecimal code");
        }


    }


    public void setRed(int red) {

        if (0 <= red && red <= 255) {
            this.red = red;
            setHexValue("#" + Integer.toHexString(red) + Integer.toHexString(getGreen()) + Integer.toHexString(getBlue()) );

        } else {

            throw new IllegalArgumentException("Value between 0 and 255");
        }
    }

    public void setGreen(int green) {

        if (0 <= green && green <= 255) {
            this.green = green;
            setHexValue("#" + Integer.toHexString(getRed()) + Integer.toHexString(green) + Integer.toHexString(getBlue()) );

        } else {

            throw new IllegalArgumentException("Value between 0 and 255");
        }
    }

    public void setBlue(int blue) {
        if (0 <= blue && blue <= 255) {
            this.blue = blue;
            setHexValue("#" + Integer.toHexString(getRed()) + Integer.toHexString(getGreen()) + Integer.toHexString(getBlue()) );

        } else {

            throw new IllegalArgumentException("Value between 0 and 255");
        }
    }

    public void setHexValue(String hexValue) {


        if (isValidHexaCode(hexValue)) {
            this.hexValue = hexValue;
            setRed( java.awt.Color.decode(hexValue).getRed() );
            setGreen( java.awt.Color.decode(hexValue).getGreen() );
            setBlue( java.awt.Color.decode(hexValue).getBlue() );

        } else {

            throw new IllegalArgumentException("Invalid hexadecimal code");
        }
    }

    public int getRed() {
        return this.red;
    }

    public int getGreen() {
        return this.green;
    }

    public int getBlue() {
        return this.blue;
    }

    public String getHexValue() {
        return this.hexValue;
    }

    @Override
    public String toString() {
        return "[value=" + this.hexValue + ", r=" + this.red + ", g=" + this.green + ", b=" + this.blue + "]";
    }


    private static boolean isValidHexaCode(String str)
    {
        String regex = "^#([A-F0-9]{6}|[A-F0-9]{3})$";
        Pattern p = Pattern.compile(regex);

        if (str == null) {
            return false;
        }

        Matcher m = p.matcher(str);
        return m.matches();
    }
}
