public class CalificacionFinal {
 
    private int idCalificacion;
    private double notaFinal;
 
    // Constructor 
    public CalificacionFinal(int idCalificacion, double notaFinal) {
        this.idCalificacion = idCalificacion;
        this.notaFinal = notaFinal;
    }
 
    // Getters
    public int getIdCalificacion() {
        return idCalificacion;
    }
 
    public double getNotaFinal() {
        return notaFinal;
    }
 
    // Setters
    public void setIdCalificacion(int idCalificacion) {
        this.idCalificacion = idCalificacion;
    }
 
    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

 
    // Mostrar información de la calificación
    public void mostrarInformacion() {
        System.out.println("ID calificación: " + idCalificacion);
        System.out.println("Nota final: " + notaFinal);
    }
}
 
