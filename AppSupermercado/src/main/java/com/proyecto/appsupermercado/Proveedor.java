/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.appsupermercado;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author K
 */
public class Proveedor {

    String nombre;
    String empresa;
    String categoria;
    int id;
    List<Producto> productos = new ArrayList<>();   //Lista productos 

    // Metodos
    
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    //Getter y Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    //Constructor
    public Proveedor(String nombre, String empresa, String categoria, int id) {
        this.nombre = nombre;
        this.empresa = empresa;
        this.categoria = categoria;
        this.id = id;
    }

}
