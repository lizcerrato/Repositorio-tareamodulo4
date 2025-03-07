import java.util.ArrayList;
import java.util.Scanner;

class Empleado {
    private String nombre;
    private int edad;
    private double salario;

    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // imprimir la información del empleado
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad + ", Salario: " + salario);
    }
}

// Clase GestorEmpleados
class GestorEmpleados {
    private ArrayList<Empleado> empleados;

    public GestorEmpleados() {
        this.empleados = new ArrayList<>();
    }

    // agregar empleados
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    // mostrar todos los empleados
    public void mostrarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            for (Empleado emp : empleados) {
                emp.mostrarInformacion();
            }
        }
    }

    // modificar un empleado
    public void modificarEmpleado(String nombre, int nuevaEdad, double nuevoSalario) {
        for (Empleado emp : empleados) {
            if (emp.getNombre().equalsIgnoreCase(nombre)) {
                emp.setEdad(nuevaEdad);
                emp.setSalario(nuevoSalario);
                System.out.println("Empleado actualizado correctamente.");
                return;
            }
        }
        System.out.println("Empleado no encontrado.");
    }
}

// Clase Main
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorEmpleados gestor = new GestorEmpleados();
        int opcion;
        
        do {
            System.out.println("\nMenú de Gestión de Empleados:");
            System.out.println("1. Agregar empleado");
            System.out.println("2. Mostrar empleados");
            System.out.println("3. Modificar empleado");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            while (!scanner.hasNextInt()) { 
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();
                    
                    System.out.print("Ingrese edad: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Por favor, ingrese una edad válida.");
                        scanner.next();
                    }
                    int edad = scanner.nextInt();
                    scanner.nextLine(); 
                    
                    System.out.print("Ingrese salario: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Por favor, ingrese un salario válido.");
                        scanner.next();
                    }
                    double salario = scanner.nextDouble();
                    scanner.nextLine(); 
                    
                    gestor.agregarEmpleado(new Empleado(nombre, edad, salario));
                    System.out.println("Empleado agregado con éxito.");
                    break;
                
                case 2:
                    System.out.println("Lista de empleados registrados:");
                    gestor.mostrarEmpleados();
                    break;
                
                case 3:
                    System.out.print("Ingrese el nombre del empleado a modificar: ");
                    String nombreMod = scanner.nextLine();
                    
                    System.out.print("Ingrese nueva edad: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Por favor, ingrese una edad válida.");
                        scanner.next();
                    }
                    int nuevaEdad = scanner.nextInt();
                    scanner.nextLine(); 
                    
                    System.out.print("Ingrese nuevo salario: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Por favor, ingrese un salario válido.");
                        scanner.next();
                    }
                    double nuevoSalario = scanner.nextDouble();
                    scanner.nextLine(); 
                    
                    gestor.modificarEmpleado(nombreMod, nuevaEdad, nuevoSalario);
                    break;
                
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 4);
        
        scanner.close();
    }
}
