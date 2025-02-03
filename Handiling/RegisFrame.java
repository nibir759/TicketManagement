import java.awt.*;
import java.io.*;
import javax.swing.*;

public class RegisFrame extends JFrame {
    private JTextArea ta;
    private JButton btnAddUser, btnUpdateUser;
    private File usersFile = new File("D:\\java\\Handiling\\Data.txt");

    public RegisFrame(String usersData) {
        super("Registered Users");
        setBounds(350, 80, 650, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Main panel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Text Area (Editable)
        ta = new JTextArea();
        ta.setText(usersData);
        ta.setEditable(true);
        JScrollPane scrollPane = new JScrollPane(ta);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Button Panel (Bottom)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        btnAddUser = new JButton("Add User");
        btnUpdateUser = new JButton("Update Users");

        btnAddUser.addActionListener(e -> addUser());
        btnUpdateUser.addActionListener(e -> updateUsers());

        buttonPanel.add(btnAddUser);
        buttonPanel.add(btnUpdateUser);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);
    }

    // Method to add a user (formatted correctly)
    private void addUser() {
        String username = JOptionPane.showInputDialog(this, "Enter Username:");
        if (username == null || username.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username cannot be empty!");
            return;
        }

        String password = JOptionPane.showInputDialog(this, "Enter Password:");
        if (password == null || password.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Password cannot be empty!");
            return;
        }

        // Append new user in the required format
        ta.append("UserName: " + username + "\tPassword: " + password + "\n\n");
        saveToFile();
        JOptionPane.showMessageDialog(this, "User added successfully!");
    }

    // Method to update user list (overwrite file with text area content)
    private void updateUsers() {
        saveToFile();
        JOptionPane.showMessageDialog(this, "User list updated successfully!");
    }

    // Method to save text area content to file
    private void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(usersFile))) {
            bw.write(ta.getText());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving user file.");
        }
    }
}
