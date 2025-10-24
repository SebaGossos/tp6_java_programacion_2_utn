package ej3;

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
    }
    
    public void agregarCurso( Curso c ) {
        
    }
    
    public void eliminarCurso( Curso c ) {
        
    }
    
    public void listarCursos() {
        
    }
    
    public void mostrarInfo() {
        
    }

    public void setCursos(List<Curso> cursos) {
        //TODO:
        this.cursos = cursos;
    }
    
    
    
    
}
