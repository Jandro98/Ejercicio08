package clasessql;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase donde se realizan las distintas funciones que se piden
 *
 * @author Usuario 1 DAM
 */
public class Listas {

    /**
     * Lista 1 o todos los departamentos, segun se elija
     *
     * @throws SQLException
     */
    public void ListarDepartamento() throws SQLException {

        Scanner sc = new Scanner(System.in);

        Departamento dep;
        Departamentos bdep = new Departamentos();

        System.out.println("◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘");
        System.out.println("1- Mostrar un departamento\n2- Mostrar todos los departamentos");
        System.out.println("◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘");
        int n = sc.nextInt();
        System.out.println("◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘");
        switch (n) {
            case 1:
                int s = 0;
                while (s <= 0) {
                    try {
                        while (s <= 0) {
                            System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••");
                            System.out.println("○ ¿Qué departamento desea ver?");
                            System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••");
                            s = sc.nextInt();
                            System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••");
                            if (s <= 0) {
                                System.out.println("○ El numero debe ser mayor a 0");
                            }
                        }
                    } catch (InputMismatchException ex) {
                        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••");
                        System.out.println("○ Ha introducido un valor erróneo, vuelvalo a intentar");
                        sc.nextLine();
                    }
                }
                dep = bdep.Read(s);
                System.out.println("+-------------------------------------------------+");
                System.out.printf("|%-15s |%-15s |%-15s| %n", "NºDepartamento", "NomDepartamento", "Localidad");
                System.out.println("+-------------------------------------------------+");
                System.out.printf("|%-15d |%-15s |%-15s| %n", (dep.getNumeroDepartamento()), dep.getNombreDepartamento(), dep.getLocalidad());
                System.out.println("+-------------------------------------------------+");
                break;
            case 2:
                ArrayList<Departamento> bdeps = bdep.ReadVarios();
                System.out.println("+-------------------------------------------------+");
                System.out.printf("|%-15s |%-15s |%-15s| %n", "NºDepartamento", "NomDepartamento", "Localidad");
                System.out.println("+-------------------------------------------------+");
                for (int i = 0; i < bdeps.size(); i++) {
                    System.out.printf("|%-15d |%-15s |%-15s| %n", (bdeps.get(i).getNumeroDepartamento()), bdeps.get(i).getNombreDepartamento(), bdeps.get(i).getLocalidad());
                }
                System.out.println("+-------------------------------------------------+");
                System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••");
                break;
            default:
                System.out.println("○ El numero no corresponde con ninguna opcion valida");
        }//fin switch
    }//fin ListarDEPARTAMENTO()

    /**
     * Lista 1 o todos los empleados segun se elija
     *
     * @throws SQLException
     */
    public void ListarEmpleado() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘");
        System.out.println("1- Mostrar un empleado\n2- Mostrar todos los empleados");
        System.out.println("◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘");
        int n = sc.nextInt();
        System.out.println("◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘");
        Empleado emp;
        Empleados bemp = new Empleados();
        switch (n) {
            case 1:

                int s = 0;
                while (s <= 0) {
                    try {
                        while (s <= 0) {
                            System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••");
                            System.out.println("○ ¿Qué empleado desea ver?");
                            System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••");
                            s = sc.nextInt();
                            if (s <= 0) {
                                System.out.println("○ El numero debe ser mayor a 0");
                            }
                            System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••");

                        }
                    } catch (InputMismatchException ex) {
                        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••");
                        System.out.println("○ Ha introducido un valor erróneo, vuelvalo a intentar");
                        sc.nextLine();
                    }
                }
                emp = bemp.Read(s);
                System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------+");
                System.out.printf("|%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s|%n", "NºEmpleado", "Apellido", "Oficio", "Direccion", "Fecha Alta", "Salario", "Comision", "NºDepartamento");
                System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------+");
                System.out.printf("|%-15d |%-15s |%-15s |%-15d |%-15s |%-15.2f |%-15.2f |%-15d|%n", emp.getNumeroEmpleado(), emp.getApellido(), emp.getOficio(), emp.getDireccion(), emp.getFechaAlta(), emp.getSalario(), emp.getComision(), emp.getNumeroDepartamento());
                System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------+");
                System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••");
                break;
            case 2:
                System.out.println("••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
                ArrayList<Empleado> bemps = bemp.ReadVarios();
                System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------+");
                System.out.printf("|%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s|%n", "NºEmpleado", "Apellido", "Oficio", "Direccion", "Fecha Alta", "Salario", "Comision", "NºDepartamento");
                System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------+");
                for (int i = 0; i < bemps.size(); i++) {
                    System.out.printf("|%-15d |%-15s |%-15s |%-15d |%-15s |%-15f |%-15f |%-15d|%n", bemps.get(i).getNumeroEmpleado(), bemps.get(i).getApellido(), bemps.get(i).getOficio(), bemps.get(i).getDireccion(), bemps.get(i).getFechaAlta(), bemps.get(i).getSalario(), bemps.get(i).getComision(), bemps.get(i).getNumeroDepartamento());
                }
                System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------+");
                System.out.println("••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••••");
                break;
            default:
                System.out.println("○ El numero no corresponde con ninguna opcion valida");
        }//fin switch
    }//fin ListarEmpleado()

