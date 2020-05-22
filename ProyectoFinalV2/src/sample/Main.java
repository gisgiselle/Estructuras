package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Arbolito bb");
        primaryStage.setScene(new Scene(root, 300, 275));
        AVL<Integer> avl = new AVL<>();
        Drawer<Integer> draw = new Drawer<>();
        Nodo<Integer> nodo = new Nodo<>(10);
        Nodo<Integer> nodo2 = new Nodo<>(1);
        NodoUI<Integer> ui1 = new NodoUI<>(100,100,nodo);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
