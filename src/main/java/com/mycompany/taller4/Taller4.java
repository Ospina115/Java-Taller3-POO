/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.taller4;
import model.Articulo;
import javax.swing.JOptionPane;

/**
 *
 * @author aula9
 */
public class Taller4 {

    public static void main(String[] args) {
        String tipo, forma;
        double precio;
        
        boolean continuar = true;
        int i=0;
        while(continuar){
            JOptionPane.showMessageDialog(null, "Articulo #"+(i+=1));
            do{
                tipo = JOptionPane.showInputDialog("Digite C para camisetas o Z para zapatos").toUpperCase();
            }while(!tipo.equals("C")&& !tipo.equals("Z"));
            
            do{
                precio = Double.parseDouble(JOptionPane.showInputDialog("dijite el precio inicial"));
            }while(precio<=0);
            
            do{
                forma = JOptionPane.showInputDialog("Dijite E para efectivo o T para tarjeta").toUpperCase();
            }while (!forma.equals("E") && !forma.equals("T"));
            
            
            Articulo articulo = new Articulo(tipo,precio);
            
            double vlrPagar=0;
            if (tipo.equals("C")){
                String talla;
                do{
                    talla = JOptionPane.showInputDialog("talla S, M o L").toUpperCase();
                } while(!talla.equals("S") && !talla.equals("M") && !talla.equals("L"));
                vlrPagar = articulo.valorCompra(talla);
            } else if (tipo.equals("Z")){
                float talla;
                do{
                    talla = Float.parseFloat(JOptionPane.showInputDialog("Talla 9.5, 10.5 u 11.5"));
                }while (talla != 9.5 && talla != 10.5 && talla != 11.5);
                vlrPagar = articulo.valorCompra(talla);
            }
            
            double dcto1 = articulo.valorDescuento(forma, vlrPagar);
            double dcto2 = articulo.valorDescuento(vlrPagar);
            articulo.factura(vlrPagar, (dcto1 + dcto2));
            
            String SN;
            do{
                SN = JOptionPane.showInputDialog("Desea continuar? S/N").toUpperCase();
            }while (!SN.equals("S") && !SN.equals("N"));
        }
    }
}
