
package archivosobjetos;

import java.io.Serializable;


public class Cliente implements Serializable{
    private String NombreCompleto,Nrcedula;
    private TarjetaCliente tarjeta;
    //metodo
     public void mostrarcliente(){
      System.out.println("nombre"+this.NombreCompleto);
       System.out.println("nro.cedula"+this.Nrcedula);
         if (tarjeta!=null) {
             System.out.println("datos de la tarjeta de debito");
             tarjeta.mostrartarjeta();
         }else{
             System.out.println("el cliente no tiene agregado en la tarjeta de debito");
             
         }
  }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public String getNrcedula() {
        return Nrcedula;
    }

    public void setNrcedula(String Nrcedula) {
        this.Nrcedula = Nrcedula;
    }

    public TarjetaCliente getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaCliente tarjeta) {
        this.tarjeta = tarjeta;
    }

   
    
    
}
