package br.com.arcus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.arcus.model.Cliente;
import br.com.arcus.model.Usuario;
import br.com.arcus.utils.Dao;
import br.com.arcus.utils.Singleton;

public class UsuarioDao implements Dao {

	public void insert(Object arg0) {
		Usuario u = (Usuario) arg0;
		try {
			Connection conn = new ConexaoDao().conexaoDb();
			String sql = 
					"insert into usuario ( "
						+ "login,"
						+ "nome,"
						+ "senha,"
						+ "cpf,"
						+ "empresa) "
					+ "values ( "
						+ "(select gen_id(gen_idusuario,1) from rdb$database),"
						+ "?,"
						+ "?,"
						+ "?,"
						+ "(select id from empresa where cnpj = ?))";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, u.getNome_usuario());
			pstm.setString(2, u.getSenha_usuario());
			pstm.setString(3,u.getCpf_usuario());
			pstm.execute();
			pstm.close();
			conn.close();
			JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "Erro", 0, null);
		}
		
	}

	public void update(Object arg0) {
		Usuario u = (Usuario) arg0;
		try {
			Connection conn = new ConexaoDao().conexaoDb();
			String sql = 
					 "UPDATE USUARIO"
						+ "SET NOME = ?, "
						+ "PERFIL = ?, "
						+ "SENHA = ?, "
						+ "VERSAO = NULL, "
						+ "VERSAO_USUARIO = NULL, "
						+ "SINCRONIZANDO = 'N', "
						+ "PESQUISA = 'N', "
						+ "MSG_MLSMART = 'N',"
						+ "EXCLUI_PED_ENV = NULL,"
						+ "LIMPA_PED_ENV = NULL,"
						+ "IMEI_1 = NULL,"
						+ "IMEI_2 = NULL,"
						+ "IMEI_3 = NULL,"
						+ "DATA_CONEXAO = NULL,"
						+ "CPF = ?,"
						+ "REGRA_NEGOCIO = NULL,"
						+ "HOST = NULL,"
						+ "CAIXINHA = NULL,"
						+ "SERIAL = NULL,"
						+ "SERIAL_SUPERVISOR = NULL,"
						+ "QTD_SERIAL = NULL,"
						+ "DATA_CARGA = NULL,"
						+ "VALIDADE_CARGA = NULL,"
						+ "EMPRESA = 1,"
						+ "TELEFONE = NULL,"
						+ "FATURADO = NULL,"
						+ "META = NULL,"
						+ "DTCAIXINHA = NULL "
					+ "WHERE (LOGIN = ?)";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, u.getNome_usuario());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public void delete(Object arg0) {
		
		
	}

	public Object select(Object arg0) {
		Usuario u = (Usuario) arg0;
		Cliente c = new Cliente();
		try {
			Connection conn = new ConexaoDao().conexaoDb();
			Singleton.getInstance().setConn(conn);
			String sql = 
					"select "
						+ "u.login as login,"
						+ "u.nome as nome,"
						+ "u.senha as senha,"
						+ "u.cpf as cpf,"
						+ "u.empresa as empresa "
					+ "from usuario u "
						+ "inner join empresa e on(e.id = u.empresa and e.cnpj = u.cnpj) "
					+ "where u.cpf = ? "
						+ "and u.senha = ? "
						+ "and e.cnpj = ?";
			if(!conn.equals(null)) {
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1, u.getCpf_usuario());
				pstm.setString(2, u.getSenha_usuario());
				pstm.setString(3,u.getCnpjEmp_usuario());
				ResultSet rs = pstm.executeQuery(); 
				if(rs.next()) {
					u.setId_usuario(rs.getInt("login"));
					c.setUsuario_cliente(rs.getInt("login"));
					u.setNome_usuario(rs.getString("nome"));
					u.setSenha_usuario(rs.getString("senha"));
					u.setCpf_usuario(rs.getString("cpf"));
					u.setEmpresa_usuario(rs.getInt("empresa"));
					
				}else {
					u.setId_usuario(0);
					pstm.close();
					conn.close();
					rs.close();
				}
				
			}
			else{
				
			}
		} catch (Exception e) {
			//JOptionPane.showMessageDialog(null, e, "Erro", 0, null);
		}
		return u;
	}

	@Override
	public List<?> select() {
		// TODO Auto-generated method stub
		return null;
	}

}