    /**
     * Busca 1 departamento por su nombre y lo muestra
     *
     * @throws SQLException
     */
    public void DepartamentoPorNombre() throws SQLException {
        Scanner sc = new Scanner(System.in);
        Departamento dep;
        Departamentos bdep = new Departamentos();
        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••");
        System.out.println("○ Indica el nombre del departamento que desea ver");
        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••");
        String n = sc.nextLine();
        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••");
        dep = bdep.ReadNombre(n);
        System.out.println("+-------------------------------------------------+");
        System.out.printf("|%-15s |%-15s |%-15s| %n", "NºDepartamento", "NomDepartamento", "Localidad");
        System.out.println("+-------------------------------------------------+");
        System.out.printf("|%-15d |%-15s |%-15s| %n", (dep.getNumeroDepartamento()), dep.getNombreDepartamento(), dep.getLocalidad());
        System.out.println("+-------------------------------------------------+");
        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••");
    }//fin DepartamentoPorNombre

    /**
     * Busca un empleado por su nombre y lo muestra
     *
     * @throws SQLException
     */
    public void EmpleadoPorNombre() throws SQLException {
        Scanner sc = new Scanner(System.in);
        Empleado emp;
        Empleados bemp = new Empleados();
        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••");
        System.out.println("○ Indica el nombre del empleado que desea ver");
        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••");
        String n = sc.nextLine();
        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••");
        emp = bemp.ReadNombre(n);
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("|%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s |%-15s|%n", "NºEmpleado", "Apellido", "Oficio", "Direccion", "Fecha Alta", "Salario", "Comision", "NºDepartamento");
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("|%-15d |%-15s |%-15s |%-15d |%-15s |%-15.2f |%-15.2f |%-15d|%n", emp.getNumeroEmpleado(), emp.getApellido(), emp.getOficio(), emp.getDireccion(), emp.getFechaAlta(), emp.getSalario(), emp.getComision(), emp.getNumeroDepartamento());
        System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••");
    }//fin EmpleadoPorNombre

    /**
     * Crea un nuevo empleado
     *
     * @throws SQLException
     * @throws ParseException
     */
    public void CrearEmpleado() throws SQLException, ParseException {
        //SimpleDateFormat sdf = new SimpleDateFormat ("YYYY-MM-DD");
        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••");
        Scanner sc = new Scanner(System.in);
        Empleado emp = new Empleado(0, null, null, 0, null, -1, -1, 0);
        Empleados bemp = new Empleados();
        boolean seguir = true;
        while (seguir) {
            try {
                while (emp.getNumeroEmpleado() <= 0) {
                    System.out.println("+----------------------------------------");
                    System.out.print("|NºEmpleado: ");
                    emp.setNumeroEmpleado(sc.nextInt());
                    sc.nextLine();
                    if (emp.getNumeroEmpleado() <= 0) {
                        System.out.println("○ El NºEmpleado debe ser mayor a 0");
                    }
                }
                while (emp.getApellido() == null) {
                    System.out.println("+----------------------------------------");
                    System.out.print("|Apellido: ");
                    emp.setApellido(sc.nextLine());
                }
                while (emp.getOficio() == null) {
                    System.out.println("+----------------------------------------");
                    System.out.print("|Oficio: ");
                    emp.setOficio(sc.nextLine());
                }
                while (emp.getDireccion() <= 0) {
                    System.out.println("+----------------------------------------");
                    System.out.print("|Direccion: ");
                    emp.setDireccion(sc.nextInt());
                    sc.nextLine();
                    if (emp.getDireccion() <= 0) {
                        System.out.println("○ La direccion debe ser mayor que 0");
                    }
                }
                while (emp.getFechaAlta() == null) {
                    System.out.println("+----------------------------------------");
                    System.out.print("|Fecha Alta: ");
                    java.sql.Date jsd = java.sql.Date.valueOf(sc.nextLine());
                    //String s = sc.nextLine();
                    //java.util.Date parsed = sdf.parse(s);
                    //java.sql.Date sql = new java.sql.Date(parsed.getTime());
                    emp.setFechaAlta(jsd);
                }
                while (emp.getSalario() < 0) {
                    System.out.println("+----------------------------------------");
                    System.out.print("|Salario: ");
                    emp.setSalario(sc.nextFloat());
                    if (emp.getSalario() < 0) {
                        System.out.println("○ El salario no puede ser negativo");
                    }
                }
                while (emp.getComision() < 0) {
                    System.out.println("+----------------------------------------");
                    System.out.print("|Comision: ");
                    emp.setComision(sc.nextFloat());
                    if (emp.getComision() < 0) {
                        System.out.println("○ La comision no puede ser negativa");
                    }
                }
                while (emp.getNumeroDepartamento() <= 0) {
                    System.out.println("+----------------------------------------");
                    System.out.print("|NºDepartamento: ");
                    emp.setNumeroDepartamento(sc.nextInt());
                    if (emp.getNumeroDepartamento() <= 0) {
                        System.out.println("○ El NºDepartamento debe ser mayor a 0");
                    }
                }
                System.out.println("+----------------------------------------");
                System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••");
                seguir = false;
                System.out.println("○ Comando ejecutado, filas afectadas: " + bemp.Create(emp));
            } catch (InputMismatchException ex) {
                System.out.println("○ Ha introducido un valor erróneo, vuelvalo a intentar");
                seguir = true;
                sc.nextLine();
            } catch (IllegalArgumentException ex) {
                System.out.println("○ Ha introducido un valor erróneo, vuelvalo a intentar");
                seguir = true;
            }
        }//fin while
    }//fin CrearEmpleado

