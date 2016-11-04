package tn.esprit.swing;

import tn.esprit.delegator.GestionAccountDelegate;
import tn.esprit.delegator.GestionClientDelegate;
import tn.esprit.entites.Account;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GetAccount extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	List<Account> Accounts;
	Account accountToGet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GetAccount dialog = new GetAccount();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GetAccount() {

		Accounts = new ArrayList<Account>();
		Accounts = GestionAccountDelegate.findAllAccount();
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 60, 414, 190);
			contentPanel.add(scrollPane);
			{
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(e.getClickCount() == 2)
						{
							accountToGet=Accounts.get(table.getSelectedRow()) ;
					        setVisible(false);
						}
					}
				});
				scrollPane.setViewportView(table);
			}
		}
		{
			textField = new JTextField();
			textField.setBounds(10, 33, 86, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(106, 33, 86, 20);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		initDataBindings();

	}
	protected void initDataBindings() {
		JTableBinding<Account, List<Account>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, Accounts, table);
		//
		BeanProperty<Account, Integer> accountBeanProperty = BeanProperty.create("id");
		jTableBinding.addColumnBinding(accountBeanProperty).setColumnName("RIB");
		//
		BeanProperty<Account, String> accountBeanProperty_1 = BeanProperty.create("client.name");
		jTableBinding.addColumnBinding(accountBeanProperty_1).setColumnName("Name");
		//
		BeanProperty<Account, String> accountBeanProperty_2 = BeanProperty.create("client.lastName");
		jTableBinding.addColumnBinding(accountBeanProperty_2).setColumnName("Last name");
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
}
