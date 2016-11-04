package tn.esprit.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import tn.esprit.delegator.GestionMaterialDelegate;
import tn.esprit.entites.Material;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.ObjectProperty;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class listMaterial extends JFrame {

	private JPanel contentPane;
	private JTable table;
	List< Material>materials;
	private JTextField des;
	private JTextField qte;
	private JTextField id;
	private JLabel lblMaterial;
	private JLabel lblId;
	private JLabel lblDesignation;
	private JLabel lblQuantity;
	private JButton btnUpdate;
	private JButton btnUpdate_1;
	Material m=new Material();
	private JTextField search;
	private JLabel lblSearchByName;
	private JLabel label;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listMaterial frame = new listMaterial();
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
	public listMaterial() {
		
		materials=new ArrayList<Material>();
		materials=GestionMaterialDelegate.doFindAllMaterial();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton button = new JButton("Back");
		button.setBounds(539, 357, 89, 23);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ManageMaterial frame = new ManageMaterial();
				frame.setVisible(true);
			}
		});
		contentPane.setLayout(null);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 52, 391, 280);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2)
				{
					Material m =new Material();
					id.setText(String.valueOf(materials.get(table.getSelectedRow()).getIdMat()));
					des.setText(materials.get(table.getSelectedRow()).getDesignation());
					qte.setText(String.valueOf(materials.get(table.getSelectedRow()).getQuantite()));
					
				}
			}
		});
		scrollPane.setViewportView(table);
		
		des = new JTextField();
		des.setBounds(522, 170, 150, 20);
		contentPane.add(des);
		des.setColumns(10);
		
		qte = new JTextField();
		qte.setBounds(522, 236, 150, 20);
		contentPane.add(qte);
		qte.setColumns(10);
		
		id = new JTextField();
		id.setBounds(522, 98, 150, 20);
		contentPane.add(id);
		id.setColumns(10);
		
		lblMaterial = new JLabel("Material");
		lblMaterial.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
		lblMaterial.setBounds(411, 26, 150, 29);
		contentPane.add(lblMaterial);
		
		lblId = new JLabel("Id:");
		lblId.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblId.setBounds(411, 101, 46, 14);
		contentPane.add(lblId);
		
		lblDesignation = new JLabel("Designation:");
		lblDesignation.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblDesignation.setBounds(411, 173, 86, 17);
		contentPane.add(lblDesignation);
		
		lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblQuantity.setBounds(411, 239, 76, 14);
		contentPane.add(lblQuantity);
		
		btnUpdate = new JButton("Remove");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m=materials.get(table.getSelectedRow());
				GestionMaterialDelegate.doDeleteMaterial(m);
				materials=GestionMaterialDelegate.doFindAllMaterial();
				initDataBindings();
			}
		});
		btnUpdate.setBounds(353, 357, 89, 23);
		contentPane.add(btnUpdate);
		
		btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				m=materials.get(table.getSelectedRow());
				m.setDesignation(des.getText().toString());
				m.setQuantite(Integer.parseInt(qte.getText().toString()));
				GestionMaterialDelegate.doUpdateMaterial(m);
				materials=GestionMaterialDelegate.doFindAllMaterial();
				initDataBindings();

			}
		});
		btnUpdate_1.setBounds(243, 357, 89, 23);
		contentPane.add(btnUpdate_1);
		
		search = new JTextField();
		search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				materials=GestionMaterialDelegate.doFindMaterialbyDesignation(search.getText().toString());
				initDataBindings();
				
			}
		});
		search.setBounds(68, 21, 127, 20);
		contentPane.add(search);
		search.setColumns(10);
		
		lblSearchByName = new JLabel("Search :");
		lblSearchByName.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblSearchByName.setBounds(10, 26, 119, 14);
		contentPane.add(lblSearchByName);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(listMaterial.class.getResource("/images/back3.jpg")));
		label.setBounds(0, 0, 704, 439);
		contentPane.add(label);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Material, List<Material>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, materials, table);
		//
		BeanProperty<Material, String> materialBeanProperty = BeanProperty.create("designation");
		jTableBinding.addColumnBinding(materialBeanProperty).setColumnName("designation").setEditable(false);
		//
		BeanProperty<Material, Integer> materialBeanProperty_1 = BeanProperty.create("idMat");
		jTableBinding.addColumnBinding(materialBeanProperty_1).setColumnName("id").setEditable(false);
		//
		BeanProperty<Material, Integer> materialBeanProperty_2 = BeanProperty.create("quantite");
		jTableBinding.addColumnBinding(materialBeanProperty_2).setColumnName("quantity").setEditable(false);
		//
		jTableBinding.bind();
	}
}
