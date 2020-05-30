package sample;

import javafx.animation.TranslateTransition;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.util.Duration;

public class NodoUI<T extends Comparable<T>> extends Pane {
    Nodo<T> nodo;
    private double radio = 20;
    DoubleProperty centerX;
    DoubleProperty centerY;
    Circle c;
    Text t;

    public Nodo<T> getNodo() {
        return nodo;
    }

    public void setNodo(Nodo<T> nodo) {
        this.nodo = nodo;
    }

    public NodoUI(double centerX, double centerY, Nodo<T> nodo) {
        super();
        Circle circle= new Circle(centerX,centerY,radio);
        this.c=circle;
        this.centerX=new SimpleDoubleProperty(centerX);
        this.centerY=new SimpleDoubleProperty(centerY);
        Text text= new Text(nodo.getElemento().toString());
        this.t=text;
        text.setBoundsType(TextBoundsType.VISUAL);
        text.setFill(Color.WHITE);
        //para que el texto quede en el centro del circulo
        setLayoutX(centerX-radio);
        setLayoutY(centerY-radio);
        this.getChildren().addAll(circle,text);
        this.nodo = nodo;
    }

    public void animarNodo(double toX, double toY, Arista linea, Pane pane){
        TranslateTransition circle1Animation = new TranslateTransition(Duration.seconds(1), this);
       // circle
    }
    
}
