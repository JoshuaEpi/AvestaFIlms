package A_Nodos;

import A_Clases.Cines;

public class NodoCines {
    
    private NodoCines siguiente;
    private final Cines cines;

    public NodoCines(Cines cines) {
        this.cines = cines;
        this.siguiente = null;
    }

    public Cines getCines() {
        return cines;
    }

    public void setCliente(Cines cines) {
    }

    public NodoCines getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCines siguiente) {
        this.siguiente = siguiente;
}

}