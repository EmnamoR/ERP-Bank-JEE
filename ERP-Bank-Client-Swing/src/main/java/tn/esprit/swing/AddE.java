package tn.esprit.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JButton;

import tn.esprit.delegator.GestionEmployeeDelegator;
import tn.esprit.entites.Employee;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AddE extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField lastName;
	private JTextField pseudo;
	private JTextField pass;
	private JTextField cin;
	private JTextField birth;
	private JTextField kids;
	private JTextField mail;
	private JTextField phone;
	private JTextField adress;

AddContract addc = new AddContract();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddE frame = new AddE();
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
	public AddE() {
		setTitle("Add Employee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		name = new JTextField();
		name.setBounds(122, 37, 86, 20);
		contentPane.add(name);
		name.setColumns(10);

		lastName = new JTextField();
		lastName.setBounds(372, 37, 86, 20);
		contentPane.add(lastName);
		lastName.setColumns(10);

		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(23, 40, 46, 14);
		contentPane.add(lblName);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setBounds(287, 40, 75, 14);
		contentPane.add(lblLastName);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBounds(23, 77, 86, 14);
		contentPane.add(lblUsername);

		pseudo = new JTextField();
		pseudo.setBounds(122, 74, 86, 20);
		contentPane.add(pseudo);
		pseudo.setColumns(10);

		pass = new JTextField();
		pass.setBounds(372, 74, 86, 20);
		contentPane.add(pass);
		pass.setColumns(10);

		JLabel lblPasswor = new JLabel("Password");
		lblPasswor.setForeground(Color.WHITE);
		lblPasswor.setBounds(287, 77, 75, 14);
		contentPane.add(lblPasswor);

		JLabel lblBirthday = new JLabel("Cin");
		lblBirthday.setForeground(Color.WHITE);
		lblBirthday.setBounds(23, 117, 63, 14);
		contentPane.add(lblBirthday);

		cin = new JTextField();
		cin.setBounds(122, 114, 86, 20);
		contentPane.add(cin);
		cin.setColumns(10);

		JLabel lblCivilState = new JLabel("Birthday");
		lblCivilState.setForeground(Color.WHITE);
		lblCivilState.setBounds(287, 117, 75, 14);
		contentPane.add(lblCivilState);

		birth = new JTextField();
		birth.setBounds(372, 114, 86, 20);
		contentPane.add(birth);
		birth.setColumns(10);

		JLabel lblKidsNumber = new JLabel("Civil State");
		lblKidsNumber.setForeground(Color.WHITE);
		lblKidsNumber.setBounds(23, 159, 86, 14);
		contentPane.add(lblKidsNumber);

		JLabel lblKidsNumber_1 = new JLabel("Kids Number");
		lblKidsNumber_1.setForeground(Color.WHITE);
		lblKidsNumber_1.setBounds(287, 159, 86, 14);
		contentPane.add(lblKidsNumber_1);

		kids = new JTextField();
		kids.setBounds(372, 156, 86, 20);
		contentPane.add(kids);
		kids.setColumns(10);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(23, 198, 46, 14);
		contentPane.add(lblEmail);

		JLabel lblAdress = new JLabel("Adress");
		lblAdress.setForeground(Color.WHITE);
		lblAdress.setBounds(287, 198, 46, 14);
		contentPane.add(lblAdress);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setBounds(23, 236, 86, 14);
		contentPane.add(lblPhoneNumber);

		JLabel lblRole = new JLabel("Role");
		lblRole.setForeground(Color.WHITE);
		lblRole.setBounds(287, 236, 46, 14);
		contentPane.add(lblRole);

		mail = new JTextField();
		mail.setBounds(122, 195, 86, 20);
		contentPane.add(mail);
		mail.setColumns(10);

		phone = new JTextField();
		phone.setBounds(122, 233, 86, 20);
		contentPane.add(phone);
		phone.setColumns(10);

		adress = new JTextField();
		adress.setBounds(372, 195, 86, 20);
		contentPane.add(adress);
		adress.setColumns(10);

		JComboBox role = new JComboBox();
		role.setModel(new DefaultComboBoxModel(new String[] {"HR manager", "Inventory Manager", "Financial Manager", "Cashier", "Client Agent"}));
		role.setBounds(372, 233, 86, 20);
		contentPane.add(role);

		JComboBox civil = new JComboBox();
		civil.setModel(new DefaultComboBoxModel(new String[] {"Single", "Married", "Divorced"}));
		civil.setBounds(122, 156, 86, 20);
		contentPane.add(civil);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setOpaque(false);
		menuBar.setBounds(0, 0, 97, 21);
		contentPane.add(menuBar);

		JMenu mnAdmin = new JMenu("Admin");
		menuBar.add(mnAdmin);

		JCheckBoxMenuItem chckbxmntmDashboard = new JCheckBoxMenuItem("Dashboard");
		chckbxmntmDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				AddE.this.dispose();
				new manageHR().show();
			}
		});

		JCheckBoxMenuItem chckbxmntmManageEmployees = new JCheckBoxMenuItem("Manage employees");
		chckbxmntmManageEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddE.this.dispose();
				new ManageEmployees().show();
			}
		});
		mnAdmin.add(chckbxmntmManageEmployees);

		JCheckBoxMenuItem chckbxmntmManageTrainingSessions = new JCheckBoxMenuItem("Manage Training sessions");
		mnAdmin.add(chckbxmntmManageTrainingSessions);

		JCheckBoxMenuItem chckbxmntmManageCandidacies = new JCheckBoxMenuItem("Manage Candidacies");
		mnAdmin.add(chckbxmntmManageCandidacies);
		mnAdmin.add(chckbxmntmDashboard);

		JComboBox gender = new JComboBox();
		gender.setModel(new DefaultComboBoxModel(new String[] {"Female", "Male"}));
		gender.setBounds(122, 270, 86, 20);
		contentPane.add(gender);

		JButton btnAddEmployee = new JButton("");
		btnAddEmployee.setIcon(new ImageIcon(AddE.class.getResource("/images/base.png")));
		btnAddEmployee.setOpaque(false);
		btnAddEmployee.setContentAreaFilled(false);
		btnAddEmployee.setBorderPainted(false);
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee emp= new Employee();
				emp.setAdress(adress.getText().toString());
				emp.setBirthDate(birth.getText().toString());
				emp.setCin(Integer.parseInt( cin.getText()));
				emp.setCivilState(civil.getSelectedItem().toString());
				emp.setEmail(mail.getText().toString());
				emp.setKidsNumber(Integer.parseInt(kids.getText().toString()));
				emp.setLastName(lastName.getText().toString());
				emp.setName(name.getText().toString());
				emp.setPassWord(pass.getText().toString());
				emp.setPhoneNumber(Integer.parseInt(phone.getText()));
				emp.setRole(role.getSelectedItem().toString());
				emp.setSexe(gender.getSelectedItem().toString());
				emp.setUserName(pseudo.getText().toString());
				GestionEmployeeDelegator.ajouterEmploye(emp);
				JOptionPane.showMessageDialog(null, "employee addes !");

				AddE.this.dispose();
				addc.show();
			}
		});
		btnAddEmployee.setBounds(375, 333, 63, 57);
		contentPane.add(btnAddEmployee);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		lblGender.setBounds(23, 273, 46, 14);
		contentPane.add(lblGender);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddE.class.getResource("/images/back3.jpg")));
		label.setBounds(0, 0, 704, 439);
		contentPane.add(label);


	}
}
