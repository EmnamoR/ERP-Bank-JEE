package tn.esprit.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class BankActor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankActor frame = new BankActor();
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
	public BankActor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnClient = new JButton("Client");
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				new	ClientManagement().setVisible(true);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} ;
			}
		});
		btnClient.setBounds(10, 110, 118, 116);
		contentPane.add(btnClient);

		JButton btnAccount = new JButton("Account");
		btnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new AccountManagement().setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAccount.setBounds(138, 110, 138, 116);
		contentPane.add(btnAccount);

		JButton btnManageTransaction = new JButton("Manage transaction");
		btnManageTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TransactionManagment().setVisible(true);
			}
		});
		btnManageTransaction.setBounds(286, 110, 138, 116);
		contentPane.add(btnManageTransaction);

		JLabel lblMenu = new JLabel("Menu :");
		lblMenu.setBounds(10, 11, 46, 14);
		contentPane.add(lblMenu);
	}

}
