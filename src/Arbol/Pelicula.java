package Arbol;

public class Pelicula {

    private int CodigoPelicula;
    private String Titulo;
    private String Director;
    private String Genero;
    private int Duracion;
    private String ClasificacionEdad;

    public Pelicula(int CodigoPelicula, String Titulo, String Director, String Genero, int Duracion, String ClasificacionEdad) {
        this.CodigoPelicula = CodigoPelicula;
        this.Titulo = Titulo;
        this.Director = Director;
        this.Genero = Genero;
        this.Duracion = Duracion;
        this.ClasificacionEdad = ClasificacionEdad;
    }

    public int getCodigoPelicula() {
        return CodigoPelicula;
    }

    public void setCodigoPelicula(int CodigoPelicula) {
        this.CodigoPelicula = CodigoPelicula;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String Director) {
        this.Director = Director;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int Duracion) {
        this.Duracion = Duracion;
    }

    public String getClasificacionEdad() {
        return ClasificacionEdad;
    }

    public void setClasificacionEdad(String ClasificacionEdad) {
        this.ClasificacionEdad = ClasificacionEdad;
    }

}
