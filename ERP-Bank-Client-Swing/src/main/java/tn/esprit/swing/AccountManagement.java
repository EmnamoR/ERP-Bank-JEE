package tn.esprit.swing;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import tn.esprit.delegator.GestionAccountDelegate;
import tn.esprit.delegator.GestionClientDelegate;
import tn.esprit.entites.Account;
import tn.esprit.entites.Client;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.Font;
import javax.swing.JTextPane;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AccountManagement extends JFrame {

	JComboBox comboBox_accountType;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField_balance;
	private JTextField textField_date;
	List<Account> Accounts;
	private JTextField textField_search;
	private Client clientToSet;
	JLabel label_client;
    Account account;
    JButton btnSave;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountManagement frame = new AccountManagement();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException
	 */
	public AccountManagement() throws ParseException {

account = new Account();
		clientToSet = new Client();
		Accounts = new ArrayList<Account>();
		Accounts = GestionAccountDelegate.findAllAccount();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboBox_accountType = new JComboBox();
		comboBox_accountType.setModel(new DefaultComboBoxModel(new String[] {"Saving Account", "Basic Checking Account", "Certificates of Deposit"}));
		comboBox_accountType.setBounds(71, 92, 123, 20);
		contentPane.add(comboBox_accountType);


		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Account account = new Account();

				account.setBalance(Float.parseFloat( textField_balance.getText()));
				account.setAccountType(comboBox_accountType.getSelectedItem().toString());
				account.setOpnedDate(textField_date.getText());
				account.setClient(clientToSet);
				GestionAccountDelegate.ajouterAccount(account );
				Accounts = GestionAccountDelegate.findAllAccount();
				initDataBindings();
				clearFields();
			}
		});
		btnAdd.setBounds(10, 304, 89, 23);
		contentPane.add(btnAdd);

		 btnSave = new JButton("Save");
		 btnSave.setEnabled(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				account.setClient(clientToSet);
				account.setAccountType(comboBox_accountType.getSelectedItem().toString());
				account.setBalance(Float.parseFloat(textField_balance.getText()));
				account.setOpnedDate(textField_date.getText());
				GestionAccountDelegate.updateAccount(account);
				Accounts=GestionAccountDelegate.findAllAccount();
				initDataBindings();
				clearFields();
				btnAdd.setEnabled(true);
			}
		});
		btnSave.setBounds(105, 304, 89, 23);
		contentPane.add(btnSave);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestionAccountDelegate.deleteAccount(account);
				Accounts = GestionAccountDelegate.findAllAccount();
				initDataBindings();
				clearFields();
				btnAdd.setEnabled(true);
			}
		});
		btnDelete.setBounds(10, 331, 89, 23);
		contentPane.add(btnDelete);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFields();
				btnAdd.setEnabled(true);
				Accounts= GestionAccountDelegate.findAllAccount();
				initDataBindings();
			}
		});
		btnRefresh.setBounds(105, 331, 89, 23);
		contentPane.add(btnRefresh);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(204, 63, 424, 377);
		contentPane.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2)
				{
		account= Accounts.get(table.getSelectedRow());
		textField_balance.setText(String.valueOf( account.getBalance()));
		textField_date.setText(account.getOpnedDate());
		comboBox_accountType.setSelectedItem(account.getAccountType());
		label_client.setText(account.getClient().getName()+" "+account.getClient().getLastName());
		clientToSet=account.getClient();
        btnAdd.setEnabled(false);
        btnSave.setEnabled(true);
				}
			}
		});
		scrollPane.setViewportView(table);


		textField_balance = new JTextField();
		textField_balance.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {


				try
				{
              Float.parseFloat(textField_balance.getText());
				}
				catch(NumberFormatException r)
				{
					textField_balance.setText(null);
			}

			}
		});


		textField_balance.setBounds(71, 125, 123, 20);
		contentPane.add(textField_balance);
		textField_balance.setColumns(10);

		textField_date =  new JFormattedTextField(new MaskFormatter("##/##/####"));
		textField_date.setBounds(71, 156, 123, 20);
		contentPane.add(textField_date);
		textField_date.setColumns(10);

		label_client = new JLabel("");
		label_client.setBounds(10, 220, 184, 23);
		contentPane.add(label_client);

		JButton btnClient = new JButton("Client");
		btnClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 final	GetClientDialog ahla = new GetClientDialog();

			 ahla.setModal(true);
                ahla.setVisible(true);

                clientToSet = ahla.clientToGet;
                label_client.setText(clientToSet.getName()+" "+clientToSet.getLastName());
                Accounts= GestionAccountDelegate.findAccountByClientId(clientToSet.getId());
                initDataBindings();
			}
		});
		btnClient.setBounds(10, 187, 184, 23);
		contentPane.add(btnClient);

		JLabel lblNewLabel = new JLabel("Type");
		lblNewLabel.setBounds(15, 95, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Balance");
		lblNewLabel_1.setBounds(15, 128, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(15, 159, 46, 14);
		contentPane.add(lblDate);


		JLabel lblAccount = new JLabel("Account");
		lblAccount.setFont(new Font("Arial", Font.PLAIN, 20));
		lblAccount.setBounds(10, 11, 116, 30);
		contentPane.add(lblAccount);



		textField_search = new JTextField();
		textField_search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
		  Accounts.clear();
		  Accounts.add(GestionAccountDelegate.findAccountById(Integer.parseInt( textField_search.getText())));
		  initDataBindings();
			}
		});
		textField_search.setBounds(10, 396, 184, 20);
		contentPane.add(textField_search);
		textField_search.setColumns(10);

		JLabel lblSearch = new JLabel("Search :");
		lblSearch.setBounds(10, 371, 46, 14);
		contentPane.add(lblSearch);
		initDataBindings();




	}

	 void clearFields()
		{
			textField_balance.setText(null);
			textField_date.setText(null);
            label_client.setText(null);
            comboBox_accountType.setSelectedIndex(1);
            textField_search.setText(null);
btnSave.setEnabled(false);
		}
	protected void initDataBindings() {
		JTableBinding<Account, List<Account>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, Accounts, table);
		//
		BeanProperty<Account, String> accountBeanProperty = BeanProperty.create("client.name");
		jTableBinding.addColumnBinding(accountBeanProperty).setColumnName("Client");
		//
		BeanProperty<Account, String> accountBeanProperty_1 = BeanProperty.create("client.name");
		jTableBinding.addColumnBinding(accountBeanProperty_1).setColumnName("Name");
		//
		BeanProperty<Account, Float> accountBeanProperty_2 = BeanProperty.create("balance");
		jTableBinding.addColumnBinding(accountBeanProperty_2).setColumnName("Balance");
		//
		BeanProperty<Account, Integer> accountBeanProperty_3 = BeanProperty.create("id");
		jTableBinding.addColumnBinding(accountBeanProperty_3).setColumnName("RIB");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}
