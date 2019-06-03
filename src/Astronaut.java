import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Astronaut {

    private Image image;
    private int w, h;
    private int velY = 2;
    private int  y;


    Random r = new Random();
    private int x = r.nextInt(600-100) + 100;


    public Astronaut(int n, int y){
        loadImage(n);
        this.y = y;
    }

    public void loadImage(int n){
        ImageIcon tempImg = new ImageIcon("src/a" + n + ".png");
        image = tempImg.getImage();
//        image = image.getScaledInstance(75,50,Image.SCALE_DEFAULT);

        w = 75;
        h = 75;
    }



    public void move(){
        y += velY;
//        System.out.println(y);
    }

    public int getHeight(){
        return h;
    }

    public int getWidth(){
        return w;
    }

    public int getY(){
        return y;
    }

    public int getX() {
        return x;
    }

    public Image getImage(){
        return image;
    }

    public Rectangle newRect(){
        return new Rectangle(x,y,40,60);
    }
}
