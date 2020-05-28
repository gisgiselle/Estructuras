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
import ui.NodoUI;

import java.io.FileInputStream;

public class Main extends Application {
    AVL<String> avl = new AVL<>();
    ArbolPrinter<String> arbolPrinter = new ArbolPrinter<>();
    // NodoUI<String> tempPapa;
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello World");
        AVLVer avlVer= new AVLVer(avl);
        Pane gp = new Pane();
        GridPane grid = new GridPane();
        BorderPane bp= new BorderPane();
        VBox vbox = new VBox();
        VBox vbox2 = new VBox();
        HBox hb = new HBox();
        HBox hb2 = new HBox();
        Label titulo = new Label("AVL c:");

        TextField cosoAdd = new TextField("Ingresa una letra");;

        Button button = new Button("Agregar");
        Button borrar = new Button("Borrar");
        TextField cosoBorrar = new TextField("Ingresa lo que quieres borrar");
        arbolPrinter.printNodo(avl.getRaiz());
        //botoncito para agregar
        button.setOnAction(e ->{
            Nodo<String> nodo=new Nodo<>(cosoAdd.getText());
            avl.insertar(nodo.getElemento());
            avlVer.ver(cosoAdd.getText());
        });
        borrar.setOnAction(e ->{
            try {
                if (avl.buscarNodo(avl.getRaiz().getElemento()) == null) {
                    System.out.println("no hay algo que borrar");
                } else {
                    avl.borrar(avl.getRaiz(),cosoBorrar.getText());
                    avlVer.ver(cosoBorrar.getText());
                    ;
                }
            }catch(Exception ex){
                System.out.println("no");
            }
        });

        vbox.getChildren().addAll(hb,hb2);
        hb.getChildren().addAll(cosoAdd,button);
        hb.setPadding(new Insets(15, 12, 15, 12));
        hb2.getChildren().addAll(cosoBorrar,borrar);
        hb2.setPadding(new Insets(15, 12, 15, 12));
        hb.setStyle("-fx-background-color: #00ff2e ;");//verde
        vbox.setAlignment(Pos.CENTER);
        hb2.setStyle("-fx-background-color: #ff00fb ;");//rosa
        vbox.setStyle("-fx-background-color: #FF0000;");//rojo
        grid.setStyle("-fx-background-color: #7800ff ");//morado
        bp.setStyle("-fx-background-color: #FFFF00;"); //amarillo
        gp.setStyle("-fx-background-color: #0093ff;");//azul
        avlVer.setMaxWidth(300);
        vbox2.getChildren().add(avlVer);
        bp.setLeft(vbox);
        bp.setCenter(vbox2);




        primaryStage.setScene(new Scene(bp,900,800));
        primaryStage.show();
        primaryStage.setMinWidth(primaryStage.getWidth());
        primaryStage.setMinHeight(primaryStage.getHeight());
        //nodoUi.animate(200,200,a);
    }



    public static void main(String[] args) {
        launch(args);
    }
}
 /*if(avl.getRaiz()==null) {
                Nodo<String> nodo1 = new Nodo<>(textField.getText());
                NodoUI<String> nodoUI = new NodoUI<>(50, 50, nodo1);
                avl.insertar(nodo1.getElemento());
                gp.getChildren().add(nodoUI);
                nodoUI.animateRoot(gp.getWidth() / 2 - 50, 0);
                arbolPrinter.printNodo(nodo1);
                avl.insertar(nodoUI.getNodo().getElemento());
                tempPapa=nodoUI; //veremos
                System.out.println("Entra " +tempPapa.getNodo().getElemento());

            }else{
                Nodo<String> nodoPapa=avl.getRaiz() ;
                Nodo<String> nodoHijo=avl.getRaiz() ;
                Nodo<String> temp ;
                Nodo<String> nodo= new Nodo<>(textField.getText());
                avl.insertar(nodo.getElemento());

                while(nodoHijo.getElemento()!=textField.getText()) {
                    temp = nodo;

                }


                NodoUI<String> nodoUi=new NodoUI<>(50,50,nodo);
                gp.getChildren().add(nodoUi);
                Arista a= new Arista(tempPapa,nodoUi);
                System.out.println("Entra 2 "+tempPapa.getNodo().getElemento());
                nodoUi.animate(gp.getWidth()/2-50,0,a,gp);
                tempPapa=nodoUi;
                System.out.println("Entra 2.1 "+tempPapa.getNodo().getElemento());
            }

             */