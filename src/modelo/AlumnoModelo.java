package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AlumnoModelo extends Conector {

	public Alumno getAlumno(int id){
		Alumno alumno = new Alumno();
		
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from alumnos where id=" +id);
			
			while (rs.next()) {
				alumno.setId(rs.getInt("id"));
				alumno.setDni(rs.getString("dni"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setEmail(rs.getString("email"));
				return alumno;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	public ArrayList<Alumno> selectAllConMatriculas(){
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		MatriculaModelo matriculaModelo = new MatriculaModelo();

		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from alumnos");
			while (rs.next()) {
				Alumno alumno = new Alumno();
				alumno.setId(rs.getInt("id"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setDni(rs.getString("dni"));
				alumno.setEmail(rs.getString("email"));
				ArrayList<Matricula> matriculas = matriculaModelo.getMatriculasConAsignatura(alumno);
				alumno.setMatriculas(matriculas);

				alumnos.add(alumno);
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnos;
	}
	
	
	
}
