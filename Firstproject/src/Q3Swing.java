import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Q3Swing extends JFrame {
    private JTable table;
    private DefaultTableModel model;

    public Q3Swing() {
        setTitle("JTable Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu editMenu = new JMenu("Edit");
        JMenuItem addItem = new JMenuItem("Add");
        JMenuItem deleteItem = new JMenuItem("Delete");
        JMenuItem updateItem = new JMenuItem("Update");

        addItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRow();
            }
        });

        deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRow();
            }
        });

        updateItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateRow();
            }
        });

        editMenu.add(addItem);
        editMenu.add(deleteItem);
        editMenu.add(updateItem);
        menuBar.add(editMenu);
        setJMenuBar(menuBar);

        // Create the table
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Age");

        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void addRow() {
        String[] data = {"1", "Avdhesh Kumar Sharma", "20"};
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
            model.setValueAt("Updated Name", selectedRow, 1);
            model.setValueAt("40", selectedRow, 2);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Q3Swing example = new Q3Swing();
                example.setVisible(true);
            }
        });
    }
}
//isme na maam ne bataya ki , we need to make like phele ek jtable hogi jisme data store hoga , then uske upar ek navigation button usse click karne pe 3 options pop up hongi . 