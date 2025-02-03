import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



    public class Select extends JFrame implements ActionListener
{
    private JPanel panel; 
	private JLabel label1, label2, label3, label4, label5, label6;
	private JTextField tf1, tf2;
	private JPasswordField pf1;
	private JButton bt1,bt2,bt3;
    private ImageIcon ig1,ig2,ig3;

    public  Select()
    {

        super("Selection");
        
        super.setBounds(70,30,1300,756);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel=new JPanel();
        panel.setLayout(null);

        ig1=new ImageIcon("D:\\java\\Handiling\\bus(2).png");
        bt1=new JButton(ig1);
        bt1.setBounds(350,250,250,250);
        bt1.addActionListener(this);
        panel.add(bt1);

        ig2=new ImageIcon("D:\\java\\Handiling\\Train.png");
        bt2=new JButton(ig2);
        bt2.setBounds(700,250,250,250);
        bt2.addActionListener(this);
        panel.add(bt2);



         ig3=new ImageIcon("D:\\java\\Handiling\\illustration-4788151_1280(2).jpg");
        label1=new JLabel(ig3);
        label1.setBounds(0,0,1400,756);
        label1.setOpaque(false);
        panel.add(label1);
        


        super.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent me)
    {
        if(me.getSource()==bt3)
        {
            Project obj2=new Project();
            obj2.setvisible(true);
            this.setVisible(false);

        }



        if(me.getSource()==bt2)
        {

            TrainTicketselect t1=new TrainTicketselect();
            t1.setVisible(true);
            this.setVisible(false);
        }


        if(me.getSource()==bt1)
        {

           BusTicket t1=new BusTicket();
            t1.setVisible(true);
            this.setVisible(false);
        }





        
    }

    


    
}
