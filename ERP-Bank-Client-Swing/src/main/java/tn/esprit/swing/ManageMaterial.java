package tn.esprit.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import tn.esprit.delegator.GestionMaterialDelegate;


import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class ManageMaterial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageMaterial frame = new ManageMaterial();
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
	public ManageMaterial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add material");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addMaterial frame = new addMaterial();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(221, 127, 233, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("List of all materials");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listMaterial frame = new listMaterial();
				frame.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(221, 180, 233, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Statistics");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			stat frame = new stat();
				frame.setVisible(true);
				
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(221, 235, 233, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IinventoryManager frame = new IinventoryManager();
				frame.setVisible(true);
			}
		});
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setBounds(580, 357, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblBanksMaterial = new JLabel("Bank's Material");
		lblBanksMaterial.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblBanksMaterial.setBounds(221, 35, 233, 42);
		contentPane.add(lblBanksMaterial);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ManageMaterial.class.getResource("/images/back3.jpg")));
		label.setBounds(0, 0, 704, 456);
		contentPane.add(label);
	}
}
