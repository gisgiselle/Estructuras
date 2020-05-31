package sample;

import javafx.animation.TranslateTransition;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.util.Duration;

public class NodoUI<T extends Comparable<T>> extends Pane {
    Nodo<T> nodo;
    private Line linea;
    private double radio = 20;
    private double centerX;
    private double centerY;
    Circle c;
    Text t;

    public Nodo<T> getNodo() {
        return nodo;
    }

    public void setNodo(Nodo<T> nodo) {
        this.nodo = nodo;
    }
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
    
}
