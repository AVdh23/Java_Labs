import java.awt.*;
import java.awt.event.*;

public class LoginFrameColor1 extends Frame implements ActionListener {

    private Panel usernamePanel, passwordPanel;
    private TextField usernameField, passwordField;
    private Button loginButton, loginButton1;

    public LoginFrameColor1() {
        // Set layout manager to null for absolute positioning
        setLayout(null);

        // Create panels for labels
        usernamePanel = new Panel();
        passwordPanel = new Panel();

        // Set background color for label panels
        usernamePanel.setBackground(Color.black);
        passwordPanel.setBackground(Color.black);

        // Create labels
        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");

        // Set foreground color for labels
        usernameLabel.setForeground(Color.white);
        passwordLabel.setForeground(Color.white);

        // Create text fields
        usernameField = new TextField();
        passwordField = new TextField();
        passwordField.setEchoChar('*'); // Set password field to show '*' for each character

        // Create login button
        loginButton = new Button("Login");
        loginButton1 = new Button("Login");

        // Set positions and sizes
        usernamePanel.setBounds(50, 50, 80, 30);
        passwordPanel.setBounds(50, 100, 80, 30);
        usernameField.setBounds(150, 50, 150, 30);
        passwordField.setBounds(150, 100, 150, 30);
        loginButton.setBounds(120, 150, 80, 30);
        loginButton1.setBounds(120, 180, 80, 30);

        // Add components to the frame
        usernamePanel.add(usernameLabel);
        passwordPanel.add(passwordLabel);
        add(usernamePanel);
        add(passwordPanel);
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

        // Set color for button
        loginButton.setBackground(Color.black);
        loginButton.setForeground(Color.gray);
        loginButton1.setBackground(Color.black);
        loginButton1.setForeground(Color.gray);
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
        new LoginFrameColor1();
    }
}
