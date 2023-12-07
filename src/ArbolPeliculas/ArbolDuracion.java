
package ArbolPeliculas;

import javax.swing.JOptionPane;

/**
 *
 * @author Fabrizzio
 */
public class ArbolDuracion {
    NodoArbol_Duracion raiz;

    public ArbolDuracion(){
    raiz = null; 
}

public void insertar_Nodo(int duracion, String pregunta){
    if (raiz == null){
        raiz = new NodoArbol_Duracion(duracion,pregunta);
    }else{
         raiz.insertar_elemento(duracion, pregunta);
    }
}

private String preorden(NodoArbol_Duracion nodo){
    String cadena = new String() ;
    String eligeme ="";
    
    if (nodo != null){
        if (nodo.right !=null || nodo.left != null  ){
            eligeme = JOptionPane.showInputDialog(nodo.getPregunta() + "\n Ingrese:  si / no");
        }
        if ("no".equalsIgnoreCase(eligeme)){
            cadena = preorden(nodo.right);
        }else if ("si".equalsIgnoreCase(eligeme)){
            cadena = preorden(nodo.left);
        }else {
            //cadena = "Entonces la categoria que le recomiendo es: "+ nodo.getPregunta();
            cadena = nodo.getPregunta();
        }
    }else{
        cadena = "";
    }
    return cadena;
}

public String realizar_Pregunta(){
    String resultado = preorden(raiz);
    return resultado;
}

}

