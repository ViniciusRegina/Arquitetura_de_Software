package dao;

public class FilaDAO {
	
public ArrayList<Fila> listarTodasFilas() {
		
		Fila fl = new ArrayList<Fila>;
		
		String sqlSelect = "SELECT id_fila, nm_fila FROM FILA";
		
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					fl.setId_fila(rs.getInt("id_fila"));
					fl.setNm_fila(rs.getString("nm_fila"));
					
					
				} else {
					fl.setId_fila(-1);
					fl.setNm_fila(null);
					
			   }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return fl;
	}

}
