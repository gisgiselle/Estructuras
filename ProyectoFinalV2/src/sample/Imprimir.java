package sample;

public class Imprimir <T extends Comparable<T>> {

    private void imprimirX(Nodo<T>nodo, int anchoX) {
        //al instanciar hacer un temp
        AVL<T> avl = new AVL<>();
        if (avl.getProfundidad(nodo.getElemento()) == 0)
            return;
        else {
            if (nodo.getIzquierdo() != null) {
                nodo = nodo.getIzquierdo();
                anchoX = anchoX + 25;
                imprimirX(nodo, anchoX);
            } else {
                nodo = nodo.getDerecho();
                anchoX = anchoX + 25;
                imprimirX(nodo, anchoX);
            }
        }
    }

    private void imprimirY(Nodo<T>nodo, int alturaY) {
        //al instanciar hacer un temp
        AVL<T> avl = new AVL<>();
        if (avl.calcularAltura(nodo.getElemento()) == 0)
            return;
        else {
            if (nodo.getIzquierdo() != null) {
                nodo = nodo.getIzquierdo();
                alturaY = alturaY + 50;
                imprimirX(nodo, alturaY);
            } else {
                nodo = nodo.getDerecho();
                alturaY = alturaY + 25;
                imprimirX(nodo, alturaY);
            }
        }
    }

    public void imprimirTodo(Nodo<T> nodo, int anchoX, int anchoY ){

    }































    //en x porque el arbol se extiende a la horizontal
   /* public double moverX(Nodo<T> nodo,double ancho){
        Nodo<T> temp = nodo;
        AVL<T> avl = new AVL<T>();
        int profu = avl.getProfundidad(temp.getElemento());
        if(profu==0)
            return 50;
        else{
            return ancho+20;
        }
    }
    public double mover(Nodo<T> nodo){
        if()
    }
    public double moverY(Nodo<T> nodo,double height){
        Nodo<T> temp = nodo;
        AVL<T> avl = new AVL<T>();
        int altu = avl.calcularAltura(temp.getElemento());
        if(altu==0)
            return 50;
        else{
            return height+50;
        }
    }

    */
}
