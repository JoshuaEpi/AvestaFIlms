
package A_Nodos;

import A_Clases.Sala;

public class NodoSala {

    private Sala valor;
    private NodoSala siguiente;

    public NodoSala() {
        this.valor = valor;
        this.siguiente = null;
    }

    public Sala getValor() {
        return valor;
    }

    public void setValor(Sala valor) {
        this.valor = valor;
    }

    public NodoSala getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSala siguiente) {
        this.siguiente = siguiente;
    }
}

