import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyHandler implements KeyListener {
    public boolean up, down, left, right;
    public int direction = 0; //standstill

    @Override
    public void keyTyped(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            up = true;
            direction = 1;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            up = false;
            direction = 0;
        }
    }

    /*@Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

            switch (code) {
            case (KeyEvent.VK_UP): {
                up = true;
                direction = 1;
            }
            case (KeyEvent.VK_DOWN): {
                down = true;
                direction = 2;
            }
            case (KeyEvent.VK_LEFT): {
                left = true;
                direction = 3;
            }
            case (KeyEvent.VK_RIGHT): {
                right = true;
                direction = 4;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();;

        switch (code) {
            case (KeyEvent.VK_UP): {
                up = false;
                direction = 0;
            }
            case (KeyEvent.VK_DOWN): {
                down = false;
                direction = 0;
            }
            case (KeyEvent.VK_LEFT): {
                left = false;
                direction = 0;
            }
            case (KeyEvent.VK_RIGHT): {
                right = false;
                direction = 0;
            }
        }
    }*/
}
