
package clasessql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

public class Empleados {
    private Connection conexion;
    //private ArrayList<Empleado> empleados;

    /**
     * Al construir un empleado se realizara la conexion a la bbdd
     */
    public Empleados() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
        } catch (SQLException ex) {
            Logger.getLogger(Empleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * 
     * @param emp Se introduce un empleado
     * @return Devuelve el numero de filas que han sido afectadas
     * @throws SQLException 
     */
    public int Create (Empleado emp) throws SQLException{
        String sql = "INSERT INTO empleados VALUES(?,?,?,?,?,?,?,?)";
        int filas;
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, emp.getNumeroEmpleado());
        sentencia.setString(2, emp.getApellido());
        sentencia.setString(3, emp.getOficio());
        sentencia.setInt(4, emp.getDireccion());
        sentencia.setDate(5, emp.getFechaAlta());
        sentencia.setFloat(6, emp.getSalario());
        sentencia.setFloat(7, emp.getComision());
        sentencia.setInt(8, emp.getNumeroDepartamento());
        filas = sentencia.executeUpdate();
        return filas;
    }
     /**
      * 
      * @param emp_no Numero del empleado al que se actualizara su informacion
      * @param emp Empleado al cual se actualizara su informacion
      * @return Devuelve el numero de filas que han sido afectadas
      * @throws SQLException 
      */
    public int Update (int emp_no, Empleado emp) throws SQLException{
        String sql = "UPDATE empleados SET emp_no = ?, apellido = ?, oficio = ?, dir = ?, fecha_alt = ?, "
                + "salario = ?,comision = ?, dpt_no = ?  WHERE emp_no = ?;";
        int filas;
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, emp.getNumeroEmpleado());
        sentencia.setString(2, emp.getApellido());
        sentencia.setString(3, emp.getOficio());
        sentencia.setInt(4, emp.getDireccion());
        sentencia.setDate(5, emp.getFechaAlta());
        sentencia.setFloat(1, emp.getSalario());
        sentencia.setFloat(7, emp.getComision());
        sentencia.setInt(8, emp.getNumeroDepartamento());
        sentencia.setInt(9,emp_no);
        filas = sentencia.executeUpdate();
        return filas;
    }
    /**
     * 
     * @param emp_no Numero de empleado que se desea mostrar
     * @return devuelve el empleado a mostrar
     * @throws SQLException 
     */
    public Empleado Read (int emp_no) throws SQLException{
        Empleado emp;
        String sql = "SELECT * FROM empleados WHERE emp_no = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, emp_no);
        ResultSet rs = sentencia.executeQuery();
        rs.first();
        emp = new Empleado(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getFloat(6), rs.getFloat(7), rs.getInt(8));
        return emp;
    }
    /**
     * 
     * @return Devuelve un arraylist con los distintos empleados a mostrar
     * @throws SQLException 
     */
    public ArrayList<Empleado> ReadVarios() throws SQLException{
        Empleado emp;
        ArrayList<Empleado> bemps = new ArrayList<>();
        String sql = "SELECT * FROM empleados";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet rs = sentencia.executeQuery();
        
        while(rs.next()){
            emp = new Empleado(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getFloat(6), rs.getFloat(7), rs.getInt(8));
            bemps.add(emp);
        }
        return bemps;
    }
    /**
     * 
     * @param emp_nom Nombre del empleado que se quiere buscar
     * @return Devuelve dicho empleado
     * @throws SQLException 
     */
    public Empleado ReadNombre (String emp_nom) throws SQLException{
        Empleado emp;
        String sql = "SELECT * FROM empleados WHERE apellido = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, emp_nom);
        ResultSet rs = sentencia.executeQuery();
        rs.first();
        emp = new Empleado(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getDate(5), rs.getFloat(6), rs.getFloat(7), rs.getInt(8));
        return emp;
    }
    /**
     * 
     * @param emp_no Numero del empleado que se desea borrar
     * @return Devuelve el numero de filas afectadas
     * @throws SQLException 
     */
    public int Delete (int emp_no) throws SQLException{
        String sql = "DELETE FROM empleados WHERE emp_no=?";
        int filas;
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, emp_no);
        filas = sentencia.executeUpdate();
        return filas;
    }
    /**
     * Cierra la conexion con la base de datos
     * @throws SQLException 
     */
    public void Close() throws SQLException {
        conexion.close();
    }
    
}
