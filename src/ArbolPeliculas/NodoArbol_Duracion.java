package ArbolPeliculas;

public class NodoArbol_Duracion {
    private int duracion;
    private String pregunta;
    
    NodoArbol_Duracion left = null;
    NodoArbol_Duracion right = null;

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    
    
    
    
    public NodoArbol_Duracion(int duracion, String pregunta){
        this.duracion = duracion;
        this.pregunta = pregunta;
        left = null;
        right = null;
    }
    
    public void insertar_elemento(int duracion, String pregunta){
        if(duracion < this.duracion){
            if(left == null){
                left = new NodoArbol_Duracion(duracion, pregunta);
            } else {
                left.insertar_elemento(duracion, pregunta);
            }
        }
        if(duracion > this.duracion){
            if(right == null){
                right = new NodoArbol_Duracion(duracion, pregunta);
            } else {
                right.insertar_elemento(duracion, pregunta);
            }
        }
    }
    
}
