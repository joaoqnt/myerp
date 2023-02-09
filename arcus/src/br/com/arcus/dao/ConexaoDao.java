package br.com.arcus.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.arcus.utils.Singleton;
public class ConexaoDao {
	PreparedStatement pstm;
	Connection conn;
	
	public Connection conexaoDb() throws SQLException {
		conn = null;
		try {			 
			String url = "jdbc:firebird:localhost/3050:C:/bancos/" + Singleton.getInstance().getCnpj() + ".gdb?encoding=NONE";
			conn = DriverManager.getConnection(url,"sysdba","masterkey");
			//conn.setAutoCommit(false);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Empresa desconhecida");
		} 			
		return conn;
	}
}
