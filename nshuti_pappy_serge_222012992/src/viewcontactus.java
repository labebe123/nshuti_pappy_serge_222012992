import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class viewcontactus extends JFrame implements ActionListener {

    private JTable feedbackTable;
    private JButton deleteButton, updateButton, backButton;

    public viewcontactus() {
        setTitle("FEEDBACK");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);


        String[] columnNames = {"NAME", "EMAIL", "PHONE NUMBER", "MESSAGE"};


        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nshuti _pappy_serge_fs", "222012992", "222012992");


            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM contactus");


            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            while (rs.next()) {
                Object[] row = {rs.getInt("name"), rs.getString("email"), rs.getString("phone_number"),rs.getString("message")};
                model.addRow(row);
            }


            feedbackTable = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(feedbackTable);
            add(scrollPane, BorderLayout.CENTER);


            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Driver not found: " + ex.getMessage());
        }


        JPanel buttonPanel = new JPanel();
        /*deleteButton = new JButton("delete");
        deleteButton.addActionListener(this);
        buttonPanel.add(deleteButton);

        updateButton = new JButton("update");
        updateButton.addActionListener(this);
        buttonPanel.add(updateButton);*/

        backButton = new JButton("back");
        backButton.addActionListener(this);
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deleteButton) {


        } else if (e.getSource() == updateButton) {



        } else if (e.getSource() == backButton) {

            new adminview().setVisible(true);
            dispose();

        }
    }

    public static void main(String[] args) {
        viewcontactus viewcontactus = new viewcontactus();
        viewcontactus.setVisible(true);
    }

}


