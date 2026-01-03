import javax.swing.JPanel;
import java.awt.*;

public class gamepanel extends JPanel implements Runnable {
    final int originalTileSize = 16;
    final int scale = 3;
    final int tileSize = originalTileSize * scale; //48*48 Tile size
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    int FPS = 60;
    KeyInput keyI = new KeyInput();
    Thread gameThread;

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public gamepanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyI);
        this.setFocusable(true);
        this.requestFocusInWindow();  // Explicitly request focus for the gamepanel


    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    

    @Override
    public void run() {
        while (gameThread != null) {
            long currentTime = System.nanoTime();

            // UPDATE INFORMATION ON PLAYER POSITION + MAP
            update();

            // UPDATE DRAWING ON THE WINDOW ACCORDING TO INFORMATION
            repaint();

        }
    }

    public void update() {
        if (keyI.upPressed) {
            playerY = playerY - playerSpeed;
            System.out.println("AAAA");
        }
        else if (keyI.downPressed) {
            playerY = playerY + playerSpeed;
        }
        else if (keyI.leftPressed) {
            playerX = playerX - playerSpeed;
        }
        else if (keyI.rightPressed) {
            playerX = playerX + playerSpeed;
        }

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);
        g2.fillRect(playerX,playerY,tileSize,tileSize);
        g2.dispose();

    }
}
