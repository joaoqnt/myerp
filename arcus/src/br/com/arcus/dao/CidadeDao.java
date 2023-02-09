package br.com.arcus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.arcus.model.Cidade;
import br.com.arcus.utils.Dao;

public class CidadeDao implements Dao {

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cidade> select() {
		List<Cidade> cidades = new ArrayList<>();
		try {
			Connection conn = new ConexaoDao().conexaoDb();
			String sql =
					"select "
						+ "c.id as id,"
						+ "c.cidade as cidade,"
						+ "c.estado as estado "
					+ "from cidade c "
					+ "where c.estado = ? "
						+ "and c.usuario = ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Cidade c = new Cidade();
				c.setId_cidade(rs.getInt("id"));
				c.setNome_cidade(rs.getString("cidade"));
				c.setEstado_cidade(rs.getString("estado"));
				cidades.add(c);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cidades;
	}

}
