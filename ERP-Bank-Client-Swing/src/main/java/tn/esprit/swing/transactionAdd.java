package tn.esprit.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.eclipse.jdt.core.CheckDebugAttributes;

import tn.esprit.delegator.GestionTransactionDelegate;
import tn.esprit.entites.Account;
import tn.esprit.entites.Transaction;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class transactionAdd extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_amount;
	Account accountToSet ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			transactionAdd dialog = new transactionAdd();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public transactionAdd() {
		accountToSet = new Account();
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblAmount = new JLabel("Amount :");
		lblAmount.setBounds(21, 68, 85, 14);
		contentPanel.add(lblAmount);

		JLabel label_account = new JLabel("");
		label_account.setBounds(120, 102, 219, 14);
		contentPanel.add(label_account);

		textField_amount = new JTextField();
		textField_amount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				try
				{
              Float.parseFloat(textField_amount.getText());
				}
				catch(NumberFormatException r)
				{
					textField_amount.setText(null);
			}
			}
		});
		textField_amount.setBounds(116, 65, 147, 20);
		contentPanel.add(textField_amount);
		textField_amount.setColumns(10);

		JButton btnAccount = new JButton("Account");
		btnAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetAccount acc = new GetAccount();
				acc.setModal(true);
				acc.setVisible(true);
				accountToSet = acc.accountToGet;
				label_account.setText( accountToSet.getId() + ":"+accountToSet.getClient().getName()+" "+accountToSet.getClient().getLastName());			}
		});
		btnAccount.setBounds(21, 98, 89, 23);
		contentPanel.add(btnAccount);




		JCheckBox checkDepos = new JCheckBox("Deposit");
		checkDepos.setBounds(21, 142, 97, 23);
		contentPanel.add(checkDepos);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
              Transaction transaction = new Transaction();
              transaction.setAmount(Float.parseFloat(textField_amount.getText()));
              transaction.setDate(Date.valueOf(LocalDate.now()).toString());
			    transaction.setTime(Time.valueOf(LocalTime.now()).toString());
			    transaction.setEffect(checkDepos.isSelected());
			    transaction.setAccount(accountToSet);
				GestionTransactionDelegate.ajouterTransaction(transaction);
			}
		});
		btnAdd.setBounds(10, 227, 89, 23);
		contentPanel.add(btnAdd);

		JLabel lblTransaction = new JLabel("Transaction");
		lblTransaction.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTransaction.setBounds(10, 11, 205, 32);
		contentPanel.add(lblTransaction);

	}
}
