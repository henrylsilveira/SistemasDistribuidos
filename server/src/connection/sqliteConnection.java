package connection;

import java.sql.*;
import javax.swing.*;

public class sqliteConnection {
	Connection conect = null;
	public static Connection dbConnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conect = DriverManager.getConnection("jdbc:sqlite:javaProject.sqlite");
			JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
			return conect;
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e);
			return null;
		}	
	}
}
