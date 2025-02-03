import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import javax.swing.*;

public class Paymentpg extends JFrame implements ActionListener
{
    private JPanel panel; 
	private JLabel label1, label2, label3,label4;
	private JTextField tf1, tf2;
	private JPasswordField pf1;
	private JButton bt1,bt2;
    private ImageIcon ig;


    public Paymentpg(String s1)
    {
        super("Profile");
        setBounds(70,30,1120,756);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel=new JPanel();
        panel.setLayout(null);

		
		
		
		label2=new JLabel("Enter Bkash Number:");
        label2.setBounds(410,158,200,250);
		label2.setForeground(Color.WHITE);
        panel.add(label2);
		
		tf1 = new JTextField();
		tf1.setBounds(410,300,280,30); 
		panel.add(tf1);
		
		label3=new JLabel("Enter Your Bkash pin:");
        label3.setBounds(410,230,200,250);
		label3.setForeground(Color.WHITE);
        panel.add(label3);
		
		pf1 = new JPasswordField();
		pf1.setBounds(410,375,280,30); 
		panel.add(pf1);
		
		bt1 = new JButton("PROCEED");
		bt1.setBounds(430,435,100,18); 
		bt1.setBackground(Color.decode("0x9E1638"));
		bt1.setForeground(Color.WHITE);
        bt1.addActionListener(this);
		panel.add(bt1);
		
		bt2 = new JButton("CLOSE");
		bt2.setBounds(550,435,100,18); 
		bt2.setBackground(Color.decode("0x9E1638"));
		bt2.setForeground(Color.WHITE);
        bt2.addActionListener(this);
		panel.add(bt2);

		label4=new JLabel("Amount  "+s1);
        label4.setBounds(460,65,250,250);
		label4.setForeground(Color.WHITE);
        panel.add(label4);
		
		
		
		
		
		ig=new ImageIcon("D:\\java\\Handiling\\6286934c43eac 1.png");
        label1=new JLabel(ig);
        label1.setBounds(0,0,1120,756);
        label1.setOpaque(false);
        panel.add(label1);
		
		
		
	
		
		
		add(panel);
		
	}
    @Override
    public void actionPerformed(ActionEvent me)
    {
        if(me.getSource()==bt1)
        {
            String num,pin;
            num=tf1.getText();
            pin=new String(pf1.getPassword());



            if (num.length() != 11)
             {
                JOptionPane.showMessageDialog(this, "Bkash number must be exactly 11 digits!");
            } 
            else if (pin.length() != 5) 
            {
                JOptionPane.showMessageDialog(this, "Pin must be exactly 5 digits!");
            } 
            else
            {
                JOptionPane.showMessageDialog(this, "Payment Successful");
                this.setVisible(false);
            }

            /*if(num.isEmpty()||pin.isEmpty())
            {

                JOptionPane.showMessageDialog(this,"Fillup all the info");

            }
            else
            {


                JOptionPane.showMessageDialog(this,"Payment Successfull");
                this.setVisible(false);
               


            }

            //JOptionPane.showMessageDialog(this,"Payment Successfull");
            /*Paymentpg s1=new Paymentpg();
            s1.setVisible(true);*/
            
        }
        if(me.getSource()==bt2)
        {
            System.exit(0);

        }


   

        
    }
}		