package ej2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Biblioteca {
    private final String nombre;
    private final List<Libro> libros;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList();
    }
    
    public void agregarLibro( String isbn, String titulo, int anioPublicacion, Autor autor ) {
        if( buscarLibroPorIsbn(isbn) != null ) {
            System.out.println("El libro ya ah sido agregado");
            return;
        }
        Libro libro = new Libro(isbn, titulo, anioPublicacion, autor );
        libros.add(libro);
    }
    
    
    public List<Libro> listarLibros(){
        return List.copyOf(libros);
    }

    public Libro buscarLibroPorIsbn( String isbn ){
        Libro libroBuscado = libros.stream()
            .filter(l -> l.getIsbn().equalsIgnoreCase(isbn))
            .findFirst()
            .orElse(null);
        if(libroBuscado == null ) System.out.println("No se encontro ningún libro"); 
        return libroBuscado;
    }
    
    public void eliminarLibro( String isbn ) {
        libros.remove(buscarLibroPorIsbn(isbn));
    }
    
    public int obtenerCantidadLibros(){
        return libros.size();
    }
    
    public List<Libro> filtrarLibrosPorAnio( int anio ) {
        return libros.stream()
                    .filter( l -> l.getAnioPublicacion() == anio )
                    .toList(); // toList convierte inmutable la Lista
    }
    
    public List<Autor> mostrarAutoresDisponibles() {
        Set<Autor> listaDeAutores = new HashSet(); // La estructura Set no permite duplicados y las operaciones son o(1) en promedio.
        
        for( Libro l : libros ) listaDeAutores.add(l.getAutor());
        
        return new ArrayList<>(listaDeAutores);
    }
    
}
