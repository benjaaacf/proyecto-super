/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.appsupermercado;

/**
 *
 * @author K
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventario {

    private Map<Producto, List<Proveedor>> proveedoresPorProducto;
    private Map<Proveedor, List<Producto>> productosPorProveedor;
    private Map<Integer, Proveedor> proveedoresPorId; // Mapa para buscar proveedores por ID

    public Inventario() {
        this.productosPorProveedor = new HashMap<>();
        this.proveedoresPorProducto = new HashMap<>();
        this.proveedoresPorId = new HashMap<>(); // Inicialización del mapa
    }

    // Agrega un producto a un proveedor y viceversa
    public void agregarProductoAProveedor(Producto producto, Proveedor proveedor) {
        proveedoresPorProducto.computeIfAbsent(producto, k -> new ArrayList<>()).add(proveedor);
        productosPorProveedor.computeIfAbsent(proveedor, k -> new ArrayList<>()).add(producto);

        // Asegurarse de que el proveedor está en el mapa de proveedoresPorId
        if (!proveedoresPorId.containsKey(proveedor.getId())) {
            proveedoresPorId.put(proveedor.getId(), proveedor);
        }
    }

    // Obtiene la lista de proveedores para un producto específico
    public List<Proveedor> obtenerProveedoresDeProducto(Producto producto) {
        return proveedoresPorProducto.getOrDefault(producto, new ArrayList<>());
    }

    // Obtiene la lista de productos ofrecidos por un proveedor específico
    public List<Producto> obtenerProductosDeProveedor(Proveedor proveedor) {
        return productosPorProveedor.getOrDefault(proveedor, new ArrayList<>());
    }

    // Obtiene todos los proveedores registrados en el inventario
    public List<Proveedor> obtenerTodosLosProveedores() {
        return new ArrayList<>(proveedoresPorId.values());
    }

    // Buscar un proveedor por su ID
    public Proveedor buscarProveedorPorId(int id) {
        return proveedoresPorId.get(id);
    }

    //Añadir un proveedor a la instancia de inventario
    public void añadirProveedor(Proveedor proveedor) {
        // Asegurarse de que el proveedor no sea nulo y que no esté ya presente en el inventario
        if (proveedor != null && !proveedoresPorId.containsKey(proveedor.getId())) {
            proveedoresPorId.put(proveedor.getId(), proveedor);
        }
    }

    //Metodo mostrar productos
    public void mostrarTodosLosProductos() {
        if (proveedoresPorProducto.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
            return;
        }

        System.out.println("Lista de todos los productos:");
        for (Producto producto : proveedoresPorProducto.keySet()) {
            System.out.println("Nombre: " + producto.getNombre() + ", Precio: $" + producto.getPrecio() + ", Codigo: " + producto.getCodigo() + ", Stock: " + producto.getStock());
        }
    }

    //Metodo para proveedores
    public void mostrarTodosLosProveedores() {
        if (proveedoresPorId.isEmpty()) {
            System.out.println("No hay proveedores en el inventario.");
            return;
        }

        System.out.println("Lista de todos los proveedores:");
        for (Proveedor proveedor : proveedoresPorId.values()) {
            System.out.println("ID: " + proveedor.getId() + ", Nombre: " + proveedor.getNombre() + ", Empresa: " + proveedor.getEmpresa() + ", Categoria: " + proveedor.getCategoria());
            // Si también quieres mostrar los productos que ofrece cada proveedor, puedes hacerlo aquí.
        }
    }

    //Buscar y mostrar todos los productos bajo de stock (actualmente -20)
    public void mostrarProductosBajosDeStock() {
        boolean hayProductosBajosDeStock = false;

        for (Producto producto : proveedoresPorProducto.keySet()) {
            if (producto.getStock() < 20) {
                hayProductosBajosDeStock = true;
                List<Proveedor> proveedores = obtenerProveedoresDeProducto(producto);
                System.out.println("Producto bajo de stock: " + producto.getNombre() + ", Stock actual: " + producto.getStock());
                System.out.println("Puede solicitar a los siguientes proveedores:");
                for (Proveedor proveedor : proveedores) {
                    System.out.println("- " + proveedor.getNombre() + " (Empresa: " + proveedor.getEmpresa() + ", Categoria: " + proveedor.getCategoria() + ")");
                }
                System.out.println(); // Agrega una línea en blanco para separar los productos.
            }
        }

        if (!hayProductosBajosDeStock) {
            System.out.println("Todos los productos tienen un stock suficiente.");
        }
    }

}
