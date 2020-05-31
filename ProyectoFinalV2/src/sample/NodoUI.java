package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.util.Duration;

public class NodoUI<T extends Comparable<T>> extends Pane {
    private AVL<T> avl;
    private Line linea;
    private double radio = 20;
    private double centerX;
    private double centerY;
    private Arista arista;
    Circle c;
    Text t;

    public double getCenterX() {
        return centerX;
    }

    public void setCenterX(Double centerX) {
        this.centerX = centerX;
    }
    public double getCenterY() {
        return centerY;
    }

    public void setCenterY(Double centerY) {
        this.centerY = centerY;
    }

    public NodoUI(double centerX, double centerY, Nodo<T> nodo) {
        super();
        Circle circle= new Circle(centerX,centerY,radio);
        this.c=circle;
        this.centerX = centerX;
        this.centerY = centerY;
        this.nodo = nodo;
        Text text= new Text(nodo.getElemento().toString());
        this.t=text;
        text.setBoundsType(TextBoundsType.VISUAL);
        text.setFill(Color.WHITE); 
        StackPane stack = new StackPane();
        //para que el texto quede en el centro del circulo
       
        stack.setLayoutX(centerX-radio);
        stack.setLayoutY(centerY-radio);
        stack.getChildren().addAll(circle,text);
        this.getChildren().addAll(arista,stack);
    }
    
}
