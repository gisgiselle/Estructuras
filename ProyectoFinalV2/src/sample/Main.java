package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    Pane gp = new Pane();
    AVL<String> avl = new AVL<>();
    ArbolPrinter<String> arbolPrinter = new ArbolPrinter<>();
    AVLVer<String> avlVer= new AVLVer<>(avl,gp);
    @Override
    
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello World");
       
        BorderPane bp= new BorderPane();
        VBox vbox = new VBox();
        VBox vbox2 = new VBox();
        HBox hb = new HBox();
        HBox hb2 = new HBox();

        TextField cosoAdd = new TextField("Ingresa una letra");;
        
        Button button = new Button("Agregar");
        button.setMaxSize(50, 20);
        Button borrar = new Button("Borrar");
        TextField cosoBorrar = new TextField("borrar");
 
        //botoncito para agregar
        button.setOnAction(e ->{
            Nodo<String> nodo=new Nodo<>(cosoAdd.getText());
            avl.insertar(nodo.getElemento());
             NodoUI<String> nodoUI = new NodoUI<>(50,50,nodo);
            avlVer.agregarUI(nodoUI);
           // avlVer.ver(cosoAdd.getText());
        });

        //boton para borrar
        borrar.setOnAction(e ->{
            String quieroBorrar = cosoBorrar.getText();
            avl.borrar(quieroBorrar);
            //avlVer.ver(avl.getRaiz().getElemento());
        });

        vbox.getChildren().addAll(hb,hb2);
        vbox2.getChildren().addAll(avlVer,gp);
        hb.getChildren().addAll(cosoAdd,button);
        hb2.getChildren().addAll(cosoBorrar,borrar);
        vbox.setAlignment(Pos.CENTER);

        hb.setPadding(new Insets(15, 12, 15, 12));
        hb2.setPadding(new Insets(15, 12, 15, 12));

        bp.setLeft(vbox);
        bp.setCenter(vbox2);

        /* hb.setStyle("-fx-background-color: #00ff2e ;");//verde
        hb2.setStyle("-fx-background-color: #ff00fb ;");//rosa
        vbox.setStyle("-fx-background-color: #FF0000;");//rojo
        grid.setStyle("-fx-background-color: #7800ff ");//morado
        bp.setStyle("-fx-background-color: #FFFF00;"); //amarillo
        gp.setStyle("-fx-background-color: #0093ff;");//azul
        */

        primaryStage.setScene(new Scene(bp,900,800));
        primaryStage.show();
        primaryStage.setMinWidth(primaryStage.getWidth());
        primaryStage.setMinHeight(primaryStage.getHeight());
    }


}
