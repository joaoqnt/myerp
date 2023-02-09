package br.com.arcus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.arcus.model.Cliente;
import br.com.arcus.model.Usuario;
import br.com.arcus.utils.Dao;
import br.com.arcus.utils.Singleton;

public class ClienteDao implements Dao{
	public void insert(Object arg0) {
		Cliente c = (Cliente) arg0;
		try {
			Usuario u = Singleton.getInstance().getUser();
			Connection conn = new ConexaoDao().conexaoDb();
			String sql = 
					"insert into cliente ("
						+ "id,"
						+ "nome,"
						+ "data_cadastro,"
						+ "pessoa_fisica,"
						+ "cpf_cnpj,"
						+ "email,"
						+ "celular,"
						+ "INSC_ESTADUAL,"
						+ "usuario,"
						+ "cep,"
						+ "estado,"
						+ "nome_cidade,"
						+ "bairro,"
						+ "logradouro,"
						+ "numero)"
					+ "values("
						+ "(select gen_id(GEN_CLIENTE_ID,1) from rdb$database),"
						+ "?,"
						+ "current_timestamp,"
						+ "trim(?),"
						+ "trim(?),"
						+ "trim(?),"
						+ "trim(?),"
						+ "trim(?),"
						+ "trim(?),"
						+ "trim(?),"
						+ "trim(?),"
						+ "trim(?),"
						+ "trim(?),"
						+ "trim(?),"
						+ "?);";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, c.getNome_cliente());
			pstm.setString(2, c.getTipo_cliente());
			pstm.setString(3, c.getCpf_cliente());
			pstm.setString(4, c.getEmail_cliente());
			pstm.setString(5, c.getCel_cliente());
			pstm.setString(6, c.getInsc_cliente());
			pstm.setInt(7, u.getId_usuario());
			pstm.setString(8, c.getCep_cliente());
			pstm.setString(9, c.getEstado_cliente());
			pstm.setString(10, c.getCidade_cliente());
			pstm.setString(11, c.getBairro_cliente());
			pstm.setString(12, c.getLogradouro_cliente());
			pstm.setInt(13, c.getNumero_cliente());
			int resultado = JOptionPane.showConfirmDialog(null, "Confirmar inserção");
			if(resultado == JOptionPane.YES_OPTION) {
				pstm.execute();
				pstm.close();
				conn.close();
				JOptionPane.showMessageDialog(null, "Cadastro concluido");		
			} else {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void update(Object arg0) {
		Cliente c = (Cliente) arg0;
		try {
			Usuario u = Singleton.getInstance().getUser();
			Connection conn = new ConexaoDao().conexaoDb();
			String sql =
					"update cliente c set "
						+ "c.nome = ?,"
						+ "c.cpf_cnpj = ?,"
						+ "c.email = ?,"
						+ "c.celular = ?,"
						+ "c.senha = ?,"
						+ "c.insc_estadual = ? ,"
						+ "c.cep = ?,"
						+ "c.estado = ?,"
						+ "c.nome_cidade = ?,"
						+ "c.bairro = ?,"
						+ "c.logradouro = ?,"
						+ "c.numero = ?"
					+ "where c.id = ? "
						+ "and c.usuario = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, c.getNome_cliente());
			pstm.setString(2, c.getCpf_cliente());
			pstm.setString(3, c.getEmail_cliente());
			pstm.setString(4, c.getCel_cliente());
			pstm.setString(5, c.getSenha_cliente());
			pstm.setString(6, c.getInsc_cliente());
			pstm.setString(7, c.getCep_cliente());
			pstm.setString(8, c.getEstado_cliente());
			pstm.setString(9, c.getCidade_cliente());
			pstm.setString(10, c.getBairro_cliente());
			pstm.setString(11, c.getLogradouro_cliente());
			pstm.setInt(12, c.getNumero_cliente());
			pstm.setString(13, c.getId_cliente());
			pstm.setInt(14, c.getUsuario_cliente());
			System.out.println(u.getId_usuario());
			int resultado = JOptionPane.showConfirmDialog(null, "Confirmar edição");
			if(resultado == JOptionPane.YES_OPTION) {
				pstm.execute();
				pstm.close();
				conn.close();				
			}else {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Object arg0) {
		Cliente c = (Cliente) arg0;
		try {
			Usuario u = Singleton.getInstance().getUser();
			Connection conn = new ConexaoDao().conexaoDb();
			String sql = "delete from cliente where id = ? and usuario = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, c.getId_cliente());
			pstm.setInt(2, u.getId_usuario());
			int resultado = JOptionPane.showConfirmDialog(null, "Confirmar exclusão");
			if(resultado == JOptionPane.YES_OPTION) {
				pstm.execute();
				pstm.close();
				conn.close();				
			}else {
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object select(Object arg0) {
		Cliente c = (Cliente) arg0;
		try {
			Connection conn = Singleton.getInstance().getConn();
			String sql = 
					"select "
						+ "id,"
						+ "trim(nome) as nome,"
						+ "cpf_cnpj,"
						+ "celular,"
						+ "email,"
						+ "pessoa_fisica,"
						+ "insc_estadual,"
						+ "senha "
					+ "from cliente "
					+ "where id = ? "
						+ "and usuario = ? "
					+ "order by id";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, c.getId_cliente());
			pstm.setInt(2, c.getUsuario_cliente());
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				c.setId_cliente(rs.getString("id"));
				c.setNome_cliente(rs.getString("nome"));
				c.setCpf_cliente(rs.getString("cpf_cnpj"));
				c.setCel_cliente(rs.getString("celular"));
				c.setEmail_cliente(rs.getString("email"));
				c.setTipo_cliente(rs.getString("pessoa_fisica"));
				c.setInsc_cliente(rs.getString("insc_estadual"));
				c.setSenha_cliente(rs.getString("senha"));
				//JOptionPane.showMessageDialog(null, "Bem vindo " + c.getNome_cliente() );
			}else {
				JOptionPane.showMessageDialog(null, "Usuario nao encontrado!");
			}
			pstm.close();
			conn.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}


	public List<Cliente> select() {
		List<Cliente> clientes = new ArrayList<>();
		try {
			Usuario u = Singleton.getInstance().getUser();
			String busca = Singleton.getInstance().getBusca();
			Connection conn = new ConexaoDao().conexaoDb();
			String sql = 
					"select "
						+ "id,"
						+ "nome,"
						+ "cpf_cnpj,"
						+ "email,"
						+ "rpad(coalesce(replace(celular,' ',''),0),11,0) as celular, "
						+ "pessoa_fisica,"
						+ "insc_estadual,"
						+ "cep,"
						+ "estado,"
						+ "nome_cidade,"
						+ "bairro,"
						+ "logradouro,"
						+ "numero "
					+ "from cliente "
					+ "where usuario = ?"
						+ "and ((select * from arcus_stpremoveacentos(upper(nome))) like  '%'||"
							+ "(select * from arcus_stpremoveacentos(?)) ||'%' or ? is null "
							+ "or(cpf_cnpj like '%'|| ? ||'%' or ? is null))";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, u.getId_usuario());
			pstm.setString(2, busca);
			pstm.setString(3, busca);
			pstm.setString(4, busca);
			pstm.setString(5, busca);
			ResultSet rs = pstm.executeQuery();
			

			//modelo.setNumRows(0);
			
			while(rs.next()) {
				Cliente c = new Cliente();
				c.setId_cliente(rs.getString("id"));
				c.setNome_cliente(rs.getString("nome"));
				c.setCpf_cliente(rs.getString("cpf_cnpj"));
				c.setEmail_cliente(rs.getString("email"));
				c.setCel_cliente(rs.getString("celular"));
				c.setTipo_cliente(rs.getString("pessoa_fisica"));
				c.setInsc_cliente(rs.getString("insc_estadual"));
				c.setCep_cliente(rs.getString("cep"));
				c.setEstado_cliente(rs.getString("estado"));
				c.setCidade_cliente(rs.getString("nome_cidade"));
				c.setBairro_cliente(rs.getString("bairro"));
				c.setLogradouro_cliente(rs.getString("logradouro"));
				c.setNumero_cliente(rs.getInt("numero"));
				clientes.add(c);
			}
			pstm.close();
			rs.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		} 
		return clientes ;
	}
}
