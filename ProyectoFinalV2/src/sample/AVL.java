package sample;

import javafx.scene.layout.Pane;
import ui.NodoUI;

public class AVL<T extends Comparable<T>> {

    private Nodo<T> raiz;
    private AVLVer<T> avlVer;
    private final int nNodos =0;

    public AVLVer<T> getAVLVer(){
        return avlVer;
    }
    public Nodo<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(final Nodo<T> raiz) {
        this.raiz = raiz;
    }

    public void insertar(final T elemento){
        raiz=insertar(elemento,raiz);
    }


    private Nodo<T> insertar( T elemento, Nodo<T> raiz){
        if(raiz!=null) {
            System.out.println("Entra el nodo: " + elemento + " a la raiz " + raiz.getElemento());
        }
        if(raiz==null){
            raiz = new Nodo<>(elemento);
        }else if(elemento.compareTo(raiz.getElemento())<0){
            raiz.setIzquierdo(insertar(elemento,raiz.getIzquierdo()));
            if(altura(raiz.getIzquierdo())-altura(raiz.getDerecho())==2){
                if(elemento.compareTo(raiz.getIzquierdo().getElemento())<0){
                    raiz=rotarSimpleALaDerecha(raiz);
                }else{
                    raiz=rotarDobleALaDerecha(raiz);
                }
            }
        }else if(elemento.compareTo(raiz.getElemento())>0){
            raiz.setDerecho(insertar(elemento,raiz.getDerecho()));
            if(altura(raiz.getIzquierdo())-altura(raiz.getDerecho())==-2) {
                if (elemento.compareTo(raiz.getDerecho().getElemento()) > 0) {
                    raiz = rotarSimpleALaIzquierda(raiz);
                } else {
                    raiz = rotarDobleALaIzquierda(raiz);
                }
            }
        }

         double altura=max(altura(raiz.getIzquierdo()),altura(raiz.getDerecho()));
        raiz.setAltura(altura+1);
        return raiz;

    }

    private Nodo<T> rotarSimpleALaDerecha( Nodo<T> raiz){
        System.out.println("Rotando simple a la derecha");
        final Nodo<T> temp=raiz.getIzquierdo();
        raiz.setIzquierdo(temp.getDerecho());
        temp.setDerecho(raiz);
        raiz.setAltura(max(altura(raiz.getIzquierdo()),altura(raiz.getDerecho()))+1);
        temp.setAltura(max(altura(temp.getIzquierdo()),raiz.getAltura())+1);
        return temp;
    }
    private Nodo<T> rotarSimpleALaIzquierda( Nodo<T> raiz){
        System.out.println("Rotando simple a la izquierda");
         Nodo<T> temp=raiz.getDerecho();
        raiz.setDerecho(temp.getIzquierdo());
        temp.setIzquierdo(raiz);
        raiz.setAltura(max(altura(raiz.getIzquierdo()),altura(raiz.getDerecho()))+1);
        temp.setAltura(max(raiz.getAltura(),altura(temp.getDerecho()))+1);
        return temp;
    }

    private Nodo<T> rotarDobleALaDerecha( Nodo<T> raiz){
        System.out.println("Rotando doble a la derecha");
        raiz.setIzquierdo(rotarSimpleALaIzquierda(raiz.getIzquierdo()));
        return rotarSimpleALaDerecha(raiz);
    }
    private Nodo<T> rotarDobleALaIzquierda( Nodo<T> raiz){
        System.out.println("Rotando doble a la izquierda");
        raiz.setDerecho(rotarSimpleALaDerecha(raiz.getDerecho()));
        return rotarSimpleALaIzquierda(raiz);
    }
    private double max( double a,  double b){
        if(a>b){
            return a;
        }else{
            return b;
        }
    }
    private double altura( Nodo<T> nodo){
        if(nodo==null)
            return -1;
        return nodo.getAltura();
    }
    private Nodo<T> recorreRecursivo( Nodo<T> raiz, T buscando) {
        if (raiz == null) {
            return null;
        }
        if (buscando.compareTo(raiz.getElemento()) == 0) {
            return raiz;
        }
        if (buscando.compareTo(raiz.getElemento()) > 0) {
            return recorreRecursivo(raiz.getDerecho(), buscando);
        } else {
            return recorreRecursivo(raiz.getIzquierdo(), buscando);
        }
    }


    public double calcularAltura( T buscando){
         Nodo<T> nodo=recorreRecursivo(raiz,buscando);
        if(nodo!=null){
            return nodo.getAltura();
        }else{
            return -1;
        }
    }


    public Nodo<T> buscarNodo( T loQueBusco){
        return buscarNodoRec(raiz, loQueBusco);
    }

