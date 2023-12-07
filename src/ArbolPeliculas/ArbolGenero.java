
package ArbolPeliculas;

import javax.swing.JOptionPane;
public class ArbolGenero {
    NodoArbol_Genero raiz;
    
    public ArbolGenero(){
        raiz=null;
    }
    public void insertar_nodo(int genero,String preg){
        if(raiz==null){
           raiz=new NodoArbol_Genero(genero, preg);
        }else{
           raiz.insertar_elemento(genero, preg);     
        }
    }
    public String realizar_operacion(){
        String resultado=preorden(raiz);
        return resultado;
    }
    private String preorden(NodoArbol_Genero nodo){
        String cadena=new String();
        String eligeme="";
        if(nodo!=null){
            if(nodo.derecha!=null||nodo.izquierda!=null){
                eligeme=JOptionPane.showInputDialog(nodo.pregunta+"\nIngrese: si /no");
            }if(eligeme.compareTo("no")==0){
                cadena=preorden(nodo.derecha);
            }else if(eligeme.compareTo("si")==0){
                cadena=preorden(nodo.izquierda);
            }else{
               // cadena="Los autores recomendados son: "+nodo.pregunta;
                cadena= nodo.pregunta;
            }
        }else{
            cadena="";
        }
        return cadena;
    }
}
