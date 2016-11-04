package tn.esprit.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import tn.esprit.entites.Material;
import tn.esprit.entites.Supplier;
import tn.esprit.delegator.GestionMaterialDelegate;
import tn.esprit.delegator.GestionSupplierDelegate;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addSupplier extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField adress;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addSupplier frame = new addSupplier();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public addSupplier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddSupplier = new JLabel("Add Supplier");
		lblAddSupplier.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblAddSupplier.setBounds(26, 11, 233, 53);
		contentPane.add(lblAddSupplier);
		
		JLabel lblNewLabel = new JLabel("name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(46, 130, 59, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("adress");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(46, 185, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("email");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setBounds(46, 241, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		name = new JTextField();
		name.setBounds(198, 127, 142, 26);
		contentPane.add(name);
		name.setColumns(10);
		
		adress = new JTextField();
		adress.setBounds(198, 182, 142, 26);
		contentPane.add(adress);
		adress.setColumns(10);
		
		email = new JTextField();
		email.setBounds(198, 238, 142, 26);
		contentPane.add(email);
		email.setColumns(10);
		
		JButton save = new JButton("Save");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Supplier s=new Supplier();
				s.setName(name.getText().toString());
				s.setAdress(adress.getText());
				s.setEmail(email.getText().toString());
				GestionSupplierDelegate.doAddSupplier(s);
			}
		});
		save.setBounds(369, 343, 89, 23);
		contentPane.add(save);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageSupplier frame = new ManageSupplier();
				frame.setVisible(true);
			}
		});
		btnBack.setBounds(478, 343, 89, 23);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddE.class.getResource("/images/back3.jpg")));
		label.setBounds(0, 0, 718, 452);
		contentPane.add(label);
	}

}
