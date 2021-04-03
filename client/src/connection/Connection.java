package connection;

import java.net.*;
import java.util.Date;
import javax.swing.JOptionPane;
import java.io.*;
import org.json.JSONException;
import org.json.JSONObject;

import views.InterfaceClient;

/*
public class Connection {
	public static void main(String[] args) throws IOException {
		Socket service = new Socket("localhost", 2021);
	}
}
*/

public class Connection {
	  public static void main(String[] args) {
	    try {
	    	
	      Socket cliente = new Socket("localhost",8899);
	      ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
	      Date data_atual = (Date)entrada.readObject();
	      JOptionPane.showMessageDialog(null,"Data recebida do servidor:" + data_atual.toString());
	      entrada.close();
	      System.out.println("Conexão encerrada");
	    }
	    catch(Exception e) {
	      System.out.println("Erro: " + e.getMessage());
	    }
	  }
	}