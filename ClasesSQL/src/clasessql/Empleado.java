
package clasessql;
//CRUDO -> CREATE  READ  UPDATE  DELETE
import java.sql.Date;

public class Empleado {
    /**
     * Clase con las variables correspondientes y sus constructores, getters y setters
     */
    private int numeroEmpleado; //emp_no
    private String apellido; //apellido
    private String oficio; //oficio
    private int direccion; //dir
    private Date fechaAlta; //fecha_alt
    private float salario; //salario
    private float comision; //comision
    private int numeroDepartamento; //dept_no

    public Empleado() {
        
    }

    public Empleado(int numeroEmpleado, String apellido, String oficio, int direccion, Date fechaAlta, float salario, float comision, int numeroDepartamento) {
        this.numeroEmpleado = numeroEmpleado;
        this.apellido = apellido;
        this.oficio = oficio;
        this.direccion = direccion;
        this.fechaAlta = fechaAlta;
        this.salario = salario;
        this.comision = comision;
        this.numeroDepartamento = numeroDepartamento;
    }

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public int getNumeroDepartamento() {
        return numeroDepartamento;
    }

    public void setNumeroDepartamento(int numeroDepartamento) {
        this.numeroDepartamento = numeroDepartamento;
    }
    
}
