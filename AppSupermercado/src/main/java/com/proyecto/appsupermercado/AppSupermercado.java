/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.proyecto.appsupermercado;

/**
 *
 * @author K
 */
import java.util.Scanner;

public class AppSupermercado {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario inventario = new Inventario();
        int idProveedor;

        while (true) {
            //Primer menú
            System.out.println("Seleccione un menu de los siguientes:");
            System.out.println("1. Menu Ventas.");
            System.out.println("2. Menu Administracion (inventario).");
            System.out.println("0. Cerrar aplicacion.");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 0:
                    System.exit(0);
                case 1:
                    System.out.println("Menu de Ventas (No disponible - Próximamente)");
                    break;
                case 2:
                    System.out.println("Menu de administracion");
                    System.out.println("Seleccione una opcion:");
                    System.out.println("1. Añadir producto (Deben existir proveedores)");
                    System.out.println("2. Añadir proveedor");
                    System.out.println("3. Mostrar productos");
                    System.out.println("4. Mostrar proveedores");
                    System.out.println("5. Mostrar productos con stock bajo (<20)");
                    System.out.println("6. Realizar orden de compra (Proximamente disponible)");
                    System.out.println("9. Cargar Casos de Prueba");
                    System.out.println("0. Salir");

                    int opcion2 = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (opcion2) {
                        case 1:
                            System.out.println("Introduzca el nombre del producto:");
                            String nombreProducto = scanner.nextLine();
                            System.out.println("Introduzca el precio:");
                            int precio = scanner.nextInt();
                            System.out.println("Introduzca el codigo:");
                            int codigo = scanner.nextInt();
                            System.out.println("Introduzca el stock:");
                            int stock = scanner.nextInt();
                            scanner.nextLine(); // Consume newline left-over

                            Producto producto = new Producto(nombreProducto, precio, codigo, stock);
                            System.out.println("Producto añadido con exito.");
                            System.out.println("Introduzca el ID del proveedor para este producto:");
                            idProveedor = scanner.nextInt();
                            scanner.nextLine(); // Consume newline left-over

                            // Asegúrate de tener una instancia de Inventario llamada inventario
                            Proveedor proveedorAsociado = inventario.buscarProveedorPorId(idProveedor);
                            if (proveedorAsociado != null) {
                                inventario.agregarProductoAProveedor(producto, proveedorAsociado);
                                System.out.println("Producto añadido al proveedor con exito.");
                            } else {
                                System.out.println("Proveedor no encontrado. Asegurate de añadir el proveedor antes de asociarlo con productos.");
                            }
                            break;

                        case 2:
                            System.out.println("Introduzca el nombre del proveedor:");
                            String nombreProveedor = scanner.nextLine();
                            System.out.println("Introduzca el nombre de la empresa:");
                            String empresa = scanner.nextLine();
                            System.out.println("Introduzca la categoria del proveedor:");
                            String categoria = scanner.nextLine();
                            System.out.println("Introduzca el ID del proveedor:");
                            idProveedor = scanner.nextInt();
                            scanner.nextLine(); // Consume newline left-over

                            Proveedor nuevoProveedor = new Proveedor(nombreProveedor, empresa, categoria, idProveedor);
                            // Asumiendo que tienes un método en tu clase Inventario para añadir proveedores.
                            // Como ejemplo, voy a utilizar un método ficticio llamado "añadirProveedor".
                            inventario.añadirProveedor(nuevoProveedor);

                            System.out.println("Proveedor añadido con exito.");
                            break;

                        case 3:
                            System.out.println("Productos disponibles:");
                            inventario.mostrarTodosLosProductos();
                            break;
                        case 4:
                            System.out.println("Proovedores registrados:");
                            inventario.mostrarTodosLosProveedores();
                            break;

                        case 5:
                            inventario.mostrarProductosBajosDeStock();
                            break;

                        case 6:
                            break;
                        case 9:
                            añadirDatosDePrueba(inventario);
                            break;

                        case 0:
                            System.out.println("Saliendo...");
                            System.exit(0);
                        default:
                            System.out.println("Opcion no valida. Por favor, intente de nuevo.");
                            break;
                    }
            }
        }

    }

    private static void añadirDatosDePrueba(Inventario inventario) {
        // Crear algunos productos
        Producto producto1 = new Producto("Leche", 990, 1001, 50);
        Producto producto2 = new Producto("Cereal mono", 1950, 1002, 30);
        Producto producto3 = new Producto("Limpia pisos", 2480, 1003, 20);
        Producto producto4 = new Producto("Gaseosa kem", 2300, 1004, 12);
        Producto producto5 = new Producto("Choclo", 1290, 1005, 18);

        // Crear algunos proveedores
        Proveedor proveedor1 = new Proveedor("Juan", "Colun", "Lacteos", 1);
        Proveedor proveedor2 = new Proveedor("Melisa", "Costa", "Cereales", 2);
        Proveedor proveedor3 = new Proveedor("Pedro", "Virutex", "Productos de aseo", 3);
        Proveedor proveedor4 = new Proveedor("Isabela", "CCU", "Gaseosas", 4);
        Proveedor proveedor5 = new Proveedor("Maicol", "Minuto Verde", "Congelados", 5);

        // Añadir productos a proveedores (y viceversa) en el inventario
        inventario.agregarProductoAProveedor(producto1, proveedor1);
        inventario.agregarProductoAProveedor(producto2, proveedor2);
        inventario.agregarProductoAProveedor(producto3, proveedor3);
        inventario.agregarProductoAProveedor(producto4, proveedor4);
        inventario.agregarProductoAProveedor(producto5, proveedor5);

        System.out.println("Datos de prueba añadidos al inventario.");
    }
}
