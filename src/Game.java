import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    private final int WIDTH = 700;
    private final int HEIGHT = 1000;

    public Game(){
        startGame();
    }

    public void startGame(){
        add(new Board());
        setResizable(false);
        setTitle("GameMVP");
        setSize(WIDTH,HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String [] args){
        EventQueue.invokeLater(() -> {
            Game game = new Game();
            game.setVisible(true);
        });

    }
}
