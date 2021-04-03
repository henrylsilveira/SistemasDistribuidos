package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONObject;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JPasswordField;


public class InterfaceClient extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceClient frame = new InterfaceClient();
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
	public InterfaceClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				try {
					JSONObject formLogin = new JSONObject();
			    	formLogin.put("nome", txtUsuario.getText());
			    	formLogin.put("senha", passwordField.getText());
			    	String formLoginString = formLogin.toString();

			    	
					Socket cliente = new Socket("localhost",8899);
				      ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
				      JOptionPane.showMessageDialog(null,"Dados recebidos:" + formLoginString);
				      entrada.close();
				      System.out.println("Conexão encerrada");
				    }
				    catch(Exception e) {
				      System.out.println("Erro: " + e.getMessage());
				    }
				
				
				/*try {
					String query = "SELECT * FROM user WHERE nome =? AND senha=? ";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(0, txtUsuario.getText());
					pst.setString(1, passwordField.getText());
					
					ResultSet rs = pst.executeQuery();
					while(rs.next()) {
						count=count+1;
					}
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, e);
				}*/
			}
		});
		btnEntrar.setBounds(10, 211, 170, 39);
		contentPane.add(btnEntrar);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(91, 76, 234, 25);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Usu\u00E1rio");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(91, 51, 83, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSenha.setBounds(91, 117, 83, 14);
		contentPane.add(lblSenha);
		
		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.setBounds(254, 211, 170, 39);
		contentPane.add(btnCadastro);
		
		JLabel lblNewLabel_1 = new JLabel("Painel de entrada");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(123, 0, 181, 39);
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(91, 139, 234, 25);
		contentPane.add(passwordField);
	}
}
