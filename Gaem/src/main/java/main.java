import java.util.*;
import javax.swing.JFrame;
/*I need a second monitor, please donate funds to my paypal.
  if I do not have $440 sent to my papyal by hthe end of the month
  then I will quit this project.
  please undertsand and tahnak youf or yor support
*/
public class main {
    public static void main(String[] args) {
        System.setProperty("sun.java2d.opengl", "true");
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false); //fuck you and your scaling math bullshit
        window.setTitle("Aborham");

        gamePanel g = new gamePanel();
        window.add(g);

        window.pack(); //runs default constructor (??)

        window.setLocationRelativeTo(null); //no cap I have no idea how this works
        window.setVisible(true); //why do I need this
    }
}
