package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class MatriculaModelo extends Conector {

		public ArrayList<Matricula> selectAll(){

			ArrayList<Matricula> Matriculas = new ArrayList();
			AlumnoModelo alumnoModelo = new AlumnoModelo();
			AsignaturaModelo asignaturaModelo = new AsignaturaModelo();
			
			
			try {
				Statement st = conexion.createStatement();

				ResultSet rs = st.executeQuery("select * from matriculas");
				
				while (rs.next()){
					Matricula matricula = new Matricula();
					matricula.setAlumno(alumnoModelo.getAlumno(rs.getInt("id_alumno")));
					matricula.setAsignatura(asignaturaModelo.getAsignatura(rs.getInt("id_asignatura")));
					matricula.setFecha(rs.getDate("fecha"));
					Matriculas.add(matricula);
				}
				return Matriculas;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;			
	}
		
		
		public ArrayList<Matricula> getMatriculasConAsignatura(Alumno alumno) {
			AsignaturaModelo asignaturaModelo = new AsignaturaModelo();
			ArrayList<Matricula> matriculas = new ArrayList<Matricula>();
			Matricula matricula;
			try {
				PreparedStatement pst = super.conexion.prepareStatement("select * from matriculas where id_alumno = ?");
				pst.setInt(1, alumno.getId());
				ResultSet rs = pst.executeQuery();
				
				while(rs.next()){
					matricula = new Matricula();
					matricula.setFecha(rs.getDate("fecha"));
					matricula.setAsignatura(asignaturaModelo.getAsignatura(rs.getInt("id_asignatura")));
					
					matriculas.add(matricula);
					
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return matriculas;
		}

			
}
