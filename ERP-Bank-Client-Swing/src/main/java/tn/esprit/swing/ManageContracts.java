package tn.esprit.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import tn.esprit.delegator.GestionContractDelegator;
import tn.esprit.delegator.GestionEmployeeDelegator;
import tn.esprit.entites.Contract;
import tn.esprit.entites.Employee;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Color;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ManageContracts extends JFrame {

	private JPanel contentPane;
	List<Contract> contracts;
	Contract contrat;
	private JTable table;
	private JTextField username;
	private JTextField name;
	private JTextField lastname;
	private JTextField cin;
	private JTextField roles;
	private JTextField startDate;
	private JTextField endDate;
	private JTextField type;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageContracts frame = new ManageContracts();
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
	public ManageContracts() {
		contracts=new ArrayList<Contract>();
		contracts=GestionContractDelegator.contrats();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 883, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDeleteContract = new JButton("Delete contract");
		btnDeleteContract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contrat= contracts.get(table.getSelectedRow());
				GestionContractDelegator.removeContract(contrat);
			}
		});
		btnDeleteContract.setBounds(603, 305, 122, 23);
		contentPane.add(btnDeleteContract);
		
		JButton btnNewButton = new JButton("print contract");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(728, 305, 111, 23);
		contentPane.add(btnNewButton);
		
		JButton btnUpdateContract = new JButton("update contract");
		btnUpdateContract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contrat=contracts.get(table.getSelectedRow());
				contrat.setContractType(type.getText().toString());
				contrat.setEndDate(endDate.getText().toString());
				contrat.setStartDate(startDate.getText().toString());
				GestionContractDelegator.updateContract(contrat);
			
				contracts =GestionContractDelegator.contrats();
				initDataBindings();
			}
		});
		btnUpdateContract.setBounds(477, 305, 114, 23);
		contentPane.add(btnUpdateContract);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 431, 292);
		contentPane.add(scrollPane);
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(458, 26, 101, 14);
		contentPane.add(lblUsername);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(460, 70, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(460, 115, 84, 14);
		contentPane.add(lblLastName);
		
		JLabel lblCin = new JLabel("Cin");
		lblCin.setBounds(460, 157, 46, 14);
		contentPane.add(lblCin);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(460, 196, 46, 14);
		contentPane.add(lblRole);
		
		username = new JTextField();
		username.setEditable(false);
		username.setBounds(569, 23, 86, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		name = new JTextField();
		name.setEditable(false);
		name.setBounds(569, 64, 86, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		lastname = new JTextField();
		lastname.setEditable(false);
		lastname.setBounds(569, 112, 86, 20);
		contentPane.add(lastname);
		lastname.setColumns(10);
		
		cin = new JTextField();
		cin.setEditable(false);
		cin.setBounds(569, 154, 86, 20);
		contentPane.add(cin);
		cin.setColumns(10);
		
		roles = new JTextField();
		roles.setEditable(false);
		roles.setBounds(569, 193, 86, 20);
		contentPane.add(roles);
		roles.setColumns(10);
		
		
		lastname.setVisible(false);
		name.setVisible(false);
		cin.setVisible(false);
		roles.setVisible(false);
		username.setVisible(false);
		lblCin.setVisible(false);
		lblLastName.setVisible(false);
		lblName.setVisible(false);
		lblRole.setVisible(false);
		lblUsername.setVisible(false);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
		            int rowcheck = table.getSelectedRow();
		            if (rowcheck > -1) {
		           //   System.out.println("ok");
		            	contrat=contracts.get(table.getSelectedRow());
		            	contrat.getEmployee();
		            	username.setText(contrat.getEmployee().getUserName());
		            	name.setText(contrat.getEmployee().getName());
		            	lastname.setText(contrat.getEmployee().getLastName());
		            	cin.setText(""+contrat.getEmployee().getCin());
		            	roles.setText(contrat.getEmployee().getRole());
		            	
		            	lastname.setVisible(true);
		        		name.setVisible(true);
		        		cin.setVisible(true);
		        		roles.setVisible(true);
		        		username.setVisible(true);
		        		lblCin.setVisible(true);
		        		lblLastName.setVisible(true);
		        		lblName.setVisible(true);
		        		lblRole.setVisible(true);
		        		lblUsername.setVisible(true);
		            }
		        } catch (NullPointerException ex) {
		        }
			}
		});
		startDate = new JTextField();
		startDate.setBounds(771, 23, 86, 20);
		contentPane.add(startDate);
		startDate.setColumns(10);
		
		endDate = new JTextField();
		endDate.setBounds(771, 67, 86, 20);
		contentPane.add(endDate);
		endDate.setColumns(10);
		
		type = new JTextField();
		type.setBounds(771, 112, 86, 20);
		contentPane.add(type);
		type.setColumns(10);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setBounds(687, 26, 74, 14);
		contentPane.add(lblStartDate);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(687, 70, 74, 14);
		contentPane.add(lblEndDate);
		
		JLabel lblContractType = new JLabel("Contract Type");
		lblContractType.setBounds(687, 115, 74, 14);
		contentPane.add(lblContractType);
		

		scrollPane.setViewportView(table);
		startDate.setVisible(false);
		endDate.setVisible(false);
		type.setVisible(false);
		lblEndDate.setVisible(false);
		lblStartDate.setVisible(false);
		lblContractType.setVisible(false);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				contrat= contracts.get(table.getSelectedRow());
				startDate.setText(contrat.getStartDate());
				endDate.setText(contrat.getEndDate());
				type.setText(contrat.getContractType());
				startDate.setVisible(true);
				endDate.setVisible(true);
				type.setVisible(true);
				lblEndDate.setVisible(true);
				lblStartDate.setVisible(true);
				lblContractType.setVisible(true);
				
		
			}
		});

		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
	
		btnNewButton_1.setBounds(451, 292, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ManageContracts.class.getResource("/images/back3.jpg")));
		label.setBounds(0, 0, 867, 421);
		contentPane.add(label);
		
	
		
	
		initDataBindings();

		
			
	}
	protected void initDataBindings() {
		JTableBinding<Contract, List<Contract>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, contracts, table);
		//
		BeanProperty<Contract, String> contractBeanProperty = BeanProperty.create("startDate");
		jTableBinding.addColumnBinding(contractBeanProperty).setColumnName("start date");
		//
		BeanProperty<Contract, String> contractBeanProperty_1 = BeanProperty.create("endDate");
		jTableBinding.addColumnBinding(contractBeanProperty_1).setColumnName("end date");
		//
		BeanProperty<Contract, String> contractBeanProperty_2 = BeanProperty.create("contractType");
		jTableBinding.addColumnBinding(contractBeanProperty_2).setColumnName("type");
		//
		jTableBinding.bind();
	}
}
