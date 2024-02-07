import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FinalQ3 extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;

    public FinalQ3() {
        setTitle("JTable Example");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Use null layout

        // Create the table
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Age");
        model.addRow(new Object[]{"", "", ""}); // Add an empty row initially

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 10, 400, 300);
        add(scrollPane);

        // Create panel for labels (ID, Name, Age) and text fields
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 320, 150, 120); // Adjust y-coordinate to place it below the JTable

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(0, 0, 50, 25);
        panel.add(idLabel);

        idField = new JTextField();
        idField.setBounds(60, 0, 80, 25);
        panel.add(idField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(0, 35, 50, 25);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(60, 35, 80, 25);
        panel.add(nameField);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(0, 70, 50, 25);
        panel.add(ageLabel);

        ageField = new JTextField();
        ageField.setBounds(60, 70, 80, 25);
        panel.add(ageField);

        // Add the panel to the frame
        add(panel);

        // Create buttons using absolute positioning
        addButton = new JButton("Add");
        addButton.setBounds(200, 320, 100, 25);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRow();
            }
        });
        add(addButton);

        updateButton = new JButton("Update");
        updateButton.setBounds(200, 354, 100, 25);
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateRow();
            }
        });
        add(updateButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(200, 387, 100, 25);
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRow();
            }
        });
        add(deleteButton);

        // Handle mouse click event on the table
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = table.getSelectedRow();
                if (row != -1) {
                    idField.setText((String) table.getValueAt(row, 0));
                    nameField.setText((String) table.getValueAt(row, 1));
                    ageField.setText((String) table.getValueAt(row, 2));
                }
            }
        });
    }

    private void addRow() {
        String[] data = {idField.getText(), nameField.getText(), ageField.getText()};
        model.addRow(data);
    }

    private void deleteRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
        }
    }

    private void updateRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            model.setValueAt(nameField.getText(), selectedRow, 1);
            model.setValueAt(ageField.getText(), selectedRow, 2);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FinalQ3 example = new FinalQ3();
                example.setVisible(true);
            }
        });
    }
}
