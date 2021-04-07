package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;

import connection.sqliteConnection;

import java.awt.Component;
import javax.swing.Box;
import java.awt.TextArea;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Canvas;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
//BANCO DE DADOS
import java.sql.*;
import javax.swing.*;



public class InterfaceAdministrator extends JFrame {

	private JPanel contentPane;
	private JTable tableConnectios;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceAdministrator frame = new InterfaceAdministrator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		Connection conection = null;
	public InterfaceAdministrator() {
		conection = sqliteConnection.dbConnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1043, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tableConnectios = new JTable();
		tableConnectios.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tableConnectios.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableConnectios.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"IP", "Usu\u00E1rio"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableConnectios.getColumnModel().getColumn(0).setPreferredWidth(344);
		tableConnectios.getColumnModel().getColumn(1).setPreferredWidth(266);
		tableConnectios.setBounds(10, 73, 410, 261);
		contentPane.add(tableConnectios);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 345, 1027, 12);
		contentPane.add(separator);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(10, 383, 410, 160);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Mensagem");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 549, 72, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(75, 547, 345, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Chat");
		lblNewLabel_1.setBounds(10, 363, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Usu\u00E1rios conectados");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 53, 143, 14);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(430, 0, 11, 574);
		contentPane.add(separator_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(446, 383, 571, 180);
		contentPane.add(textPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("");
		tabbedPane.setBorder(new TitledBorder(null, "Cadastro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tabbedPane.setBounds(436, 11, 581, 323);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Usuário", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Hospital", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Server Log");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(451, 362, 72, 14);
		contentPane.add(lblNewLabel_3);
	}
}