    /**
     * Crea un nuevo departamento
     *
     * @throws SQLException
     */
    public void CrearDepartamento() throws SQLException {
        System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••");
        Scanner sc = new Scanner(System.in);
        Departamento dep = new Departamento();
        Departamentos bdep = new Departamentos();
        boolean seguir = true;
        while (seguir) {
            try {
                while (dep.getNumeroDepartamento() <= 0) {
                    System.out.println("+----------------------------------------");
                    System.out.print("|NºDepartamento: ");
                    dep.setNumeroDepartamento(sc.nextInt());
                    if (dep.getNumeroDepartamento() <= 0) {
                        System.out.println("○ El NºDepartamento debe ser mayor a 0");
                    }
                }
                while (dep.getNombreDepartamento() == null) {
                    System.out.println("+----------------------------------------");
                    System.out.print("|NomDepartamento: ");
                    sc.nextLine();
                    dep.setNombreDepartamento(sc.nextLine());
                }
                while (dep.getLocalidad() == null) {
                    System.out.println("+----------------------------------------");
                    System.out.print("|Localidad: ");
                    dep.setLocalidad(sc.nextLine());
                }
                System.out.println("+----------------------------------------");
                System.out.println("•••••••••••••••••••••••••••••••••••••••••••••••");
                System.out.println("○ Comando ejecutado, filas afectadas: " + bdep.Create(dep));
                seguir = false;
            } catch (InputMismatchException ex) {
                System.out.println("○ Ha introducido un valor erróneo, vuelvalo a intentar");
                seguir = true;
                sc.nextLine();
            }
        }//fin while
    }//fin CrearDepartaento()

    /**
     * Borra un empleado existente
     *
     * @throws SQLException
     */
    public void BorrarEmpleado() throws SQLException {
        Scanner sc = new Scanner(System.in);
        Empleados bemp = new Empleados();
        System.out.println("◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘");
        System.out.println("¿Que empleado desea borrar? (Numero)");
        try {
            int n = sc.nextInt();
            System.out.println("○ Comando ejecutado, filas afectadas: " + bemp.Delete(n));
        } catch (InputMismatchException ex) {
            System.out.println("○ Ha introducido un valor erróneo, vuelvalo a intentar");
        }
    }//fin BorrarEmpleado()

    /**
     * Borra un departamento existente
     *
     * @throws SQLException
     */
    public void BorrarDepartamento() throws SQLException {
        Scanner sc = new Scanner(System.in);
        Departamentos bdep = new Departamentos();
        System.out.println("◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘◘");
        System.out.println("¿Que departamento desea borrar? (Numero)");
        try {
            int n = sc.nextInt();
            System.out.println("○ Comando ejecutado, filas afectadas: " + bdep.Delete(n));
        } catch (InputMismatchException ex) {
            System.out.println("○ Ha introducido un valor erróneo, vuelvalo a intentar");
        }
    }//fin BorrarDepartamento()

    public void CerrarConexion () {
        Departamentos bdep = new Departamentos();
        Empleados bemp = new Empleados();
        try {
            bdep.Close();
            bemp.Close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la BBDD: " + ex.getSQLState() + " " + ex.getMessage());
        }
    }//fin CerrarConexion
}//fin Listas()
