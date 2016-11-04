package tn.esprit.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import tn.esprit.delegator.GestionMeetingDelegate;
import tn.esprit.entites.Mail;
import tn.esprit.entites.Meeting;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Meetings extends JFrame {

	private JPanel contentPane;
	List<Meeting>meetings;
	Meeting meeting;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel label;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Meetings frame = new Meetings();
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
	public Meetings() {
		meetings= new ArrayList<Meeting>();
		meetings=GestionMeetingDelegate.meetings();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCancelAppointment = new JButton("cancel appointment");
		btnCancelAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				meeting=meetings.get(table.getSelectedRow());
				
				 Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

				    try {
						new Mail().sendSSLMessage(meeting.getEmail(), "Devsters: Canceled interview", "Your meeting have been canceled.","devsters.erBi@gmail.com");
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    GestionMeetingDelegate.removeMeeting(meeting);
					 meetings=GestionMeetingDelegate.meetings();
					 initDataBindings();
				    JOptionPane.showMessageDialog(null, "an interview have bean canceled!");
				  
				   
			}
		});
		btnCancelAppointment.setBounds(293, 317, 156, 23);
		contentPane.add(btnCancelAppointment);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(149, 85, 414, 184);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(Meetings.class.getResource("/images/back3.jpg")));
		label.setBounds(0, 0, 694, 422);
		contentPane.add(label);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Meeting, List<Meeting>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, meetings, table);
		//
		BeanProperty<Meeting, String> meetingBeanProperty = BeanProperty.create("name");
		jTableBinding.addColumnBinding(meetingBeanProperty).setColumnName("name");
		//
		BeanProperty<Meeting, String> meetingBeanProperty_1 = BeanProperty.create("lastName");
		jTableBinding.addColumnBinding(meetingBeanProperty_1).setColumnName("last name");
		//
		BeanProperty<Meeting, String> meetingBeanProperty_2 = BeanProperty.create("email");
		jTableBinding.addColumnBinding(meetingBeanProperty_2).setColumnName("mail");
		//
		BeanProperty<Meeting, String> meetingBeanProperty_3 = BeanProperty.create("state");
		jTableBinding.addColumnBinding(meetingBeanProperty_3).setColumnName("state");
		//
		BeanProperty<Meeting, String> meetingBeanProperty_4 = BeanProperty.create("role");
		jTableBinding.addColumnBinding(meetingBeanProperty_4).setColumnName("role");
		//
		jTableBinding.bind();
	}
}
