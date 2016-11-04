package tn.esprit.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HumanRessourceManagement extends JFrame {
	

	private JPanel contentPane;
	ManageEmployees manageE= new ManageEmployees();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HumanRessourceManagement frame = new HumanRessourceManagement();
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
	public HumanRessourceManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnManageTrainingSessions = new JButton("manage training sessions");
		btnManageTrainingSessions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
				//manageE.show();
			}
		});
		contentPane.add(btnManageTrainingSessions, BorderLayout.WEST);
		
		JButton btnManageEmployees = new JButton("manage employees");
		btnManageEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	System.exit(0);
			//	this.
				HumanRessourceManagement.this.dispose();
				manageE.show();
				
			}
		});
		contentPane.add(btnManageEmployees, BorderLayout.CENTER);
		
		JButton btnManageCandidacies = new JButton("manage candidacies");
		contentPane.add(btnManageCandidacies, BorderLayout.EAST);
	}

}
