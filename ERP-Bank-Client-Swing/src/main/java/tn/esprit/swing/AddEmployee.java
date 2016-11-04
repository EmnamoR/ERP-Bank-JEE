package tn.esprit.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

import tn.esprit.delegator.GestionEmployeeDelegator;
import tn.esprit.entites.Employee;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

import org.hibernate.dialect.JDataStoreDialect;

public class AddEmployee extends JFrame {

	DateFormat format = new SimpleDateFormat("dd/mm/yyy");
	private JPanel contentPane;
	private JFormattedTextField birthDate;
	private JTextField cin;
	private JTextField adresse;
	private JTextField mail;
	private JTextField kids;
	private JTextField lastName;
	private JTextField name;
	private JTextField phone;
	private JTextField username;
	private JPasswordField password;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee frame = new AddEmployee();
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
	public AddEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		birthDate = new JFormattedTextField(format);
		birthDate.setBounds(92, 308, 142, 20);

		//birthDate.setfor

		contentPane.add(birthDate);
		birthDate.setColumns(10);

		cin = new JTextField();
		cin.setBounds(92, 127, 142, 20);
		contentPane.add(cin);
		cin.setColumns(10);

		JButton btnAdd = new JButton("add");
		btnAdd.setIcon(new ImageIcon("C:\\Users\\pein\\Desktop\\add.png"));

		btnAdd.setBounds(313, 261, 224, 126);
		contentPane.add(btnAdd);

		adresse = new JTextField();
		adresse.setBounds(92, 339, 142, 20);
		contentPane.add(adresse);
		adresse.setColumns(10);

		mail = new JTextField();
		mail.setBounds(92, 189, 142, 20);
		contentPane.add(mail);
		mail.setColumns(10);

		kids = new JTextField();
		kids.setBounds(92, 277, 142, 20);
		contentPane.add(kids);
		kids.setColumns(10);

		lastName = new JTextField();
		lastName.setBounds(92, 99, 142, 20);
		contentPane.add(lastName);
		lastName.setColumns(10);

		name = new JTextField();
		name.setBounds(92, 73, 142, 20);
		contentPane.add(name);
		name.setColumns(10);

		phone = new JTextField();
		phone.setBounds(92, 246, 142, 20);
		contentPane.add(phone);
		phone.setColumns(10);

		username = new JTextField();
		username.setBounds(92, 11, 142, 20);
		contentPane.add(username);
		username.setColumns(10);

		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(10, 45, 46, 14);
		contentPane.add(lblPassword);

		JLabel lblUsername = new JLabel("username");
		lblUsername.setBounds(10, 14, 72, 14);
		contentPane.add(lblUsername);

		JLabel lblSex = new JLabel("Sex");
		lblSex.setBounds(10, 221, 46, 14);
		contentPane.add(lblSex);

		JLabel lblPhone = new JLabel("Phone Number");
		lblPhone.setBounds(10, 249, 86, 14);
		contentPane.add(lblPhone);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(10, 76, 46, 14);
		contentPane.add(lblName);

		JLabel lblLastname = new JLabel("Last Name");
		lblLastname.setBounds(10, 102, 72, 14);
		contentPane.add(lblLastname);

		JLabel lblKids = new JLabel("Kids Number");
		lblKids.setBounds(10, 280, 72, 14);
		contentPane.add(lblKids);

		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(10, 192, 46, 14);
		contentPane.add(lblMail);

		JLabel lblNewLabel = new JLabel("Civil");
		lblNewLabel.setBounds(10, 161, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblCin = new JLabel("Cin");
		lblCin.setBounds(10, 130, 46, 14);
		contentPane.add(lblCin);

		JLabel lblBirth = new JLabel("Birth Date");
		lblBirth.setBounds(10, 311, 72, 14);
		contentPane.add(lblBirth);

		JLabel lblAdresse = new JLabel("Adress");
		lblAdresse.setBounds(10, 342, 224, 14);
		contentPane.add(lblAdresse);

		JComboBox civil = new JComboBox();
		civil.setModel(new DefaultComboBoxModel(new String[] {"Single", "Married", "Divorced"}));
		civil.setBounds(92, 158, 142, 20);
		contentPane.add(civil);

		JComboBox sex = new JComboBox();
		sex.setModel(new DefaultComboBoxModel(new String[] {"Female", "Male"}));
		sex.setBounds(92, 216, 142, 20);
		contentPane.add(sex);

		JLabel lblNewLabel_1 = new JLabel("Role");
		lblNewLabel_1.setBounds(10, 373, 46, 14);
		contentPane.add(lblNewLabel_1);

		JComboBox role = new JComboBox();
		role.setModel(new DefaultComboBoxModel(new String[] {"HR Manager", "Inventory Manager", "Financial Manager", "Cashier", "Client Agent"}));
		role.setBounds(92, 370, 142, 20);
		contentPane.add(role);

		password = new JPasswordField();
		password.setBounds(92, 42, 142, 20);
		contentPane.add(password);

		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\pein\\Desktop\\cv2.png"));


		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try {
				JFileChooser cv = new JFileChooser();
				cv.showOpenDialog(null);
			} catch (Exception e) {
e.getStackTrace();			}
			}
		});
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Employee employee = new Employee();

		//	employee.setCin(cin.getText().toString());
			employee.setAdress(adresse.getText().toString());
				employee.setBirthDate(birthDate.getText().toString());
				employee.setCivilState(civil.getSelectedItem().toString());
				employee.setEmail(mail.getText().toString());
			//	employee.setKidsNumber( kids.getText().toString());
				employee.setLastName(lastName.getText().toString());
				employee.setName(name.getText().toString());
			//	employee.setPhoneNumber( phone.getText().toString());
				employee.setSexe(sex.getSelectedItem().toString());
				employee.setPassWord(password.getText().toString());
				employee.setUserName(username.getText().toString());
				employee.setRole(role.getSelectedItem().toString());

		//	GestionEmployeeDelegator.ajouterEmploye(name.getText().toString(), lastName.getText().toString(), birthDate.getText().toString(), adresse.getText().toString(), mail.getText().toString(), role.getText().toString(),Integer.parseInt( phone.getText()), result, sex.getText().toString(), civil.getText().toString(), Integer.parseInt(kids.getText()), username.getText().toString(), password.getText().toString());;
			GestionEmployeeDelegator.ajouterEmploye(employee);
			}
		});
		btnNewButton.setBounds(358, 125, 120, 84);
		contentPane.add(btnNewButton);
	}
}
