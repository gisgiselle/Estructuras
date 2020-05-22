package sample;

import javafx.beans.InvalidationListener;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.geometry.Point2D;

public class Drawer<T extends Comparable<T>> {

    private Circle c1;
    private Circle c2;







    //ARISTAS
    ///Point 2D sirve para representar un punto x y un punto y
        public static Point2D getDirection(Circle c1, Circle c2) {
            //.normalize reescala el vector sin cambiar la dirección  pero alch no entendí bien pa que
            //https://stackoverflow.com/questions/38027635/how-to-connect-a-line-to-circle-not-the-center-using-java-fx
            return new Point2D(c2.getCenterX() - c1.getCenterX(), c2.getCenterY() - c1.getCenterY()).normalize();
        }
        //Explicación propiedades: https://www.youtube.com/watch?v=BY-4ONH0DFE
        //Explicación observables: https://www.youtube.com/watch?v=JaqExzdJhEI
        //Explicación invalidationListener: https://www.youtube.com/watch?v=7WD6jtmNfW8&t=66s

        public static void conectarNodos(Circle c1, Circle c2, Line linea) {
            //un listener busca cambios en las propiedades
            //invalidationListener es mi evento nos permite saber cuando el valor de una propiedad se cambia de estado válido a no válido
            //Un estado no válido es cuando se le cambia el valor, o que necesita recalcular el valor cuando es solicitado otra vez geT()
            //Un observable permite que se actualice una variable automáticamente

            //El observable del inicio se vuelve inválido
            InvalidationListener startInvalidated = observable -> {
                Point2D dir = getDirection(c1, c2);
                Point2D diff = dir.multiply(c1.getRadius());
                linea.setStartX(c1.getCenterX() + diff.getX());
                linea.setStartY(c1.getCenterY() + diff.getY());
            };
            //el observable del final se vuelve inválido
            InvalidationListener endInvalidated = observable -> {
                Point2D dir = getDirection(c2, c1);
                Point2D diff = dir.multiply(c2.getRadius());
                linea.setEndX(c2.getCenterX() + diff.getX());
                linea.setEndY(c2.getCenterY() + diff.getY());
            };
            //se usa .blablablaProperty() debido a que hace que la posición x,y y el radio sean properties y puedan tener un listener
            // o sea que sean OBSERVABLES c:
            c1.centerXProperty().addListener(startInvalidated);
            c1.centerYProperty().addListener(startInvalidated);
            c1.radiusProperty().addListener(startInvalidated);

            //invalidated es un método de InvalidationListener
            //cuando se produzca la invalidación, se hace el evento startInvalidated

            startInvalidated.invalidated(null);

            //el listener de un invalidated hace que solamente se recalcule cuando se solicita: lazy evaluation
            c2.centerXProperty().addListener(endInvalidated);
            c2.centerYProperty().addListener(endInvalidated);
            c2.radiusProperty().addListener(endInvalidated);

            endInvalidated.invalidated(null);
        }

}
