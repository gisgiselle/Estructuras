package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ui.NodoUI;

public class Main extends Application {
    AVL<String> avl = new AVL<>();
    ArbolPrinter<String> arbolPrinter = new ArbolPrinter<>();
   // NodoUI<String> tempPapa;
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello World");
        AVLVer avlVer= new AVLVer(avl);
        Pane gp = new Pane();
        BorderPane bp= new BorderPane();
        VBox vbox = new VBox();
        TextField cosoAdd = new TextField();
        Label label= new Label("Ingresa un número");
        Button button = new Button("Agregar");
        Button borrar = new Button("Borrar");
        TextField cosoBorrar = new TextField();
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

        vbox.getChildren().addAll(label,cosoAdd,button,avlVer,borrar,cosoBorrar);
        avlVer.setMaxWidth(300);
        bp.setLeft(vbox);
        bp.setCenter(gp);

        primaryStage.setScene(new Scene(bp,1000,1000));
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