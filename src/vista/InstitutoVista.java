package vista;
import java.util.Scanner;

public class InstitutoVista {

	public static final int MENU_ALUMNOS = 1;
	public static final int MENU_MATRICULAS = 2;
	public static final int SALIR = 0;
	
	public void menuInstituto() {
		Scanner scan = new Scanner(System.in);
		int opcion;

		do {
			System.out.println("--Menu de matriculas--");
			System.out.println(MENU_ALUMNOS + " - menu de alumnos");
			System.out.println(MENU_MATRICULAS + " - menu de matriclas");
			System.out.println(SALIR + " - salir");
			opcion = Integer.parseInt(scan.nextLine());
			switch (opcion) {
			case MENU_ALUMNOS:
				AlumnoVista alumnoVista = new AlumnoVista();
				alumnoVista.menuAlumnos();
				
				break;
			case MENU_MATRICULAS:
				MatriculaVista matriculaVista = new MatriculaVista();
				matriculaVista.menuMatriculas();
				break;

			default:
				break;
			}

		} while (opcion != SALIR);

	}
	
}
