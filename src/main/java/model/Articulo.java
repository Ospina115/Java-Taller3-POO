/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import static java.lang.Math.round;
import javax.swing.JOptionPane;

/**
 *
 * @author aula9
 */
public class Articulo {
    String tipo;
    double precio;

    public Articulo(String tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }
    
    public double valorCompra (float talla){
        if (talla == 10.5){return precio -1.15;}
        else if (talla == 11.5){return precio *1.2;}
        else {return precio;}
    }
    
    public double valorCompra (String talla){
        return switch (talla) {
            case "s" -> precio;
            case "m" -> precio*1.05;
            default -> precio*1.07;
        };
    }
    
    public double valorDescuento (String forma, double vlrpagar){
        switch (forma){
            case "E" -> {
                return vlrpagar*0.1;
            }
            case "T" -> {
                return 0;
            }
        }
        return 0;
    }
    
    public double valorDescuento (double vlrpagar){
        if(vlrpagar>=80000 && vlrpagar<=120000){
            return vlrpagar*0.05;
        } else if(vlrpagar>120000){
            return vlrpagar*0.08;
        } return 0;
    }
    
    public void factura (double valorcompra, double valorDescuento){
        JOptionPane.showConfirmDialog(null, "Valor compra " + round(valorcompra) + 
                                                        " \nvalor descuento "+ round(valorDescuento) +
                                                        " \nvalor pagar" + (valorcompra + valorDescuento), tipo, 0);
    }
}
