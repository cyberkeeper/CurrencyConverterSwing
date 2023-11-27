import javax.swing.*;
import java.awt.*;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The starting point for the application.
 * @author ahart
 */
public class Main {

    public static void main(String[] args) {
        //create a new instance of the Main class.
        Main ccApp = new Main();
        //call the method to run the program
        ccApp.runProgram();
    }

    /**
     * This method will create an instance of the Currency JFrame which in turn holds all the
     * other components.
     */
    public void runProgram(){
        //find out or set which locale are we running from
        Locale whereAmI = Locale.getDefault();
        //switch locale to Spain for testing the locale.
        //Locale whereAmI = Locale.forLanguageTag("es");

        //set the default location for the Java virtual machine
        Locale.setDefault(whereAmI);

        //create the outer JFrame and give it a title
        ResourceBundle msgs = ResourceBundle.getBundle("converter");
        JFrame frame = new JFrame(msgs.getString("title"));

        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("Icon-Money.png"));
        frame.setIconImage(image);

        //set the content pane. This is the main panel in the form. Change the permission of
        //currencyForm from private to public in the Currency.java file.
        frame.setContentPane(new Currency().currencyForm);

        //set the exit on close
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set the frame to a size to accommodate all components
        frame.pack();

        //set the initial location. In this case the middle of the screen
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);

        //stop the user changing the size of the screen
        frame.setResizable(false);

        //make the frame appear on screen
        frame.setVisible(true);
    }
}