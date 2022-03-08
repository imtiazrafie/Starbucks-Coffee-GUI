package main;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;

public class Welcomeframe extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the application.
	 */
	JProgressBar progressBar = new JProgressBar();
	JLabel lblNewLabel_3 = new JLabel("Welcome! Starting up...");
	public Welcomeframe() {
		setUndecorated(true);
		setResizable(false);
		setTitle(Main.getappname());
		setBounds(100, 100, 765, 387);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(this.getClass().getResource("/main/logo/logo.png")).getImage());
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 306, 766, 81);
		panel.setBackground(new Color(46, 139, 87));
		getContentPane().add(panel);
		
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(Color.WHITE);

		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_3)
						.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, 697, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(38, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(313))
		);
		progressBar.setVisible(false);
		progressBar.setForeground(new Color(192, 192, 192));
		panel.setLayout(gl_panel);
		
				JPanel panel_1 = new JPanel();
				panel_1.setBounds(0, 0, 766, 307);
				getContentPane().add(panel_1);
				panel_1.setForeground(Color.BLACK);
				panel_1.setBackground(new Color(143, 188, 143));
				
						JLabel lblNewLabel_1 = new JLabel("");
						lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 11));
						lblNewLabel_1.setBounds(322, 11, 128, 137);
						lblNewLabel_1.setIcon(new ImageIcon(Welcomeframe.class.getResource("/main/logo/welcome.png")));
						
								JLabel lblNewLabel_2 = new JLabel("STARBUCKS COFFEE");
								lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
								lblNewLabel_2.setBounds(0, 184, 766, 50);
								lblNewLabel_2.setForeground(new Color(0, 0, 0));
								lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 35));
								
										JLabel lblNewLabel = new JLabel("By: " + Main.getcontributor());
										lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
										lblNewLabel.setBounds(0, 280, 766, 27);
										lblNewLabel.setForeground(new Color(0, 0, 0));
										lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 14));
										panel_1.setLayout(null);
										panel_1.add(lblNewLabel_1);
										panel_1.add(lblNewLabel_2);
										panel_1.add(lblNewLabel);
										
										JLabel lblNewLabel_4 = new JLabel("WELCOME TO");
										lblNewLabel_4.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
										lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
										lblNewLabel_4.setBounds(0, 170, 766, 14);
										panel_1.add(lblNewLabel_4);
										
										JLabel lblNewLabel_4_1 = new JLabel("CASHIER SYSTEM");
										lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
										lblNewLabel_4_1.setFont(new Font("Arial", Font.BOLD, 14));
										lblNewLabel_4_1.setBounds(0, 231, 766, 14);
										panel_1.add(lblNewLabel_4_1);
	}
}
