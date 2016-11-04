package tn.esprit.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;




import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class IinventoryManager extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IinventoryManager frame = new IinventoryManager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IinventoryManager() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIventoryManager = new JLabel("                                   Iventory Manager");
		lblIventoryManager.setBounds(5, 5, 694, 20);
		lblIventoryManager.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 17));
		lblIventoryManager.setBackground(Color.WHITE);
		contentPane.add(lblIventoryManager);
		
		JButton logout = new JButton("Log out");
		logout.setBounds(24, 356, 109, 25);
		logout.setFont(new Font("Times New Roman", Font.BOLD, 13));
		logout.setForeground(Color.RED);
		logout.setToolTipText("");
		logout.setVerticalAlignment(SwingConstants.BOTTOM);
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(logout);
		
		JButton btnSuppliersSpace = new JButton("Supplier's space");
		btnSuppliersSpace.setBounds(257, 166, 180, 100);
		btnSuppliersSpace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageSupplier frame =new ManageSupplier();
				frame.setVisible(true);
			}
		});
		btnSuppliersSpace.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(btnSuppliersSpace);
		
		JButton btnManageBanksMaterial = new JButton("Bank's material");
		btnManageBanksMaterial.setBounds(519, 251, 180, 100);
		btnManageBanksMaterial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageMaterial frame = new ManageMaterial();
				frame.setVisible(true);
			}
		});
		btnManageBanksMaterial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnManageBanksMaterial.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(btnManageBanksMaterial);
		
		JButton btnManageLocal = new JButton("Manage Local");
		btnManageLocal.setBounds(24, 50, 180, 100);
		btnManageLocal.setFont(new Font("Times New Roman", Font.BOLD, 15));
		contentPane.add(btnManageLocal);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(IinventoryManager.class.getResource("/images/back3.jpg")));
		label.setBounds(0, 5, 704, 434);
		contentPane.add(label);
	}
}
