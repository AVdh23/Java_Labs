import java.awt.*;
import java.awt.event.*;

public class FinalLogin extends Frame implements ActionListener {

    private Panel usernamePanel, passwordPanel;
    private TextField usernameField, passwordField;
    private Button loginButton, forgetButton;
    private Dialog forgetDialog;
    private TextArea resultTextArea;  // New component for displaying result

    private String currentUsername = "Avdhesh";
    private String currentPassword = "1234";

    public FinalLogin() {
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
        forgetButton.setForeground(Color.red); // Change the color of the Forget button

        // Create result TextArea
        resultTextArea = new TextArea("", 5, 30, TextArea.SCROLLBARS_VERTICAL_ONLY);
        resultTextArea.setEditable(false);
        resultTextArea.setBounds(50, 200, 300, 80);
        add(resultTextArea);

        // Set positions and sizes
        usernamePanel.setBounds(50, 50, 80, 30);
        passwordPanel.setBounds(50, 100, 80, 30);
        usernameField.setBounds(150, 50, 150, 30);
        passwordField.setBounds(150, 100, 150, 30);
        loginButton.setBounds(100, 150, 80, 30);
        forgetButton.setBounds(200, 150, 80, 30);

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
        setSize(400, 300);
        setVisible(true);

        // Set background color to gray
        setBackground(Color.lightGray);

        // Set color for buttons
        loginButton.setBackground(Color.black);
        loginButton.setForeground(Color.gray);
        forgetButton.setBackground(Color.black);
        forgetButton.setForeground(Color.gray);
        resultTextArea.setBackground(Color.LIGHT_GRAY);

        
    }

    // Implement actionPerformed method for handling button click event
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = passwordField.getText();
            
            // Validate login credentials
            if (username.equals(currentUsername) && password.equals(currentPassword)) {
                
                // If valid, display success message
                resultTextArea.setText("Login successful!");
            } else {
                // If invalid, display error message
                resultTextArea.setText("Invalid username or password. Please try again.");
            }
        } else if (e.getSource() == forgetButton) {
            // Open dialog for forget functionality
            showForgetDialog();
        }
    }

    private void showForgetDialog() {
        // Create a new dialog for forget functionality
        forgetDialog = new Dialog(this, "Forget Password", true);

        // Create labels and text fields for username, new password, and confirm password
        Label usernameLabel = new Label("Enter your username:");
        Label newPasswordLabel = new Label("New Password:");
        Label confirmPasswordLabel = new Label("Confirm Password:");

        TextField forgetUsernameField = new TextField();  // Change the variable name
        TextField newPasswordField = new TextField();
        TextField confirmPasswordField = new TextField();

        newPasswordField.setEchoChar('*');
        confirmPasswordField.setEchoChar('*');

        Button submitButton = new Button("Submit");

        // Set positions and sizes
        usernameLabel.setBounds(20, 50, 120, 30);
        newPasswordLabel.setBounds(20, 100, 120, 30);
        confirmPasswordLabel.setBounds(20, 150, 120, 30);

        forgetUsernameField.setBounds(150, 50, 150, 30);  // Change the variable name
        newPasswordField.setBounds(150, 100, 150, 30);
        confirmPasswordField.setBounds(150, 150, 150, 30);

        submitButton.setBounds(120, 190, 80, 30);

        // Add components to the forget dialog
        forgetDialog.setLayout(null);
        forgetDialog.add(usernameLabel);
        forgetDialog.add(newPasswordLabel);
        forgetDialog.add(confirmPasswordLabel);

        forgetDialog.add(forgetUsernameField);  // Change the variable name
        forgetDialog.add(newPasswordField);
        forgetDialog.add(confirmPasswordField);

        forgetDialog.add(submitButton);

        // Add ActionListener to the submit button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Validate username and password
                String enteredUsername = forgetUsernameField.getText();  // Change the variable name
                String newPassword = newPasswordField.getText();
                String confirmPassword = confirmPasswordField.getText();

                if (enteredUsername.equals(currentUsername) && newPassword.equals(confirmPassword)) {
                    // If valid, change the password and username
                    currentUsername = enteredUsername;
                    currentPassword = newPassword;
                    resultTextArea.setText("Password change successful!");
                } else {
                    // If invalid, display error message
                    resultTextArea.setText("Invalid details. Please try again.");
                }
                forgetDialog.dispose(); // Close the dialog
            }
        });

        // Handle window close event for the forgetDialog
        forgetDialog.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                forgetDialog.dispose(); // Close the dialog when the cross button is clicked
            }
        });

        // Set dialog properties
        forgetDialog.setSize(400, 250);
        forgetDialog.setBackground(Color.lightGray); // Set background color of forgetDialog
        forgetDialog.setVisible(true);
    }

    public static void main(String[] args) {
        new FinalLogin();
    }
}

//Ho nahi rha i think we need to use database for this , but vo nahi aata abhi  mai sirf output on the loginpage pe daalne ka try karta hu 