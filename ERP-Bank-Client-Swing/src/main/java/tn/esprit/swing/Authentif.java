package tn.esprit.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import tn.esprit.delegator.GestionEmployeeDelegator;
import tn.esprit.entites.Employee;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DropMode;
import javax.swing.JPasswordField;

public class Authentif extends JFrame {

	private JPanel contentPane;
	private JTextField pseudo;
	Employee employee;
	manageHR h = new manageHR();
	private JPasswordField pass;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Authentif frame = new Authentif();
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
	public Authentif() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Dashboard", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnLogin = new JButton("");
		btnLogin.setIcon(new ImageIcon(AddE.class.getResource("/images/login.png")));
		btnLogin.setOpaque(false);
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String user=pseudo.getText().toString();
				String passw=pass.getText().toString();
			
				if (GestionEmployeeDelegator.findEmployeeInventory(user, passw)==false)
				{
					Authentif.this.dispose();
					new IinventoryManager().show();
				}
				else  if(GestionEmployeeDelegator.findEmployee(user, passw)==false)
				{
				Authentif.this.dispose();
					h.show();
				}
			

				
			}
		});
		
		pass = new JPasswordField();
		pass.setBounds(186, 125, 95, 20);
		panel.add(pass);
		btnLogin.setBounds(315, 76, 82, 73);
		panel.add(btnLogin);
		
		JLabel lblPseudo = new JLabel("Pseudo");
		lblPseudo.setFont(new Font("Swiss921 BT", Font.ITALIC, 13));
		lblPseudo.setBounds(49, 75, 66, 17);
		panel.add(lblPseudo);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Swiss921 BT", Font.ITALIC, 13));
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setBounds(50, 119, 95, 30);
		panel.add(lblPassword);
		
		pseudo = new JTextField();
		pseudo.setBounds(186, 72, 95, 20);
		panel.add(pseudo);
		pseudo.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddE.class.getResource("/images/back3.jpg")));
		label.setBounds(0, 0, 434, 261);
		panel.add(label);
	}
}
