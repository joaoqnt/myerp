package br.com.arcus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.arcus.model.ItemPedido;
import br.com.arcus.model.Pedido;
import br.com.arcus.utils.Dao;
import br.com.arcus.utils.Singleton;

public class ItemPedidoDao implements Dao {

	@Override
	public void insert(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object select(Object arg0) {
		ItemPedido ip = (ItemPedido) arg0;
		try {
			Pedido p = Singleton.getInstance().getPed();
			Connection conn = new ConexaoDao().conexaoDb();
			String sql = 
					"select "
							+ "ip.id as id,"
							+ "ip.produto as produto,"
							+ "ip.quantidade as quantidade,"
							+ "ip.preco_unitario as preco_unitario,"
							+ "ip.adicional as adicional,"
							+ "ip.frete as frete,"
							+ "ip.desconto as desconto,"
							+ "ip.peso as peso,"
							+ "ip.categoria as categoria,"
							+ "ip.unidade_venda as unidade_venda,"
							+ "ip.pedido as pedido "
						+ "from itempedido ip "
						+ "where ip.pedido = ? "
							+ "and ip.produto = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, p.getId());
			pstm.setInt(2, ip.getProduto());
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				ip.setId(rs.getInt("id"));
				ip.setProduto(rs.getInt("produto"));
				ip.setQuantidade(rs.getInt("quantidade"));
				ip.setPreco_unitario(rs.getDouble("preco_unitario"));
				ip.setAdici_unitario(rs.getDouble("adicional"));
				ip.setFrete_unitario(rs.getDouble("frete"));
				ip.setDesco_unitario(rs.getDouble("desconto"));
				ip.setPeso_unitario(rs.getDouble("peso"));
				ip.setGrupo_produto(rs.getString("categoria"));
				ip.setUnid_unitario(rs.getString("unidade_venda"));
				ip.setPedido(rs.getInt("pedido"));
			}
			rs.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<ItemPedido> select() {
		List<ItemPedido> itens = new ArrayList<>();
		try {
			Pedido p = Singleton.getInstance().getPed();
			
			Connection conn = new ConexaoDao().conexaoDb();
			String sql =
					"select "
						+ "ip.id as id,"
						+ "ip.produto as produto,"
						+ "ip.quantidade as quantidade,"
						+ "ip.preco_unitario as preco_unitario,"
						+ "ip.adicional as adicional,"
						+ "ip.frete as frete,"
						+ "ip.desconto as desconto,"
						+ "ip.peso as peso,"
						+ "ip.categoria as categoria,"
						+ "ip.unidade_venda as unidade_venda,"
						+ "ip.pedido as pedido "
					+ "from itempedido ip "
					+ "where ip.pedido = ? "
					+ "order by id";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, p.getId());
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				ItemPedido ip = new ItemPedido();
				ip.setId(rs.getInt("id"));
				ip.setProduto(rs.getInt("produto"));
				ip.setQuantidade(rs.getInt("quantidade"));
				ip.setPreco_unitario(rs.getDouble("preco_unitario"));
				ip.setAdici_unitario(rs.getDouble("adicional"));
				ip.setFrete_unitario(rs.getDouble("frete"));
				ip.setDesco_unitario(rs.getDouble("desconto"));
				ip.setPeso_unitario(rs.getDouble("peso"));
				ip.setGrupo_produto(rs.getString("categoria"));
				ip.setUnid_unitario(rs.getString("unidade_venda"));
				ip.setPedido(rs.getInt("pedido"));
				itens.add(ip);
			}
			rs.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao mostrar os itens do pedido: " + e );
		}
		return itens;
	}

}
