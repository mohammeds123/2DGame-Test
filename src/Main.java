import javax.swing.JFrame;
public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("2D Game Test");
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setFocusable(true);


        gamepanel gamePanel = new gamepanel();
        window.add(gamePanel);
        window.pack();
        gamePanel.startGameThread();

        
        }
    }
