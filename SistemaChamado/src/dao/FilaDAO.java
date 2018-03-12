	package dao;

	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.ArrayList;

	import com.mysql.jdbc.Connection;
	import com.mysql.jdbc.PreparedStatement;

	import model.Fila;
	
public class FilaDAO {
			public int criar(Fila fila) {
				String sqlInsert = "INSERT INTO fila(nm_fila) VALUES (?)";
			
				try (Connection conn = (Connection) ConnectionFactory.obtemConexao();
						PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sqlInsert);) {
					stm.setInt(1, fila.getNm_fila());
					stm.execute();
					String sqlQuery = "SELECT LAST_INSERT_ID()";
					try (PreparedStatement stm2 = (PreparedStatement) conn.prepareStatement(sqlQuery);
							ResultSet rs = stm2.executeQuery();) {
						if (rs.next()) {
							fila.setId(rs.getInt(1));
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return fila.getId();
			}

			public void atualizar(Fila fila) {
				String sqlUpdate = "UPDATE fila SET nm_fila=? WHERE id=?";
				try (Connection conn = (Connection) ConnectionFactory.obtemConexao();
						PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sqlUpdate);) {
					stm.setInt(1, fila.getNm_fila());
					stm.setInt(2, fila.getId());
					stm.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			public void excluir(int id) {
				String sqlDelete = "DELETE FROM fila WHERE id = ?";
				
				try (Connection conn = (Connection) ConnectionFactory.obtemConexao();
						PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sqlDelete);) {
					stm.setInt(1, id);
					stm.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			public Fila carregar(int id) {
				Fila fila = new Fila();
				fila.setId(id);
				String sqlSelect = "SELECT nm_fila FROM fila WHERE fila.id = ?";
				
				try (Connection conn = (Connection) ConnectionFactory.obtemConexao();
						PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sqlSelect);) {
					stm.setInt(1, fila.getId());
					try (ResultSet rs = stm.executeQuery();) {
						if (rs.next()) {
							stm.setInt(1, fila.getNm_fila());
							
						} else {
							fila.setId(-1);
							
							
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
				return fila;
			}

			public ArrayList<Fila> listarFila() {
				Fila fila;
				ArrayList<Fila> lista = new ArrayList<>();
				String sqlSelect = "SELECT nm_fila FROM fila";
				
				try (Connection conn = (Connection) ConnectionFactory.obtemConexao();
						PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sqlSelect);) {
					try (ResultSet rs = stm.executeQuery();) {
						while (rs.next()) {
							fila = new Fila();
							fila.setId(rs.getInt("id"));
							fila.setNm_fila(rs.getInt("Numero fila"));
							lista.add(fila);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
				return lista;
			}

			public ArrayList<Fila> listarFila(String chave) {
				Fila fila;
				ArrayList<Fila> lista = new ArrayList<>();
				String sqlSelect = "SELECT id, nm_fila FROM fila like ?";
				
				try (Connection conn = (Connection) ConnectionFactory.obtemConexao();
						PreparedStatement stm = (PreparedStatement) conn.prepareStatement(sqlSelect);) {
					try (ResultSet rs = stm.executeQuery();) {
						while (rs.next()) {
							fila = new Fila();
							fila.setId(rs.getInt("id"));
							fila.setNm_fila(rs.getInt("Numero fila"));
							lista.add(fila);
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

