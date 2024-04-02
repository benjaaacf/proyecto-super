/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.appsupermercado;

/**
 *
 * @author K
 */
public class Producto {

    String nombre;
    int precio;
    int codigo; //Codigo de barras unico. Sirve para hashmap.
    int stock;  //Ver si es necesario acá o en inventario
    
    //Getter y Setter
    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getStock() {
        return stock;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Producto(String nombre, int precio, int codigo, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.codigo = codigo;
        this.stock = stock;
    }

}
