package sample;

import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class AVLVer<T extends Comparable<T>> extends Pane {
   // private double espacioY = 50; //espacioY step(dinstancia entre dos nodos) en y
    private AVL<T> avl;
    private Pane gp;
    private double profundidad=0;
    

     public AVLVer(AVL<T> avl,  Pane gp){
        this.avl = avl;
        this.gp = gp;
        
     }

     public void agregarUI(NodoUI<T> nUI){
         avl.insertar(nUI.getNodo().getElemento());
         gp.getChildren().add(nUI);
         //falta agregar la animacion bruh
     }

    public void animar(NodoUI<T> nUI){
        TranslateTransition transition = new TranslateTransition(Duration.seconds(1),nUI);
        //hasta aquí va a llegar la transition en Y
        transition.setByY(30);
        transition.setCycleCount(1);
        transition.play();
        profundidad=0;
        transition.setOnFinished(new MyEventHandler(profundidad, nUI));
    } 
    
    class MyEventHandler implements EventHandler<ActionEvent>{

        double pos;
        NodoUI nodoUI;
        double centerY = nodoUI.getCenterY();

        public MyEventHandler(double profundidad, NodoUI nodoUI) {
            this.pos = profundidad;
            this.nodoUI=nodoUI;
        }

        @Override
        public void handle(ActionEvent event) {
            System.out.println(pos);
            TranslateTransition transition= new TranslateTransition(Duration.seconds(1),nodoUI);
            this.centerY = avl.getProfundidad(nodoUI.get).centerY.doubleValue();
            transition.setByY(nodoUI.centerY.doubleValue());

            System.out.println("Center y:"+nodoUI.centerY);
            transition.setCycleCount(1);

            transition.play();
            currentIndex++;
            if(currentIndex<lista.size()){
                animarRec(nodoUI);
            }
        }
    }



    //no puedo usar este porque borra el arbol cada vez que se muestra tons no sirve para animar :(
    /*
        public AVLVer(AVL<T> avl) {
        this.avl = avl;
    } 
    
    //no le entra nada porque cuando se instancia ahi se mete al arbol c:
    public void ver(String elemento){
        this.getChildren().clear(); //vaciar borrar el pane
        if(avl.getRaiz()!= null){
            //mete la raiz el ancho del pane/2 --> x, y =50, espacio x(step) --> pane/4
            verRecursivo(avl.getRaiz(),getWidth(),espacioY,getWidth()/2);
            System.out.println(getWidth());

        }
    }
    public void ver(){
       this.getChildren().clear(); //vaciar borrar el pane
        if(avl.getRaiz()!= null){
            //mete la raiz el ancho del pane/2 --> x, y =50, espacio x(step) --> pane/4
            verRecursivo(avl.getRaiz(),getWidth(),espacioY,getWidth()/2);
            System.out.println(getWidth());

        }
    }
    //espacioX step(dinstancia entre dos nodos) en x
    public void verRecursivo(Nodo<String> raiz,  double x, double y, double espacioX) {
        if (raiz.getIzquierdo() != null) {
            //dibuja una linea al nodo izquierdo
            getChildren().add(new Line(x - espacioX, y + espacioY, x, y));
            verRecursivo(raiz.getIzquierdo(), x - espacioX, y + espacioY, espacioX / 2);
            System.out.println("entra izquierdo" +raiz.getIzquierdo().getElemento());
        }
        //linea al nodo derecho
        if (raiz.getDerecho() != null) {
            getChildren().add(new Line(x + espacioX, y + espacioY, x, y));
            verRecursivo(raiz.getDerecho(), x + espacioX, y + espacioY, espacioX / 2);
            System.out.println("entra derecho" +raiz.getDerecho().getElemento());
        }
        //hace el nodo
        Circle circle = new Circle(x, y, radio);
        circle.setFill(Color.CYAN);
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle, new Text(x - 4, y + 4, raiz.getElemento() + ""));
    }

*/

}


