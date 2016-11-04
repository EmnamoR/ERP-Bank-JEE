package tn.esprit.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tn.esprit.delegator.GestionTransactionDelegate;
import tn.esprit.entites.Account;
import tn.esprit.entites.Transfer;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TransferManagement extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField_amonut;
	private JTextField textField_iban;
	private JTextField textField_bic;
	private JTextField textField_fullname;
	private JTextField textField_rib;
	Account accountToSet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TransferManagement dialog = new TransferManagement();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TransferManagement() {

		accountToSet = new Account();

		setBounds(100, 100, 500, 390);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

			textField_amonut = new JTextField();
			textField_amonut.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {


					try
					{
	              Float.parseFloat(textField_amonut.getText());
					}
					catch(NumberFormatException r)
					{
						textField_amonut.setText(null);
				}
				}
			});
			textField_amonut.setBounds(98, 92, 150, 20);
			contentPanel.add(textField_amonut);
			textField_amonut.setColumns(10);

			textField_iban = new JTextField();
			textField_iban.setBounds(98, 187, 150, 20);
			contentPanel.add(textField_iban);
			textField_iban.setColumns(10);

			textField_bic = new JTextField();
			textField_bic.setBounds(98, 220, 150, 20);
			contentPanel.add(textField_bic);
			textField_bic.setColumns(10);

			textField_fullname = new JTextField();
			textField_fullname.setBounds(98, 251, 150, 20);
			contentPanel.add(textField_fullname);
			textField_fullname.setColumns(10);

			textField_rib = new JTextField();
			textField_rib.setBounds(98, 282, 150, 20);
			contentPanel.add(textField_rib);
			textField_rib.setColumns(10);

			JLabel label_account = new JLabel(" ");
			label_account.setBounds(265, 321, 198, 14);
			contentPanel.add(label_account);

			JButton btnAccount = new JButton("Account");
			btnAccount.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
GetAccount acc = new GetAccount();
acc.setModal(true);
acc.setVisible(true);
accountToSet = acc.accountToGet;
label_account.setText( accountToSet.getId() + ":"+accountToSet.getClient().getName()+" "+accountToSet.getClient().getLastName());

				}
			});
			btnAccount.setBounds(98, 317, 150, 23);
			contentPanel.add(btnAccount);

			JLabel lblNewLabel = new JLabel("Amount :");
			lblNewLabel.setBounds(10, 95, 78, 14);
			contentPanel.add(lblNewLabel);

			JLabel lblIban = new JLabel("IBAN :");
			lblIban.setBounds(10, 190, 81, 14);
			contentPanel.add(lblIban);

			JLabel lblBic = new JLabel("BIC :");
			lblBic.setBounds(10, 223, 67, 14);
			contentPanel.add(lblBic);

			JLabel lblFullName = new JLabel("Full name :");
			lblFullName.setBounds(10, 254, 116, 14);
			contentPanel.add(lblFullName);

			JLabel lblRib = new JLabel("RIB  :");
			lblRib.setBounds(10, 285, 80, 14);
			contentPanel.add(lblRib);



			JLabel lblTransfer = new JLabel("Transfer");
			lblTransfer.setFont(new Font("Arial", Font.PLAIN, 21));
			lblTransfer.setBounds(10, 11, 133, 48);
			contentPanel.add(lblTransfer);

			JButton btnAddsave = new JButton("Add");
			btnAddsave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Transfer trans = new Transfer();
					accountToSet.setId(100000);
					trans.setAccount(accountToSet);
				    trans.setAmount(Float.parseFloat(textField_amonut.getText()));
				    trans.setBIC(textField_bic.getText());
				    trans.setDate(Date.valueOf(LocalDate.now()).toString());
				    trans.setTime(Time.valueOf(LocalTime.now()).toString());
				    trans.setEffect(false);
				    trans.setIBAN(textField_iban.getText());
                    trans.setNameFull(textField_fullname.getText());
                    trans.setRIB(textField_rib.getText());
                    GestionTransactionDelegate.ajouterTransaction(trans);
                    JOptionPane.showMessageDialog(TransferManagement.this,"Transfer added", "Good", JOptionPane.INFORMATION_MESSAGE,null);
            setVisible(false);
}
			});
			btnAddsave.setBounds(321, 155, 89, 23);
			contentPanel.add(btnAddsave);
		}
	}


