package Arbol;

/**
 * Representa un nodo en el árbol de películas con información adicional.
 * 
 * @author Pierre
 */
class NodoPelicula {

    String titulo;
    String genero;
    // Puedes agregar más atributos aquí según sea necesario
    NodoPelicula izquierda = null;
    NodoPelicula derecha = null;

    public NodoPelicula(String titulo, String genero) {
        this.titulo = titulo;
        this.genero = genero;
        izquierda = null;
        derecha = null;
    }

    public void insertarPelicula(String titulo, String genero) {
        if (titulo.compareTo(this.titulo) < 0) {
            if (izquierda == null) {
                izquierda = new NodoPelicula(titulo, genero);
            } else {
                izquierda.insertarPelicula(titulo, genero);
            }
        } else if (titulo.compareTo(this.titulo) > 0) {
            if (derecha == null) {
                derecha = new NodoPelicula(titulo, genero);
            } else {
                derecha.insertarPelicula(titulo, genero);
            }
        }
    }
}
