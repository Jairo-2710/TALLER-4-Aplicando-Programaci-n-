import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Lista donde se guardan los estudiantes en memoria
    static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    static int contadorCalificaciones = 1; // genera el idCalificacion

    public static void main(String[] args) {
        System.out.println("  BIENVENIDO AL SISTEMA DE GESTIÓN DE ESTUDIANTES");


        int opcion = 0;

        do {
            mostrarMenu();
            opcion = leerEntero();

            switch (opcion) {
                case 1:
                    consultarEstudiantes();
                    break;
                case 2:
                    registrarEstudiante();
                    break;
                case 3:
                    actualizarEstudiante();
                    break;
                case 4:
                    registrarCalificacion();
                    break;
                case 5:
                    consultarCalificaciones();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }

    // Muestra el menú principal
    static void mostrarMenu() {
        System.out.println("\n MENÚ PRINCIPAL ");
        System.out.println("1. Consultar estudiantes");
        System.out.println("2. Registrar estudiante");
        System.out.println("3. Actualizar información de estudiante");
        System.out.println("4. Registrar calificación final");
        System.out.println("5. Consultar calificaciones finales");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // RF02: Consultar estudiantes
    static void consultarEstudiantes() {
        System.out.println("\n--- LISTA DE ESTUDIANTES ---");
        if (estudiantes.isEmpty()) {
            System.out.println("La lista de estudiantes está vacía.");
            return;
        }
        for (Estudiante e : estudiantes) {
            e.mostrarInformacion();
            System.out.println("----------------------------");
        }
    }

    // RF03: Registrar estudiante
    static void registrarEstudiante() {
        System.out.println("\n--- REGISTRAR ESTUDIANTE ---");
        System.out.print("Código estudiantil: ");
        String codigo = scanner.nextLine().trim();

        if (codigo.isEmpty()) {
            System.out.println("El código no puede estar vacío.");
            return;
        }
        if (buscarEstudiante(codigo) != null) {
            System.out.println("Ya existe un estudiante con ese código.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Programa académico: ");
        String programa = scanner.nextLine();

        Estudiante nuevo = new Estudiante(codigo, nombre, apellido, programa);
        estudiantes.add(nuevo);
        System.out.println("Estudiante registrado correctamente.");
    }

    // RF04: Actualizar información
    static void actualizarEstudiante() {
        System.out.println("\n--- ACTUALIZAR ESTUDIANTE ---");
        System.out.print("Código del estudiante: ");
        String codigo = scanner.nextLine().trim();

        Estudiante e = buscarEstudiante(codigo);
        if (e == null) {
            System.out.println("No se encontró un estudiante con ese código.");
            return;
        }

        System.out.println("Datos actuales:");
        e.mostrarInformacion();

        System.out.println("\nIngrese los nuevos datos:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Programa académico: ");
        String programa = scanner.nextLine();

        e.actualizarInformacion(nombre, apellido, programa);
        System.out.println("Información actualizada correctamente.");
    }

    // RF05: Registrar calificación final
    static void registrarCalificacion() {
        System.out.println("\n--- REGISTRAR CALIFICACIÓN FINAL ---");
        System.out.print("Código del estudiante: ");
        String codigo = scanner.nextLine().trim();

        Estudiante e = buscarEstudiante(codigo);
        if (e == null) {
            System.out.println("No se encontró un estudiante con ese código.");
            return;
        }

        System.out.print("Calificación final (0.0 a 5.0): ");
        double nota = leerDecimal();

        if (nota < 0.0 || nota > 5.0) {
            System.out.println("Nota no válida. Debe estar entre 0.0 y 5.0.");
            return;
        }

        CalificacionFinal calificacion = new CalificacionFinal(contadorCalificaciones, nota);
        contadorCalificaciones++;
        e.setCalificacionFinal(calificacion);
        System.out.println("Calificación registrada correctamente.");
    }

    // Consultar calificaciones finales
    static void consultarCalificaciones() {
        System.out.println("\n--- CALIFICACIONES FINALES ---");
        boolean hayNotas = false;

        for (Estudiante e : estudiantes) {
            if (e.getCalificacionFinal() != null) {
                System.out.println("Estudiante: " + e.getCodigo() + " - " + e.getNombre() + " " + e.getApellido());
                e.getCalificacionFinal().mostrarInformacion();
                System.out.println("----------------------------");
                hayNotas = true;
            }
        }

        if (!hayNotas) {
            System.out.println("No hay calificaciones registradas.");
        }
    }

    // Busca un estudiante por código; devuelve null si no existe
    static Estudiante buscarEstudiante(String codigo) {
        for (Estudiante e : estudiantes) {
            if (e.getCodigo().equals(codigo)) {
                return e;
            }
        }
        return null;
    }

    // Lee un número entero sin que el programa se detenga por errores
    static int leerEntero() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException ex) {
            return -1;
        }
    }

    // Lee un número decimal (acepta coma o punto); devuelve -1 si es inválido
    static double leerDecimal() {
        try {
            return Double.parseDouble(scanner.nextLine().trim().replace(',', '.'));
        } catch (NumberFormatException ex) {
            return -1;
        }
    }
}
