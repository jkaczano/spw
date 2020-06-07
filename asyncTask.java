package sample;

import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.awt.*;
import java.awt.image.BufferedImage;

import static javafx.scene.paint.Color.WHITE;

public class asyncTask extends Task {

    GraphicsContext g;
    Canvas canvas;
    double d,h,b;
    public asyncTask(Canvas canvas, double d, double h,double b){
        this.g = canvas.getGraphicsContext2D();
        this.canvas = canvas;
        this.d = d;
        this.h = h;
        this.b = b;
    }


    @Override
    protected Object call() throws Exception {
        BufferedImage img = new BufferedImage((int)(canvas.getWidth()),(int)canvas.getHeight(),BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        climg(img);
        double x1,x2,y1,y2,r,a=h;
        int n=(int)d;
        System.out.println(n+" "+a+" "+b);
        for(double i=0; i<2*Math.PI;i+=0.01){
            r = a + b*(Math.tanh(b*Math.sin(n*i)));
            x1 = r*Math.cos(i);
            y1 = r*Math.sin(i);
            r = a + b*(Math.tanh(b*Math.sin(n*(i+0.01))));
            x2 = r*Math.cos(i+0.01);
            y2 = r*Math.sin(i+0.01);
            g2d.setPaint(Color.BLACK);
            //g2d.drawRect((int)(x1+canvas.getWidth()/2),(int)(canvas.getHeight()/2+y1),1,1);
            g2d.drawLine((int)(x1+canvas.getWidth()/2),(int)(canvas.getHeight()/2+y1),(int)(x2+canvas.getWidth()/2),(int)(canvas.getHeight()/2+y2));
            g.drawImage(SwingFXUtils.toFXImage(img, null),0 ,0);
        }

        return null;
    }

    void climg(BufferedImage img){
        for(int i=0;i<img.getWidth();i++){
            for(int j=0;j<img.getHeight();j++){
                img.setRGB(i,j,java.awt.Color.WHITE.getRGB());
            }
        }
    }
}
