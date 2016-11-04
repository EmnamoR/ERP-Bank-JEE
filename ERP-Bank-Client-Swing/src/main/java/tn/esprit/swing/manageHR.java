package tn.esprit.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

public class manageHR extends JFrame {

	private JPanel contentPane;
	AddE a = new AddE();
	AddContract addc = new AddContract();
	ManageCandidacies clist = new ManageCandidacies();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manageHR frame = new manageHR();
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
	public manageHR() {
		setTitle("HR Interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AddE.class.getResource("/images/human.png")));
		label_1.setBounds(0, 0, 434, 261);
		contentPane.add(label_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 97, 21);
		contentPane.add(menuBar);
		
		JMenu mnAdmin = new JMenu("Admin");
		menuBar.add(mnAdmin);
		
		JMenu mnManageEmployees = new JMenu("Manage Employees");
		mnAdmin.add(mnManageEmployees);
		
		JCheckBoxMenuItem chckbxmntmAddEmployee = new JCheckBoxMenuItem("Add Employee");
		chckbxmntmAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manageHR.this.dispose();
				a.show();
			}
		});
		mnManageEmployees.add(chckbxmntmAddEmployee);
		
		JCheckBoxMenuItem chckbxmntmManageEmployees = new JCheckBoxMenuItem("Manage employees");
		chckbxmntmManageEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manageHR.this.dispose();
				new ManageEmployees().show();
			}
		});
		mnManageEmployees.add(chckbxmntmManageEmployees);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem = new JCheckBoxMenuItem("Manage Training sessions");
		mnAdmin.add(chckbxmntmNewCheckItem);
		
		JCheckBoxMenuItem chckbxmntmManageCandidacies = new JCheckBoxMenuItem("Manage Candidacies");
		chckbxmntmManageCandidacies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				manageHR.this.dispose();
				clist.show();
				
			}
		});
		mnAdmin.add(chckbxmntmManageCandidacies);
		
		JMenu mnManageEmployeesContracts = new JMenu("Manage Employees Contracts");
		mnAdmin.add(mnManageEmployeesContracts);
		
		JCheckBoxMenuItem chckbxmntmAddContract = new JCheckBoxMenuItem("Add Contract");
		chckbxmntmAddContract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				manageHR.this.dispose();
				addc.show();
			}
		});
		mnManageEmployeesContracts.add(chckbxmntmAddContract);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddE.class.getResource("/images/back3.jpg")));
		label.setBounds(0, 0, 434, 261);
		contentPane.add(label);
	}
}
