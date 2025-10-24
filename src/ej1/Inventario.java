package ej1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Inventario {
    private final ArrayList<Producto> productos;

    public Inventario() {
        this.productos = new ArrayList();
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }
    
    
    
    public void agregarProducto( Producto p ){
        productos.add(p);
    }
    
    public void listarProductos() {
        if( productos.isEmpty() ) {
            System.out.println("No hay productos");
        } else {
//            metodo por referencia, utilizamos la referencia directa al metodo que queremos ejecutar
            productos.forEach(Producto::mostrarInfo);
        }
    }
    
    public Producto buscarProductoPorId( String id ) {
        Producto prod = productos.stream()
                .filter(p -> p.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
        if( prod == null) System.out.println("No se encontro ningún producto con el id " + id );
        return prod; 
    }
 
    public boolean eliminarProducto( String id ) {
        Producto prodToDelete = buscarProductoPorId(id);
        if( prodToDelete == null ) return false;
        
        productos.remove(prodToDelete);
        System.out.println("Producto eliminado " + id);
        
        return true;
    }
    
    public boolean actualizarStock( String id, int nuevaCantidad ){
        Producto prodToupdate = buscarProductoPorId(id);
        if( prodToupdate == null ) {
            System.out.println("Producto no encontrado");
            return false;
        }
        
        prodToupdate.setCantidad(nuevaCantidad);
        System.out.println("Stock Actualizado para " + prodToupdate.getNombre() );
        return true;
    }
    
//    Ulizamos List para hacerlo mas adaptable al tipo de lista por upcasting
    public List<Producto> filtrarPorCategoria( CategoriaProducto categoria ) {
        
        return productos.stream()
                        .filter(p -> p.getCategoria() == categoria)
                        .collect(Collectors.toList());
                        
    }
    
    public int obtenerTotalStock(){
        // metodo por referencia para que lo ejecute el stream()
        return productos.stream()
                        .mapToInt(Producto::getCantidad)
                        .sum();
    }
    
    public Producto obtenerProductoConMayorStock(){ return obtenerProductoConMayorStock(productos); };
//    Sobrecarga de metodo y metodo estatico para usarlo desde la clase directamente sin tener que instanciarla
    public static Producto obtenerProductoConMayorStock( List<Producto> prodToFilter ) {
        Producto prodConMasStock = null;
        int contador = 0;
        for( Producto p : prodToFilter ) {
            if(contador == 0 || p.getCantidad() > prodConMasStock.getCantidad() ) {
                prodConMasStock = p;
            }
            contador++;
        }
        return prodConMasStock;
    }
    
    public List<Producto> filtrarProductosPorPrecio( double min, double max ) {
        return productos.stream()
                        .filter(p -> p.getPrecio() >= min && p.getPrecio() <= max )
                        .collect(Collectors.toList());
    }
    
    public void mostrarCategoriasDisponibles(){
        for( CategoriaProducto c : CategoriaProducto.values()) {
            System.out.println(c + ": " + c.getDescripcion());
        }
    }
}


