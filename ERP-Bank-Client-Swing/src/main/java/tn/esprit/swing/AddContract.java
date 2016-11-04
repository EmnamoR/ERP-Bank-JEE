package tn.esprit.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;

import javax.swing.JTable;

import tn.esprit.delegator.GestionContractDelegator;
import tn.esprit.delegator.GestionEmployeeDelegator;
import tn.esprit.entites.Contract;
import tn.esprit.entites.Employee;
import antlr.collections.List;

import java.awt.Panel;
import java.util.ArrayList;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;

public class AddContract extends JFrame {

	private JPanel contentPane;
	private JTextField start;
	private JTextField end;
	private JTable table;
	java.util.List<Employee> employees;
	Employee emp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					AddContract frame = new AddContract();
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
	public AddContract() {

		employees = new ArrayList<Employee>();
		employees= GestionEmployeeDelegator.EmployeeList();
		setTitle("Add Contract");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 97, 21);
		menuBar.setOpaque(false);
		contentPane.add(menuBar);

		JMenu mnAdmin = new JMenu("Admin");
		menuBar.add(mnAdmin);

		JMenu mnManageEmployees = new JMenu("Manage Employees");
		mnAdmin.add(mnManageEmployees);
		mnAdmin.setOpaque(false);

		JCheckBoxMenuItem chckbxmntmAddEmployee = new JCheckBoxMenuItem("Add Employee");
		mnManageEmployees.add(chckbxmntmAddEmployee);
		chckbxmntmAddEmployee.setOpaque(false);

		JCheckBoxMenuItem chckbxmntmManageEmployees = new JCheckBoxMenuItem("Manage Employees");
		mnManageEmployees.add(chckbxmntmManageEmployees);
		chckbxmntmManageEmployees.setOpaque(false);
		JCheckBoxMenuItem chckbxmntmManageTrainingSessions = new JCheckBoxMenuItem("Manage training sessions");
		mnAdmin.add(chckbxmntmManageTrainingSessions);
		chckbxmntmManageTrainingSessions.setOpaque(false);

		JCheckBoxMenuItem chckbxmntmManageCandidacies = new JCheckBoxMenuItem("Manage Candidacies");
		mnAdmin.add(chckbxmntmManageCandidacies);
		chckbxmntmManageCandidacies.setOpaque(false);

		JCheckBoxMenuItem chckbxmntmManageEmployeesContracts = new JCheckBoxMenuItem("Dashboard");
		mnAdmin.add(chckbxmntmManageEmployeesContracts);
		chckbxmntmManageEmployeesContracts.setOpaque(false);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Contract", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(32, 39, 530, 202);
		panel.setOpaque(false);

		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setBounds(10, 39, 62, 14);
		panel.add(lblStartDate);

		start = new JTextField();
		start.setBounds(112, 36, 86, 20);
		panel.add(start);
		start.setColumns(10);

		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(10, 77, 74, 14);
		panel.add(lblEndDate);

		end = new JTextField();
		end.setBounds(112, 74, 86, 20);
		panel.add(end);
		end.setColumns(10);

		JLabel lblContractType = new JLabel("Contract Type");
		lblContractType.setBounds(10, 119, 93, 14);
		panel.add(lblContractType);

		JComboBox ctype = new JComboBox();
		ctype.setModel(new DefaultComboBoxModel(new String[] {"CDD", "CDI", "CTT"}));
		ctype.setBounds(112, 116, 86, 20);
		panel.add(ctype);

		JButton btnAddContract = new JButton("");
		btnAddContract.setIcon(new ImageIcon(AddE.class.getResource("/images/add.png")));
		btnAddContract.setOpaque(false);
		btnAddContract.setContentAreaFilled(false);
		btnAddContract.setBorderPainted(false);
	//	btnAddContract.setIcon(new ImageIcon(AddE.class.getResource("/images/add1.jpg")));
		btnAddContract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Contract contrat = new Contract();
				emp=employees.get(table.getSelectedRow());
				contrat.setContractType(ctype.getSelectedItem().toString());
				contrat.setEndDate(end.getText().toString());
				contrat.setStartDate(start.getText().toString());

					contrat.setEmployee(emp);
					//	emp=	GestionEmployeeDelegator.findEmployeeById(emp.getId());
				//System.out.println(emp.getId());
				GestionContractDelegator.addContract(contrat);
			//	JOptionPane.showMessageDialog(null, "New Contract added to "+emp.getUserName(),"adding Contract" , JOptionPane.OK_OPTION);

			}
		});
		btnAddContract.setBounds(112, 141, 68, 50);
		panel.add(btnAddContract);

		JPanel bloc1 = new JPanel();
		bloc1.setBorder(new TitledBorder(null, "Employees", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		bloc1.setBounds(32, 265, 530, 163);
		bloc1.setOpaque(false);
		contentPane.add(bloc1);
		bloc1.setLayout(null);

		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 21, 510, 132);

		table = new JTable();
		table.setBackground(new Color(175, 238, 238));
		table.setBounds(0, 0, 1, 1);
		table.setOpaque(false);
		table.setSelectionBackground(getBackground());;
		scrollPane.add(table);
		bloc1.add(scrollPane);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddE.class.getResource("/images/back3.jpg")));
		label.setBounds(0, 0, 704, 439);
		contentPane.add(label);
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<Employee, java.util.List<Employee>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, employees, table);
		//
		BeanProperty<Employee, String> employeeBeanProperty = BeanProperty.create("userName");
		jTableBinding.addColumnBinding(employeeBeanProperty).setColumnName("User Name");
		//
		BeanProperty<Employee, String> employeeBeanProperty_1 = BeanProperty.create("name");
		jTableBinding.addColumnBinding(employeeBeanProperty_1).setColumnName("Name");
		//
		BeanProperty<Employee, String> employeeBeanProperty_2 = BeanProperty.create("lastName");
		jTableBinding.addColumnBinding(employeeBeanProperty_2).setColumnName("Last Name");
		//
		BeanProperty<Employee, Integer> employeeBeanProperty_3 = BeanProperty.create("cin");
		jTableBinding.addColumnBinding(employeeBeanProperty_3).setColumnName("Cin");
		//
		BeanProperty<Employee, String> employeeBeanProperty_4 = BeanProperty.create("adress");
		jTableBinding.addColumnBinding(employeeBeanProperty_4).setColumnName("Adress");
		//
		BeanProperty<Employee, String> employeeBeanProperty_5 = BeanProperty.create("role");
		jTableBinding.addColumnBinding(employeeBeanProperty_5).setColumnName("Role");
		//
		BeanProperty<Employee, String> employeeBeanProperty_6 = BeanProperty.create("sexe");
		jTableBinding.addColumnBinding(employeeBeanProperty_6).setColumnName("Gender");
		//
		jTableBinding.bind();
	}
}
