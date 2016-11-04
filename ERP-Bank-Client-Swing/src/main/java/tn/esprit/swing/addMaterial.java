package tn.esprit.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;

import tn.esprit.delegator.GestionMaterialDelegate;
import tn.esprit.entites.Material;

import java.awt.Font;
import javax.swing.ImageIcon;

public class addMaterial extends JFrame {

	private JPanel contentPane;
	private JTextField designation;
	private JTextField quantite;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addMaterial frame = new addMaterial();
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
	public addMaterial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageMaterial frame = new ManageMaterial();
				frame.setVisible(true);
			}
		});
		btnBack.setBounds(575, 357, 89, 23);
		contentPane.add(btnBack);
		
		designation = new JTextField();
		designation.setBounds(271, 140, 154, 20);
		contentPane.add(designation);
		designation.setColumns(10);
		
		quantite = new JTextField();
		quantite.setBounds(271, 233, 154, 20);
		contentPane.add(quantite);
		quantite.setColumns(10);
		
		JLabel lblDesignation = new JLabel("Designation:");
		lblDesignation.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDesignation.setBounds(135, 138, 103, 23);
		contentPane.add(lblDesignation);
		
		JLabel lblQuntite = new JLabel("Quantite:");
		lblQuntite.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblQuntite.setBounds(135, 227, 105, 30);
		contentPane.add(lblQuntite);
		
		JButton btnAdd = new JButton("Save");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Material m =new Material();
				m.setDesignation(designation.getText().toString());
				m.setQuantite(Integer.parseInt(quantite.getText()));
				GestionMaterialDelegate.doAddMaterial(m);
				/*if (AccountManagementDelegate.doAdd(account)) {
					JOptionPane.showMessageDialog(null, "ok...");
					login_txt.setText("");
					pwd_txt.setText("");

				} else {
					System.out.println("Failed to add account!");
				}
			}*/
			
			
		
			}
		});
		btnAdd.setBounds(431, 357, 89, 23);
		contentPane.add(btnAdd);
		
		JLabel lblAddMaterial = new JLabel("Add Material");
		lblAddMaterial.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblAddMaterial.setBounds(20, 11, 233, 53);
		contentPane.add(lblAddMaterial);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(addMaterial.class.getResource("/images/back3.jpg")));
		lblNewLabel.setBounds(0, 0, 716, 439);
		contentPane.add(lblNewLabel);
	}
}
