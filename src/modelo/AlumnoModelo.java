package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AlumnoModelo extends Conector {

	public Alumno getAlumno(int id_alumno) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select * from alumnos where id = ?");
			pst.setInt(1, id_alumno);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Alumno alumno = new Alumno();
				alumno.setId(rs.getInt("id"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setDni(rs.getString("dni"));
				alumno.setEmail(rs.getString("email"));
				
				return alumno;
			}

		} catch (SQLException e) {
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

	
	public ArrayList<Alumno> sellectAll() {
		Statement st;
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		
		try {
			st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from alumnos join provincias on alumnos.id_provincia = provincias.id");
			while(rs.next()){
				Alumno alumno= new Alumno();
				alumno.setId(rs.getInt("alumnos.id"));
				alumno.setNombre(rs.getString("alumnos.nombre"));
				alumno.setDni(rs.getString("dni"));
				Provincia provincia = new Provincia();
				provincia.setId(rs.getInt("provincias.id"));
				provincia.setNombre(rs.getString("provincias.nombre"));
				alumno.setProvincia(provincia);
				
				alumnos.add(alumno);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return alumnos;
		
		
	}
	
	public ArrayList<Alumno> sellectAll2() {
		Statement st;
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		ProvinciaModelo provinciaModelo = new ProvinciaModelo();
		
		try {
			st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from alumnos");
			while(rs.next()){
				Alumno alumno= new Alumno();
				alumno.setId(rs.getInt("id"));
				alumno.setNombre(rs.getString("nombre"));
				alumno.setDni(rs.getString("dni"));
				alumno.setProvincia(provinciaModelo.get(rs.getInt("id_provincia")));
				
				alumnos.add(alumno);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return alumnos;
		
		
	}
	
	
}
