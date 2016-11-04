package tn.esprit.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.ScrollPane;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;

import tn.esprit.delegator.GestionCandidatureDelegator;
import tn.esprit.delegator.GestionMeetingDelegate;
import tn.esprit.entites.Candidature;
import tn.esprit.entites.Mail;
import tn.esprit.entites.Meeting;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.swing.ImageIcon;

public class ManageCandidacies extends JFrame {

	private JPanel contentPane;
	private JTable table;
	List<Candidature> canidas;
	Candidature candidat;
	private JTextField date;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageCandidacies frame = new ManageCandidacies();
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
	public ManageCandidacies() {
		canidas = new ArrayList<Candidature>();
		canidas= GestionCandidatureDelegator.candidates();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 813, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Candidacies", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(5, 5, 424, 245);
	panel.setLayout(null);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 25, 404, 210);
		
		
		table = new JTable();
		table.setBounds(0, 0, 1, 1);
		scrollPane.add(table);
		panel.add(scrollPane);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Fix Appointement", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(484, 11, 303, 274);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblAppointementDate = new JLabel("Appointement Date");
		lblAppointementDate.setBounds(28, 48, 93, 14);
		panel_1.add(lblAppointementDate);
		
		date = new JTextField();
		date.setBounds(158, 45, 135, 20);
		panel_1.add(date);
		date.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(31, 94, 90, 14);
		panel_1.add(lblDescription);
		
		JTextPane Description = new JTextPane();
		Description.setBounds(158, 101, 135, 108);
		panel_1.add(Description);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Meeting meeting= new Meeting();
				candidat= canidas.get(table.getSelectedRow());
			//	meeting.setId(3); 
				
				    meeting.setLastName(candidat.getLastName());
				    meeting.setName(candidat.getName());
				    meeting.setRole(candidat.getRole());
				    meeting.setState(candidat.getState());
				    GestionMeetingDelegate.addMeeting(meeting);
				//candidat= GestionCandidatureDelegator.findCandidatureById(candidat.getId());
				//System.out.println(candidat.getEmail());
				
				  Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

				    try {
						new Mail().sendSSLMessage(candidat.getEmail(), "Devsters: interview", Description.getText().toString(),
						        "devsters.erBi@gmail.com");
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				   
				   GestionCandidatureDelegator.removeCandidature(candidat);
				    canidas=GestionCandidatureDelegator.candidates();
				    JOptionPane.showMessageDialog(null, "mail successfuly sent !");
				   
				   
				    
			
				    initDataBindings();
				    ManageCandidacies.this.dispose();
				    new Meetings().show();
			}
		});
		btnSend.setBounds(204, 240, 89, 23);
		panel_1.add(btnSend);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ManageCandidacies.class.getResource("/images/back3.jpg")));
		label.setBounds(0, 0, 797, 296);
		contentPane.add(label);
	
		initDataBindings();
		
	}
	protected void initDataBindings() {
		JTableBinding<Candidature, List<Candidature>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ_WRITE, canidas, table);
		//
		BeanProperty<Candidature, Integer> candidatureBeanProperty = BeanProperty.create("id");
		jTableBinding.addColumnBinding(candidatureBeanProperty).setColumnName("id");
		//
		BeanProperty<Candidature, String> candidatureBeanProperty_1 = BeanProperty.create("name");
		jTableBinding.addColumnBinding(candidatureBeanProperty_1).setColumnName("Name");
		//
		BeanProperty<Candidature, String> candidatureBeanProperty_2 = BeanProperty.create("lastName");
		jTableBinding.addColumnBinding(candidatureBeanProperty_2).setColumnName("Last Name");
		//
		BeanProperty<Candidature, String> candidatureBeanProperty_3 = BeanProperty.create("state");
		jTableBinding.addColumnBinding(candidatureBeanProperty_3).setColumnName("State");
		//
		BeanProperty<Candidature, String> candidatureBeanProperty_4 = BeanProperty.create("role");
		jTableBinding.addColumnBinding(candidatureBeanProperty_4).setColumnName("Role");
		//
		BeanProperty<Candidature, String> candidatureBeanProperty_5 = BeanProperty.create("email");
		jTableBinding.addColumnBinding(candidatureBeanProperty_5).setColumnName("Email");
		//
		jTableBinding.bind();
	}
}