    private Nodo<T> buscarNodoRec( Nodo<T> nodo, T loQueBusco){
        if(nodo==null) {
            return null;
        }
        if(loQueBusco.compareTo(nodo.getElemento())==0) {
            return nodo;
        }else if(loQueBusco.compareTo(nodo.getElemento())>0) {
            return buscarNodoRec(nodo.getDerecho(),loQueBusco);
        }else {
            return buscarNodoRec(nodo.getIzquierdo(),loQueBusco);
        }
    }
    public void borrar( T valor){
        raiz = borrarRecursivo(raiz,valor);
    }

    private Nodo<T> borrarRecursivo(Nodo<T> raiz,  T valor) {
        //caso base
        if (raiz == null) return raiz;
        //voy a buscar el elemento a borrar en el lado izq
        if (valor.compareTo(raiz.getElemento()) < 0) {
            //si mi valor es menor a la raiz, entonces me voy al lado izq
            //el vuelve a usar el recursivo del lado izquierdo
            raiz.setIzquierdo(borrarRecursivo(raiz.getIzquierdo(), valor));
        } else if (valor.compareTo(raiz.getElemento()) > 0) {
            raiz.setDerecho(borrarRecursivo(raiz.getDerecho(), valor));
        }//una vez que encontramos el valor:
        else if (valor.compareTo(raiz.getElemento()) == 0){
            Nodo<T> temp = null;
            //caso 1 : es una hoja (no tiene subarboles)
            if (raiz.getIzquierdo() == null && raiz.getDerecho() == null) {
                temp = raiz;
                raiz= null;
                return raiz;
            }//caso 2: solo tiene subarbol derecho
            else if (raiz.getIzquierdo() == null) {
                temp = raiz.getDerecho();
                raiz = temp;
            }//caso 3: el nodo tiene solo un subarbol izquierdo
            else if (raiz.getDerecho() == null) {
                temp= raiz.getIzquierdo();
                raiz = temp;
            }//caso 4: tiene ambos izquierdo y derecho
            else if (raiz.getIzquierdo()!= null && raiz.getDerecho()!=null){
                //Escogemos el valor menor del derecho
                temp = minNodo(raiz.getDerecho());
                raiz.setElemento(temp.getElemento());
                raiz.setDerecho(borrarRecursivo(raiz.getDerecho(),temp.getElemento()));
            }

            raiz.setAltura(max(altura(raiz.getIzquierdo()),altura(raiz.getDerecho()))+1);
             double facEquilibrio=factorEquilibrio(raiz);
            if(facEquilibrio==2){
                if(valor.compareTo(raiz.getIzquierdo().getElemento())<0) {
                    raiz = rotarSimpleALaDerecha(raiz);
                }else {
                    raiz = rotarDobleALaDerecha(raiz);
                }
            }
            if(facEquilibrio==-2) {
                if (valor.compareTo(raiz.getDerecho().getElemento()) > 0) {
                    raiz = rotarSimpleALaIzquierda(raiz);
                } else {
                    raiz = rotarDobleALaIzquierda(raiz);
                }
            }
        }

        return raiz;
    }
    public double getProfundidad( T buscando){
        return calcularProfundidadRec(raiz,buscando,0);
    }

    private double calcularProfundidadRec( Nodo<T> raiz, T buscando,double profundidad){
        if(raiz==null){
            return profundidad;
        }
        if(buscando.compareTo(raiz.getElemento())==0){
            return profundidad;
        }
        if(buscando.compareTo(raiz.getElemento())>0){
            return calcularProfundidadRec(raiz.getDerecho(),buscando,++profundidad);
        }else{
            return calcularProfundidadRec(raiz.getIzquierdo(),buscando,++profundidad);
        }
    }
    private double factorEquilibrio( Nodo<T> nodo){
        if(nodo==null)
            return 0;
        return altura(nodo.getIzquierdo())-altura(nodo.getDerecho());
    }

    private Nodo<T> minNodo( Nodo<T> nodo){
        Nodo<T> temp=nodo;
        while(temp.getIzquierdo()!=null){
            temp=temp.getIzquierdo();
        }
        return temp;

    }
    private T minValor( Nodo<T> nodo) {
        if (nodo.getIzquierdo() != null)
            return minValor(nodo.getIzquierdo());
        else return nodo.getElemento();
    }

    private boolean noBalanceado( Nodo<T> nodo) {
        if (altura(nodo.getIzquierdo()) - altura(nodo.getDerecho()) == 2 || altura(nodo.getIzquierdo()) - altura(nodo.getDerecho()) == -2)
            return true;
        return false;
    }

    private void recorridoPre( Nodo<T> raiz){
        recorridoPreRec(raiz);
    }

    private void recorridoPreRec( Nodo<T> raiz){
        if(raiz == null)
            return;
        recorridoPreRec(raiz.getIzquierdo());   //recorre subarbol izquierdo
        recorridoPreRec(raiz.getDerecho());     //recorre subarbol derecho
    }
    private int size(){
        return nNodos;
    }


}
