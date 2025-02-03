import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Project extends JFrame  implements ActionListener,MouseListener
{
    private JPanel panel; 
	private JLabel label1, label2, label3, label4, label5, label6;
	private JTextField tf1, tf2;
	private JPasswordField pf1;
	private JButton bt1,bt2,bt3,bt4,bt7;
    private ImageIcon ig;


    public Project()
    {
        super("Profile");
        super.setBounds(70,30,1300,756);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel=new JPanel();
        panel.setLayout(null);

        label4=new JLabel("Log in with username and password");
        label4.setBounds(80,230,300,250);
        panel.add(label4);

       label1=new JLabel("Username:");
        label1.setBounds(60,280,150,250);
        panel.add(label1);


        tf1=new JTextField();
        tf1.setBounds(128,395,150,25);
        panel.add(tf1);

        

        
        label3=new JLabel("Password:");
        label3.setBounds(60,320,150,250);
        panel.add(label3);

        pf1=new JPasswordField();
        pf1.setEchoChar('*');
        pf1.setBounds(128,433,150,25);
        panel.add(pf1);


        
        bt1=new JButton("Log In");
        bt1.setBounds(90,490,80,30);
        bt1.addActionListener(this);
        panel.add(bt1);

        bt7=new JButton("Exit");
        bt7.setBounds(195,490,80,30);
        bt7.addActionListener(this);
        panel.add(bt7);

        bt3=new JButton("Create New Account");
        bt3.setBounds(98,550,180,25);
        bt3.addActionListener(this);
        panel.add(bt3);

        bt4=new JButton("Admin Log In");
        bt4.setBounds(1050,30,130,35);
        bt4.addActionListener(this);
        panel.add(bt4);





        ig=new ImageIcon("D:\\java\\Handiling\\Front(1).png");
        label2=new JLabel(ig);
        label2.setBounds(0,0,1300,756);
        label2.setOpaque(false);
        panel.add(label2);

        





     super.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent me)
    {

       


        if(me.getSource()==bt1)
        {

            

            String name,pass;

            name=tf1.getText();
            
            pass=new String(pf1.getPassword());

            Save data=new Save(name,pass);

            if(data.checkAccount()==true)
            {
                JOptionPane.showMessageDialog(this,"Login Successfull");
                Select s1=new Select();
            s1.setVisible(true);
            this.setVisible(false);


            }
        

       

           
        

        else
        {

            JOptionPane.showMessageDialog(this,"Invalid info");
            


        }

        }
    

         
        if(me.getSource()==bt3)
        {
            Registration rgs=new Registration();
            rgs.setVisible(true);
            this.setVisible(false);


        }

        if(me.getSource()==bt4)
    {
        AdminPanel a=new AdminPanel();
        a.setVisible(true);
        this.setVisible(false);


        
    }
         if(me.getSource()==bt2)
    {
        AdminPanel a=new AdminPanel();
        a.setVisible(true);
        this.setVisible(false);

    }


        
    

    if(me.getSource()==bt2)
    {
        Registration rgs1=new Registration();
        rgs1.setVisible(true);
        this.setVisible(false);


        
    }
    if(me.getSource()==bt7)

    {
        System.exit(0);

    }
}

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    void setvisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    void setvisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    







}