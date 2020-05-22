package sample;

public class AVL<T extends Comparable<T>> {

    private Nodo<T> raiz;
    private int nNodos =0;
    public Nodo<T> getRaiz() {
        return raiz;
    }


    public void insertar(T elemento){
        raiz=insertarRecursivo(elemento,raiz);
    }

    private Nodo<T> insertarRecursivo(T elemento, Nodo<T> raiz){
        if(raiz!=null) {
            System.out.println("Entra el nodo: " + elemento + " a la raiz " + raiz.getElemento());
        }
        if(raiz==null){
            raiz = new Nodo<>(elemento);
        }else if(elemento.compareTo(raiz.getElemento())<0){
            raiz.setIzquierdo(insertarRecursivo(elemento,raiz.getIzquierdo()));
            if(altura(raiz.getIzquierdo())-altura(raiz.getDerecho())==2){
                if(elemento.compareTo(raiz.getIzquierdo().getElemento())<0){
                    raiz=rotarSimpleALaDerecha(raiz);
                }else{
                    raiz=rotarDobleALaDerecha(raiz);
                }
            }
        }else if(elemento.compareTo(raiz.getElemento())>0){
            raiz.setDerecho(insertarRecursivo(elemento,raiz.getDerecho()));
            if(altura(raiz.getIzquierdo())-altura(raiz.getDerecho())==-2) {
                if (elemento.compareTo(raiz.getDerecho().getElemento()) > 0) {
                    raiz = rotarSimpleALaIzquierda(raiz);
                } else {
                    raiz = rotarDobleALaIzquierda(raiz);
                }
            }
        }

        int altura=max(altura(raiz.getIzquierdo()),altura(raiz.getDerecho()));
        raiz.setAltura(altura+1);
        System.out.println("la altura es:" +raiz.getAltura());
        return raiz;

    }

    private Nodo<T> rotarSimpleALaDerecha(Nodo<T> raiz){
        System.out.println("Rotando simple a la derecha");
        Nodo<T> temp=raiz.getIzquierdo();
        raiz.setIzquierdo(temp.getDerecho());
        temp.setDerecho(raiz);
        raiz.setAltura(max(altura(raiz.getIzquierdo()),altura(raiz.getDerecho()))+1);
        temp.setAltura(max(altura(temp.getIzquierdo()),raiz.getAltura())+1);
        return temp;
    }
    private Nodo<T> rotarSimpleALaIzquierda(Nodo<T> raiz){
        System.out.println("Rotando simple a la izquierda");
        Nodo<T> temp=raiz.getDerecho();
        raiz.setDerecho(temp.getIzquierdo());
        temp.setIzquierdo(raiz);
        raiz.setAltura(max(altura(raiz.getIzquierdo()),altura(raiz.getDerecho()))+1);
        temp.setAltura(max(raiz.getAltura(),altura(temp.getDerecho()))+1);
        return temp;
    }

    private Nodo<T> rotarDobleALaDerecha(Nodo<T> raiz){
        System.out.println("Rotando doble a la derecha");
        raiz.setIzquierdo(rotarSimpleALaIzquierda(raiz.getIzquierdo()));
        return rotarSimpleALaDerecha(raiz);
    }
    private Nodo<T> rotarDobleALaIzquierda(Nodo<T> raiz){
        System.out.println("Rotando doble a la izquierda");
        raiz.setDerecho(rotarSimpleALaDerecha(raiz.getDerecho()));
        return rotarSimpleALaIzquierda(raiz);
    }
    private int max(int a, int b){
        if(a>b){
            return a;
        }else{
            return b;
        }
    }
    private int altura(Nodo<T> nodo){
        if(nodo==null)
            return -1;
        return nodo.getAltura();
    }

    public void altura(T elemento){
        if(buscarNodo(elemento)==null)
            System.out.println("El elemento "+elemento+ " del cual quiere la altura no existe en el árbol");
        else{
            Nodo<T> temp=raiz;
            while(elemento.compareTo(temp.getElemento())!=0){
                if(elemento.compareTo(temp.getElemento())<0){
                    temp=temp.getIzquierdo();
                }else{
                    temp=temp.getDerecho();
                }
            }
            int altura=altura(temp);
            System.out.println("El elemento "+elemento+ " tiene una altura de: "+altura);
        }
    }


    public Nodo<T> buscarNodo(T loQueBusco){
        return buscarNodoRec(raiz, loQueBusco);
    }

    private Nodo<T> buscarNodoRec(Nodo<T> nodo,T loQueBusco){
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
    public void borrar(Nodo<T> coso, T valor){
        raiz = borrarRecursivo(coso,valor);
    }

    private Nodo<T> borrarRecursivo(Nodo<T> raiz, T valor) {
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
            int facEquilibrio=factorEquilibrio(raiz);
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

    private int factorEquilibrio(Nodo<T> nodo){
        if(nodo==null)
            return 0;
        return altura(nodo.getIzquierdo())-altura(nodo.getDerecho());
    }

    private Nodo<T> minNodo(Nodo<T> nodo){
        Nodo<T> temp=nodo;
        while(temp.getIzquierdo()!=null){
            temp=temp.getIzquierdo();
        }
        return temp;

    }
    private T minValor(Nodo<T> nodo) {
        if (nodo.getIzquierdo() != null)
            return minValor(nodo.getIzquierdo());
        else return nodo.getElemento();
    }

    private boolean noBalanceado(Nodo<T> nodo) {
        if (altura(nodo.getIzquierdo()) - altura(nodo.getDerecho()) == 2 || altura(nodo.getIzquierdo()) - altura(nodo.getDerecho()) == -2)
            return true;
        return false;
    }

    private void recorridoPre(Nodo<T> raiz){
        recorridoPreRec(raiz);
    }

    private void recorridoPreRec(Nodo<T> raiz){
        if(raiz == null)
            return;
        recorridoPreRec(raiz.getIzquierdo());   //recorre subarbol izquierdo
        recorridoPreRec(raiz.getDerecho());     //recorre subarbol derecho
    }
    private int size(){
        return nNodos;
    }


}
