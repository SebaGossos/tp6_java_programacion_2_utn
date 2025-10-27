package ej3;

import java.util.List;

public class MainEj3 {

    public static void main(String[] args) {
    //    1. Crear al menos 3 profesores y 5 cursos.
        Profesor profesor1 = new Profesor("1", "Seba", "Programación");
        Profesor profesor2 = new Profesor("2", "Pedro", "Base de datos");
        Profesor profesor3 = new Profesor("3", "Juan", "Probabilidad y estadísticas");

        Curso curso1 = new Curso("1", "primero");
        Curso curso2 = new Curso("2", "segundo");
        Curso curso3 = new Curso("3", "tercero");
        Curso curso4 = new Curso("4", "cuarto");
        Curso curso5 = new Curso("5", "quinto");

    //    2. Agregar profesores y cursos a la universidad.
        Universidad universidad = new Universidad("UTN");

        universidad.agregarProfesor(profesor1);
        universidad.agregarProfesor(profesor2);
        universidad.agregarProfesor(profesor3);

        universidad.agregarCurso(curso1);
        universidad.agregarCurso(curso2);
        universidad.agregarCurso(curso3);
        universidad.agregarCurso(curso4);
        universidad.agregarCurso(curso5);

    //    3. Asignar profesores a cursos usando asignarProfesorACurso(...).
        universidad.asignarProfesorACurso("1", "2");
        universidad.asignarProfesorACurso("3", "3");
        universidad.asignarProfesorACurso("2", "1");
        universidad.asignarProfesorACurso("4", "2");
        universidad.asignarProfesorACurso("5", "1");

    //    4. Listar cursos con su profesor y profesores con sus cursos.
        System.out.println(universidad.listarProfesores());
        System.out.println(universidad.listarCursos());


    //    5. Cambiar el profesor de un curso y verificar que ambos lados quedan sincronizados.
        universidad.asignarProfesorACurso("4", "3");
        System.out.println(universidad.listarProfesores());
        System.out.println(universidad.listarCursos());


    //    6. Remover un curso y confirmar que ya no aparece en la lista del profesor.
        universidad.eliminarCursoPorCodigo("3");
        System.out.println(universidad.listarProfesores());

    //    7. Remover un profesor y dejar profesor = null.
        universidad.eliminarProfesorPorId("2");
        System.out.println(universidad.listarProfesores());
        System.out.println(universidad.listarCursos());


    //    8. Mostrar un reporte: cantidad de cursos por profesor.
        List<Profesor> profesores = universidad.listarProfesores();
        profesores.forEach(p -> System.out.println("El profesor " + p.getNombre() + " tiene una cantidad de " + p.getCursos().size() + " cursos."));

    }
    
}
