package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AsignaturaModelo extends Conector{

	public Asignatura getAsignatura(int id){
		
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from asignaturas where id=" +id);
			
			if (rs.next()){
				Asignatura asignatura = new Asignatura();
				asignatura.setId(rs.getInt("id"));
				asignatura.setNombre(rs.getString("nombre"));
				asignatura.setHoras(rs.getInt("horas"));
				return asignatura;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
