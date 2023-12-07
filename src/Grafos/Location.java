package Grafos;

public class Location {
private String name;
private double latitude;
private double length;
public Location(String name, double latitude, double length){
    this.name = name;
    this.latitude = latitude;
    this.length = length;
}
public String getName(){return name; }


public void setName (String name) { this.name = name; }

public double getLatitude() {return latitude;}

public void setLatitude (double latitude) {this.latitude = latitude;}




public double getLength(){return length;}

public void setLength(double length) {this.length = length;}


}

