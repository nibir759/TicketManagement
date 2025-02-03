
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.swing.*;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Registration extends JFrame implements ActionListener {

    private JPanel panel; 
	private JLabel label1, label2, label3, label4, label5, label6,label7,label8,label9;
	private JTextField tf1, tf2,tf3,tf4,tf5,tf6,tf7,tf8;
	private JPasswordField pf1,pf2;
	private JButton bt1,bt2,bt3,bt4;
	private JRadioButton rd1, rd2;
	private JCheckBox jc1,jc2,jc3,jc4;
    private ImageIcon ig;
    private ButtonGroup grp1;
    @SuppressWarnings("rawtypes")
    private JComboBox box;


    
    public Registration()
    {

        super.setTitle("Registration");
        super.setBounds(70,30,1120,756);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);


        panel=new JPanel();
        panel.setLayout(null);

        

        label3=new JLabel("UserName :");
        label3.setBounds(350,130,150,150);
        panel.add(label3);

        tf2=new JTextField();
        tf2.setBounds(425,195,150,25);
        panel.add(tf2);

        label4=new JLabel("Mobile Number :");
        label4.setBounds(323,170,150,150);
        panel.add(label4);

        tf3=new JTextField();
        tf3.setBounds(425,235,150,25);
        panel.add(tf3);

        label5=new JLabel("Password :");
        label5.setBounds(355,210,150,150);
        panel.add(label5);


        pf1=new JPasswordField();
        pf1.setEchoChar('*');
        pf1.setBounds(425, 273, 150, 25);
        
        panel.add(pf1);


        label6=new JLabel("Confirm Password :");
        label6.setBounds(310,250,150,150);
        panel.add(label6);


        

        pf2=new JPasswordField();
        pf2.setBounds(425, 313, 150, 25);
        pf2.setEchoChar('*');
        panel.add(pf2);

        label7=new JLabel("Gender :");
        label7.setBounds(370,285,150,150);
        panel.add(label7);


        rd1=new JRadioButton("Male");
        rd1.setBounds(425,348,70,25);
        panel.add(rd1);


        rd2=new JRadioButton("Female");
        rd2.setBounds(505,348,70,25);
        panel.add(rd2);

        grp1=new ButtonGroup();
        grp1.add(rd1);
        grp1.add(rd2);


        label8=new JLabel("Email  :");
        label8.setBounds(378,327,150,150);
        panel.add(label8);

        tf4=new JTextField();
        tf4.setBounds(425,390,150,25);
        panel.add(tf4);


        label9=new JLabel("Birth Year  :");
        label9.setBounds(350,368,150,150);
        panel.add(label9);


        String topics[] = new String[]{"1994","1995","1996"};
        box=new JComboBox<>(topics);
        box.setBounds(425,430,150,25);
        panel.add(box);


        bt1=new JButton("Submit");
        bt1.setBounds(440,480,100,25);
        bt1.setBackground(new Color(255, 237, 197));
        bt1.addActionListener(this);
        panel.add(bt1);


        bt2=new JButton("Back");
        bt2.setBounds(440,520,100,25);
        bt2.setBackground(new Color(255, 237, 197));
        bt2.addActionListener(this);
        panel.add(bt2);














        ig=new  ImageIcon("D:\\java\\Handiling\\traveling-by-bus-tourist-buses-drive-along-road-towards-trip-adventure-travel-agency-commercial-advert.png(1).jpg");
        label2=new JLabel(ig);
        label2.setBounds(0,0,1120,756);
        label2.setOpaque(false);
        panel.add(label2);
        super.add(panel);

    }

    @SuppressWarnings({"deprecation", "StringEquality"})
    @Override
    public void actionPerformed(ActionEvent me)
	{

       

        
        if(me.getSource()==bt1)
        {
            String name,pass,num,cpass,gender,email,brth;

            name=tf2.getText();
            num=tf2.getText();
            pass=new String(pf1.getPassword());
            cpass=pf2.getText();
            
            

            if(rd1.isSelected())
            {
                gender=rd1.getText();
            }

            else if(rd2.isSelected())
            {
                gender=rd2.getText();
            }
            gender=rd1.getText();
            email=tf4.getText();
            brth=box.getSelectedItem().toString();

            if(name.isEmpty() || pass.isEmpty()||cpass.isEmpty()||gender.isEmpty()||email.isEmpty()||brth.isEmpty())//||num.length()<11||num.length()>11)
            {

                JOptionPane.showMessageDialog(this,"Please fill up all the info");
            }
            else if(!pass.equals(cpass))
            {
                JOptionPane.showMessageDialog(this,"Password doesn't match");

            }
            /*else if(num.length()!=11)
            {
                JOptionPane.showMessageDialog(this,"Mobile Number must be 11 Digits");

            }*/
            else
            {

                Save data=new Save(name,pass);//num,cpass,gender,email,brth);

                if(data.checkAccount()==true)
                {


                    JOptionPane.showMessageDialog(this,"Already exists");
                }

                else  
				{
					data.addAccount();
					JOptionPane.showMessageDialog(this,"Signup Successfull");
				
					tf2.setText("");
					pf1.setText("");
                    
					
                    
				
					Project obj1 = new Project();
					obj1.setVisible(true);
					this.setVisible(false);
				}
            }








        }
		if(me.getSource() == bt3)
		{
			Project obj1 = new Project();
			obj1.setVisible(true);
			this.setVisible(false);
		}
        if(me.getSource() == bt2)
		{
			Project obj1 = new Project();
			obj1.setVisible(true);
			this.setVisible(false);
		}
	}
    

    
}
