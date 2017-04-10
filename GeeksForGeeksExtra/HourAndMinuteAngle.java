import java.util.*;
public class HourAndMinuteAngle{
    // Utility function to find minimum of two integers
double min(double x, double y) { 
          return (x < y)? x: y; 
          
}
 
double calcAngle(double h, double m){
    // validate the input
    if (h <0 || m < 0 || h >12 || m > 60)
        return 0.00;
 
    if (h == 12) h = 0;
    if (m == 60) m = 0;
 
    // Calculate the angles moved by hour and minute hands
    // with reference to 12:00
    double hour_angle = 0.5 * (h*60 + m);
    double minute_angle = 6*m;
 
    // Find the difference between two angles
    double angle = Math.abs(hour_angle - minute_angle);
 
    // Return the smaller angle of two possible angles
    angle = min(360-angle, angle);
 
    return angle;
}
 
     // Driver program to test above function
     public static void main(String[] args){
          HourAndMinuteAngle hma = new HourAndMinuteAngle();
          double angle = hma.calcAngle(3,30);
          System.out.println("Angle "+angle);
     }      
}
 
