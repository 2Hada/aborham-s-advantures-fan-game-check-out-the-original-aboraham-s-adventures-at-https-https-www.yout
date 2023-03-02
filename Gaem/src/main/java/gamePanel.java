import javax.swing.*;
import java.awt.*;

public class gamePanel extends JPanel implements Runnable {
    private static final int FPS = 30;
    //sets individual tile sizes
    final int ogTileSize = 16; //actual tilesize
    final int scaleSize = 4;
    final int tileSize = ogTileSize * scaleSize; //rescale since 32x32 is too small for 1920x1080 screens

    //sets screen size
    final int colScreen = 16; //4
    final int rowScreen = 12; //3

    final int screenWidth = tileSize * colScreen;
    final int screenHeight = tileSize * rowScreen;

    keyHandler kh = new keyHandler();
    Thread t;

    int pX = screenWidth/2;
    int pY = screenHeight/2;
    int pSpeed = tileSize;

    public gamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true); //what the fuck is this? is this vsync??????
        this.addKeyListener(kh);
        this.setFocusable(true);
    }

    public void startThread() {
        t = new Thread(this); //???
        t.start();
    }

    @Override
    public void run() { //god save me
        double drawInterval = 1_000_000_000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (t != null) {
            currentTime = System.nanoTime();
            lastTime = currentTime;
            delta += (currentTime - lastTime) / drawInterval;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

   /* public void update() {
        switch (kh.direction) {
            case 1:
                pY -= pSpeed; //up
            case 2:
                pY += pSpeed; //down
            case 3:
                pX -= pSpeed; //left
            case 4:
                pX += pSpeed; //right
        }
    }*/

    public void update() {
        if (kh.up == true) {
            pY -= pSpeed;
        } else if (kh.down == true) {
            pY+= pSpeed;
        } else if (kh.left == true) {
            pX -= pSpeed;
        } else if (kh.right == true) {
            pY += pSpeed;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g; //cast g as g2d idk either lmao
        g2d.setColor(Color.BLUE);
        g2d.fillRect(pX, pY, tileSize, tileSize); //man this is gonna be a pain in the ass
        g2d.dispose(); //what
    }
}
