package clasessql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Departamentos {

    private Connection conexion;
    //private ArrayList<Departamento> departamentos;

    /**
     * Al construir un departamento se realizara la conexion a la bbdd
     */
    public Departamentos() { //Contructor: Crea una conexion al MySQL. Al crear un nuevo objeto se conectará a la BBDD.
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
        } catch (SQLException ex) {
            Logger.getLogger(Departamentos.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error al acceder a la BBDD " + ex.getMessage());
        }
    }

    /**
     *
     * @param dep Departamento que se desea añadir a la base de datos
     * @return Devuelve el numero de filas afectadas
     * @throws SQLException
     */
    public int Create(Departamento dep) throws SQLException {
        String sql = "INSERT INTO departamentos VALUES (?, ?, ?);";
        int filas;
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, dep.getNumeroDepartamento());
        sentencia.setString(2, dep.getNombreDepartamento());
        sentencia.setString(3, dep.getLocalidad());
        filas = sentencia.executeUpdate();
        return filas;
    }

    /**
     *
     * @param dep_no Numero del departamento al que se actualizara su
     * informacion
     * @param dep Departamento al cual se actualizara su informacion
     * @return Devuelve el numero de filas que han sido afectadas
     * @throws SQLException
     */
    public int Update(int dep_no, Departamento dep) throws SQLException {
        String sql = "UPDATE departamentos SET dnombre =  ?, loc = ? WHERE dept_no = ?;";
        int filas;
        PreparedStatement sentencia = conexion.prepareCall(sql);
        sentencia.setString(1, "PEPE");
        sentencia.setString(2, "BENAMENTE");
        sentencia.setInt(3, dep_no);
        filas = sentencia.executeUpdate();
        return filas;
    }

    /**
     *
     * @param dep_no Numero de departamento que se desea mostrar
     * @return devuelve el departamento a mostrar
     * @throws SQLException
     */
    public Departamento Read(int dep_no) throws SQLException {
        Departamento dep;
        String sql = "SELECT * FROM departamentos WHERE dept_no = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, dep_no);
        ResultSet rs = sentencia.executeQuery();
        rs.first();
        dep = new Departamento(rs.getInt(1), rs.getString(2), rs.getString(3));
        return dep;
    }

    /**
     *
     * @return Devuelve un arraylist con los departamentos a mostrar
     * @throws SQLException
     */
    public ArrayList<Departamento> ReadVarios() throws SQLException {
        Departamento dep;
        ArrayList<Departamento> deps = new ArrayList<>();
        String sql = "SELECT * FROM departamentos";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet rs = sentencia.executeQuery();

        while (rs.next()) {
            dep = new Departamento(rs.getInt(1), rs.getString(2), rs.getString(3));
            deps.add(dep);
        }
        return deps;
    }

    /**
     *
     * @param dep_nom Nombre del departamento que se quiere buscar
     * @return Devuelve dicho departamento
     * @throws SQLException
     */
    public Departamento ReadNombre(String dep_nom) throws SQLException {
        Departamento dep;
        String sql = "SELECT * FROM departamentos WHERE dnombre=?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, dep_nom);
        ResultSet rs = sentencia.executeQuery();
        rs.first();
        dep = new Departamento(rs.getInt(1), rs.getString(2), rs.getString(3));
        return dep;
    }

    /**
     *
     * @param dep Numero del departamento que se desea borrar
     * @return Devuelve el numero de filas afectadas
     * @throws SQLException
     */
    public int Delete(int dep) throws SQLException {
        String sql = "DELETE FROM departamentos WHERE dept_no=?";
        int filas;
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, dep);
        filas = sentencia.executeUpdate();
        return filas;
    }

    /**
     * Cierra la conexion con la base de datos
     *
     * @throws SQLException
     */
    public void Close() throws SQLException {
        conexion.close();
    }
}
