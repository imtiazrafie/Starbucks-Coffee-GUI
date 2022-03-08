package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.SwingConstants;

public class NewOrder extends JFrame {

	static DecimalFormat priceformatter = new DecimalFormat("#0.00");
	DecimalFormat discountnumber = new DecimalFormat("#0");

	private JPanel contentPane;
	public JLabel lblNewLabel_2;

	static private double listpricecust = 0;
	static private double finalprice = 0;
	static private JLabel titletotalprice;
	static private JLabel totalpricedisplay;
	Payment paymentframe = null;

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	static public void calctotalprice(double totalprice) {
		totalpricedisplay.setText("RM " + priceformatter.format(totalprice));
		listpricecust = totalprice;
		finalprice = totalprice;
	}

	public NewOrder(String orderid) throws IOException {
		ItemSelector itemselector = new ItemSelector(orderid);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				itemselector.dispose();
				Cashierframe.getbuttoncreate().setEnabled(true);
			}

			@Override
			public void windowClosing(WindowEvent e) {
				String selectorbutton[] = { "Yes", "No" };
				int PromptResult = JOptionPane.showOptionDialog(null,
						"Are you sure you want to exit? This order will be discarded.", "Exit Order Window",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, selectorbutton,
						selectorbutton[1]);
				if (PromptResult == JOptionPane.YES_OPTION) {
					Main.getorders().removeIf(Orders -> Orders.getorderid().equals(orderid));
					Main.getitems().removeIf(Items -> Items.getorderid().equals(orderid));
					Main.getcustomer().removeIf(Customer -> Customer.getorderid().equals(orderid));
					dispose();
					System.out.println("ORDER DELETED");
				}
			}
		});

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		setTitle(Main.getappname());
		setIconImage(Toolkit.getDefaultToolkit().getImage(ItemSelector.class.getResource("/main/logo/logo.png")));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1023, 587);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1009, 72);
		panel.setBackground(new Color(143, 188, 143));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(71, 110, 877, 383);
		panel_1.setBackground(new Color(245, 245, 220));

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 186, 429);
		panel_2.setBackground(new Color(143, 188, 143));

		JLabel lblNewLabel_1 = new JLabel("Customer Name");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel lblNewLabel_3 = new JLabel("Phone Number");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel lblNewLabel_4 = new JLabel("Items");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel lblNewLabel = new JLabel("Address");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel lblNewLabel_5 = new JLabel("Regular Customer");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 14));

		JLabel lblNewLabel_6 = new JLabel("Gender");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 14));
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(25)
							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(38)
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(45)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(lblNewLabel_3)
					.addGap(26)
					.addComponent(lblNewLabel)
					.addGap(54)
					.addComponent(lblNewLabel_6)
					.addGap(18)
					.addComponent(lblNewLabel_4)
					.addGap(30)
					.addComponent(lblNewLabel_5)
					.addContainerGap(83, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);

		JTextField custnamefield = new JTextField();
		custnamefield.setBounds(246, 42, 396, 19);
		custnamefield.setFont(new Font("Arial", Font.PLAIN, 14));
		custnamefield.setColumns(10);

		JTextField phonenofield = new JTextField();
		phonenofield.setBounds(246, 78, 396, 19);
		phonenofield.setFont(new Font("Arial", Font.PLAIN, 14));
		phonenofield.setColumns(10);

		JCheckBox regularcustomercheck = new JCheckBox("Yes");
		regularcustomercheck.setBounds(246, 276, 56, 21);
		regularcustomercheck.setFont(new Font("Arial", Font.PLAIN, 14));
		regularcustomercheck.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				boolean regularcustomer = false;
				if (regularcustomercheck.isSelected()) {
					regularcustomer = true;
				}

				if (regularcustomer == true) {
					titletotalprice.setText("Total Price with discount "
							+ discountnumber.format((Main.getdiscountvalue() * 100)) + "%");
					double totalwithdiscount = listpricecust - (listpricecust * Main.getdiscountvalue());
					totalpricedisplay.setText("RM " + priceformatter.format(totalwithdiscount));
					finalprice = totalwithdiscount;
				} else {
					titletotalprice.setText("Total Price");
					totalpricedisplay.setText("RM " + priceformatter.format(listpricecust));
					finalprice = listpricecust;
				}
			}
		});
		
		JTextArea addressfield = new JTextArea();
		addressfield.setBounds(246, 121, 396, 56);
		panel_1.add(addressfield);
		addressfield.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		addressfield.setFont(new Font("Arial", Font.PLAIN, 14));

		JRadioButton malevalueradio = new JRadioButton("Male");
		malevalueradio.setBounds(246, 192, 66, 21);
		malevalueradio.setFont(new Font("Arial", Font.PLAIN, 14));
		JRadioButton femalevalueradio = new JRadioButton("Female");
		femalevalueradio.setBounds(314, 192, 80, 21);
		femalevalueradio.setFont(new Font("Arial", Font.PLAIN, 14));
		malevalueradio.setActionCommand("Male");
		femalevalueradio.setActionCommand("Female");

		ButtonGroup genderselector = new ButtonGroup();
		genderselector.add(malevalueradio);
		genderselector.add(femalevalueradio);

		JButton btnNewButton = new JButton("Pay");
		btnNewButton.setBounds(784, 334, 66, 35);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String customername = custnamefield.getText();
				String phoneno = phonenofield.getText();
				String address = addressfield.getText();
				String gender = "";
				boolean regularcustomer = false;
				if (regularcustomercheck.isSelected()) {
					regularcustomer = true;
				}

				// ERROR HANDLING FOR RADIO GET ACTION COMMAND
				try {
					gender = genderselector.getSelection().getActionCommand();
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}

				// PROCESS STATE
				boolean process = false;

				// ERROR STATE
				boolean customernameerror = false;
				boolean phonenoerror = false;
				boolean addresserror = false;
				boolean gendererror = false;
				boolean quantityerror = false;

				// CHECK NAME
				if (customername.isEmpty()) {
					customernameerror = true;
				}

				// CHECK PHONE NO
				if (phoneno.isEmpty()) {
					phonenoerror = true;
				}

				// CHECK ADDRESS
				if (address.isEmpty()) {
					addresserror = true;
				}

				// CHECK GENDER
				if (gender.isEmpty()) {
					gendererror = true;
				}

				// CHECK IF ITEM ADDED
				int quantitycount = 0;
				for (int i = 0; i < Main.getitems().size(); i++) {
					if (String.valueOf(Main.getitems().get(i).getorderid()).equals(orderid)) {
						quantitycount = quantitycount + Main.getitems().get(i).getquantity();
					}
				}

				// CHECK QUANTITY ITEMS ADDED
				if (quantitycount == 0) {
					quantityerror = true;
				}

				// ERROR MESSAGE
				if (customernameerror || phonenoerror || addresserror || gendererror || quantityerror) {
					String error = "Check your required field:";
					if (customernameerror) {
						error += "\nName is empty";
					}
					if (phonenoerror) {
						error += "\nPhone number is empty";
					}
					if (addresserror) {
						error += "\nAddress is empty";
					}
					if (gendererror) {
						error += "\nGender is empty";
					}
					if (quantityerror) {
						error += "\nItems is empty";
					}
					JOptionPane.showMessageDialog(null, error, "Error. ID: " + orderid, JOptionPane.ERROR_MESSAGE);
				} else {
					process = true;
				}

				// IF TRUE, SAVE THE RECORD
				if (process == true) {
					// System.out.println("Name: " + customername + "\nPhone no: " + phoneno +
					// "\nAddress: " + address + "\nGender: " + gender + "Regular customer: " +
					// regularcustomer);
					Main.getcustomer().add(new Customerclass(orderid, customername, phoneno, address, gender, regularcustomer));
					Cashierframe.getbuttoncreate().setEnabled(true);
					// orderlistrefresh();
					// dispose();
					if(paymentframe == null) {						
						paymentframe = new Payment(orderid, finalprice);
						paymentframe.setVisible(true);
					}else {
						paymentframe.setVisible(true);
					}
				}
			}
		});

		JButton btnNewButton_1 = new JButton("Open Order Item Manager");
		btnNewButton_1.setBounds(246, 233, 204, 21);
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				itemselector.setVisible(true);
			}
		});

		titletotalprice = new JLabel("Total Price:");
		titletotalprice.setBounds(246, 314, 273, 18);
		titletotalprice.setFont(new Font("Arial", Font.BOLD, 15));
		titletotalprice.setForeground(Color.BLACK);

		totalpricedisplay = new JLabel("RM 0.00");
		totalpricedisplay.setBounds(246, 342, 273, 18);
		totalpricedisplay.setFont(new Font("Arial", Font.BOLD, 15));
		panel_1.setLayout(null);
		panel_1.add(panel_2);
		panel_1.add(titletotalprice);
		panel_1.add(totalpricedisplay);
		panel_1.add(btnNewButton);
		panel_1.add(malevalueradio);
		panel_1.add(femalevalueradio);
		panel_1.add(phonenofield);
		panel_1.add(custnamefield);
		panel_1.add(btnNewButton_1);
		panel_1.add(regularcustomercheck);
		
		contentPane.setLayout(null);

		lblNewLabel_2 = new JLabel("New order for ID: " + orderid);
		lblNewLabel_2.setIcon(new ImageIcon(NewOrder.class.getResource("/main/logo/details.png")));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 808, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(191, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(29, Short.MAX_VALUE)
					.addComponent(lblNewLabel_2)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.add(panel);
		contentPane.add(panel_1);
	}
}
