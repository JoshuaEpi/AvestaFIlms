package ArbolPeliculas;

public class NodoArbol_Edad {
    private int edad;
    private String pregunta;
    
    NodoArbol_Edad left = null;
    NodoArbol_Edad right = null;

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    
    
    
    
    public NodoArbol_Edad(int edad, String pregunta){
        this.edad = edad;
        this.pregunta = pregunta;
        left = null;
        right = null;
    }
    
    public void insertar_elemento(int edad, String pregunta){
        if(edad < this.edad){
            if(left == null){
                left = new NodoArbol_Edad(edad, pregunta);
            } else {
                left.insertar_elemento(edad, pregunta);
            }
        }
        if(edad > this.edad){
            if(right == null){
                right = new NodoArbol_Edad(edad, pregunta);
            } else {
                right.insertar_elemento(edad, pregunta);
            }
        }
    }
    
}
