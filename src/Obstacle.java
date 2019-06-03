import org.w3c.dom.css.Rect;

import javax.swing.*;
import java.awt.*;

public class Obstacle  {

//
//    private Rectangle obs;
     private int  x;
    private int y;
    private int w;
    private int h;
    private int velX = 3;
    private int velY = 3;

    public Obstacle(int x, int y, int w, int h){
     this.x = x;
     this.y = y;
     this.w = w;
     this.h = h;



    }
    public void drawObs(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
//        g.drawRect(500,500,150,150);
        g2d.setColor(Color.BLACK);

        g2d.fillRect(x,y,w,h);

    }

    public void move(){
        y += velY;
    }

    public int getX(){

        return x;
    }

    public int getY()
    {
        return y;
    }
    public Rectangle getRectBounds(){
        return new Rectangle(x,y,w,h);
    }

    public int getHeight(){
        return h;
    }

    public int getWidth(){
        return w;
    }

}
