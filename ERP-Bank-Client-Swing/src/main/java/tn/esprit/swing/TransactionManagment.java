package tn.esprit.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tn.esprit.delegator.GestionTransactionDelegate;
import tn.esprit.entites.Transaction;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

public class TransactionManagment extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransactionManagment frame = new TransactionManagment();
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
	public TransactionManagment() {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnTransaction = new JButton("Transaction");
		btnTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
transactionAdd a = new transactionAdd();
a.setModal(true);
a.setVisible(true);

}
		});
		btnTransaction.setBounds(20, 79, 140, 181);
		contentPane.add(btnTransaction);

		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TransferManagement tran = new TransferManagement();
				tran.setModal(true);
				tran.setVisible(true);

			}
		});
		btnTransfer.setBounds(170, 79, 140, 181);
		contentPane.add(btnTransfer);

		JButton btnDraft = new JButton("Draft");
		btnDraft.setBounds(320, 79, 145, 181);
		contentPane.add(btnDraft);

		JLabel lblTransaction = new JLabel("Transaction");
		lblTransaction.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTransaction.setBounds(10, 11, 186, 61);
		contentPane.add(lblTransaction);

		JButton btnReporting = new JButton("Reporting");
		btnReporting.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			SimpleReport	rr= new SimpleReport();
			rr.SimpleReportt();

			}
		});
		btnReporting.setBounds(473, 79, 147, 181);
		contentPane.add(btnReporting);
	}

}
