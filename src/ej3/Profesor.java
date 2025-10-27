package ej3;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
    private final String id;
    private final String nombre;
    private String especialidad;
    private List<Curso> cursos;

    public Profesor(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.cursos = new ArrayList();
    }
    
    public void agregarCurso( Curso c ) {
        if( c == null ) throw new IllegalArgumentException("El curso no puede ser nulo");
        if(  cursos.contains(c) ) {
            System.out.println("El Curso ya ha sido registrado");
            return;
        }
        cursos.add(c);
//        Si el curso tiene un profe distinto a este lo asociamos bidireccionalmente a este profe.
        if( c.getProfesor() != this ) {
            c.setProfesor(this);
        }
    }
    
    public void eliminarCurso( Curso c ) {
//        checkear que el curso exista en la collection
        if( c != null && cursos.contains(c) ) {
            cursos.remove(c);
        }
//        si eliminamos el curso del profesor, tenemos que eliminar el profesor del curso.
        if( c.getProfesor() == this ){ 
            c.setProfesor(null);
        }
    }
    
    public void eliminarCursos( List<Curso> cursosAEliminar ) { for( Curso c : List.copyOf(cursosAEliminar) ) eliminarCurso(c); }
    
    public List<Curso> listarCursos() { return List.copyOf(cursos); }
    
    public void mostrarInfo() {
        System.out.println("Profesor{" + "id=" + id + ", nombre=" + nombre + ", especialidad=" + especialidad + ", cursos=" + cursos + '}');
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public List<Curso> getCursos() {
        return List.copyOf(cursos);
    }

    @Override
    public String toString() {
        return "Profesor{" +
               "id=" + id +
               ", nombre=" + nombre +
               ", especialidad=" + especialidad +
               ", cursos=" +
               ((cursos != null && !cursos.isEmpty())
                   ? cursos.stream()
                            .map(Curso::getNombre)
                            .toList()
                   : "sin cursos") +
               '}';
    }


    
}
