package dao;

import model.Fila;

public class ChamadoDAO {
	
	public int inserirChamado(Chamado ch) {
		
		String sqlInsert = "INSERT INTO CHAMADO(descricao, status, dt_abertura, id_fila) VALUES (?, ?, ?, ?)";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setString(1, ch.getDescricao());
			stm.setString(2, ch.getStatus());
			stm.setString(3, ch.getDt_abertura());
			stm.setInt(4,    ch.getId_fila());
			
			stm.execute();
			
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					ps.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fila.getId_fila();
	}

	public void alterarChamado(Chamado ch) {
		String sqlUpdate = "UPDATE CHAMADO SET descricao=?, status=?, dt_abertura=?, dt_fechamento=?, id_fila=? WHERE id_chamado=?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, ch.getDescricao());
			stm.setString(2, ch.getStatus());
			stm.setString(3, ch.getDt_abertura());
			stm.setString(4, ch.getDt_fechamento());
			stm.setString(5, ch.getId_fila());
			stm.setString(6, ch.getId_chamado());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM CHAMADO WHERE id_chamado = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			
			stm.setInt(1, id);
			stm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Chamado> listarTodosChamados() {
		
		Chamado ch = new ArrayList<Chamado>;
		
		String sqlSelect = "SELECT id_chamado, descricao, status, dt_abertura, dt_fechamento, id_fila FROM CHAMADO";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					ch.setId_chamado(rs.getInt("id_chamado"));
					ch.setDescricao(rs.getString("descricao"));
					ch.setStatus(rs.getString("status"));
					ch.setDt_abertura(rs.getString("dt_abertura"));
					ch.setDt_fechamento(rs.getString("dt_fechamento"));
					ch.setId_fila(rs.getInt("id_fila"));
					
				} else {
					ch.setId_chamado(-1);
					ch.setDescricao(null);
					ch.setStatus(null);
					ch.setDt_abertura(null);
					ch.setDt_fechamento(null);
					ch.setId_fila(null);
					
			   }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return ch;
	}
	

}
