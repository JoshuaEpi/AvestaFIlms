package ArbolPeliculas;

import javax.swing.JOptionPane;

public class NodoArbol_Genero {    
     String pregunta;
     int genero;
     NodoArbol_Genero izquierda=null;
     NodoArbol_Genero derecha=null;
     
     public NodoArbol_Genero (int genero,String pregunta) {
         this.genero=genero;
         this.pregunta = pregunta;
         izquierda=null;
         derecha=null;
     }
     

     
     public void insertar_elemento(int genero,String pregunta){
         if(genero<this.genero){
             if(izquierda == null){
                izquierda = new NodoArbol_Genero(genero, pregunta);
            } else {
                izquierda.insertar_elemento(genero, pregunta);
            }
        }
        if(genero > this.genero){
            if(derecha == null){
                derecha = new NodoArbol_Genero(genero, pregunta);
            } else {
                derecha.insertar_elemento(genero, pregunta);
            }      
         }
     }
    
    
}
