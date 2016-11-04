package tn.esprit.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ManageSupplier extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageSupplier frame = new ManageSupplier();
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
	public ManageSupplier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBanksSuppliers = new JLabel("Bank's Suppliers");
		lblBanksSuppliers.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblBanksSuppliers.setBounds(237, 40, 233, 42);
		contentPane.add(lblBanksSuppliers);
		
		JButton btnListAllSuppliers = new JButton("List all Suppliers");
		btnListAllSuppliers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listSupplier frame = new listSupplier();
				frame.setVisible(true);
			}
		});
		btnListAllSuppliers.setBounds(227, 176, 243, 42);
		contentPane.add(btnListAllSuppliers);
		
		JButton btnAddSupplier = new JButton("Add Supplier");
		btnAddSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSupplier frame = new addSupplier();
				frame.setVisible(true);
			}
		});
		btnAddSupplier.setBounds(227, 115, 243, 42);
		contentPane.add(btnAddSupplier);
		
		JButton btnContact = new JButton("Contact");
		btnContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		//	Imail frame = new Imail();
			//	frame.setVisible(true);
			}
		});
		btnContact.setBounds(227, 242, 243, 42);
		contentPane.add(btnContact);
		
		JButton btnRetour = new JButton("Back");
		btnRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IinventoryManager frame = new IinventoryManager();
				frame.setVisible(true);
			}
		});
		btnRetour.setBounds(574, 356, 89, 23);
		contentPane.add(btnRetour);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ManageSupplier.class.getResource("/images/back3.jpg")));
		label.setBounds(0, 0, 704, 390);
		contentPane.add(label);
	}

}
