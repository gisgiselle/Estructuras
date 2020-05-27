package sample;

import javafx.animation.Transition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class AVLVer extends Pane {
    private AVL<String> avl = new AVL<>();
    private double radio = 20;
    private double espacioY = 50; //espacioY step(dinstancia entre dos nodos) en y

    public AVL<String> getAvl() {
        return avl;
    }

    public void setAvl(AVL<String> avl) {
        this.avl = avl;
    }

    public AVLVer(AVL<String> avl) {
        this.avl = avl;
    }
    //no le entra nada porque cuando se instancia ahi se mete al arbol c:
    public void ver(){
        this.getChildren().clear(); //vaciar borrar el pane
        if(avl.getRaiz()!= null){
            //mete la raiz el ancho del pane/2 --> x, y =50, espacio x(step) --> pane/4
            verRecursivo(avl.getRaiz(),getWidth(),espacioY,getWidth()/2);
            System.out.println(getWidth());
        }
    }
    //espacioX step(dinstancia entre dos nodos) en x
    public void verRecursivo(Nodo<String> raiz,  double x, double y, double espacioX){
        if(raiz.getIzquierdo()!= null){
            //dibuja una linea al nodo izquierdo
            getChildren().add(new Line(x-espacioX, y+espacioY, x, y));
            verRecursivo(raiz.getIzquierdo(),x-espacioX,y+espacioY,espacioX/2);
        }
        //linea al nodo derecho
        if(raiz.getDerecho()!= null){
            getChildren().add(new Line(x+espacioX, y+espacioY, x, y));
            verRecursivo(raiz.getDerecho(),x+espacioX,y+espacioY,espacioX/2);
        }
        //hace el nodo
        System.out.println("se crea circulo");
        Circle circle = new Circle(x, y, radio);
        circle.setFill(Color.CYAN);
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle, new Text(x - 4, y + 4, raiz.getElemento() + ""));
    }


}
