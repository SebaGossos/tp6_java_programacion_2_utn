package ej2;

import java.util.List;

public class MainEj2 {

    public static void main(String[] args) {
//        1) Creamos una biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca Municipal");
        
//        2) Crear al menos tres autores
        Autor autor1 = new Autor("1", "Seba", "Argentina");
        Autor autor2 = new Autor("2", "Nico", "Colombia");
        Autor autor3 = new Autor("3", "Pedro", "Chile");
        
//        3) Agregar 5 libros asociados a alguno de los Autores a la biblioteca
        biblioteca.agregarLibro("234is", "La bella cajera", 2023, autor1);
        biblioteca.agregarLibro("178xs", "Recorriendo el mundo", 2010, autor3);
        biblioteca.agregarLibro("430kl", "Barra Brava", 2020, autor2);
        biblioteca.agregarLibro("543of", "Barra Brava 2", 2023, autor2);
        biblioteca.agregarLibro("184ts", "Recorriendo el mundo 2", 2014, autor3);
        
        
//        4) Listar todos los libros con su información y la del autor.
//        List<Libro> libros = biblioteca.listarLibros();
//        libros.forEach( l -> System.out.println(l));

//        5) Buscar un libro por su ISBN y mostrar su información.
//        System.out.println(biblioteca.buscarLibroPorIsbn("178xs"));
        
//        6) Filtrar y mostrar los libros publicados en un año específico.
//        System.out.println(biblioteca.filtrarLibrosPorAnio(2023));
        

//        7) Eliminar un libro por su ISBN y listar los libros restantes.
//        List<Libro> libros = biblioteca.listarLibros();
//        libros.forEach( l -> System.out.println(l));
//        System.out.println("");
//        
//        biblioteca.eliminarLibro("430kl");
//        
//        libros = biblioteca.listarLibros();
//        libros.forEach( l -> System.out.println(l));

//        8) Mostrar la cantidad total de libros en la biblioteca
//        System.out.println(biblioteca.obtenerCantidadLibros());

//        9) Listar todos los autores de los libros disponibles en la biblioteca.
//            System.out.println(biblioteca.mostrarAutoresDisponibles());
    }
    
}