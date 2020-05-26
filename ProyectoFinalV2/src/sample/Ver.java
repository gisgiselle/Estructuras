package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Random;

public class Ver <T extends Comparable<T>> extends Application {
    private int counter = 0;
    int xx;
    int yy;
    Nodo<String> nodo;
    public void start (Stage primaryStage){
        Button btn = new Button("Botón");
        Pane root= new Pane();
        TextField txt = new TextField("Ingresa elemento");
        root.getChildren().addAll(btn,txt);


        Random random=new Random();
        double x=random.nextDouble();

        EventHandler<javafx.scene.input.MouseEvent> CrearCirc = new EventHandler<javafx.scene.input.MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                AVL<String> avl = new AVL<>();
                String coso = txt.getText();
                avl.insertar(coso);
                nodo.setElemento(coso);
                Mover<Double> mover = new Mover<>();

                Drawer<String> c1 = new Drawer<>(xx,yy,nodo);

            }
        };

        btn.addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, CrearCirc);

        x=random.nextDouble();
        System.out.println(x);
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("Transition");
        primaryStage.setScene(scene);
        primaryStage.show();

}

    public static void main(String[]args) {
        launch(args);

    }


}