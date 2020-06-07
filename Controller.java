package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import sample.asyncTask;

import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.paint.Color.BLUE;

public class Controller implements Initializable {

    @FXML
    Canvas canvas;
    @FXML
    TextField height;
    @FXML
    TextField width;
    @FXML
    TextField b;
    GraphicsContext g;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        g = canvas.getGraphicsContext2D();

    }
    @FXML
    public void handleInit(){
        g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    @FXML
    public void handleStart() {
        double d = Double.parseDouble(width.getText());
        double h = Double.parseDouble(height.getText());
        double b1 = Double.parseDouble(b.getText());
        asyncTask task = new asyncTask(canvas,d,h,b1);
        new Thread(task).start();
    }
}
