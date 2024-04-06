/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package junglamar.simuladormatricula;

/**
 *
 * @author JHON ROSAS
 */
import java.util.Scanner;
public class SimuladorMatricula {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Mostrar el menú
            System.out.println("=== Menú de Matrícula ===");
            System.out.println("1. Ingeniería de Sistemas");
            System.out.println("2. Medicina");
            System.out.println("3. Derecho");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            // Procesar la opción seleccionada
            switch (opcion) {
                case 1:
                    matricularEstudiante("Ingeniería de Sistemas", scanner);
                    break;
                case 2:
                    matricularEstudiante("Medicina", scanner);
                    break;
                case 3:
                    matricularEstudiante("Derecho", scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 4);

        scanner.close();
    }
    
    public static void matricularEstudiante(String carrera, Scanner scanner) {
    // Solicitar datos del estudiante
    System.out.println("Ingrese los datos del estudiante para la carrera de " + carrera + ":");
    System.out.print("Nombres: ");
    String nombres = scanner.nextLine();
    System.out.print("Apellidos: ");
    String apellidos = scanner.nextLine();
    System.out.print("Documento: ");
    String documento = scanner.nextLine();
    System.out.print("Dirección: ");
    String direccion = scanner.nextLine();
    System.out.print("Teléfono: ");
    String telefono = scanner.nextLine();
    System.out.print("Semestre actual: ");
    int semestre = scanner.nextInt();
    scanner.nextLine(); // Limpiar el buffer de entrada
    
    // Verificar si el estudiante tiene materias aplazadas
    System.out.print("¿El estudiante tiene materias aplazadas? (SI/NO): ");
    String tieneMateriasAplazadasStr = scanner.nextLine();
    boolean tieneMateriasAplazadas = tieneMateriasAplazadasStr.equalsIgnoreCase("SI");
    
    // Calcular el monto de la matrícula
    double montoMatricula;
    
    if (tieneMateriasAplazadas) {
            System.out.print("Número de materias aplazadas: ");
            int materiasAplazadas = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada
            
            // Determinar el costo por crédito según el semestre
            double costoCredito;
            if (semestre <= 3) {
                costoCredito = 20;
            } else if (semestre <= 6) {
                costoCredito = 25;
            } else {
                costoCredito = 30;
            }
            
            montoMatricula = materiasAplazadas * costoCredito; // Costo de las materias aplazadas
            
            // Mostrar recibo de inscripción
            System.out.println("\nRECIBO DE INSCRIPCIÓN");
            System.out.println("======================");
            System.out.println("Carrera: " + carrera);
            System.out.println("Estudiante: " + nombres + " " + apellidos);
            System.out.println("Documento: " + documento);
            System.out.println("Dirección: " + direccion);
            System.out.println("Teléfono: " + telefono);
            System.out.println("Semestre actual: " + semestre);
            System.out.println("Materias aplazadas: " + materiasAplazadas);
            System.out.println("Costo por crédito: $" + costoCredito);
            System.out.println("Monto total de la matrícula: $" + montoMatricula);
        } else {
            // No hay materias aplazadas, calcular monto base
            double costoCredito;
            if (semestre <= 3) {
                costoCredito = 20;
            } else if (semestre <= 6) {
                costoCredito = 25;
            } else {
                costoCredito = 30;
            }
            
            montoMatricula = 1500 * semestre; // Precio base por semestre
            if (semestre >= 5) {
                montoMatricula *= 1.05; // Aumento del 5% a partir del quinto semestre
            }
            
            // Mostrar recibo de inscripción
            System.out.println("\nRECIBO DE INSCRIPCIÓN");
            System.out.println("======================");
            System.out.println("Carrera: " + carrera);
            System.out.println("Estudiante: " + nombres + " " + apellidos);
            System.out.println("Documento: " + documento);
            System.out.println("Dirección: " + direccion);
            System.out.println("Teléfono: " + telefono);
            System.out.println("Semestre actual: " + semestre);
            System.out.println("Materias aplazadas: Ninguna");
            System.out.println("Costo por crédito: $" + costoCredito);
            System.out.println("Monto total de la matrícula: $" + montoMatricula);
        }
    }
}