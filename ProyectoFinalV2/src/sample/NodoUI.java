package sample;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

public class NodoUI<T extends Comparable<T>> extends StackPane {
    Nodo<T> nodo;
    DoubleProperty centerX;
    DoubleProperty centerY;
    Circle c;
    Text t;

    public NodoUI(double centerX, double centerY, Nodo<T> nodo) {
        super();
        Circle circle= new Circle(centerX,centerY,20);
        this.c=circle;
        this.centerX=new SimpleDoubleProperty(centerX);
        this.centerY=new SimpleDoubleProperty(centerY);
        Text text= new Text(nodo.getElemento().toString());
        this.t=text;
        text.setBoundsType(TextBoundsType.VISUAL);
        text.setFill(Color.WHITE);
        setLayoutX(centerX-20);
        setLayoutY(centerY-20);
        this.getChildren().addAll(circle,text);
        this.nodo = nodo;
    }
}
