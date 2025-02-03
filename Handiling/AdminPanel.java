import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class AdminPanel extends JFrame  implements ActionListener 
{
    
   
        
        private JPanel panel; 
        private JLabel label1, label2, label3, label4, label5, label6;
        private JTextField tf1, tf2;
        private JPasswordField pf1;
        private JButton bt1,bt2,bt3,bt4;
        private final ImageIcon ig;
        private static final String DEFAULT_ADMIN_USERNAME = "Nibir";
        private static final String DEFAULT_ADMIN_PASSWORD = "Biswas";
    
    
        public AdminPanel()
        {
            super("AdminPanel");
            super.setBounds(370,130,800,656);
            super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
            panel=new JPanel();
            panel.setLayout(null);
            panel.setBackground(Color.WHITE);
    
            ig=new ImageIcon("D:\\java\\Handiling\\img4(1).jpg");
    
            label1=new JLabel(ig);
            label1.setBounds(400,180,400,400);
            panel.add(label1);
    
            label1=new JLabel("Username :");
            label1.setBounds(150,220,100,100);
            panel.add(label1);
    
            tf1=new JTextField();
            tf1.setBounds(220,255,130,30);
            panel.add(tf1);
    
            label2=new JLabel("Password :");
            label2.setBounds(150,260,100,100);
            panel.add(label2);
    
            pf1=new JPasswordField();
            pf1.setBounds(220,293,130,30);
            pf1.setEchoChar('*');
            panel.add(pf1);
    
            bt1=new JButton("Login");
            bt1.setBounds(180,350,80,30);
            bt1.addActionListener(this);
            panel.add(bt1);
    
            bt2=new JButton("Back");
            bt2.setBounds(275,350,80,30);
            bt2.addActionListener(this);
            
             panel.add(bt2);






        super.add(panel);
        initializeAdminFile();


    }
       
      

 
    
    private void initializeAdminFile()
    {
        File file = new File("D:\\java\\Handiling\\Admin.txt");
 
        
        if (file.exists() && file.length() > 0)
        {
            return;
        }
 
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file)))
        {
            bw.write(DEFAULT_ADMIN_USERNAME + "," + DEFAULT_ADMIN_PASSWORD);
            bw.newLine();  
            bw.flush(); 
            System.out.println("Admin credentials saved: " + DEFAULT_ADMIN_USERNAME + " " + DEFAULT_ADMIN_PASSWORD);
        } 
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(this, "Error initializing admin file.");
        }
    }
 
    
    private boolean checkAdminCredentials(String username, String password)
     {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\java\\Handiling\\Admin.txt"))) 
        {
            String line;
            while ((line = br.readLine()) != null)
             {
                String[] creds = line.split(",");
                if (creds.length == 2 && creds[0].trim().equals(username) && creds[1].trim().equals(password)) 
                {
                    return true;
                }
            }
        } 
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(this, "Error reading admin file.");
        }
        return false;
    }
 
    
    private String getRegisteredUsers()
     {
        StringBuilder sb = new StringBuilder();
        File usersFile = new File("D:\\java\\Handiling\\Data.txt");
 
        if (!usersFile.exists()) 
        {
            return "No users found!";
        }
 
        try (BufferedReader br = new BufferedReader(new FileReader(usersFile)))
        {
            String line;
            while ((line = br.readLine()) != null) 
            {
                sb.append(line).append("\n");
            }
        } 
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(this, "Error reading user file.");
        }
        return sb.toString();
    }

    @Override
    public void actionPerformed(ActionEvent ae)

    {
        if(ae.getSource()==bt4)
        {

            Project P2=new Project();
            P2.setVisible(true);
            this.setVisible(false);
        }

        if (ae.getSource() == bt1)
         {
        String username = tf1.getText().trim();
        String password = new String(pf1.getPassword()).trim();

        if (checkAdminCredentials(username, password))
        {
            
            String usersData = getRegisteredUsers();
            
           
             RegisFrame obj1 =new RegisFrame("" + usersData);
        } 
        else
         {
            JOptionPane.showMessageDialog(this, "Invalid ! Try again.");
        }
        } 
    else if (ae.getSource() == bt2)
     {
        Project p2 = new Project();
		p2.setVisible(true);
		this.setVisible(false);
     }
   }


}


       


        
    

