package tn.esprit.swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;


import tn.esprit.delegator.GestionClientDelegate;
import tn.esprit.delegator.GestionContractDelegator;
import tn.esprit.entites.Client;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import org.hibernate.engine.jdbc.ColumnNameCache;
import org.omg.CORBA.PUBLIC_MEMBER;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class ClientManagement extends JFrame {

	private JPanel contentPane;
	private JTextField textField_name;
	private JTextField textField_lastName;
	private JTextField textField_bitrhDte;
	private JTextField textField_regDate;
	private JTextField textField_mail;
	private JTextField textField_phone;
	private JTable table;
	public  int[]  list_id = new int[100000000];
	private JTextField textField_search;
	public List<Client> Clients;
	public Client clienT;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					ClientManagement frame = new ClientManagement();
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
	public ClientManagement() throws ParseException {
		MaskFormatter mf2;

Clients= new ArrayList<Client>();
Clients = GestionClientDelegate.listerClient();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 521);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setBounds(20, 88, 107, 14);
		contentPane.add(lblNewLabel);

		textField_name = new JTextField();
		textField_name.setBounds(93, 85, 135, 20);
		contentPane.add(textField_name);
		textField_name.setColumns(10);

		JLabel lblLastName = new JLabel("Last name :");
		lblLastName.setBounds(20, 114, 107, 14);
		contentPane.add(lblLastName);

		textField_lastName = new JTextField();
		textField_lastName.setColumns(10);
		textField_lastName.setBounds(93, 111, 135, 20);
		contentPane.add(textField_lastName);

		textField_bitrhDte = new JFormattedTextField(new MaskFormatter("##/##/####"));
		textField_bitrhDte.setColumns(10);
		textField_bitrhDte.setBounds(93, 139, 135, 20);
		contentPane.add(textField_bitrhDte);

		textField_regDate = new JFormattedTextField(new MaskFormatter("##/##/####"));
		textField_regDate.setColumns(10);
		textField_regDate.setBounds(93, 170, 135, 20);
		contentPane.add(textField_regDate);

		JLabel lblRegistrationDate = new JLabel("Registration :");
		lblRegistrationDate.setBounds(20, 168, 107, 14);
		contentPane.add(lblRegistrationDate);

		JLabel lblBirthDate = new JLabel("Birth date:");
		lblBirthDate.setBounds(20, 142, 107, 14);
		contentPane.add(lblBirthDate);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(20, 227, 107, 14);
		contentPane.add(lblEmail);

		textField_mail = new JTextField();
		textField_mail.setColumns(10);
		textField_mail.setBounds(93, 224, 135, 20);
		contentPane.add(textField_mail);

		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(20, 199, 107, 14);
		contentPane.add(lblPhone);

		textField_phone =  new JFormattedTextField(new MaskFormatter("########"));
		textField_phone.setColumns(10);
		textField_phone.setBounds(93, 196, 135, 20);
		contentPane.add(textField_phone);

		 JComboBox comboBox = new JComboBox();
		 comboBox.setModel(new DefaultComboBoxModel(new String[] {"name", "phone"}));
		 comboBox.setBounds(20, 429, 162, 20);
		 contentPane.add(comboBox);


 JScrollPane scrollPane = new JScrollPane();
 scrollPane.addMouseListener(new MouseAdapter() {
 	@Override
 	public void mouseClicked(MouseEvent e) {

 	}
 });
 scrollPane.setBounds(238, 68, 565, 395);
 contentPane.add(scrollPane);


 table = new JTable();

 scrollPane.setViewportView(table);

 JButton btnAdd = new JButton("Add");
 btnAdd.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {

 		Client client = new Client();
 		client.setName(textField_name.getText());
 		client.setLastName(textField_lastName.getText());
 		client.setBirthDate(textField_bitrhDte.getText());
 		client.setRegistrationDate(textField_regDate.getText());
 		client.setEmail(textField_mail.getText());
 		client.setPhoneNumber(textField_phone.getText());
 		client.setPassWord(textField_name.getText()+"AD");
 		client.setLogin(textField_name.getText()+"AD");
 		GestionClientDelegate.ajouterClient(client);

        Clients = GestionClientDelegate.listerClient();
initDataBindings();

      clearFields();
 	}
 });

 btnAdd.setBounds(20, 268, 89, 23);
 contentPane.add(btnAdd);


 JButton btnSave = new JButton("Save");
 btnSave.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {

 		clienT = Clients.get(table.getSelectedRow());
        clienT.setName(textField_name.getText());
        GestionClientDelegate.updateClient(clienT);
        Clients = GestionClientDelegate.listerClient();
        initDataBindings();
        clearFields();
        btnAdd.setEnabled(true);

 	}
 });
 btnSave.setBounds(119, 268, 89, 23);
 contentPane.add(btnSave);

 JButton btnDelete = new JButton("Delete");
 btnDelete.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 		clienT = Clients.get(table.getSelectedRow());
 		GestionClientDelegate.deleteClient(clienT);
 		 Clients = GestionClientDelegate.listerClient();
 		  clearFields();
 		 initDataBindings();
         btnAdd.setEnabled(true);
 	}
 });
 btnDelete.setBounds(20, 302, 89, 23);
 contentPane.add(btnDelete);



 table.addMouseListener(new MouseAdapter() {
	 	@Override
	 	public void mouseClicked(MouseEvent e) {

	 		if(e.getClickCount() == 2)
	 		{
	 			Client client = new Client();
	 		client=	GestionClientDelegate.findClientByID(Clients.get(table.getSelectedRow()).getId())  ;
	 		textField_name.setText(client.getName());
	 		textField_lastName.setText(client.getLastName());
	 		textField_mail.setText(client.getEmail());
	 		textField_phone.setText(client.getPhoneNumber());
	 		textField_regDate.setText(client.getRegistrationDate());
	 		textField_bitrhDte.setText(client.getBirthDate());
            btnAdd.setEnabled(false);
	 		}
	 	}
	 });


 JButton refreshBtn = new JButton("Refresh");
 refreshBtn.addActionListener(new ActionListener() {
 	public void actionPerformed(ActionEvent e) {
 		Clients = GestionClientDelegate.listerClient();
		  clearFields();
		 initDataBindings();
       btnAdd.setEnabled(true);

 	}
 });
 refreshBtn.setBounds(119, 302, 89, 23);
 contentPane.add(refreshBtn);

 textField_search = new JTextField();
 textField_search.addKeyListener(new KeyAdapter() {
 	@Override
 	public void keyPressed(KeyEvent e) {

 	}
 	@Override
 	public void keyReleased(KeyEvent e) {
 		Clients = GestionClientDelegate.findClientByName(textField_search.getText());
 		initDataBindings();
 	}
 });


 textField_search.setBounds(20, 398, 162, 20);
 contentPane.add(textField_search);
 textField_search.setColumns(10);



 JLabel lblSearch = new JLabel("Search :");
 lblSearch.setBounds(20, 373, 135, 14);
 contentPane.add(lblSearch);

 JLabel lblClient = new JLabel("Client");
 lblClient.setFont(new Font("Arial", Font.BOLD, 21));
 lblClient.setBounds(10, 11, 135, 64);
 contentPane.add(lblClient);
 initDataBindings();

	}
	 public void removeRowsFTable(DefaultTableModel model)
	 {
		 try{
		 if(model.getColumnCount() > 1)
		 {
		 for(int i=0;i<model.getColumnCount();i++)
		 {
			 model.removeRow(i);
	     }
		 }
		 }catch(IndexOutOfBoundsException  f){}
	 }
	public void clearFields()
	{
       textField_bitrhDte.setText(null);
       textField_lastName.setText(null);
       textField_name.setText(null);
       textField_mail.setText(null);
       textField_phone.setText(null);
       textField_regDate.setText(null);

	}
	protected void initDataBindings() {
		JTableBinding<Client, List<Client>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, Clients, table);
		//
		BeanProperty<Client, String> clientBeanProperty = BeanProperty.create("name");
		jTableBinding.addColumnBinding(clientBeanProperty).setColumnName("Name").setEditable(false);
		//
		BeanProperty<Client, String> clientBeanProperty_1 = BeanProperty.create("lastName");
		jTableBinding.addColumnBinding(clientBeanProperty_1).setColumnName("Last name").setEditable(false);
		//
		BeanProperty<Client, String> clientBeanProperty_2 = BeanProperty.create("phoneNumber");
		jTableBinding.addColumnBinding(clientBeanProperty_2).setColumnName("Phone number").setEditable(false);
		//
		jTableBinding.bind();
	}
}
