package A_Nodos;

import A_Clases.Empleado;

public class NodoEmpleado {

    private Empleado valor;
    private NodoEmpleado siguiente;

    public NodoEmpleado() {
        this.valor = valor;
        this.siguiente = null;
    }

    public Empleado getValor() {
        return valor;
    }

    public void setValor(Empleado valor) {
        this.valor = valor;
    }

    public NodoEmpleado getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoEmpleado siguiente) {
        this.siguiente = siguiente;
    }
    
}
