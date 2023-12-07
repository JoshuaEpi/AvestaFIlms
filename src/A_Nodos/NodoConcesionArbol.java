package A_Nodos;

import A_Clases.Producto;

public class NodoConcesionArbol {

    private Producto producto;
    private NodoConcesionArbol izquierda = null;
    private NodoConcesionArbol derecha = null;

    public NodoConcesionArbol(Producto producto) {
        this.producto = producto;
        izquierda = derecha = null;

    }

    public void Insertar_Elemento(Producto producto) {
        if (producto.getCodigoProducto() < this.producto.getCodigoProducto()) {
            if (izquierda == null) {
                izquierda = new NodoConcesionArbol(producto);
            } else {
                izquierda.Insertar_Elemento(producto);
            }
        }
        if (producto.getCodigoProducto() > this.producto.getCodigoProducto()) {
            if (derecha == null) {
                derecha = new NodoConcesionArbol(producto);
            } else {
                derecha.Insertar_Elemento(producto);
            }
        }
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public NodoConcesionArbol getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoConcesionArbol izquierda) {
        this.izquierda = izquierda;
    }

    public NodoConcesionArbol getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoConcesionArbol derecha) {
        this.derecha = derecha;
    }
    
}
