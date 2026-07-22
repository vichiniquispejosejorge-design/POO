
package archivosobjetos;

import java.io.Serializable;

public class TarjetaCliente implements Serializable{
   private int nrotarjeta,nrocuenta;
   private double saldo;
   private String estado;
   
  public void mostrartarjeta(){
      System.out.println("nro.tarjeta"+this.nrotarjeta);
       System.out.println("nro.cuenta"+this.nrocuenta);
       System.out.println("slado"+this.saldo);
       System.out.println("estado"+this.estado);
  }
  

    public int getNrotarjeta() {
        return nrotarjeta;
    }

    public void setNrotarjeta(int nrotarjeta) {
        this.nrotarjeta = nrotarjeta;
    }

    public int getNrocuenta() {
        return nrocuenta;
    }

    public void setNrocuenta(int nrocuenta) {
        this.nrocuenta = nrocuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
   
  
}
