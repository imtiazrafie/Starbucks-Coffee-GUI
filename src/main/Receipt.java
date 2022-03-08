package main;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Receipt extends JFrame {
	
	DecimalFormat priceformatter = new DecimalFormat("#0.00");

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public Receipt(String orderid) {
		//@SuppressWarnings("unlikely-arg-type")
		List<Customerclass> customerdata = Main.getcustomer().stream().filter(custdata -> custdata.getorderid().equals(orderid)).collect(Collectors.toList());
		List<Ordersclass> orderdata = Main.getorders().stream().filter(orderdat -> orderdat.getorderid().equals(orderid)).collect(Collectors.toList());
		List<Paymentclass> paymentdata = Main.getpayment().stream().filter(paymentdat -> paymentdat.getorderid().equals(orderid)).collect(Collectors.toList());
		List<Itemsclass> itemsdata = Main.getitems().stream().filter(itemdat -> itemdat.getorderid().equals(orderid)).collect(Collectors.toList());
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Receipt.class.getResource("/main/logo/logo.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 936, 636);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 220));
		setContentPane(contentPane);
		setTitle(Main.getappname());
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 945, 68);
		panel.setBackground(new Color(143, 188, 143));
		
		JLabel lblNewLabel_4 = new JLabel("Customer Details");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(0, 92, 170, 22);
		lblNewLabel_4.setBackground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4.setForeground(Color.BLACK);
		
				JLabel lblNewLabel_1 = new JLabel("Name:");
				lblNewLabel_1.setBounds(10, 120, 47, 19);
				lblNewLabel_1.setForeground(Color.BLACK);
				lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel namedisplay = new JLabel(customerdata.get(0).getname());
		namedisplay.setBounds(133, 122, 361, 17);
		namedisplay.setForeground(Color.BLACK);
		namedisplay.setFont(new Font("Arial", Font.PLAIN, 14));
		
				JLabel lblNewLabel_2 = new JLabel("Phone Number:");
				lblNewLabel_2.setBounds(10, 147, 113, 19);
				lblNewLabel_2.setForeground(Color.BLACK);
				lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel phonenodisplay = new JLabel(customerdata.get(0).getphoneno());
		phonenodisplay.setBounds(133, 149, 207, 17);
		phonenodisplay.setForeground(Color.BLACK);
		phonenodisplay.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblNewLabel_4_2 = new JLabel("Order Details");
		lblNewLabel_4_2.setBounds(568, 91, 140, 24);
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setForeground(Color.BLACK);
		lblNewLabel_4_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4_2.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_1_2 = new JLabel("Order Date:");
		lblNewLabel_1_2.setBounds(568, 119, 84, 21);
		lblNewLabel_1_2.setForeground(Color.BLACK);
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel orderdatedisplay = new JLabel(orderdata.get(0).getdate() + " " + orderdata.get(0).getordertime());
		orderdatedisplay.setBounds(701, 119, 209, 21);
		orderdatedisplay.setHorizontalAlignment(SwingConstants.LEFT);
		orderdatedisplay.setForeground(Color.BLACK);
		orderdatedisplay.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Order ID:");
		lblNewLabel_1_2_1.setBounds(568, 146, 82, 21);
		lblNewLabel_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel orderiddisplay = new JLabel(orderid);
		orderiddisplay.setBounds(701, 147, 211, 21);
		orderiddisplay.setHorizontalAlignment(SwingConstants.LEFT);
		orderiddisplay.setForeground(Color.BLACK);
		orderiddisplay.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Payment Type:");
		lblNewLabel_1_2_2.setBounds(568, 172, 113, 21);
		lblNewLabel_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_1_2_2.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel paymenttypedisplay = new JLabel(paymentdata.get(0).getpaymenttype());
		paymenttypedisplay.setBounds(703, 173, 209, 21);
		paymenttypedisplay.setHorizontalAlignment(SwingConstants.LEFT);
		paymenttypedisplay.setForeground(Color.BLACK);
		paymenttypedisplay.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 279, 955, 233);
		
		JLabel lblNewLabel_4_1 = new JLabel("Total: RM" + priceformatter.format(paymentdata.get(0).gettotalprice()));
		lblNewLabel_4_1.setBounds(10, 518, 289, 26);
		lblNewLabel_4_1.setForeground(Color.BLACK);
		lblNewLabel_4_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel_4_1.setBackground(Color.WHITE);
		
		JLabel custpaiddisplay = new JLabel("Customer paid: RM" + priceformatter.format(paymentdata.get(0).getcustpay()));
		custpaiddisplay.setBounds(10, 550, 598, 17);
		custpaiddisplay.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel balancedisp = new JLabel("Balance: RM" + priceformatter.format(paymentdata.get(0).getcustpay() - paymentdata.get(0).gettotalprice()));
		balancedisp.setBounds(10, 573, 598, 15);
		balancedisp.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2_1 = new JLabel("Address:");
		lblNewLabel_2_1.setBounds(10, 201, 73, 21);
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 14));
		
		String addressline = "<html>" + customerdata.get(0).getaddress().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>";
		JLabel addressdisplay = new JLabel(addressline);
		addressdisplay.setBounds(133, 202, 358, 65);
		addressdisplay.setVerticalAlignment(SwingConstants.TOP);
		addressdisplay.setForeground(Color.BLACK);
		addressdisplay.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2_2 = new JLabel("Gender:");
		lblNewLabel_2_2.setBounds(10, 172, 108, 21);
		lblNewLabel_2_2.setForeground(Color.BLACK);
		lblNewLabel_2_2.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JLabel lblGendeDisp = new JLabel(customerdata.get(0).getgender());
		lblGendeDisp.setBounds(133, 172, 207, 21);
		lblGendeDisp.setForeground(Color.BLACK);
		lblGendeDisp.setFont(new Font("Arial", Font.PLAIN, 14));
		
		table = new JTable();
		DefaultTableModel listitemmodel = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Item Number", "Item Name", "Quantity", "Price"
				}
			){
			/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int columnIndex) {
			    return false;
			}
			};
		table.setModel(listitemmodel);
		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(62);
		scrollPane.setViewportView(table);
		
		String regularcuststate = "No";
		if(customerdata.get(0).getregularcustomer()) {
			regularcuststate = "Yes";
		}

		JLabel lblNewLabel = new JLabel("Receipt for Order ID " + orderid);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setIcon(new ImageIcon(Receipt.class.getResource("/main/logo/menu.png")));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 475, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(438, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(null);
		contentPane.add(lblNewLabel_4_1);
		contentPane.add(custpaiddisplay);
		contentPane.add(balancedisp);
		contentPane.add(lblNewLabel_2_1);
		contentPane.add(scrollPane);
		contentPane.add(lblNewLabel_2_2);
		contentPane.add(addressdisplay);
		contentPane.add(lblGendeDisp);
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_1);
		contentPane.add(namedisplay);
		contentPane.add(phonenodisplay);
		contentPane.add(lblNewLabel_4);
		contentPane.add(lblNewLabel_1_2);
		contentPane.add(orderdatedisplay);
		contentPane.add(lblNewLabel_1_2_1);
		contentPane.add(orderiddisplay);
		contentPane.add(lblNewLabel_1_2_2);
		contentPane.add(paymenttypedisplay);
		contentPane.add(lblNewLabel_4_2);
		contentPane.add(panel);
		
		listitemmodel.setRowCount(0);
		for(int i = 0; i < itemsdata.size(); i++) {	
				listitemmodel.addRow(new Object[]{itemsdata.get(i).getitemnumber(), itemsdata.get(i).getitemname(), itemsdata.get(i).getquantity(), "RM " + priceformatter.format(itemsdata.get(i).gettotalitems())});
		}
	}
}
