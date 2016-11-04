package tn.esprit.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import tn.esprit.delegator.GestionEmployeeDelegator;
import tn.esprit.entites.Employee;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;



import java.awt.Shape;
import java.io.FileOutputStream;



import javax.swing.JOptionPane;
/*

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;*/

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.ImageIcon;


public class ManageEmployees extends JFrame {

	private JPanel contentPane;
	List<Employee> employees;
	Employee emp;
	private JButton btnUpdate;
	private JButton btnPrint;
	private JTextField adress;
	private JTextField cin;
	private JTextField phone;
	private JTextField name;
	private JTextField lastname;
	private JTextField pseudo;
	private JTextField password;
	private JTextField kids;
	private JTextField civil;
	private JTextField birth;
	private JTextField mail;
	private JLabel lblMail;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnUp;
	private JTextField username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageEmployees frame = new ManageEmployees();
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
	public ManageEmployees() {
		employees= new ArrayList<Employee>();
		employees=GestionEmployeeDelegator.EmployeeList();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 510);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnDelete = new JButton("delete");
		JComboBox role = new JComboBox();
		role.setModel(new DefaultComboBoxModel(new String[] {"HR Manager", "Inventory Manager", "Financial Manager", "Cashier", "Client A gent"}));
		role.setBounds(445, 380, 86, 20);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				emp=employees.get(table.getSelectedRow());
				//emp=	GestionEmployeeDelegator.findEmployeeById(emp.getId());
				GestionEmployeeDelegator.supprimerEmploye(emp);
				employees.remove(emp);
				initDataBindings();
			}
		});

		btnUp = new JButton("update");
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				emp=employees.get(table.getSelectedRow());
				emp.setAdress(adress.getText().toString());
				emp.setBirthDate(birth.getText().toString());
				emp.setCin(Integer.parseInt(cin.getText()));
				emp.setCivilState(civil.getText().toString());
				emp.setEmail(mail.getText().toString());
				emp.setKidsNumber(Integer.parseInt(kids.getText()));
				emp.setLastName(lastname.getText().toString());
				emp.setName(name.getText().toString());
				emp.setPassWord(password.getText().toString());
				emp.setPhoneNumber(Integer.parseInt(phone.getText()));
				emp.setRole(role.getSelectedItem().toString());
				emp.setUserName(pseudo.getText().toString());
				GestionEmployeeDelegator.editemployee(emp);
				employees=GestionEmployeeDelegator.EmployeeList();
				initDataBindings();
			}
		});
		btnUp.setBounds(426, 81, 105, 23);
		contentPane.add(btnUp);
		btnDelete.setBounds(426, 47, 105, 23);
		contentPane.add(btnDelete);



		btnPrint = new JButton("print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			/*	 Document document = new Document(PageSize.A4.rotate());
				    try {
				      PdfWriter pdf_writer = PdfWriter.getInstance(document,
				      	new FileOutputStream("C:/Users/pein/Desktop/pi/employees.pdf"));

				      document.open();
				      PdfContentByte cb = pdf_writer.getDirectContent();

				      cb.saveState();
				      Graphics2D g2 = cb.createGraphicsShapes(500, 500);

				      Shape oldClip = g2.getClip();
				      g2.clipRect(0, 0, 500, 500);

				      table.print(g2);
				      g2.setClip(oldClip);

				      g2.dispose();
				      cb.restoreState();
				      JOptionPane.showMessageDialog(null, "liste des employees exprté vers PDF avec succès");
				    } catch (Exception e) {
				      System.err.println(e.getMessage());
				    }
				    document.close();*/

			}
		});
		btnPrint.setBounds(426, 112, 105, 23);
		contentPane.add(btnPrint);

		adress = new JTextField();
		adress.setBounds(41, 277, 86, 20);
		contentPane.add(adress);
		adress.setColumns(10);

		cin = new JTextField();
		cin.setBounds(41, 327, 86, 20);
		contentPane.add(cin);
		cin.setColumns(10);

		phone = new JTextField();
		phone.setBounds(41, 380, 86, 20);
		contentPane.add(phone);
		phone.setColumns(10);

		name = new JTextField();
		name.setBounds(41, 440, 86, 20);
		contentPane.add(name);
		name.setColumns(10);

		lastname = new JTextField();
		lastname.setBounds(254, 277, 86, 20);
		contentPane.add(lastname);
		lastname.setColumns(10);

		pseudo = new JTextField();
		pseudo.setBounds(254, 327, 86, 20);
		contentPane.add(pseudo);
		pseudo.setColumns(10);

		password = new JTextField();
		password.setBounds(254, 380, 86, 20);
		contentPane.add(password);
		password.setColumns(10);

		kids = new JTextField();
		kids.setBounds(445, 327, 86, 20);
		contentPane.add(kids);
		kids.setColumns(10);

		civil = new JTextField();
		civil.setBounds(445, 277, 86, 20);
		contentPane.add(civil);
		civil.setColumns(10);

		birth = new JTextField();
		birth.setBounds(254, 440, 86, 20);
		contentPane.add(birth);
		birth.setColumns(10);

		JLabel lblNewLabel = new JLabel("adress");
		lblNewLabel.setBounds(41, 261, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("cin");
		lblNewLabel_1.setBounds(41, 302, 46, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblPhone = new JLabel("phone");
		lblPhone.setBounds(41, 355, 46, 14);
		contentPane.add(lblPhone);

		JLabel lblName = new JLabel("name");
		lblName.setBounds(41, 415, 46, 14);
		contentPane.add(lblName);

		JLabel lblLastName = new JLabel("last name");
		lblLastName.setBounds(256, 261, 71, 14);
		contentPane.add(lblLastName);

		JLabel lblNewLabel_2 = new JLabel("pseudo");
		lblNewLabel_2.setBounds(254, 308, 46, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblPassword = new JLabel("password");
		lblPassword.setBounds(254, 358, 112, 14);
		contentPane.add(lblPassword);

		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setBounds(254, 415, 73, 14);
		contentPane.add(lblBirthday);

		JLabel lblCivilState = new JLabel("civil state");
		lblCivilState.setBounds(447, 261, 59, 14);
		contentPane.add(lblCivilState);

		JLabel lblKidsNumber = new JLabel("Kids number");
		lblKidsNumber.setBounds(445, 308, 86, 14);
		contentPane.add(lblKidsNumber);

		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(445, 358, 46, 14);
		contentPane.add(lblRole);


		contentPane.add(role);
		mail = new JTextField();
		mail.setBounds(445, 440, 86, 20);
		contentPane.add(mail);
		mail.setColumns(10);

		lblMail = new JLabel("Mail");
		lblMail.setBounds(445, 415, 46, 14);
		contentPane.add(lblMail);

		role.setVisible(false);
		civil.setVisible(false);
		birth.setVisible(false);
		adress.setVisible(false);
		kids.setVisible(false);
		phone.setVisible(false);
		name.setVisible(false);
		lastname.setVisible(false);
		pseudo.setVisible(false);
		password.setVisible(false);
		cin.setVisible(false);
		mail.setVisible(false);
		lblBirthday.setVisible(false);
		lblCivilState.setVisible(false);
		lblKidsNumber.setVisible(false);
		lblLastName.setVisible(false);
		lblName.setVisible(false);
		lblPassword.setVisible(false);
		lblPhone.setVisible(false);
		lblRole.setVisible(false);
		lblNewLabel_1.setVisible(false);
		lblNewLabel_2.setVisible(false);
		lblMail.setVisible(false);
		lblNewLabel.setVisible(false);

		btnUpdate = new JButton("");
		btnUpdate.setEnabled(false);
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				emp=employees.get(table.getSelectedRow());
				civil.setText(emp.getCivilState());
				birth.setText(emp.getBirthDate());
				adress.setText(emp.getAdress());
				kids.setText(""+emp.getKidsNumber());
				phone.setText(""+emp.getPhoneNumber());
				name.setText(emp.getName());
				lastname.setText(emp.getLastName());
				pseudo.setText(emp.getUserName());
				password.setText(emp.getPassWord());
				cin.setText(""+emp.getCin());
				mail.setText(emp.getEmail());

				role.setVisible(true);
				civil.setVisible(true);
				birth.setVisible(true);
				adress.setVisible(true);
				kids.setVisible(true);
				phone.setVisible(true);
				name.setVisible(true);
				lastname.setVisible(true);
				pseudo.setVisible(true);
				password.setVisible(true);
				cin.setVisible(true);
				mail.setVisible(true);
				lblBirthday.setVisible(true);
				lblCivilState.setVisible(true);
				lblKidsNumber.setVisible(true);
				lblLastName.setVisible(true);
				lblName.setVisible(true);
				lblPassword.setVisible(true);
				lblPhone.setVisible(true);
				lblRole.setVisible(true);
				lblNewLabel_1.setVisible(true);
				lblNewLabel_2.setVisible(true);
				lblMail.setVisible(true);
				lblNewLabel.setVisible(true);
			}
		});

		btnUpdate.setBounds(412, 67, 105, 23);
		contentPane.add(btnUpdate);
		btnUpdate.setOpaque(false);
		btnUpdate.setContentAreaFilled(false);
		btnUpdate.setBorderPainted(false);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 392, 207);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		username = new JTextField();
		username.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				employees=GestionEmployeeDelegator. emplyees(username.getText().toString());
				initDataBindings();
			}
		});
		username.setBounds(426, 146, 105, 20);
		contentPane.add(username);
		username.setColumns(10);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 97, 21);
		contentPane.add(menuBar);

		JMenu mnAdmin = new JMenu("Admin");
		menuBar.add(mnAdmin);

		JMenu mnManageEmployees = new JMenu("Manage employees");
		mnAdmin.add(mnManageEmployees);

		JCheckBoxMenuItem chckbxmntmAddEmployee = new JCheckBoxMenuItem("Add Employee");
		chckbxmntmAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageEmployees.this.dispose();
				new AddE().show();
			}
		});
		mnManageEmployees.add(chckbxmntmAddEmployee);

		JCheckBoxMenuItem chckbxmntmManageEmployees = new JCheckBoxMenuItem("Manage employees");
		mnManageEmployees.add(chckbxmntmManageEmployees);

		JMenu mnManageTrainingSessions = new JMenu("Manage training sessions");
		mnAdmin.add(mnManageTrainingSessions);

		JCheckBoxMenuItem chckbxmntmManageCandidacies = new JCheckBoxMenuItem("Manage Candidacies ");
		mnAdmin.add(chckbxmntmManageCandidacies);

		JCheckBoxMenuItem chckbxmntmManageEmployeesContracts = new JCheckBoxMenuItem("Manage employees contracts");
		mnAdmin.add(chckbxmntmManageEmployeesContracts);

		JCheckBoxMenuItem chckbxmntmDashboard = new JCheckBoxMenuItem("Dashboard");
		chckbxmntmDashboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageEmployees.this.dispose();
				new manageHR().show();
			}
		});
		mnAdmin.add(chckbxmntmDashboard);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ManageEmployees.class.getResource("/images/back3.jpg")));
		label.setBounds(0, 0, 545, 471);
		contentPane.add(label);

		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


							}
		});
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<Employee, List<Employee>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, employees, table);
		//
		BeanProperty<Employee, Integer> employeeBeanProperty = BeanProperty.create("cin");
		jTableBinding.addColumnBinding(employeeBeanProperty).setColumnName("cin");
		//
		BeanProperty<Employee, String> employeeBeanProperty_1 = BeanProperty.create("email");
		jTableBinding.addColumnBinding(employeeBeanProperty_1).setColumnName("mail");
		//
		BeanProperty<Employee, String> employeeBeanProperty_2 = BeanProperty.create("lastName");
		jTableBinding.addColumnBinding(employeeBeanProperty_2).setColumnName("L.name");
		//
		BeanProperty<Employee, String> employeeBeanProperty_3 = BeanProperty.create("name");
		jTableBinding.addColumnBinding(employeeBeanProperty_3).setColumnName("F.name");
		//
		BeanProperty<Employee, Integer> employeeBeanProperty_4 = BeanProperty.create("phoneNumber");
		jTableBinding.addColumnBinding(employeeBeanProperty_4).setColumnName("phone");
		//
		BeanProperty<Employee, String> employeeBeanProperty_5 = BeanProperty.create("role");
		jTableBinding.addColumnBinding(employeeBeanProperty_5).setColumnName("role");
		//
		BeanProperty<Employee, String> employeeBeanProperty_6 = BeanProperty.create("userName");
		jTableBinding.addColumnBinding(employeeBeanProperty_6).setColumnName("username");
		//
		jTableBinding.bind();
	}
}
