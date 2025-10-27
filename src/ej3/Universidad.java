package ej3;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Universidad {
    private String nombre;
    private List<Profesor> profesores;
    private List<Curso> cursos;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList();
        this.cursos = new ArrayList();
    }
//    Asociacion unidireccional
    public void agregarProfesor( Profesor p ) {
        if( p != null && profesores.contains(p) ) {
            System.out.println("El profesor ya ha sido registrado");
            return;
        }
        profesores.add(p);
    }
    
    public void agregarCurso( Curso c ) {
        if( c != null && cursos.contains(c) ) {
            System.out.println("El Curso ya ha sido registrado");
            return;
        }
        cursos.add(c);
    }
    
    public void asignarProfesorACurso( String codigoCurso, String idProfesor ) {
//        Trabajamos con Optional para hacerlo mas profesional en caso de devolver null
        Optional<Curso> cursoParaAsig = buscarCursoPorCodigo(codigoCurso);
        Optional<Profesor> profesorParaAsig = buscarProfesorPorId(idProfesor);
        
        cursoParaAsig.ifPresent(curso -> {
            curso.setProfesor(profesorParaAsig.get());
        });
    }

    
    public List<Profesor> listarProfesores() {
        return List.copyOf(profesores);
    }
    
    public List<Curso> listarCursos() {
        return List.copyOf(cursos);
    }
    
    public Optional<Profesor> buscarProfesorPorId( String id ) {
        return profesores.stream()
                .filter(p -> p.getId().equalsIgnoreCase(id) )
                .findFirst();
    }
    
    public Optional<Curso> buscarCursoPorCodigo( String codigo ) {
        return cursos.stream()
                .filter(c -> c.getCodigo().equalsIgnoreCase(codigo))
                .findFirst();
    }
    
    public void eliminarCursoPorCodigo( String codigo ) {
        Optional<Curso> cursoPorEliminar = buscarCursoPorCodigo(codigo);
        
        if( cursoPorEliminar.isPresent() ){
            Curso cursoActual = cursoPorEliminar.get();
            Profesor profesorDelCurso = cursoActual.getProfesor();
            
            if( profesorDelCurso != null ) {
                profesorDelCurso.eliminarCurso(cursoPorEliminar.get());
            }
        }
        cursos.remove(cursoPorEliminar.get());
    }
    
    public void eliminarProfesorPorId ( String id ) {
        Optional<Profesor> profesorPorEliminar = buscarProfesorPorId(id);
        
        profesorPorEliminar.ifPresent( profesor -> {
            
//            Eliminamos de profesor los cursos
            List<Curso> cursos = profesor.getCursos();
            
            if(!cursos.isEmpty()){
                profesor.eliminarCursos(cursos);
            }
            
//            Eliminamos profesor de la universisad
            profesores.remove(profesor);
        });
    }
    
}