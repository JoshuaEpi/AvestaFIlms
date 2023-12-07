/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Grafos;


import Grafos.Location;
import Grafos.Route;
import Grafos.Window;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraManyToManyShortestPaths;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

public class Control {
  private List<Location> cities;
private List<Route> routes;
private Graph<Location, DefaultWeightedEdge> graph;
private DijkstraShortestPath<Location, DefaultWeightedEdge> dijkstra;
private GraphPath<Location, DefaultWeightedEdge> shortestPath;


public Control(){
        this.cities = new ArrayList <>(Arrays.asList(
new Location("Comas", -11.9568, -77.0438),
new Location("Los Olivos", -11.9656, -77.0716),
new Location("Callao", -12.0416, -77.125),
new Location("Ventanilla", -11.8772, -77.1054),
new Location("Independencia", -11.9864, -77.058),
new Location("La Victoria", -12.0736, -77.0186),
new Location("Ate", -12.0399, -76.9364),
new Location("Santa Anita", -12.0422, -76.9689),
new Location("Chorrillos", -12.1764, -77.008),
new Location("Surco", -12.1316, -76.9811)
        ));
  this.routes = new ArrayList<>(Arrays.asList(
 new Route(cities.get(0), cities.get(1)),
new Route(cities.get(0), cities.get(2)),
new Route(cities.get(1), cities.get(2)),
new Route(cities.get(1), cities.get(3)),
new Route(cities.get(2), cities.get(3)),
new Route(cities.get(0), cities.get(3)),
new Route(cities.get(0), cities.get(4)),
new Route(cities.get(1), cities.get(6)),
new Route(cities.get(3), cities.get(7)),
new Route(cities.get(4), cities.get(7)),
new Route(cities.get(0), cities.get(9))
  ));
      
graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
for (Location city: cities){
    graph.addVertex(city);
}
for (Route route:routes){
    graph.addEdge(route.getStartLocation(),route.getEndLocation());
    graph.setEdgeWeight(graph.getEdge(route.getStartLocation(),route.getEndLocation()), route.getDistance());
}
}
public String showRoute(int origin, int destiny) {
    this.dijkstra = new DijkstraShortestPath<>(graph);
    this.shortestPath = dijkstra.getPath(cities.get(origin), cities.get(destiny));
    String out = "";

    if (shortestPath != null) {
        out += "La distancia entre las sedes: " + "\n";
        List<Location> shortestRoute = shortestPath.getVertexList();
        double shortestDistance = shortestPath.getWeight();
        for (int i = 0; i < shortestRoute.size() - 1; i++) {
            out += shortestRoute.get(i).getName() + " -> ";
        }

        out += shortestRoute.get(shortestRoute.size() - 1).getName();
        out += "\nLa distancia total de la ruta es: " + shortestDistance;
    } else {
        out += "\nNo se encontró una ruta entre las ciudades especificadas.";
    }
    return out;
}



public void launchWindow(){new Window().setVisible(true);}
}
