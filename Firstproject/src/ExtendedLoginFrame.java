import java.awt.*;
import java.awt.event.*;

public class ExtendedLoginFrame extends Frame implements ActionListener {

    private Label nameLabel, usernameLabel, passwordLabel, ageLabel, genderLabel, dobLabel, addressLabel,
            rollNoLabel, branchLabel, semesterLabel, contactLabel, emailLabel;

    private TextField nameField, usernameField, passwordField, ageField, addressField, rollNoField,
            contactField, emailField;

    private Choice dayChoice, monthChoice, yearChoice, branchChoice, semesterChoice;
    private CheckboxGroup genderCheckboxGroup;
    private Checkbox maleCheckbox, femaleCheckbox;

    private Button submitButton;

    public ExtendedLoginFrame() {
        // Set layout manager to null for absolute positioning
        setLayout(null);

        // Create labels
        nameLabel = new Label("Name:");
        usernameLabel = new Label("Username:");
        passwordLabel = new Label("Password:");
        ageLabel = new Label("Age:");
        genderLabel = new Label("Gender:");
        dobLabel = new Label("Date of Birth:");
        addressLabel = new Label("Address:");
        rollNoLabel = new Label("Roll No:");
        branchLabel = new Label("Branch:");
        semesterLabel = new Label("Semester:");
        contactLabel = new Label("Contact Number:");
        emailLabel = new Label("Email Address:");

        // Create text fields
        nameField = new TextField();
        usernameField = new TextField();
        passwordField = new TextField();
        ageField = new TextField();
        addressField = new TextField();
        rollNoField = new TextField();
        contactField = new TextField();
        emailField = new TextField();

        // Create gender checkboxes
        genderCheckboxGroup = new CheckboxGroup();
        maleCheckbox = new Checkbox("Male", genderCheckboxGroup, false);
        femaleCheckbox = new Checkbox("Female", genderCheckboxGroup, false);

        // Create Date of Birth dropdowns
        dayChoice = new Choice();
        monthChoice = new Choice();
        yearChoice = new Choice();

        // Create Branch and Semester dropdowns
        branchChoice = new Choice();
        semesterChoice = new Choice();

        // Create submit button
        submitButton = new Button("Submit");

        // Set positions and sizes
// Set positions and sizes
nameLabel.setBounds(50, 70, 80, 20);
usernameLabel.setBounds(50, 100, 80, 20);
passwordLabel.setBounds(50, 130, 80, 20);
ageLabel.setBounds(50, 160, 80, 20);
genderLabel.setBounds(50, 190, 80, 20);
dobLabel.setBounds(50, 220, 80, 20);
addressLabel.setBounds(50, 250, 80, 20);
rollNoLabel.setBounds(50, 280, 80, 20);
branchLabel.setBounds(50, 310, 80, 20);
semesterLabel.setBounds(50, 340, 80, 20);
contactLabel.setBounds(50, 370, 120, 20);
emailLabel.setBounds(50, 400, 120, 20);

nameField.setBounds(150, 70, 150, 20);
usernameField.setBounds(150, 100, 150, 20);
passwordField.setBounds(150, 130, 150, 20);
ageField.setBounds(150, 160, 150, 20);

maleCheckbox.setBounds(150, 190, 60, 20);
femaleCheckbox.setBounds(220, 190, 80, 20);

// Populate Date of Birth dropdowns
for (int i = 1; i <= 31; i++) {
    dayChoice.add(Integer.toString(i));
}
for (int i = 1; i <= 12; i++) {
    monthChoice.add(Integer.toString(i));
}
for (int i = 1900; i <= 2024; i++) {
    yearChoice.add(Integer.toString(i));
}

dayChoice.setBounds(150, 220, 40, 20);
monthChoice.setBounds(200, 220, 40, 20);
yearChoice.setBounds(250, 220, 60, 20);

addressField.setBounds(150, 250, 150, 20);
rollNoField.setBounds(150, 280, 150, 20);

// Populate Branch and Semester dropdowns
branchChoice.add("CSE");
branchChoice.add("MEC");
branchChoice.add("ECE");
for (int i = 1; i <= 8; i++) {
    semesterChoice.add(Integer.toString(i));
}

branchChoice.setBounds(150, 310, 80, 20);
semesterChoice.setBounds(150, 340, 80, 20);

contactField.setBounds(180, 370, 120, 20);
emailField.setBounds(180, 400, 120, 20);

submitButton.setBounds(120, 450, 80, 20);

        // Add components to the frame
        add(nameLabel);
        add(usernameLabel);
        add(passwordLabel);
        add(ageLabel);
        add(genderLabel);
        add(dobLabel);
        add(addressLabel);
        add(rollNoLabel);
        add(branchLabel);
        add(semesterLabel);
        add(contactLabel);
        add(emailLabel);

        add(nameField);
        add(usernameField);
        add(passwordField);
        add(ageField);
        add(maleCheckbox);
        add(femaleCheckbox);
        add(dayChoice);
        add(monthChoice);
        add(yearChoice);
        add(addressField);
        add(rollNoField);
        add(branchChoice);
        add(semesterChoice);
        add(contactField);
        add(emailField);

        add(submitButton);

        // Add ActionListener to the submit button
        submitButton.addActionListener(this);

        // Handle window close event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Set frame properties
        setTitle("Extended Login Form");
        setSize(400, 500);
        setVisible(true);
    }

    // Implement actionPerformed method for handling button click event
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            // Retrieve values from fields
            String name = nameField.getText();
            String username = usernameField.getText();
            String password = passwordField.getText();
            String age = ageField.getText();
            String gender = (maleCheckbox.getState()) ? "Male" : "Female";
            String dob = dayChoice.getSelectedItem() + "/" + monthChoice.getSelectedItem() + "/"
                    + yearChoice.getSelectedItem();
            String address = addressField.getText();
            String rollNo = rollNoField.getText();
            String branch = branchChoice.getSelectedItem();
            String semester = semesterChoice.getSelectedItem();
            String contact = contactField.getText();
            String email = emailField.getText();

            // Display information (you can replace this with further processing or validation)
            System.out.println("Name: " + name);
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            System.out.println("Age: " + age);
            System.out.println("Gender: " + gender);
            System.out.println("Date of Birth: " + dob);
            System.out.println("Address: " + address);
            System.out.println("Roll No: " + rollNo);
            System.out.println("Branch: " + branch);
            System.out.println("Semester: " + semester);
            System.out.println("Contact Number: " + contact);
            System.out.println("Email Address: " + email);
        }
    }

    public static void main(String[] args) {
        new ExtendedLoginFrame();
    }
}
