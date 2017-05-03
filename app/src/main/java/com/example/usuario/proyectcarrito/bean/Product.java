package com.example.usuario.proyectcarrito.bean;

/**
 * Created by Usuario on 02/05/2017.
 */

public class Product {

    private Long ProductId;
    private String Descripcion;
    private String Cantidad;
    private Double Precio;
    private Double Total;

    public Product(Long productId, String descripcion, String cantidad, Double precio, Double total) {
        ProductId = productId;
        Descripcion = descripcion;
        Cantidad = cantidad;
        Precio = precio;
        Total = total;
    }

    public Product() {

    }

    public Long getProductId() {
        return ProductId;
    }

    public void setProductId(Long productId) {
        ProductId = productId;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String cantidad) {
        Cantidad = cantidad;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double precio) {
        Precio = precio;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }


    @Override
    public String toString() {
        return Descripcion + " " + Cantidad +" " + Precio ;
    }


}
