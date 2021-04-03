package connection;

import java.net.*;
import java.util.*;
import java.io.*;


public class Server {
	  public static void main(String[] args) {
	    try {
	      ServerSocket servidor = new ServerSocket(8899);
	      System.out.println("Servidor aguardando dados...");
	      while(true) {
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