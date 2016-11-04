package tn.esprit.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Imail extends JFrame {

	private JPanel contentPane;
	private JTextField subject;
	private JTextField text;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Imail frame = new Imail();
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
	public Imail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		subject = new JTextField();
		subject.setBounds(37, 36, 277, 29);
		contentPane.add(subject);
		subject.setColumns(10);
		
		text = new JTextField();
		text.setBounds(37, 95, 532, 178);
		contentPane.add(text);
		text.setColumns(10);
		
		JLabel lblObject = new JLabel("Subject");
		lblObject.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblObject.setBounds(37, 11, 57, 14);
		contentPane.add(lblObject);
		
		JLabel lblText = new JLabel("Text");
		lblText.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblText.setBounds(35, 70, 46, 14);
		contentPane.add(lblText);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*candidat= canidas.get(table.getSelectedRow());
				candidat= GestionCandidatureDelegator.findCandidatureById(candidat.getId());
				 
				  Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

				    try {
						new Mail().sendSSLMessage(candidat.getEmail(), "Devsters: interview", Description.getText().toString(),
						        "devsters.erBi@gmail.com");
					} catch (MessagingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    System.out.println("Sucessfully Sent mail to All Users");*/
			}
		});
		btnSend.setBounds(359, 323, 89, 23);
		contentPane.add(btnSend);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageSupplier frame = new ManageSupplier();
				frame.setVisible(true);
			}
		});
		btnBack.setBounds(468, 323, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Imail.class.getResource("/images/back3.jpg")));
		lblNewLabel.setBounds(0, 0, 704, 450);
		contentPane.add(lblNewLabel);
	}

}
