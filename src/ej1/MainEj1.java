package ej1;

import java.util.List;

public class MainEj1 {

    public static void main(String[] args) {
//        1) Crear al menos cinco productos con diferentes categorías y agregarlos al inventario.
        Producto prod1 = new Producto("1", "Queso Crema", 2.33, 24, CategoriaProducto.ALIMENTOS);
        Producto prod2 = new Producto("2", "Smart Tv 55", 1429.99, 5, CategoriaProducto.ELECTRONICA);
        Producto prod3 = new Producto("3", "Remera Nike", 19.99, 9, CategoriaProducto.ROPA);
        Producto prod4 = new Producto("4", "Silla Gamer", 2245.00, 3, CategoriaProducto.HOGAR);
        Producto prod5 = new Producto("5", "Samsung Pocket", 289.99, 7, CategoriaProducto.ELECTRONICA);
        
        Inventario inventario = new Inventario();
        
        inventario.agregarProducto(prod1);
        inventario.agregarProducto(prod2);
        inventario.agregarProducto(prod3);
        inventario.agregarProducto(prod4);
        inventario.agregarProducto(prod5);
        
//        2) Listar todos los productos mostrando su información y categoría
//        inventario.listarProductos();
        
//        3) Buscar un producto por ID y mostrar su información.
//        Producto prodPorId = inventario.buscarProductoPorId("3");
//        if( prodPorId != null ) prodPorId.mostrarInfo();

//        4) Filtrar y mostrar productos que pertenezcan a una categoría específica. 
//        List<Producto> productosPorCategoria = inventario.filtrarPorCategoria(CategoriaProducto.ELECTRONICA);
//        productosPorCategoria.forEach(p -> p.mostrarInfo());

//        5) Eliminar un producto por su ID y listar los productos restantes.
//        inventario.eliminarProducto("3");
////        Corroboramos la eliminacion
//        inventario.listarProductos();
    
//        6) Actualizar el stock de un producto existente
//        prod4.mostrarInfo();
//        inventario.actualizarStock("4", 6);
//        prod4.mostrarInfo();

//        7) Mostrar el total de stock disponible
//        System.out.println("El total de stock es: " + inventario.obtenerTotalStock());

//        8) Obtener y mostrar el producto con mayor stock
        Producto prodConMasStock = inventario.obtenerProductoConMayorStock();
        prodConMasStock.mostrarInfo();
//        paso 2
        Producto prodConMasStock2 = Inventario.obtenerProductoConMayorStock(inventario.getProductos());
        prodConMasStock2.mostrarInfo();
        
//        9) Filtrar productos con precios entre $1000 y $3000
//        List<Producto> prodPorPrecio = inventario.filtrarProductosPorPrecio(1000, 3000);
//        if(prodPorPrecio.size() == 0 ) System.out.println("No hay productos entre esos precios");;
//        prodPorPrecio.forEach( p -> p.mostrarInfo()); 

//        10) Mostrar las categorías disponibles con sus descripciones
//        inventario.mostrarCategoriasDisponibles();
        

    }
    
}
