
package Grafos;
import Grafos.Control;
import Grafos.Location;
import Grafos.Main;

import Grafos.Window;



public class Route {
private Location startLocation;
private Location endLocation;
private double distance; 
private double time;

public Route(Location startLocation, Location endLocation){
    this.startLocation = startLocation;
    this.endLocation = endLocation;
    this.distance = calculateDistance();
    this.time = calculateTime();
}
 public Location getStartLocation (){
     return startLocation;
 }
 
public void setStartLocation (Location startLocation){
    this.startLocation = startLocation;
}

public Location getEndLocation (){
    return endLocation;
}
public void setEndLocation (Location endLocation){
    this.endLocation = endLocation;
} 
public double getDistance(){
    return distance;
}
public void setDistance(double distance){
    this.distance = distance;
}

public double getTime(){
return time;
}

public void setTime(double time){
    this.time = time;
}
 
//formula herversine
private double calculateDistance (){
    double dLat = Math.toRadians(endLocation.getLatitude() - startLocation.getLatitude());
    double dLon = Math.toRadians(endLocation.getLength() - startLocation.getLength());
    double a = Math.sin(dLat / 2) * Math.sin(dLat/2)
            + Math.cos(Math.toRadians(startLocation.getLatitude()))* Math.cos(Math.toRadians(endLocation.getLatitude()))
            * Math.sin(dLon/2) * Math.sin(dLon/2);
    double c= 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
    return 6371 * c;
            }

private double calculateTime(){
    double speed = 50; // en kilometros
    return distance/speed;
}


}
