import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Board extends JPanel implements ActionListener {
    private int arrSize  = 150;
    private int health = 10;
    private int leftObstacleX = 0;
    private int rightObstacleX;
    ArrayList arrayListLeft = new ArrayList(arrSize);
    ArrayList arrayListRight = new ArrayList(arrSize);
    ArrayList arrayListAstronaut = new ArrayList(arrSize);
    private final int DELAY = 16;
    private Timer timer;
    private int offset = 0;
    private int offset2 = 0;
    private int numAstro = 0;

    private Spaceship spaceship;

    private Obstacle temp;
    private Astronaut temp2;

    private Astronaut astrologyBoy = new Astronaut(3,700);

    private boolean gameOver = false;



    public Board(){


            initBoard();




    }

    public void initBoard(){
//        System.out.println(arrayList.size());
        addKeyListener(new keyAdapter());
        setFocusable(true);
//        rock = new Obstacle(350,0,150,150);
        spaceship = new Spaceship();
        setBackground(Color.PINK);
        loadArrList();
//        loadArrListRight();
        timer = new Timer(DELAY, this);
        timer.start();

    }

    public void loadArrList(){
        Random r = new Random();
//        r.nextInt(high-low) + low
        int width;

        for (int i = 0;i<arrSize;i++){
            width = r.nextInt(300-100) + 100;
            int n = r.nextInt(5-1)+1;
            arrayListLeft.add(new Obstacle(leftObstacleX, offset, width ,45));
            arrayListRight.add(new Obstacle(700 - width, offset, width ,45));
            arrayListAstronaut.add(new Astronaut(n,offset));
            System.out.println(n);
            offset-= 300;
        }
    }

//    public void loadArrListRight(){
//        Random r = new Random();
//
//        for (int i = 0;i<arrSize;i++){
//            arrayListRight.add(new Obstacle(500, offset2, 50 ,45));
//            offset2-= 300;
//        }
//
//    }

    public void checkCollision(){
        for(int i = 0;i<arrayListLeft.size();i++){
            temp = (Obstacle) arrayListLeft.get(i);
            Rectangle temp1 = temp.getRectBounds().getBounds();
            if (temp1.intersects(spaceship.newRect())){
                System.out.println("collisionLeftgfgdfgdfgd");
//                arrayList.remove(i);
                health--;
            }
        }


        for(int i = 0;i<arrayListRight.size();i++){
            temp = (Obstacle) arrayListRight.get(i);
            Rectangle temp1 = temp.getRectBounds().getBounds();
            if (temp1.intersects(spaceship.newRect())){
                System.out.println("collisionRight");
//                arrayList.remove(i);
                health--;
            }
        }

        for(int i = 0;i<arrayListAstronaut.size();i++){
            temp2 = (Astronaut) arrayListAstronaut.get(i);
//            Rectangle temp1 = temp2.getRectBounds().getBounds();
            if (temp2.newRect().intersects(spaceship.newRect())){
                System.out.println("collisionAstro");
//                arrayList.remove(i);
                arrayListAstronaut.remove(i);
                numAstro++;
            }
        }
    }

    public void checkHealth(){
        if(health <= 0){
            gameOver = true;
        }
    }

//    public Image loadAstro(int n){
//        ImageIcon tempImg = new ImageIcon("src/a"+ n + ".png");
//        Image shipImage = tempImg.getImage();
//        return shipImage.getScaledInstance(50,50,Image.SCALE_DEFAULT);
//
////        w = 75;
////        h = 75;
//    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);


//        drawAstronaut(g, astrologyBoy);
        if (gameOver == false) {

            for (int i = 0; i < arrayListAstronaut.size(); i++) {
                temp2 = (Astronaut) arrayListAstronaut.get(i);
                drawAstronaut(g, temp2);
//
            }


//        rock.drawObs(g);
            for (int i = 0; i < arrayListLeft.size(); i++) {
                temp = (Obstacle) arrayListLeft.get(i);
                temp.drawObs(g);
//
            }

            for (int i = 0; i < arrayListRight.size(); i++) {
                temp = (Obstacle) arrayListRight.get(i);
                temp.drawObs(g);
//
            }

            drawShip(g);


            drawBanner(g);
            g.setColor(Color.BLACK);
            g.drawString("Space Ship Health: " + health, 50, 50);
            g.drawString("Astronauts Rescued: " + numAstro, 500, 50);
        }
        else if (gameOver == true){
            drawGameOver(g);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    public void drawShip(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(spaceship.getImage(), spaceship.getX(), spaceship.getY(), this);

    }
    public void drawAstronaut(Graphics g, Astronaut astroInst){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(astroInst.getImage(), astroInst.getX(), astroInst.getY(), 50,75,this);
    }
    public void drawBanner(Graphics g){
        Graphics g2d = (Graphics2D) g;
        g2d.setColor(Color.YELLOW);
        g2d.fillRect(0,0,700,100);
    }

    public void drawGameOver(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,700,1000);
        g.setColor(Color.PINK);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
        g.drawString("Game Over",300,475);
    }



        @Override
        public void actionPerformed(ActionEvent e) {
            moveXY();
            checkCollision();
            checkHealth();
        }

        public void moveXY(){
            spaceship.move();
            astrologyBoy.move();
//            rock.move();
            for(int i = 0;i<arrayListLeft.size();i++){
                temp = (Obstacle) arrayListLeft.get(i);
                temp.move();

            }

            for(int i = 0;i<arrayListRight.size();i++){
                temp = (Obstacle) arrayListRight.get(i);
                temp.move();

            }

            for(int i = 0;i<arrayListAstronaut.size();i++){
                temp2 = (Astronaut) arrayListAstronaut.get(i);
                temp2.move();

            }

//            repaint(spaceship.getX()-2, spaceship.getY()-2,spaceship.getWidth(),spaceship.getHeight());
//

                repaint();

//
        }

        private class keyAdapter extends KeyAdapter  {
//            public void keyReleased(KeyEvent e){
////                spaceship.keyReleased(e);
////            }

            public void keyPressed(KeyEvent e){
                spaceship.keyPressed(e);
            }
        }



}
