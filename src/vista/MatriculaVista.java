package vista;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import modelo.Alumno;
import modelo.AlumnoModelo;
import modelo.Matricula;
import modelo.MatriculaModelo;

public class MatriculaVista {


	
	static final int MOSTRAR_MATRICULAS = 1;
	static final int ALUMNOS_MATRICULAS = 2;
	static final int SALIR = 0;

	public void menuMatriculas() {
		Scanner scan = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("--Menu de matriculas--");
			System.out.println(MOSTRAR_MATRICULAS + " - listar todas");
			System.out.println(ALUMNOS_MATRICULAS + " - alumnos con matriculas");
			System.out.println(SALIR + " - salir");
			opcion = Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case MOSTRAR_MATRICULAS:
				MatriculaModelo matriculaModelo = new MatriculaModelo();
				ArrayList<Matricula> matriculas = matriculaModelo.selectAll();
				this.mostrarMatriculas(matriculas);
				
				break;
			case ALUMNOS_MATRICULAS:
				AlumnoModelo alumnoModelo = new AlumnoModelo();
				ArrayList<Alumno> alumnos = alumnoModelo.selectAllConMatriculas();
				
				this.mostrarAlumnosConAsignaturas(alumnos);
				break;

			default:
				break;
			}

		} while (opcion != SALIR);

	}

	private void mostrarAlumnosConAsignaturas(ArrayList<Alumno> alumnos) {
		
		
	}

	public void mostrarMatriculas(ArrayList<Matricula> matriculas) {
		Iterator<Matricula> i = matriculas.iterator();
		while (i.hasNext()) {
			Matricula matricula = i.next();
			mostrarMatricula(matricula);
		}

	}

	public void mostrarMatricula(Matricula matricula) {
		// conseguir la info de asignatura y alumno

		System.out.println(matricula.getAlumno().getNombre() + " : " + matricula.getAlumno().getDni() + " : "
				+ matricula.getAsignatura().getNombre() + " : " + matricula.getAsignatura().getHoras() + " : "
				+ matricula.getFecha());
	}
}
