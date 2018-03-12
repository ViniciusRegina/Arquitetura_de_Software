package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import model.Chamado;

public class ChamadoDAO {
		public int criar(Chamado chamado) {
			String sqlInsert = "INSERT INTO chamado(descrição, status, dt_abertura, dt_fechamento) VALUES (?, ?, ?, ?)";
		
			try (Connection conn = (Connection) ConnectionFactory.obtemConexao();
					PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sqlInsert);) {
				stm.setString(1, chamado.getDescricao());
				stm.setString(2, chamado.getStatus());
				stm.setInt	 (3, chamado.getDt_abertura());
				stm.setInt	 (4, chamado.getDt_fechamento());
				stm.execute();
				String sqlQuery = "SELECT LAST_INSERT_ID()";
				try (PreparedStatement stm2 = (PreparedStatement) conn.prepareStatement(sqlQuery);
						ResultSet rs = stm2.executeQuery();) {
					if (rs.next()) {
						chamado.setId(rs.getInt(1));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return chamado.getId();
		}

		public void atualizar(Chamado chamado) {
			String sqlUpdate = "UPDATE chamado SET descricao=?, status=?, dt_abertura=?, dt_fechamento=? WHERE id=?";
			try (Connection conn = (Connection) ConnectionFactory.obtemConexao();
					PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sqlUpdate);) {
				stm.setString(1, chamado.getDescricao());
				stm.setString(2, chamado.getStatus());
				stm.setInt	 (3, chamado.getDt_abertura());
				stm.setInt	 (4, chamado.getDt_fechamento());
				stm.setInt	 (5, chamado.getId());
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void excluir(int id) {
			String sqlDelete = "DELETE FROM chamado WHERE id = ?";
			
			try (Connection conn = (Connection) ConnectionFactory.obtemConexao();
					PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sqlDelete);) {
				stm.setInt(1, id);
				stm.execute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@SuppressWarnings("null")
		public Chamado carregar(int id) {
			Chamado chamado = new Chamado();
			chamado.setId(id);
			String sqlSelect = "SELECT descricao, status, dt_abertura, dt_fechamento FROM chamado WHERE chamado.id = ?";
			
			try (Connection conn = (Connection) ConnectionFactory.obtemConexao();
					PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, chamado.getId());
				try (ResultSet rs = stm.executeQuery();) {
					if (rs.next()) {
						chamado.setDescricao(rs.getString("descricao"));
						chamado.setStatus(rs.getString("status"));
						chamado.setDt_abertura(rs.getInt("data de abertura"));
						chamado.setDt_fechamento(rs.getInt("data de fechamento"));
					} else {
						chamado.setId(-1);
						chamado.setDescricao(null);
						chamado.setStatus(null);
						chamado.setDt_abertura((Integer) null);
						chamado.setDt_fechamento((Integer) null);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return chamado;
		}

		public ArrayList<Chamado> listarChamado() {
			Chamado chamado;
			ArrayList<Chamado> lista = new ArrayList<>();
			String sqlSelect = "SELECT id, descricao, status, dt_abertura, dt_fechamento FROM chamado";
			
			try (Connection conn = (Connection) ConnectionFactory.obtemConexao();
					PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sqlSelect);) {
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						chamado = new Chamado();
						chamado.setId(rs.getInt("id"));
						chamado.setDescricao(rs.getString("descricao"));
						chamado.setStatus(rs.getString("status"));
						chamado.setDt_abertura(rs.getInt("data de abertura"));
						chamado.setDt_fechamento(rs.getInt("data de fechamento"));
						lista.add(chamado);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return lista;
		}

		public ArrayList<Chamado> listarChamado(String chave) {
			Chamado chamado;
			ArrayList<Chamado> lista = new ArrayList<>();
			String sqlSelect = "SELECT id, descricao, status, dt_abertura, dt_fechamento FROM chamado like ?";
			
			try (Connection conn = (Connection) ConnectionFactory.obtemConexao();
					PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sqlSelect);) {
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						chamado = new Chamado();
						chamado.setId(rs.getInt("id"));
						chamado.setDescricao(rs.getString("descricao"));
						chamado.setStatus(rs.getString("status"));
						chamado.setDt_abertura(rs.getInt("data de abertura"));
						chamado.setDt_fechamento(rs.getInt("data de fechamento"));
						lista.add(chamado);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return lista;
		}

	}



