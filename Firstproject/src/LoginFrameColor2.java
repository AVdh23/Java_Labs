import java.awt.*;
import java.awt.event.*;

public class LoginFrameColor2 extends Frame implements ActionListener {

    private Panel usernamePanel, passwordPanel;
    private TextField usernameField, passwordField;
    private Button loginButton, forgetButton;
    private Frame forgetFrame;

    public LoginFrameColor2() {
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

        // Create forget button
        forgetButton = new Button("Forget ?");
        forgetButton.setForeground(Color.blue);

        // Set positions and sizes
        usernamePanel.setBounds(50, 50, 80, 30);
        passwordPanel.setBounds(50, 100, 80, 30);
        usernameField.setBounds(150, 50, 150, 30);
        passwordField.setBounds(150, 100, 150, 30);
        loginButton.setBounds(120, 150, 80, 30);
        forgetButton.setBounds(20, 200, 60, 20);

        // Add components to the frame
        usernamePanel.add(usernameLabel);
        passwordPanel.add(passwordLabel);
        add(usernamePanel);
        add(passwordPanel);
        add(usernameField);
        add(passwordField);
        add(loginButton);
        add(forgetButton);

        // Add ActionListener to the buttons
        loginButton.addActionListener(this);
        forgetButton.addActionListener(this);

        // Handle window close event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Set frame properties
        setTitle("Login Form");
        setSize(400, 250);
        setVisible(true);

        // Set background color to gray
        setBackground(Color.lightGray);

        // Set color for buttons
        loginButton.setBackground(Color.black);
        loginButton.setForeground(Color.gray);
        forgetButton.setBackground(Color.lightGray);
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
        } else if (e.getSource() == forgetButton) {
            // Open another frame for forget panel
            showForgetPanel();
        }
    }

    private void showForgetPanel() {
        // Create a new frame for forget panel
        forgetFrame = new Frame("Forget Panel");

        // Create labels
        Label usernameLabel = new Label("Username:");
        Label emailLabel = new Label("Email:");
        Label passwordLabel = new Label("Password:");

        // Set foreground color for labels
        usernameLabel.setForeground(Color.black);
        emailLabel.setForeground(Color.black);
        passwordLabel.setForeground(Color.black);

        // Set positions and sizes
        usernameLabel.setBounds(50, 50, 80, 30);
        emailLabel.setBounds(50, 100, 80, 30);
        passwordLabel.setBounds(50, 150, 80, 30);

        // Add components to the forget frame
        forgetFrame.add(usernameLabel);
        forgetFrame.add(emailLabel);
        forgetFrame.add(passwordLabel);

        // Set frame properties
        forgetFrame.setLayout(null);
        forgetFrame.setSize(300, 250);
        forgetFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginFrameColor2();
    }
}//isme closing wala add nahi hua hai on the forget wale mein , position hmmbaad mein add karenge that's not an issue the thing is we need to add the closing event first
