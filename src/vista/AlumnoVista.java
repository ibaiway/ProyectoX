package vista;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import modelo.Alumno;
import modelo.AlumnoModelo;
import modelo.Matricula;

public class AlumnoVista {

	public static final int ALUMNOS_MATRICULAS = 1;
	public static final int SALIR = 0;
	
	public void menuAlumnos() {
		Scanner scan = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("--Menu de alumnos--");
			
			System.out.println(ALUMNOS_MATRICULAS + " - alumnos con matriculas");
			System.out.println(SALIR + " - salir");
			opcion = Integer.parseInt(scan.nextLine());
			switch (opcion) {
			
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
		Iterator<Alumno> i = alumnos.iterator();
		while(i.hasNext()){
			Alumno alumno = i.next();
			mostrarAlumnoConAsignaturas(alumno);
		}
		
	}

	private void mostrarAlumnoConAsignaturas(Alumno alumno) {
		System.out.println(alumno.getNombre() + " " + alumno.getDni());
		System.out.println("...............");
		ArrayList<Matricula> matriculas = alumno.getMatriculas();
		Iterator<Matricula> i = matriculas.iterator();
		while(i.hasNext()){
			Matricula matricula = i.next();
			System.out.println(matricula.getFecha()  + " : " + matricula.getAsignatura().getNombre() + "("
					+matricula.getAsignatura().getHoras()+ ")");
		}
		System.out.println("------------------------");
	}
	
}
