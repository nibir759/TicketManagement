import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;

public class TrainTicketselect extends JFrame implements ActionListener
{
    private JPanel panel; 
       
	private JLabel label1, label2, label3, label4, label5, label6,label7,labelPrice,labelCoupon,totalPriceLabel;
	private JTextField tf1, tf2,tfCoupon;
	private JPasswordField pf1;
	private JButton bt1,bt2,bt3,bt4,btCalculate;
	private JRadioButton rd1, rd2;
	private ButtonGroup bg1;
	private JCheckBox jc1,jc2,jc3,jc4;
    private ImageIcon ig;
	@SuppressWarnings("rawtypes")
	private JComboBox jb1,jb2,jb3,jb4;
	


    @SuppressWarnings({ "rawtypes", "unchecked" })
	public TrainTicketselect()
    {
        super("Ticketpage");
        super.setBounds(70,30,1300,800);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);

        panel=new JPanel();
        panel.setLayout(null);
		
		label2=new JLabel("Select Route:");
        label2.setBounds(70,0,150,250);
        panel.add(label2);
		
		String route[] = new String[]
		{"", "Dhaka-Cox's Bazar", "Cox's Bazar-Dhaka", "Dhaka-Chottogram","Chottogram-Dhaka","Dhaka-Shylhet","Shylhet-Dhaka"};
		jb1 = new JComboBox(route);
		jb1.setBounds(175,116,200,20);
		jb1.setForeground(Color.WHITE);
		jb1.setBackground(Color.GREEN);
		panel.add(jb1);
		
		label3=new JLabel("Select Your Train:");
        label3.setBounds(70,50,150,250);
        panel.add(label3);
		
		String trainselect[] = new String[]
		{"", "Upokul","Projjotok Express"};
		jb2 = new JComboBox(trainselect);
		jb2.setBounds(175,167,200,20);
		jb2.setForeground(Color.WHITE);
		jb2.setBackground(Color.GREEN);
		panel.add(jb2);
		
		label4=new JLabel("Select Cetagory:");
        label4.setBounds(70,100,150,250);
        panel.add(label4);
		
		rd1 = new JRadioButton("Ac");
		rd1.setBounds(175,216,70,20); 
		panel.add(rd1);
		
		rd2 = new JRadioButton("Non-Ac");
		rd2.setBounds(255,216,70,20); 
		panel.add(rd2);
		
		bg1 = new ButtonGroup();
		bg1.add(rd1);
		bg1.add(rd2);
		
		label5=new JLabel("Date of Journey:");
        label5.setBounds(70,145,150,250);
        panel.add(label5);
		
	JTextField tf1 = new JTextField(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
	tf1.setBounds(170, 263, 150, 20);
	panel.add(tf1);
		
		label6=new JLabel("Departure Times Available:");
        label6.setBounds(70,195,170,250);
        panel.add(label6);
		
		String time[] = new String[]
		{"", "8:30AM","12:00PM"};
		jb3 = new JComboBox(time);
		jb3.setBounds(230,310,150,20);
		jb3.setForeground(Color.WHITE);
		jb3.setBackground(Color.GREEN);
		panel.add(jb3);
		
		label7=new JLabel("Available Tickets:");
        label7.setBounds(70,240,170,250);
        panel.add(label7);
		
		String ticket[] = new String[]
		{"Select Amount","1","2","3","4"};
		jb4 = new JComboBox(ticket);
		jb4.setBounds(180,355,130,20);
		jb4.setForeground(Color.WHITE);
		jb4.setBackground(Color.GREEN);
		panel.add(jb4);

		labelPrice = new JLabel("Total Price:");
        labelPrice.setBounds(70, 400, 80, 25);
        panel.add(labelPrice);

        totalPriceLabel = new JLabel("0 TK");
        totalPriceLabel.setBounds(180, 400, 200, 25);
		totalPriceLabel.setForeground(Color.white);

        panel.add(totalPriceLabel);

        labelCoupon = new JLabel("Coupon Code:");
        labelCoupon.setBounds(70, 430, 150, 25);
        panel.add(labelCoupon);

        tfCoupon = new JTextField();
        tfCoupon.setBounds(180, 430, 150, 25);
        panel.add(tfCoupon);

        btCalculate = new JButton("Calculate Price");
        btCalculate.setBounds(350, 355, 150, 25);
        panel.add(btCalculate);
		
		
		
		bt1 = new JButton("Book Ticket");
		bt1.setBounds(170,460,190,25);
		panel.add(bt1);
		bt1.setForeground(Color.GREEN);
		bt1.setBackground(Color.WHITE);
		
		bt2 = new JButton("Back");
		bt2.setBounds(190,495,90,25);
		panel.add(bt2);
		bt2.setForeground(Color.WHITE);
		bt2.setBackground(Color.GREEN);
		
		bt3 = new JButton("Exit");
		bt3.setBounds(270,495,90,25);
		panel.add(bt3);
		bt3.setForeground(Color.WHITE);
		bt3.setBackground(Color.GREEN);

		btCalculate.addActionListener(this);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
		
		
		
		
		
		ig=new ImageIcon("D:\\java\\Handiling\\WhatsApp Image 2025-01-27 at 00.47.53_5ee79d75 1 (1).jpg");
        label1=new JLabel(ig);
        label1.setBounds(0,0,1200,800);
        label1.setOpaque(false);
        panel.add(label1);
		






     super.add(panel);
    }


    private void calculatePrice() 
	{
		int ticketPrice = 500; 
		String selectedTicket = (String) jb4.getSelectedItem();

		
		if (selectedTicket != null && !selectedTicket.isEmpty())
		 {
			
			//String numericPart = selectedTicket.replaceAll("[^0-9]", ""); 
			int ticketCount = Integer.parseInt(selectedTicket); //numericPart.isEmpty() ? 0 : Integer.parseInt(numericPart); 
	
			int totalPrice = ticketPrice * ticketCount;
			int finalPrice = totalPrice; 
	
			
			String couponCode = tfCoupon.getText().trim();
			if (couponCode.equalsIgnoreCase("DISCOUNT10"))
			 {
				finalPrice *= 0.9; 
			}
	
			
			totalPriceLabel.setText("Total: " + totalPrice + " TK | Final: " + finalPrice + " TK");
		} 
		else 
		{
			totalPriceLabel.setText("0 TK"); 
		}
	}
	
	
    @Override
	public void actionPerformed(ActionEvent me)
    {
        if(me.getSource()==bt2)
        {
			Select s1=new Select();
			s1.setVisible(true);
			this.setVisible(false);

		}
		if (me.getSource() == btCalculate)
		 {
            calculatePrice();
        } 
		else if (me.getSource() == bt1) 
		{
			String s1;
			s1=totalPriceLabel.getText();
            JOptionPane.showMessageDialog(this, "Ticket booked: Redirecting to bKash gateway");
			Paymentpg j1 = new Paymentpg(s1);
			j1.setVisible(true);
			this.setVisible(false);

        } 
		else if (me.getSource() == bt2)
		 {
            this.setVisible(false);
        } 
		else if (me.getSource() == bt3) 
		{
            System.exit(0);
        }
	}

}