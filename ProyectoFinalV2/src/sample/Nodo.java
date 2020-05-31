package sample;
public class Nodo<T extends Comparable<T>> {

    private NodoUI<T> nodoUI; 
    private T elemento;
    private Nodo<T> izquierdo;
    private Nodo<T> derecho;
    private double altura;
    private double profundidad;

    public NodoUI<T> getUI() {
        return nodoUI;
    }

    public void setUI(NodoUI<T> nodoUI) {
        this.nodoUI = nodoUI;
    }
    
    public void setProfundidad(double profundidad) {
        this.profundidad = profundidad;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public Nodo(T elemento) {
        this.elemento = elemento;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public Nodo<T> getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo<T> izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo<T> getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo<T> derecho) {
        this.derecho = derecho;
    }

    public boolean isLeaf() {

        return (this.izquierdo == null && this.derecho == null);

    }
}
