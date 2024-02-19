import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class contactus extends JFrame implements ActionListener {
    JLabel nameLabel,emailLabel,phone_numberLabel,messageLabel;
    JTextField nameTextField,emailTextField,phone_numberTextField,messageTextField;
    JButton submitButton, viewButton, backButton;
    

    contactus() {
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 20, 80, 30);
        nameTextField = new JTextField();
        nameTextField.setBounds(100, 20, 200, 30);

        emailLabel = new JLabel("email:");
        emailLabel.setBounds(20, 80, 80, 30);
        emailTextField = new JTextField();
        emailTextField.setBounds(100, 80, 200, 30);



        messageLabel = new JLabel("message:");
        messageLabel.setBounds(20, 140, 80, 30);
        messageTextField = new JTextField();
        messageTextField.setBounds(100, 140, 200, 100);

        submitButton = new JButton("Submit");
        submitButton.setBounds(100, 260, 80, 30);
        submitButton.addActionListener(this);



        backButton = new JButton("Back");
        backButton.setBounds(100, 300, 80, 30);
        backButton.addActionListener(this);
        
        



        add(nameLabel);
        add(nameTextField);
        add(emailLabel);
        add(emailTextField);

        add(messageLabel);
        add(messageTextField);
        add(submitButton);
        
        add(backButton);


        setSize(500, 400);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("CONTACT US");
        setLayout(new BorderLayout());
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameTextField.getText();
            String email =emailTextField.getText();
            //String phone_number = phone_numberTextField.getText();
            String message = messageTextField.getText();

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/nshuti _pappy_serge_fs", "222012992", "222012992");
                PreparedStatement stmt = con.prepareStatement("INSERT INTO contactus (name,email,message) VALUES (?,?,?)");
                stmt.setString(1, name);
                stmt.setString(2, email);
               // stmt.setString(3, phone_number);
                stmt.setString(3, message);
                stmt.executeUpdate();
                con.close();
                JOptionPane.showMessageDialog(this, "Feedback submitted successfully!");
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else if (e.getSource() == backButton) {
            new bookingform();
            dispose();
        }
    }

    public static void main(String[] args) {
        new contactus();
    }
}

