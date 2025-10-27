package ej3;

public class Curso {
    private final String codigo;
    private String nombre;
    private Profesor profesor;

    public Curso(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    // Metodos publicos
    public void mostrarInfo(){ System.out.println("Curso{" + "codigo=" + 
            codigo + ", nombre=" + nombre + ", profesor=" + 
            profesor.getNombre() + " con el id: " + profesor.getId() + '}'); }

    public void setProfesor(Profesor profesor) {
//      Si es el mismo profesor no hacer nada
        if( this.profesor == profesor ) return;
        
//      Si hay un profesor de este curso eliminarlo para agregar el nuevo profesor.
        if( this.profesor != null ) {
            Profesor profesorAnterior = this.profesor;
            this.profesor = null;
            profesorAnterior.eliminarCurso(this);
        }
        
//      Establecer un nuevo profesor o eliminarlo
        this.profesor = profesor;
        
//      Añadir al nuevo curso en Profesor( sino es nulo y si no lo contiene)
        if( profesor != null && !profesor.getCursos().contains(this) ) {
            profesor.agregarCurso(this);
        }
        
    }    

    public Profesor getProfesor() {
        return profesor;
    }

    
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Curso{" + "codigo=" + codigo + ", nombre=" + nombre + ", profesor=" + ((profesor != null ) ? profesor.getNombre() + " con el id: " + profesor.getId() : " " ) + '}';
    }
    
}
