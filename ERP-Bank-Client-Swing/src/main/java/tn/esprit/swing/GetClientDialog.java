package tn.esprit.swing;
import tn.esprit.delegator.GestionClientDelegate;
import tn.esprit.entites.Client;
import java.util.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.faces.lifecycle.ClientWindowWrapper;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GetClientDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField textField_search;
	private List<Client> Clients ;
	public Client clientToGet;
	private JTextField textField_name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GetClientDialog dialog = new GetClientDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GetClientDialog() {

		clientToGet = new Client();
		Clients = new ArrayList<Client>();
		Clients = GestionClientDelegate.listerClient();

		setBounds(100, 100, 540, 406);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 59, 504, 297);
		contentPanel.add(scrollPane);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
if(e.getClickCount() == 2)
{
		clientToGet=GestionClientDelegate.findClientByID(Clients.get(table.getSelectedRow()).getId())  ;
        setVisible(false);
}
			}
		});
		scrollPane.setViewportView(table);

		textField_search = new JTextField();
		textField_search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				Clients.clear();
				Clients.add(GestionClientDelegate.findClientByID(Integer.parseInt(textField_search.getText())));

		 		initDataBindings();
			}
		});
		textField_search.setBounds(10, 23, 102, 20);
		contentPanel.add(textField_search);
		textField_search.setColumns(10);

		textField_name = new JTextField();
		textField_name.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Clients =  GestionClientDelegate.findClientByName(textField_name.getText());
				initDataBindings();
			}
		});
		textField_name.setBounds(122, 23, 118, 20);
		contentPanel.add(textField_name);
		textField_name.setColumns(10);

		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField_name.setText(null);
				textField_search.setText(null);
				Clients = GestionClientDelegate.listerClient();
				initDataBindings();

			}
		});
		btnRefresh.setBounds(277, 22, 89, 23);
		contentPanel.add(btnRefresh);
		initDataBindings();
	}
	protected void initDataBindings() {
		JTableBinding<Client, List<Client>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, Clients, table);
		//
		BeanProperty<Client, Integer> clientBeanProperty = BeanProperty.create("id");
		jTableBinding.addColumnBinding(clientBeanProperty).setColumnName("Code");
		//
		BeanProperty<Client, String> clientBeanProperty_1 = BeanProperty.create("name");
		jTableBinding.addColumnBinding(clientBeanProperty_1).setColumnName("Name");
		//
		BeanProperty<Client, String> clientBeanProperty_2 = BeanProperty.create("lastName");
		jTableBinding.addColumnBinding(clientBeanProperty_2).setColumnName("Last name");
		//
		BeanProperty<Client, String> clientBeanProperty_3 = BeanProperty.create("phoneNumber");
		jTableBinding.addColumnBinding(clientBeanProperty_3).setColumnName("Phone");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}
