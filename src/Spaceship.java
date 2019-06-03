import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Spaceship {
    private int dx;
    private int dy;
    private int x = 350;
    private int y = 800;
    private int w;
    private int h;
    private Image shipImage;

     public Spaceship(){
        loadImage();
    }

    public void loadImage(){
        ImageIcon tempImg = new ImageIcon("src/spaceship.png");
        shipImage = tempImg.getImage();
        shipImage = shipImage.getScaledInstance(50,50,Image.SCALE_DEFAULT);

        w = 75;
        h = 75;
    }

    public void move(){
         x += dx;
         y += dy;
    }

    public int getX(){
         return x;
    }

    public int getY(){
         return y;
    }

    public int getHeight(){
         return h;
    }

    public int getWidth(){
         return w;
    }

    public Image getImage(){
        return shipImage;
    }

    public Rectangle newRect(){
         return new Rectangle(x,y,w-10,h-10);
    }

    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT){
            dx = -10;
        }
        if (key == KeyEvent.VK_RIGHT){
            dx = 10;
        }

    }

//    public void keyReleased(KeyEvent e){
//         int key = e.getKeyCode();
//
//        if (key == KeyEvent.VK_LEFT){
//            dx = 0;
//        }
//        if (key == KeyEvent.VK_RIGHT){
//            dx = 0;
//        }
//        if (key == KeyEvent.VK_UP){
//            dx = 0;
//        }
//        if (key == KeyEvent.VK_DOWN){
//            dx = 0;
//        }
//
//    }

}
