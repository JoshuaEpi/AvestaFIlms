package A_Nodos;

import A_Clases.Pelicula;

public class NodoPelicula {

    private Pelicula pelicula;
    private NodoPelicula siguiente;

    public NodoPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
        this.siguiente = null;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public NodoPelicula getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPelicula siguiente) {
        this.siguiente = siguiente;
    }

}