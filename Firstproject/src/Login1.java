import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login1 extends Frame implements ActionListener {
    // Components
    private Label userLabel, passwordLabel, messageLabel;
    private TextField userTextField, passwordTextField;
    private Button loginButton;

    // Constructor
    public Login1() {
        // Frame settings
        setTitle("Login Page");
        setSize(300, 200);
        setLayout(new FlowLayout());

        // Components initialization
        userLabel = new Label("Username:");
        userTextField = new TextField(20);

        passwordLabel = new Label("Password:");
        passwordTextField = new TextField(20);
        passwordTextField.setEchoChar('*'); // Display * for password characters

        loginButton = new Button("Login");
        loginButton.addActionListener(this);

        messageLabel = new Label("");

        // Adding components to the frame
        add(userLabel);
        add(userTextField);
        add(passwordLabel);
        add(passwordTextField);
        add(loginButton);
        add(messageLabel);
    }

    // Action performed when the login button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = userTextField.getText();
        String password = passwordTextField.getText();

        // Implement your authentication logic here
        if (authenticate(username, password)) {
            messageLabel.setText("Login Successful!");
        } else {
            messageLabel.setText("Login Failed. Please check your credentials.");
        }
    }

    // Example authentication logic (replace with your own logic)
    private boolean authenticate(String username, String password) {
        // Add your authentication logic here
        // For example, check against a database or other authentication service
        // Return true if authentication is successful, false otherwise
        // For demonstration purposes, always return true in this example
        return true;
    }

    public static void main(String[] args) {
        // Create and display the login frame
        Login1 loginFrame = new Login1();
        loginFrame.setVisible(true);

        // Close the application when the window is closed
        loginFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });
    }
}
