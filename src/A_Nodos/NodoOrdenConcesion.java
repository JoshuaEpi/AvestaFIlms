package A_Nodos;

import A_Clases.OrdenConcesion;

public class NodoOrdenConcesion {

    private OrdenConcesion ordenConcesion;
    private NodoOrdenConcesion siguiente;

    public NodoOrdenConcesion(OrdenConcesion ordenConcesion) {
        this.ordenConcesion = ordenConcesion;
        this.siguiente = null;
    }

    public OrdenConcesion getOrdenConcesion() {
        return ordenConcesion;
    }

    public void setOrdenConcesion(OrdenConcesion ordenConcesion) {
        this.ordenConcesion = ordenConcesion;
    }

    public NodoOrdenConcesion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoOrdenConcesion siguiente) {
        this.siguiente = siguiente;
    }

}
