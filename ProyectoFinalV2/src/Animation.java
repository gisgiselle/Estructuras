import javafx.animation.TranslateTransition;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Animation {
    Circle c;

    public void animarEntrada(Circle c, double x, double y){
        TranslateTransition trans1 = new TranslateTransition(Duration.seconds(1),c);
    }
}
