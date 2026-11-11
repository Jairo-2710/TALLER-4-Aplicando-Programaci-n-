public class Estudiante {
 
    private String codigo;
    private String nombre;
    private String apellido;
    private String programa;
    private CalificacionFinal calificacionFinal;

    public Estudiante(String codigo, String nombre, String apellido, String programa) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.programa = programa;
        this.calificacionFinal = null;  // hasta que se le asigne calificacion queda como null
 
    }
 
    // Getters
    public String getCodigo() {
        return codigo;
    }
 
    public String getNombre() {
        return nombre;
    }
 
    public String getApellido() {
        return apellido;
    }
 
    public String getPrograma() {
        return programa;
    }
 
    public CalificacionFinal getCalificacionFinal() {
        return calificacionFinal;
    }
 
    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
 
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
 
    public void setPrograma(String programa) {
        this.programa = programa;
    }
 
    public void setCalificacionFinal(CalificacionFinal calificacionFinal) {
        this.calificacionFinal = calificacionFinal;
    }
 
    // Mostrar información del estudiante
    public void mostrarInformacion() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Programa: " + programa);
    }
 
    // Actualizar la información
    public void actualizarInformacion(String nombre, String apellido, String programa) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.programa = programa;
    }
}
 
