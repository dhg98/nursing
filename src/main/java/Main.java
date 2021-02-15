import java.util.Scanner;

import org.apache.commons.io.FilenameUtils;

public class Main {

    public static void main(String ... args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de gestión de enfermería del colegio Juan de la Cierva");
        System.out.print("Introduzca el fichero en el que se encuentra la información de los alumnos (en formato csv): ");
        String filename = sc.nextLine();
        String extension = FilenameUtils.getExtension(filename);
        if (extension.equals("")) {
            System.err.println("ERROR: Es necesario introducir un nombre de fichero");
            return;
        } else if (!extension.equals("csv")) {
            System.err.println("ERROR: El formato del fichero debe ser csv");
            return;
        }

        System.out.println("Se va a proceder a cargar la información proveniente del fichero " + filename);

        // Load info

        menuFunction();
    }

    public static void menuFunction() {
        int opt;
        do {
            opt = menuOpt();
            // Work with the valid option
            switch (opt) {
                case 1: // Add students

                    break;
                case 2: // Erase students

                    break;
                case 3: // Add incidence

                    break;
                case 4: // Add antecedents

                    break;
                case 5: // Add allergies

                    break;
                case 6: // Add vaccination info

                    break;
                case 7: // Save information

                    break;
                case 8: // Obtain student information

                    break;
                case 9: // Generate student PDF

                    break;
                case 0: // Exit

            }
        } while (opt != 0);
    }

    public static int menuOpt() {
        int opt;
        Scanner sc = new Scanner(System.in);
        menu();
        do {
            System.out.print("Introduzca una opción válida: ");
            String input = sc.nextLine();
            try {
                opt = Integer.parseInt(input);
                if (opt < 0 || opt > 9) {
                    System.out.println("Opción no válida " + input + ". El argumento debe ser un número dentro del rango especificado");
                    opt = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Opción no válida " + input + ". El argumento debe ser un número dentro del rango especificado");
                opt = -1;
            }

            // Valid option

        } while (opt == -1);
        return opt;
    }

    public static void menu() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("1.\tAñadir alumnos");
        System.out.println("2.\tEliminar alumnos");
        System.out.println("3.\tAñadir incidencia de un alumno");
        System.out.println("4.\tAñadir antecedentes personales de un alumno");
        System.out.println("5.\tAñadir alergias de un alumno");
        System.out.println("6.\tAñadir vacunación de un alumno");
        System.out.println("7.\tVolcar la información del registro");
        System.out.println("8.\tObtener información de un alumno");
        System.out.println("9.\tGenerar una ficha clínica para un alumno (PDF)");
        System.out.println("0.\tSalir");
        System.out.println("------------------------------------------------------------------------");
    }

    public static void addIncidence() {

    }

}

