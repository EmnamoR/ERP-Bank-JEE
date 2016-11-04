package tn.esprit.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTabbedPane;

import tn.esprit.delegator.GestionMaterialDelegate;
import tn.esprit.delegator.GestionSupplierDelegate;


import tn.esprit.entites.Material;
import tn.esprit.entites.Supplier;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.ObjectProperty;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class listSupplier extends JFrame {

	private JPanel contentPane;
	private JTextField search;
	private JTextField id;
	private JTextField name;
	private JTextField adress;
	private JTextField email;
	private JTable table;
	List<Supplier>suppliers;
	Supplier supp=new Supplier();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listSupplier frame = new listSupplier();
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
	public listSupplier() {
		
		suppliers=new ArrayList<Supplier>();
		suppliers=GestionSupplierDelegate.doFindAllSupplier();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Search :");
		label.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label.setBounds(10, 32, 119, 14);
		contentPane.add(label);
		
		search = new JTextField();
		search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				suppliers=GestionSupplierDelegate.doFindSupplierbyName(search.getText().toString());
				initDataBindings();
			}
		});
		search.setColumns(10);
		search.setBounds(85, 30, 127, 20);
		contentPane.add(search);
		
		JLabel lblSupplier = new JLabel("Supplier");
		lblSupplier.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblSupplier.setBounds(400, 33, 150, 29);
		contentPane.add(lblSupplier);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(511, 73, 150, 20);
		contentPane.add(id);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(511, 124, 150, 20);
		contentPane.add(name);
		
		adress = new JTextField();
		adress.setColumns(10);
		adress.setBounds(511, 182, 150, 20);
		contentPane.add(adress);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(511, 234, 150, 20);
		contentPane.add(email);
		
		JLabel label_1 = new JLabel("Id:");
		label_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		label_1.setBounds(410, 76, 46, 14);
		contentPane.add(label_1);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblName.setBounds(410, 127, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblAdress = new JLabel("Adress:");
		lblAdress.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblAdress.setBounds(410, 185, 91, 14);
		contentPane.add(lblAdress);
		
		JLabel id_1 = new JLabel("E-mail:");
		id_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		id_1.setBounds(410, 237, 64, 14);
		contentPane.add(id_1);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supp=suppliers.get(table.getSelectedRow());
				supp.setId_supp(Integer.parseInt(id.getText().toString()));
				supp.setName(name.getText().toString());
				supp.setAdress(adress.getText().toString());
				supp.setEmail(email.getText().toString());
				GestionSupplierDelegate.doUpdateSupplier(supp);
				suppliers=GestionSupplierDelegate.doFindAllSupplier();
				initDataBindings();
			}
		});
		update.setBounds(281, 357, 89, 23);
		contentPane.add(update);
		
		JButton remove = new JButton("Remove");
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supp=suppliers.get(table.getSelectedRow());
				GestionSupplierDelegate.doDeleteSupplier(supp);
				suppliers=GestionSupplierDelegate.doFindAllSupplier();
				initDataBindings();
			}
		});
		remove.setBounds(412, 357, 89, 23);
		contentPane.add(remove);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageSupplier frame = new ManageSupplier();
				frame.setVisible(true);
			}
		});
		btnBack.setBounds(547, 357, 89, 23);
		contentPane.add(btnBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 60, 370, 275);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2)
				{
					Material m =new Material();
					id.setText(String.valueOf(suppliers.get(table.getSelectedRow()).getId_supp()));
					name.setText(suppliers.get(table.getSelectedRow()).getName());
					adress.setText(suppliers.get(table.getSelectedRow()).getAdress());
					email.setText(suppliers.get(table.getSelectedRow()).getEmail());
					
				}
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(listSupplier.class.getResource("/images/back3.jpg")));
		label_2.setBounds(0, 0, 704, 391);
		contentPane.add(label_2);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Supplier, List<Supplier>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, suppliers, table);
		//
		BeanProperty<Supplier, Integer> supplierBeanProperty = BeanProperty.create("id_supp");
		jTableBinding.addColumnBinding(supplierBeanProperty).setColumnName("id").setEditable(false);
		//
		BeanProperty<Supplier, String> supplierBeanProperty_1 = BeanProperty.create("name");
		jTableBinding.addColumnBinding(supplierBeanProperty_1).setColumnName("name").setEditable(false);
		//
		BeanProperty<Supplier, String> supplierBeanProperty_2 = BeanProperty.create("adress");
		jTableBinding.addColumnBinding(supplierBeanProperty_2).setColumnName("adress").setEditable(false);
		//
		BeanProperty<Supplier, String> supplierBeanProperty_3 = BeanProperty.create("email");
		jTableBinding.addColumnBinding(supplierBeanProperty_3).setColumnName("email").setEditable(false);
		//
		jTableBinding.bind();
	}
}
