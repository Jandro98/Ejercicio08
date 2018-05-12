package clasessql;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ClasesSQL {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Listas l = new Listas();
        //System.out.println(dep.toString());
        int menu = 1;
        /**
         * Bucle que servira como menu
         */
        while (menu != 9) {
            try {
                System.out.println("◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘");
                System.out.println("1- Listar departamentos\n2- Listar empleados\n3- Buscar empleado por nombre\n4- Buscar departamento por nombre\n5- Crear empleado\n6- Crear departamento\n7- Borrar empleado\n8- Borrar departamento\n9- Salir");
                System.out.println("◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘");
                menu = entrada.nextInt();

                switch (menu) {
                    /**
                     * Lista los departamentos
                     */
                    case 1:
                        try {
                            l.ListarDepartamento();
                        } catch (SQLException ex) {
                            System.out.println("○ Ha ocurrido un error SQL, vuélvalo a intentar");
                        }
                        break;
                    /**
                     * Lista los empleados
                     */
                    case 2:
                        try {
                            l.ListarEmpleado();
                        } catch (SQLException ex) {
                            System.out.println("○ Ha ocurrido un error SQL, vuélvalo a intentar");
                        }
                        break;
                    /**
                     * Pide un nombre y muestra el empleado al que pertenece
                     */
                    case 3:
                        try {
                            l.EmpleadoPorNombre();
                        } catch (SQLException ex) {
                            System.out.println("○ Ha ocurrido un error SQL, vuélvalo a intentar");
                        }
                        break;
                    /**
                     * Pide un nombre y muestra el departamento al que pertenece
                     */
                    case 4:
                        try {
                            l.DepartamentoPorNombre();
                        } catch (SQLException ex) {
                            System.out.println("○ Ha ocurrido un error SQL, vuélvalo a intentar");
                        }
                        break;
                    /**
                     * Crea un nuevo empleado
                     */
                    case 5:
                        try {
                            l.CrearEmpleado();
                        } catch (SQLException ex) {
                            System.out.println("○ Ha ocurrido un error SQL, vuélvalo a intentar");
                        }
                        break;
                    /**
                     * Crea un nuevo departamento
                     */
                    case 6:
                        try {
                            l.CrearDepartamento();
                        } catch (SQLException ex) {
                            System.out.println("○ Ha ocurrido un error SQL, vuélvalo a intentar");
                        }
                        break;
                    /**
                     * Borra un empleado existente
                     */
                    case 7:
                        try {
                            l.BorrarEmpleado();
                        } catch (SQLException ex) {
                            System.out.println("○ Ha ocurrido un error SQL, vuélvalo a intentar");
                        }
                        break;
                    /**
                     * Borra un departamento existente
                     */
                    case 8:
                        try {
                            l.BorrarDepartamento();
                        } catch (SQLException ex) {
                            System.out.println("○ Ha ocurrido un error SQL, vuélvalo a intentar");
                        }
                        break;
                    /**
                     * Mostrara mensaje de error si no se introduce un numero
                     * correcto
                     */
                    default:
                        if (menu != 9) {
                            System.out.println("◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘\n○ Número incorrecto ! Pruebe otra vez.");
                        }
                }//fin switch
                /**
                 * Recogera el error cuando se introduzca un valor incorrecto
                 */
            } catch (InputMismatchException ex) {
                System.out.println("◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘\n○ Ha introducido un valor erróneo, empiece otra vez.");
                //ex.printStackTrace();
                entrada.nextLine();
                /**
                 * Recogera otro tipo de errores que puedan surgir
                 */
            } catch (Exception ex) {
                System.out.println("◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘\n○ Ha ocurrido un error, pruebe otra vez.");
                //ex.printStackTrace();
                entrada.nextLine();
            }
        }//fin while

        /*
        Se desconecta de la bbdd
         */
        

    }
}
