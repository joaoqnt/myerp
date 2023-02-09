package br.com.arcus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.arcus.model.Cliente;
import br.com.arcus.model.Pedido;
import br.com.arcus.model.Usuario;
import br.com.arcus.utils.Dao;
import br.com.arcus.utils.Singleton;

public class PedidoDao implements Dao{

	@Override
	public void insert(Object arg0) {
		Pedido p = (Pedido) arg0;
		try {
			Connection conn = new ConexaoDao().conexaoDb();
			String sql = 
					"insert into pedido ("
							+ "id,"
							+ "usuario,"
							+ "cliente,"
							+ "valor_total) "
					+ "values("
							+"(select gen_id(gen_idpedido,1)from rdb$database),"
							+ "?,"
							+ "?,"
							+ "?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, p.getUsuario());
			pstm.setInt(2, p.getCliente());
			pstm.setDouble(3, p.getValorLiquido());
			
			pstm.execute();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao inserir pedido " + e);
		}
	}

	@Override
	public void update(Object arg0) {
		Pedido p = (Pedido) arg0;
		try {
			Connection conn = new ConexaoDao().conexaoDb();
			String sql = 
					"update pedido set"
					+ "usuario = ?,"
					+ "cliente = ?,"
					+ "valor_total = ? "
					+ "where id = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, p.getUsuario());
			pstm.setInt(2, p.getCliente());
			pstm.setDouble(3, p.getValorLiquido());
			pstm.setInt(4, p.getId());
			
			pstm.execute();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar pedido " + e);
		}
	}

	@Override
	public void delete(Object arg0) {
		Pedido p = (Pedido) arg0;
		try {
			Connection conn = new ConexaoDao().conexaoDb();
			String sql = 
					"delete from pedido where id = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, p.getId());
			
			pstm.execute();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar pedido " + e);
		}
	}

	@Override
	public Object select(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> select() {
		List<Pedido> pedido = new ArrayList<>();
		try {
			Usuario u = Singleton.getInstance().getUser();
			Cliente c = Singleton.getInstance().getCli(); 
			Connection conn = new ConexaoDao().conexaoDb();
			String sql = 
					"select "
						+ "id,"
						+ "usuario,"
						+ "cliente,"
						+ "valor_total,"
						+ "data_pedido,"
						+ "tipo_pedido,"
						+ "prazo_pagamento,"
						+ "forma_pagamento "
					+ "from pedido "
					+ "where usuario = ? "
						+ "and cliente = ? "
					+ "order by data_pedido desc";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, u.getId_usuario());
			pstm.setString(2, c.getId_cliente());
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Pedido p = new Pedido();
				p.setId(rs.getInt("id"));
				p.setUsuario(rs.getInt("usuario"));
				p.setCliente(rs.getInt("cliente"));
				p.setValorLiquido(rs.getDouble("valor_total"));
				p.setValorBruto(rs.getDouble("valor_total"));
				p.setData(rs.getDate("data_pedido"));
				p.setTipo_oper(rs.getInt("tipo_pedido"));
				p.setPrazo_pgto(rs.getInt("prazo_pagamento"));
				p.setForma_pgto(rs.getInt("forma_pagamento"));
				pedido.add(p);
			}
			pstm.close();
			conn.close();
			rs.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar pedidos " + e);
		}
		return pedido;
	}
}
