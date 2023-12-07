package ArbolPeliculas;

import javax.swing.JOptionPane;

public class ArbolEdad {
    
    NodoArbol_Edad raiz;
    
    public ArbolEdad(){
        raiz = null;
    }
    
    public void insertar_nodo(int edad, String preg){
        if(raiz == null){
            raiz = new NodoArbol_Edad(edad, preg);
        } else {
            raiz.insertar_elemento(edad, preg);
        }
    }
    
    public String realizar_operacion(){
        String resultado = preorden(raiz);
        return resultado;
    }
    
    private String preorden(NodoArbol_Edad nodo){
        String cadena = new String();
        String eligeme = "";
        
        if(nodo != null){
            if(nodo.right != null || nodo.left != null){
                eligeme = JOptionPane.showInputDialog(nodo.getPregunta() + "\nIngrese: si / no");
            }
            
            if(eligeme.compareTo("no") == 0){
                cadena = preorden(nodo.right);
            }
            else if(eligeme.compareTo("si") == 0){
                cadena = preorden(nodo.left);
            } else {
                //cadena = "Entonces las editoriales que te recomiendo son:\n" + nodo.getPregunta();
                cadena = nodo.getPregunta();
            }
        } else {
            cadena = "";
        }
        return cadena;
    }
    
}
