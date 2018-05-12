
package clasessql;

public class Departamento {
    /**
     * Clase con las variables correspondientes y sus constructores, getters y setters
     */
     private int numeroDepartamento; //dept_no
     private String nombreDepartamento; //dnombre
     private String localidad; //loc

    public Departamento() {
    }

    public Departamento(int numeroDepartamento, String nombreDepartamento, String localidad) {
        this.numeroDepartamento = numeroDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.localidad = localidad;
    }

    public int getNumeroDepartamento() {
        return numeroDepartamento;
    }

    public void setNumeroDepartamento(int numeroDepartamento) {
        this.numeroDepartamento = numeroDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
     
}
