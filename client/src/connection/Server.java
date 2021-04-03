package connection;

import java.net.*;
import java.util.*;
import java.io.*;

/*
public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket serviceServer = new ServerSocket(2021);
		Socket service = serviceServer.accept();
		
		System.out.println("Cliente conectado!");
	}
}
*/

public class Server {
	  public static void main(String[] args) {
	    try {
	      // Instancia o ServerSocket ouvindo a porta 12345
	      ServerSocket servidor = new ServerSocket(12345);
	      System.out.println("Servidor ouvindo a porta 12345");
	      while(true) {
	        // o método accept() bloqueia a execução até que
	        // o servidor receba um pedido de conexão
	        Socket cliente = servidor.accept();
	        System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
	        ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
	        saida.flush();
	        saida.writeObject(new Date());
	        saida.close();
	        cliente.close();
	      }
	    }
	    catch(Exception e) {
	       System.out.println("Erro: " + e.getMessage());
	    }
	  }
	}