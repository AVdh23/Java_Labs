import java.awt.*;
import java.awt.event.*;

public class LoginFrameColor extends Frame implements ActionListener {

    private Label usernameLabel, passwordLabel;
    private TextField usernameField, passwordField;
    private Button loginButton;

    public LoginFrameColor() {
        // Set layout manager to null for absolute positioning
        setLayout(null);

        // Create labels
        usernameLabel = new Label("Username:");
        passwordLabel = new Label("Password:");

        // Create text fields
        usernameField = new TextField();
        passwordField = new TextField();
        passwordField.setEchoChar('*'); // Set password field to show '*' for each character

        // Create login button
        loginButton = new Button("Login");

        // Set positions and sizes
        usernameLabel.setBounds(50, 50, 80, 30);
        passwordLabel.setBounds(50, 100, 80, 30);
        usernameField.setBounds(150, 50, 150, 30);
        passwordField.setBounds(150, 100, 150, 30);
        loginButton.setBounds(120, 150, 80, 30);

        // Add components to the frame
        add(usernameLabel);
        add(passwordLabel);
        add(usernameField);
        add(passwordField);
        add(loginButton);

        // Add ActionListener to the login button
        loginButton.addActionListener(this);

        // Handle window close event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Set frame properties
        setTitle("Login Form");
        setSize(350, 250);
        setVisible(true);

        // Set background color to gray
        setBackground(Color.lightGray);

        // Set color for labels and button
        usernameLabel.setForeground(Color.black);
        passwordLabel.setForeground(Color.black);
        loginButton.setBackground(Color.black);
        loginButton.setForeground(Color.gray);
    }

    // Implement actionPerformed method for handling button click event
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = passwordField.getText();

            // Validate login credentials
            if (username.equals("Avdhesh") && password.equals("1234")) {
                // If valid, display success message
                System.out.println("Login successful!");
            } else {
                // If invalid, display error message
                System.out.println("Invalid username or password. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        new LoginFrameColor();
    }
}
