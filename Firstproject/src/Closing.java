import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Closing extends Frame {

    public Closing() {
        // Set the title of the frame
        setTitle("AVDHESH");

        // Add a WindowListener to handle the window closing event
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Handle the window closing event (e.g., close the frame)
                System.exit(0);
            }
        });

        // Set the size of the frame
        setSize(300, 200);

        // Make the frame visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Create an instance of Closing
        Closing closing = new Closing();
    }
}
