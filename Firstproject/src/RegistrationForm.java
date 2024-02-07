import java.awt.*;
import java.awt.event.*;

public class RegistrationForm extends Frame implements ActionListener {

    private Label avdheshLabel, kumarLabel;
    private Label nameLabel, ageLabel, genderLabel, dobLabel, addressLabel,
            rollNoLabel, branchLabel, semesterLabel, contactLabel, emailLabel;

    private TextField nameField, ageField, addressField, rollNoField,
            contactField, emailField, outputField;

    private Choice dayChoice, monthChoice, yearChoice, branchChoice, semesterChoice;
    private CheckboxGroup genderCheckboxGroup;
    private Checkbox maleCheckbox, femaleCheckbox;

    private Button submitButton;

    public RegistrationForm() {
        // Set layout manager to null for absolute positioning
        setLayout(null);

        // Create labels for names
        avdheshLabel = new Label("Registration");
        kumarLabel = new Label("Form");
        
        // Set positions and sizes for name labels
        avdheshLabel.setBounds(50, 40, 150, 30);
        kumarLabel.setBounds(200, 40, 80, 30);

        // Increase text size
        Font labelFont = new Font("Arial", Font.PLAIN, 25); // Choose your desired font and style
        avdheshLabel.setFont(labelFont);
        kumarLabel.setFont(labelFont);

        // Create labels for other fields
        nameLabel = new Label("Name:");
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
        ageField = new TextField();
        addressField = new TextField();
        rollNoField = new TextField();
        contactField = new TextField();
        emailField = new TextField();
        outputField = new TextField();

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

        // Set positions and sizes for other labels
        nameLabel.setBounds(50, 70, 80, 20);
        ageLabel.setBounds(50, 100, 80, 20);
        genderLabel.setBounds(50, 130, 80, 20);
        dobLabel.setBounds(50, 160, 80, 20);
        addressLabel.setBounds(50, 190, 80, 20);
        rollNoLabel.setBounds(50, 220, 80, 20);
        branchLabel.setBounds(50, 250, 80, 20);
        semesterLabel.setBounds(50, 280, 80, 20);
        contactLabel.setBounds(50, 310, 120, 20);
        emailLabel.setBounds(50, 340, 120, 20);

        // Set positions and sizes for text fields
        nameField.setBounds(150, 70, 150, 20);
        ageField.setBounds(150, 100, 150, 20);

        maleCheckbox.setBounds(150, 130, 60, 20);
        femaleCheckbox.setBounds(220, 130, 80, 20);

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

        dayChoice.setBounds(150, 160, 40, 20);
        monthChoice.setBounds(200, 160, 40, 20);
        yearChoice.setBounds(250, 160, 60, 20);

        addressField.setBounds(150, 190, 150, 20);
        rollNoField.setBounds(150, 220, 150, 20);

        // Populate Branch and Semester dropdowns
        branchChoice.add("CSE");
        branchChoice.add("MEC");
        branchChoice.add("ECE");
        for (int i = 1; i <= 8; i++) {
            semesterChoice.add(Integer.toString(i));
        }

        branchChoice.setBounds(150, 250, 80, 20);
        semesterChoice.setBounds(150, 280, 80, 20);

        contactField.setBounds(180, 310, 120, 20);
        emailField.setBounds(180, 340, 120, 20);

        submitButton.setBounds(120, 380, 80, 20);
        outputField.setBounds(50, 410, 300, 20);

        // Add components to the frame
        add(avdheshLabel);
        add(kumarLabel);
        
        add(nameLabel);
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
        add(outputField);

        // Add ActionListener to the submit button
        submitButton.addActionListener(this);

        // Handle window close event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        // Set frame properties
        setTitle("Registration Form");
        setSize(400, 500);
        setVisible(true);
    }

    // Implement actionPerformed method for handling button click event
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            // Retrieve values from fields
            String name = nameField.getText();
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

            // Construct output string
            String output = "Name: " + name + "\n" +
                            "Age: " + age + "\n" +
                            "Gender: " + gender + "\n" +
                            "Date of Birth: " + dob + "\n" +
                            "Address: " + address + "\n" +
                            "Roll No: " + rollNo + "\n" +
                            "Branch: " + branch + "\n" +
                            "Semester: " + semester + "\n" +
                            "Contact Number: " + contact + "\n" +
                            "Email Address: " + email;

            // Display information in output field
            outputField.setText(output);
        }
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}
